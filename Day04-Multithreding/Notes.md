                Multithreding

1. Creating Threads - There are two primary low-level ways to create threads:
        Extending Thread: Overriding the run () method directly.
   Implementing Runnable: Decoupling the task from the thread execution (preferred over extending Thread).
-----------------------------------------------------------------------------------------------------------------

2. Thread Lifecycle & Control -A Java thread moves through distinct states:

    **New**:               Created but not yet started.
    
    **Runnable**:          Ready to run and waiting for CPU time allocation.
    
    **Blocked** / Waiting: Waiting for a lock or notification from another thread (wait (), join (), sleep ()).
    
    **Terminated**:         Execution complete.
--------------------------------------------------------------------------------------------------

3. Concurrency & Thread Safety : When multiple threads access shared mutable data,
   race conditions occur. Core synchronization tools include:

   synchronized Keyword: Guarantees mutual exclusion so only one thread executes a code block or method at a time.

   volatile Keyword: Ensures visibility of changes across threads by preventing CPU caching of variables.

   Atomic Classes (AtomicInteger, etc.): Lock-free thread-safe operations on single variables.

   Explicit Locks (ReentrantLock)(Manual Lock): Flexible locking with fairness policies and try-lock capabilities.
      it uses Lock interface - lock.lock(): for locking and lock.unlock(): for unlocking.
--------------------------------------------------------------------------------------------------------------
4. Modern Java Concurrency (java.util.concurrent)
   In production applications, manually managing raw Thread objects is discouraged. Instead, Java provides:

    ExecutorService: Thread pools to reuse threads and manage execution queues efficiently.

    Callable & Future: Tasks that return results or throw checked exceptions.

    CompletableFuture: Asynchronous, non-blocking pipeline operations.

    Concurrent Collections: High-performance thread-safe data structures like ConcurrentHashMap and BlockingQueue.