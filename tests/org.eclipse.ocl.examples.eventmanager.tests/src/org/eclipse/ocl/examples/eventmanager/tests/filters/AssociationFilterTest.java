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
package org.eclipse.ocl.examples.eventmanager.tests.filters;

import junit.textui.TestRunner;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.ocl.examples.eventmanager.EventManagerFactory;
import org.eclipse.ocl.examples.eventmanager.filters.AssociationFilter;
import org.eclipse.ocl.examples.eventmanager.filters.StructuralFeatureFilter;


/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Association Filter</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 * <li>{@link org.eclipse.ocl.examples.eventmanager.filters.AssociationFilter#setReference(org.eclipse.emf.ecore.EReference)
 * <em>Set Reference</em>}</li>
 * </ul>
 * </p>
 */
public class AssociationFilterTest extends StructuralFeatureFilterTest {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     */
    public static void main(String[] args) {
        TestRunner.run(AssociationFilterTest.class);
    }

    /**
     * Constructs a new Association Filter test case with the given name. <!-- begin-user-doc --> <!-- end-user-doc -->
     */
    public AssociationFilterTest() {
        super();
    }

    private EReference reference1;
	private EReference reference2;

    /**
     * Returns the fixture for this Association Filter test case. <!-- begin-user-doc --> <!-- end-user-doc -->
     */
    @Override
    protected AssociationFilter getFixture() {
        return (AssociationFilter) fixture;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see junit.framework.TestCase#setUp()
     */
    @Override
    public void setUp() {
        super.setUp();
        this.reference1 = EcoreFactory.eINSTANCE.createEReference();
        reference1.setName("myReference");
        this.reference2 = EcoreFactory.eINSTANCE.createEReference();
        setFixture(EventManagerFactory.eINSTANCE.createAssociationFilter(reference1));

    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see junit.framework.TestCase#tearDown()
     */
    @Override
    public void tearDown() {
        super.tearDown();
        setFixture(null);
        this.reference1 = null;
        this.reference2 = null;
    }

    /**
     * Tests the '
     * {@link org.eclipse.ocl.examples.eventmanager.filters.AssociationFilter#setReference(org.eclipse.emf.ecore.EReference)
     * <em>Set Reference</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.ocl.examples.eventmanager.filters.AssociationFilter#setReference(org.eclipse.emf.ecore.EReference)
     */
    public void testSetReference__EReference() {
        assertSame(getFixture().getFeature(), reference1);
    }

	@Override
	StructuralFeatureFilter getFilterFor(Object f) {
		return  EventManagerFactory.eINSTANCE.createAssociationFilter((EReference) f);
	}

	@Override
	EStructuralFeature getFilterCriterion1() {
		return reference1;
	}

	@Override
	EStructuralFeature getFilterCriterion2() {
		return reference2;
	}

} // AssociationFilterTest
