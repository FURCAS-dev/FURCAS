package com.sap.emf.ocl.hiddenopposites;

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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.EvaluationVisitor;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.SendSignalAction;

public class EcoreEnvironmentFactoryWithHiddenOpposites extends
		EcoreEnvironmentFactory {

	/**
     * A convenient shared instance of the environment factory, that creates
     * environments using the global package registry.
	 */
    public static EcoreEnvironmentFactoryWithHiddenOpposites INSTANCE = new EcoreEnvironmentFactoryWithHiddenOpposites();
	
	private OppositeEndFinder oppositeEndFinder;

	@Override
	public EvaluationVisitor<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createEvaluationVisitor(
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
			EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> evalEnv,
			Map<? extends EClass, ? extends Set<? extends EObject>> extentMap) {
        EvaluationVisitorWithHiddenOpposites result =
            new EvaluationVisitorWithHiddenOppositesImpl(env, evalEnv, extentMap);
        if (isEvaluationTracingEnabled()) {
            // decorate the evaluation visitor with tracing support
            result = new TracingEvaluationVisitorWithHiddenOpposites((EvaluationVisitorWithHiddenOpposites) result);
        }
        return result;
	}

	/**
	 * Initializes me.  Environments that I create will use the global package
     * registry to look up packages.
	 */
	public EcoreEnvironmentFactoryWithHiddenOpposites() {
		this(EPackage.Registry.INSTANCE);
	}
	
	/**
	 * Initializes me.  Environments that I create will use the global package
     * registry to look up packages and the <code>oppositeEndFinder</code>
     * specified to lookup up and navigate hidden opposites on references based on
     * annotations.
	 */
	public EcoreEnvironmentFactoryWithHiddenOpposites(OppositeEndFinder oppositeEndFinder) {
		this(EPackage.Registry.INSTANCE, oppositeEndFinder);
	}
	
	/**
	 * Initializes me with an <code>EPackage.Registry</code> that the
     * environments I create will use to look up packages. As a finder for
     * "hidden opposites" based on name annotations on the forward references
     * for the non-existing opposite's name a <code>DefaultOppositeEndFinder</code>
     * will be used. To not look for those annotations at all, use
     * {@link #EcoreEnvironmentFactory(org.eclipse.emf.ecore.EPackage.Registry, OppositeEndFinder)}
     * and pass <code>null</code> for the <code>OppositeEndFinder</code> argument.
     * 
     * @param reg my package registry (must not be <code>null</code>)
	 */
	public EcoreEnvironmentFactoryWithHiddenOpposites(EPackage.Registry reg) {
		this(reg, new DefaultOppositeEndFinder(reg));
	}
	
	/**
	 * Initializes me with an <code>EPackage.Registry</code> that the
     * environments I create will use to look up packages, and with an
     * <code>OppositeEndFinder</code> that the environments I create
     * will use to construct and evaluate <code>OppositePropertyCallExp</code>
     * expressions based on name annotations on the forward references.
     * 
     * @param reg my package registry (must not be <code>null</code>)
     * @param finder for opposite ends; may be <code>null</code> which means that
     * no <code>OppositePropertyCallExp</code> expressions will be synthesized because
     * no lookups can/will be performed for them. To use a default finder, use
     * {@link #EcoreEnvironmentFactory(org.eclipse.emf.ecore.EPackage.Registry)} or
     * {@link #EcoreEnvironmentFactory()}.
	 */
	public EcoreEnvironmentFactoryWithHiddenOpposites(EPackage.Registry reg, OppositeEndFinder oppositeEndFinder) {
		super(reg);
		this.oppositeEndFinder = oppositeEndFinder;
	}
	
    // implements the inherited specification
	@Override
    public Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject>
	createEnvironment() {
		EcoreEnvironmentWithHiddenOppositesImpl result = new EcoreEnvironmentWithHiddenOppositesImpl(getEPackageRegistry(), oppositeEndFinder);
		result.setFactory(this);
		return result;
	}
	
    @Override
        public Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createEnvironment(
                Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent) {
	    EcoreEnvironmentWithHiddenOppositesImpl result = new EcoreEnvironmentWithHiddenOppositesImpl(parent);
	    result.setFactory(this);
	    return result;
        }

	// implements the inherited specification
	@Override
    public Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject>
	loadEnvironment(Resource resource) {
		EcoreEnvironmentWithHiddenOppositesImpl result = new EcoreEnvironmentWithHiddenOppositesImpl(getEPackageRegistry(), resource, oppositeEndFinder);
		result.setFactory(this);
		return result;
	}
	
	@Override
	public EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> createEvaluationEnvironment() {
		return new EvaluationEnvironmentWithHiddenOppositesImpl(oppositeEndFinder);
	}

	@Override
	public EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> createEvaluationEnvironment(
			EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> parent) {
		return new EvaluationEnvironmentWithHiddenOppositesImpl(parent);
	}

	protected OppositeEndFinder getOppositeEndFinder() {
	    return oppositeEndFinder;
	}

    @Override
    public Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createPackageContext(
            Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent,
            EPackage context) {
        return super.createPackageContext(parent, context);
    }
}
