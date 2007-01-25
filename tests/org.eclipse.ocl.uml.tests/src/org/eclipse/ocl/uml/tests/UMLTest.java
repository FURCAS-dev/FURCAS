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
 * $Id: UMLTest.java,v 1.1 2007/01/25 18:41:56 cdamus Exp $
 */

package org.eclipse.ocl.uml.tests;

import java.util.Set;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;

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
        imported.createOwnedClass("Foo", false).createOwnedAttribute("boo", getUMLBoolean());  //$NON-NLS-1$//$NON-NLS-2$
        
        fruitPackage.createPackageImport(imported);
        
		parseConstraint(
			"package ocltest context Fruit " + //$NON-NLS-1$
			"inv: self.oclIsKindOf(Foo) implies self.oclAsType(Foo).boo " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
	}
    
    /**
     * Tests the navigation of properties that are redefined in the actual
     * type of an instance specification (redefinition already handled internally
     * by generated code).
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
        OCLExpression<Classifier> expr = parse(
            "package ocltest context Fruit " + //$NON-NLS-1$
            "inv: self.friends" + //$NON-NLS-1$
            " endpackage"); //$NON-NLS-1$
        
        // check that we got the value of the slot for the redefining property
        assertEquals(apples, evaluate(expr, anApple));
    }

    //
    // Fixture methods
    //
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        
        instanceResource = resourceSet.createResource(
                URI.createFileURI("/tmp/instances.uml")); //$NON-NLS-1$
        
        instancePackage = umlf.createPackage();
        instancePackage.setName("instances"); //$NON-NLS-1$
        instanceResource.getContents().add(instancePackage);
    }
    
    @Override
    protected void tearDown() throws Exception {
        instancePackage = null;
        instanceResource.unload();
        resourceSet.getResources().remove(instanceResource);
        
        super.tearDown();
    }
}
