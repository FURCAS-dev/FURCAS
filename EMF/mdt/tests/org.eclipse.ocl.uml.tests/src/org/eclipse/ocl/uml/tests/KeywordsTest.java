/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - Bug 296409
 *
 * </copyright>
 *
 * $Id: KeywordsTest.java,v 1.8 2009/12/16 21:00:47 ewillink Exp $
 */

package org.eclipse.ocl.uml.tests;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.tests.GenericKeywordsTest;
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
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Tests for usages of model features whose names coincide with "keywords"
 * defined as reserved words by the OCL specification and/or by the LPG grammar.
 *
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public class KeywordsTest
extends GenericKeywordsTest<EObject, Package, Type, Classifier, Class, DataType, PrimitiveType, Enumeration, Operation, Parameter, Property,
Property, Property, EnumerationLiteral, State, CallOperationAction, SendSignalAction, Constraint> {

	@Override
	public UMLTestReflection.Static getStaticReflection() {
		return UMLTestReflection.Static.INSTANCE;
	}

	@Override
	protected void setUp() {
		super.setUp();
        
        StateMachine machine = (StateMachine) elseClass.createOwnedBehavior(
            "StateMachine", UMLPackage.Literals.STATE_MACHINE);
        State state = (State) machine.createRegion("region").createSubvertex(
            "init", UMLPackage.Literals.STATE);
        state.createRegion("region").createSubvertex("body",
            UMLPackage.Literals.STATE);
	}
    
	public void test_body_162300() {
        Classifier metaclass = getMetaclass("OpaqueExpression");
		assertInvariant(metaclass, "self.language->includes('OCL') implies self._body->notEmpty()");
        assertInvariant(metaclass, "language->includes('OCL') implies _body->notEmpty()");
    }
    
    public void test_reservedStateName_183362() {
        assertInvariant(elseClass, "not self.oclIsInState(_init::_body)");
    }
}
