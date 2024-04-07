package com.ocado;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Helper class for handling files.
 * 
 * @author Maciej Chamera
 */
public class IOUtils {
    /**
     * Reads file from absolute path as string.
     * 
     * @param absolutePath absolute path to the file.
     * @return String containing all lines of the file.
     * @throws IOException if file can not be found.
     */
    public static final String readFileAsString(final String absolutePath) throws IOException {
        String lines = "";
        File myObj = new File(absolutePath);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            lines += myReader.nextLine();
            if (myReader.hasNextLine())
                lines += "\n";
        }
        myReader.close();
        return lines;
    }

}
