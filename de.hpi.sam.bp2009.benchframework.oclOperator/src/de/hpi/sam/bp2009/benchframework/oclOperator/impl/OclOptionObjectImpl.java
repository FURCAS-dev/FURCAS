/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.oclOperator.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.hpi.sam.bp2009.benchframework.OptionObject;
import de.hpi.sam.bp2009.benchframework.impl.OptionObjectImpl;
import de.hpi.sam.bp2009.benchframework.oclOperator.OclOperatorPackage;
import de.hpi.sam.bp2009.benchframework.oclOperator.OclOptionObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ocl Option Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.oclOperator.impl.OclOptionObjectImpl#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.benchframework.oclOperator.impl.OclOptionObjectImpl#isUseImpactAnalyzer <em>Use Impact Analyzer</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OclOptionObjectImpl extends OptionObjectImpl implements OclOptionObject {
	/**
	 * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<String> constraints;
	/**
	 * The default value of the '{@link #isUseImpactAnalyzer() <em>Use Impact Analyzer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUseImpactAnalyzer()
	 * @generated
	 * @ordered
	 */
	protected static final boolean USE_IMPACT_ANALYZER_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isUseImpactAnalyzer() <em>Use Impact Analyzer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUseImpactAnalyzer()
	 * @generated
	 * @ordered
	 */
	protected boolean useImpactAnalyzer = USE_IMPACT_ANALYZER_EDEFAULT;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 */
	public OclOptionObjectImpl() {
		super();
		setWizardPage(new OclOperatorWizardPage("OCL Operator", this));
		
	}

	public static OptionObject defaultValue(){
		OclOptionObjectImpl def = new OclOptionObjectImpl();
		//TODO weiterreichen der Eingabe der Constraints an die Gui
		EList<String> list= new BasicEList<String>();
		list.add("context Class0: self.attribute0 < 10");
		def.setConstraints(list);
		return def;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OclOperatorPackage.Literals.OCL_OPTION_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getConstraints() {
		return constraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstraints(EList<String> newConstraints) {
		EList<String> oldConstraints = constraints;
		constraints = newConstraints;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OclOperatorPackage.OCL_OPTION_OBJECT__CONSTRAINTS, oldConstraints, constraints));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUseImpactAnalyzer() {
		return useImpactAnalyzer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUseImpactAnalyzer(boolean newUseImpactAnalyzer) {
		boolean oldUseImpactAnalyzer = useImpactAnalyzer;
		useImpactAnalyzer = newUseImpactAnalyzer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OclOperatorPackage.OCL_OPTION_OBJECT__USE_IMPACT_ANALYZER, oldUseImpactAnalyzer, useImpactAnalyzer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OclOperatorPackage.OCL_OPTION_OBJECT__CONSTRAINTS:
				return getConstraints();
			case OclOperatorPackage.OCL_OPTION_OBJECT__USE_IMPACT_ANALYZER:
				return isUseImpactAnalyzer();
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
			case OclOperatorPackage.OCL_OPTION_OBJECT__CONSTRAINTS:
				setConstraints((EList<String>)newValue);
				return;
			case OclOperatorPackage.OCL_OPTION_OBJECT__USE_IMPACT_ANALYZER:
				setUseImpactAnalyzer((Boolean)newValue);
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
			case OclOperatorPackage.OCL_OPTION_OBJECT__CONSTRAINTS:
				setConstraints((EList<String>)null);
				return;
			case OclOperatorPackage.OCL_OPTION_OBJECT__USE_IMPACT_ANALYZER:
				setUseImpactAnalyzer(USE_IMPACT_ANALYZER_EDEFAULT);
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
			case OclOperatorPackage.OCL_OPTION_OBJECT__CONSTRAINTS:
				return constraints != null;
			case OclOperatorPackage.OCL_OPTION_OBJECT__USE_IMPACT_ANALYZER:
				return useImpactAnalyzer != USE_IMPACT_ANALYZER_EDEFAULT;
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
		result.append(", useImpactAnalyzer: ");
		result.append(useImpactAnalyzer);
		result.append(')');
		return result.toString();
	}

	@Override
	public OclOptionObject clone() throws CloneNotSupportedException {
		return (OclOptionObject) EcoreUtil.copy(this);
	}
} //OclOptionObjectImpl
