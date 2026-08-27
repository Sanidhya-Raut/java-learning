Concepts Learned
1. ConcurrentHashMap
ConcurrentHashMap is a thread-safe implementation of the Map interface.
It allows multiple threads to access the map concurrently without corrupting the map's internal state.
Example:
Map<Integer, AtomicInteger> accessCount = new ConcurrentHashMap<>();
However, it is important to understand that making the map thread-safe does not automatically make a sequence of multiple operations atomic.

2. Why ConcurrentHashMap<Integer, Integer> is not enough
The unsafe implementation used:
Integer empCount = accessCount.get(employeeId);
if (empCount == null) {
empCount = 0;
}
empCount += 1;
accessCount.put(employeeId, empCount);
At first glance, this looks correct.
However, multiple threads can execute these operations at the same time.

For example, suppose the current count is 100:
Thread A                  Thread B
get() → 100               get() → 100
↓                         ↓
+1 → 101                  +1 → 101
↓                         ↓
put(101)                  put(101)

Two accesses happened, but the final value is only 101.
The expected value is:
102
One update has been lost.
This is called a race condition and specifically a lost update.

3. Why ConcurrentHashMap alone does not solve the problem
ConcurrentHashMap makes individual operations such as:
get()
put()
thread-safe.
But the following sequence is not atomic:
get()
↓
modify
↓
put()

Another thread can execute between these operations.

Therefore:

A thread-safe collection does not necessarily make a compound operation thread-safe.

4. AtomicInteger

AtomicInteger provides thread-safe operations on an integer value.

Example:

AtomicInteger count = new AtomicInteger(0);

count.incrementAndGet();

incrementAndGet() atomically increments the value and returns the updated value.

Multiple threads can safely perform:

count.incrementAndGet();

without losing updates.

Internally, atomic classes such as AtomicInteger use CAS (Compare-And-Set) to perform atomic updates without requiring a traditional lock for these operations.

5. Thread-Safe Implementation

The safe implementation uses:

Map<Integer, AtomicInteger> accessCount =
new ConcurrentHashMap<>();

The access is recorded using:

accessCount
.computeIfAbsent(employeeId, key -> new AtomicInteger(0))
.incrementAndGet();
How it works
Employee ID
↓
computeIfAbsent()
↓
Find existing AtomicInteger
OR
Create AtomicInteger(0)
↓
incrementAndGet()

For example:

First access:
0 → 1

Second access:
1 → 2

Third access:
2 → 3

The increment operation is atomic, so concurrent updates are not lost.

6. Race Condition Experiment

Five tasks were executed using:

ExecutorService executorService =
Executors.newFixedThreadPool(5);

Each task performs:

2,000 accesses

Therefore:

5 tasks × 2,000 accesses
= 10,000 expected accesses

The tasks were distributed as:

Task 1 → Employee 1 → 2,000
Task 2 → Employee 2 → 2,000
Task 3 → Employee 3 → 2,000
Task 4 → Employee 1 → 2,000
Task 5 → Employee 2 → 2,000

Expected result:

Employee 1 → 4,000
Employee 2 → 4,000
Employee 3 → 2,000

Total → 10,000
7. Unsafe Implementation Result

Using:

Map<Integer, Integer>

with the following logic:

Integer empCount = accessCount.get(employeeId);
empCount += 1;
accessCount.put(employeeId, empCount);

produced:

Employee 1 → 2561
Employee 2 → 2394
Employee 3 → 2000

Total accesses → 6955

Expected:

10,000

Actual:

6,955

Lost updates:

10,000 - 6,955 = 3,045

The exact result can vary between executions because thread scheduling is not deterministic.

8. Why Employee 3 had exactly 2,000 accesses

Employee 3 was accessed by only one task:

Task 3 → Employee 3

Therefore, there was no competition between multiple threads for Employee 3's counter.

All 2,000 increments were preserved:

Employee 3 → 2,000

Employee 1 and Employee 2 were accessed by two tasks each:

Employee 1 → Task 1 + Task 4
Employee 2 → Task 2 + Task 5

Therefore, they experienced concurrent modifications and lost updates.

9. Safe vs Unsafe Implementation
   Feature	Unsafe Implementation	Safe Implementation
   Map	ConcurrentHashMap	ConcurrentHashMap
   Value	Integer	AtomicInteger
   Increment	get → modify → put	incrementAndGet()
   Compound operation	Not atomic	Atomic increment
   Race condition	Possible	Prevented for the counter update
   Expected total	10,000	10,000
   Observed result	6,955	10,000