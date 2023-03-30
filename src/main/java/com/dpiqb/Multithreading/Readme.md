# Multithreading

---

## [`class DemoThread extends Thread {...}`](./Demo001ExtendsThread.java)

- `class DemoThread extends Thread`
- `@Override public void run() {...}`
- `new DemoThread().start()`

```java
public class Demo {
    public static void main(String[] args) {
        DemoThread demoThread = new DemoThread();
        demoThread1.start();
    }
}

class DemoThread extends Thread{
    @Override
    public void run() {
        System.out.println("Hello from Demo Thread");
    }
}
```

---

## [`class DemoRunnable implements Runnable {...}`](./Demo002ImplRunnable.java)

- `@FunctionalInterface Runnable {...}` hello lambdas
- `@Override public void run() {...}`
- `Thread thread = new Thread(new DemoRunnable());`

```java
public class DemoRunnable {
    public static void main(String[] args) {
        Thread thread = new Thread(new DemoRunnable());
        thread.start();
    }
}

class DemoRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello from Demo Runnable");
    }
}
```

---

## [`Lambdas`](./Demo002ImplRunnable.java)

- `@FunctionalInterface Runnable {...}` hello lambdas

```java
public class Demo {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("[Lambda Thread1] = " + i);
            }
        });
        thread.start();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("[Lambda Thread2] = " + i);
            }
        }).start();
    }
}
```

---

## Thread methods

### [set and get Name, set get Priority](./Demo003SetGetNamePriority.java)
### [sleep, set get State, join](./Demo004SleepJoin.java)

- Call from current thread example `Thread.currentThread().getName()`
- Call from instance example `new Thread().getName()`

- `thread.sleep(2000)` thread will sleep 2 sec
- `thread.getName();` default Thread-'N'
- `thread.setName("some Name");`
- `thread.getPriority();` from 1 to 10 (default 5)
- `thread.setPriority();`
    - `Thread.MAX_PRIORITY` - 10
    - `Thread.NORM_PRIORITY` - 5
    - `Thread.MIN_PRIORITY` - 1
- `thread.getState();`
- `thread.setState();`
    - `NEW`
    - `RUNNABLE`
      - `READY`
      - `RUNNING`
    - `TIMED_WAITING`
    - `BLOCKED`
    - `TERMINATED`
- `thread.join();` if call in `someThread`, `someThread` will wait for `thread`
- `thread.join(2000);` if call in `someThread`, `someThread` will wait for 2 sec

---

## [Volatile](./Demo005Volatile.java)

- it is good when only one thread change value all others are read

`volatile boolean flag = true;`

---

## Data race. Synchronized methods

1. [Example (`synchronized (lock){...}`)](./Demo006Call.java)
2. [Example (`synchronized` om method)](./Demo006DataRaceSynchronizedMethods.java)

- Synchronization is on the monitor
- Default `synchronized` by `this`
- Synchronization on `this`, `SomeClass.class`, `private static final Object lock = new Object();`
- Can not Synchronize Constructor

### Monitor. Synchronized block

- Every entity in Java has own monitor
- Monitor can be `busy` or `free`
- At same time the monitor can work with one thread
- With Synchronized block you can sync only part of logic

```java
class DemoRunnable implements Runnable{
    public synchronized void increment(){ // synchronized
        Counter.count++;
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            this.increment(); // potentially Data race here
        }
    }
}
```

### synchronized block in non-static method
3. [Example (lock on `this`)](./Demo006SyncBlockMonitor1.java)
```java
    public void increment(){
        // Some other not synchronized logic
        synchronized (this){ // I will use lock on `this` obj monitor
            Counter.count++;
        }
        // Some other not synchronized logic
    }
```
### synchronized block in static method
4. [Example (`synchronized` in static method)](./Demo006SyncBlockMonitor1.java)
```java
    public static synchronized void increment(){
        synchronized (SomeClass.class){
            counter++;
        }
    }
```

## [`wait()` `notify()`](Demo007WaitNotify.java)
- `wait([mills, nanos])` - releases the monitor
- use `wait()` in `while` loop not in `if`
- Use `synchronized`
- `Exception in thread "Thread-N" java.lang.IllegalMonitorStateException: current thread is not owner`
- in `synchronized` method `wait()` `notify()` same as `this.wait()` `this.notify()`
- in `synchronized block`
  - you can use `wait()` `notify()` or `this.wait()` `this.notify()`
  - you can use `static final Object lock = new Object();`
    - respectively use `lock.wait()` `lock.notify()`

## [Deadlock](./Demo008DeadLock.java)
- When you try to `synchronized` by few objects do it in the same order
- At a `deadlock`, the threads wait endlessly, they are not work

## LiveLock
- At a LiveLock, the threads work endlessly
 
## LockStarvation
- When lower priority threads are just waiting

## [`interface Lock`](./Demo009ATMLock.java)
- `Lock lock = new ReentrantLock()`
- `void lock()`
- `void unlock()`
- `void lockInterruptibly()`
- `boolean tryLock()` - will lock the thread if it is not locked
- `boolean tryLock(long time, TimeUnit unit)`
- `Condition newCondition()`

---

## [Daemon Threads](./Demo010DaemonThreads.java)
- before `.start()` call `.setDaemon(true)`
```java
SomeThread thread = new SomeThread();
thread.setDaemon(true);
thread.start();
```

---

## [Interrupt thread](./Demo011Interruption.java)
- thread.~~stop()~~; - DEPRECATED!
- use `thread.interrupt();` 
  - this methos is not interupt thred!
  - it sets flag `interrupted = true;` and you can use it in you thread

---

## ThreadPoolExecutor and Executor

- `public class ThreadPoolExecutor extends AbstractExecutorService { ... }`
  - `public abstract class AbstractExecutorService implements ExecutorService { ... }`
    - `public interface ExecutorService extends Executor { ... }`

- `public class Executors { ... }`
  
Factory and utility methods for `Executor`, `ExecutorService`, `ScheduledExecutorService`, `ThreadFactory`, and `Callable` classes defined in.

This class supports the following kinds of methods:
  - Methods that create and return an `ExecutorService` set up with commonly useful configuration settings.
  - Methods that create and return a `ScheduledExecutorService` set up with commonly useful configuration settings.
  - Methods that create and return a "wrapped" `ExecutorService`, that disables reconfiguration by making implementation-specific methods inaccessible.
  - Methods that create and return a `ThreadFactory` that sets newly created threads to a known state.
  - Methods that create and return a `Callable` out of other closure-like forms, so they can be used in execution methods requiring `Callable`.

1. [Example](./Demo012ThreadPoolExecutorService1.java)

- Executors.newFixedThreadPool(5)
- Executors.newSingleThreadExecutor();

- threadPoolExecService.execute(new RunnableImpl());
- threadPoolExecService.shutdown();
- threadPoolExecService.awaitTermination(1, TimeUnit.SECONDS); - **like a join but with a timer**

2. [Example](./Demo012ThreadPoolExecutorService2.java)

- schedule
- scheduleAtFixedRate
- scheduleWithFixedDelay

- Executors.newScheduledThreadPool(1);
- `schExecService.schedule(new RunnableImpl2(), 3, TimeUnit.SECONDS);`
  - in this example I scheduled the task after 3 seconds
- `schExecService.scheduleAtFixedRate(new RunnableImpl2(), 1, 2, TimeUnit.SECONDS);`
  - (task, the first time it will be started after 1 second, and the task will repeat every 2 seconds without delay, TimeUnit.SECONDS)
  - if you use `schExecService.shutdown();` immediately after `scheduleAtFixedRate`, `scheduleAtFixedRate` will not start
- `schExecService.scheduleWithFixedDelay(new RunnableImpl2(), 2, 3, TimeUnit.SECONDS);`
  - (task, the first time will be started after 2 seconds, and the task will repeat after every 2 seconds, TimeUnit.SECONDS)
  - if you use `schExecService.shutdown();` immediately after `scheduleWithFixedDelay`, `scheduleWithFixedDelay` will not start

---

## [Callable and Future](./Demo013CallableExampleFactorial.java)

- `Callable` - `@FunctionalInterface` `public interface Callable<V>{ ... }` a task that returns a result.
  - `V call() throws Exception;`
  - You can use `Callable` only with `ExecutorServices`

- `Future` - `public interface Future<V>` represents the result of an asynchronous computation.
  - `boolean cancel(boolean mayInterruptIfRunning);`
  - `boolean isCancelled();`
  - `boolean isDone();`
  - `V get() throws InterruptedException, ExecutionException;` - will block thread and wait for result
  - `V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException;`

---

## [Semaphore](./Demo014Semaphore.java)

A counting semaphore. Semaphore maintains a set of permits.
Each acquire blocks if necessary until a permit is available, and then takes it.
Each release adds a permit, potentially releasing a blocking acquirer.
However, no actual permit objects are used;
Semaphore just keeps a count of the number available and acts accordingly.

- `callBox.acquire();`
- `callBox.release();`

---

## [CountDownLatch](./Demo015CountDownLatch.java)

- `CountDownLatch countDownLatch = new CountDownLatch(3);`
- `countDownLatch.countDown();`
- `countDownLatch.await();`

---

## [Exchanger](./Demo016Exchanger.java)
- A synchronization point at which threads can pair and swap elements within pairs.
- `public V exchange(V x) throws InterruptedException { ... }`

## [Atomic operations](./Demo017Atomic.java)
- AtomicInteger
- AtomicBoolean
- AtomicLong
- AtomicIntegerArray
- ...

## [ConcurrentCollections](./Demo018ConcurrentCollections.java)
- Collections.synchronized`Collection`();
- Collections.synchronized`List`();
- Collections.synchronized`Map`();
- Collections.synchronized`Set`();
- Collections.synchronized`NavigableMap`();
- Collections.synchronized`NavigableSet`();
- Collections.synchronized`SortedMap`();
- Collections.synchronized`SortedSet`();

- Be careful with `Concurrent Modification Exception`

## [ConcurrentHashMap](./Demo019ConcurrentHashMap.java)
- Segment locking (Bucket locking)
- `HashMap<Integer, String> map = new HashMap<>();` <= Concurrent Modification Exception
- `ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();` <= Ok
- Be careful with `Concurrent Modification Exception`

## [CopyOnWriteArrayList](./CopyOnWriteArrayList.java)
- For modification - create copy of list and write to copy.
- Good for reading
- Be careful with `Concurrent Modification Exception`

## [ArrayBlockingQueue](./ArrayBlockingQueue.java)
- FIFO
- Thread-1 can add to queue (in end)
- Thread-2 can extract from queue (from begin)
- `queue.put(i);`
- `queue.take();`