package e.localadmin.supplydrop;

public class Item {

    private String name = "";
    private boolean requested =false;

    public Item(String names) {
        name = names;
    }

    public String getName() {
        return name;
    }
}
