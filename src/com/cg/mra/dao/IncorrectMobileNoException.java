package com.cg.mra.dao;

public class IncorrectMobileNoException extends RuntimeException{

    public IncorrectMobileNoException(final String msg){
        super(msg);
    }

    public IncorrectMobileNoException(final String msg,final Throwable e){
        super(msg,e);
    }
}
