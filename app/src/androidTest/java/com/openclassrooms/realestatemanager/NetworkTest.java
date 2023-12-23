package com.openclassrooms.realestatemanager;

import static org.junit.Assert.assertTrue;

import com.openclassrooms.realestatemanager.utils.Utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class NetworkTest {
    // This test needs internet connexion
    @Test
    public void isInternetAvailable_test() {
        assertTrue(Utils.isInternetAvailable());
    }
}
