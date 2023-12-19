package com.openclassrooms.realestatemanager.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Property {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "property_id")
    private long id;
    private String type;
    private String district;
    private int price;
    private int surface;
    private int numberOfRooms;
    private int numberOfBathrooms;
    private int numberOfBedrooms;
    private String description;
    private long mainPictureId;
    private String mainPictureUri;
    private String addressNumber;
    private String street;
    private String postalCode;
    private String city;
    //TODO: Points of interest, school, shop, parcs...
    private boolean poiSwimmingPool;
    private boolean poiSchool;
    private boolean poiShopping;
    private boolean poiParking;
    private boolean available;
    private String listedDate;
    private String soldDate;
    private String realEstateAgent;

    public Property(String type, String district, int price, int surface, int numberOfRooms, int numberOfBathrooms, int numberOfBedrooms, String description, long mainPictureId, String mainPictureUri, String addressNumber, String street, String postalCode, String city, boolean poiSwimmingPool, boolean poiSchool, boolean poiShopping, boolean poiParking, boolean available, String listedDate, String soldDate, String realEstateAgent) {
        this.type = type;
        this.district = district;
        this.price = price;
        this.surface = surface;
        this.numberOfRooms = numberOfRooms;
        this.numberOfBathrooms = numberOfBathrooms;
        this.numberOfBedrooms = numberOfBedrooms;
        this.description = description;
        this.mainPictureId = mainPictureId;
        this.mainPictureUri = mainPictureUri;
        this.addressNumber = addressNumber;
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.poiSwimmingPool = poiSwimmingPool;
        this.poiSchool = poiSchool;
        this.poiShopping = poiShopping;
        this.poiParking = poiParking;
        this.available = available;
        this.listedDate = listedDate;
        this.soldDate = soldDate;
        this.realEstateAgent = realEstateAgent;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }
        public void setType(String type) {
            this.type = type;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSurface() { return surface; }

    public void setSurface(int surface) { this.surface = surface; }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public int getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    public void setNumberOfBathrooms(int numberOfBathrooms) { this.numberOfBathrooms = numberOfBathrooms; }

    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    public void setNumberOfBedrooms(int numberOfBedrooms) { this.numberOfBedrooms = numberOfBedrooms; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getMainPictureId() {
        return mainPictureId;
    }

    public void setMainPictureId(long mainPictureId) {
        this.mainPictureId = mainPictureId;
    }

    public String getMainPictureUri() { return mainPictureUri; }

    public void setMainPictureUri(String mainPictureUri) { this.mainPictureUri = mainPictureUri; }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }
    public boolean hasPoiSwimmingPool() {
        return poiSwimmingPool;
    }

    public void setPoiSwimmingPool(boolean poiSwimmingPool) { this.poiSwimmingPool = poiSwimmingPool; }

    public boolean hasPoiSchool() {
        return poiSchool;
    }

    public void setPoiSchool(boolean poiSchool) {
        this.poiSchool = poiSchool;
    }

    public boolean hasPoiShopping() {
        return poiShopping;
    }

    public void setPoiShopping(boolean poiShopping) {
        this.poiShopping = poiShopping;
    }

    public boolean hasPoiParking() {
        return poiParking;
    }

    public void setPoiParking(boolean poiParking) {
        this.poiParking = poiParking;
    }


    public void setCity(String city) {
        this.city = city;
    }
        public String getFullAddress () {
            return addressNumber + " " + street + " " + postalCode + " " + city;
        }

        public boolean isAvailable () {
            return available;
        }

        public void setAvailable ( boolean available){
            this.available = available;
        }

        public String getListedDate () {
            return listedDate;
        }

        public void setListedDate (String listedDate){
            this.listedDate = listedDate;
        }

        public String getSoldDate () {
            return soldDate;
        }

        public void setSoldDate (String soldDate){
            this.soldDate = soldDate;
        }

        public String getRealEstateAgent () {
            return realEstateAgent;
        }

        public void setRealEstateAgent (String realEstateAgent){
            this.realEstateAgent = realEstateAgent;
        }
    public boolean hasSameContent(Property property) {
        if (!type.contentEquals(property.getType())) return false;
        if (!district.contentEquals(property.getDistrict())) return false;
        if (price != property.getPrice()) return false;
        if (surface != property.getSurface()) return false;
        if (numberOfRooms != property.getNumberOfRooms()) return false;
        if (numberOfBathrooms != property.getNumberOfBathrooms()) return false;
        if (numberOfBedrooms != property.getNumberOfBedrooms()) return false;
        if (!description.contentEquals(property.getDescription())) return false;
        if (mainPictureId != property.getMainPictureId()) return false;
        if (price != property.getPrice()) return false;
        if (!addressNumber.contentEquals(property.getAddressNumber())) return false;
        if (!street.contentEquals(property.getStreet())) return false;
        if (!postalCode.contentEquals(property.getPostalCode())) return false;
        if (!city.contentEquals(property.getCity())) return false;
        if (poiSwimmingPool != property.hasPoiSwimmingPool()) return false;
        if (poiSchool != property.hasPoiSchool()) return false;
        if (poiShopping != property.hasPoiShopping()) return false;
        if (poiParking != property.hasPoiParking()) return false;
        if (available != property.isAvailable()) return false;
        if (!listedDate.contentEquals(property.getListedDate())) return false;
        if (!soldDate.contentEquals(property.getSoldDate())) return false;
        if (!realEstateAgent.contentEquals(property.getRealEstateAgent())) return false;
        return true;
    }
    }
