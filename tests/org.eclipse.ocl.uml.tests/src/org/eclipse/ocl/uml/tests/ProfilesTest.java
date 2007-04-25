/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: ProfilesTest.java,v 1.3 2007/04/25 21:12:21 cdamus Exp $
 */

package org.eclipse.ocl.uml.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

/**
 * Tests for state expressions.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class ProfilesTest
    extends AbstractTestSuite {

    private static Profile testProfile;

    private static Stereotype testStereotype;

    private static Property stereoEnum;

    private static Property stereoX;

    private static Enumeration testEnumeration;

    private static EnumerationLiteral maybe;

    private static EnumerationLiteral no;

    private static EnumerationLiteral yes;

    public ProfilesTest(String name) {
        super(name);
    }

    public static Test suite() {
        return new TestSuite(ProfilesTest.class, "Profile Constraint Tests"); //$NON-NLS-1$
    }

    /**
     * Tests the parsing of the constraints on stereotypes.
     */
    public void test_parseStereotypeConstraint() {
        helper.setContext(testStereotype);

        try {
            Constraint constraint = helper
                .createInvariant("base_Classifier.name = 'Fruit' implies" + //$NON-NLS-1$
                    " (x > 0 or yesno = YesNo::yes)"); //$NON-NLS-1$

            // set up a couple of stereotyped classes to test the constraint on
            fruit.applyStereotype(testStereotype);
            fruit.setValue(testStereotype, stereoX.getName(), 0);
            fruit.setValue(testStereotype, stereoEnum.getName(), no);

            tree.applyStereotype(testStereotype);
            tree.setValue(testStereotype, stereoX.getName(), 0);
            tree.setValue(testStereotype, stereoEnum.getName(), no);

            // the 'Fruit' class violates the 'x' and 'yesno' conditions
            assertFalse(ocl.check(fruit, constraint));

            // the 'Tree' class's name is not 'Fruit'
            assertTrue(ocl.check(tree, constraint));

            // fix the Fruit class by changing 'x'
            fruit.setValue(testStereotype, stereoX.getName(), 1);
            assertTrue(ocl.check(fruit, constraint));

            // or, fix it by changing 'yesno'
            fruit.setValue(testStereotype, stereoX.getName(), 0);
            fruit.setValue(testStereotype, stereoEnum.getName(), yes);
            assertTrue(ocl.check(fruit, constraint));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }

    /**
     * Tests the non-navigable association-end support for navigating to applied
     * stereotypes.
     */
    public void test_navigateToStereotypeApplication() {
        // this is metamodel-level OCL that we're dealing with where
        // stereotypes are concerned
        helper.setContext(getMetaclass("Classifier")); //$NON-NLS-1$

        try {
            Constraint constraint = helper
                .createInvariant("let st : TestProfile::Stereo1 = self.extension_Stereo1 in " + //$NON-NLS-1$
                    "st <> null implies st.x > 0 or st.yesno = TestProfile::YesNo::yes"); //$NON-NLS-1$

            // constraint passes because the implication is trivially true
            assertTrue(ocl.check(fruit, constraint));

            // set up a couple of stereotyped classes to test the constraint on
            fruit.applyStereotype(testStereotype);
            fruit.setValue(testStereotype, stereoX.getName(), 0);
            fruit.setValue(testStereotype, stereoEnum.getName(), no);

            // the 'Fruit' class violates the 'x' and 'yesno' conditions
            assertFalse(ocl.check(fruit, constraint));

            // fix the Fruit class by changing 'x'
            fruit.setValue(testStereotype, stereoX.getName(), 1);
            assertTrue(ocl.check(fruit, constraint));

            // or, fix it by changing 'yesno'
            fruit.setValue(testStereotype, stereoX.getName(), 0);
            fruit.setValue(testStereotype, stereoEnum.getName(), yes);
            assertTrue(ocl.check(fruit, constraint));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }

    //
    // Test Framework
    //

    @Override
    protected void setUp()
        throws Exception {
        super.setUp();

        if (testProfile == null) {
            initTestProfile();
        }

        fruitPackage.applyProfile(testProfile);
    }

    @Override
    protected void tearDown()
        throws Exception {
        fruitPackage.unapplyProfile(testProfile);

        super.tearDown();
    }

    private static void initTestProfile() {
        Resource res = fruitPackage.eResource();
        URI uri = res.getURI().trimSegments(1).appendSegment(
            "OCLTest.profile.uml"); //$NON-NLS-1$

        res = resourceSet.getResource(uri, true);

        testProfile = (Profile) res.getContents().get(0);

        testStereotype = testProfile.getOwnedStereotype("Stereo1"); //$NON-NLS-1$
        assertNotNull(testStereotype);
        stereoEnum = testStereotype.getOwnedAttribute("yesno", null); //$NON-NLS-1$
        assertNotNull(stereoEnum);
        stereoX = testStereotype.getOwnedAttribute("x", null); //$NON-NLS-1$
        assertNotNull(stereoX);

        testEnumeration = (Enumeration) testProfile.getOwnedType("YesNo"); //$NON-NLS-1$
        assertNotNull(testEnumeration);
        maybe = testEnumeration.getOwnedLiteral("maybe"); //$NON-NLS-1$
        assertNotNull(maybe);
        no = testEnumeration.getOwnedLiteral("no"); //$NON-NLS-1$
        assertNotNull(no);
        yes = testEnumeration.getOwnedLiteral("yes"); //$NON-NLS-1$
        assertNotNull(yes);
    }
}
