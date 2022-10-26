package exercise.collectionHierarchy;

import exercise.collectionHierarchy.collections.AddCollection;
import exercise.collectionHierarchy.collections.AddRemoveCollection;
import exercise.collectionHierarchy.collections.MyListImpl;
import exercise.collectionHierarchy.interfaces.AddRemovable;
import exercise.collectionHierarchy.interfaces.Addable;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] itemsToAdd = scanner.nextLine().split("\\s+");
        int removeCount = Integer.parseInt(scanner.nextLine());

        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myList = new MyListImpl();

        printAdd(addCollection, itemsToAdd);
        printAdd(addRemoveCollection, itemsToAdd);
        printAdd(myList, itemsToAdd);

        printRemove(addRemoveCollection, removeCount);
        printRemove(myList, removeCount);
    }

    private static void printAdd(Addable collection, String[] items) {
        for (String item : items) {
            System.out.print(collection.add(item) + " ");
        }

        System.out.println();
    }

    private static void printRemove(AddRemovable collection, int counter) {
        for (int i = 0; i < counter; i++) {
            System.out.print(collection.remove() + " ");
        }

        System.out.println();
    }
}
