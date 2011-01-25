/**
 * <copyright>
 *
 * Copyright (c) 2005, 2010 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
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
 * $Id: EcoreEnvironmentFactory.java,v 1.4 2010/12/24 10:18:06 asanchez Exp $
 */

package org.eclipse.ocl.ecore;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.AbstractEnvironmentFactory;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EnvironmentFactory;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.EvaluationVisitor;
import org.eclipse.ocl.ecore.internal.OCLStandardLibraryImpl;
import org.eclipse.ocl.ecore.internal.UMLReflectionImpl;
import org.eclipse.ocl.ecore.internal.evaluation.TracingEvaluationVisitor;
import org.eclipse.ocl.ecore.opposites.EcoreEnvironmentFactoryWithHiddenOpposites;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;
import org.eclipse.ocl.ecore.parser.OCLAnalyzer;
import org.eclipse.ocl.ecore.parser.OCLFactoryWithHistory;
import org.eclipse.ocl.ecore.parser.ValidationVisitor;
import org.eclipse.ocl.helper.OCLSyntaxHelper;
import org.eclipse.ocl.parser.AbstractOCLParser;
import org.eclipse.ocl.utilities.Visitor;



/**
 * Implementation of the {@link EnvironmentFactory} for parsing OCL expressions
 * on Ecore models.
 *
 * @author Christian W. Damus (cdamus)
 */
public class EcoreEnvironmentFactory
	extends AbstractEnvironmentFactory<
		EPackage, EClassifier, EOperation, EStructuralFeature,
		EEnumLiteral, EParameter,
		EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> {
	
	/**
     * A convenient shared instance of the environment factory, that creates
     * environments using the global package registry.
	 */
    public static EcoreEnvironmentFactory INSTANCE = new EcoreEnvironmentFactory();
	
	private final EPackage.Registry registry;

	private OppositeEndFinder oppositeEndFinder = null;

	/**
	 * Initializes me.  Environments that I create will use the global package
     * registry to look up packages.
	 */
	public EcoreEnvironmentFactory() {
		this(EPackage.Registry.INSTANCE);
	}
	
	/**
	 * Initializes me with an <code>EPackage.Registry</code> that the
     * environments I create will use to look up packages.
     * 
     * @param reg my package registry (must not be <code>null</code>)
	 */
	public EcoreEnvironmentFactory(EPackage.Registry reg) {
		super();
		this.registry = reg;
	}
	
    // implements the inherited specification
    public Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject>
	createEnvironment() {
		EcoreEnvironment result = new EcoreEnvironment(this, null);
		return result;
	}
	
    // implements the inherited specification
    public Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject>
	loadEnvironment(Resource resource) {
		EcoreEnvironment result = new EcoreEnvironment(this, resource);
		return result;
	}
	
    /**
     * Obtains the package registry used by environment that I create to look
     * up packages.
     * 
     * @return my package registry
     */
	public final EPackage.Registry getEPackageRegistry() {
		return registry;
	}
	
    // implements the inherited specification
	@Override
	protected EPackage lookupPackage(List<String> pathname) {
		return EcoreEnvironment.findPackage(pathname, registry);
	}

    // implements the inherited specification
	@Override
	protected EClassifier getClassifier(Object context) {
        return oclType(context);
	}
    
    static EClassifier oclType(Object object) {
        EClassifier result = null;
        
        if (object instanceof EObject) {
            result = ((EObject) object).eClass();
        } else {
            // maybe it's an instance of an Ecore data type?
            for (EClassifier next : EcorePackage.eINSTANCE.getEClassifiers()) {
                if ((next != EcorePackage.Literals.EJAVA_OBJECT) && (next.isInstance(object))) {
                    result = UMLReflectionImpl.INSTANCE.asOCLType(next);
                    break;
                }
            }
            
            if (result == null) {
                // it's just some weirdo object that we don't understand
                result = OCLStandardLibraryImpl.INSTANCE.getOclAny();
            }
        }
        
        return result;
    }

    // implements the inherited specification
	public Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject>
	createEnvironment(Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent) {
		if (!(parent instanceof EcoreEnvironment)) {
			throw new IllegalArgumentException(
				"Parent environment must be an Ecore environment: " + parent); //$NON-NLS-1$
		}
		
		EcoreEnvironment result = new EcoreEnvironment(parent);
		return result;
	}

    // implements the inherited specification
	public EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject>
	createEvaluationEnvironment() {
		return new EcoreEvaluationEnvironment(this);
	}

    // implements the inherited specification
	public EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject>
	createEvaluationEnvironment(
			EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> parent) {
		return new EcoreEvaluationEnvironment(parent);
	}

	/**
	 * @since 3.1
	 */
	@Override
	public OCLAnalyzer createOCLAnalyzer(
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
			String input) {
		return new OCLAnalyzer(env, input);
	}

	/**
	 * @since 3.1
	 */
	@Override
	public OCLAnalyzer createOCLAnalyzer(
			AbstractOCLParser parser) {
		return new OCLAnalyzer(parser);
	}

	/**
	 * @since 3.1
	 */
	public OCLFactoryWithHistory createOCLFactoryWithHistory(
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
		return new OCLFactoryWithHistory(env.getOCLFactory());
	}

	/**
	 * @since 3.1
	 */
    @Override
	public OCLSyntaxHelper createOCLSyntaxHelper(
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
		return new org.eclipse.ocl.ecore.internal.helper.OCLSyntaxHelper(env);
	}

	/**
	 * @since 3.1
	 */
    @Override
	public Visitor<Boolean, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> createValidationVisitor(
		Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
		return new ValidationVisitor(env);
	}

	/**
	 * Returns a <code>null</code> opposite end finder. This means that by default no hidden opposites
	 * will be found and no CPU cycles will be used even for looking them up.<p>
	 * 
	 * Subclasses can redefine this accordingly. See, e.g., {@link EcoreEnvironmentFactoryWithHiddenOpposites}.
	 * 
	 * @since 3.1
	 */
    protected OppositeEndFinder createOppositeEndFinder(EPackage.Registry registry) {
		return null;
	}

	/**
	 * @since 3.1
	 */
    public OppositeEndFinder getOppositeEndFinder() {
    	if (oppositeEndFinder == null) {
    		oppositeEndFinder = createOppositeEndFinder(registry);
    	}
		return oppositeEndFinder;
	}

	/**
	 * @since 3.1
	 */
	public EvaluationVisitor<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createEvaluationVisitor(
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
			EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> evalEnv,
			Map<? extends EClass, ? extends Set<? extends EObject>> extentMap) {
		EvaluationVisitor<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> result = new EvaluationVisitorImpl(
			env, evalEnv, extentMap);

		if (isEvaluationTracingEnabled()) {
			// decorate the evaluation visitor with tracing support
			result = new TracingEvaluationVisitor(result);
		}
		return result;
	}

}
