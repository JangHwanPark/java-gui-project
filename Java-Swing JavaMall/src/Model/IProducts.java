package Model;

public abstract class IProducts {
    // 제품의 공통 필드 정의 (제품 id, 제품 이름, 제품 이름, 제품 상태)
    private int productId;
    private String productName;
    private String productImg;
    private String productState;
    // 제품 Product 생성자
    public IProducts(int productId, String productName, String productImg, String productState) {
        this.productId = productId;
        this.productName = productName;
        this.productImg = productImg;
        this.productState = productState;
    }
    // private 캡슐화된 필드를 가져오기 위한 get/set Methode
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

    // 객체가 가지고 있는 정보를 문자열로 return 하기 위한 toString() 메서드
    @Override
    public String toString() {
        return "Products: {" +
                "\n\tproductId: " + productId +
                "\n\tproductName: " + productName +
                "\n\tproductImg: " + productImg +
                "\n\tproductState: " + productState +
                "\n}"
               ;
    }
}

