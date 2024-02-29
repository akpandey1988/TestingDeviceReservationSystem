package com.phonebooking.test.infrastructure.persistence;

import com.phonebooking.domain.model.MobilePhone;
import com.phonebooking.domain.model.ModelName;
import com.phonebooking.infrastructure.persistence.MobilePhoneRepository;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MobilePhoneRepositoryTest {

    @Test
    public void repoShouldReturnTheRequestedPhoneIfFound() {
        MobilePhoneRepository phoneRepository = new MobilePhoneRepository();
        MobilePhone phone = phoneRepository.findByModel(ModelName.SAMSUNG_GALAXY_S9);
        assertNotNull(phone);
        assertEquals(ModelName.SAMSUNG_GALAXY_S9, phone.getModelName());
    }

    @Test
    public void getAllShouldReturnAllThePhone() {
        MobilePhoneRepository phoneRepository = new MobilePhoneRepository();
        Iterable<MobilePhone> phones = phoneRepository.getAll();
        assertNotNull(phones);
        assertTrue(phones.iterator().hasNext());
    }

    @Test
    public void getAllAvailableShouldReturnAllAvailable() {
        MobilePhoneRepository phoneRepository = new MobilePhoneRepository();
        phoneRepository.getAll().iterator().next().book("Akhilesh");
        List<MobilePhone> phones = phoneRepository.getAllAvailablePhones();
        assertNotNull(phones);
        assertTrue(phones.size() == 8);
    }
}

