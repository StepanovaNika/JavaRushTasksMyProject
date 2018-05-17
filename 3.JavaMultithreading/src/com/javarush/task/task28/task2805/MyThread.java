package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
    private static AtomicInteger currenrproip = new AtomicInteger(0);
    public MyThread() {
        priorit();
    }

    public MyThread(Runnable target) {
        super(target);
        priorit();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        priorit();
    }

    public MyThread(String name) {
        super(name);
        priorit();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        priorit();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        priorit();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        priorit();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        priorit();
    }
    public void priorit(){
        currenrproip.incrementAndGet();
        currenrproip.compareAndSet(11, 1);
        int newPr = currenrproip.get();
        if (getThreadGroup() != null){
            if (newPr > getThreadGroup().getMaxPriority()){
                newPr = getThreadGroup().getMaxPriority();
            }
        }
        setPriority(newPr);

    }
}
