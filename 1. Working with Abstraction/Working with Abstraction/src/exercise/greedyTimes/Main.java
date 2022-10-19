
package exercise.greedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] itemTypes = scanner.nextLine().split("\\s+");

        var bag = new LinkedHashMap<String, LinkedHashMap<String, Long>>();

        long gold = 0;
        long stone = 0;
        long money = 0;

        for (int i = 0; i < itemTypes.length; i += 2) {
            String itemTypeName = itemTypes[i];
            long quantity = Long.parseLong(itemTypes[i + 1]);

            String itemType = "";

            if (itemTypeName.length() == 3) {
                itemType = "Cash";
            } else if (itemTypeName.toLowerCase().endsWith("gem")) {
                itemType = "Gem";
            } else if (itemTypeName.toLowerCase().equals("gold")) {
                itemType = "Gold";
            }

            if (itemType.equals("") ||
                    bagCapacity < bag.values().stream()
                    .map(Map::values)
                    .flatMap(Collection::stream)
                    .mapToLong(e -> e)
                    .sum() + quantity) {
                continue;
            }

            switch (itemType) {
                case "Gem":
                    if (!bag.containsKey(itemType)) {
                        if (bag.containsKey("Gold")) {
                            if (quantity > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(itemType).values().stream().mapToLong(e -> e).sum() + quantity > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!bag.containsKey(itemType)) {
                        if (bag.containsKey("Gem")) {
                            if (quantity > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(itemType).values().stream().mapToLong(e -> e).sum() + quantity > bag.get("Gem").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
            }

            if (!bag.containsKey(itemType)) {
                bag.put((itemType), new LinkedHashMap<String, Long>());
            }

            if (!bag.get(itemType).containsKey(itemTypeName)) {
                bag.get(itemType).put(itemTypeName, 0L);
            }


            bag.get(itemType).put(itemTypeName, bag.get(itemType).get(itemTypeName) + quantity);
            if (itemType.equals("Gold")) {
                gold += quantity;
            } else if (itemType.equals("Gem")) {
                stone += quantity;
            } else if (itemType.equals("Cash")) {
                money += quantity;
            }
        }

        for (var x : bag.entrySet()) {
            Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.println(String.format("<%s> $%s", x.getKey(), sumValues));

            x.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }
}