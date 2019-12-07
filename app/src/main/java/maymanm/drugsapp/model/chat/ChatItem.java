package maymanm.drugsapp.model.chat;

import androidx.annotation.NonNull;

/**
 * Created by MahmoudAyman on 12/7/2019.
 **/
public class ChatItem {
    private int id;
    private String message;
    private int type;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
