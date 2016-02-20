/**
 * GoEuroMain.java
 */
package com.goeuro.location.domain;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Feb 20, 20161:15:28 PM
 *
 * @author vibhorr
 */
public class GoEuroMain {

    /**
     * main method
     * 
     * @param args
     */
    public static void main(String[] args) {

        final ClassPathXmlApplicationContext ctx =
                new ClassPathXmlApplicationContext("META-INF/spring/appCtx.xml");

        try {

            final String cityName = CommandLineParser.getCityName(args);

            final LocationManager locationManager = ctx.getBean(LocationManager.class);

            locationManager.processLocation(cityName);

        } catch (final Exception e) {

            System.err.println("\n####\n" + getMessage(e) + "####\n");
        }

        ctx.close();
    }

    /**
     * @param e
     * @return
     */
    private static String getMessage(Throwable e) {

        final StringBuilder sb = new StringBuilder();

        while (e != null) {

            sb.append(e.getMessage() + "\n");

            e = e.getCause();
        }

        return sb.toString();
    }

}
