package com.openclassrooms.realestatemanager.fragment;

import android.view.View;

import androidx.navigation.Navigation;

import com.openclassrooms.realestatemanager.model.PropertyPicture;

import java.util.List;

public class PropertyAddAdapter extends PropertDetailsAdapter {

    private final CommandPictureManager mCommandPictureManager;

    public PropertyAddAdapter(List<PropertyPicture> pictures, CommandPictureManager commandPictureManager) {
        super(pictures);
        mCommandPictureManager = commandPictureManager;
    }

    @Override
    public void onItemClick(View view, int position) {
        Navigation.findNavController(view).navigate(
                PropertyAddFragmentDirections.fromAddFragmentToPictureManager().setPictureRowIndex(position)
        );
    }

    @Override
    public void displayMainPictureIcon(View view, int position) {
        if (mCommandPictureManager.getMainPictureIndex() == position) view.setVisibility(View.VISIBLE);
        else view.setVisibility(View.GONE);
    }
}
