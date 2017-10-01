package org.example;

public final class BPMCacheException extends Exception {
    public BPMCacheException() {
        super();
    }

    public BPMCacheException(String message) {
        super(message);
    }

    public BPMCacheException(String message, Throwable cause) {
        super(message, cause);
    }

    public BPMCacheException(Throwable cause) {
        super(cause);
    }

    protected BPMCacheException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
