package com.phonebooking.application;

import com.phonebooking.domain.repository.IMobilePhoneRepository;
import com.phonebooking.domain.service.IMobilePhoneBookingService;
import com.phonebooking.domain.service.MobilePhoneBookingService;
import com.phonebooking.infrastructure.persistence.MobilePhoneRepository;

import java.util.Scanner;

public class MobilePhoneReservationSystem {

    public static void main(String[] args) {
        //Initialise the inputReader to take the inputReader from user
        Scanner inputReader = new Scanner(System.in);
        //Initialise repository
        IMobilePhoneRepository phoneRepository = new MobilePhoneRepository();
        //Initialise Service
        IMobilePhoneBookingService phoneService = new MobilePhoneBookingService(phoneRepository);
        //Start workflow
        var client = new MobilePhoneReservationClient(inputReader, phoneService);
        client.start();
    }

}
