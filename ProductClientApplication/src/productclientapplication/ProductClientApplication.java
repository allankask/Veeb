/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productclientapplication;

import ee.ttu.idu0075._2015.ws.invoice.AddProductRequest;
import ee.ttu.idu0075._2015.ws.invoice.GetProductRequest;
import ee.ttu.idu0075._2015.ws.invoice.ProductPortType;
import ee.ttu.idu0075._2015.ws.invoice.ProductService;
import ee.ttu.idu0075._2015.ws.invoice.ProductType;
import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Allan
 */
public class ProductClientApplication {

  public static void main(String[] args) {
        //ADD PRODUCT
        AddProductRequest apr = new AddProductRequest();
        apr.setProductCode("KOOD1");
        apr.setName("Kahvel");
        apr.setManufacturer("KitchenKnif");
        apr.setDescribeProduct("Parimad kahvlid");
        apr.setToken("salajane");
        addProduct(apr);
        
        //GET PRODUCT
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product ID: ");
        BigInteger id = scanner.nextBigInteger();
        System.out.println(id);
        GetProductRequest gpr = new GetProductRequest();
        gpr.setToken("salajane");
        gpr.setId(id);
        ProductType response = getProduct(gpr);
        System.out.println("Toote nimi: " + response.getName());
        System.out.println("Toote kood: " + response.getProductCode());
        System.out.println("Tootja: " + response.getManufacturer());
    }


    private static ProductType addProduct(AddProductRequest parameter) {
        ProductService service = new ProductService();
        ProductPortType port = service.getProductPort();
        return port.addProduct(parameter);
    }

    private static ProductType getProduct(GetProductRequest parameter) {
        ProductService service = new ProductService();
        ProductPortType port = service.getProductPort();
        return port.getProduct(parameter);
    }
    
}
