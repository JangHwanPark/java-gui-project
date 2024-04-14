package Model;

public abstract class ProductDTO {
    private int productId;
    private String productName;
    private String productImg;
    private String productState;

    public ProductDTO(int productId, String productName, String productImg, String productState) {
        this.productId = productId;
        this.productName = productName;
        this.productImg = productImg;
        this.productState = productState;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductState(String productState) {
        this.productState = productState;
    }

    public String getProductState() {
        return productState;
    }
}

