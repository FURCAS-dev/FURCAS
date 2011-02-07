/**
 * <copyright>
 * </copyright>
 *
 * $Id: MultiplicityImpl.java,v 1.1 2011/02/07 17:16:10 auhl Exp $
 */
package data.classes.impl;

import data.classes.ClassesPackage;
import data.classes.Multiplicity;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multiplicity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link data.classes.impl.MultiplicityImpl#getLowerMultiplicity <em>Lower Multiplicity</em>}</li>
 *   <li>{@link data.classes.impl.MultiplicityImpl#getUpperMultiplicity <em>Upper Multiplicity</em>}</li>
 *   <li>{@link data.classes.impl.MultiplicityImpl#isOrdered <em>Ordered</em>}</li>
 *   <li>{@link data.classes.impl.MultiplicityImpl#isUnique <em>Unique</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class MultiplicityImpl extends EObjectImpl implements Multiplicity {
	/**
     * The default value of the '{@link #getLowerMultiplicity() <em>Lower Multiplicity</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getLowerMultiplicity()
     * @generated
     * @ordered
     */
	protected static final int LOWER_MULTIPLICITY_EDEFAULT = 0;

	/**
     * The cached value of the '{@link #getLowerMultiplicity() <em>Lower Multiplicity</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getLowerMultiplicity()
     * @generated
     * @ordered
     */
	protected int lowerMultiplicity = LOWER_MULTIPLICITY_EDEFAULT;

	/**
     * The default value of the '{@link #getUpperMultiplicity() <em>Upper Multiplicity</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getUpperMultiplicity()
     * @generated
     * @ordered
     */
	protected static final int UPPER_MULTIPLICITY_EDEFAULT = 0;

	/**
     * The cached value of the '{@link #getUpperMultiplicity() <em>Upper Multiplicity</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getUpperMultiplicity()
     * @generated
     * @ordered
     */
	protected int upperMultiplicity = UPPER_MULTIPLICITY_EDEFAULT;

	/**
     * The default value of the '{@link #isOrdered() <em>Ordered</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isOrdered()
     * @generated
     * @ordered
     */
	protected static final boolean ORDERED_EDEFAULT = false;

	/**
     * The cached value of the '{@link #isOrdered() <em>Ordered</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isOrdered()
     * @generated
     * @ordered
     */
	protected boolean ordered = ORDERED_EDEFAULT;

	/**
     * The default value of the '{@link #isUnique() <em>Unique</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isUnique()
     * @generated
     * @ordered
     */
	protected static final boolean UNIQUE_EDEFAULT = false;

	/**
     * The cached value of the '{@link #isUnique() <em>Unique</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isUnique()
     * @generated
     * @ordered
     */
	protected boolean unique = UNIQUE_EDEFAULT;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected MultiplicityImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ClassesPackage.Literals.MULTIPLICITY;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public int getLowerMultiplicity() {
        return lowerMultiplicity;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setLowerMultiplicity(int newLowerMultiplicity) {
        int oldLowerMultiplicity = lowerMultiplicity;
        lowerMultiplicity = newLowerMultiplicity;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.MULTIPLICITY__LOWER_MULTIPLICITY, oldLowerMultiplicity, lowerMultiplicity));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public int getUpperMultiplicity() {
        return upperMultiplicity;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setUpperMultiplicity(int newUpperMultiplicity) {
        int oldUpperMultiplicity = upperMultiplicity;
        upperMultiplicity = newUpperMultiplicity;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.MULTIPLICITY__UPPER_MULTIPLICITY, oldUpperMultiplicity, upperMultiplicity));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isOrdered() {
        return ordered;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setOrdered(boolean newOrdered) {
        boolean oldOrdered = ordered;
        ordered = newOrdered;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.MULTIPLICITY__ORDERED, oldOrdered, ordered));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isUnique() {
        return unique;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setUnique(boolean newUnique) {
        boolean oldUnique = unique;
        unique = newUnique;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.MULTIPLICITY__UNIQUE, oldUnique, unique));
    }

	/**
     * The cached invocation delegate for the '{@link #isMany() <em>Is Many</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isMany()
     * @generated
     * @ordered
     */
	protected static final EOperation.Internal.InvocationDelegate IS_MANY__EINVOCATION_DELEGATE = ((EOperation.Internal)ClassesPackage.Literals.MULTIPLICITY.getEOperations().get(0)).getInvocationDelegate();

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isMany() {
        try {
            return (Boolean)IS_MANY__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
        }
        catch (InvocationTargetException ite) {
            throw new WrappedException(ite);
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ClassesPackage.MULTIPLICITY__LOWER_MULTIPLICITY:
                return getLowerMultiplicity();
            case ClassesPackage.MULTIPLICITY__UPPER_MULTIPLICITY:
                return getUpperMultiplicity();
            case ClassesPackage.MULTIPLICITY__ORDERED:
                return isOrdered();
            case ClassesPackage.MULTIPLICITY__UNIQUE:
                return isUnique();
        }
        return super.eGet(featureID, resolve, coreType);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case ClassesPackage.MULTIPLICITY__LOWER_MULTIPLICITY:
                setLowerMultiplicity((Integer)newValue);
                return;
            case ClassesPackage.MULTIPLICITY__UPPER_MULTIPLICITY:
                setUpperMultiplicity((Integer)newValue);
                return;
            case ClassesPackage.MULTIPLICITY__ORDERED:
                setOrdered((Boolean)newValue);
                return;
            case ClassesPackage.MULTIPLICITY__UNIQUE:
                setUnique((Boolean)newValue);
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
            case ClassesPackage.MULTIPLICITY__LOWER_MULTIPLICITY:
                setLowerMultiplicity(LOWER_MULTIPLICITY_EDEFAULT);
                return;
            case ClassesPackage.MULTIPLICITY__UPPER_MULTIPLICITY:
                setUpperMultiplicity(UPPER_MULTIPLICITY_EDEFAULT);
                return;
            case ClassesPackage.MULTIPLICITY__ORDERED:
                setOrdered(ORDERED_EDEFAULT);
                return;
            case ClassesPackage.MULTIPLICITY__UNIQUE:
                setUnique(UNIQUE_EDEFAULT);
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
            case ClassesPackage.MULTIPLICITY__LOWER_MULTIPLICITY:
                return lowerMultiplicity != LOWER_MULTIPLICITY_EDEFAULT;
            case ClassesPackage.MULTIPLICITY__UPPER_MULTIPLICITY:
                return upperMultiplicity != UPPER_MULTIPLICITY_EDEFAULT;
            case ClassesPackage.MULTIPLICITY__ORDERED:
                return ordered != ORDERED_EDEFAULT;
            case ClassesPackage.MULTIPLICITY__UNIQUE:
                return unique != UNIQUE_EDEFAULT;
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
        result.append(" (lowerMultiplicity: ");
        result.append(lowerMultiplicity);
        result.append(", upperMultiplicity: ");
        result.append(upperMultiplicity);
        result.append(", ordered: ");
        result.append(ordered);
        result.append(", unique: ");
        result.append(unique);
        result.append(')');
        return result.toString();
    }

} //MultiplicityImpl
