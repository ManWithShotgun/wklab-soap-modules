package ru.ilia.soap.webservice;

import net.webservicex.ArrayOfDouble;
import net.webservicex.Statistics;
import net.webservicex.StatisticsSoap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.ilia.soap.exception.BaseException;
import ru.ilia.soap.exception.SumLessZeroException;

import javax.ws.rs.core.Response;
import javax.xml.ws.Holder;
import java.util.List;

/**
 * Created by ILIA on 09.04.2017.
 */

@Service("AverageService")
public class AverageServiceImpl implements AverageService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final StatisticsSoap statisticsSoap=new Statistics().getStatisticsSoap();

    @Override
    public double calculateAverage(List<Double> array) {
        for (double a : array){
            logger.info("In double: "+a);
        }

        ArrayOfDouble arrayOfDouble=new ArrayOfDouble();
        arrayOfDouble.getDouble().addAll(array);

        Holder<Double> average=new Holder<Double>();
        Holder<Double> sum=new Holder<Double>();

        statisticsSoap.getStatistics(arrayOfDouble, sum,average,null,null,null);

        logger.info("Average: "+average.value);
        logger.info("Sum: "+sum.value);
        if(sum.value<0){
            throw new SumLessZeroException();
        }

        return average.value;
    }
}
