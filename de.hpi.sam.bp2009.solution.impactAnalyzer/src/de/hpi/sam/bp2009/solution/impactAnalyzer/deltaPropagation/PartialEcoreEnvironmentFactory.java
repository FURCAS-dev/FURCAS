package de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation;

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
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.SendSignalAction;

public class PartialEcoreEnvironmentFactory extends EcoreEnvironmentFactory {
    private Object valueOfSourceExpression;
    private OCLExpression sourceExpression;

    public PartialEcoreEnvironmentFactory() {
    }
    
    // implements the inherited specification
    public EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> createEvaluationEnvironment() {
        return new PartialEcoreEvaluationEnvironment();
    }

    // implements the inherited specification
    public EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> createEvaluationEnvironment(
            EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> parent) {
        return new PartialEcoreEvaluationEnvironment(parent);
    }

    /**
     * Creates a visitor. The {@link #isEvaluationTracingEnabled()} result is ignored here. Unfortunately,
     * the <tt>TracingEvaluationVisitor</tt> class is not visible here.
     */
    public EvaluationVisitor<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createEvaluationVisitor(
            Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
            EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> evalEnv,
            Map<? extends EClass, ? extends Set<? extends EObject>> extentMap) {
        EvaluationVisitor<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> result =
            new PartialEvaluationVisitorImpl(env, evalEnv, extentMap, sourceExpression, valueOfSourceExpression);
        return result;
    }

    public void setExpressionValue(OCLExpression sourceExpression, Object valueOfSourceExpression) {
        this.sourceExpression = sourceExpression;
        this.valueOfSourceExpression = valueOfSourceExpression;
    }
}
