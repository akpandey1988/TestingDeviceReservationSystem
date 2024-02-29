package com.phonebooking.domain.model;

public enum ModelName {
    SAMSUNG_GALAXY_S9,
    SAMSUNG_GALAXY_S8,
    MOTOROLA_NEXUS_6,
    ONEPLUS_9,
    APPLE_IPHONE_13,
    APPLE_IPHONE_12,
    APPLE_IPHONE_11,
    IPHONE_X,
    NOKIA_3310;

    public static ModelName getModelNameById(Integer modelNameId) throws Exception {
        switch (modelNameId) {
            case 1:
                return SAMSUNG_GALAXY_S9;
            case 2:
                return SAMSUNG_GALAXY_S8;
            case 3:
                return MOTOROLA_NEXUS_6;
            case 4:
                return ONEPLUS_9;
            case 5:
                return APPLE_IPHONE_13;
            case 6:
                return APPLE_IPHONE_12;
            case 7:
                return APPLE_IPHONE_11;
            case 8:
                return IPHONE_X;
            case 9:
                return NOKIA_3310;
            default:
                throw new Exception("Invalid Input");
        }
    }
}
