package de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation;

import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
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
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.SendSignalAction;

import com.sap.emf.ocl.hiddenopposites.DefaultOppositeEndFinder;
import com.sap.emf.ocl.hiddenopposites.EcoreEnvironmentFactoryWithHiddenOpposites;
import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;

public class PartialEcoreEnvironmentFactory extends EcoreEnvironmentFactoryWithHiddenOpposites {
    private Object valueOfSourceExpression;
    private OCLExpression sourceExpression;
    
    /**
     * A {@link Notification} object such that an evaluation performed with the {@link EvaluationVisitor} returned by this
     * factory's {@link #createEvaluationVisitor(Environment, EvaluationEnvironment, Map)} operation will be based on the state
     * *before* the notification. For example, if the notification indicates the removal of a reference from an element
     * <tt>e1</tt> to an element <tt>e2</tt> across reference <tt>r</tt> then when during partial evaluation <tt>r</tt> is
     * traversed starting from <tt>e1</tt> then <tt>e2</tt> will show in the results although in the current version of the model
     * it would not.<p>
     * 
     * If <tt>null</tt>, the expression will be evaluated on the model as is.
     */
    private Notification atPre;

    /**
     * Uses a {@link DefaultOppositeEndFinder} for querying hidden opposites
     */
    public PartialEcoreEnvironmentFactory() {
        super();
    }

    public PartialEcoreEnvironmentFactory(OppositeEndFinder oppositeEndFinder) {
        super(oppositeEndFinder);
    }

    /**
     * Taking a {@link Notification} object such that an evaluation performed with the {@link EvaluationVisitor} returned by this
     * factory's {@link #createEvaluationVisitor(Environment, EvaluationEnvironment, Map)} operation will be based on the state
     * <em>before</em> the notification. For example, if the notification indicates the removal of a reference from an element
     * <tt>e1</tt> to an element <tt>e2</tt> across reference <tt>r</tt> then when during partial evaluation <tt>r</tt> is
     * traversed starting from <tt>e1</tt> then <tt>e2</tt> will show in the results although in the current version of the model
     * it would not.<p>
     * 
     * Uses a {@link DefaultOppositeEndFinder} for navigating hidden opposites.
     */
    public PartialEcoreEnvironmentFactory(Notification atPre) {
        this.atPre = atPre;
    }
    
    public PartialEcoreEnvironmentFactory(Notification atPre, OppositeEndFinder oppositeEndFinder) {
        this(oppositeEndFinder);
        this.atPre = atPre;
    }

    // implements the inherited specification
    public EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> createEvaluationEnvironment() {
        return new PartialEcoreEvaluationEnvironment(getOppositeEndFinder());
    }

    // implements the inherited specification
    public EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> createEvaluationEnvironment(
            EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> parent) {
        return new PartialEcoreEvaluationEnvironment(parent);
    }

    /**
     * Creates a visitor. The {@link #isEvaluationTracingEnabled()} result is ignored here. Unfortunately,
     * the <tt>TracingEvaluationVisitor</tt> class is not visible here. The {@link #sourceExpression}
     * and {@link #valueOfSourceExpression} are passed to the {@link PartialEvaluationVisitorImpl}
     * constructor and are nulled out before the constructor is called. As a consequence of this, subsequent
     * requests to this factory to create a visitor will result in visitors that don't treat the
     * source expression special anymore. This prevents incorrect use of the cached value during
     * recursions.
     */
    public EvaluationVisitor<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createEvaluationVisitor(
            Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
            EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> evalEnv,
            Map<? extends EClass, ? extends Set<? extends EObject>> extentMap) {
        OCLExpression localSourceExpression = sourceExpression;
        sourceExpression = null;
        Object localValueOfSourceExpression = valueOfSourceExpression;
        valueOfSourceExpression = null;
        return new PartialEvaluationVisitorImpl(env, evalEnv, extentMap, localSourceExpression, localValueOfSourceExpression, atPre);
    }

    public void setExpressionValue(OCLExpression sourceExpression, Object valueOfSourceExpression) {
        this.sourceExpression = sourceExpression;
        this.valueOfSourceExpression = valueOfSourceExpression;
    }

    protected Object getValueOfSourceExpression() {
        return valueOfSourceExpression;
    }

    protected OCLExpression getSourceExpression() {
        return sourceExpression;
    }

    protected void setSourceExpression(OCLExpression sourceExpression) {
        this.sourceExpression = sourceExpression;
    }

    protected void setValueOfSourceExpression(Object valueOfSourceExpression) {
        this.valueOfSourceExpression = valueOfSourceExpression;
    }

    protected Notification getAtPre() {
        return atPre;
    }
}
