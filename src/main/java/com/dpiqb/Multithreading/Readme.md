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