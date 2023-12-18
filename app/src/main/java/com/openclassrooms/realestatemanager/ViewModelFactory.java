package com.openclassrooms.realestatemanager;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.openclassrooms.realestatemanager.data.viewmodel.PropertyListViewModel;
import com.openclassrooms.realestatemanager.model.DataBase;
import com.openclassrooms.realestatemanager.repository.PropertyPictureRepository;
import com.openclassrooms.realestatemanager.repository.PropertyRepository;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private static volatile ViewModelFactory sFactory;

    @NonNull
    private final PropertyRepository mPropertyRepository;
    @NonNull
    private final PropertyPictureRepository mPropertyPictureRepository;

    public static ViewModelFactory getInstance(Context context) {
        if (sFactory == null) {
            synchronized (ViewModelFactory.class) {
                if (sFactory == null) {
                    sFactory = new ViewModelFactory(context);
                    System.out.println("Just Created "+context.getClass());
                }
            }
        }
        return sFactory;
    }

    private ViewModelFactory(Context context) {
        DataBase database = DataBase.getDatabase(context);

        mPropertyRepository = new PropertyRepository(database.propertyDao());
        mPropertyPictureRepository = new PropertyPictureRepository(database.propertyPictureDao());
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(PropertyListViewModel.class)) {
            return (T) new PropertyListViewModel(mPropertyRepository, mPropertyPictureRepository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
