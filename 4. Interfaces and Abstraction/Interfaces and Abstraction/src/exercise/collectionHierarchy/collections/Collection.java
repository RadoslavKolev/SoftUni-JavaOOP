package exercise.collectionHierarchy.collections;

import java.util.ArrayList;
import java.util.List;

public abstract class Collection {
    protected int maxSize;
    protected List<String> items;

    protected Collection() {
        this.maxSize = 100;
        this.items = new ArrayList<>();
    }
}
