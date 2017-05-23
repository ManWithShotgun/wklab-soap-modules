package ru.ilia.soap.webservice;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.ilia.soap.client.SoapClient;
import ru.ilia.soap.exception.SumLessZeroException;

import javax.jws.WebService;
import java.util.List;

/**
 * Created by ILIA on 09.04.2017.
 */

@WebService()
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
