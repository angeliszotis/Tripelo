package com.example.tripelo.RoomDB;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class myDao_Impl implements myDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<TravelAgency> __insertionAdapterOfTravelAgency;

  private final EntityInsertionAdapter<SuggestTrip> __insertionAdapterOfSuggestTrip;

  private final EntityInsertionAdapter<PacketTrip> __insertionAdapterOfPacketTrip;

  private final EntityDeletionOrUpdateAdapter<TravelAgency> __deletionAdapterOfTravelAgency;

  private final EntityDeletionOrUpdateAdapter<SuggestTrip> __deletionAdapterOfSuggestTrip;

  private final EntityDeletionOrUpdateAdapter<PacketTrip> __deletionAdapterOfPacketTrip;

  private final EntityDeletionOrUpdateAdapter<TravelAgency> __updateAdapterOfTravelAgency;

  private final EntityDeletionOrUpdateAdapter<SuggestTrip> __updateAdapterOfSuggestTrip;

  private final EntityDeletionOrUpdateAdapter<PacketTrip> __updateAdapterOfPacketTrip;

  public myDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTravelAgency = new EntityInsertionAdapter<TravelAgency>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `ta` (`kwdikos`,`ta_name`,`ta_street`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TravelAgency value) {
        stmt.bindLong(1, value.kwdikos);
        if (value.travel_agency_name == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.travel_agency_name);
        }
        if (value.travel_agency_street == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.travel_agency_street);
        }
      }
    };
    this.__insertionAdapterOfSuggestTrip = new EntityInsertionAdapter<SuggestTrip>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `st` (`kwdikos`,`city`,`country`,`time`,`type`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SuggestTrip value) {
        stmt.bindLong(1, value.kwdikos);
        if (value.city == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.city);
        }
        if (value.country == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.country);
        }
        if (value.time == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.time);
        }
        if (value.type == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.type);
        }
      }
    };
    this.__insertionAdapterOfPacketTrip = new EntityInsertionAdapter<PacketTrip>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `pt` (`kwdikos`,`kwd_ta`,`kwd_trip`,`time_to_start`,`price`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PacketTrip value) {
        stmt.bindLong(1, value.kwdikos);
        stmt.bindLong(2, value.kwd_travel_agency);
        stmt.bindLong(3, value.kwd_trip);
        if (value.time_to_start == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.time_to_start);
        }
        if (value.price == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.price);
        }
      }
    };
    this.__deletionAdapterOfTravelAgency = new EntityDeletionOrUpdateAdapter<TravelAgency>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `ta` WHERE `kwdikos` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TravelAgency value) {
        stmt.bindLong(1, value.kwdikos);
      }
    };
    this.__deletionAdapterOfSuggestTrip = new EntityDeletionOrUpdateAdapter<SuggestTrip>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `st` WHERE `kwdikos` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SuggestTrip value) {
        stmt.bindLong(1, value.kwdikos);
      }
    };
    this.__deletionAdapterOfPacketTrip = new EntityDeletionOrUpdateAdapter<PacketTrip>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `pt` WHERE `kwdikos` = ? AND `kwd_ta` = ? AND `kwd_trip` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PacketTrip value) {
        stmt.bindLong(1, value.kwdikos);
        stmt.bindLong(2, value.kwd_travel_agency);
        stmt.bindLong(3, value.kwd_trip);
      }
    };
    this.__updateAdapterOfTravelAgency = new EntityDeletionOrUpdateAdapter<TravelAgency>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `ta` SET `kwdikos` = ?,`ta_name` = ?,`ta_street` = ? WHERE `kwdikos` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TravelAgency value) {
        stmt.bindLong(1, value.kwdikos);
        if (value.travel_agency_name == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.travel_agency_name);
        }
        if (value.travel_agency_street == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.travel_agency_street);
        }
        stmt.bindLong(4, value.kwdikos);
      }
    };
    this.__updateAdapterOfSuggestTrip = new EntityDeletionOrUpdateAdapter<SuggestTrip>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `st` SET `kwdikos` = ?,`city` = ?,`country` = ?,`time` = ?,`type` = ? WHERE `kwdikos` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SuggestTrip value) {
        stmt.bindLong(1, value.kwdikos);
        if (value.city == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.city);
        }
        if (value.country == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.country);
        }
        if (value.time == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.time);
        }
        if (value.type == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.type);
        }
        stmt.bindLong(6, value.kwdikos);
      }
    };
    this.__updateAdapterOfPacketTrip = new EntityDeletionOrUpdateAdapter<PacketTrip>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `pt` SET `kwdikos` = ?,`kwd_ta` = ?,`kwd_trip` = ?,`time_to_start` = ?,`price` = ? WHERE `kwdikos` = ? AND `kwd_ta` = ? AND `kwd_trip` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PacketTrip value) {
        stmt.bindLong(1, value.kwdikos);
        stmt.bindLong(2, value.kwd_travel_agency);
        stmt.bindLong(3, value.kwd_trip);
        if (value.time_to_start == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.time_to_start);
        }
        if (value.price == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.price);
        }
        stmt.bindLong(6, value.kwdikos);
        stmt.bindLong(7, value.kwd_travel_agency);
        stmt.bindLong(8, value.kwd_trip);
      }
    };
  }

  @Override
  public void addTA(final TravelAgency ta) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTravelAgency.insert(ta);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void addST(final SuggestTrip st) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfSuggestTrip.insert(st);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void addPT(final PacketTrip pt) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfPacketTrip.insert(pt);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteTA(final TravelAgency ta) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfTravelAgency.handle(ta);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteST(final SuggestTrip st) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfSuggestTrip.handle(st);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deletePT(final PacketTrip pt) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfPacketTrip.handle(pt);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateTA(final TravelAgency ta) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfTravelAgency.handle(ta);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateST(final SuggestTrip st) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfSuggestTrip.handle(st);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updatePT(final PacketTrip pt) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfPacketTrip.handle(pt);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Integer> getLastRecordTA() {
    final String _sql = "SELECT kwdikos FROM ta ORDER BY kwdikos DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final List<Integer> _result = new ArrayList<Integer>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Integer _item;
        if (_cursor.isNull(0)) {
          _item = null;
        } else {
          _item = _cursor.getInt(0);
        }
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<TravelAgency> getAllTA() {
    final String _sql = "SELECT * FROM ta";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfKwdikos = CursorUtil.getColumnIndexOrThrow(_cursor, "kwdikos");
      final int _cursorIndexOfTravelAgencyName = CursorUtil.getColumnIndexOrThrow(_cursor, "ta_name");
      final int _cursorIndexOfTravelAgencyStreet = CursorUtil.getColumnIndexOrThrow(_cursor, "ta_street");
      final List<TravelAgency> _result = new ArrayList<TravelAgency>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final TravelAgency _item;
        _item = new TravelAgency();
        _item.kwdikos = _cursor.getInt(_cursorIndexOfKwdikos);
        if (_cursor.isNull(_cursorIndexOfTravelAgencyName)) {
          _item.travel_agency_name = null;
        } else {
          _item.travel_agency_name = _cursor.getString(_cursorIndexOfTravelAgencyName);
        }
        if (_cursor.isNull(_cursorIndexOfTravelAgencyStreet)) {
          _item.travel_agency_street = null;
        } else {
          _item.travel_agency_street = _cursor.getString(_cursorIndexOfTravelAgencyStreet);
        }
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<TravelAgency> getDataTA(final int id) {
    final String _sql = "SELECT * FROM ta WHERE kwdikos = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfKwdikos = CursorUtil.getColumnIndexOrThrow(_cursor, "kwdikos");
      final int _cursorIndexOfTravelAgencyName = CursorUtil.getColumnIndexOrThrow(_cursor, "ta_name");
      final int _cursorIndexOfTravelAgencyStreet = CursorUtil.getColumnIndexOrThrow(_cursor, "ta_street");
      final List<TravelAgency> _result = new ArrayList<TravelAgency>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final TravelAgency _item;
        _item = new TravelAgency();
        _item.kwdikos = _cursor.getInt(_cursorIndexOfKwdikos);
        if (_cursor.isNull(_cursorIndexOfTravelAgencyName)) {
          _item.travel_agency_name = null;
        } else {
          _item.travel_agency_name = _cursor.getString(_cursorIndexOfTravelAgencyName);
        }
        if (_cursor.isNull(_cursorIndexOfTravelAgencyStreet)) {
          _item.travel_agency_street = null;
        } else {
          _item.travel_agency_street = _cursor.getString(_cursorIndexOfTravelAgencyStreet);
        }
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Integer> getLastRecordST() {
    final String _sql = "SELECT kwdikos FROM st ORDER BY kwdikos DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final List<Integer> _result = new ArrayList<Integer>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Integer _item;
        if (_cursor.isNull(0)) {
          _item = null;
        } else {
          _item = _cursor.getInt(0);
        }
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<SuggestTrip> getAllSuggestTrip() {
    final String _sql = "SELECT * FROM st";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfKwdikos = CursorUtil.getColumnIndexOrThrow(_cursor, "kwdikos");
      final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "city");
      final int _cursorIndexOfCountry = CursorUtil.getColumnIndexOrThrow(_cursor, "country");
      final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final List<SuggestTrip> _result = new ArrayList<SuggestTrip>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final SuggestTrip _item;
        _item = new SuggestTrip();
        _item.kwdikos = _cursor.getInt(_cursorIndexOfKwdikos);
        if (_cursor.isNull(_cursorIndexOfCity)) {
          _item.city = null;
        } else {
          _item.city = _cursor.getString(_cursorIndexOfCity);
        }
        if (_cursor.isNull(_cursorIndexOfCountry)) {
          _item.country = null;
        } else {
          _item.country = _cursor.getString(_cursorIndexOfCountry);
        }
        if (_cursor.isNull(_cursorIndexOfTime)) {
          _item.time = null;
        } else {
          _item.time = _cursor.getString(_cursorIndexOfTime);
        }
        if (_cursor.isNull(_cursorIndexOfType)) {
          _item.type = null;
        } else {
          _item.type = _cursor.getString(_cursorIndexOfType);
        }
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<SuggestTrip> getDataST(final int id) {
    final String _sql = "SELECT * FROM st WHERE kwdikos = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfKwdikos = CursorUtil.getColumnIndexOrThrow(_cursor, "kwdikos");
      final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "city");
      final int _cursorIndexOfCountry = CursorUtil.getColumnIndexOrThrow(_cursor, "country");
      final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final List<SuggestTrip> _result = new ArrayList<SuggestTrip>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final SuggestTrip _item;
        _item = new SuggestTrip();
        _item.kwdikos = _cursor.getInt(_cursorIndexOfKwdikos);
        if (_cursor.isNull(_cursorIndexOfCity)) {
          _item.city = null;
        } else {
          _item.city = _cursor.getString(_cursorIndexOfCity);
        }
        if (_cursor.isNull(_cursorIndexOfCountry)) {
          _item.country = null;
        } else {
          _item.country = _cursor.getString(_cursorIndexOfCountry);
        }
        if (_cursor.isNull(_cursorIndexOfTime)) {
          _item.time = null;
        } else {
          _item.time = _cursor.getString(_cursorIndexOfTime);
        }
        if (_cursor.isNull(_cursorIndexOfType)) {
          _item.type = null;
        } else {
          _item.type = _cursor.getString(_cursorIndexOfType);
        }
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Integer> getLastRecordPT() {
    final String _sql = "SELECT kwdikos FROM pt ORDER BY kwdikos DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final List<Integer> _result = new ArrayList<Integer>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Integer _item;
        if (_cursor.isNull(0)) {
          _item = null;
        } else {
          _item = _cursor.getInt(0);
        }
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<PacketTrip> getAllPacketTrip() {
    final String _sql = "SELECT * FROM pt";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfKwdikos = CursorUtil.getColumnIndexOrThrow(_cursor, "kwdikos");
      final int _cursorIndexOfKwdTravelAgency = CursorUtil.getColumnIndexOrThrow(_cursor, "kwd_ta");
      final int _cursorIndexOfKwdTrip = CursorUtil.getColumnIndexOrThrow(_cursor, "kwd_trip");
      final int _cursorIndexOfTimeToStart = CursorUtil.getColumnIndexOrThrow(_cursor, "time_to_start");
      final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price");
      final List<PacketTrip> _result = new ArrayList<PacketTrip>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final PacketTrip _item;
        _item = new PacketTrip();
        _item.kwdikos = _cursor.getInt(_cursorIndexOfKwdikos);
        _item.kwd_travel_agency = _cursor.getInt(_cursorIndexOfKwdTravelAgency);
        _item.kwd_trip = _cursor.getInt(_cursorIndexOfKwdTrip);
        if (_cursor.isNull(_cursorIndexOfTimeToStart)) {
          _item.time_to_start = null;
        } else {
          _item.time_to_start = _cursor.getString(_cursorIndexOfTimeToStart);
        }
        if (_cursor.isNull(_cursorIndexOfPrice)) {
          _item.price = null;
        } else {
          _item.price = _cursor.getString(_cursorIndexOfPrice);
        }
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<PacketTrip> getDataPT(final int id) {
    final String _sql = "SELECT * FROM pt WHERE kwdikos = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfKwdikos = CursorUtil.getColumnIndexOrThrow(_cursor, "kwdikos");
      final int _cursorIndexOfKwdTravelAgency = CursorUtil.getColumnIndexOrThrow(_cursor, "kwd_ta");
      final int _cursorIndexOfKwdTrip = CursorUtil.getColumnIndexOrThrow(_cursor, "kwd_trip");
      final int _cursorIndexOfTimeToStart = CursorUtil.getColumnIndexOrThrow(_cursor, "time_to_start");
      final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price");
      final List<PacketTrip> _result = new ArrayList<PacketTrip>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final PacketTrip _item;
        _item = new PacketTrip();
        _item.kwdikos = _cursor.getInt(_cursorIndexOfKwdikos);
        _item.kwd_travel_agency = _cursor.getInt(_cursorIndexOfKwdTravelAgency);
        _item.kwd_trip = _cursor.getInt(_cursorIndexOfKwdTrip);
        if (_cursor.isNull(_cursorIndexOfTimeToStart)) {
          _item.time_to_start = null;
        } else {
          _item.time_to_start = _cursor.getString(_cursorIndexOfTimeToStart);
        }
        if (_cursor.isNull(_cursorIndexOfPrice)) {
          _item.price = null;
        } else {
          _item.price = _cursor.getString(_cursorIndexOfPrice);
        }
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<ResultStringInt> recycleHome() {
    final String _sql = "SELECT DISTINCT pt.time_to_start as time , pt.price as price , pt.kwdikos as id, st.city as title  FROM pt INNER JOIN st ON kwd_trip = st.kwdikos ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTime = 0;
      final int _cursorIndexOfPrice = 1;
      final int _cursorIndexOfId = 2;
      final int _cursorIndexOfTitle = 3;
      final List<ResultStringInt> _result = new ArrayList<ResultStringInt>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ResultStringInt _item;
        _item = new ResultStringInt();
        final String _tmpTime;
        if (_cursor.isNull(_cursorIndexOfTime)) {
          _tmpTime = null;
        } else {
          _tmpTime = _cursor.getString(_cursorIndexOfTime);
        }
        _item.setTime(_tmpTime);
        final String _tmpPrice;
        if (_cursor.isNull(_cursorIndexOfPrice)) {
          _tmpPrice = null;
        } else {
          _tmpPrice = _cursor.getString(_cursorIndexOfPrice);
        }
        _item.setPrice(_tmpPrice);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpTitle;
        if (_cursor.isNull(_cursorIndexOfTitle)) {
          _tmpTitle = null;
        } else {
          _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        }
        _item.setTitle(_tmpTitle);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<ResultStringInt> bringjoin(final int id) {
    final String _sql = "SELECT DISTINCT pt.time_to_start as time , pt.price as price , pt.kwdikos as id, st.city as title  FROM pt INNER JOIN st ON kwd_trip = st.kwdikos WHERE pt.kwdikos = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTime = 0;
      final int _cursorIndexOfPrice = 1;
      final int _cursorIndexOfId = 2;
      final int _cursorIndexOfTitle = 3;
      final List<ResultStringInt> _result = new ArrayList<ResultStringInt>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ResultStringInt _item;
        _item = new ResultStringInt();
        final String _tmpTime;
        if (_cursor.isNull(_cursorIndexOfTime)) {
          _tmpTime = null;
        } else {
          _tmpTime = _cursor.getString(_cursorIndexOfTime);
        }
        _item.setTime(_tmpTime);
        final String _tmpPrice;
        if (_cursor.isNull(_cursorIndexOfPrice)) {
          _tmpPrice = null;
        } else {
          _tmpPrice = _cursor.getString(_cursorIndexOfPrice);
        }
        _item.setPrice(_tmpPrice);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpTitle;
        if (_cursor.isNull(_cursorIndexOfTitle)) {
          _tmpTitle = null;
        } else {
          _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        }
        _item.setTitle(_tmpTitle);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
