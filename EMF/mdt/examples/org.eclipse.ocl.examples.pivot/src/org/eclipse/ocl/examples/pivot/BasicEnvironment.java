/**
 * <copyright>
 *
 * Copyright (c) 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - Lexer and Parser refactoring to support extensibility and flexible error handling 
 *
 * </copyright>
 *
 * $Id: BasicEnvironment.java,v 1.1 2011/02/11 20:00:29 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

/**
 * A <code>BasicEnvironment</code> provides input token and output problem support for a text analysis
 * comprising an <code>AbstractAnalyzer</code> for semantic analysis,
 * <code>AbstractParser</code> for syntactic analysis
 * (parsing), and an <code>AbstractLexer</code> for lexical analysis.
 */
public interface BasicEnvironment extends Adaptable, Customizable
{	
}
