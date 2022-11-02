package exercise.task1;

import exercise.task1.products.Product;

import java.util.List;

public class CalorieCalculator {
    private static final String SUM_FORMAT = "Sum: %f";
    private static final String AVERAGE_FORMAT = "Average: %f";
    private final Printer printer;

    public CalorieCalculator() {
        this.printer = new Printer();
    }

    public double sum(List<Product> products) {
//        double sum = 0;
//
//        for (Product product : products) {
//            sum += product.getAmountOfCalories();
//        }

//        final double sum = products.stream()
//                .map(Product::getAmountOfCalories)
//                .reduce(0.0, Double::sum);

        final double sum = products.stream()
                .mapToDouble(Product::getAmountOfCalories)
                .sum();

        this.printer.print(SUM_FORMAT, sum);

        return sum;
    }

    public double average(List<Product> products) {
        final double result = sum(products) / products.size();
        this.printer.print(AVERAGE_FORMAT, result);
        return result;
    }
}
