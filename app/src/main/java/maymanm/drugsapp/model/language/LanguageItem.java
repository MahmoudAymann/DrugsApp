package maymanm.drugsapp.model.language;

import java.util.ArrayList;
import java.util.List;

import maymanm.drugsapp.R;

import static maymanm.drugsapp.util.ApplicationUtil.getString;

public class LanguageItem {

    private int id;
    private String name;


    private LanguageItem(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public LanguageItem() {

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


    public List<? extends LanguageItem> getItems() {
        List<LanguageItem> languageItems = new ArrayList<>();
        languageItems.add(new LanguageItem(1, getString(R.string.kurdish)));
        languageItems.add(new LanguageItem(2, getString(R.string.english)));
        languageItems.add(new LanguageItem(3, getString(R.string.arabic)));
        return languageItems;
    }
}
