import org.junit.*;

import static org.junit.Assert.*;

public class SkladTests {
    private Sklad sklad;
    private ProductsRuntimeSaver saver;

    @Before
    public void prepareProducts() {
        saver = new ProductsRuntimeSaver();
        saver.products.add(new Product("chair", 10));
        saver.products.add(new Product("table", 5));
        sklad = new Sklad(saver);
    }

    @Test
    public void addProductTest() {
        sklad.createNewProduct("phone", 15);

        assertEquals(3, saver.products.size());
        assertEquals("phone", saver.products.get(2).name);
        assertEquals(15, saver.products.get(2).count);
    }

    @Test
    public void getProductTestSuccess() {
        Product p = sklad.getProduct("table");

        assertNotNull(p);
        assertEquals("table", p.name);
        assertEquals(5, p.count);
    }

    @Test
    public void getProductTestFailed() {
        Product p = sklad.getProduct("phone");
        assertNull(p);
    }

    @Test
    public void deleteProductTest() {
        sklad.deleteProduct("table");

        assertEquals(1, saver.products.size());
    }


}