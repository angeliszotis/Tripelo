package com.example.tripelo.RoomDB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "st")
public class SuggestTrip {
    @PrimaryKey(autoGenerate = true)
    public int kwdikos;

    @ColumnInfo(name = "city")
    public String city;

    @ColumnInfo(name = "country")
    public String country;

    @ColumnInfo(name = "time")
    public String time;

    @ColumnInfo(name = "type")
    public String type;

    //CONSTRACTORS
    public SuggestTrip() {
    }

    public SuggestTrip(int kwdikos, String city, String country, String time, String type) {
        this.kwdikos = kwdikos;
        this.city = city;
        this.country = country;
        this.time = time;
        this.type = type;
    }

    //SETTERS GETTERS

    public int getKwdikos() {
        return kwdikos;
    }

    public void setKwdikos(int kwdikos) {
        this.kwdikos = kwdikos;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
