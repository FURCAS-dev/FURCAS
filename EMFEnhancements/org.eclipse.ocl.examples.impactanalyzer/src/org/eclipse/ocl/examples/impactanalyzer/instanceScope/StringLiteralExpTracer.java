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
package org.eclipse.ocl.examples.impactanalyzer.instanceScope;

import java.util.Stack;

import org.eclipse.ocl.ecore.StringLiteralExp;
import org.eclipse.ocl.examples.impactanalyzer.OCLFactory;


public class StringLiteralExpTracer extends AbstractTracer<StringLiteralExp> {
	public StringLiteralExpTracer(StringLiteralExp expression, Stack<String> tuplePartNames, OCLFactory oclFactory) {
		super(expression, tuplePartNames, oclFactory);
	}

}
