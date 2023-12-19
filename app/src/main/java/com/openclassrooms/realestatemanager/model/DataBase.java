package com.openclassrooms.realestatemanager.model;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.openclassrooms.realestatemanager.utils.Utils;
import com.openclassrooms.realestatemanager.dao.PropertyDao;
import com.openclassrooms.realestatemanager.dao.PropertyPictureDao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Property.class, PropertyPicture.class}, version = 1, exportSchema = false)
public abstract class DataBase extends RoomDatabase {

    private static volatile DataBase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    private static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    // --- DAO ---
    public abstract PropertyDao propertyDao();

    public abstract PropertyPictureDao propertyPictureDao();

    public ExecutorService getDatabaseWriteExecutor() {
        return databaseWriteExecutor;
    }

    // --- INSTANCE ---
    public static DataBase getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (Database.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context,
                                    DataBase.class, "DataBase.db")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            databaseWriteExecutor.execute(DataBase::prepopulateDataBase);
        }
    };

    private static void prepopulateDataBase() {
        PropertyDao propertyDao = INSTANCE.propertyDao();
        PropertyPictureDao propertyPictureDao = INSTANCE.propertyPictureDao();
        propertyDao.deleteAll();
        propertyPictureDao.deleteAll();

        Property property1 = new Property(
                "Penthouse",
                "Manhattan",
                9000000,
                280,
                8,
                2,
                4,
                "Beautiful penthouse",
                -1L,
                "",
                "4",
                "Wall St",
                "10005",
                "New York",
                true,
                Utils.getTodayDate(),
                "",
                "Randa");
        Property property2 = new Property(
                "Apartment",
                "Brooklyn",
                700000,
                90,
                4,
                1,
                2,
                "Superb penthouse",
                -1L,
                "",
                "4",
                "Wall St",
                "10005",
                "New York",
                true,
                Utils.getTodayDate(),
                "",
                "Buck");

        Property property3 = new Property(
               "Loft",
                "Manhattan",
                1200000,
                100,
                2,
                1,
                1,
                "Insane loft",
                -1L,
                "",
                "4",
                "Wall St",
                "10005",
                "New York",
                true,
                Utils.getTodayDate(),
                "",
                "Samantha");

        long propertyId1 = propertyDao.insert(property1);
        long propertyId2 = propertyDao.insert(property2);
        long propertyId3 = propertyDao.insert(property3);

        long pictureId1 = propertyPictureDao.insert(new PropertyPicture(propertyId1, "Living room", ""));
        propertyPictureDao.insert(new PropertyPicture(propertyId1, "Bathroom", ""));
        propertyPictureDao.insert(new PropertyPicture(propertyId1, "Bedroom", ""));
        propertyPictureDao.insert(new PropertyPicture(propertyId1, "Bedroom", ""));
        propertyPictureDao.insert(new PropertyPicture(propertyId1, "Bedroom", ""));

        long pictureId2 = propertyPictureDao.insert(new PropertyPicture(propertyId2, "Living room", ""));

        long pictureId3 = propertyPictureDao.insert(new PropertyPicture(propertyId3, "Living room", ""));

    }
}
