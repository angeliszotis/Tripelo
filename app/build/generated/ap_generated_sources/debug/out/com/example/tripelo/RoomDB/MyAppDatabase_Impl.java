package com.example.tripelo.RoomDB;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MyAppDatabase_Impl extends MyAppDatabase {
  private volatile myDao _myDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `pt` (`kwdikos` INTEGER NOT NULL, `kwd_ta` INTEGER NOT NULL, `kwd_trip` INTEGER NOT NULL, `time_to_start` TEXT NOT NULL, `price` TEXT, PRIMARY KEY(`kwdikos`, `kwd_ta`, `kwd_trip`), FOREIGN KEY(`kwd_ta`) REFERENCES `ta`(`kwdikos`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`kwd_trip`) REFERENCES `st`(`kwdikos`) ON UPDATE CASCADE ON DELETE CASCADE )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `st` (`kwdikos` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `city` TEXT, `country` TEXT, `time` TEXT, `type` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `ta` (`kwdikos` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `ta_name` TEXT, `ta_street` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'af37a3ca19f206f9bdb97a32dd845045')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `pt`");
        _db.execSQL("DROP TABLE IF EXISTS `st`");
        _db.execSQL("DROP TABLE IF EXISTS `ta`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        _db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsPt = new HashMap<String, TableInfo.Column>(5);
        _columnsPt.put("kwdikos", new TableInfo.Column("kwdikos", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPt.put("kwd_ta", new TableInfo.Column("kwd_ta", "INTEGER", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPt.put("kwd_trip", new TableInfo.Column("kwd_trip", "INTEGER", true, 3, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPt.put("time_to_start", new TableInfo.Column("time_to_start", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPt.put("price", new TableInfo.Column("price", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPt = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysPt.add(new TableInfo.ForeignKey("ta", "CASCADE", "CASCADE",Arrays.asList("kwd_ta"), Arrays.asList("kwdikos")));
        _foreignKeysPt.add(new TableInfo.ForeignKey("st", "CASCADE", "CASCADE",Arrays.asList("kwd_trip"), Arrays.asList("kwdikos")));
        final HashSet<TableInfo.Index> _indicesPt = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPt = new TableInfo("pt", _columnsPt, _foreignKeysPt, _indicesPt);
        final TableInfo _existingPt = TableInfo.read(_db, "pt");
        if (! _infoPt.equals(_existingPt)) {
          return new RoomOpenHelper.ValidationResult(false, "pt(com.example.tripelo.RoomDB.PacketTrip).\n"
                  + " Expected:\n" + _infoPt + "\n"
                  + " Found:\n" + _existingPt);
        }
        final HashMap<String, TableInfo.Column> _columnsSt = new HashMap<String, TableInfo.Column>(5);
        _columnsSt.put("kwdikos", new TableInfo.Column("kwdikos", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSt.put("city", new TableInfo.Column("city", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSt.put("country", new TableInfo.Column("country", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSt.put("time", new TableInfo.Column("time", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSt.put("type", new TableInfo.Column("type", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSt = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSt = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSt = new TableInfo("st", _columnsSt, _foreignKeysSt, _indicesSt);
        final TableInfo _existingSt = TableInfo.read(_db, "st");
        if (! _infoSt.equals(_existingSt)) {
          return new RoomOpenHelper.ValidationResult(false, "st(com.example.tripelo.RoomDB.SuggestTrip).\n"
                  + " Expected:\n" + _infoSt + "\n"
                  + " Found:\n" + _existingSt);
        }
        final HashMap<String, TableInfo.Column> _columnsTa = new HashMap<String, TableInfo.Column>(3);
        _columnsTa.put("kwdikos", new TableInfo.Column("kwdikos", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTa.put("ta_name", new TableInfo.Column("ta_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTa.put("ta_street", new TableInfo.Column("ta_street", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTa = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTa = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTa = new TableInfo("ta", _columnsTa, _foreignKeysTa, _indicesTa);
        final TableInfo _existingTa = TableInfo.read(_db, "ta");
        if (! _infoTa.equals(_existingTa)) {
          return new RoomOpenHelper.ValidationResult(false, "ta(com.example.tripelo.RoomDB.TravelAgency).\n"
                  + " Expected:\n" + _infoTa + "\n"
                  + " Found:\n" + _existingTa);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "af37a3ca19f206f9bdb97a32dd845045", "b3039cc02beea3fc198bb22427dbd76f");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "pt","st","ta");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `pt`");
      _db.execSQL("DELETE FROM `st`");
      _db.execSQL("DELETE FROM `ta`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(myDao.class, myDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public myDao mydao() {
    if (_myDao != null) {
      return _myDao;
    } else {
      synchronized(this) {
        if(_myDao == null) {
          _myDao = new myDao_Impl(this);
        }
        return _myDao;
      }
    }
  }
}
