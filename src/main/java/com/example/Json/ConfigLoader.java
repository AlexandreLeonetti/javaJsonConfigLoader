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
        
        ObjectMapper tradeMapper = new ObjectMapper();
        tradeMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
        	Trades trades = tradeMapper.readValue(new File("trades.json"), Trades.class);
        	Trades.TradeDetails tradeDetails = trades.getTradeDetailsByName("BNBUSDT");
        	System.out.println(" we are here and tradeDetails is equal to "+ tradeDetails);
        	if(tradeDetails != null) {
        		System.out.println("Name of the pair is : "+ tradeDetails.getName());
        		System.out.println("Size of the order is : "+ tradeDetails.getSize());
        		System.out.println("Minimum price is : "+ tradeDetails.getMinPrice());
        	}else {
        		System.out.println("TradeDetails is null");
        	}
        }catch(IOException e) {
        	e.printStackTrace();
        }
        
    }
}


