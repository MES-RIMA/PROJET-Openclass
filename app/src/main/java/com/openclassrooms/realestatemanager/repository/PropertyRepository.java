package com.openclassrooms.realestatemanager.repository;

import androidx.lifecycle.LiveData;

import com.openclassrooms.realestatemanager.dao.PropertyDao;
import com.openclassrooms.realestatemanager.model.Property;

import java.util.List;
import java.util.concurrent.ExecutorService;

public class PropertyRepository {
    private final PropertyDao mPropertyDao;
    private final ExecutorService mExecutor;
    public PropertyRepository(PropertyDao propertyDao, ExecutorService executor) {

        mPropertyDao = propertyDao;
        mExecutor = executor;
    }

    public LiveData<List<Property>> fetchAllProperties() {
        return mPropertyDao.fetchAllProperties();
    }
    public LiveData<Property> fetchProperty(long propertyId) {
        return mPropertyDao.fetchProperty(propertyId);
    }
    public int updateMainPicture(long propertyId, long pictureId, String uri) {
        return mPropertyDao.updateMainPicture(propertyId, pictureId, uri);
    }

    public long insert(Property property) {return mPropertyDao.insert(property);
    };

    public void delete(Property property) {
        mPropertyDao.delete(property.getId());
    }
    public ExecutorService getExecutor() {
        return mExecutor;
    }
}
