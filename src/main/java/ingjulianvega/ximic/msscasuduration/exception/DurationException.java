package ingjulianvega.ximic.msscasuduration.exception;

import lombok.Getter;

@Getter
public class DurationException extends RuntimeException {

    private final String code;

    public DurationException(final String code, final String message) {
        super(message);
        this.code = code;
    }
}

