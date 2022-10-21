package exercise.shoppingSpree;

public class Product {
    private String name;
    private double cost;

    public Product(String name, double cost) {
        this.setName(name);
        this.setCost(cost);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        Person.validateName(name);
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    private void setCost(double cost) {
        Person.validatePrice(cost);
        this.cost = cost;
    }
}
