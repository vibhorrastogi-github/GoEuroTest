/**
 * CSVLocationFileCreator.java
 */
package com.goeuro.location.domain;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.goeuro.location.bean.Location;
import com.goeuro.location.spi.ILocationFileCreator;
import com.goeuro.location.util.CSVWriter;

/**
 * Feb 20, 20161:09:45 PM
 *
 * @author vibhorr
 */
public class CSVLocationFileCreator implements ILocationFileCreator {

    private static final Logger LOGGER = LoggerFactory.getLogger(CSVLocationFileCreator.class);

    private static final String LOCATIONS_CSV_FILE_NAME = "_locations.csv";

    private static final String LOCATIONS_CSV_FILE_HEADER = "_id, name, type, latitude, longitude";

    private static final char COMMA = ',';

    /**
     * (non-Javadoc)
     * 
     * @throws IOException
     * 
     * @see com.goeuro.location.spi.ILocationFileCreator#create(com.goeuro.location.bean.Location)
     */
    public void create(final List<Location> locations, final String cityName) throws IOException {

        LOGGER.info("going to create csv file of locations...location.size(): {}",
                locations.size());

        final List<String> lines = getLines(locations);

        final File csvFile = new File(cityName + LOCATIONS_CSV_FILE_NAME);

        CSVWriter.write(LOCATIONS_CSV_FILE_HEADER, lines, csvFile);

        LOGGER.info("\n\n****CSV FILE CREATED****, FILE PATH: {}", csvFile.getAbsolutePath() + "\n");
    }

    private List<String> getLines(final List<Location> locations) {

        final List<String> lines = new ArrayList<String>();

        for (final Location location : locations) {

            final StringBuilder sb = new StringBuilder();

            sb.append(location.get_id()).append(COMMA).append(location.getName()).append(COMMA)
                    .append(location.getType()).append(COMMA)
                    .append(location.getGeo_position().getLatitude()).append(COMMA)
                    .append(location.getGeo_position().getLongitude());

            lines.add(sb.toString());
        }

        return lines;
    }

}
