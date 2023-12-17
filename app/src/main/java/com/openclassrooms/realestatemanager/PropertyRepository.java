package com.openclassrooms.realestatemanager;

import androidx.lifecycle.LiveData;

import com.openclassrooms.realestatemanager.dao.PropertyDao;

import java.util.List;

public class PropertyRepository {
    private final PropertyDao mPropertyDao;

    public PropertyRepository(PropertyDao propertyDao) {
        mPropertyDao = propertyDao;
    }

    public LiveData<List<Property>> fetchAllProperties() {
        return mPropertyDao.fetchAllProperties();
    }

    public void insert(Property property) {
        mPropertyDao.insert(property);
    }

    public void delete(Property property) {
        mPropertyDao.delete(property.getId());
    }
}
