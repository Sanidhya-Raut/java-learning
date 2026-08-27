10. Key Interview Questions
    Q1. Why did ConcurrentHashMap<Integer, Integer> still lose updates?

    ConcurrentHashMap makes individual operations such as get() and put() thread-safe. However, the complete get → modify → put sequence is not atomic. Multiple threads can read the same value and overwrite each other's updates, resulting in lost updates.

Q2. Why does AtomicInteger solve the increment problem?

    AtomicInteger provides atomic operations such as incrementAndGet(). The increment is performed as a single atomic operation, so multiple threads can safely update the same counter without losing increments.

    Internally, AtomicInteger uses CAS (Compare-And-Set) for these atomic updates.

Q3. Why did Employee 3 get exactly 2,000?

    Only one task was accessing Employee 3. Since no other thread was concurrently modifying its counter, there were no competing updates and all 2,000 increments were preserved.

Q4. What is a race condition?

    A race condition occurs when multiple threads access and modify shared mutable data concurrently, and the final result depends on the timing or ordering of those operations.

Q5. What is a lost update?

    A lost update occurs when two or more threads read the same old value, calculate new values independently, and then one thread overwrites another thread's update.

Example:

Initial value = 100

Thread A reads 100
Thread B reads 100

Thread A writes 101
Thread B writes 101

Expected = 102
Actual = 101

One update was lost.

11. Important Takeaways
    ConcurrentHashMap is useful for safely accessing a map from multiple threads.
    Thread-safe individual operations do not automatically make a sequence of operations atomic.
    Integer is immutable, so count += 1 creates a new value and does not provide atomic increment behavior.
    AtomicInteger provides atomic operations such as incrementAndGet().
    computeIfAbsent() can safely create a value when a key does not exist.
    ExecutorService allows multiple tasks to execute concurrently using a thread pool.
    Future.get() can be used to wait for submitted tasks to complete.
    Race conditions can cause lost updates when shared mutable state is not properly protected.
    Always think about whether an entire operation is thread-safe, not just whether the underlying collection is thread-safe.
    Final Learning

The most important lesson from Day 6:

Thread-safe components do not necessarily make a sequence of operations thread-safe.

For shared counters, an operation such as:

read → modify → write

must be made atomic or properly synchronized.

In this exercise, AtomicInteger.incrementAndGet() provides the required atomic update.