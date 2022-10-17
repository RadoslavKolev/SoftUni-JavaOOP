package lection.hotelReservation;

public enum Discount {
    None(0),
    SecondVisit(10),
    VIP(20);

    private final int value;

    Discount(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
