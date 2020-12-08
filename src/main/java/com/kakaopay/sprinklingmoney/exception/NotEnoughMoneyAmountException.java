package com.kakaopay.sprinklingmoney.exception;

public class NotEnoughMoneyAmountException extends RuntimeException {
    public NotEnoughMoneyAmountException() {
        super();
    }

    public NotEnoughMoneyAmountException(String message) {
        super(message);
    }

    public NotEnoughMoneyAmountException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnoughMoneyAmountException(Throwable cause) {
        super(cause);
    }

    protected NotEnoughMoneyAmountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
