package Model;

public class Lexus extends IProducts{
    private String brand;
    private String model;
    public Lexus(int productId, String productName, String productImg, String productState,
                 String brand, String model) {
        super(productId, productName, productImg,productState);
        this.brand = brand;
        this.model = model;
    }

    @Override
    public void setProductId(int productId) {
        super.setProductId(productId);
    }

    @Override
    public int getProductId() {
        return super.getProductId();
    }

    @Override
    public void setProductName(String productName) {
        super.setProductName(productName);
    }

    @Override
    public String getProductName() {
        return super.getProductName();
    }

    @Override
    public void setProductImg(String productImg) {
        super.setProductImg(productImg);
    }

    @Override
    public String getProductState() {
        return super.getProductState();
    }

    @Override
    public void setProductState(String productState) {
        super.setProductState(productState);
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }


    // 객체가 가지고 있는 정보를 문자열로 return 하기 위한 toString() 메서드
    @Override
    public String toString() {
        return "Lexus: {" +
                "\n\tproductId: " + getProductId() +
                "\n\tproductName: " + getProductName() +
                "\n\tproductImg: " + getProductImg() +
                "\n\tproductState: " + getProductState() +
                "\n\tbrand: " + brand +
                "\n\tmodel: " + model +
                "\n}"
                ;
    }

}
