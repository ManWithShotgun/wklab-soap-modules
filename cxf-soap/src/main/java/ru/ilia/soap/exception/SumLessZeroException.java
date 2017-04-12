package ru.ilia.soap.exception;

import javax.ws.rs.core.Response;

/**
 * Created by ILIA on 10.04.2017.
 */
public class SumLessZeroException extends BaseException {

    public SumLessZeroException() {
        super(Response.Status.BAD_REQUEST, "Sum is less than 0");
    }
}
