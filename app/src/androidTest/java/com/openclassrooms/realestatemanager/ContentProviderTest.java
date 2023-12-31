package com.openclassrooms.realestatemanager;



import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.platform.app.InstrumentationRegistry;

import com.openclassrooms.realestatemanager.data.model.DataBase;
import com.openclassrooms.realestatemanager.provider.EstateContentProvider;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Objects;
@RunWith(JUnit4.class)
public class ContentProviderTest {

    private ContentResolver contentResolver;
    //Data Set for test
    private static long mandateNumberID = 1;
    @Before
    public void setUp() {
        Context context = ApplicationProvider.getApplicationContext();
        Room.inMemoryDatabaseBuilder(context,
                      DataBase.class)
                .allowMainThreadQueries()
                .build();
        contentResolver = InstrumentationRegistry.getInstrumentation().getContext().getContentResolver();
    }

    @Test
    public void getItemsWhenNoItemInserted() {
        final Cursor cursor = contentResolver.query(ContentUris.withAppendedId(EstateContentProvider.URI_PROPERTY, mandateNumberID),
                null, null, null, null);
        assertThat(cursor, notNullValue());
        if (cursor != null) {
            assertThat(cursor.getCount(), is(0));
            cursor.close();
        }
    }
    @Test
    public void insertAndGetProperty() {
        // Add a property
        final Uri houseUri = contentResolver.insert(EstateContentProvider.URI_PROPERTY, generateEstate());
        final Cursor cursor = contentResolver.query(ContentUris.withAppendedId(EstateContentProvider.URI_PROPERTY, mandateNumberID),
                        null, null, null, null);
        // Verify only one property has been inserted and content is correct
        assertThat(cursor, notNullValue());
        assertThat(cursor.getCount(), is(1));
        assertThat(cursor.moveToFirst(), is(true));
        assertThat(cursor.getString(cursor.getColumnIndexOrThrow("type")), is("House"));
        // cleaning
        contentResolver.delete(Objects.requireNonNull(houseUri), null, null);
    }

    private ContentValues generateEstate() {
        final ContentValues values = new ContentValues();
        values.put("property_id", 1);
        values.put("type", "House");
        values.put("district", "facade");
        values.put("price", 540000);
        values.put("surface", 120);
        values.put("numberOfRooms", 3);
        values.put("poiSwimmingPool", false);
        values.put("poiSchool", true);
        values.put("poiShopping", true);
        values.put("poiParking", true);
        values.put("description", "magnifique maison");
        values.put("mainPictureId", 1);
        values.put("mainPictureUri", "");
        values.put("addressNumber", 12);
        values.put("street", "rue de la roquette");
        values.put("postalCode", 75012);
        values.put("city", "Paris");
        values.put("available", true);
        values.put("listedDate", "9/12/2023");
        values.put("soldDate", "");
        values.put("realEstateAgent", "Roger");
        return values;
    }
}
