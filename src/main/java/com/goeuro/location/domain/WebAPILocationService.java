/**
 * LocationService.java
 */
package com.goeuro.location.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.goeuro.location.bean.Location;
import com.goeuro.location.spi.ILocationService;

/**
 * Feb 20, 201612:54:18 PM
 *
 * @author vibhorr
 */
public class WebAPILocationService implements ILocationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebAPILocationService.class);

    private final String baseUrl;

    private final HttpClient client;

    private final WebAPILocationResponseParser responseParser;

    /**
     * @param baseUrl
     * @param responseParser
     */
    public WebAPILocationService(final String baseUrl,
            final WebAPILocationResponseParser responseParser) {

        this.baseUrl = baseUrl;

        this.responseParser = responseParser;

        client = HttpClientBuilder.create().build();
    }

    /**
     * (non-Javadoc)
     * 
     * @see com.goeuro.location.spi.ILocationService#get(java.lang.String)
     */
    public List<Location> get(final String cityName) throws IOException {

        final String url = baseUrl.concat(cityName);

        final HttpResponse httpResponse = client.execute(new HttpGet(url));

        final int responseCode = httpResponse.getStatusLine().getStatusCode();

        LOGGER.info("response code: {}", responseCode);

        final String response = readResponse(httpResponse);

        LOGGER.debug("response: {}", response);

        if (responseCode != 200) {

            throw new IllegalStateException("invalid response code: " + responseCode
                    + ", 200 expected, response: " + response);
        }

        return responseParser.parse(response);
    }

    /**
     * @param httpresponse
     * @return
     * @throws IOException
     */
    private String readResponse(final HttpResponse httpresponse) throws IOException {

        final BufferedReader rd =
                new BufferedReader(new InputStreamReader(httpresponse.getEntity().getContent()));

        final StringBuilder sb = new StringBuilder();

        String line;

        while ((line = rd.readLine()) != null) {

            sb.append(line);
        }

        rd.close();

        final String response = sb.toString();

        return response;
    }
}
