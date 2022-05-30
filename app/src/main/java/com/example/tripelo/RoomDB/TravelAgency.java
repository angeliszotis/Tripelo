package com.example.tripelo.RoomDB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ta")
public class TravelAgency {

    @PrimaryKey(autoGenerate = true)
    public int kwdikos;

    @ColumnInfo(name = "ta_name")
    public String travel_agency_name;

    @ColumnInfo(name = "ta_street")
    public String travel_agency_street;

    public TravelAgency() {
    }

    public TravelAgency(int kwdikos, String travel_agency_name, String travel_agency_street) {
        this.kwdikos = kwdikos;
        this.travel_agency_name = travel_agency_name;
        this.travel_agency_street = travel_agency_street;
    }

    public int getKwdikos() {
        return kwdikos;
    }

    public void setKwdikos(int kwdikos) {
        this.kwdikos = kwdikos;
    }

    public String getTravel_agency_name() {
        return travel_agency_name;
    }

    public void setTravel_agency_name(String travel_agency_name) {
        this.travel_agency_name = travel_agency_name;
    }

    public String getTravel_agency_street() {
        return travel_agency_street;
    }

    public void setTravel_agency_street(String travel_agency_street) {
        this.travel_agency_street = travel_agency_street;
    }
}
