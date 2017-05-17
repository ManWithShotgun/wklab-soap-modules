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
    private static final StatisticsSoap statisticsSoap=new Statistics().getStatisticsSoap();

    public double calculateAverage(List<Double> array) throws SumLessZeroException {

        ArrayOfDouble arrayOfDouble=new ArrayOfDouble();
        arrayOfDouble.getDouble().addAll(array);

        Holder<Double> average=new Holder<Double>();
        Holder<Double> sum=new Holder<Double>();

        statisticsSoap.getStatistics(arrayOfDouble, sum,average,null,null,null);

        if(sum.value<0){
            throw new SumLessZeroException();
        }
        return average.value;
    }
}
