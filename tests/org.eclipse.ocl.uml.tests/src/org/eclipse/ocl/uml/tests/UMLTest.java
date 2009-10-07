/**
 * <copyright>
 *
 * Copyright (c) 2007, 2008 IBM Corporation and others.
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
 * $Id: UMLTest.java,v 1.8 2009/10/07 20:41:45 ewillink Exp $
 */

package org.eclipse.ocl.uml.tests;

import java.util.Map;
import java.util.Set;

import junit.framework.AssertionFailedError;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.VisibilityKind;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Tests involving constructs peculiar to the UML.
 * 
 * @author Christian W. Damus (cwdamus)
 */
public class UMLTest
    extends AbstractTestSuite {

	Resource instanceResource;
    Package instancePackage;

    /**
     * Tests that name look-up accounts for namespace imports.
     */
    public void test_importedElements() {
        expectModified = true;
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
        expectModified = true;
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
        expectModified = true;
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
        expectModified = true;
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
        expectModified = true;
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

    /**
     * Test accessing operations that are aliased by the
     * <tt>&lt;&lt;eOperation&gt;&gt;</tt> stereotype.
     */
    public void test_aliasedOperation_bug184753() {
        OCLExpression<Classifier> expr = parseConstraint(
            "package uml context Namespace " + //$NON-NLS-1$
            "inv:  self.importedMember()->isEmpty()" + //$NON-NLS-1$
            " endpackage"); //$NON-NLS-1$
        
        try {
            assertNotSame(getInvalid(), evaluate(expr, umlMetamodel));
        } catch (RuntimeException e) {
            fail("Failed to evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }

    /**
     * Test accessing attributes that are aliased by the
     * <tt>&lt;&lt;eAttribute&gt;&gt;</tt> stereotype.
     */
    public void test_aliasedAttribute_bug184753() {
        OCLExpression<Classifier> expr = parseConstraint(
            "package ocltest context Aliased " + //$NON-NLS-1$
            "inv:  self.isAliased" + //$NON-NLS-1$
            " endpackage"); //$NON-NLS-1$
        
        Map<String, String> options = new java.util.HashMap<String, String>();
        options.put(UMLUtil.UML2EcoreConverter.OPTION__ECORE_TAGGED_VALUES,
            UMLUtil.OPTION__PROCESS);
        EPackage epkg = UMLUtil.convertToEcore(fruitPackage, options).iterator().next();
        
        try {
            resourceSet.getPackageRegistry().put(epkg.getNsURI(), epkg);
            
            // create an instance.  Note that the class name is aliased, too
            EObject instance = epkg.getEFactoryInstance().create(
                (EClass) epkg.getEClassifier("HasAliases")); //$NON-NLS-1$
            
            // the attribute alias
            instance.eSet(instance.eClass().getEStructuralFeature("aliased"), //$NON-NLS-1$
                Boolean.TRUE);
            
            assertEquals(Boolean.TRUE, evaluate(expr, instance));
        } catch (RuntimeException e) {
            fail("Failed to evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
        } finally {
            resourceSet.getPackageRegistry().remove(epkg.getNsURI());
        }
    }

    /**
     * Test accessing private attributes in general classifiers.
     */
    public void test_privateAttributeInheritance_214224() {
        expectModified = true;
        fruit_color.setVisibility(VisibilityKind.PRIVATE_LITERAL);
        
        EPackage epkg = UMLUtil.convertToEcore(fruitPackage, null).iterator().next();
        
        try {
            resourceSet.getPackageRegistry().put(epkg.getNsURI(), epkg);
            
            OCLExpression<Classifier> expr = parseConstraint(
                "package ocltest context Apple " + //$NON-NLS-1$
                "inv:  self.color <> Color::brown" + //$NON-NLS-1$
                " endpackage"); //$NON-NLS-1$
            
            // create an instance
            EObject instance = epkg.getEFactoryInstance().create(
                (EClass) epkg.getEClassifier("Apple")); //$NON-NLS-1$
            
            assertEquals(Boolean.TRUE, evaluate(expr, instance));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }

    /**
     * Test accessing private operations in general classifiers.
     */
    public void test_privateOperationInheritance_214224() {
        expectModified = true;
        fruit_preferredColor.setVisibility(VisibilityKind.PRIVATE_LITERAL);
        
        EPackage epkg = UMLUtil.convertToEcore(fruitPackage, null).iterator().next();
        
        try {
            resourceSet.getPackageRegistry().put(epkg.getNsURI(), epkg);
            
            OCLExpression<Classifier> expr = parseConstraint(
                "package ocltest context Apple " + //$NON-NLS-1$
                "inv:  self.preferredColor() <> Color::brown" + //$NON-NLS-1$
                " endpackage"); //$NON-NLS-1$
            
            // provide a body for the private operation 
            parseConstraint(
                "package ocltest context Fruit::preferredColor() : Color " + //$NON-NLS-1$
                "body: Color::red" + //$NON-NLS-1$
                " endpackage"); //$NON-NLS-1$
            
            // create an instance
            EObject instance = epkg.getEFactoryInstance().create(
                (EClass) epkg.getEClassifier("Apple")); //$NON-NLS-1$
            
            assertEquals(Boolean.TRUE, evaluate(expr, instance));
        } catch (Exception e) {
            fail("Failed to parse or evaluate: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }

    /**
     * Test accessing private signal receptions in general classifiers.
     */
    public void test_privateReceptionInheritance_214224() {
        expectModified = true;
        fruit.getOwnedReceptions().get(0).setVisibility(VisibilityKind.PRIVATE_LITERAL);
        
        try {
            parseConstraint(
                "package ocltest context Apple " + //$NON-NLS-1$
                "inv:  not self^Drop(?, ?)" + //$NON-NLS-1$
                " endpackage"); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }

    //
    // Fixture methods
    //

    @Override
    protected void setUp() {
        super.setUp();

        instanceResource = resourceSet.createResource(URI
            .createFileURI("/tmp/instances.uml")); //$NON-NLS-1$

        instancePackage = umlf.createPackage();
        instancePackage.setName("instances"); //$NON-NLS-1$
        instanceResource.getContents().add(instancePackage);
    }
}