package exercise.collectionHierarchy.collections;

import exercise.collectionHierarchy.interfaces.MyList;

public class MyListImpl extends Collection implements MyList {
    @Override
    public int add(String element) {
        items.add(0, element);
        return 0;
    }

    @Override
    public String remove() {
        return items.remove(0);
    }

    @Override
    public int getUsed() {
        return items.size();
    }
}
