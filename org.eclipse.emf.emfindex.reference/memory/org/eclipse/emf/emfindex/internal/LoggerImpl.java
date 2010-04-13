/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex.internal;

import org.eclipse.emf.emfindex.Logger;


/**
 * Allows logging to stderr
 * 
 * @author Jan Köhnlein - Initial contribution and API
 */
public class LoggerImpl implements Logger {

	public void logError(String message, Throwable t) {
		System.err.println(message);
		t.printStackTrace();
	}

	public void logError(String message) {
		System.err.println(message);
	}
}
