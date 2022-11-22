package lection;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class InstockTest {
    private Instock instock;

    @Before
    public void setUp() {
        this.instock = new Instock();
    }

    @Test
    public void test_Count_ShouldBeZero_WhenInstockIsEmpty() {
        assertEquals(0, instock.getCount());
    }

    @Test
    public void test_Count_ShouldBeFive_WhenInstockHasFiveProducts() {
        int productsCount = 5;
        addProducts(productsCount);
        assertEquals(productsCount, instock.getCount());
    }

    @Test
    public void test_Contains_ShouldBeTrue_WhenProduct_IsPresent() {
        Product product = addProducts(5)[3];
        assertTrue(this.instock.contains(product));
    }

    @Test
    public void test_Contains_ShouldBeFalse_WhenNoSuchProduct_IsPresent() {
        addProducts(5);
        assertFalse(this.instock.contains(new Product("Apple", 0.80, 60)));
    }

    @Test
    public void test_Find_ReturnsTheCorrectProduct() {
        Product expected = addProducts(10)[4];
        Product actual = this.instock.find(4);
        assertNotNull(actual);  // actual always returns null
        assertEquals(expected.getLabel(), actual.getLabel());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test_Find_ThrowsException_WhenPassingInvalidIndex() {
        addProducts(2);
        this.instock.find(this.instock.getCount());
    }

    @Test
    public void test_ChangeQuantity_ShouldUpdateTheProduct() {
        Product product = new Product("Apple", 0.80, 60);
        this.instock.add(product);

        int expectedQuantity = product.getQuantity() - 10;
        this.instock.changeQuantity(product.getLabel(), expectedQuantity);

        assertEquals(expectedQuantity, product.getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_ChangeQuantity_ThrowsException_WhenNoSuchProductIsFound() {
        this.instock.changeQuantity("NoSuchProduct", 10);
    }

    @Test
    public void test_FindByLabel_ReturnsTheCorrectProduct() {
        Product expected = addProducts(10)[4];
        Product actual = this.instock.findByLabel(expected.getLabel());
        assertNotNull(actual);  // actual always returns null
        assertEquals(expected.getLabel(), actual.getLabel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_FindByLabel_ThrowsException_WhenPassingInvalidIndex() {
        this.instock.findByLabel("NoSuchProduct");
    }

    @Test
    public void test_FindFirstMostExpensiveProducts_ShouldReturnTheCorrectProducts() {
        int productsToTake = 10;

        List<Product> expected = Arrays.stream(addProducts(20))
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .limit(productsToTake)
                .toList();

        Iterable<Product> iterable = this.instock.findFirstMostExpensiveProducts(productsToTake);
        List<Product> actual = assertIterableNotNullAndConvertToList(iterable);

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_FindFirstMostExpensiveProducts_ThrowsException_WhenThereAreLessProducts() {
        addProducts(10);
        this.instock.findFirstMostExpensiveProducts(11);
    }

    private List<Product> assertIterableNotNullAndConvertToList(Iterable<Product> iterable) {
        assertNotNull(iterable);
        List<Product> products = new ArrayList<>();
        iterable.forEach(products::add);
        return products;
    }

    private Product[] addProducts(int count) {
        Product[] arr = new Product[count];

        for (int i = 1; i <= count; i++) {
            Product product = new Product("Product " + i, 10.00 + i, i);
            this.instock.add(product);
            arr[i - 1] = product;
        }

        return arr;
    }
}