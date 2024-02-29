package com.phonebooking.domain.service;


import com.phonebooking.domain.model.MobilePhone;
import com.phonebooking.domain.model.ModelName;

public interface IMobilePhoneBookingService {
    int bookPhone(ModelName modelName, String bookedBy);
    int returnPhone(ModelName modelName);
    void displayPhoneStatus();
    void displayPhonesAvailableForBooking();
    MobilePhone getPhoneByModelName(ModelName name);
}
