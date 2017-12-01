package com.yang.common.base.rest;


import com.yang.common.base.service.BaseRuntimeException;

public class ThirdApiException extends BaseRuntimeException {
    private static final long serialVersionUID = 1401593546385403723L;

    public ThirdApiException() {
        super();
    }

    public ThirdApiException(String message) {
        super(message);
    }

    public ThirdApiException(Throwable cause) {
        super(cause);
    }

    public ThirdApiException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
