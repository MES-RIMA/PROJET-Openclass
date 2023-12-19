package com.openclassrooms.realestatemanager.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.openclassrooms.realestatemanager.databinding.PropertyPictureItemBinding;
import com.openclassrooms.realestatemanager.model.PropertyPicture;
import com.openclassrooms.realestatemanager.utils.Utils;

import java.util.List;

public class PropertDetailsAdapter extends RecyclerView.Adapter<PropertDetailsAdapter.ViewHolder> {

    private final List<PropertyPicture> mPictures;

    public PropertDetailsAdapter(List<PropertyPicture> pictures) {
        mPictures = pictures;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private PropertyPictureItemBinding mBinding;

        public ViewHolder(PropertyPictureItemBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }
    }

    @NonNull
    @Override
    public PropertDetailsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PropertDetailsAdapter.ViewHolder(PropertyPictureItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PropertDetailsAdapter.ViewHolder holder, int position) {
        PropertyPicture picture = mPictures.get(position);


        holder.mBinding.description.setText(picture.getDescription());
        Utils.setPicture(picture.getUri(), holder.mBinding.picture);
        holder.itemView.setOnClickListener(view -> onItemClick(view, position));
        displayMainPictureIcon(holder.mBinding.mainPictureIcon, position);
    }

    @Override
    public int getItemCount() {
        return mPictures.size();
    }
    public void onItemClick(View view, int position) {
        Navigation.findNavController(view).navigate(
                PropertyDetailsFragmentDirections.fromDetailsFragmentToPictureViewer().setPictureRowIndex(position)
        );
    }

    public void displayMainPictureIcon(View view, int position) {
        view.setVisibility(View.GONE);
    }
}
