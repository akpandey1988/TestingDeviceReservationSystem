package com.phonebooking.application;

import com.phonebooking.domain.model.ModelName;
import com.phonebooking.domain.service.IMobilePhoneBookingService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MobilePhoneReservationClient {
    private final Scanner scanner;
    private final IMobilePhoneBookingService phoneService;

    public MobilePhoneReservationClient(Scanner scanner, IMobilePhoneBookingService phoneService) {
        this.scanner = scanner;
        this.phoneService = phoneService;
    }

    public void start() {
        System.out.println("######### WelcomeTo Mobile Phone Test Devices Booking System #########");
        while (true) {
            try {
                printAvailableOptions();
                int userSelection = scanner.nextInt();
                switch (userSelection) {
                    case 1 -> phoneService.displayPhoneStatus();
                    case 2 -> bookPhone();
                    case 3 -> returnPhone();
                    case 4 -> phoneService.displayPhonesAvailableForBooking();
                    case 5 -> {
                        displayThankYouMessageAndClose();
                        return;
                    }
                    default -> throw new InputMismatchException("Invalid Option");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input, please enter the valid input");
                clearScannerBuffer();
            }
        }
    }

    private void displayThankYouMessageAndClose() {
        System.out.println("Thanks for using Mobile Phone Booking System.");
        System.out.println("Have a great day!!");
        // Close the scanner
        scanner.close();
    }

    private void printAvailableOptions() {
        System.out.println("###############################");
        System.out.println("Select from below options:");
        System.out.println("1. Get the booking status of all phones");
        System.out.println("2. Book phone for testing.");
        System.out.println("3. Return phone.");
        System.out.println("4. Get all available phones.");
        System.out.println("5. Exit");
        System.out.println("###############################");
        System.out.print("Enter appropriate option(1,2,3...) to proceed:");
    }

    public void bookPhone() {
        while (true) {
            try {
                System.out.println("Enter phone model to reserve for testing:");
                printAllPhonesWithAvaialbility();
                Integer modelNameId = getModelNameIdAsUserInput();
                if (invalid(modelNameId)) return;
                scanner.nextLine();
                ModelName modelNameById = ModelName.getModelNameById(modelNameId);

                System.out.print("Please enter the customer's name for the booking of mobile phone: ");
                String bookingName = getBookingNameAsUserInput();
                if (invalid(bookingName)) return;
                int responseCode = phoneService.bookPhone(modelNameById, bookingName);

                if (successful(responseCode)) {
                    System.out.println("Thank you " + bookingName + "!! Your Booking is confirmed ");
                }
                return;
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input, please enter the valid input");
                // Clear invalid input from scanner buffer
                clearScannerBuffer();
            } catch (Exception ide) {
                System.out.println("Invalid input, please enter the valid input");
            }
        }
    }

    private boolean successful(int responseCode) {
        return responseCode == 0;
    }

    private boolean invalid(String bookingName) {
        return bookingName == null;
    }

    private String getBookingNameAsUserInput() {
        String bookingName = scanner.nextLine();
        if (bookingName.isEmpty()) {
            System.out.println("Redirecting to main menu...., customer's name can't be empty.");
            return null;
        }
        return bookingName;
    }

    private boolean invalid(Integer modelNameId) {
        return modelNameId == null;
    }

    private Integer getModelNameIdAsUserInput() {
        int modelNameId = scanner.nextInt();
        if (successful(modelNameId)) {
            // Return to the main options list
            return null;
        }
        return modelNameId;
    }

    private void returnPhone() {
        try {
            System.out.println("Enter phone model to return after testing:");
            printAllPhonesWithAvaialbility();
            Integer modelNameId = getModelNameIdAsUserInput();
            if (invalid(modelNameId)) return;
            int response = phoneService.returnPhone(ModelName.getModelNameById(modelNameId));
            if (successful(response)) {
                System.out.println("Thanks for returning. Your return is accepted");
            }
        } catch (InputMismatchException ex) {
            System.out.println("Invalid input, please enter the valid input");
            scanner.next();
        } catch (Exception ide) {
            System.out.println("Invalid input, please enter the valid input");
        }
    }

    private void printAllPhonesWithAvaialbility() {
        System.out.println("###############################");
        System.out.println("\t1. " + phoneService.getPhoneByModelName(ModelName.SAMSUNG_GALAXY_S9));
        System.out.println("\t2. " + phoneService.getPhoneByModelName(ModelName.SAMSUNG_GALAXY_S8));
        System.out.println("\t3. " + phoneService.getPhoneByModelName(ModelName.MOTOROLA_NEXUS_6));
        System.out.println("\t4. " + phoneService.getPhoneByModelName(ModelName.ONEPLUS_9));
        System.out.println("\t5. " + phoneService.getPhoneByModelName(ModelName.APPLE_IPHONE_13));
        System.out.println("\t6. " + phoneService.getPhoneByModelName(ModelName.APPLE_IPHONE_12));
        System.out.println("\t7. " + phoneService.getPhoneByModelName(ModelName.APPLE_IPHONE_11));
        System.out.println("\t8. " + phoneService.getPhoneByModelName(ModelName.IPHONE_X));
        System.out.println("\t9. " + phoneService.getPhoneByModelName(ModelName.NOKIA_3310));
        System.out.println("###############################");
        System.out.print("Enter appropriate option(1,2,3) for model name[Enter 0 to exit]:");
    }

    private void clearScannerBuffer() {
        // Clear invalid input from scanner buffer
        scanner.nextLine();
    }
}
