package lection.product;

public class Main {
    public static void main(String[] args) {
        Car bmw = new CarBuilderFacade()
                .carInfo()
                    .withType("BMW")
                    .withColor("Black")
                    .withNumberOfDoors(5)
                .placeBuilt()
                    .inCity("Leipzig")
                    .atAddress("Random Street 234")
                .build();

        System.out.println(bmw);
    }
}
