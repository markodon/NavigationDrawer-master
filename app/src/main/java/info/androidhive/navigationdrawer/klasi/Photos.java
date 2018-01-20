package info.androidhive.navigationdrawer.klasi;

import java.io.Serializable;

/**
 * Created by Anti on 1/16/2018.
 */

public class Photos implements Serializable {

    String image_url;
    int id;
    String name;

    public Photos(String image_url, int id, String name) {
        this.image_url = image_url;
        this.id = id;
        this.name = name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
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
