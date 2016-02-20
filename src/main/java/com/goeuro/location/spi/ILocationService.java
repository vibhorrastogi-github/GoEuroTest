/**
 * ILocationService.java
 */
package com.goeuro.location.spi;

import java.io.IOException;
import java.util.List;

import com.goeuro.location.bean.Location;

/**
 * Feb 20, 20161:11:36 PM
 *
 * @author vibhorr
 */
public interface ILocationService {

    List<Location> get(String cityName) throws IOException;
}
