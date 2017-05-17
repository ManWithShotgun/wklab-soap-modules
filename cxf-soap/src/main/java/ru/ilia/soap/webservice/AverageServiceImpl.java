package ru.ilia.soap.webservice;

import net.webservicex.ArrayOfDouble;
import net.webservicex.Statistics;
import net.webservicex.StatisticsSoap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.ilia.soap.client.SoapClient;
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

    @Override
    public double calculateAverage(List<Double> array) {
        for (double a : array) {
            logger.info("In double: " + a);
        }

        double result = -1;
        SoapClient client = new SoapClient();
        try {
            result = client.calculateAverage(array);
        } catch (ru.ilia.soap.client.exception.SumLessZeroException e) {
            throw new SumLessZeroException();
        }

        return result;
    }
}
