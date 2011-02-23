/*******************************************************************************
 * Copyright (c) 2011 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package com.sap.furcas.runtime.parser.testbase;

import static org.junit.Assert.fail;

import org.antlr.tool.Message;

import com.sap.furcas.parsergenerator.GenerationErrorHandler;
import com.sap.furcas.runtime.parser.ParsingError;

public class FailOnErrorErrorHandler implements GenerationErrorHandler {

    @Override
    public void error(ParsingError exception) {
        System.err.println("ERROR: " + exception.getMessage());
        fail(exception.getMessage());
    }

    @Override
    public void fatalError(ParsingError exception) {
        System.err.println("FATAL ERROR: " + exception.getMessage());
        fail(exception.getMessage());
    }

    @Override
    public void warning(ParsingError exception) {
        System.out.println("WARNING: " + exception.getMessage());
    }

    @Override
    public void error(Message err) {
        System.err.println("ERROR: " + err);
        fail(err.toString());
    }

    @Override
    public void warn(Message warn) {
        System.out.println("WARNING: " + warn);
    }

    @Override
    public void info(String info) {
        System.out.println("INFO: " + info);
    }

}
