package com.openclassrooms.realestatemanager.fragment;

import android.view.View;

import androidx.navigation.Navigation;

import com.openclassrooms.realestatemanager.data.model.PropertyPicture;

import java.util.List;

public class PropertyAddAdapter extends PropertyDetailsAdapter {

    private final CommandPictureManager mCommandPictureManager;

    public PropertyAddAdapter(List<PropertyPicture> pictures, CommandPictureManager commandPictureManager) {
        super(pictures);
        mCommandPictureManager = commandPictureManager;
    }

    @Override
    public void onItemClick(View view, int position) {
        Navigation.findNavController(view).navigate(
                PropertyAddFragmentDirections.fromAddFragmentToPictureManagerAdd().setPictureRowIndex(position)
        );
    }

    @Override
    public void displayMainPictureIcon(View view, int position) {
        if (mCommandPictureManager.getMainPictureIndex() == position) view.setVisibility(View.VISIBLE);
        else view.setVisibility(View.GONE);
    }
}
