package ru.ilia.soap.webservice;

import org.junit.Test;
import ru.ilia.soap.exception.SumLessZeroException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * SoapClient class is service integrator (pattern Integrator)
 * and the case is so difficult for testing.
 * The class tests: "if" section and exception
 */
public class AverageServiceTest {

    /*
    * Online test's
    * */

    @Test
    public void calculateAverage_ArrayDoubleSum20_10() {
        AverageServiceImpl averageService = new AverageServiceImpl();

        List<Double> list = new ArrayList<>();
        list.add(8d);
        list.add(12d);

        double resultAverage = averageService.calculateAverage(list);
        assertEquals(10d, resultAverage, 0.1d);
    }

    @Test
    public void calculateAverage_ArrayDoubleSum600_300() {
        AverageServiceImpl averageService = new AverageServiceImpl();

        List<Double> list = new ArrayList<>();
        list.add(100d);
        list.add(500d);

        double resultAverage = averageService.calculateAverage(list);
        assertEquals(300d, resultAverage, 0.1d);
    }

    @Test(expected = NullPointerException.class)
    public void calculateAverage_ArrayDoubleNull_NullPointerException() {
        AverageServiceImpl averageService = new AverageServiceImpl();
        averageService.calculateAverage(null);
    }

    @Test(expected = SumLessZeroException.class)
    public void calculateAverage_ArrayDoubleSumLessZero_SumLessZeroException() {
        AverageServiceImpl averageService = new AverageServiceImpl();

        List<Double> list = new ArrayList<>();
        list.add(8d);
        list.add(-12d);

        averageService.calculateAverage(list);
    }
}
