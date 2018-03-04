package mx.iteso.escalaapp.beans;

import android.graphics.drawable.Drawable;

/**
 * Created by aceve on 03/03/2018.
 */

public class ItemCompetition {
    private String title;
    private String store;
    private String phone;
    private String address;
    private Drawable photo;
    private Drawable store_photo;


    public ItemCompetition(String title, String store, String phone, String address, Drawable photo,Drawable store_photo) {
        this.title = title;
        this.store = store;
        this.phone= phone;
        this.address= address;
        this.photo= photo;
        this.store_photo=store_photo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Drawable getPhoto() {
        return photo;
    }

    public void setPhoto(Drawable photo) {
        this.photo = photo;
    }

    public Drawable getStore_photo() {
        return store_photo;
    }

    public void setStore_photo(Drawable store_photo) {
        this.store_photo = store_photo;
    }

    @Override
    public String toString() {
        return "ItemCompetition{" +
                "title='" + title + '\'' +
                ", store='" + store + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address  +
                '}';
    }
}
