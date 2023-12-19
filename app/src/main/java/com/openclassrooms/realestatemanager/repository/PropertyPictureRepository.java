package com.openclassrooms.realestatemanager.repository;

import androidx.lifecycle.LiveData;

import com.openclassrooms.realestatemanager.dao.PropertyPictureDao;
import com.openclassrooms.realestatemanager.model.PropertyPicture;

import java.util.List;
import java.util.concurrent.ExecutorService;

public class PropertyPictureRepository {
    private final PropertyPictureDao mPropertyPictureDao;
    private final ExecutorService mExecutor;
    public PropertyPictureRepository(PropertyPictureDao propertyPictureDao, ExecutorService executor) {
        mPropertyPictureDao = propertyPictureDao;
        mExecutor = executor;
    }

    public LiveData<List<PropertyPicture>> fetchPictures(long projectId) {
        return mPropertyPictureDao.fetchPictures(projectId);
    }
    public long insert(PropertyPicture propertyPicture) {
        return mPropertyPictureDao.insert(propertyPicture);
    }

    public void delete(PropertyPicture propertyPicture) {
        mPropertyPictureDao.delete(propertyPicture.getId());
    }
}
