package exercise.shoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private final List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        validateName(name);
        this.name = name;
    }

    private void setMoney(double money) {
        validatePrice(money);
        this.money = money;
    }

    public void buyProduct(Product product) {
        if (this.money < product.getCost()) {
            throw new RuntimeException(String.format(
                    "%s can't afford %s",
                    this.name, product.getName()
            ));
        }

        this.money -= product.getCost();
        this.products.add(product);
    }

    static void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    static void validatePrice(double number) {
        if (number < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(this.name).append(" - ");

        String productData = this.products.stream()
                .map(Product::getName)
                .collect(Collectors.joining(", "));

        if (productData.isEmpty()) {
            productData = "Nothing bought";
        }

        builder.append(productData);

        return builder.toString();
    }
}
