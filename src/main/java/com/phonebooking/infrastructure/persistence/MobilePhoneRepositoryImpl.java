package com.phonebooking.infrastructure.persistence;

import com.phonebooking.domain.model.MobilePhone;
import com.phonebooking.domain.model.ModelName;
import com.phonebooking.domain.repository.MobilePhoneRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MobilePhoneRepositoryImpl implements MobilePhoneRepository {
    //Using in memory map ideally this would be a table in db
    private Map<ModelName, MobilePhone> phones;

    public MobilePhoneRepositoryImpl() {
        phones = new HashMap<>();
        initializePhones();
    }

    private void initializePhones() {
        for (ModelName modelName : ModelName.values()) {
            phones.put(modelName, new MobilePhone(modelName));
        }
    }

    @Override
    public MobilePhone findByModel(ModelName modelName) {
        return phones.get(modelName);
    }

    @Override
    public List<MobilePhone> getAll() {
        return phones.values().stream().collect(Collectors.toList());
    }

    @Override
    public List<MobilePhone> getAllAvailablePhones() {
        return phones.values().stream().filter(x->x.isAvailable()).collect(Collectors.toList());
    }
}
