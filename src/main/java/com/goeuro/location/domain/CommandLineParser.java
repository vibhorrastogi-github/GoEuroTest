/**
 * CommandLineParser.java
 */
package com.goeuro.location.domain;

/**
 * Feb 20, 20161:41:13 PM
 *
 * @author vibhorr
 */
public class CommandLineParser {

    private static final String OPTION =
            "cityName is required in input. sample: java -jar GoEuroTest.jar \"Berlin\"";

    public static String getCityName(final String[] args) {

        validateArgs(args);

        return args[0];
    }

    private static void validateArgs(final String[] args) {

        if (args == null || args.length == 0) {

            throw new IllegalArgumentException("invalid input, args is null or empty \n" + OPTION);
        }

        if (args.length > 1) {

            throw new IllegalArgumentException(
                    "invalid input, only one cityName is accepted in input, \n" + OPTION);
        }
    }
}
