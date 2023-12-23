package com.openclassrooms.realestatemanager;

import static org.junit.Assert.assertEquals;

import com.openclassrooms.realestatemanager.utils.Utils;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    @Test
    public void getTodayDateTest() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String actualDate = Utils.getTodayDate();
        assertEquals(dateFormat.format(new Date()), actualDate);
    }
}
