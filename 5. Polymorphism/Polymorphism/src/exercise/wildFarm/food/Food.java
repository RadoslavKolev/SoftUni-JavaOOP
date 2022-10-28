package exercise.wildFarm.food;

public abstract class Food {
    private Integer quantity;

    protected Food(Integer quantity) {
        this.setQuantity(quantity);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
