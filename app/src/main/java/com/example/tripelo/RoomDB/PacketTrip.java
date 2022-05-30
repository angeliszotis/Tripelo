package com.example.tripelo.RoomDB;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "pt",
        primaryKeys = {"kwdikos","kwd_ta","kwd_trip"},
        foreignKeys = {
        @ForeignKey(entity = TravelAgency.class,
                parentColumns = "kwdikos",
                childColumns = "kwd_ta",
                onDelete = ForeignKey.CASCADE,
                onUpdate = ForeignKey.CASCADE),
                @ForeignKey(entity = SuggestTrip.class,
                        parentColumns = "kwdikos",
                        childColumns = "kwd_trip",
                        onDelete = ForeignKey.CASCADE,
                        onUpdate = ForeignKey.CASCADE )
        }
)
public class PacketTrip {

    @ColumnInfo()
    public int kwdikos;

    @ColumnInfo(name = "kwd_ta") @NonNull
    public int kwd_travel_agency;

    @ColumnInfo(name = "kwd_trip") @NonNull
    public int kwd_trip;

    @ColumnInfo(name = "time_to_start") @NonNull
    public String time_to_start;

    @ColumnInfo(name = "price")
    public String price;

    //CONSTRACTORS


    public PacketTrip() {
    }

    public PacketTrip(String time_to_start, String price) {

        this.time_to_start = time_to_start;
        this.price = price;
    }

    //GETTERS SETTERS


    public int getKwdikos() {
        return kwdikos;
    }

    public void setKwdikos(int kwdikos) {
        this.kwdikos = kwdikos;
    }

    public int getKwd_travel_agency() {
        return kwd_travel_agency;
    }

    public void setKwd_travel_agency(int kwd_travel_agency) {
        this.kwd_travel_agency = kwd_travel_agency;
    }

    public int getKwd_trip() {
        return kwd_trip;
    }

    public void setKwd_trip(int kwd_trip) {
        this.kwd_trip = kwd_trip;
    }

    @NonNull
    public String getTime_to_start() {
        return time_to_start;
    }

    public void setTime_to_start(@NonNull String time_to_start) {
        this.time_to_start = time_to_start;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
