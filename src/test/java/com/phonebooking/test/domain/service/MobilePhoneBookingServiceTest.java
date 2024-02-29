package com.phonebooking.test.domain.service;

import com.phonebooking.domain.model.ModelName;
import com.phonebooking.domain.repository.IMobilePhoneRepository;
import com.phonebooking.domain.service.IMobilePhoneBookingService;
import com.phonebooking.domain.service.MobilePhoneBookingService;
import com.phonebooking.infrastructure.persistence.MobilePhoneRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MobilePhoneBookingServiceTest {
    private IMobilePhoneBookingService phoneService;
    private IMobilePhoneRepository phoneRepository;

    @Before
    public void setUp() {
        phoneRepository = new MobilePhoneRepository();
        phoneService = new MobilePhoneBookingService(phoneRepository);
    }

    @Test
    public void phoneShouldNotBeAvailableOnceBooked() {
        phoneService.bookPhone(ModelName.SAMSUNG_GALAXY_S9, "John Doe");
        assertFalse(phoneRepository.findByModel(ModelName.SAMSUNG_GALAXY_S9).isAvailable());
    }

    @Test
    public void phoneShouldBeAvailableOnceReturned() {
        phoneService.bookPhone(ModelName.SAMSUNG_GALAXY_S9, "John Doe");
        phoneService.returnPhone(ModelName.SAMSUNG_GALAXY_S9);
        assertTrue(phoneRepository.findByModel(ModelName.SAMSUNG_GALAXY_S9).isAvailable());
    }
}

