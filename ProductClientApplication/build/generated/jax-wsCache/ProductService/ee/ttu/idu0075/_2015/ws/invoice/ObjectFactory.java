
package ee.ttu.idu0075._2015.ws.invoice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ee.ttu.idu0075._2015.ws.invoice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddCategoryResponse_QNAME = new QName("http://www.ttu.ee/idu0075/2015/ws/invoice", "addCategoryResponse");
    private final static QName _AddProductResponse_QNAME = new QName("http://www.ttu.ee/idu0075/2015/ws/invoice", "addProductResponse");
    private final static QName _GetCategoryProductListResponse_QNAME = new QName("http://www.ttu.ee/idu0075/2015/ws/invoice", "getCategoryProductListResponse");
    private final static QName _AddCategoryProductResponse_QNAME = new QName("http://www.ttu.ee/idu0075/2015/ws/invoice", "addCategoryProductResponse");
    private final static QName _GetProductResponse_QNAME = new QName("http://www.ttu.ee/idu0075/2015/ws/invoice", "getProductResponse");
    private final static QName _GetCategoryResponse_QNAME = new QName("http://www.ttu.ee/idu0075/2015/ws/invoice", "getCategoryResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ee.ttu.idu0075._2015.ws.invoice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CategoryProductType }
     * 
     */
    public CategoryProductType createCategoryProductType() {
        return new CategoryProductType();
    }

    /**
     * Create an instance of {@link ProductType }
     * 
     */
    public ProductType createProductType() {
        return new ProductType();
    }

    /**
     * Create an instance of {@link GetProductListResponse }
     * 
     */
    public GetProductListResponse createGetProductListResponse() {
        return new GetProductListResponse();
    }

    /**
     * Create an instance of {@link AddCategoryRequest }
     * 
     */
    public AddCategoryRequest createAddCategoryRequest() {
        return new AddCategoryRequest();
    }

    /**
     * Create an instance of {@link CategoryType }
     * 
     */
    public CategoryType createCategoryType() {
        return new CategoryType();
    }

    /**
     * Create an instance of {@link GetCategoryListResponse }
     * 
     */
    public GetCategoryListResponse createGetCategoryListResponse() {
        return new GetCategoryListResponse();
    }

    /**
     * Create an instance of {@link GetCategoryProductListRequest }
     * 
     */
    public GetCategoryProductListRequest createGetCategoryProductListRequest() {
        return new GetCategoryProductListRequest();
    }

    /**
     * Create an instance of {@link AddProductRequest }
     * 
     */
    public AddProductRequest createAddProductRequest() {
        return new AddProductRequest();
    }

    /**
     * Create an instance of {@link CategoryProductListType }
     * 
     */
    public CategoryProductListType createCategoryProductListType() {
        return new CategoryProductListType();
    }

    /**
     * Create an instance of {@link GetCategoryListRequest }
     * 
     */
    public GetCategoryListRequest createGetCategoryListRequest() {
        return new GetCategoryListRequest();
    }

    /**
     * Create an instance of {@link AddCategoryProductRequest }
     * 
     */
    public AddCategoryProductRequest createAddCategoryProductRequest() {
        return new AddCategoryProductRequest();
    }

    /**
     * Create an instance of {@link GetProductRequest }
     * 
     */
    public GetProductRequest createGetProductRequest() {
        return new GetProductRequest();
    }

    /**
     * Create an instance of {@link GetProductListRequest }
     * 
     */
    public GetProductListRequest createGetProductListRequest() {
        return new GetProductListRequest();
    }

    /**
     * Create an instance of {@link GetCategoryRequest }
     * 
     */
    public GetCategoryRequest createGetCategoryRequest() {
        return new GetCategoryRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CategoryType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ttu.ee/idu0075/2015/ws/invoice", name = "addCategoryResponse")
    public JAXBElement<CategoryType> createAddCategoryResponse(CategoryType value) {
        return new JAXBElement<CategoryType>(_AddCategoryResponse_QNAME, CategoryType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProductType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ttu.ee/idu0075/2015/ws/invoice", name = "addProductResponse")
    public JAXBElement<ProductType> createAddProductResponse(ProductType value) {
        return new JAXBElement<ProductType>(_AddProductResponse_QNAME, ProductType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CategoryProductListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ttu.ee/idu0075/2015/ws/invoice", name = "getCategoryProductListResponse")
    public JAXBElement<CategoryProductListType> createGetCategoryProductListResponse(CategoryProductListType value) {
        return new JAXBElement<CategoryProductListType>(_GetCategoryProductListResponse_QNAME, CategoryProductListType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CategoryProductType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ttu.ee/idu0075/2015/ws/invoice", name = "addCategoryProductResponse")
    public JAXBElement<CategoryProductType> createAddCategoryProductResponse(CategoryProductType value) {
        return new JAXBElement<CategoryProductType>(_AddCategoryProductResponse_QNAME, CategoryProductType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProductType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ttu.ee/idu0075/2015/ws/invoice", name = "getProductResponse")
    public JAXBElement<ProductType> createGetProductResponse(ProductType value) {
        return new JAXBElement<ProductType>(_GetProductResponse_QNAME, ProductType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CategoryType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ttu.ee/idu0075/2015/ws/invoice", name = "getCategoryResponse")
    public JAXBElement<CategoryType> createGetCategoryResponse(CategoryType value) {
        return new JAXBElement<CategoryType>(_GetCategoryResponse_QNAME, CategoryType.class, null, value);
    }

}
