package com.openclassrooms.realestatemanager.data.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.openclassrooms.realestatemanager.Property;
import com.openclassrooms.realestatemanager.PropertyPictureRepository;
import com.openclassrooms.realestatemanager.PropertyRepository;

import java.util.List;

public class PropertyListViewModel extends ViewModel {
    private PropertyRepository mPropertyRepository;
    private PropertyPictureRepository mPropertyPictureRepository;

    public PropertyListViewModel(PropertyRepository propertyRepository, PropertyPictureRepository propertyPictureRepository) {
        mPropertyRepository = propertyRepository;
        mPropertyPictureRepository = propertyPictureRepository;
    }

    public LiveData<List<Property>> fetchAllProperties() {
        return mPropertyRepository.fetchAllProperties();
    }
}