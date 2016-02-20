/**
 * CSVWriter.java
 */
package com.goeuro.location.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Feb 20, 20163:13:18 PM
 *
 * @author vibhorr
 */
public class CSVWriter {

    public static void write(final String header, final List<String> lines, final File csvFile)
            throws IOException {

        if (!csvFile.exists() || !csvFile.isFile()) {

            csvFile.createNewFile();
        }

        final FileWriter writer = new FileWriter(csvFile);

        writer.append(header);
        writer.append('\n');

        for (final String line : lines) {

            writer.append(line);
            writer.append('\n');
        }

        writer.flush();

        writer.close();
    }
}
