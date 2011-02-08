/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package org.eclipse.ocl.examples.impactanalyzer.util;

import org.eclipse.ocl.examples.impactanalyzer.instanceScope.NavigationStep;

public abstract class SemanticIdentity {
    private boolean currentlyEvaluatingHashCode = false;

    @Override
    public abstract boolean equals(Object arg0);

    @Override
    public synchronized int hashCode() {
	int result = 0;
	if (!currentlyEvaluatingHashCode) {
	    currentlyEvaluatingHashCode = true;
	    result = calculateHashCode();
	}
	currentlyEvaluatingHashCode = false;
	return result;
    }

    protected abstract int calculateHashCode();

    public abstract NavigationStep getStep();
}
