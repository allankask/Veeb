/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee.ttu.idu0075.product;

import ee.ttu.idu0075._2015.ws.invoice.AddCategoryProductRequest;
import ee.ttu.idu0075._2015.ws.invoice.AddCategoryRequest;
import ee.ttu.idu0075._2015.ws.invoice.AddProductRequest;
import ee.ttu.idu0075._2015.ws.invoice.CategoryProductListType;
import ee.ttu.idu0075._2015.ws.invoice.CategoryProductType;
import ee.ttu.idu0075._2015.ws.invoice.CategoryType;
import ee.ttu.idu0075._2015.ws.invoice.GetCategoryListRequest;
import ee.ttu.idu0075._2015.ws.invoice.GetCategoryListResponse;
import ee.ttu.idu0075._2015.ws.invoice.GetCategoryProductListRequest;
import ee.ttu.idu0075._2015.ws.invoice.GetCategoryRequest;
import ee.ttu.idu0075._2015.ws.invoice.GetProductListRequest;
import ee.ttu.idu0075._2015.ws.invoice.GetProductListResponse;
import ee.ttu.idu0075._2015.ws.invoice.GetProductRequest;
import ee.ttu.idu0075._2015.ws.invoice.ProductType;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;

/**
 *
 * @author Allan
 */
@WebService(serviceName = "ProductService", portName = "ProductPort", endpointInterface = "ee.ttu.idu0075._2015.ws.invoice.ProductPortType", targetNamespace = "http://www.ttu.ee/idu0075/2015/ws/invoice", wsdlLocation = "WEB-INF/wsdl/ProductWebService/ProductCategoryService.wsdl")
public class ProductWebService {

    static int nextProductId = 1;
    static int nextCategoryId = 1;
    static List<ProductType> productList = new ArrayList<ProductType>();
    static List<CategoryType> categoryList = new ArrayList<CategoryType>();

    public ProductType getProduct(GetProductRequest parameter) {
         ProductType pt = null;
        if (parameter.getToken().equalsIgnoreCase("salajane")) {
            for (int i = 0; i < productList.size(); i++){
                if(productList.get(i).getId().equals(parameter.getId())){
                    pt = productList.get(i);
                }
            }
        }
        return pt;
    }

    public ProductType addProduct(AddProductRequest parameter) {
        ProductType pt = new ProductType();
        if (parameter.getToken().equalsIgnoreCase("salajane")) {
            pt.setName(parameter.getName());
            pt.setProductCode(parameter.getProductCode());
            pt.setManufacturer(parameter.getManufacturer());
            pt.setDescribeProduct(parameter.getDescribeProduct());
            pt.setId(BigInteger.valueOf(nextProductId++));
            productList.add(pt);
        }
        return pt;
    }

    public GetProductListResponse getProductList(GetProductListRequest parameter) {
        GetProductListResponse response = new GetProductListResponse();
        if (parameter.getToken().equalsIgnoreCase("salajane")) {
            for (ProductType productType : productList) {
                if (parameter.getManufacturer().equalsIgnoreCase(productType.getManufacturer()) &&
                        parameter.getProductCode().equals(productType.getProductCode())) {
                   response.getProduct().add(productType); 
                }
            }
        }
        return response;
    } 

    public CategoryType  getCategory(GetCategoryRequest parameter) {
            CategoryType ct = null;
        if (parameter.getToken().equalsIgnoreCase("salajane")) {
            for (int i = 0; i < categoryList.size(); i++){
                if(categoryList.get(i).getId().equals(parameter.getId())){
                    ct = categoryList.get(i);
                }
            }
        }
        return ct;
    }
    
    public CategoryType addCategory(AddCategoryRequest parameter) {
         CategoryType ct = new CategoryType();
        if (parameter.getToken().equalsIgnoreCase("salajane")) {
            ct.setCategoryName(parameter.getCategoryName());
            ct.setCategoryProductList(new CategoryProductListType());
            ct.setDescription(parameter.getDescription());
            ct.setId(BigInteger.valueOf(nextCategoryId++));
            categoryList.add(ct);
        }
        return ct;
    }

    public GetCategoryListResponse getCategoryList(GetCategoryListRequest parameter) {
        GetCategoryListResponse response = new GetCategoryListResponse();
        if(parameter.getToken().equalsIgnoreCase("salajane")){
            for (CategoryType categoryType : categoryList){
                if(parameter.getHasRelatedProducts().equalsIgnoreCase("ei") 
                        && (categoryType.getCategoryProductList() == null
                        || categoryType.getCategoryProductList().getCategoryProduct().isEmpty())
                        || parameter.getHasRelatedProducts().equalsIgnoreCase("jah")
                        && categoryType.getCategoryProductList() != null
                        && !categoryType.getCategoryProductList().getCategoryProduct().isEmpty()) {
                    response.getCategory().add(categoryType);
                }
            }
        }
        return response;
    }

    public CategoryProductListType getCategoryProductList(GetCategoryProductListRequest parameter) {
        CategoryProductListType categoryProductList = null;
        if (parameter.getToken().equalsIgnoreCase("salajane")) {
            for (int i = 0; i < categoryList.size(); i++) {
                if (categoryList.get(i).getId().equals(parameter.getCategoryId())) {
                    categoryProductList = categoryList.get(i).getCategoryProductList();
                }

            }    
        }
        return categoryProductList;
    }

    public CategoryProductType addCategoryProduct(AddCategoryProductRequest parameter) {
        CategoryProductType productCategory = new CategoryProductType();
        if (parameter.getToken().equalsIgnoreCase("salajane")) {
            GetProductRequest productRequest = new GetProductRequest();
            productRequest.setId(parameter.getProductId());
            productRequest.setToken(parameter.getToken());
            productCategory.setProduct(getProduct(productRequest));
            productCategory.setQuantity(parameter.getQuantity());
            productCategory.setUnitPrice(parameter.getUnitPrice());
       
            for (int i = 0; i < categoryList.size(); i++) {
                if (categoryList.get(i).getId().equals(parameter.getCategoryId()) ) {
                    categoryList.get(i).getCategoryProductList().getCategoryProduct().add(productCategory);      
                    return productCategory;
                }
            } 
        }
        return null;
    }
    
}
