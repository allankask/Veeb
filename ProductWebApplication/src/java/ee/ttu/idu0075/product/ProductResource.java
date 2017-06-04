/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee.ttu.idu0075.product;


import ee.ttu.idu0075._2015.ws.invoice.AddProductRequest;
import ee.ttu.idu0075._2015.ws.invoice.GetProductListRequest;
import ee.ttu.idu0075._2015.ws.invoice.GetProductListResponse;
import ee.ttu.idu0075._2015.ws.invoice.GetProductRequest;
import ee.ttu.idu0075._2015.ws.invoice.ProductType;
import java.math.BigInteger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;


/**
 * REST Web Service
 *
 * @author Allan
 */
@Path("products")
public class ProductResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProductResource
     */
    public ProductResource() {
    }

    /**
     * Retrieves representation of an instance of ee.ttu.idu0075.product.ProductResource
     * @param token
     * @param productCode
     * @param manufacturer
     * @return an instance of ee.ttu.idu0075._2015.ws.invoice.ProductType
     */
    
    @GET
    @Produces("application/json")
    public GetProductListResponse getProductList(
            @QueryParam("token") String token,
            @QueryParam("productCode")String productCode,
            @QueryParam("manufacturer")String manufacturer){
        
        ProductWebService ps = new ProductWebService();
        GetProductListRequest request = new GetProductListRequest();
        request.setProductCode(productCode);
        request.setManufacturer(manufacturer);  
        request.setToken(token);
        return ps.getProductList(request);
       
    }
    

  
    @GET
    @Path("{id : \\d+}")
    @Produces("application/json")
    public ProductType getProduct (@PathParam("id") String id, 
            @QueryParam("token") String token){
        
        ProductWebService ps = new ProductWebService();
        GetProductRequest request = new GetProductRequest();
        request.setId(BigInteger.valueOf(Integer.parseInt(id)));
        request.setToken(token);
        return ps.getProduct(request);
    }
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public ProductType addProduct(ProductType content, 
            @QueryParam("token") String token) {
        
        ProductWebService ps = new ProductWebService();
        AddProductRequest request = new AddProductRequest();
        request.setProductCode(content.getProductCode());
        request.setName(content.getName());
        request.setManufacturer(content.getManufacturer());
        request.setDescribeProduct(content.getDescribeProduct());
        request.setToken(token);
        return ps.addProduct(request);
        
    }
}
