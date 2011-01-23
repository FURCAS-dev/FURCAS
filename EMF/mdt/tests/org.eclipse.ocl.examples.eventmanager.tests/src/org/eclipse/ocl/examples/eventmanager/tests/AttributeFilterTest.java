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
package org.eclipse.ocl.examples.eventmanager.tests;

import junit.textui.TestRunner;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.ocl.examples.eventmanager.EventManagerFactory;
import org.eclipse.ocl.examples.eventmanager.filters.AttributeFilter;


/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Attribute Filter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.eventmanager.filters.AttributeFilter#setAttribute(org.eclipse.emf.ecore.EAttribute) <em>Set Attribute</em>}</li>
 * </ul>
 * </p>
 */
public class AttributeFilterTest extends StructuralFeatureFilterTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public static void main(String[] args) {
		TestRunner.run(AttributeFilterTest.class);
	}

	/**
	 * Constructs a new Attribute Filter test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public AttributeFilterTest() {
		super();
	}

	private EAttribute attribute;


	/**
	 * Returns the fixture for this Attribute Filter test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	protected AttributeFilter getFixture() {
		return (AttributeFilter)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	public void setUp()  {
		super.setUp();
		setFixture(EventManagerFactory.eINSTANCE.createAttributeFilter(null));
		this.attribute = EcoreFactory.eINSTANCE.createEAttribute();
		attribute.setName("myAttribute");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	public void tearDown()   {
		super.tearDown();
		setFixture(null);
		this.attribute = null;
	}

	/**
	 * Tests the '{@link org.eclipse.ocl.examples.eventmanager.filters.AttributeFilter#setAttribute(org.eclipse.emf.ecore.EAttribute) <em>Set Attribute</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.eventmanager.filters.AttributeFilter#setAttribute(org.eclipse.emf.ecore.EAttribute)
	 */
	public void testSetAttribute__EAttribute() {
		AttributeFilter filter = EventManagerFactory.eINSTANCE.createAttributeFilter(attribute);
		assertSame(filter.getFeature(), attribute);
	}

} //AttributeFilterTest
