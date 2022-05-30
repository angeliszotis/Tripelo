package com.example.tripelo.RoomDB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface myDao {


    // ---------------------TravelAgency DAOString

   @Insert
   public void addTA(TravelAgency ta);

    @Query("SELECT kwdikos FROM ta ORDER BY kwdikos DESC LIMIT 1")
    List<Integer>  getLastRecordTA();

    @Query("SELECT * FROM ta")
    List<TravelAgency> getAllTA();

    @Query("SELECT * FROM ta WHERE kwdikos = :id")
    List<TravelAgency> getDataTA(int id);


    @Delete
    void deleteTA(TravelAgency ta);

    @Update
    void updateTA(TravelAgency ta);


    // --------------------suggest trip

    @Insert
    void addST(SuggestTrip st);

    @Query("SELECT kwdikos FROM st ORDER BY kwdikos DESC LIMIT 1")
    List<Integer>  getLastRecordST();

    @Query("SELECT * FROM st")
    List<SuggestTrip> getAllSuggestTrip();

 @Query("SELECT * FROM st WHERE kwdikos = :id")
 List<SuggestTrip> getDataST(int id);

    @Delete
    void deleteST(SuggestTrip st);

    @Update
    void updateST(SuggestTrip st);


    // ----------------- PacketTrip

    @Insert
    void addPT(PacketTrip pt);

    @Query("SELECT kwdikos FROM pt ORDER BY kwdikos DESC LIMIT 1")
    List<Integer>  getLastRecordPT();

    @Query("SELECT * FROM pt")
    List<PacketTrip> getAllPacketTrip();

    @Query("SELECT * FROM pt WHERE kwdikos = :id")
    List<PacketTrip> getDataPT(int id);

    @Delete
    void deletePT(PacketTrip pt);

    @Update
    void updatePT(PacketTrip pt);

    @Query("SELECT DISTINCT pt.time_to_start as time , pt.price as price , pt.kwdikos as id, st.city as title  " +
            "FROM pt INNER JOIN st ON kwd_trip = st.kwdikos ")
    public List<ResultStringInt> recycleHome();

    @Query("SELECT DISTINCT pt.time_to_start as time , pt.price as price , pt.kwdikos as id, st.city as title  " +
            "FROM pt INNER JOIN st ON kwd_trip = st.kwdikos WHERE pt.kwdikos = :id")

    public List<ResultStringInt> bringjoin(int id);


}

