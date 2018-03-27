package mx.iteso.escalaapp.beans;

/**
 * Created by aceve on 04/03/2018.
 */

public class Competition {
    private String comp_name;
    private String gym;
    private String Description;
    private int image;
    private String participants;
    private String date;

    public Competition(String comp_name, String gym, String description, int photo, String participants, String date) {
        this.comp_name = comp_name;
        this.gym = gym;
        Description = description;
        this.image = photo;
        this.participants = participants;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Competition{" +
                "comp_name='" + comp_name + '\'' +
                ", gym='" + gym + '\'' +
                ", Description='" + Description + '\'' +
                ", image=" + image +
                ", participants=" + participants +
                ", date='" + date + '\'' +
                '}';
    }

    public String getComp_name() {
        return comp_name;
    }

    public void setComp_name(String comp_name) {
        this.comp_name = comp_name;
    }

    public String getGym() {
        return gym;
    }

    public void setGym(String gym) {
        this.gym = gym;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

