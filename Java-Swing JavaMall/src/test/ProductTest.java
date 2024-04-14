package test;
import static org.junit.Assert.assertEquals;

import Model.LexusDTO;
import Model.SuvDTO;
import org.junit.Test;
public class ProductTest {
    @Test
    public void testProduct() {
        LexusDTO product = new SuvDTO(1, "Lexus SUV", "suv.jpg", "new", 2024, "NX", "Black");
        assertEquals(1, product.getProductId());
        assertEquals("Lexus SUV", product.getProductName());
        assertEquals("suv.jpg", product.getProductImg());
        assertEquals("new", product.getProductState());
        assertEquals(2024, product.getYear());
        assertEquals("NX", product.getModel());
        assertEquals("Black", product.getColor());
    }
}