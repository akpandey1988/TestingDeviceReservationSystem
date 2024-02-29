package com.phonebooking.domain.repository;

import com.phonebooking.domain.model.MobilePhone;
import com.phonebooking.domain.model.ModelName;

import java.util.List;

public interface IMobilePhoneRepository {
    MobilePhone findByModel(ModelName modelName);
    List<MobilePhone> getAll();
    List<MobilePhone> getAllAvailablePhones();
}
