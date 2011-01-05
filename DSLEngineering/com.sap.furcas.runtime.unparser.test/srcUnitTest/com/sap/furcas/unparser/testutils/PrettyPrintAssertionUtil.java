package com.sap.furcas.unparser.testutils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.runtime.textblocks.model.TextBlocksModel;

public class PrettyPrintAssertionUtil {

    public static void assertEqualsIgnoreWhitespaces(String message, String expected, String actual) {
	assertEquals(message, stripWhiteSpace(expected), stripWhiteSpace(actual));
    }
    
    public static void assertEqualsIgnoreWhitespaces(String expected, String actual) {
        assertEquals(stripWhiteSpace(expected), stripWhiteSpace(actual));
    }

    private static String stripWhiteSpace(String expected) {
	return expected.replaceAll(" ", "").replaceAll("\n", "").replaceAll("\r", "").replaceAll("\t", "");
    }       
          
    public static void assertEqualsByLines(String output, String referenceOutput) {
        BufferedReader actualOutputStream = new BufferedReader(new StringReader(output));
        BufferedReader referenceOutputStream = new BufferedReader(new StringReader(referenceOutput));

        String refLine;
        String actualLine;
        int line = 0;
        try {
            refLine = referenceOutputStream.readLine();
            actualLine = actualOutputStream.readLine();

            while (refLine != null) {
                assertEquals("error in line " + line + ":\n actual output was \n" + output + "\n reference output was \n "
                        + referenceOutput + "\n", refLine, actualLine);
                refLine = referenceOutputStream.readLine();
                actualLine = actualOutputStream.readLine();
                line++;
            }

            if (actualLine != null) {
                fail("error in line " + line + ":\n actual output was \n" + output + "\n reference output was \n "
                        + referenceOutput + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
            fail("error comparing streams");
        }
    }

    public static void assertEqualsByLines(TextBlock textBlock, String referenceOutput) {
        TextBlocksModel model = new TextBlocksModel(textBlock, /*modelAdapter*/ null);
        String output = model.get(0, model.getLength());
        assertEqualsByLines(output, referenceOutput);
        
    }
    
}
