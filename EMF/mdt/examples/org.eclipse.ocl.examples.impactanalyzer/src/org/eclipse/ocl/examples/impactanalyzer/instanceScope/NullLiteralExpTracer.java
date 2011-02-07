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

import org.eclipse.ocl.ecore.NullLiteralExp;
import org.eclipse.ocl.examples.impactanalyzer.OCLFactory;


public class NullLiteralExpTracer extends AbstractTracer<NullLiteralExp> {
	public NullLiteralExpTracer(NullLiteralExp expression, Stack<String> tuplePartNames, OCLFactory oclFactory) {
		super(expression, tuplePartNames, oclFactory);
	}
}
