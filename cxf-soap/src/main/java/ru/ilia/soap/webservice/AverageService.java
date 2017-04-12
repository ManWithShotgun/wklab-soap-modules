package ru.ilia.soap.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by ILIA on 09.04.2017.
 */
@WebService
public interface AverageService {
    @WebMethod
    @WebResult(name = "average")
    double calculateAverage(@WebParam(name = "double") List<Double> array);
}
