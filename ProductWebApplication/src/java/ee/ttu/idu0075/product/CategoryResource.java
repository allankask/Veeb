/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee.ttu.idu0075.product;
import ee.ttu.idu0075._2015.ws.invoice.AddCategoryProductRequest;
import ee.ttu.idu0075._2015.ws.invoice.AddCategoryRequest;
import ee.ttu.idu0075._2015.ws.invoice.CategoryProductListType;
import ee.ttu.idu0075._2015.ws.invoice.CategoryProductType;
import ee.ttu.idu0075._2015.ws.invoice.CategoryType;
import ee.ttu.idu0075._2015.ws.invoice.GetCategoryListRequest;
import ee.ttu.idu0075._2015.ws.invoice.GetCategoryListResponse;
import ee.ttu.idu0075._2015.ws.invoice.GetCategoryProductListRequest;
import ee.ttu.idu0075._2015.ws.invoice.GetCategoryRequest;
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
@Path("categorys")
public class CategoryResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CategoryResource
     */
    public CategoryResource() {
    }
    
    @GET
    @Produces("application/json")
    public GetCategoryListResponse getCategoryList(
            @QueryParam("token") String token,
            @QueryParam("hasRelatedProducts") String hasRelatedProducts) {
        ProductWebService ps = new ProductWebService();
        GetCategoryListRequest request = new GetCategoryListRequest();
        request.setToken(token);
        request.setHasRelatedProducts(hasRelatedProducts);
        return ps.getCategoryList(request);
    }
    
    @GET
    @Path("{id : \\d+}")
    @Produces("application/json")
    public CategoryType getCategory (@PathParam("id") String id, 
            @QueryParam("token") String token){
        ProductWebService ps = new ProductWebService();
        GetCategoryRequest request = new GetCategoryRequest();
        request.setId(BigInteger.valueOf(Integer.parseInt(id)));
        request.setToken(token);
        return ps.getCategory(request);
    }
    
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public CategoryType addCategory(CategoryType content, 
            @QueryParam("token") String token) {
        ProductWebService ps = new ProductWebService();
        AddCategoryRequest request = new AddCategoryRequest();
        request.setCategoryName(content.getCategoryName());
        request.setDescription(content.getDescription());
        request.setToken(token);
        return ps.addCategory(request);
    }
    @GET
    @Path("{id : \\d+}/products")
    @Produces("application/json")
    public CategoryProductListType getCategoryProductList(
            @QueryParam("token") String token,
            @PathParam("id") String id) {
        
        ProductWebService ps = new ProductWebService();
        GetCategoryProductListRequest request = new GetCategoryProductListRequest();
        request.setToken(token);
        request.setCategoryId(BigInteger.valueOf(Integer.parseInt(id)));
        return ps.getCategoryProductList(request);
    }
    
    @POST
    @Path("{categoryId : \\d+}/products/{productId : \\d+}")
    @Consumes("application/json")
    @Produces("application/json")
    public CategoryProductType addCategoryProduct(CategoryProductType content,
                                @PathParam("categoryId") String categoryId,
                                @PathParam("productId") String productId,
                                @QueryParam("token") String token) {
        
        ProductWebService ps = new ProductWebService();
        AddCategoryProductRequest request = new AddCategoryProductRequest();
        
        request.setProductId(BigInteger.valueOf(Integer.parseInt(productId)));
        request.setCategoryId(BigInteger.valueOf(Integer.parseInt(categoryId)));
        request.setQuantity(content.getQuantity());
        request.setUnitPrice(content.getUnitPrice());
        request.setToken(token);
        return ps.addCategoryProduct(request);
    }
}
