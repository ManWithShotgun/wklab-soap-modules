package ru.ilia.soap.client;

import net.webservicex.ArrayOfDouble;
import net.webservicex.Statistics;
import net.webservicex.StatisticsSoap;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import ru.ilia.soap.client.exception.SumLessZeroException;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * SoapClient class is service integrator (pattern Integrator)
 * and the case is so difficult for testing.
 * The class tests: "if" section and exception
 */
public class SoapClientTest {

    /*
    * Online test's
    * */

    @Test
    public void calculateAverage_ArrayDoubleSum20_10() throws SumLessZeroException {
        SoapClient soapClient = new SoapClient();

        List<Double> list= new ArrayList<>();
        list.add(8d);
        list.add(12d);

        double resultAverage = soapClient.calculateAverage(list);
        assertEquals(10d, resultAverage, 0.1d);
    }

    @Test
    public void calculateAverage_ArrayDoubleSum600_300() throws SumLessZeroException {
        SoapClient soapClient = new SoapClient();

        List<Double> list= new ArrayList<>();
        list.add(100d);
        list.add(500d);

        double resultAverage = soapClient.calculateAverage(list);
        assertEquals(300d, resultAverage, 0.1d);
    }

    @Test
    public void calculateAverage_TestSumArrayDouble_20() throws SumLessZeroException {
        SoapClient soapClient = new SoapClient();

        List<Double> list= new ArrayList<>();
        list.add(8d);
        list.add(12d);

        soapClient.calculateAverage(list);
        assertEquals(20d, soapClient.getSum(), 0.1d);
    }

    @Test
    public void invokeGetStatistics_ArrayDoubleSum120_40() throws SumLessZeroException {
        SoapClient soapClient = new SoapClient();

        ArrayOfDouble arrayOfDouble = new ArrayOfDouble();
        arrayOfDouble.getDouble().add(20d);
        arrayOfDouble.getDouble().add(40d);
        arrayOfDouble.getDouble().add(60d);

        soapClient.invokeGetStatistics(arrayOfDouble);
        assertEquals(40, soapClient.getAverage(), 0.1d);
    }

    @Test(expected = NullPointerException.class)
    public void calculateAverage_ArrayDoubleNull_NullPointerException() throws SumLessZeroException {
        SoapClient soapClient = new SoapClient();
        soapClient.calculateAverage(null);
    }

    /**
     * Check exception on null from outside service
     * */
    @Test(expected = Exception.class)
    public void invokeGetStatistics_ArrayDoubleNull_Exception() throws SumLessZeroException {
        SoapClient soapClient = new SoapClient();
        soapClient.invokeGetStatistics(null);
    }

    @Test(expected = SumLessZeroException.class)
    public void calculateAverage_ArrayDoubleSumLessZero_SumLessZeroException() throws SumLessZeroException {
        SoapClient soapClient = new SoapClient();

        List<Double> list= new ArrayList<>();
        list.add(8d);
        list.add(-12d);

        soapClient.calculateAverage(list);
    }

    /**
     * Offline test. Test mocks service.
     * Attention: The test testing mock.
     */
    @Test
    public void calculateAverage_ArrayDoubleSum12_6(){
        SoapClient soapClient = mock(SoapClient.class);
        when(soapClient.getSum()).thenReturn(4d);
        when(soapClient.getAverage()).thenReturn(6d);
        doNothing().when(soapClient).invokeGetStatistics(anyObject());

        List<Double> list= new ArrayList<>();
        list.add(4d);
        list.add(4d);
        list.add(4d);

        try {
            soapClient.calculateAverage(list);
            /*equals with mock. Real average eq 4*/
            assertEquals(6d, soapClient.getAverage(), 0.1d);
        } catch (SumLessZeroException e) {
            e.printStackTrace();
        }
    }

}
