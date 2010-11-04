package de.hpi.sam.bp2009.solution.oclToMqlMapping.impl;

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
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.EvaluationVisitor;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;

import com.sap.emf.ocl.hiddenopposites.EcoreEnvironmentFactoryWithHiddenOpposites;
import com.sap.emf.oppositeendfinder.DefaultOppositeEndFinder;
import com.sap.emf.oppositeendfinder.OppositeEndFinder;

public class MappingOCLEnvironmentFactory extends EcoreEnvironmentFactoryWithHiddenOpposites {
    public static MappingOCLEnvironmentFactory INSTANCE = new MappingOCLEnvironmentFactory();

    /**
     * Initializes me. Environments that I create will use the global package registry to look up packages.
     */
    public MappingOCLEnvironmentFactory() {
        super();
    }

    /**
     * Initializes me. Environments that I create will use the global package registry to look up packages and the
     * <code>oppositeEndFinder</code> specified to lookup up and navigate hidden opposites on references based on annotations.
     */
    public MappingOCLEnvironmentFactory(OppositeEndFinder oppositeEndFinder) {
        super(oppositeEndFinder);
    }

    /**
     * Initializes me with an <code>EPackage.Registry</code> that the environments I create will use to look up packages. As a
     * finder for "hidden opposites" based on name annotations on the forward references for the non-existing opposite's name a
     * <code>DefaultOppositeEndFinder</code> will be used. To not look for those annotations at all, use
     * {@link #EcoreEnvironmentFactory(org.eclipse.emf.ecore.EPackage.Registry, OppositeEndFinder)} and pass <code>null</code> for
     * the <code>OppositeEndFinder</code> argument.
     * 
     * @param reg
     *            my package registry (must not be <code>null</code>)
     */
    public MappingOCLEnvironmentFactory(EPackage.Registry reg) {
        super(reg, new DefaultOppositeEndFinder(reg));
    }

    /**
     * Initializes me with an <code>EPackage.Registry</code> that the environments I create will use to look up packages, and with
     * an <code>OppositeEndFinder</code> that the environments I create will use to construct and evaluate
     * <code>OppositePropertyCallExp</code> expressions based on name annotations on the forward references.
     * 
     * @param reg
     *            my package registry (must not be <code>null</code>)
     * @param finder
     *            for opposite ends; may be <code>null</code> which means that no <code>OppositePropertyCallExp</code> expressions
     *            will be synthesized because no lookups can/will be performed for them. To use a default finder, use
     *            {@link #EcoreEnvironmentFactory(org.eclipse.emf.ecore.EPackage.Registry)} or {@link #EcoreEnvironmentFactory()}.
     */
    public MappingOCLEnvironmentFactory(EPackage.Registry reg, OppositeEndFinder oppositeEndFinder) {
        super(reg, oppositeEndFinder);
    }

    @Override
    public EvaluationVisitor<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createEvaluationVisitor(
            Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
            EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> evalEnv,
            Map<? extends EClass, ? extends Set<? extends EObject>> extentMap) {
        return new MappingEvaluationVisitor(env, evalEnv, extentMap);
    }

}
