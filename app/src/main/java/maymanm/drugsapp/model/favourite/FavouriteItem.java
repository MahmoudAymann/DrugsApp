package maymanm.drugsapp.model.favourite;

/**
 * Created by MahmoudAyman on 12/7/2019.
 **/
public class FavouriteItem {

    private int id;
    private String name;
    private int drugId;

    public int getDrugId() {
        return drugId;
    }

    public void setDrugId(int drugId) {
        this.drugId = drugId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
