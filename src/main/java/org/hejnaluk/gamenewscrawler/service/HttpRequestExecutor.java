package org.hejnaluk.gamenewscrawler.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequestExecutor {

    Logger logger = LoggerFactory.getLogger(HttpRequestExecutor.class.getName());
    
    public String call (URL url) throws IOException {
        logger.info("HttpRequestExecutor::call start");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        logger.info("HttpRequestExecutor::call url");

        try (   InputStreamReader reader = new InputStreamReader(con.getInputStream(), "UTF-8");
                BufferedReader in = new BufferedReader(reader)) {
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
        }

        logger.info("HttpRequestExecutor::call data received");

        String receivedData = content.toString();

        return receivedData;
    }
}
