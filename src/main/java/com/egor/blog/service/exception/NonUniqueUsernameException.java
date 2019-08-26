package com.egor.blog.service.exception;

public class NonUniqueUsernameException extends UniqueException {
    public NonUniqueUsernameException() {

    }

    @Override
    public String getMessage() {
        return "Пользователь с таким именем уже существует";
    }


    public String getField() {
        return "username";
    }
}
