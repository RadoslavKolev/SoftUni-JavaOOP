package lection.p02_OpenClosedPrinciple.p03_ShoppingCart.barcodeTypes;

public class Weight extends OrderItem {
    @Override
    public double getItemPrice() {
        return this.getQuantity() * 4.0 / 1000;
    }
}
