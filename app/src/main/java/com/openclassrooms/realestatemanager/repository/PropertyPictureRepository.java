package com.openclassrooms.realestatemanager.repository;

import androidx.lifecycle.LiveData;

import com.openclassrooms.realestatemanager.dao.PropertyPictureDao;
import com.openclassrooms.realestatemanager.model.PropertyPicture;

import java.util.List;

public class PropertyPictureRepository {
    private final PropertyPictureDao mPropertyPictureDao;

    public PropertyPictureRepository(PropertyPictureDao propertyPictureDao) {
        mPropertyPictureDao = propertyPictureDao;
    }

    public LiveData<List<PropertyPicture>> fetchPictures(long projectId) {
        return mPropertyPictureDao.fetchPictures(projectId);
    }
    public void insert(PropertyPicture propertyPicture) {
        mPropertyPictureDao.insert(propertyPicture);
    }

    public void delete(PropertyPicture propertyPicture) {
        mPropertyPictureDao.delete(propertyPicture.getId());
    }
}
