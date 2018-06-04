package e.localadmin.supplydrop;

import java.util.ArrayList;

public class Organization {

    private String name = "";
    private ArrayList<Item> itemsOffered;

    public Organization(String names) {
        name = names;
        itemsOffered = new ArrayList<>();
    }

    public void addItem(Item item) {
        itemsOffered.add(item);
    }
}
