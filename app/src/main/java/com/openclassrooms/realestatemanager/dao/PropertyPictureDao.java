package com.openclassrooms.realestatemanager.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.openclassrooms.realestatemanager.model.PropertyPicture;

import java.util.List;
@Dao
public interface PropertyPictureDao {
    @Query("SELECT * FROM PropertyPicture WHERE property_id = :propertyId")
    LiveData<List<PropertyPicture>> fetchPictures(long propertyId);

    @Insert
    long insert(PropertyPicture propertyPicture);

    @Query("DELETE FROM PropertyPicture WHERE property_picture_id = :propertyPictureId")
    int delete(long propertyPictureId);

    @Query("DELETE FROM PropertyPicture")
    void deleteAll();
}
