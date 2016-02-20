/**
 * WebAPILocationResponseParser.java
 */
package com.goeuro.location.domain;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.goeuro.location.bean.Location;
import com.goeuro.location.spi.ILocationResponseParser;

/**
 * Feb 20, 20162:22:55 PM
 *
 * @author vibhorr
 */
public class WebAPILocationResponseParser implements ILocationResponseParser {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(WebAPILocationResponseParser.class);

    private final ObjectMapper mapper;

    public WebAPILocationResponseParser(final ObjectMapper mapper) {

        this.mapper = mapper;
    }

    /**
     * (non-Javadoc)
     * 
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     * 
     * @see com.goeuro.location.spi.ILocationResponseParser#parse(java.lang.String)
     */
    public List<Location> parse(final String response) throws IOException {

        final Location[] locationArray =
                mapper.readValue(new StringReader(response), Location[].class);

        final List<Location> locations = new ArrayList<Location>(Arrays.asList(locationArray));

        LOGGER.debug("parsed response: {}", locations);

        return locations;
    }

    public static void main(String[] args) throws Exception {

        final BufferedReader rd = new BufferedReader(new InputStreamReader(
                new FileInputStream("src/main/resources/sampleResponse.json")));

        final StringBuilder result = new StringBuilder();

        String line;

        while ((line = rd.readLine()) != null) {

            result.append(line);
        }

        rd.close();

        System.out.println(
                new WebAPILocationResponseParser(new ObjectMapper()).parse(result.toString()));
    }

}
