package com.bpf.except;

public class GoodNotEnoughException extends RuntimeException {

    public GoodNotEnoughException() {
        super();
    }

    public GoodNotEnoughException(String message) {
        super(message);
    }
}
