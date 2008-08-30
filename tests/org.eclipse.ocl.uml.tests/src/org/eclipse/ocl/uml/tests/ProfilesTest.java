/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2008 IBM Corporation, Zeligsoft Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bugs 241148, 243098
 *   
 * </copyright>
 *
 * $Id: ProfilesTest.java,v 1.6 2008/08/30 17:04:05 cdamus Exp $
 */

package org.eclipse.ocl.uml.tests;

import java.util.List;
import java.util.Set;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.util.Bag;
import org.eclipse.ocl.util.CollectionUtil;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
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

    private static Stereotype testSubStereotype;

    private static Property stereoEnum;

    private static Property stereoX;
    
    private static Property stereoTag;

    private static Enumeration testEnumeration;

    private static EnumerationLiteral maybe;

    private static EnumerationLiteral no;

    private static EnumerationLiteral yes;
    
    private static Class tag;
    
    private static EClass eTag;
    
    private static Property tagName;
    
    private static EAttribute eTagName;

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
     * Tests the parsing of the constraints on stereotypes, in the context of
     * elements that have a sub-stereotype applied (very different from a UML2
     * API perspective).
     */
    public void test_parseStereotypeConstraint_substereotype_243098() {
    	// do define the constraint on the general stereotype, so that it will
    	// be inherited
        helper.setContext(testStereotype);

        try {
            Constraint constraint = helper
                .createInvariant("base_Classifier.name = 'Fruit' implies" + //$NON-NLS-1$
                    " (x > 0 or yesno = YesNo::yes)"); //$NON-NLS-1$

            // set up a couple of stereotyped classes to test the constraint on
            fruit.applyStereotype(testSubStereotype);
            fruit.setValue(testSubStereotype, stereoX.getName(), 0);
            fruit.setValue(testSubStereotype, stereoEnum.getName(), no);

            tree.applyStereotype(testSubStereotype);
            tree.setValue(testSubStereotype, stereoX.getName(), 0);
            tree.setValue(testSubStereotype, stereoEnum.getName(), no);

            // the 'Fruit' class violates the 'x' and 'yesno' conditions
            assertFalse(ocl.check(fruit, constraint));

            // the 'Tree' class's name is not 'Fruit'
            assertTrue(ocl.check(tree, constraint));

            // fix the Fruit class by changing 'x'
            fruit.setValue(testSubStereotype, stereoX.getName(), 1);
            assertTrue(ocl.check(fruit, constraint));

            // or, fix it by changing 'yesno'
            fruit.setValue(testSubStereotype, stereoX.getName(), 0);
            fruit.setValue(testSubStereotype, stereoEnum.getName(), yes);
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
    
    /**
	 * Tests the <tt>allInstances()</tt> query on stereotypes.
	 */
	public void test_allInstances_stereotype_241148() {
		helper.setContext(testStereotype);

		try {
			OCLExpression<Classifier> expr = helper
				.createQuery("Stereo1.allInstances().base_Classifier.name"); //$NON-NLS-1$

			// set up a couple of stereotyped classes to test the query on
			fruit.applyStereotype(testStereotype);

			tree.applyStereotype(testStereotype);

			Bag<String> expectedValue = CollectionUtil.createNewBag();
			expectedValue.add("Fruit"); //$NON-NLS-1$
			expectedValue.add("Tree"); //$NON-NLS-1$

			assertEquals(expectedValue, evaluate(expr, fruit));
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}

	/**
	 * Tests the <tt>allInstances()</tt> query on classes defined in profiles.
	 */
	@SuppressWarnings("unchecked")
	public void test_allInstances_profileClass_241148() {
		helper.setContext(testStereotype);

		try {
			OCLExpression<Classifier> expr = helper
				.createQuery("Tag.allInstances()"); //$NON-NLS-1$

			// set up a couple of stereotyped classes to test the query on
			fruit.applyStereotype(testStereotype);
			EObject tag1 = EcoreUtil.create(eTag);
			List<EObject> tags = (List<EObject>) fruit.getValue(testStereotype,
				stereoTag.getName());
			tags.add(tag1);
			tag1.eSet(eTagName, "myTag"); //$NON-NLS-1$

			tree.applyStereotype(testStereotype);
			EObject tag2 = EcoreUtil.create(eTag);
			tags = (List<EObject>) tree.getValue(testStereotype, stereoTag
				.getName());
			tags.add(tag2);
			tag2.eSet(eTagName, "anotherTag"); //$NON-NLS-1$

			Set<EObject> expectedInstances = new java.util.HashSet<EObject>();
			expectedInstances.add(tag1);
			expectedInstances.add(tag2);
			assertEquals(expectedInstances, evaluate(expr, fruit));

			expr = helper.createQuery("Tag.allInstances().name"); //$NON-NLS-1$

			Bag<String> expectedValue = CollectionUtil.createNewBag();
			expectedValue.add("myTag"); //$NON-NLS-1$
			expectedValue.add("anotherTag"); //$NON-NLS-1$

			assertEquals(expectedValue, evaluate(expr, fruit));
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

        testProfile = null;
        testStereotype = null;
        stereoEnum = null;
        stereoX = null;
        stereoTag = null;
        testEnumeration = null;
        maybe = null;
        no = null;
        yes = null;
        tag = null;
        tagName = null;
        
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
        stereoTag = testStereotype.getOwnedAttribute("tag", null); //$NON-NLS-1$
        assertNotNull(stereoTag);

        testSubStereotype = testProfile.getOwnedStereotype("SubStereo1"); //$NON-NLS-1$
        assertNotNull(testSubStereotype);

        testEnumeration = (Enumeration) testProfile.getOwnedType("YesNo"); //$NON-NLS-1$
        assertNotNull(testEnumeration);
        maybe = testEnumeration.getOwnedLiteral("maybe"); //$NON-NLS-1$
        assertNotNull(maybe);
        no = testEnumeration.getOwnedLiteral("no"); //$NON-NLS-1$
        assertNotNull(no);
        yes = testEnumeration.getOwnedLiteral("yes"); //$NON-NLS-1$
        assertNotNull(yes);
        
        tag = (Class) testProfile.getOwnedType("Tag"); //$NON-NLS-1$
        assertNotNull(tag);
        eTag = (EClass) testProfile.getDefinition(tag);
        assertNotNull(eTag);
        tagName = tag.getOwnedAttribute("name", null);  //$NON-NLS-1$
        assertNotNull(tagName);
        eTagName = (EAttribute) eTag.getEStructuralFeature(tagName.getName());
        assertNotNull(eTagName);
    }
}
