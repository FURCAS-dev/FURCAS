/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 248869
 *   Borland - Bug 242880
 *   E.D.Willink - Bug 295166
 *   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - Bug 333032
 *
 * </copyright>
 *
 * $Id: EcoreEnvironmentTest.java,v 1.10 2010/02/09 21:04:27 ewillink Exp $
 */

package org.eclipse.ocl.ecore.tests;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EnvironmentFactory;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.EcoreEvaluationEnvironment;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.helper.Choice;
import org.eclipse.ocl.helper.ChoiceKind;
import org.eclipse.ocl.helper.ConstraintKind;
import org.eclipse.ocl.helper.OCLHelper;
import org.eclipse.ocl.options.ParsingOptions;

/**
 * Tests the {@link ExpressionsUtil} class.
 *
 * @author Christian Vogt (cvogt)
 */
@SuppressWarnings("nls")
public class EcoreEnvironmentTest
	extends AbstractTestSuite {

	/**
	 * Tests the default EcoreEnvironment which uses the global package registry.
	 */
	public void test_globalEPackageRegistry_lookup() {
		// add a context which we won't use
		helper.setContext(EcorePackage.eINSTANCE.getEClassifier());

		final String EXPRESSION = "ocltest::Color::";

		// choices should be returned
		List<Choice> choices = helper.getSyntaxHelp(ConstraintKind.INVARIANT, EXPRESSION);
		assertNotNull(choices);
		assertFalse(choices.isEmpty());
		assertChoice(choices, ChoiceKind.ENUMERATION_LITERAL, "green");
		
		// remove the package from the global registry
		resourceSet.getPackageRegistry().remove(fruitPackage.getNsURI());

		// registry no longer contains the fruit package
		// no choices should be returned
		choices = helper.getSyntaxHelp(ConstraintKind.INVARIANT, EXPRESSION); 
		assertNotNull(choices);
		assertTrue(choices.isEmpty());
	}

	/**
	 * Tests the use of a custom package registry with the EcoreEnvironment.
	 */
	public void test_customEPackageRegistry_lookup() {
		EPackage.Registry registry = new EPackageRegistryImpl();

		ocl.dispose();
		ocl = OCL.newInstance(new EcoreEnvironmentFactory(registry));
		OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint> helper =
			ocl.createOCLHelper();
		
		// add a context which we won't use
		helper.setContext(EcorePackage.eINSTANCE.getEClassifier());

		final String EXPRESSION = "ocltest::Color::";

		// registry is empty, no choices should be returned
		List<Choice> choices = helper.getSyntaxHelp(ConstraintKind.INVARIANT, EXPRESSION); 
		assertNotNull(choices);
		assertTrue(choices.isEmpty());
		
		// add the fruit package to the registry
		registry.put(fruitPackage.getNsURI(), fruitPackage);

		// choices should now be returned
		choices = helper.getSyntaxHelp(ConstraintKind.INVARIANT, EXPRESSION);
		assertNotNull(choices);
		assertFalse(choices.isEmpty());
		assertChoice(choices, ChoiceKind.ENUMERATION_LITERAL, "green");
	}
    
    public void test_evaluationEnvironment_getType_178901() {
        EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject>
        evalEnv = ocl.getEvaluationEnvironment();
        
        assertSame(EcorePackage.Literals.EPACKAGE, evalEnv.getType(fruitPackage));
        assertSame(EcorePackage.Literals.ECLASS, evalEnv.getType(fruit));
        assertSame(EcorePackage.Literals.ERESOURCE_SET, evalEnv.getType(new ResourceSetImpl()));
        assertSame(getOCLStandardLibrary().getString(), evalEnv.getType("foo"));
        assertSame(getOCLStandardLibrary().getOclAny(), evalEnv.getType(this));
    }
    
    /**
     * Tests extensibility of the OCL Ecore environment.
     */
    public void test_extensibility_156360() {
		ocl.dispose();
        OCL ocl = OCL.newInstance(new MyEnvironmentFactory());

        OCL.Helper helper = ocl.createOCLHelper();
        helper.setContext(EcorePackage.Literals.ESTRING);

        Constraint constraint = null;
        
        try {	// Double \ for Java and Double \ again for OCL String Literal
            constraint = helper.createInvariant(
                    "self.regexMatch('\\\\d{3}-\\\\d{3}-\\\\d{3}') <> null");
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage());
        }
        
        assertTrue(ocl.check("123-456-789", constraint));
        assertFalse(ocl.check("123-4567-890", constraint));
        assertFalse(ocl.check("123-abc-456", constraint));
    }
	
    /**
     * Tests extensibility of the OCL Ecore environment, that the particular
     * scenario also works with backslash escaping, such that the Java operation
     * implementation gets the expected string values.
     */
	public void test_extensibility_156360_with_backslash_escaping() {
		OCL ocl = OCL.newInstance(new MyEnvironmentFactory());

		OCL.Helper helper = ocl.createOCLHelper();
		helper.setContext(EcorePackage.Literals.ESTRING);

		Constraint constraint = null;

		Boolean oldBackslashProcessingEnabled = ParsingOptions.getValue(ocl
			.getEnvironment(), ParsingOptions.USE_BACKSLASH_ESCAPE_PROCESSING);
		ParsingOptions.setOption(ocl.getEnvironment(),
			ParsingOptions.USE_BACKSLASH_ESCAPE_PROCESSING, true);

		try {
			constraint = helper
				.createInvariant("self.regexMatch('\\\\d{3}-\\\\d{3}-\\\\d{3}') <> null");
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage());
		} finally {
			ParsingOptions.setOption(ocl.getEnvironment(),
				ParsingOptions.USE_BACKSLASH_ESCAPE_PROCESSING,
				oldBackslashProcessingEnabled);
		}

		assertTrue(ocl.check("123-456-789", constraint));
		assertFalse(ocl.check("123-4567-890", constraint));
		assertFalse(ocl.check("123-abc-456", constraint));
	}
	
	class MyEnvironment extends EcoreEnvironment {
	    EOperation regexMatch;
	    
	    // this constructor is used to initialize the root environment
	    MyEnvironment(EPackage.Registry registry) {
	        super(registry);
	        
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
	            EnvironmentFactory<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> factory) {
	        super.setFactory(factory);
	    }
	    
	    // use the AbstractEnvironment's mechanism for defining "additional operations"
	    // to add our custom operation to OCL's String primitive type
	    private void defineCustomOperations() {
	        // pattern-matching operation
	        regexMatch = EcoreFactory.eINSTANCE.createEOperation();
	        regexMatch.setName("regexMatch");
	        regexMatch.setEType(getOCLStandardLibrary().getString());
	        EParameter parm = EcoreFactory.eINSTANCE.createEParameter();
	        parm.setName("pattern");
	        parm.setEType(getOCLStandardLibrary().getString());
	        regexMatch.getEParameters().add(parm);
	        
	        // annotate it so that we will recognize it in the evaluation environment
	        EAnnotation annotation = EcoreFactory.eINSTANCE.createEAnnotation();
	        annotation.setSource("MyEnvironment");
	        regexMatch.getEAnnotations().add(annotation);
	        
	        // define it as an additional operation on OCL String
	        addHelperOperation(getOCLStandardLibrary().getString(), regexMatch);
	    }
	}

	class MyEvaluationEnvironment extends EcoreEvaluationEnvironment {
	    MyEvaluationEnvironment(MyEnvironmentFactory factory) {
	        super(factory);
	    }

	    MyEvaluationEnvironment(
	            EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> parent) {
	        super(parent);
	    }
	    
	    @Override
        public Object callOperation(EOperation operation, int opcode, Object source, Object[] args) {
	        if (operation.getEAnnotation("MyEnvironment") == null) {
	            // not our custom regex operation
	            return super.callOperation(operation, opcode, source, args);
	        }
	        
	        if ("regexMatch".equals(operation.getName())) {
	            Pattern pattern = Pattern.compile((String) args[0]);
	            Matcher matcher = pattern.matcher((String) source);
	            
	            return matcher.matches()? matcher.group() : null;
	        }
	        
	        throw new UnsupportedOperationException();  // unknown operation
	    }
	}

	class MyEnvironmentFactory extends EcoreEnvironmentFactory {
	    @Override
        public Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject>
	    createEnvironment() {
	        MyEnvironment result = new MyEnvironment(getEPackageRegistry());
	        result.setFactory(this);
	        return result;
	    }
	    
	    @Override
        public Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject>
	    createEnvironment(Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent) {
	        if (!(parent instanceof MyEnvironment)) {
	            throw new IllegalArgumentException(
	                "Parent environment must be my environment: " + parent);
	        }
	        
	        MyEnvironment result = new MyEnvironment((MyEnvironment) parent);
	        result.setFactory(this);
	        return result;
	    }

	    @Override
        public EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject>
	    createEvaluationEnvironment() {
	        return new MyEvaluationEnvironment(this);
	    }

	    @Override
        public EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject>
	    createEvaluationEnvironment(
	            EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> parent) {
	        return new MyEvaluationEnvironment(parent);
	    }
	    
	    
	}

}
