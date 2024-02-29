package com.phonebooking.test.domain.models;

import com.phonebooking.domain.model.MobilePhone;
import com.phonebooking.domain.model.ModelName;
import org.junit.Test;

import static org.junit.Assert.*;

public class MobilePhoneTest {

    @Test
    public void phoneShouldBeAvailableUponCreation() {
        MobilePhone phone = new MobilePhone(ModelName.SAMSUNG_GALAXY_S9);
        assertTrue(phone.isAvailable());
    }

    @Test
    public void phoneShouldHaveModelName() {
        assertThrows(IllegalArgumentException.class, ()-> new MobilePhone(null));
    }

    @Test
    public void phoneShouldNotBeAvailableOnceBooked() {
        MobilePhone phone = new MobilePhone(ModelName.SAMSUNG_GALAXY_S9);
        phone.book("Customer1");
        assertFalse(phone.isAvailable());
    }

    @Test
    public void phoneShouldNotBeBookedTwice() {
        MobilePhone phone = new MobilePhone(ModelName.SAMSUNG_GALAXY_S9);
        phone.book("Customer1");
        assertFalse(phone.isAvailable());
        assertThrows(IllegalStateException.class, ()->phone.book("Customer2"));
    }

    @Test
    public void phoneShouldBeAvailableOnceReturned() {
        MobilePhone phone = new MobilePhone(ModelName.SAMSUNG_GALAXY_S9);
        phone.book("John Doe");
        phone.returnPhone();
        assertTrue(phone.isAvailable());
    }

    @Test
    public void phoneShouldNotBeReturnedIfNotBooked() {
        MobilePhone phone = new MobilePhone(ModelName.SAMSUNG_GALAXY_S9);
        assertThrows(IllegalStateException.class, ()->phone.returnPhone());
    }
}
