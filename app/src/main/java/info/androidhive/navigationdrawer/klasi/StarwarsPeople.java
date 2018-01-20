package info.androidhive.navigationdrawer.klasi;

import java.io.Serializable;

/**
 * Created by Marko on 1/19/2018.
 */

public class StarwarsPeople implements Serializable {
    String name;
    String birth_year;
    String films;

    public StarwarsPeople(String name, String birth_year, String films) {
        this.name = name;
        this.birth_year = birth_year;
        this.films = films;
    }

    public String getName() {
        return name;
    }

    public String getBirth_year() {
        return birth_year;
    }

    public String getFilms() {
        return films;
    }
}
