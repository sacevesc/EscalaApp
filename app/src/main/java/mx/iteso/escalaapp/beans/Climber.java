package mx.iteso.escalaapp.beans;

import android.graphics.drawable.Drawable;

/**
 * Created by aceve on 03/03/2018.
 */

public class Climber {
    private String firstname;
    private String lastname;
    private Drawable photo;

    public Climber(String firstname, String lastname, Drawable photo) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.photo = photo;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Drawable getPhoto() {
        return photo;
    }

    public void setPhoto(Drawable photo) {
        this.photo = photo;
    }

}
