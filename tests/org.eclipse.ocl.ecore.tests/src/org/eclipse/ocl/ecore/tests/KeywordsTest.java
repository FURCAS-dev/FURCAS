/**
 * <copyright>
 * 
 * Copyright (c) 2007 IBM Corporation and others.
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
 * $Id: KeywordsTest.java,v 1.2 2009/10/07 20:39:27 ewillink Exp $
 */

package org.eclipse.ocl.ecore.tests;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.ocl.OCLInput;
import org.eclipse.ocl.expressions.Variable;

/**
 * Tests for usages of model features whose names coincide with "keywords"
 * defined as reserved words by the OCL specification.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class KeywordsTest
    extends AbstractTestSuite {

    Resource res;
    EPackage smalltalk;
    EClass collection;
    EClass block;
    EClass elseClass;
    EClass clazz;
    EClass property;
    EClass constraint;

    public void test_isUnique_162300() {
        helper.setContext(property);

        try {
            helper.createInvariant("self.isUnique implies self.upper > 1"); //$NON-NLS-1$
            helper.createInvariant("isUnique implies self.upper > 1"); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }

    public void test_package_162300() {
        helper.setContext(clazz);

        try {
            helper
                .createInvariant("self._package.oclIsUndefined() implies Set{VisibilityKind::protected, VisibilityKind::_package}->excludes(self.visibility)"); //$NON-NLS-1$
            helper
                .createInvariant("_package.oclIsUndefined() implies Set{VisibilityKind::protected, VisibilityKind::_package}->excludes(self.visibility)"); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }

    public void test_context_162300() {
        helper.setContext(constraint);

        try {
            helper
                .createInvariant("self._context <> null implies _context.oclIsKindOf(Class)"); //$NON-NLS-1$
            helper
                .createInvariant("_context <> null implies self._context.oclIsKindOf(Class)"); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }

    public void test_isUniqueOperation_162300() {
        helper.setContext(collection);

        Variable<EClassifier, EParameter> var = ocl.getEnvironment()
            .getOCLFactory().createVariable();
        var.setName("aBlock"); //$NON-NLS-1$
        var.setType(block);

        ocl.getEnvironment().addElement(var.getName(), var, true);

        try {
            helper.createInvariant("self.isUnique(aBlock)"); //$NON-NLS-1$
            helper.createInvariant("isUnique(aBlock)"); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }

    public void test_selectOperation_162300() {
        helper.setContext(collection);

        Variable<EClassifier, EParameter> var = ocl.getEnvironment()
            .getOCLFactory().createVariable();
        var.setName("aBlock"); //$NON-NLS-1$
        var.setType(block);

        ocl.getEnvironment().addElement(var.getName(), var, true);

        try {
            helper.createInvariant("self.select(aBlock).isEmpty()"); //$NON-NLS-1$
            helper.createInvariant("select(aBlock).isEmpty()"); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }

    public void test_contextOperation_162300() {
        helper.setContext(block);

        try {
            helper.createInvariant("self._context(self).name = 'Block'"); //$NON-NLS-1$
            helper.createInvariant("_context(self).name = 'Block'"); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }

    public void test_reservedPackageName_183362() {
        helper.setContext(block);

        try {
            helper
                .createInvariant("Smalltalk::runtime::_context::language.allInstances()->notEmpty()"); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }

    public void test_reservedPackageName_packageContext_183362() {
        try {
            ocl
                .parse(new OCLInput(
                    "package Smalltalk::runtime::_context context language inv: true endpackage")); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }

    public void test_reservedClassName_183362() {
        helper.setContext(elseClass);

        try {
            helper
                .createInvariant("let e : _else = self in _else.allInstances()->forAll(oclIsKindOf(_else))"); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }

        try {
            helper.createInvariant("self.oclIsKindOf(_context::_else)"); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }

    public void test_reservedClassName_operationContext_183362() {
        try {
            ocl
                .parse(new OCLInput(
                    "package Smalltalk context runtime::_context::_else::doIt() : pre: true endpackage")); //$NON-NLS-1$
            ocl
                .parse(new OCLInput(
                    "package Smalltalk::runtime::_context context _else::doIt() : pre: true endpackage")); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }

    //
    // Framework methods
    //

    @Override
    protected void setUp() {
        super.setUp();

        // create a little test model for a Smalltalk-like collection class that
        // defines operations corresponding to OCL iterators

        res = new ResourceImpl(URI.createURI("foo://smalltalk")); //$NON-NLS-1$

        smalltalk = EcoreFactory.eINSTANCE.createEPackage();
        smalltalk.setName("Smalltalk"); //$NON-NLS-1$
        smalltalk.setNsPrefix("st"); //$NON-NLS-1$
        smalltalk.setNsURI("foo://smalltalk"); //$NON-NLS-1$

        res.getContents().add(smalltalk);
        resourceSet.getPackageRegistry().put(smalltalk.getNsURI(), smalltalk);

        EClass object = EcoreFactory.eINSTANCE.createEClass();
        object.setName("Object"); //$NON-NLS-1$
        smalltalk.getEClassifiers().add(object);

        collection = EcoreFactory.eINSTANCE.createEClass();
        collection.setName("Collection"); //$NON-NLS-1$
        smalltalk.getEClassifiers().add(collection);

        block = EcoreFactory.eINSTANCE.createEClass();
        block.setName("Block"); //$NON-NLS-1$
        smalltalk.getEClassifiers().add(block);

        clazz = EcoreFactory.eINSTANCE.createEClass();
        clazz.setName("Class"); //$NON-NLS-1$
        smalltalk.getEClassifiers().add(clazz);

        property = EcoreFactory.eINSTANCE.createEClass();
        property.setName("Property"); //$NON-NLS-1$
        smalltalk.getEClassifiers().add(property);

        constraint = EcoreFactory.eINSTANCE.createEClass();
        constraint.setName("Constraint"); //$NON-NLS-1$
        smalltalk.getEClassifiers().add(constraint);

        constraint.getESuperTypes().add(object);
        property.getESuperTypes().add(object);
        clazz.getESuperTypes().add(object);
        block.getESuperTypes().add(object);
        collection.getESuperTypes().add(object);

        EEnum visibilityKind = EcoreFactory.eINSTANCE.createEEnum();
        visibilityKind.setName("VisibilityKind"); //$NON-NLS-1$
        smalltalk.getEClassifiers().add(visibilityKind);
        createLiteral(visibilityKind, "public"); //$NON-NLS-1$
        createLiteral(visibilityKind, "protected"); //$NON-NLS-1$
        createLiteral(visibilityKind, "package"); //$NON-NLS-1$
        createLiteral(visibilityKind, "private"); //$NON-NLS-1$
        
        createAttribute(clazz, "name", EcorePackage.Literals.ESTRING); //$NON-NLS-1$
        createAttribute(clazz, "visibility", visibilityKind); //$NON-NLS-1$
        createReference(clazz, "package", object); //$NON-NLS-1$
        createAttribute(property, "isUnique", EcorePackage.Literals.EBOOLEAN); //$NON-NLS-1$
        createAttribute(property, "upper", EcorePackage.Literals.EINT); //$NON-NLS-1$
        createReference(constraint, "context", clazz); //$NON-NLS-1$
        
        EList<String> names = new BasicEList<String>(1);
        EList<EClassifier> types = new BasicEList<EClassifier>(1);

        names.add("object"); //$NON-NLS-1$
        types.add(object);
        createOwnedOperation(block, "context", names, types, clazz); //$NON-NLS-1$

        names.set(0, "block"); //$NON-NLS-1$
        types.set(0, block);
        createOwnedOperation(collection,
            "isUnique", names, types, EcorePackage.Literals.EBOOLEAN); //$NON-NLS-1$
        createOwnedOperation(collection, "select", names, types, collection); //$NON-NLS-1$

        names.clear();
        types.clear();
        createOwnedOperation(collection,
            "isEmpty", names, types, EcorePackage.Literals.EBOOLEAN); //$NON-NLS-1$

        // create some qualified classifier and package names that need
        // escaping of one or more segments. Likewise state names
        EPackage nested = EcoreFactory.eINSTANCE.createEPackage();
        nested.setName("runtime"); //$NON-NLS-1$
        smalltalk.getESubpackages().add(nested);

        EPackage contextPackage = EcoreFactory.eINSTANCE.createEPackage();
        contextPackage.setName("context"); //$NON-NLS-1$
        nested.getESubpackages().add(contextPackage);

        EClass tmp = EcoreFactory.eINSTANCE.createEClass();
        tmp.setName("language"); //$NON-NLS-1$
        contextPackage.getEClassifiers().add(tmp);

        elseClass = EcoreFactory.eINSTANCE.createEClass();
        elseClass.setName("else"); //$NON-NLS-1$
        contextPackage.getEClassifiers().add(elseClass);

        createOwnedOperation(elseClass, "doIt", null, null, null); //$NON-NLS-1$
    }

    private static EOperation createOwnedOperation(EClass eclass, String name,
            List<String> paramNames, List<EClassifier> paramTypes,
            EClassifier type) {
        EOperation result = EcoreFactory.eINSTANCE.createEOperation();
        result.setName(name);
        result.setEType(type);
        eclass.getEOperations().add(result);

        if (paramNames != null) {
            for (int i = 0; i < paramNames.size(); i++) {
                EParameter param = EcoreFactory.eINSTANCE.createEParameter();
                param.setName(paramNames.get(i));
                param.setEType(paramTypes.get(i));
                result.getEParameters().add(param);
            }
        }

        return result;
    }

    private static EAttribute createAttribute(EClass eclass, String name,
            EDataType type) {
        EAttribute result = EcoreFactory.eINSTANCE.createEAttribute();
        result.setName(name);
        result.setEType(type);
        eclass.getEStructuralFeatures().add(result);
        return result;
    }

    private static EReference createReference(EClass eclass, String name,
            EClass type) {
        EReference result = EcoreFactory.eINSTANCE.createEReference();
        result.setName(name);
        result.setEType(type);
        eclass.getEStructuralFeatures().add(result);
        return result;
    }
    
    private static EEnumLiteral createLiteral(EEnum eenum, String name) {
        EEnumLiteral result = EcoreFactory.eINSTANCE.createEEnumLiteral();
        result.setName(name);
        eenum.getELiterals().add(result);
        return result;
    }
}
