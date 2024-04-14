package Model;

public abstract class LexusDTO extends ProductDTO {
    private int year;
    private String model;
    private String color;

    // 제품모델 클래스를 상속받은 렉서스 생성자
    public LexusDTO(int productId, String productName, String productImg, String productState, int year, String model, String color) {
        super(productId, productName, productImg, productState);
        this.year = year;
        this.model = model;
        this.color = color;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public int getProductId() {
        return super.getProductId();
    }

    @Override
    public void setProductId(int productId) {
        super.setProductId(productId);
    }

    @Override
    public String getProductName() {
        return super.getProductName();
    }

    @Override
    public void setProductName(String productName) {
        super.setProductName(productName);
    }

    @Override
    public String getProductImg() {
        return super.getProductImg();
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
}
