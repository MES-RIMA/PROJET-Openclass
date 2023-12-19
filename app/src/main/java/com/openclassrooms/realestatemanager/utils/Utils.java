package com.openclassrooms.realestatemanager.utils;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.openclassrooms.realestatemanager.MainApplication;
import com.openclassrooms.realestatemanager.R;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Philippe on 21/02/2018.
 */

public class Utils {

    /**
     * Conversion d'un prix d'un bien immobilier (Dollars vers Euros)
     * NOTE : NE PAS SUPPRIMER, A MONTRER DURANT LA SOUTENANCE
     *
     * @param dollars
     * @return
     */
    public static int convertDollarToEuro(int dollars) {
        return (int) Math.round(dollars * 0.930);
    }

    /**
     * Converting euros to dollars
     *
     * @return converted amount in dollars
     */
    public static int convertEuroToDollar(int euros) {

        return (int) Math.round(euros * 1.08);
    }

    /**
     * Conversion de la date d'aujourd'hui en un format plus approprié
     * NOTE : NE PAS SUPPRIMER, A MONTRER DURANT LA SOUTENANCE
     *
     * @return
     */
    public static String getTodayDate() {
        return LocalDate.now().format(getDefaultDateTimeFormatter());
    }

    public static DateTimeFormatter getDefaultDateTimeFormatter() {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }
    /**
     * Vérification de la connexion réseau
     * NOTE : NE PAS SUPPRIMER, A MONTRER DURANT LA SOUTENANCE
     *
     * @param context
     * @return
     */
    public static Boolean isInternetAvailable(Context context) {
        WifiManager wifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        return wifi.isWifiEnabled();
    }
    public static String dollarString(int number) {
        String formattedNumber = NumberFormat.getNumberInstance(Locale.US).format(number);
        return "$"+formattedNumber;
    }
    /**
     * Generate string from given square meters surface.
     *
     * @param surface surface value
     * @return value followed by sq m
     */
    public static String surfaceString(int surface) {
        Context context = MainApplication.getApplication();
        return String.format(context.getString(R.string.placeholder_surface), surface);
    }

    /**
     * Secure integer string
     *
     * @param integer surface value
     * @return string representation of given integer
     */
    public static String integerString(int integer) {
        Context context = MainApplication.getApplication();
        return String.format(context.getString(R.string.placeholder_int), integer);
    }
    /**
     * Convert date string to LocalDate object
     *
     * @param dateString  string date in dd/MM/yyyy format
     * @param defaultDate default localDate to return if conversion fail
     * @return LocalDate with dd/MM/yyyy format
     */
    public static LocalDate stringToDate(String dateString, LocalDate defaultDate) {
        LocalDate date;
        try {
            date = LocalDate.parse(dateString, getDefaultDateTimeFormatter());
        } catch (Exception e) {
            date = defaultDate;
        }
        return date;
    }

    /**
     * Convert given LocalDate to string in dd/MM/yyyy format
     *
     * @param date date to convert
     * @return string in dd/MM/yyyy format
     */
    public static String dateToString(LocalDate date) {
        return date.format(getDefaultDateTimeFormatter());
    }
    public static void setPicture(String uri, ImageView imageView) {
        if (uri == null) {
            imageView.setImageResource(R.drawable.ic_baseline_home_24);
            return;
        }
        Glide.with(MainApplication.getContext())
                .load(uri)
                //.apply(new RequestOptions().centerCrop())
                //.error(R.drawable.ic_sharp_no_photography_24)
                .into(imageView);
    }
}