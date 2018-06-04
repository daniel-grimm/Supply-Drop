package e.localadmin.supplydrop;

import java.util.ArrayList;

public class ItemType {

    private String name = "";
    private ArrayList<Item> type;

    public ItemType(String names) {
        name = names;
        type = new ArrayList<>();
    }

    public void addItem(Item item) {
        type.add(item);
    }
}
