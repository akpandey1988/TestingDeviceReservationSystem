package com.phonebooking.domain.model;

import java.time.ZonedDateTime;

public class MobilePhone {
    private final ModelName modelName;
    private boolean isAvailable;
    private String bookedBy;
    private ZonedDateTime bookingDate;

    public MobilePhone(ModelName modelName) {
        if (modelName == null) {
            throw new IllegalArgumentException("Model name cannot be null.");
        }
        this.modelName = modelName;
        this.isAvailable = true;
        this.bookedBy = null;
        this.bookingDate = null;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void book(String bookedBy) {
        if (!isAvailable) {
            throw new IllegalStateException("Mobile phone is already booked.");
        }
        //since this object is returned from in memory so any changes done here is considered as persisted
        this.isAvailable = false;
        this.bookedBy = bookedBy;
        this.bookingDate = ZonedDateTime.now();
    }

    public void returnPhone() {
        if (isAvailable) {
            throw new IllegalStateException("Mobile phone is already available.");
        }
        //since this object is returned from in memory so any changes done here is considered as persisted
        this.isAvailable = true;
        this.bookedBy = null;
        this.bookingDate = null;
    }

    public ModelName getModelName() {
        return modelName;
    }

    @Override
    public String toString() {
        return "\tModel: " + modelName + ", Availability: " + (isAvailable ? "Available" : "Booked by " + bookedBy + ", " + "Booking date " + bookingDate);
    }
}
