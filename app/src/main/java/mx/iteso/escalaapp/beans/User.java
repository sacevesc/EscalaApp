package mx.iteso.escalaapp.beans;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by aceve on 08/03/2018.
 */

public class User implements Parcelable {
    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
    private String name;
    private String password;
    private boolean islogged;

    public User() {
    }

    protected User(Parcel in) {
        this.name = in.readString();
        this.password = in.readString();
        this.islogged = (boolean) in.readValue(boolean.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.password);
        dest.writeValue(this.islogged);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getIslogged() {
        return islogged;
    }

    public void setIslogged(boolean islogged) {
        this.islogged = islogged;
    }
}
