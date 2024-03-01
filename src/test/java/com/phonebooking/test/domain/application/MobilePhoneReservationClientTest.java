package com.phonebooking.test.domain.application;

import com.phonebooking.application.MobilePhoneReservationClient;
import com.phonebooking.domain.model.ModelName;
import com.phonebooking.domain.service.MobilePhoneBookingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class MobilePhoneReservationClientTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testStart_DisplayOptionsAndExit() {
        // Arrange
        ByteArrayInputStream inputStream = new ByteArrayInputStream("5\n".getBytes());
        System.setIn(inputStream);
        MobilePhoneBookingService phoneService = Mockito.mock(MobilePhoneBookingService.class);
        Scanner scanner = new Scanner(System.in);
        MobilePhoneReservationClient client = new MobilePhoneReservationClient(scanner, phoneService);

        // Act
        client.start();

        // Assert
        String expectedOutput = "######### WelcomeTo Mobile Phone Test Devices Booking System #########\n" +
                "###############################\n" +
                "Select from below options:\n" +
                "1. Get the booking status of all phones\n" +
                "2. Book phone for testing.\n" +
                "3. Return phone.\n" +
                "4. Get all available phones.\n" +
                "5. Exit\n" +
                "###############################\n" +
                "Enter appropriate option(1,2,3...) to proceed:" +
                "Thanks for using Mobile Phone Booking System.\n" +
                "Have a great day!!\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testStart_DisplayOptions_And_Show_Available_Phones() {
        // Arrange
        ByteArrayInputStream inputStream = new ByteArrayInputStream("4\n5\n".getBytes());
        System.setIn(inputStream);
        MobilePhoneBookingService phoneService = Mockito.mock(MobilePhoneBookingService.class);
        Scanner scanner = new Scanner(System.in);
        MobilePhoneReservationClient client = new MobilePhoneReservationClient(scanner, phoneService);

        // Act
        client.start();

        // Assert
        verify(phoneService,times(1)).displayPhonesAvailableForBooking();
    }

    @Test
    public void testStart_BookPhoneOption_SuccessfulBooking() {
        // Arrange
        ByteArrayInputStream inputStream = new ByteArrayInputStream("2\n1\nAkhilesh\n5\n".getBytes());
        System.setIn(inputStream);
        MobilePhoneBookingService phoneService = Mockito.mock(MobilePhoneBookingService.class);
        when(phoneService.bookPhone(any(ModelName.class), any(String.class))).thenReturn(0);
        Scanner scanner = new Scanner(System.in);
        MobilePhoneReservationClient client = new MobilePhoneReservationClient(scanner, phoneService);

        // Act
        client.start();

        // Assert
        verify(phoneService,times(1)).bookPhone(any(), argThat(x->x.equals("Akhilesh")));
    }

    @Test
    public void testStart_Return_PhoneOption_SuccessfulBooking() {
        // Arrange
        ByteArrayInputStream inputStream = new ByteArrayInputStream("3\n1\n5\n".getBytes());
        System.setIn(inputStream);
        MobilePhoneBookingService phoneService = Mockito.mock(MobilePhoneBookingService.class);
        when(phoneService.bookPhone(any(ModelName.class), any(String.class))).thenReturn(0);
        Scanner scanner = new Scanner(System.in);
        MobilePhoneReservationClient client = new MobilePhoneReservationClient(scanner, phoneService);

        // Act
        client.start();

        // Assert
        verify(phoneService,times(1)).returnPhone(any());
    }
}
