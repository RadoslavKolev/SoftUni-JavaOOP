package lection.p02_OpenClosedPrinciple.p03_ShoppingCart.barcodeTypes;

public class Each extends OrderItem {
    @Override
    public double getItemPrice() {
        return this.getQuantity() * 5.0;
    }
}
