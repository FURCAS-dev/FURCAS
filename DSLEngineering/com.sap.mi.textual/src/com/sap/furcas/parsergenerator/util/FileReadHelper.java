/**
 * 
 */
package com.sap.furcas.parsergenerator.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
    
}
