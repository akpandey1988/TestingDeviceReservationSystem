# Mobile Phone Booking System

This application manages the booking and returning of mobile phones for testing purposes.

## Features

- **Booking Phones:** Allows users to book available phones for testing.
- **Returning Phones:** Enables users to return phones after testing.
- **Displaying Phone Status:** Shows the current status of all phones, including availability and booking information.

## Environment Setup

1. **Install Maven**
   - brew install mvn
2. **Install Java**
   - java version greater than 1.8
   
## Usage

1. **To run unit-test**
   - mvn test
2. **To package**
   - mvn clean package
3. **To Run**
   -  java -jar target/MobileTestingBookingSystem.jar

## Example
```dtd
######### WelcomeTo Mobile Phone Test Devices Booking System #########
###############################
Select from below options:
1. Get the booking status of all phones
2. Book phone for testing.
3. Return phone.
4. Get all available phones.
5. Exit
###############################
Enter appropriate option(1,2,3...) to proceed:1
All Phones with status:
        Model: NOKIA_3310, Availability: Available
        Model: SAMSUNG_GALAXY_S9, Availability: Available
        Model: APPLE_IPHONE_13, Availability: Available
        Model: SAMSUNG_GALAXY_S8, Availability: Available
        Model: ONEPLUS_9, Availability: Available
        Model: APPLE_IPHONE_11, Availability: Available
        Model: IPHONE_X, Availability: Available
        Model: MOTOROLA_NEXUS_6, Availability: Available
        Model: APPLE_IPHONE_12, Availability: Available
###############################
Select from below options:
1. Get the booking status of all phones
2. Book phone for testing.
3. Return phone.
4. Get all available phones.
5. Exit
###############################
Enter appropriate option(1,2,3...) to proceed:2
Enter phone model to reserve for testing:
###############################
        1.      Model: SAMSUNG_GALAXY_S9, Availability: Available
        2.      Model: SAMSUNG_GALAXY_S8, Availability: Available
        3.      Model: MOTOROLA_NEXUS_6, Availability: Available
        4.      Model: ONEPLUS_9, Availability: Available
        5.      Model: APPLE_IPHONE_13, Availability: Available
        6.      Model: APPLE_IPHONE_12, Availability: Available
        7.      Model: APPLE_IPHONE_11, Availability: Available
        8.      Model: IPHONE_X, Availability: Available
        9.      Model: NOKIA_3310, Availability: Available
###############################
Enter appropriate option(1,2,3) for model name[Enter 0 to exit]:1
Please enter the customer's name for the booking of mobile phone: Akhilesh
Thank you Akhilesh!! Your Booking is confirmed 
###############################
Select from below options:
1. Get the booking status of all phones
2. Book phone for testing.
3. Return phone.
4. Get all available phones.
5. Exit
###############################
Enter appropriate option(1,2,3...) to proceed:1
All Phones with status:
        Model: NOKIA_3310, Availability: Available
        Model: SAMSUNG_GALAXY_S9, Availability: Booked by Akhilesh, Booking date 2024-02-29T21:18:53.207880+04:00[Asia/Dubai]
        Model: APPLE_IPHONE_13, Availability: Available
        Model: SAMSUNG_GALAXY_S8, Availability: Available
        Model: ONEPLUS_9, Availability: Available
        Model: APPLE_IPHONE_11, Availability: Available
        Model: IPHONE_X, Availability: Available
        Model: MOTOROLA_NEXUS_6, Availability: Available
        Model: APPLE_IPHONE_12, Availability: Available
###############################
Select from below options:
1. Get the booking status of all phones
2. Book phone for testing.
3. Return phone.
4. Get all available phones.
5. Exit
###############################
Enter appropriate option(1,2,3...) to proceed:3
Enter phone model to return after testing:
###############################
        1.      Model: SAMSUNG_GALAXY_S9, Availability: Booked by Akhilesh, Booking date 2024-02-29T21:18:53.207880+04:00[Asia/Dubai]
        2.      Model: SAMSUNG_GALAXY_S8, Availability: Available
        3.      Model: MOTOROLA_NEXUS_6, Availability: Available
        4.      Model: ONEPLUS_9, Availability: Available
        5.      Model: APPLE_IPHONE_13, Availability: Available
        6.      Model: APPLE_IPHONE_12, Availability: Available
        7.      Model: APPLE_IPHONE_11, Availability: Available
        8.      Model: IPHONE_X, Availability: Available
        9.      Model: NOKIA_3310, Availability: Available
###############################
Enter appropriate option(1,2,3) for model name[Enter 0 to exit]:1
Thanks for returning. Your return is accepted
###############################
Select from below options:
1. Get the booking status of all phones
2. Book phone for testing.
3. Return phone.
4. Get all available phones.
5. Exit
###############################
Enter appropriate option(1,2,3...) to proceed:4
Available Test Phones for booking:
        Model: NOKIA_3310, Availability: Available
        Model: SAMSUNG_GALAXY_S9, Availability: Available
        Model: APPLE_IPHONE_13, Availability: Available
        Model: SAMSUNG_GALAXY_S8, Availability: Available
        Model: ONEPLUS_9, Availability: Available
        Model: APPLE_IPHONE_11, Availability: Available
        Model: IPHONE_X, Availability: Available
        Model: MOTOROLA_NEXUS_6, Availability: Available
        Model: APPLE_IPHONE_12, Availability: Available
###############################
Select from below options:
1. Get the booking status of all phones
2. Book phone for testing.
3. Return phone.
4. Get all available phones.
5. Exit
###############################
Enter appropriate option(1,2,3...) to proceed:5
Thanks for using Mobile Phone Booking System.
Have a great day!!

```



