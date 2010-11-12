/**
 * <copyright>
 * 
 * Copyright (c) 2008,2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: ICSTFileAnalyzer.java,v 1.2 2010/04/08 06:26:25 ewillink Exp $
 */
package org.eclipse.ocl.examples.parser.environment;

import java.io.IOException;
import java.io.Reader;

import org.eclipse.ocl.lpg.AbstractParser;

/**
 * ICSTFileAnalyzer defines the required interface of the analyzer used
 * to perform lexical, syntactic ansd semantic analysis.
 */
public interface ICSTFileAnalyzer<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E, R extends ICSTRootEnvironment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>>
{
	public boolean analyze(R rootEnvironment);

	public AbstractParser getParser();

	public void reset(Reader reader, String fileName) throws IOException;
}
