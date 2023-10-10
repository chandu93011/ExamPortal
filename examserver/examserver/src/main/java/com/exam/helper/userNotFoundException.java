package com.exam.helper;

public class userNotFoundException extends Exception{
    public  userNotFoundException(){
        super("user with this username not found !! ");
    }

    public userNotFoundException(String msg) {
        super(msg);
    }
}
