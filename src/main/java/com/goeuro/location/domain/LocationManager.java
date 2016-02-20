/**
 * LocationManager.java
 */
package com.goeuro.location.domain;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.goeuro.location.bean.Location;
import com.goeuro.location.spi.ILocationFileCreator;
import com.goeuro.location.spi.ILocationService;

/**
 * Feb 20, 20161:05:14 PM
 *
 * @author vibhorr
 */
public class LocationManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocationManager.class);

    private final ILocationService locationService;

    private final ILocationFileCreator fileCreator;

    /**
     * @param locationService
     * @param fileCreator
     */
    public LocationManager(final ILocationService locationService,
            final ILocationFileCreator fileCreator) {

        this.locationService = locationService;

        this.fileCreator = fileCreator;
    }

    /**
     * @param cityName
     */
    public void processLocation(final String cityName) {

        LOGGER.info("going to process location, cityName: {}", cityName);

        try {

            final List<Location> locations = locationService.get(cityName);

            if (locations == null || locations.isEmpty()) {

                throw new IllegalStateException("locations not found by cityName: " + cityName);
            }

            fileCreator.create(locations, cityName);

            LOGGER.info("location processes successfully, cityName: {}", cityName);

        } catch (final IOException e) {

            throw new IllegalStateException("unable to process location, cityName: " + cityName, e);
        }
    }
}
