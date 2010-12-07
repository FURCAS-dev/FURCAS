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
 *
 * </copyright>
 *
 * $Id: EObjectStructuralFeatureValueConditionTest.java,v 1.2 2007/11/08 23:00:27 cdamus Exp $
 */

package org.eclipse.emf.query.tests;

import java.util.Collection;
import java.util.Collections;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.examples.extlibrary.EXTLibraryFactory;
import org.eclipse.emf.examples.extlibrary.EXTLibraryPackage;
import org.eclipse.emf.examples.extlibrary.Library;
import org.eclipse.emf.query.conditions.ObjectInstanceCondition;
import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.conditions.eobjects.EObjectInstanceCondition;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectAttributeValueCondition;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectReferenceValueCondition;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectStructuralFeatureValueCondition;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;

/**
 * Tests for the {@link EObjectStructuralFeatureValueCondition} class.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class EObjectStructuralFeatureValueConditionTest
    extends TestCase {

    public static void main(String[] args) {
        TestRunner.run(suite());
    }

    public static Test suite() {
        return new TestSuite(EObjectStructuralFeatureValueConditionTest.class,
            "Feature value condition tests"); //$NON-NLS-1$
    }

    public EObjectStructuralFeatureValueConditionTest(String name) {
        super(name);
    }

    public void test_searchForNullValue_184011() {
        Collection<EObject> objects = new java.util.HashSet<EObject>();

        Library a = EXTLibraryFactory.eINSTANCE.createLibrary();
        objects.add(a);
        Library b = EXTLibraryFactory.eINSTANCE.createLibrary();
        objects.add(b);
        Library c = EXTLibraryFactory.eINSTANCE.createLibrary();
        objects.add(c);

        a.setName("A"); //$NON-NLS-1$
        b.setName(null); // this one has no name
        c.setName("C"); //$NON-NLS-1$

        c.getBranches().add(a);
        c.getBranches().add(b);

        EObjectCondition cond = new EObjectAttributeValueCondition(
            EXTLibraryPackage.Literals.LIBRARY__NAME,
            ObjectInstanceCondition.IS_NULL);

        Collection<EObject> results = query(objects, cond);
        assertEquals(Collections.singleton(b), results);

        cond = new EObjectReferenceValueCondition(
            EXTLibraryPackage.Literals.LIBRARY__PARENT_BRANCH,
            EObjectInstanceCondition.IS_NULL);

        results = query(objects, cond);
        assertEquals(Collections.singleton(c), results);
    }

    //
    // Framework methods
    //

    Collection<EObject> query(Collection<? extends EObject> source,
    		EObjectCondition cond) {
        return new SELECT(new FROM(source), new WHERE(cond)).execute();
    }
}
