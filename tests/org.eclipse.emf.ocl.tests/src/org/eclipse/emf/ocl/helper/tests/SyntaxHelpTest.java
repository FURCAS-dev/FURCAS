/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */

package org.eclipse.emf.ocl.helper.tests;

import java.util.List;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ocl.helper.ChoiceType;
import org.eclipse.emf.ocl.helper.HelperUtil;
import org.eclipse.emf.ocl.helper.IOclHelper;

/**
 * Tests the syntax help support, esp. for operation context.
 *
 * @author Christian W. Damus (cdamus)
 */
public class SyntaxHelpTest
	extends AbstractTestSuite {

	/**
	 * Initializes me with my name.
	 */
	public SyntaxHelpTest(String name) {
		super(name);
	}
	
	public static Test suite() {
		return new TestSuite(SyntaxHelpTest.class, "Syntax Help Tests"); //$NON-NLS-1$
	}
	
	/**
	 * Basic completion test for metamodel level.
	 */
	public void testMetaModelCompletions() {
		IOclHelper helper = HelperUtil.createOclHelper();
		
		helper.setContext(EcorePackage.eINSTANCE.getEClass());
		List choices = helper.getSyntaxHelp("self."); //$NON-NLS-1$
		
		assertChoice(choices, ChoiceType.STRUCTURAL_FEATURE, "eAttributes"); //$NON-NLS-1$
		
		choices = helper.getSyntaxHelp("self.name."); //$NON-NLS-1$
		
		assertChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "toLower"); //$NON-NLS-1$
	}
	
	/**
	 * Tests completion of enumeration literals in classifier invariant
	 * constraints.
	 */
	public void test_completeInvariant_enumLiteral() {
		IOclHelper helper = HelperUtil.createOclHelper();

		helper.setContext(fruit);
		
		try {
			List choices = helper.getSyntaxHelp("color <> Color::"); //$NON-NLS-1$
			assertNotNull(choices);
			
			assertChoice(choices, ChoiceType.STRUCTURAL_FEATURE, "red"); //$NON-NLS-1$
			assertChoice(choices, ChoiceType.STRUCTURAL_FEATURE, "brown"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests completion of attributes in classifier invariant
	 * constraints.
	 */
	public void test_completeInvariant_attribute() {
		IOclHelper helper = HelperUtil.createOclHelper();

		helper.setContext(fruit);
		
		try {
			List choices = helper.getSyntaxHelp("self."); //$NON-NLS-1$
			assertNotNull(choices);
			
			assertChoice(choices, ChoiceType.ENUMERATION_LITERAL, "color"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests completion of references (association ends) in classifier invariant
	 * constraints.
	 */
	public void test_completeInvariant_reference() {
		IOclHelper helper = HelperUtil.createOclHelper();

		helper.setContext(apple);
		
		try {
			List choices = helper.getSyntaxHelp("self."); //$NON-NLS-1$
			assertNotNull(choices);
			
			assertChoice(choices, ChoiceType.STRUCTURAL_FEATURE, "stem"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests completion of operations in classifier invariant
	 * constraints.
	 */
	public void test_completeInvariant_operation() {
		IOclHelper helper = HelperUtil.createOclHelper();

		helper.setContext(fruit);
		
		try {
			List choices = helper.getSyntaxHelp("self."); //$NON-NLS-1$
			assertNotNull(choices);
			
			assertChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "preferredColor"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests completion of enumeration literals in operation precondition
	 * constraints.
	 */
	public void test_completePrecondition_enumLiteral() {
		IOclHelper helper = HelperUtil.createOclHelper();

		helper.setContextOperation(fruit, fruit_ripen);
		
		try {
			List choices = helper.getSyntaxHelp("color <> Color::"); //$NON-NLS-1$
			assertNotNull(choices);
			
			assertChoice(choices, ChoiceType.STRUCTURAL_FEATURE, "red"); //$NON-NLS-1$
			assertChoice(choices, ChoiceType.STRUCTURAL_FEATURE, "brown"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests completion of attributes in operation body conditions.
	 */
	public void test_completeBodyCondition_attribute() {
		IOclHelper helper = HelperUtil.createOclHelper();

		helper.setContextOperation(fruit, fruit_preferredColor);
		
		try {
			List choices = helper.getSyntaxHelp("self."); //$NON-NLS-1$
			assertNotNull(choices);
			
			assertChoice(choices, ChoiceType.ENUMERATION_LITERAL, "color"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests completion of references (association ends) in operation precondition
	 * constraints.
	 */
	public void test_completePrecondition_reference() {
		IOclHelper helper = HelperUtil.createOclHelper();

		helper.setContextOperation(apple, apple_labelOper);
		
		try {
			List choices = helper.getSyntaxHelp("self."); //$NON-NLS-1$
			assertNotNull(choices);
			
			assertChoice(choices, ChoiceType.STRUCTURAL_FEATURE, "stem"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests completion of operations in operation postcondition
	 * constraints.
	 */
	public void test_completePostcondition_operation() {
		IOclHelper helper = HelperUtil.createOclHelper();

		helper.setContextOperation(fruit, fruit_ripen);
		
		try {
			List choices = helper.getSyntaxHelp("self."); //$NON-NLS-1$
			assertNotNull(choices);
			
			assertChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "preferredColor"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests completion of parameters in operation precondition
	 * constraints.
	 */
	public void test_completePrecondition_parameter() {
		IOclHelper helper = HelperUtil.createOclHelper();

		helper.setContextOperation(fruit, apple_labelOper);
		
		try {
			List choices = helper.getSyntaxHelp("text."); //$NON-NLS-1$
			assertNotNull(choices);
			
			assertChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "toLower"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
	
	/**
	 * Tests completion of the result variable in operation postcondition
	 * constraints.
	 */
	public void test_completePostcondition_result() {
		IOclHelper helper = HelperUtil.createOclHelper();

		helper.setContextOperation(fruit, fruit_preferredColor);
		
		try {
			List choices = helper.getSyntaxHelp("result."); //$NON-NLS-1$
			assertNotNull(choices);
			
			assertChoice(choices, ChoiceType.BEHAVIORAL_FEATURE, "oclIsUndefined"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Parse failed: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
}
