/**
 * ILocationResponseParser.java
 */
package com.goeuro.location.spi;

import java.io.IOException;
import java.util.List;

import com.goeuro.location.bean.Location;

/**
 * Feb 20, 20162:23:12 PM
 *
 * @author vibhorr
 */
public interface ILocationResponseParser {

    List<Location> parse(String response) throws IOException;
}
