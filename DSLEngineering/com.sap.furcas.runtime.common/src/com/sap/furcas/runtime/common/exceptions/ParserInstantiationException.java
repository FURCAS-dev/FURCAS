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
package com.sap.furcas.runtime.common.exceptions;

/**
 * Thrown when it was not possible to instantiate a parser.
 * 
 * @author Stephan Erb
 *
 */
public class ParserInstantiationException extends AbstractToolGenerationException {
    
    private static final long serialVersionUID = 2335703347680036783L;

    public ParserInstantiationException(Throwable cause) {
        super(cause);
    }

}
