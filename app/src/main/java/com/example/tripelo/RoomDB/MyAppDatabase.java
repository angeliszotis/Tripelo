package com.example.tripelo.RoomDB;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {PacketTrip.class, SuggestTrip.class, TravelAgency.class}, version = 1)
public abstract class MyAppDatabase extends RoomDatabase {

    public abstract myDao mydao();

}
