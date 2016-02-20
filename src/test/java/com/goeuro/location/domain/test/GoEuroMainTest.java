/**
 * GoEuroMainTest.java
 */
package com.goeuro.location.domain.test;

import static com.goeuro.location.domain.CSVLocationFileCreator.LOCATIONS_CSV_FILE_NAME;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

import com.goeuro.location.domain.GoEuroMain;

/**
 * Feb 20, 20164:51:30 PM
 *
 * @author vibhorr
 */
public class GoEuroMainTest {


    @Test
    public void testMain() {

        final String cityName = "Berlin";

        final String[] args = new String[] {cityName};

        GoEuroMain.main(args);

        final File csvFile = new File(cityName + LOCATIONS_CSV_FILE_NAME);

        Assert.assertTrue((csvFile.exists()));
    }
}
