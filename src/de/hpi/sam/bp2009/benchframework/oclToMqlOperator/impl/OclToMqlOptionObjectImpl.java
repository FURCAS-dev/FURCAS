/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.oclToMqlOperator.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.hpi.sam.bp2009.benchframework.OptionObject;
import de.hpi.sam.bp2009.benchframework.impl.OptionObjectImpl;
import de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlOperatorPackage;
import de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlOptionObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ocl To Mql Option Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.oclToMqlOperator.impl.OclToMqlOptionObjectImpl#getConstraints <em>Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OclToMqlOptionObjectImpl extends OptionObjectImpl implements OclToMqlOptionObject {
    /**
     * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getConstraints()
     * @generated
     * @ordered
     */
    protected EList<String> constraints;
    protected static final boolean USE_EVALUATOR_EDEFAULT = false;
    /**
     * The cached value of the '{@link #isUseImpactAnalyzer() <em>Use Impact Analyzer</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isUseImpactAnalyzer()
     * @generated
     * @ordered
     */
    protected boolean useEvaluator = USE_EVALUATOR_EDEFAULT;
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OclToMqlOptionObjectImpl() {
        super();
        setWizardPage(new OcltoMqlOperatorWizardPage("OCLtoMQL Operator", this));
    }
    public static OptionObject defaultValue(){
        OclToMqlOptionObjectImpl oclToMqlOption = new OclToMqlOptionObjectImpl();
        //TODO parse Constraints from meta-model
        //TODO show parsed constraints in GUI
        EList<String> list= new BasicEList<String>();
        //list.add("context Class0: self.attribute0 < 10");
        oclToMqlOption.getConstraints().addAll(list);
        return oclToMqlOption;
}
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return OclToMqlOperatorPackage.Literals.OCL_TO_MQL_OPTION_OBJECT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<String> getConstraints() {
        if (constraints == null) {
            constraints = new EDataTypeUniqueEList<String>(String.class, this, OclToMqlOperatorPackage.OCL_TO_MQL_OPTION_OBJECT__CONSTRAINTS);
        }
        return constraints;
    }
    public boolean isUseEvaluator(){
        return useEvaluator;
    }
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setUseEvaluator(boolean newUseEvaluator) {
        boolean oldUseEvaluator = useEvaluator;
        useEvaluator = newUseEvaluator;
        if (eNotificationRequired())
                eNotify(new ENotificationImpl(this, Notification.SET, OclToMqlOperatorPackage.OCL_TO_MQL_OPTION_OBJECT__USE_EVALUATOR, oldUseEvaluator, useEvaluator));
}
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case OclToMqlOperatorPackage.OCL_TO_MQL_OPTION_OBJECT__CONSTRAINTS:
                return getConstraints();
            case OclToMqlOperatorPackage.OCL_TO_MQL_OPTION_OBJECT__USE_EVALUATOR:
                return isUseEvaluator();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case OclToMqlOperatorPackage.OCL_TO_MQL_OPTION_OBJECT__CONSTRAINTS:
                getConstraints().clear();
                getConstraints().addAll((Collection<? extends String>)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case OclToMqlOperatorPackage.OCL_TO_MQL_OPTION_OBJECT__CONSTRAINTS:
                getConstraints().clear();
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case OclToMqlOperatorPackage.OCL_TO_MQL_OPTION_OBJECT__CONSTRAINTS:
                return constraints != null && !constraints.isEmpty();
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (constraints: ");
        result.append(constraints);
        result.append(", useEvaluator: ");
        result.append(useEvaluator);
        result.append(')');
        return result.toString();
    }
    @Override
    public OclToMqlOptionObject clone() throws CloneNotSupportedException {
            return (OclToMqlOptionObject) EcoreUtil.copy(this);
    }
} //OclToMqlOptionObjectImpl
