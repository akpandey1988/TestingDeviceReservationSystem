package com.phonebooking.application;

import com.phonebooking.domain.repository.MobilePhoneRepository;
import com.phonebooking.domain.service.MobilePhoneBookingService;
import com.phonebooking.domain.service.MobilePhoneBookingServiceImpl;
import com.phonebooking.infrastructure.persistence.MobilePhoneRepositoryImpl;

import java.util.Scanner;

public class MobilePhoneReservationSystem {

    public static void main(String[] args) {
        //Initialise the inputReader to take the inputReader from user
        Scanner inputReader = new Scanner(System.in);
        //Initialise repository
        MobilePhoneRepository phoneRepository = new MobilePhoneRepositoryImpl();
        //Initialise Service
        MobilePhoneBookingService phoneService = new MobilePhoneBookingServiceImpl(phoneRepository);
        //Start workflow
        var client = new MobilePhoneReservationClient(inputReader, phoneService);
        client.start();
    }

}
