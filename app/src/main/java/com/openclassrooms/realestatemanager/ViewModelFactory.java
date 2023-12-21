package com.openclassrooms.realestatemanager;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.openclassrooms.realestatemanager.data.viewmodel.PropertyAddViewModel;
import com.openclassrooms.realestatemanager.data.viewmodel.PropertyEditViewModel;
import com.openclassrooms.realestatemanager.data.viewmodel.PropertyListViewModel;
import com.openclassrooms.realestatemanager.model.DataBase;
import com.openclassrooms.realestatemanager.repository.PropertyPictureRepository;
import com.openclassrooms.realestatemanager.repository.PropertyRepository;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private static volatile ViewModelFactory sFactory;
    private static final int NUMBER_OF_THREADS = 4;
    private ExecutorService mMainExecutor;
    @NonNull
    private final PropertyRepository mPropertyRepository;
    @NonNull
    private final PropertyPictureRepository mPropertyPictureRepository;

    public static ViewModelFactory getInstance(Context context) {
        if (sFactory == null) {
            synchronized (ViewModelFactory.class) {
                if (sFactory == null) {
                    sFactory = new ViewModelFactory(context);
                }
            }
        }
        return sFactory;
    }

    private ViewModelFactory(Context context) {
        mMainExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        DataBase database = DataBase.getDatabase(context);

        mPropertyRepository = new PropertyRepository(database.propertyDao(),  mMainExecutor);
        mPropertyPictureRepository = new PropertyPictureRepository(database.propertyPictureDao(), mMainExecutor);
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(PropertyListViewModel.class)) {
            return (T) new PropertyListViewModel(mPropertyRepository, mPropertyPictureRepository, mMainExecutor);
        }
        else if (modelClass.isAssignableFrom(PropertyAddViewModel.class)) {
            return (T) new PropertyAddViewModel(mPropertyRepository, mPropertyPictureRepository);
        }
        else if (modelClass.isAssignableFrom(PropertyEditViewModel.class)) {
            return (T) new PropertyEditViewModel(mPropertyRepository, mPropertyPictureRepository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
