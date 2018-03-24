package mx.iteso.escalaapp.beans;

/**
 * Created by aceve on 03/03/2018.
 */

public class Climber {
    private String firstname;
    private String lastname;
    private String gym;
    private int photo;

    public Climber(String firstname, String lastname, String gym, int photo) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.gym = gym;
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

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getGym() {
        return gym;
    }

    public void setGym(String gym) {
        this.gym = gym;
    }
}
