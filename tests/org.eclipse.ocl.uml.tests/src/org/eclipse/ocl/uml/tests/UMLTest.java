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
 * $Id: UMLTest.java,v 1.3 2007/04/23 21:13:54 cdamus Exp $
 */

package org.eclipse.ocl.uml.tests;

import java.util.Set;

import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Tests involving constructs peculiar to the UML.
 * 
 * @author Christian W. Damus (cwdamus)
 */
public class UMLTest
    extends AbstractTestSuite {

    private Resource instanceResource;

    private Package instancePackage;

    public UMLTest(String name) {
        super(name);
    }

    public static Test suite() {
        return new TestSuite(UMLTest.class, "UML-Specific Tests"); //$NON-NLS-1$
    }

    /**
     * Tests that name look-up accounts for namespace imports.
     */
    public void test_importedElements() {
        Package imported = UMLFactory.eINSTANCE.createPackage();
        imported
            .createOwnedClass("Foo", false).createOwnedAttribute("boo", getUMLBoolean()); //$NON-NLS-1$//$NON-NLS-2$

        fruitPackage.createPackageImport(imported);

        parseConstraint("package ocltest context Fruit " + //$NON-NLS-1$
            "inv: self.oclIsKindOf(Foo) implies self.oclAsType(Foo).boo " + //$NON-NLS-1$
            "endpackage"); //$NON-NLS-1$
    }

    /**
     * Tests the navigation of properties that are redefined in the actual type
     * of an instance specification (redefinition already handled internally by
     * generated code).
     */
    public void test_redefinedProperties() {
        InstanceSpecification apple1 = instantiate(instancePackage, apple);
        InstanceSpecification apple2 = instantiate(instancePackage, apple);
        InstanceSpecification apple3 = instantiate(instancePackage, apple);

        Set<InstanceSpecification> apples = new java.util.HashSet<InstanceSpecification>();
        apples.add(apple1);
        apples.add(apple2);
        apples.add(apple3);

        InstanceSpecification anApple = instantiate(instancePackage, apple);
        addValue(anApple, apple_appleFriends, apple1);
        addValue(anApple, apple_appleFriends, apple2);
        addValue(anApple, apple_appleFriends, apple3);

        // access the redefined property
        OCLExpression<Classifier> expr = parse("package ocltest context Fruit " + //$NON-NLS-1$
            "inv: self.friends" + //$NON-NLS-1$
            " endpackage"); //$NON-NLS-1$

        // check that we got the value of the slot for the redefining property
        assertEquals(apples, evaluate(expr, anApple));
    }

    /**
     * Tests parsing static operation calls using the dot.
     */
    public void test_staticOperations_dot_bug164887() {
        try {
            fruit_ripen.setIsStatic(true);

            // access via an instance
            parseConstraint("package ocltest context Apple " + //$NON-NLS-1$
                "inv: self.ripen(Color::black)" + //$NON-NLS-1$
                " endpackage"); //$NON-NLS-1$

            // access via an unqualified type name
            parseConstraint("package ocltest context Apple " + //$NON-NLS-1$
                "inv: Fruit.ripen(Color::black)" + //$NON-NLS-1$
                " endpackage"); //$NON-NLS-1$

            // access via a qualified type name
            parseConstraint("package uml context Classifier " + //$NON-NLS-1$
                "inv: ocltest::Fruit.ripen(ocltest::Color::black)" + //$NON-NLS-1$
                " endpackage"); //$NON-NLS-1$
        } finally {
            fruit_ripen.setIsStatic(false);
        }
    }

    /**
     * Tests parsing static operation calls using the double colon.
     */
    public void test_staticOperations_colonColon_bug164887() {
        try {
            fruit_ripen.setIsStatic(true);

            // access via an unqualified type name
            parseConstraint("package ocltest context Apple " + //$NON-NLS-1$
                "inv: Fruit::ripen(Color::black)" + //$NON-NLS-1$
                " endpackage"); //$NON-NLS-1$

            // access via a qualified type name
            parseConstraint("package uml context Classifier " + //$NON-NLS-1$
                "inv: ocltest::Fruit::ripen(ocltest::Color::black)" + //$NON-NLS-1$
                " endpackage"); //$NON-NLS-1$
        } finally {
            fruit_ripen.setIsStatic(false);
        }
    }

    /**
     * Tests parsing static attribute calls using the dot.
     */
    public void test_staticAttributes_dot_bug164887() {
        try {
            fruit_color.setIsStatic(true);

            // access via an instance
            parseConstraint("package ocltest context Apple " + //$NON-NLS-1$
                "inv: self.color = Color::black" + //$NON-NLS-1$
                " endpackage"); //$NON-NLS-1$

            // access via an unqualified type name
            parseConstraint("package ocltest context Apple " + //$NON-NLS-1$
                "inv: Fruit.color = Color::black" + //$NON-NLS-1$
                " endpackage"); //$NON-NLS-1$

            // access via a qualified type name
            parseConstraint("package uml context Classifier " + //$NON-NLS-1$
                "inv: ocltest::Fruit.color = ocltest::Color::black" + //$NON-NLS-1$
                " endpackage"); //$NON-NLS-1$
        } finally {
            fruit_color.setIsStatic(false);
        }
    }

    /**
     * Tests parsing static attribute calls using the double colon.
     */
    public void test_staticAttributes_colonColon_bug164887() {
        try {
            fruit_color.setIsStatic(true);

            // access via an unqualified type name
            parseConstraint("package ocltest context Apple " + //$NON-NLS-1$
                "inv: Fruit::color = Color::black" + //$NON-NLS-1$
                " endpackage"); //$NON-NLS-1$

            // access via a qualified type name
            parseConstraint("package uml context Classifier " + //$NON-NLS-1$
                "inv: ocltest::Fruit::color = ocltest::Color::black" + //$NON-NLS-1$
                " endpackage"); //$NON-NLS-1$
        } finally {
            fruit_color.setIsStatic(false);
        }
    }

    /**
     * Tests validation of static operation calls using the dot (in particular,
     * that the operation is static).
     */
    public void test_staticOperations_dot_val_bug164887() {
        try {
            // access via an unqualified type name
            parseConstraint("package ocltest context Apple " + //$NON-NLS-1$
                "inv: Fruit.ripen(Color::black)" + //$NON-NLS-1$
                " endpackage"); //$NON-NLS-1$

            fail("Should have failed to parse"); //$NON-NLS-1$
        } catch (AssertionFailedError e) {
            // success
            System.out
                .println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }

        try {
            // access via a qualified type name
            parseConstraint("package uml context Classifier " + //$NON-NLS-1$
                "inv: ocltest::Fruit.ripen(ocltest::Color::black)" + //$NON-NLS-1$
                " endpackage"); //$NON-NLS-1$

            fail("Should have failed to parse"); //$NON-NLS-1$
        } catch (AssertionFailedError e) {
            // success
            System.out
                .println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }

    /**
     * Tests validation of static operation calls using the double colon (in
     * particular, that the operation is static).
     */
    public void test_staticOperations_colonColon_val_bug164887() {
        try {
            // access via an unqualified type name
            parseConstraint("package ocltest context Apple " + //$NON-NLS-1$
                "inv: Fruit::ripen(Color::black)" + //$NON-NLS-1$
                " endpackage"); //$NON-NLS-1$

            fail("Should have failed to parse"); //$NON-NLS-1$
        } catch (AssertionFailedError e) {
            // success
            System.out
                .println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }

        try {
            // access via a qualified type name
            parseConstraint("package uml context Classifier " + //$NON-NLS-1$
                "inv: ocltest::Fruit::ripen(ocltest::Color::black)" + //$NON-NLS-1$
                " endpackage"); //$NON-NLS-1$

            fail("Should have failed to parse"); //$NON-NLS-1$
        } catch (AssertionFailedError e) {
            // success
            System.out
                .println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }

    /**
     * Tests validation of static attribute calls using the dot (in particular,
     * that the operation is static).
     */
    public void test_staticAttributes_dot_val_bug164887() {
        try {
            // access via an unqualified type name
            parseConstraint("package ocltest context Apple " + //$NON-NLS-1$
                "inv: Fruit.color = Color::black" + //$NON-NLS-1$
                " endpackage"); //$NON-NLS-1$

            fail("Should have failed to parse"); //$NON-NLS-1$
        } catch (AssertionFailedError e) {
            // success
            System.out
                .println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }

        try {
            // access via a qualified type name
            parseConstraint("package uml context Classifier " + //$NON-NLS-1$
                "inv: ocltest::Fruit.color = ocltest::Color::black" + //$NON-NLS-1$
                " endpackage"); //$NON-NLS-1$

            fail("Should have failed to parse"); //$NON-NLS-1$
        } catch (AssertionFailedError e) {
            // success
            System.out
                .println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }

    /**
     * Tests validation of static attribute calls using the double colon (in
     * particular, that the operation is static).
     */
    public void test_staticAttributes_colonColon_val_bug164887() {
        try {
            // access via an unqualified type name
            parseConstraint("package ocltest context Apple " + //$NON-NLS-1$
                "inv: Fruit::color = Color::black" + //$NON-NLS-1$
                " endpackage"); //$NON-NLS-1$

            fail("Should have failed to parse"); //$NON-NLS-1$
        } catch (AssertionFailedError e) {
            // success
            System.out
                .println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }

        try {
            // access via a qualified type name
            parseConstraint("package uml context Classifier " + //$NON-NLS-1$
                "inv: ocltest::Fruit::color = ocltest::Color::black" + //$NON-NLS-1$
                " endpackage"); //$NON-NLS-1$

            fail("Should have failed to parse"); //$NON-NLS-1$
        } catch (AssertionFailedError e) {
            // success
            System.out
                .println("Got expected error: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }

    public void test_nonNavigableAttribute() {
        OCLExpression<Classifier> expr = parseConstraint("package ocltest context Tree " + //$NON-NLS-1$
            "inv: forest.trees->includes(self)" + //$NON-NLS-1$
            " endpackage"); //$NON-NLS-1$

        InstanceSpecification aForest = instantiate(instancePackage, forest);

        InstanceSpecification aTree = instantiate(instancePackage, tree);
        addValue(aForest, forest_trees, aTree);
        InstanceSpecification anotherTree = instantiate(instancePackage, tree);
        addValue(aForest, forest_trees, anotherTree);
        aTree = instantiate(instancePackage, tree);
        addValue(aForest, forest_trees, aTree);

        assertTrue(check(expr, anotherTree));
    }

    public void test_nonNavigableAttribute_instanceSpecification() {
        OCLExpression<Classifier> expr = parseConstraint("package ocltest context Tree " + //$NON-NLS-1$
            "inv: forest.trees->includes(self)" + //$NON-NLS-1$
            " endpackage"); //$NON-NLS-1$

        EPackage epackage = UMLUtil.convertToEcore(fruitPackage, null)
            .iterator().next();
        EFactory factory = epackage.getEFactoryInstance();

        // create a resource to provide the context of instance searches
        Resource res = new ResourceImpl(URI.createURI("test://foo")); //$NON-NLS-1$
        res.eAdapters().add(new ECrossReferenceAdapter());

        EPackage.Registry.INSTANCE.put(epackage.getNsURI(), epackage);

        try {
            EClass eTree = (EClass) epackage.getEClassifier("Tree"); //$NON-NLS-1$
            EClass eForest = (EClass) epackage.getEClassifier("Forest"); //$NON-NLS-1$
            EStructuralFeature eTrees = eForest.getEStructuralFeature("trees"); //$NON-NLS-1$

            EObject aForest = factory.create(eForest);
            res.getContents().add(aForest);

            @SuppressWarnings("unchecked")
            EList<EObject> trees = (EList<EObject>) aForest.eGet(eTrees);
            EObject aTree = factory.create(eTree);
            res.getContents().add(aTree);
            trees.add(aTree);
            EObject anotherTree = factory.create(eTree);
            res.getContents().add(anotherTree);
            trees.add(anotherTree);
            aTree = factory.create(eTree);
            res.getContents().add(aTree);
            trees.add(aTree);

            assertTrue(check(expr, anotherTree));
        } finally {
            res.unload();
        }
    }

    //
    // Fixture methods
    //

    @Override
    protected void setUp()
        throws Exception {
        super.setUp();

        instanceResource = resourceSet.createResource(URI
            .createFileURI("/tmp/instances.uml")); //$NON-NLS-1$

        instancePackage = umlf.createPackage();
        instancePackage.setName("instances"); //$NON-NLS-1$
        instanceResource.getContents().add(instancePackage);
    }

    @Override
    protected void tearDown()
        throws Exception {
        instancePackage = null;
        instanceResource.unload();
        resourceSet.getResources().remove(instanceResource);

        super.tearDown();
    }
}