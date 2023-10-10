package com.exam.helper;

public class userFoundException extends Exception {
    public  userFoundException(){
        super("User with this username is already there in the DB !! ");
    }

    public userFoundException(String msg) {
        super(msg);
    }
}
