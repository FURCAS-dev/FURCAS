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
 *   Zeligsoft - Bugs 241148, 243098, 247079, 179990
 *   
 * </copyright>
 *
 * $Id: ProfilesTest.java,v 1.10 2009/11/28 18:12:30 ewillink Exp $
 */

package org.eclipse.ocl.uml.tests;

import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

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
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

/**
 * Tests for state expressions.
 * 
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public class ProfilesTest
    extends AbstractTestSuite {

    private Profile testProfile;
    Stereotype testStereotype;
    Stereotype testSubStereotype;
    Property stereoEnum;
    Property stereoX;  
    Property stereoTag;
    Enumeration testEnumeration;
    EnumerationLiteral maybe;
    EnumerationLiteral no;
    EnumerationLiteral yes;   
    Class tag;   
    EClass eTag;   
    Property tagName;   
    EAttribute eTagName;

    /**
     * Tests the parsing of the constraints on stereotypes.
     */
    public void test_parseStereotypeConstraint() {
        helper.setContext(testStereotype);

        try {
            Constraint constraint = helper
                .createInvariant("base_Classifier.name = 'Fruit' implies" +
                    " (x > 0 or yesno = YesNo::yes)");

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
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
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
                .createInvariant("base_Classifier.name = 'Fruit' implies" +
                    " (x > 0 or yesno = YesNo::yes)");

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
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }

    /**
     * Tests the non-navigable association-end support for navigating to applied
     * stereotypes.
     */
    public void test_navigateToStereotypeApplication() {
        // this is metamodel-level OCL that we're dealing with where
        // stereotypes are concerned
        helper.setContext(getMetaclass("Classifier"));

        try {
            Constraint constraint = helper
                .createInvariant("let st : TestProfile::Stereo1 = self.extension_Stereo1 in " +
                    "st <> null implies st.x > 0 or st.yesno = TestProfile::YesNo::yes");

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
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        }
    }
    
    /**
	 * Tests the <tt>allInstances()</tt> query on stereotypes.
	 */
	public void test_allInstances_stereotype_241148() {
		helper.setContext(testStereotype);

		try {
			OCLExpression<Classifier> expr = helper
				.createQuery("Stereo1.allInstances().base_Classifier.name");

			// set up a couple of stereotyped classes to test the query on
			fruit.applyStereotype(testStereotype);

			tree.applyStereotype(testStereotype);

			Bag<String> expectedValue = CollectionUtil.createNewBag();
			expectedValue.add("Fruit");
			expectedValue.add("Tree");

			assertEquals(expectedValue, evaluate(expr, fruit));
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
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
				.createQuery("Tag.allInstances()");

			// set up a couple of stereotyped classes to test the query on
			fruit.applyStereotype(testStereotype);
			EObject tag1 = EcoreUtil.create(eTag);
			List<EObject> tags = (List<EObject>) fruit.getValue(testStereotype,
				stereoTag.getName());
			tags.add(tag1);
			tag1.eSet(eTagName, "myTag");

			tree.applyStereotype(testStereotype);
			EObject tag2 = EcoreUtil.create(eTag);
			tags = (List<EObject>) tree.getValue(testStereotype, stereoTag
				.getName());
			tags.add(tag2);
			tag2.eSet(eTagName, "anotherTag");

			Set<EObject> expectedInstances = new java.util.HashSet<EObject>();
			expectedInstances.add(tag1);
			expectedInstances.add(tag2);
			assertEquals(expectedInstances, evaluate(expr, fruit));

			expr = helper.createQuery("Tag.allInstances().name");

			Bag<String> expectedValue = CollectionUtil.createNewBag();
			expectedValue.add("myTag");
			expectedValue.add("anotherTag");

			assertEquals(expectedValue, evaluate(expr, fruit));
		} catch (Exception e) {
			fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
		}
	}

    /**
     * Tests the reverse-navigation of metaclass extensions where the profile is
     * applied to a nesting package.
     */
    public void test_navigateToStereotypeApplication_247079() {
        // this is metamodel-level OCL that we're dealing with where
        // stereotypes are concerned
        helper.setContext(getMetaclass("Classifier"));

        // move the Fruit class into a nested package
        final Package nested = fruitPackage.createNestedPackage("nested");
        nested.getPackagedElements().add(fruit);
        
    	try {
        	Callable<Void> call = new Callable<Void>() {
			
				public Void call()
						throws Exception {
		            Constraint constraint = helper
		                .createInvariant("let st : TestProfile::Stereo1 = self.extension_Stereo1 in " +
		                    "st <> null implies st.x > 0 or st.yesno = TestProfile::YesNo::yes");
	
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
					return null;
				}};
        	
        	exec.submit(call).get(60l, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            fail("Timed out waiting for evaluation");
         } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage());
        } finally {
        	// re-initialize the Fruit model for the next test
        	fruitPackage.getPackagedElements().add(fruit);
        	nested.destroy();
        }
    }

    //
    // Test Framework
    //

    @Override
    protected void setUp() {
        super.setUp();

        if (testProfile == null) {
            initTestProfile();
        }

        fruitPackage.applyProfile(testProfile);
        expectModified = true;
    }

    public void tearDown_testProfile() {
        fruitPackage.unapplyProfile(testProfile);
        testProfile = null;
    }

    private void initTestProfile() {
        Resource res = fruitPackage.eResource();
        URI uri = res.getURI().trimSegments(1).appendSegment(
            "OCLTest.profile.uml");

        res = resourceSet.getResource(uri, true);

        testProfile = (Profile) res.getContents().get(0);

        testStereotype = testProfile.getOwnedStereotype("Stereo1");
        assertNotNull(testStereotype);
        stereoEnum = testStereotype.getOwnedAttribute("yesno", null);
        assertNotNull(stereoEnum);
        stereoX = testStereotype.getOwnedAttribute("x", null);
        assertNotNull(stereoX);
        stereoTag = testStereotype.getOwnedAttribute("tag", null);
        assertNotNull(stereoTag);

        testSubStereotype = testProfile.getOwnedStereotype("SubStereo1");
        assertNotNull(testSubStereotype);

        testEnumeration = (Enumeration) testProfile.getOwnedType("YesNo");
        assertNotNull(testEnumeration);
        maybe = testEnumeration.getOwnedLiteral("maybe");
        assertNotNull(maybe);
        no = testEnumeration.getOwnedLiteral("no");
        assertNotNull(no);
        yes = testEnumeration.getOwnedLiteral("yes");
        assertNotNull(yes);
        
        tag = (Class) testProfile.getOwnedType("Tag");
        assertNotNull(tag);
        eTag = (EClass) testProfile.getDefinition(tag);
        assertNotNull(eTag);
        tagName = tag.getOwnedAttribute("name", null);
        assertNotNull(tagName);
        eTagName = (EAttribute) eTag.getEStructuralFeature(tagName.getName());
        assertNotNull(eTagName);
    }
}
