package com.phonebooking.test.infrastructure.persistence;

import com.phonebooking.domain.model.MobilePhone;
import com.phonebooking.domain.model.ModelName;
import com.phonebooking.infrastructure.persistence.MobilePhoneRepositoryImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MobilePhoneRepositoryTest {

    @Test
    public void repoShouldReturnTheRequestedPhoneIfFound() {
        MobilePhoneRepositoryImpl phoneRepository = new MobilePhoneRepositoryImpl();
        MobilePhone phone = phoneRepository.findByModel(ModelName.SAMSUNG_GALAXY_S9);
        assertNotNull(phone);
        assertEquals(ModelName.SAMSUNG_GALAXY_S9, phone.getModelName());
    }

    @Test
    public void getAllShouldReturnAllThePhone() {
        MobilePhoneRepositoryImpl phoneRepository = new MobilePhoneRepositoryImpl();
        Iterable<MobilePhone> phones = phoneRepository.getAll();
        assertNotNull(phones);
        assertTrue(phones.iterator().hasNext());
    }

    @Test
    public void getAllAvailableShouldReturnAllAvailable() {
        MobilePhoneRepositoryImpl phoneRepository = new MobilePhoneRepositoryImpl();
        phoneRepository.getAll().iterator().next().book("Akhilesh");
        List<MobilePhone> phones = phoneRepository.getAllAvailablePhones();
        assertNotNull(phones);
        assertTrue(phones.size() == 8);
    }
}

