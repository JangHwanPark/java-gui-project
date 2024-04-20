package Model;

public abstract class Car extends IProducts{
    private String brand;
    private String model;

    public Car(int productId, String productName, String productImg, String productState,
               String brand, String model) {
        super(productId, productName, productImg, productState);
        this.brand = brand;
        this.model = model;
    }

}
