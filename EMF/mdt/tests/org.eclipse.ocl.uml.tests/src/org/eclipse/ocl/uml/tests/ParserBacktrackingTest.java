/**
 * <copyright>
 * 
 * Copyright (c) 2009 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *   E.D.Willink - Bug 298634
 *
 * </copyright>
 *
 * $Id: ParserBacktrackingTest.java,v 1.2 2010/04/25 06:50:11 ewillink Exp $
 */

package org.eclipse.ocl.uml.tests;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.tests.GenericParserBacktrackingTest;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.SendSignalAction;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.Type;

/**
 * Tests for error reports from the backtracking parser.
 */
public class ParserBacktrackingTest
extends GenericParserBacktrackingTest<EObject, Package, Type, Classifier, Class, DataType, PrimitiveType, Enumeration, Operation, Parameter, Property,
Property, Property, EnumerationLiteral, State, CallOperationAction, SendSignalAction, Constraint> {

	@Override
	public UMLTestReflection.Static getStaticReflection() {
		return UMLTestReflection.Static.INSTANCE;
	}
}
