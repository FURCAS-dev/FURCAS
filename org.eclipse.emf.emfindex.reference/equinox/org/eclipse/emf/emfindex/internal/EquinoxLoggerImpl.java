/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex.internal;

import org.eclipse.emf.emfindex.EmfIndexPlugin;
import org.eclipse.emf.emfindex.Logger;

/**
 * @author koehnlein
 *
 */
public class EquinoxLoggerImpl implements Logger {

	public void logError(String message, Throwable t) {
		EmfIndexPlugin.logError(message, t);
	}

	public void logError(String message) {
		EmfIndexPlugin.logError(message);
	}

}
