package com.egor.blog.service.exception;

public class NonUniqueEmailException extends UniqueException {
    public NonUniqueEmailException() {

    }

    @Override
    public String getMessage() {
        return "Пользователь с таким Email уже существует";
    }

    public String getField() {
        return "email";
    }

}
