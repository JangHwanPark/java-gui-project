package Model;

public abstract class Car extends IProducts{
    // 제품의 공통 필드  (제품 id, 제품 이름, 제품 이미지, 제품 상태)
    // 차 라는 제품의 추가 공통 필드 (차 브랜드, 차 모델)
    private String brand;
    private String model;
    // 차라는 제품의 생성자
    public Car(int productId, String productName, String productImg, String productState,
               String brand, String model)
    { // 제품의 속성 상속
        super(productId, productName, productImg, productState);
        // (브랜드, 모델)
        this.brand = brand;
        this.model = model;
    }
    // 제품의 private 캡슐화된 필드를 가져오기 위한 set/get 메서드 Override
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
    public String getProductImg() {
        return super.getProductImg();
    }

    @Override
    public void setProductState(String productState) {
        super.setProductState(productState);
    }

    @Override
    public String getProductState() {
        return super.getProductState();
    }
    // car 클래스의 private 캡슐화된 필드를 가져오기 위한 get/set Methode
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }
    @Override // 차 객체가 가지고 있는 정보를 출력하기 위한 toString 메서드 Override
    public String toString() {
        return "Car{" +
                "productId=" + getProductId() +
                ", productName='" + getProductName() + '\'' +
                ", productImg='" + getProductImg() + '\'' +
                ", productState='" + getProductState() + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
