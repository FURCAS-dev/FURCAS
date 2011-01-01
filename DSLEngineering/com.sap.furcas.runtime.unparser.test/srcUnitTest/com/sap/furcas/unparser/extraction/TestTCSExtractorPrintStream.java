/*******************************************************************************
 * Copyright (c) 2008-2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package com.sap.furcas.unparser.extraction;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;

import org.junit.Before;
import org.junit.Test;

public class TestTCSExtractorPrintStream {

    private TCSExtractorStream stream;
    private ByteArrayOutputStream result;

    @Before
    public void initStream() {
        result = new ByteArrayOutputStream();
        // Also add the debug stream to make sure it does not swallow any calls.
        stream = new TCSExtractorStreamDebuggingDecorator(new TCSExtractorPrintStream(result));
    }

    @Test
    public void testPublicInterface() {
        int handleMain = stream.startClassTemplateForObject(null, null);
        stream.printIdentifier("a");
        stream.printWhiteSpace(" ");
        stream.printBoolean(false);

        int handleOuter = stream.startClassTemplateForObject(null, null);
        int handleInner = stream.startClassTemplateForObject(null, null);
        stream.printString("\"", "a(%tok%");
        stream.endClassTemplate(handleInner);
        stream.endClassTemplate(handleOuter);

        stream.printWhiteSpace("\n\n ");

        handleOuter = stream.startClassTemplateForObject(null, null);
        stream.printString("\\\"", "%token%");
        stream.endClassTemplate(handleOuter);

        stream.printWhiteSpace("\n\n ");
        stream.printInteger(2000);

        int handleA = stream.startClassTemplateForObject(null, null);
        int handleB = stream.startClassTemplateForObject(null, null);
        stream.printSymbol("(");
        int handleC = stream.startClassTemplateForObject(null, null);
        stream.printWhiteSpace(" ");
        stream.printIdentifier("PrimitiveTypes");
        stream.endClassTemplate(handleC);
        stream.printSymbol("::");
        handleC = stream.startClassTemplateForObject(null, null);
        stream.printIdentifier("String");
        stream.endClassTemplate(handleC);
        stream.endClassTemplate(handleB);
        stream.endClassTemplate(handleA);

        stream.printWhiteSpace(" ");
        stream.endClassTemplate(handleMain);

        stream.close();

        String refString = "a false\"a(%tok%\"\n\n \\\"%token%\\\"\n\n 2000( PrimitiveTypes::String ";

        assertEquals(refString, result.toString());
    }

    @Test
    public void testBacktrackingResetAll() {
        int handle = stream.createSafePoint();

        int handleMain = stream.startClassTemplateForObject(null, null);
        stream.printIdentifier("a");
        stream.printWhiteSpace(" ");
        stream.printBoolean(false);

        int handleOuter = stream.startClassTemplateForObject(null, null);
        int handleInner = stream.startClassTemplateForObject(null, null);
        stream.printString("\"", "a(%tok%");
        stream.endClassTemplate(handleInner);
        stream.endClassTemplate(handleOuter);

        stream.printWhiteSpace("\n\n ");

        handleOuter = stream.startClassTemplateForObject(null, null);
        stream.printString("\\\"", "%token%");
        stream.endClassTemplate(handleOuter);

        stream.printWhiteSpace("\n\n ");
        stream.printInteger(2000);

        int handleA = stream.startClassTemplateForObject(null, null);
        int handleB = stream.startClassTemplateForObject(null, null);
        stream.printSymbol("(");
        int handleC = stream.startClassTemplateForObject(null, null);
        stream.printWhiteSpace(" ");
        stream.printIdentifier("PrimitiveTypes");
        stream.endClassTemplate(handleC);
        stream.printSymbol("::");
        handleC = stream.startClassTemplateForObject(null, null);
        stream.printIdentifier("String");
        stream.endClassTemplate(handleC);
        stream.endClassTemplate(handleB);
        stream.endClassTemplate(handleA);

        stream.printWhiteSpace(" ");
        stream.endClassTemplate(handleMain);

        stream.resetToSafePoint(handle);

        stream.close();

        String refString = "";

        assertEquals(refString, result.toString());
    }

    @Test
    public void testBacktrackingResetPrimitiveOutput() {
        stream.createSafePoint();

        int handleMain = stream.startClassTemplateForObject(null, null);
        stream.printIdentifier("a");
        stream.printWhiteSpace(" ");
        stream.printBoolean(false);

        int handleOuter = stream.startClassTemplateForObject(null, null);
        int handleInner = stream.startClassTemplateForObject(null, null);
        stream.printString("\"", "a(%tok%");
        stream.endClassTemplate(handleInner);
        stream.endClassTemplate(handleOuter);

        // use backtracking to remove unwanted output
        int handleSavePointInner = stream.createSafePoint();
        stream.printSymbol("::");
        stream.resetToSafePoint(handleSavePointInner);

        stream.printWhiteSpace("\n\n ");

        handleOuter = stream.startClassTemplateForObject(null, null);
        stream.printString("\\\"", "%token%");
        stream.endClassTemplate(handleOuter);

        stream.printWhiteSpace("\n\n ");
        stream.printInteger(2000);

        int handleA = stream.startClassTemplateForObject(null, null);
        int handleB = stream.startClassTemplateForObject(null, null);
        stream.printSymbol("(");
        int handleC = stream.startClassTemplateForObject(null, null);
        stream.printWhiteSpace(" ");
        stream.printIdentifier("PrimitiveTypes");
        stream.endClassTemplate(handleC);
        stream.printSymbol("::");
        handleC = stream.startClassTemplateForObject(null, null);
        stream.printIdentifier("String");
        stream.endClassTemplate(handleC);
        stream.endClassTemplate(handleB);
        stream.endClassTemplate(handleA);

        stream.printWhiteSpace(" ");
        stream.endClassTemplate(handleMain);

        stream.close();

        String refString = "a false\"a(%tok%\"\n\n \\\"%token%\\\"\n\n 2000( PrimitiveTypes::String ";

        assertEquals(refString, result.toString());
    }

    @Test
    public void testBacktrackingResetTemplateOutput() {
        stream.createSafePoint();

        int handleMain = stream.startClassTemplateForObject(null, null);
        stream.printIdentifier("a");
        stream.printWhiteSpace(" ");
        stream.printBoolean(false);

        int handleOuter = stream.startClassTemplateForObject(null, null);
        int handleInner = stream.startClassTemplateForObject(null, null);
        stream.printString("\"", "a(%tok%");
        stream.endClassTemplate(handleInner);
        stream.endClassTemplate(handleOuter);

        // use backtracking to remove unwanted output
        int handleSafePointInner = stream.createSafePoint();
        handleOuter = stream.startClassTemplateForObject(null, null);
        stream.createSafePoint();
        handleInner = stream.startClassTemplateForObject(null, null);
        stream.printString("\"", "a(%tok%");
        stream.endClassTemplate(handleInner);
        stream.endClassTemplate(handleOuter);
        stream.resetToSafePoint(handleSafePointInner);

        stream.printWhiteSpace("\n\n ");

        handleOuter = stream.startClassTemplateForObject(null, null);
        stream.printString("\\\"", "%token%");
        stream.endClassTemplate(handleOuter);

        stream.printWhiteSpace("\n\n ");
        stream.printInteger(2000);

        int handleA = stream.startClassTemplateForObject(null, null);
        int handleB = stream.startClassTemplateForObject(null, null);
        stream.printSymbol("(");
        int handleC = stream.startClassTemplateForObject(null, null);
        stream.printWhiteSpace(" ");
        stream.printIdentifier("PrimitiveTypes");
        stream.endClassTemplate(handleC);
        stream.printSymbol("::");
        handleC = stream.startClassTemplateForObject(null, null);
        stream.printIdentifier("String");
        stream.endClassTemplate(handleC);
        stream.endClassTemplate(handleB);
        stream.endClassTemplate(handleA);

        stream.printWhiteSpace(" ");
        stream.endClassTemplate(handleMain);

        stream.close();

        String refString = "a false\"a(%tok%\"\n\n \\\"%token%\\\"\n\n 2000( PrimitiveTypes::String ";

        assertEquals(refString, result.toString());
    }

}
