package com.youbikerental.model;

public class RentalRequest {
    private String userId;
    private String easycardNumber;
    private String bikenumber;
    private String rentStation;
    private String returnStation;
    private String returnTime; // This should be a String in the format "yyyy-MM-ddTHH:mm"
    private double additionalFee;

    private String version;
    private String region;

    // Getters and Setters

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEasycardNumber() {
        return easycardNumber;
    }

    public void setEasycardNumber(String easycardNumber) {
        this.easycardNumber = easycardNumber;
    }

    public String getBikenumber() {
        return bikenumber;
    }

    public void setBikenumber(String bikenumber) {
        this.bikenumber = bikenumber;
    }

    public String getRentStation() {
        return rentStation;
    }

    public void setRentStation(String rentStation) {
        this.rentStation = rentStation;
    }

    public String getReturnStation() {
        return returnStation;
    }

    public void setReturnStation(String returnStation) {
        this.returnStation = returnStation;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    public double getAdditionalFee() {
        return additionalFee;
    }

    public void setAdditionalFee(double additionalFee) {
        this.additionalFee = additionalFee;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
