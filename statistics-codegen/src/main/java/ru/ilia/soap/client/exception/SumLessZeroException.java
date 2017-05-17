package ru.ilia.soap.client.exception;

/**
 * Created by ILIA on 17.05.2017.
 */
public class SumLessZeroException extends Exception {
    public SumLessZeroException() {
        super("Sum double array less zero.");
    }
}
