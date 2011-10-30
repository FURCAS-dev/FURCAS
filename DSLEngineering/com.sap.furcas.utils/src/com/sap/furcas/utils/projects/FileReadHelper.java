/**
 * 
 */
package com.sap.furcas.utils.projects;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 *
 */
public class FileReadHelper {

    /**
     * @param grammarFile
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static byte[] readBytesFromFile(File grammarFile)
            throws FileNotFoundException, IOException {
        byte[] oldBytes = null;
        if (grammarFile.exists()) {
            FileReader reader = new FileReader(grammarFile);
            ByteArrayOutputStream oldBytesStream = new ByteArrayOutputStream();
            while (reader.ready()) {
                oldBytesStream.write(reader.read());
            }
            oldBytesStream.flush();
            oldBytes = oldBytesStream.toByteArray();
            oldBytesStream.close();
        }
        return oldBytes;
    }
    
    public static String readInput(InputStream in) throws IOException {
        InputStreamReader isr = new InputStreamReader(in);
        Reader reader = new BufferedReader(isr);
        StringBuilder s = new StringBuilder();
        char buffer[] = new char[2048];
        int size;
        while((size = reader.read(buffer)) > 0) {
            s.append(buffer, 0, size);
        }
        return s.toString();
    }
    
}
