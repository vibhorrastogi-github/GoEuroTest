/**
 * ILocationFileCreator.java
 */
package com.goeuro.location.spi;

import java.io.IOException;
import java.util.List;

import com.goeuro.location.bean.Location;

/**
 * Feb 20, 20161:09:11 PM
 *
 * @author vibhorr
 */
public interface ILocationFileCreator {

    void create(List<Location> locations, String cityName) throws IOException;
}
