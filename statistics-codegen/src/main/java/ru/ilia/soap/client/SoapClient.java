package ru.ilia.soap.client;

import net.webservicex.ArrayOfDouble;
import net.webservicex.Statistics;
import net.webservicex.StatisticsSoap;
import ru.ilia.soap.client.exception.SumLessZeroException;

import javax.xml.ws.Holder;
import java.util.List;

/**
 * Created by ILIA on 17.05.2017.
 */
public class SoapClient {
    private static final StatisticsSoap statisticsSoap = new Statistics().getStatisticsSoap();

    private double sum, average;

    public double calculateAverage(List<Double> array) throws SumLessZeroException {

        ArrayOfDouble arrayOfDouble = new ArrayOfDouble();
        arrayOfDouble.getDouble().addAll(array);

        this.invokeGetStatistics(arrayOfDouble);

        if (this.getSum() < 0) {
            throw new SumLessZeroException();
        }
        return this.getAverage();
    }

    /*
    * Method is public because need create test for this method
    * */
    public void invokeGetStatistics(ArrayOfDouble x) {
        Holder<Double> average = new Holder<Double>();
        Holder<Double> sum = new Holder<Double>();
        statisticsSoap.getStatistics(x, sum, average, null, null, null);
        this.setSum(sum.value);
        this.setAverage(average.value);
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }
}
