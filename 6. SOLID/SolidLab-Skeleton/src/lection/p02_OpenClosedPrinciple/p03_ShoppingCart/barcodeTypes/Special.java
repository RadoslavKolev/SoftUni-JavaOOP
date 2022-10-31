package lection.p02_OpenClosedPrinciple.p03_ShoppingCart.barcodeTypes;

public class Special extends OrderItem {
    @Override
    public double getItemPrice() {
        double total = this.getQuantity() * 4.0;
        int setsOfThree = this.getQuantity() / 3;
        total -= setsOfThree * 2.0;
        return total;
    }
}
