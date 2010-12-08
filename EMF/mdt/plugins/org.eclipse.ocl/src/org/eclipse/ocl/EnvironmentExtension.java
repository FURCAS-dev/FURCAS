/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: AbstractEnvironment.java,v 1.20 2009/12/04 21:25:20 ewillink Exp $
 */
package org.eclipse.ocl;

import org.eclipse.ocl.helper.OCLSyntaxHelper;
import org.eclipse.ocl.parser.OCLAnalyzer;
import org.eclipse.ocl.parser.backtracking.OCLBacktrackingParser;
import org.eclipse.ocl.utilities.Visitor;


/**
 * An EnvironmentExtension provides additional API necessary to support the variant
 * behaviour for resolving hidden opposites in Ecore meta-models.
 * @since 3.1
 */
public interface EnvironmentExtension<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	extends Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
{
	/**
	 * Creates an instance of the OCLAnalyzer that analyzes the
	 * given input on behalf of this environment.
	 * 
	 * @param input the text to be analyzed
	 * 
	 * @return an OCLAnalyzer instance for this environment
	 */
	OCLAnalyzer<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> createOCLAnalyzer(String input);

	/**
	 * Creates an instance of the OCLAnalyzer that analyzes the
	 * given parser's input on behalf of this environment.
	 * 
	 * @param parser performing syntax analysis
	 * 
	 * @return an OCLAnalyzer instance for this environment
	 */
	OCLAnalyzer<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> createOCLAnalyzer(OCLBacktrackingParser parser);

	/**
	 * Creates an instnace of the OCLSyntaxHelper object for this environment.
	 * 
	 * @return an OCLSyntaxHelper instance for this environment
	 */
	OCLSyntaxHelper createOCLSyntaxHelper();

	/**
	 * Creates an instance of the validation visitor that validates against
	 * this environment, which presumably was used in parsing the OCL in
	 * the first place.
	 * 
	 * @return a validation visitor instance for this environment
	 */
	Visitor<Boolean, C, O, P, EL, PM, S, COA, SSA, CT> createValidationVisitor();
}
