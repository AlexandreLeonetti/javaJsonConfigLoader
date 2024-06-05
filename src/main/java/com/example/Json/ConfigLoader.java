//ConfigLoader.java
package com.example.Json;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ConfigLoader {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            Config config = mapper.readValue(new File("config.json"), Config.class);

            Config.PrecisionDetails details = config.getPrecisionDetailsByName("BTCTUSD");
            if (details != null) {
            	System.out.println("Name of the pair " + details.getName());
                System.out.println("Price Precision: " + details.getPricePrecision());
                System.out.println("Size Precision: " + details.getSizePrecision());
            } else {
                System.out.println("Details not found for the given name.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


