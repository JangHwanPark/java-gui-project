package product;

public abstract class Product {
    private int productId;
    private String productName;
    private String productImg;
    private String productState;

    public Product(int productId, String productName, String productImg, String productState) {
        this.productId = productId;
        this.productName = productName;
        this.productImg = productImg;
        this.productState = productState;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductState(String productState) {
        this.productState = productState;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductImg() {
        return productImg;
    }

    public String getProductName() {
        return productName;
    }


}
