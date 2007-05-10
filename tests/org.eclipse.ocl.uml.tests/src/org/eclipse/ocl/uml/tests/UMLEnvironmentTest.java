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
 * $Id: UMLEnvironmentTest.java,v 1.1 2007/05/10 13:16:27 cdamus Exp $
 */

package org.eclipse.ocl.uml.tests;

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
import org.eclipse.ocl.uml.OCL;
import org.eclipse.ocl.uml.UMLEnvironment;
import org.eclipse.ocl.uml.UMLEnvironmentFactory;
import org.eclipse.ocl.uml.UMLEvaluationEnvironment;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.SendSignalAction;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.UMLFactory;

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
