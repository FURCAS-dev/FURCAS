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
package com.sap.furcas.prettyprinter.stubs;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.TCS.ContextTemplate;
import com.sap.furcas.prettyprinter.TemplateFinder;

/**
 * @author Stephan Erb
 *
 */
public class MockContextTemplateFinder extends TemplateFinder {

    private final ContextTemplate hardcodedTemplate;

    public MockContextTemplateFinder(ContextTemplate hardcodedTemplate) {
        super(/*syntaxLookup*/ null, /*metamodelLookup*/ null);
        this.hardcodedTemplate = hardcodedTemplate;
    }

    @Override
    public Collection<ContextTemplate> findMatchingContextTemplates(EObject modelElement, String mode) {
        return Collections.<ContextTemplate>singletonList(hardcodedTemplate);
    }
}
