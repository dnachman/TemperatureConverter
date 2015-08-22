package com.logicalenigma.temperatureconverter;

/**
 * Copyright 2015 Logical Enigma
 * Created by dnachman on 8/22/15.
 */
public class TemperatureUtil {

    public static float convertToCelsius(float fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static float convertToFahrenheit(float celsius) {
        return ((celsius * 9) / 5) + 32;
    }
}
