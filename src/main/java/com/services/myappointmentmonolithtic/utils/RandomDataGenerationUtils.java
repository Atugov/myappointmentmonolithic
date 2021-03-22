package com.services.myappointmentmonolithtic.utils;

import java.util.Random;

public class RandomDataGenerationUtils {
    static Random random = new Random();

    public static int generateRandomNumber(int from, int to) {
        int randomNumber = from + random.nextInt(from - to);
        return randomNumber;
    }

}
