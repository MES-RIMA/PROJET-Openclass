package com.openclassrooms.realestatemanager;

import androidx.lifecycle.LiveData;

import com.openclassrooms.realestatemanager.dao.PropertyPictureDao;

import java.util.List;

public class PropertyPictureRepository {
    private final PropertyPictureDao mPropertyPictureDao;

    public PropertyPictureRepository(PropertyPictureDao propertyPictureDao) {
        mPropertyPictureDao = propertyPictureDao;
    }

    public LiveData<List<PropertyPicture>> fetchAllPictures() {
        return mPropertyPictureDao.fetchAllPictures();
    }

    public void insert(PropertyPicture propertyPicture) {
        mPropertyPictureDao.insert(propertyPicture);
    }

    public void delete(PropertyPicture propertyPicture) {
        mPropertyPictureDao.delete(propertyPicture.getId());
    }
}
