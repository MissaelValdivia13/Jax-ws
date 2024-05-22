package com.example.services;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public class ChocolateService {
    @WebMethod
    public String createChocolateDataBase();

    @WebMethod
    public String addChocolate(String name, int cost);
}
