/*******************************************************************************
 * Copyright (c) 2008 ikv++ technologies ag and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     ikv++ technologies ag - initial API and implementation
 *******************************************************************************/

package de.ikv.medini.qvt.syntax.parser;

import java.io.Reader;

import org.oslo.ocl20.syntax.ast.qvt.TopLevelAS;

import uk.ac.kent.cs.kmf.util.ILog;

public interface QvtParser {

	java_cup.runtime.lr_parser createParser(Reader reader, ILog log);

	/**
	 * Parse the given reader with/without debugging info, reporting errors on given log
	 * 
	 * The result is null if an error is reported
	 * 
	 */
	TopLevelAS parse(Reader reader, ILog log, boolean debug);

	/**
	 * Check if the parser encountered an error
	 * 
	 */
	boolean hasErrors();

	/**
	 * Check if the parser encountered a warning
	 * 
	 */
	boolean hasWarnings();
}
