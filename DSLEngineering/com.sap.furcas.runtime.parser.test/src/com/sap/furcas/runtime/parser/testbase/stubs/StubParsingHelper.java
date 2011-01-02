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
package com.sap.furcas.runtime.parser.testbase.stubs;

import com.sap.furcas.runtime.parser.IModelAdapter;
import com.sap.furcas.runtime.parser.ModelParsingResult;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.testbase.AbstractParsingHelper;

/**
 * Parsing helper for parsing text fragments / files that uses a {@link StubModelAdapter}.
 * No real element will be created during parsing.
 */
public class StubParsingHelper extends AbstractParsingHelper<StubModelAdapter> {

    public StubParsingHelper(ParserFacade parserFacade) {
        super(parserFacade);
    }

    @Override
    protected IModelAdapter createModelAdapter() {
        return new StubModelAdapter();
    }

    @Override
    protected StubModelAdapter createParsingResult(IModelAdapter modelAdapter, ModelParsingResult result) {
        return (StubModelAdapter) modelAdapter;
    }

}
