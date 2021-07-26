package com.singletonways;

public enum SingletonEnum {
    INSTANCE;

    public int getValue(){
        return 26;
    }

}
/*
* SingletonEnum.INSTANCE.getValue();
* This is the best way and thread safe if there is NO need for Singleton to be a class
*
* */