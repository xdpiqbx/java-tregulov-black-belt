# Multithreading

---

## `class DemoThread extends Thread {...}`

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

## `class DemoRunnable implements Runnable {...}`

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

## `Lambdas`

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

## Volatile

- it is good when only one thread change value all others are read

`volatile boolean flag = true;`

---

## Data race. Synchronized methods

- Synchronization is on the monitor
- Default `synchronized` by `this`
- Synchronization on `this`, `SomeClass.class`, `private static final Object lock = new Object();`
- Can not Synchronize Constructor

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

---

## Monitor. Synchronized block

- Every entity in Java has own monitor
- Monitor can be `busy` or `free`
- At same time the monitor can work with one thread
- With Synchronized block you can sync only part of logic

### synchronized block in non-static method
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
```java
    public static synchronized void increment(){
        synchronized (SomeClass.class){
            counter++;
        }
    }
```

## wait() notify()
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

## ThreadPool and ExecutorService