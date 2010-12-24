/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - Bug 333032
 *
 * </copyright>
 *
 * $Id: ExtensibilityTest.java,v 1.5 2010/12/24 10:18:04 asanchez Exp $
 */

package org.eclipse.ocl.ecore.tests;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EnvironmentFactory;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.EvaluationVisitor;
import org.eclipse.ocl.LookupException;
import org.eclipse.ocl.OCLInput;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.SemanticException;
import org.eclipse.ocl.TypeResolver;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.EnvironmentWithHiddenOpposites;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.helper.OCLSyntaxHelper;
import org.eclipse.ocl.parser.AbstractOCLParser;
import org.eclipse.ocl.parser.OCLAnalyzer;
import org.eclipse.ocl.parser.OCLFactoryWithHistory;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.ocl.utilities.OCLFactory;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.ocl.utilities.UMLReflection;
import org.eclipse.ocl.utilities.Visitor;

/**
 * Tests the extensibility of the parser API.
 *
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public class ExtensibilityTest
    extends AbstractTestSuite {

    /**
     * Tests that we can successfully parse with an environment that does not
     * implement the optional adapter protocols.
     */
    public void test_noAdapters_parseSuccessfully() {
        helper.setContext(EcorePackage.Literals.EPACKAGE);
        
        try {
            helper.createInvariant("not self.eClassifiers->isEmpty()");
        } catch (ParserException e) {
            fail("Failed to parse: " + e.getLocalizedMessage());
        }
        
        try {
            ocl.parse(new OCLInput(
                "context ecore::EPackage\n" +
                "inv: not self.eClassifiers->isEmpty()"));
        } catch (ParserException e) {
            fail("Failed to parse: " + e.getLocalizedMessage());
        }
    }

    /**
     * Tests that we can produce warnings with an environment that does not
     * implement the optional adapter protocols.
     */
    public void test_noAdapters_parseWithWarning() {
        helper.setContext(EcorePackage.Literals.EPACKAGE);
        
        try {
            helper.createInvariant("not self.\"eClassifiers\"->isEmpty()");
            
            Diagnostic diag = helper.getProblems();
            assertNotNull(diag);
            assertEquals(Diagnostic.WARNING, diag.getSeverity());
            
            System.out.println("Got expected warning: " + diag.getMessage());
        } catch (ParserException e) {
            fail("Failed to parse: " + e.getLocalizedMessage());
        }
        
        try {
            ocl.parse(new OCLInput(
                "context ecore::EPackage\n" +
                "inv: not self.\"eClassifiers\"->isEmpty()"));
            
            Diagnostic diag = ocl.getProblems();
            assertNotNull(diag);
            assertEquals(Diagnostic.WARNING, diag.getSeverity());
            
            System.out.println("Got expected warning: " + diag.getMessage());
        } catch (ParserException e) {
            fail("Failed to parse: " + e.getLocalizedMessage());
        }
    }

    /**
     * Tests that we can produce errors with an environment that does not
     * implement the optional adapter protocols.
     */
    public void test_noAdapters_parseWithError() {
        helper.setContext(EcorePackage.Literals.EPACKAGE);
        
        try {
            helper.createInvariant("not self.classifiers->isEmpty()");
            fail("Should not have parsed");
        } catch (ParserException e) {
            // success
            System.out.println("Got expected error: " + e.getLocalizedMessage());
        }
        
        try {
            ocl.parse(new OCLInput(
                "context ecore::EPackage\n" +
                "inv: not self.classifiers->isEmpty()"));
            fail("Should not have parsed");
        } catch (ParserException e) {
            // success
            System.out.println("Got expected error: " + e.getLocalizedMessage());
        }
    }

    /**
     * Tests that we can report lexer problems with an environment that does not
     * implement the optional adapter protocols.
     */
    public void test_noAdapters_parseWithTokenError() {
        helper.setContext(EcorePackage.Literals.EPACKAGE);
        
        try {
            helper.createInvariant("not self.;->isEmpty()");
            fail("Should not have parsed");
        } catch (ParserException e) {
            // success
            System.out.println("Got expected error: " + e.getLocalizedMessage());
        }
        
        try {
            ocl.parse(new OCLInput(
                "context ecore::EPackage\n" +
                "inv: not self.;->isEmpty()"));
            fail("Should not have parsed");
        } catch (ParserException e) {
            // success
            System.out.println("Got expected error: " + e.getLocalizedMessage());
        }
    }
    
	//
	// Framework methods
	//
	
	@Override
	protected OCL createOCL() {
	    return OCL.newInstance(new WrapperEnvironmentFactory());
	}
	
	class WrapperEnvironment implements EnvironmentWithHiddenOpposites {
	    
	    private final EnvironmentWithHiddenOpposites
	    delegate;
	    
        private final EnvironmentWithHiddenOpposites
        parent;
        
        private final WrapperEnvironmentFactory factory;
        
	    WrapperEnvironment(WrapperEnvironmentFactory factory,
	            Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> delegate) {
	        this(factory, delegate, null);
	    }

        WrapperEnvironment(WrapperEnvironmentFactory factory,
            Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> delegate,
            Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent) {
            
            this.factory = factory;
            this.delegate = (EnvironmentWithHiddenOpposites) delegate;
            this.parent = (EnvironmentWithHiddenOpposites) parent;
        }
    
        public Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> getParent() {
            return parent;
        }

        public EnvironmentFactory<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> getFactory() {
            return factory;
        }

        public boolean addElement(String name,
                Variable<EClassifier, EParameter> elem, boolean explicit) {
            return delegate.addElement(name, elem, explicit);
        }

        public EStructuralFeature defineAttribute(EClassifier owner,
                Variable<EClassifier, EParameter> variable,
                Constraint constraint) {
            return delegate.defineAttribute(owner, variable, constraint);
        }

        public EOperation defineOperation(EClassifier owner, String name,
                EClassifier type,
                List<Variable<EClassifier, EParameter>> params,
                Constraint constraint) {
            return delegate.defineOperation(owner, name, type, params,
                constraint);
        }

        public void deleteElement(String name) {
            delegate.deleteElement(name);
        }

        public List<EStructuralFeature> getAdditionalAttributes(
                EClassifier classifier) {
            return delegate.getAdditionalAttributes(classifier);
        }

        public List<EOperation> getAdditionalOperations(EClassifier classifier) {
            return delegate.getAdditionalOperations(classifier);
        }

        public Constraint getBodyCondition(EOperation operation) {
            return delegate.getBodyCondition(operation);
        }

        public EClassifier getContextClassifier() {
            return delegate.getContextClassifier();
        }

        public EOperation getContextOperation() {
            return delegate.getContextOperation();
        }

        public EPackage getContextPackage() {
            return delegate.getContextPackage();
        }

        public EStructuralFeature getContextProperty() {
            return delegate.getContextProperty();
        }

        public Constraint getDefinition(Object feature) {
            return delegate.getDefinition(feature);
        }

        public Constraint getDeriveConstraint(EStructuralFeature property) {
            return delegate.getDeriveConstraint(property);
        }

        public Constraint getInitConstraint(EStructuralFeature property) {
            return delegate.getInitConstraint(property);
        }

        public OCLFactory getOCLFactory() {
            return delegate.getOCLFactory();
        }

        public OCLStandardLibrary<EClassifier> getOCLStandardLibrary() {
            return delegate.getOCLStandardLibrary();
        }

        public Variable<EClassifier, EParameter> getSelfVariable() {
            return delegate.getSelfVariable();
        }

        public List<EObject> getStates(EClassifier owner,
                List<String> pathPrefix) {
            return delegate.getStates(owner, pathPrefix);
        }

        public TypeResolver<EClassifier, EOperation, EStructuralFeature> getTypeResolver() {
            return delegate.getTypeResolver();
        }

        public UMLReflection<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> getUMLReflection() {
            return delegate.getUMLReflection();
        }

        public Collection<Variable<EClassifier, EParameter>> getVariables() {
            return delegate.getVariables();
        }

        public boolean isEmpty() {
            return delegate.isEmpty();
        }

        public boolean isInPostcondition(OCLExpression<EClassifier> exp) {
            return delegate.isInPostcondition(exp);
        }

        public Variable<EClassifier, EParameter> lookup(String name) {
            return delegate.lookup(name);
        }

        public EClassifier lookupAssociationClassReference(EClassifier owner,
                String name) {
            return delegate.lookupAssociationClassReference(owner, name);
        }

        public EClassifier lookupClassifier(List<String> names) {
            return delegate.lookupClassifier(names);
        }

        public Variable<EClassifier, EParameter> lookupImplicitSourceForAssociationClass(
                String name) {
            return delegate.lookupImplicitSourceForAssociationClass(name);
        }

        public Variable<EClassifier, EParameter> lookupImplicitSourceForOperation(
                String name, List<? extends TypedElement<EClassifier>> args) {
            return delegate.lookupImplicitSourceForOperation(name, args);
        }

        public Variable<EClassifier, EParameter> lookupImplicitSourceForProperty(
                String name) {
            return delegate.lookupImplicitSourceForProperty(name);
        }

        public Variable<EClassifier, EParameter> lookupImplicitSourceForSignal(
                String name, List<? extends TypedElement<EClassifier>> args) {
            return delegate.lookupImplicitSourceForSignal(name, args);
        }

        public Variable<EClassifier, EParameter> lookupImplicitSourceForState(
                List<String> path)
            throws LookupException, SemanticException {
            return delegate.lookupImplicitSourceForState(path);
        }

        public Variable<EClassifier, EParameter> lookupLocal(String name) {
            return delegate.lookupLocal(name);
        }

        public EOperation lookupOperation(EClassifier owner, String name,
                List<? extends TypedElement<EClassifier>> args) {
            return delegate.lookupOperation(owner, name, args);
        }

        public EPackage lookupPackage(List<String> names) {
            return delegate.lookupPackage(names);
        }

        public EStructuralFeature lookupProperty(EClassifier owner, String name) {
            return delegate.lookupProperty(owner, name);
        }

        public EReference lookupOppositeProperty(EClassifier owner, String name)
            throws LookupException {
	    return delegate.lookupOppositeProperty(owner, name);
	}

	public EClassifier getOppositePropertyType(EClassifier owner, EReference property) {
		return delegate.getOppositePropertyType(owner, property);
	}

	public EClassifier lookupSignal(EClassifier owner, String name,
                List<? extends TypedElement<EClassifier>> args) {
            return delegate.lookupSignal(owner, name, args);
        }

        public EObject lookupState(EClassifier owner, List<String> path)
            throws LookupException, SemanticException {
            return delegate.lookupState(owner, path);
        }

        public void setBodyCondition(EOperation operation, Constraint constraint) {
            delegate.setBodyCondition(operation, constraint);
        }

        public void setDeriveConstraint(EStructuralFeature property,
                Constraint constraint) {
            delegate.setDeriveConstraint(property, constraint);
        }

        public void setInitConstraint(EStructuralFeature property,
                Constraint constraint) {
            delegate.setInitConstraint(property, constraint);
        }

        public void setParent(
                Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
            delegate.setParent(env);
        }

        public void setSelfVariable(Variable<EClassifier, EParameter> var) {
            delegate.setSelfVariable(var);
        }

        public void undefine(Object feature) {
            delegate.undefine(feature);
        }

		public Map<String, EReference> getHiddenOppositeProperties(
				EClassifier classifier) {
			return delegate.getHiddenOppositeProperties(classifier);
		}

		public Variable<EClassifier, EParameter> lookupImplicitSourceForOppositeProperty(
				String name) {
			return delegate.lookupImplicitSourceForOppositeProperty(name);
		}
	}

	class WrapperEnvironmentFactory implements EnvironmentFactory<
            EPackage, EClassifier, EOperation, EStructuralFeature,
            EEnumLiteral, EParameter,
            EObject, CallOperationAction, SendSignalAction, Constraint,
            EClass, EObject> {
	    
	    private final EnvironmentFactory<
            EPackage, EClassifier, EOperation, EStructuralFeature,
            EEnumLiteral, EParameter,
            EObject, CallOperationAction, SendSignalAction, Constraint,
            EClass, EObject> delegate;
	    
	    WrapperEnvironmentFactory(EnvironmentFactory<
                EPackage, EClassifier, EOperation, EStructuralFeature,
                EEnumLiteral, EParameter,
                EObject, CallOperationAction, SendSignalAction, Constraint,
                EClass, EObject> delegate) {
	        this.delegate = delegate;
	    }
	    
	    WrapperEnvironmentFactory() {
	        this(new EcoreEnvironmentFactory());
	    }

	    private Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject>
	    getWrappedEnvironment(Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
	        if (env instanceof WrapperEnvironment) {
	            return ((WrapperEnvironment) env).delegate;
	        } else {
	            return env;
	        }
	    }
	    
        public Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createAttributeContext(
                Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent,
                EStructuralFeature property) {
            return new WrapperEnvironment(this, delegate.createAttributeContext(getWrappedEnvironment(parent), property), parent);
        }

        public Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createClassifierContext(
                Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent,
                EClassifier context) {
            return new WrapperEnvironment(this, delegate.createClassifierContext(getWrappedEnvironment(parent), context), parent);
        }

        public Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createEnvironment() {
            return new WrapperEnvironment(this, delegate.createEnvironment());
        }

        public Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createEnvironment(
                Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent) {
            return new WrapperEnvironment(this, delegate.createEnvironment(getWrappedEnvironment(parent)), parent);
        }

        public EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> createEvaluationEnvironment() {
            return delegate.createEvaluationEnvironment();
        }

        public EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> createEvaluationEnvironment(
                EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> parent) {
            return delegate.createEvaluationEnvironment(parent);
        }

        public EvaluationVisitor<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createEvaluationVisitor(
                Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
                EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> evalEnv,
                Map<? extends EClass, ? extends Set<? extends EObject>> extentMap) {
            return delegate.createEvaluationVisitor(env, evalEnv, extentMap);
        }

        public Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createInstanceContext(
                Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent,
                Object context) {
            return new WrapperEnvironment(this, delegate.createInstanceContext(getWrappedEnvironment(parent), context), parent);
        }

        public Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createOperationContext(
                Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent,
                EOperation operation) {
            return new WrapperEnvironment(this, delegate.createOperationContext(getWrappedEnvironment(parent), operation), parent);
        }

        public Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createPackageContext(
                Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent,
                List<String> pathname) {
            return new WrapperEnvironment(this, delegate.createPackageContext(getWrappedEnvironment(parent), pathname), parent);
        }

        public Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> loadEnvironment(
                Resource resource) {
            return new WrapperEnvironment(this, delegate.loadEnvironment(resource));
        }

		public Visitor<Boolean, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> createValidationVisitor(
				Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
            return delegate.createValidationVisitor(env);
		}

		public OCLAnalyzer<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createOCLAnalyzer(
				Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
				String input) {
            return delegate.createOCLAnalyzer(env, input);
		}

		public OCLAnalyzer<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createOCLAnalyzer(
				AbstractOCLParser parser) {
            return delegate.createOCLAnalyzer(parser);
		}

		public OCLFactoryWithHistory createOCLFactoryWithHistory(
				Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
			return delegate.createOCLFactoryWithHistory(env);
		}

		public OCLSyntaxHelper createOCLSyntaxHelper(
				Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
            return delegate.createOCLSyntaxHelper(env);
		}
	}

}
