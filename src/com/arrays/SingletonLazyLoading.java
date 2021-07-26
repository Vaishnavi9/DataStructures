package com.arrays;
/*
* volatile = solves visibility issues
* atomic = solves synchronization issues
* */
public class SingletonLazyLoading {
    private static volatile SingletonLazyLoading INSTANCE = null;

    private SingletonLazyLoading(){}

    public static SingletonLazyLoading getInstance(){
        if(INSTANCE == null){
            synchronized (Singleton.class){
                if(INSTANCE==null){
                    return new SingletonLazyLoading();
                }
            }
        }
        return INSTANCE;
    }
}
