package com.example.c3s1mcAuthUser.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "this id is not available")
public class UserNotFoundException extends Exception{
}
