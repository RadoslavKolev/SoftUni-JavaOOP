package exercise.harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class Main {
	private final static Function<Field, String> FORMAT_FUNCTION =
			field -> String.format("%s %s %s",
			Modifier.toString(field.getModifiers()),
			field.getType().getSimpleName(),
			field.getName());

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Field[] fields = RichSoilLand.class.getDeclaredFields();

		String modifier = scanner.nextLine();

		while (!modifier.equals("HARVEST")) {
			printSpecifiedFields(fields, modifier);
			modifier = scanner.nextLine();
		}
	}

	private static void printSpecifiedFields(Field[] fields, String modifier) {
		Arrays.stream(fields)
				.filter(field ->
						Modifier.toString(field.getModifiers()).equals(modifier) ||
						modifier.equals("all"))
				.map(FORMAT_FUNCTION)
				.forEach(System.out::println);
	}
}
