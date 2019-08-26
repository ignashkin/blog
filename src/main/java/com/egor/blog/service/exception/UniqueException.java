package com.egor.blog.service.exception;

public abstract class UniqueException extends Exception{
    public abstract String getMessage();
    public abstract String getField();


}
