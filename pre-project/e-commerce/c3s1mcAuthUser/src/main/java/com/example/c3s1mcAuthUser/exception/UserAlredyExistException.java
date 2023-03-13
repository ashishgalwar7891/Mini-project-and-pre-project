package com.example.c3s1mcAuthUser.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "This user is alredy present")
public class UserAlredyExistException extends Exception{
}
