/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webService;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author lv1822
 */
@WebService(serviceName = "botita")
public class botita {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "suma")
    public int suma(@WebParam(name = "op1") int a, @WebParam(name = "op2") int b) {
        return a + b;
    }
    
    @WebMethod(operationName = "saludo")
    public String saludo(@WebParam(name = "name") String txt) {
        return "wola " + txt + " !";
    }
}
