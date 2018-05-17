package com.javarush.task.task28.task2802;


import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Пишем свою ThreadFactory
*/
public class Solution {

    public static void main(String[] args) {
        class EmulateThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulateThreadFactoryTask());

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulateThreadFactoryTask());

        thread.start();
        thread2.start();
    }
    public static class AmigoThreadFactory implements ThreadFactory{
        private AtomicInteger factoryN = new AtomicInteger(0);
        private AtomicInteger threadN = new AtomicInteger(0);
        private static AtomicInteger factoryCount = new AtomicInteger(0);

        public AmigoThreadFactory() {
            factoryN.set(factoryCount.incrementAndGet());
        }


        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);

            thread.setName(thread.getThreadGroup().getName() + "-pool-" + factoryN + "-thread-" + threadN.incrementAndGet());

            if (thread.isDaemon())
                thread.setDaemon(false);
            if (thread.getPriority() != Thread.NORM_PRIORITY)
                thread.setPriority(Thread.NORM_PRIORITY);

            return thread;
        }
    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }
}