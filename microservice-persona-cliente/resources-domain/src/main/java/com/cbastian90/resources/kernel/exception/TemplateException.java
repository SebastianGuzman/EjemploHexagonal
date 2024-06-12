package com.cbastian90.resources.kernel.exception;

public class TemplateException extends RuntimeException {

    TemplateException() {
        super();
    }

    TemplateException(String message) {
        super(message);
    }

    TemplateException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
