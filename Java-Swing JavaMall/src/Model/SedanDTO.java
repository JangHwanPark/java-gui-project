package Model;

public class SedanDTO extends LexusDTO {
    public SedanDTO(int productId, String productName, String productImg, String productState, int year, String model, String color) {
        super(productId, productName, productImg, productState, year, model, color);
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

    @Override
    public void setModel(String model) {
        super.setModel(model);
    }

    @Override
    public String getModel() {
        return super.getModel();
    }

    @Override
    public void setColor(String color) {
        super.setColor(color);
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public void setYear(int year) {
        super.setYear(year);
    }

    @Override
    public int getYear() {
        return super.getYear();
    }
}
