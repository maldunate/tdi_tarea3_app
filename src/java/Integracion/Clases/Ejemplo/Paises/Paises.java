/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Integracion.Clases.Ejemplo.Paises;

import Airports.NewWebServiceFromWSDL;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;
import net.webservicex.Airport;
import net.webservicex.AirportSoap;

/**
 *
 * @author Usuario
 */
@WebService(serviceName = "Paises")
public class Paises {

    /**
     * This is a sample web service operation
     * @param pais
     * @return 
     */
    @WebMethod(operationName = "getCitiesAndAirports")
    public String[] getCitiesAndAirPortsWithCountry (@WebParam(name = "pais") String pais) {
        
        // se crea cliente para service
        GlobalWeather gw = new GlobalWeather();
        Airport a = new Airport();
        
        // se obtiene cliente soap
        GlobalWeatherSoap gwSoap = gw.getGlobalWeatherSoap();
        AirportSoap aSoap = a.getAirportSoap();
        
        // se llama a servicio
        // llamada se produce de manera sincrona, por lo que el retorno
        // queda en variable cities
        
        String cities = gwSoap.getCitiesByCountry(pais);
        String airports = aSoap.getAirportInformationByCountry(pais);
        String[] result = new String[2];
        
        result[0] = cities;
        result[1] = airports;
        
        return result;
    }
}
