package com.phonebooking.domain.service;

import com.phonebooking.domain.model.MobilePhone;
import com.phonebooking.domain.model.ModelName;
import com.phonebooking.domain.repository.IMobilePhoneRepository;

public class MobilePhoneBookingService implements IMobilePhoneBookingService {
    private IMobilePhoneRepository phoneRepository;

    public MobilePhoneBookingService(IMobilePhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    @Override
    public int bookPhone(ModelName modelName, String bookedBy) {
        MobilePhone phone = phoneRepository.findByModel(modelName);
        if (phone != null && phone.isAvailable()) {
            phone.book(bookedBy);
            return 0;
        } else {
            System.out.println("Phone " + modelName + " is not available for booking.");
            return -1;
        }
    }

    @Override
    public int returnPhone(ModelName modelName) {
        MobilePhone phone = phoneRepository.findByModel(modelName);
        if (phone != null && !phone.isAvailable()) {
            phone.returnPhone();
            return 0;
        } else {
            System.out.println("Sorry, No booking found for Phone:  " + modelName);
            return -1;
        }
    }

    @Override
    public void displayPhoneStatus() {
        System.out.println("All Phones with status:");
        for (MobilePhone phone : phoneRepository.getAll()) {
            System.out.println(phone);
        }
    }

    @Override
    public void displayPhonesAvailableForBooking() {
        System.out.println("Available Test Phones for booking:");
        for (MobilePhone phone : phoneRepository.getAllAvailablePhones()) {
            System.out.println(phone);
        }
    }

    @Override
    public MobilePhone getPhoneByModelName(ModelName name) {
        return phoneRepository.findByModel(name);
    }
}
