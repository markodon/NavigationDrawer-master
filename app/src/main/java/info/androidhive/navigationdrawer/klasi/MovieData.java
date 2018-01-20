package info.androidhive.navigationdrawer.klasi;

import java.io.Serializable;

/**
 * Created by Anti on 1/18/2018.
 */

public class MovieData implements Serializable {

   String Title;
   int Year;
   int imdbID;
   String Type;
   String Poster;

    public MovieData(String title, int year, int imdbID, String type, String poster) {
        Title = title;
        Year = year;
        this.imdbID = imdbID;
        Type = type;
        Poster = poster;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public int getImdbID() {
        return imdbID;
    }

    public void setImdbID(int imdbID) {
        this.imdbID = imdbID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }
}
