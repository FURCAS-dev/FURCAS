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
package com.sap.furcas.runtime.referenceresolving;

import com.sap.furcas.runtime.parser.impl.ModelUpdaterRegistry;

/**
 * Helper class to break dependencies on OSGI. Clients of the ModelUpdaterRegistry should
 * not have to depend on OSGI just because our implementation, the SyntaxRegistry, does.
 */
public class SyntaxRegistryFacade  {

    public static ModelUpdaterRegistry getModelUpdaterRegistry() {
        return SyntaxRegistry.getInstance();
    }
}
