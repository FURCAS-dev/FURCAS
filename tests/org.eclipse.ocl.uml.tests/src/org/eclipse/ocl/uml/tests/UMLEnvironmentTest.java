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
 * $Id: UMLEnvironmentTest.java,v 1.4 2007/11/06 19:46:58 cdamus Exp $
 */

package org.eclipse.ocl.uml.tests;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EnvironmentFactory;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.ocl.options.Customizable;
import org.eclipse.ocl.options.EvaluationOptions;
import org.eclipse.ocl.options.Option;
import org.eclipse.ocl.options.ParsingOptions;
import org.eclipse.ocl.options.ProblemOption;
import org.eclipse.ocl.uml.OCL;
import org.eclipse.ocl.uml.UMLEnvironment;
import org.eclipse.ocl.uml.UMLEnvironmentFactory;
import org.eclipse.ocl.uml.UMLEvaluationEnvironment;
import org.eclipse.ocl.uml.options.EvaluationMode;
import org.eclipse.ocl.uml.options.UMLEvaluationOptions;
import org.eclipse.ocl.util.OCLUtil;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.SendSignalAction;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Tests the {@link UMLEnvironment} class.
 *
 * @author Christian W. Damus (cdamus)
 */
public class UMLEnvironmentTest
    extends AbstractTestSuite {

    public UMLEnvironmentTest(String name) {
        super(name);
    }
    
    public static Test suite() {
        return new TestSuite(UMLEnvironmentTest.class, "UML Environment Tests"); //$NON-NLS-1$
    }
    
    /**
     * Tests extensibility of the OCL Ecore environment.
     */
    public void test_extensibility_156360() {
        OCL ocl = OCL.newInstance(new MyEnvironmentFactory());

        OCL.Helper helper = ocl.createOCLHelper();
        helper.setContext(getUMLString());

        Constraint constraint = null;
        
        try {
            constraint = helper.createInvariant(
                    "self.regexMatch('\\d{3}-\\d{3}-\\d{3}') <> null"); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
        
        assertTrue(ocl.check("123-456-789", constraint)); //$NON-NLS-1$
        assertFalse(ocl.check("123-4567-890", constraint)); //$NON-NLS-1$
        assertFalse(ocl.check("123-abc-456", constraint)); //$NON-NLS-1$
    }
    
    /**
     * Tests the instance-model evaluation mode.
     */
    public void test_evaluationMode_instanceModel_194390() {
        UMLEnvironmentFactory factory = new UMLEnvironmentFactory(resourceSet);
        
        OCL ocl = OCL.newInstance(factory);
        EvaluationOptions.setOption(ocl.getEvaluationEnvironment(),
            UMLEvaluationOptions.EVALUATION_MODE,
            EvaluationMode.INSTANCE_MODEL);

        OCL.Helper helper = ocl.createOCLHelper();
        helper.setContext(getMetaclass("Element")); //$NON-NLS-1$

        Constraint constraint = null;
        
        try {
            constraint = helper.createInvariant(
                    "self.oclIsKindOf(InstanceSpecification)"); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
        
        InstanceSpecification instance1 = (InstanceSpecification) fruitPackage.createPackagedElement(
            null, UMLPackage.Literals.INSTANCE_SPECIFICATION);
        instance1.getClassifiers().add(apple);
        
        try {
            // if we had treated this as an EObject (not an InstanceSpecification)
            // then this would have checked true
            assertFalse(ocl.check(instance1, constraint));
            
            instance1.getClassifiers().add(getMetaclass("InstanceSpecification")); //$NON-NLS-1$
            
            // now we really are an instance of InstanceSpecification
            assertTrue(ocl.check(instance1, constraint));
        } finally {
            // clean up
            instance1.destroy();
        }
    }
    
    /**
     * Tests the Java-EObjects evaluation mode.
     */
    public void test_evaluationMode_runtimeObjects_194390() {
        UMLEnvironmentFactory factory = new UMLEnvironmentFactory(resourceSet);
        
        OCL ocl = OCL.newInstance(factory);
        EvaluationOptions.setOption(ocl.getEvaluationEnvironment(),
            UMLEvaluationOptions.EVALUATION_MODE,
            EvaluationMode.RUNTIME_OBJECTS);

        OCL.Helper helper = ocl.createOCLHelper();
        helper.setContext(getMetaclass("Element")); //$NON-NLS-1$

        Constraint constraint1 = null;
        Constraint constraint2 = null;
        
        try {
            constraint1 = helper.createInvariant(
                    "self.oclIsKindOf(InstanceSpecification)"); //$NON-NLS-1$
            constraint2 = helper.createInvariant(
                    "self.oclIsKindOf(ocltest::Apple)"); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
        
        InstanceSpecification instance1 = (InstanceSpecification) fruitPackage.createPackagedElement(
            null, UMLPackage.Literals.INSTANCE_SPECIFICATION);
        instance1.getClassifiers().add(apple);
        
        try {
            // now we really are an instance of InstanceSpecification
            assertTrue(ocl.check(instance1, constraint1));
            
            // if we had treated this as an InstanceSpecification (not an EObject)
            // then this would have checked true
            assertFalse(ocl.check(instance1, constraint2));
        } finally {
            // clean up
            instance1.destroy();
        }
    }
    
    /**
     * Tests the adaptive evaluation mode.
     */
    public void test_evaluationMode_adaptive_194390() {
        UMLEnvironmentFactory factory = new UMLEnvironmentFactory(resourceSet);
        
        OCL ocl = OCL.newInstance(factory);
        EvaluationOptions.setOption(ocl.getEvaluationEnvironment(),
            UMLEvaluationOptions.EVALUATION_MODE,
            EvaluationMode.ADAPTIVE);

        OCL.Helper helper = ocl.createOCLHelper();
        helper.setContext(getMetaclass("Element")); //$NON-NLS-1$

        Constraint constraint = null;
        
        try {
            constraint = helper.createInvariant(
                    "self.oclIsKindOf(InstanceSpecification) or self.owner.oclIsKindOf(InstanceSpecification)"); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
        
        InstanceSpecification instance1 = (InstanceSpecification) fruitPackage.createPackagedElement(
            null, UMLPackage.Literals.INSTANCE_SPECIFICATION);
        instance1.getClassifiers().add(apple);
        Comment comment = instance1.createOwnedComment();
        InstanceSpecification instance2 = (InstanceSpecification) fruitPackage.createPackagedElement(
            null, UMLPackage.Literals.INSTANCE_SPECIFICATION);
        instance2.getClassifiers().add(getMetaclass("InstanceSpecification")); //$NON-NLS-1$
        
        try {
            // adaptive mode handles instance specification (M1 level) when it
            //   happens to be classified by the "InstanceSpecification" metaclass
            assertTrue(ocl.check(instance2, constraint));
            
            // adaptive mode handles Java instance (M0 level) based on context
            //   being a non-instance-like element
            assertTrue(ocl.check(comment, constraint));
            
            // adaptive mode does not handle Java instance when it is a
            //  value- or instance-specification (M0 level)
            assertFalse(ocl.check(instance1, constraint));
        } finally {
            // clean up
            instance2.destroy();
            comment.destroy();
            instance1.destroy();
        }
    }
    
    /**
     * Tests that nested environments correctly copy their parent options when
     * inheriting the entire options map ({@link Customizable#getOptions()}).
     */
    public void test_optionInheritance() {
        Environment<Package, Classifier, Operation, Property, EnumerationLiteral, Parameter, State, CallOperationAction, SendSignalAction, Constraint, Class, EObject>
        parent = ocl.getEnvironment();
        
        // set option in parent environment
        ParsingOptions.setOption(parent, ProblemOption.CLOSURE_ITERATOR,
            ProblemHandler.Severity.INFO);
        
        Map<Option<?>, Object> parentOptions =
            OCLUtil.getAdapter(parent, Customizable.class).getOptions();
        
        // check that the map has the option
        assertSame(ProblemHandler.Severity.INFO, parentOptions.get(ProblemOption.CLOSURE_ITERATOR));
        
        Environment<Package, Classifier, Operation, Property, EnumerationLiteral, Parameter, State, CallOperationAction, SendSignalAction, Constraint, Class, EObject>
        child = parent.getFactory().createEnvironment(parent);
        
        Map<Option<?>, Object> childOptions =
            OCLUtil.getAdapter(child, Customizable.class).getOptions();
        
        // check that the child's map has the option
        assertSame(ProblemHandler.Severity.INFO, parentOptions.get(ProblemOption.CLOSURE_ITERATOR));
        
        // all of the options should be the same
        assertEquals(parentOptions, childOptions);
        
        // but different maps
        assertNotSame(parentOptions, childOptions);
        
        // change option in child
        ParsingOptions.setOption(child, ProblemOption.CLOSURE_ITERATOR,
            ProblemHandler.Severity.ERROR);
        childOptions = OCLUtil.getAdapter(child, Customizable.class).getOptions();
        
        assertFalse(parentOptions.equals(childOptions));
        
        assertSame(ProblemHandler.Severity.ERROR, childOptions.get(ProblemOption.CLOSURE_ITERATOR));
    }
    
    //
    // Framework methods
    //
    
    class MyEnvironment extends UMLEnvironment {
        Operation regexMatch;
        
        // this constructor is used to initialize the root environment
        MyEnvironment(EPackage.Registry registry, ResourceSet rset) {
            super(registry, rset);
            
            defineCustomOperations();
        }
        
        // this constructor is used to initialize child environments
        MyEnvironment(MyEnvironment parent) {
            super(parent);
            
            // get the parent's custom operations
            regexMatch = parent.regexMatch;
        }
        
        @Override
        protected void setFactory(
                EnvironmentFactory<Package, Classifier, Operation, Property, EnumerationLiteral, Parameter, State, CallOperationAction, SendSignalAction, Constraint, Class, EObject> factory) {
            super.setFactory(factory);
        }
        
        // use the AbstractEnvironment's mechanism for defining "additional operations"
        // to add our custom operation to OCL's String primitive type
        private void defineCustomOperations() {
            // pattern-matching operation
            regexMatch = UMLFactory.eINSTANCE.createOperation();
            regexMatch.setName("regexMatch"); //$NON-NLS-1$
            regexMatch.setType(getOCLStandardLibrary().getString());
            regexMatch.createOwnedParameter("pattern", getOCLStandardLibrary().getString()); //$NON-NLS-1$
            regexMatch.setIsQuery(true);
            
            // annotate it so that we will recognize it in the evaluation environment
            regexMatch.addKeyword("MyEnvironment"); //$NON-NLS-1$
            
            // define it as an additional operation on OCL String
            addOperation(getOCLStandardLibrary().getString(), regexMatch);
        }
    }

    class MyEvaluationEnvironment extends UMLEvaluationEnvironment {
        MyEvaluationEnvironment(UMLEnvironmentFactory factory) {
            super(factory);
        }

        MyEvaluationEnvironment(
                EvaluationEnvironment<Classifier, Operation, Property, Class, EObject> parent) {
            super(parent);
        }
        
        @Override
        public Object callOperation(Operation operation, int opcode, Object source, Object[] args) {
            if (!operation.getKeywords().contains("MyEnvironment")) { //$NON-NLS-1$
                // not our custom regex operation
                return super.callOperation(operation, opcode, source, args);
            }
            
            if ("regexMatch".equals(operation.getName())) { //$NON-NLS-1$
                Pattern pattern = Pattern.compile((String) args[0]);
                Matcher matcher = pattern.matcher((String) source);
                
                return matcher.matches()? matcher.group() : null;
            }
            
            throw new UnsupportedOperationException();  // unknown operation
        }
    }

    class MyEnvironmentFactory extends UMLEnvironmentFactory {
        @Override
        public MyEnvironment createEnvironment() {
            MyEnvironment result = new MyEnvironment(getEPackageRegistry(), getResourceSet());
            result.setFactory(this);
            return result;
        }
        
        @Override
        public Environment<Package, Classifier, Operation, Property, EnumerationLiteral, Parameter, State, CallOperationAction, SendSignalAction, Constraint, Class, EObject>
        createEnvironment(Environment<Package, Classifier, Operation, Property, EnumerationLiteral, Parameter, State, CallOperationAction, SendSignalAction, Constraint, Class, EObject> parent) {
            if (!(parent instanceof MyEnvironment)) {
                throw new IllegalArgumentException(
                    "Parent environment must be my environment: " + parent); //$NON-NLS-1$
            }
            
            MyEnvironment result = new MyEnvironment((MyEnvironment) parent);
            result.setFactory(this);
            return result;
        }

        @Override
        public EvaluationEnvironment<Classifier, Operation, Property, Class, EObject>
        createEvaluationEnvironment() {
            return new MyEvaluationEnvironment(this);
        }

        @Override
        public EvaluationEnvironment<Classifier, Operation, Property, Class, EObject>
        createEvaluationEnvironment(
                EvaluationEnvironment<Classifier, Operation, Property, Class, EObject> parent) {
            return new MyEvaluationEnvironment(parent);
        }
        
        
    }
}
