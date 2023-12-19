package com.openclassrooms.realestatemanager.utils;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.provider.MediaStore;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;

import com.openclassrooms.realestatemanager.fragment.CommandPictureManager;

public class MediaStoreHelper {

    private ActivityResultLauncher<Intent> mLauncher;
    private Fragment mFragment;

    public MediaStoreHelper(Fragment fragment, CommandPictureManager commandReceivePictureUri) {
        mFragment = fragment;
        mLauncher = mFragment.registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        commandReceivePictureUri.receivePictureUri(result.getData().getData());
                    }
                });
    }

    public void openGallery() {
        //TODO check :  if (permissionGranted) {
        openGalleryIntent();
    }

    private void openGalleryIntent() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        mLauncher.launch(galleryIntent);
    }
}
