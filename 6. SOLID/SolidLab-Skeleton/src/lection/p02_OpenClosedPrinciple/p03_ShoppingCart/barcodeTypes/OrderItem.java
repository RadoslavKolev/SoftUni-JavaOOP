package lection.p02_OpenClosedPrinciple.p03_ShoppingCart.barcodeTypes;

public abstract class OrderItem {
    private String barcode;
    private int quantity;

    public String getBarcode() {
        return this.barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public abstract double getItemPrice();
}
