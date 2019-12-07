package maymanm.drugsapp.model.changepassword;

import java.util.ArrayList;

/**
 * Created by MahmoudAyman on 11/16/2019.
 **/
public class PhoneCodeItem {

    public PhoneCodeItem(int id, String code) {
        this.id = id;
        this.code = code;
    }

    private int id;
    private String code;

    public PhoneCodeItem() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ArrayList<PhoneCodeItem> getList(){
        ArrayList<PhoneCodeItem> list = new ArrayList<>();
        list.add(new PhoneCodeItem(1,"+2"));
        list.add(new PhoneCodeItem(1,"+971"));
        list.add(new PhoneCodeItem(1,"+964"));
        list.add(new PhoneCodeItem(1,"+965"));
        return list;
    }

}
