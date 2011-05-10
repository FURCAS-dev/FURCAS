/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.oclinversion.impl;

import com.sap.furcas.oclinversion.OclinversionPackage;
import com.sap.furcas.oclinversion.QMarkLiteralExp;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.eclipse.ocl.ecore.impl.BooleanLiteralExpImpl;

import org.eclipse.ocl.expressions.EnumLiteralExp;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.expressions.IntegerLiteralExp;
import org.eclipse.ocl.expressions.NumericLiteralExp;
import org.eclipse.ocl.expressions.RealLiteralExp;
import org.eclipse.ocl.expressions.StringLiteralExp;

import org.eclipse.ocl.expressions.util.ExpressionsValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>QMark Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.oclinversion.impl.QMarkLiteralExpImpl#getReferredEnumLiteral <em>Referred Enum Literal</em>}</li>
 *   <li>{@link com.sap.furcas.oclinversion.impl.QMarkLiteralExpImpl#getIntegerSymbol <em>Integer Symbol</em>}</li>
 *   <li>{@link com.sap.furcas.oclinversion.impl.QMarkLiteralExpImpl#getRealSymbol <em>Real Symbol</em>}</li>
 *   <li>{@link com.sap.furcas.oclinversion.impl.QMarkLiteralExpImpl#getStringSymbol <em>String Symbol</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QMarkLiteralExpImpl extends BooleanLiteralExpImpl implements QMarkLiteralExp {
    /**
     * The cached value of the '{@link #getReferredEnumLiteral() <em>Referred Enum Literal</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getReferredEnumLiteral()
     * @generated
     * @ordered
     */
    protected EEnumLiteral referredEnumLiteral;

    /**
     * The default value of the '{@link #getIntegerSymbol() <em>Integer Symbol</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getIntegerSymbol()
     * @generated
     * @ordered
     */
    protected static final Integer INTEGER_SYMBOL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getIntegerSymbol() <em>Integer Symbol</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getIntegerSymbol()
     * @generated
     * @ordered
     */
    protected Integer integerSymbol = INTEGER_SYMBOL_EDEFAULT;

    /**
     * The default value of the '{@link #getRealSymbol() <em>Real Symbol</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRealSymbol()
     * @generated
     * @ordered
     */
    protected static final Double REAL_SYMBOL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getRealSymbol() <em>Real Symbol</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRealSymbol()
     * @generated
     * @ordered
     */
    protected Double realSymbol = REAL_SYMBOL_EDEFAULT;

    /**
     * The default value of the '{@link #getStringSymbol() <em>String Symbol</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStringSymbol()
     * @generated
     * @ordered
     */
    protected static final String STRING_SYMBOL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getStringSymbol() <em>String Symbol</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStringSymbol()
     * @generated
     * @ordered
     */
    protected String stringSymbol = STRING_SYMBOL_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected QMarkLiteralExpImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return OclinversionPackage.Literals.QMARK_LITERAL_EXP;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnumLiteral getReferredEnumLiteral() {
        if (referredEnumLiteral != null && ((EObject)referredEnumLiteral).eIsProxy()) {
            InternalEObject oldReferredEnumLiteral = (InternalEObject)referredEnumLiteral;
            referredEnumLiteral = (EEnumLiteral)eResolveProxy(oldReferredEnumLiteral);
            if (referredEnumLiteral != oldReferredEnumLiteral) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, OclinversionPackage.QMARK_LITERAL_EXP__REFERRED_ENUM_LITERAL, oldReferredEnumLiteral, referredEnumLiteral));
            }
        }
        return referredEnumLiteral;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnumLiteral basicGetReferredEnumLiteral() {
        return referredEnumLiteral;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setReferredEnumLiteral(EEnumLiteral newReferredEnumLiteral) {
        EEnumLiteral oldReferredEnumLiteral = referredEnumLiteral;
        referredEnumLiteral = newReferredEnumLiteral;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OclinversionPackage.QMARK_LITERAL_EXP__REFERRED_ENUM_LITERAL, oldReferredEnumLiteral, referredEnumLiteral));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Integer getIntegerSymbol() {
        return integerSymbol;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setIntegerSymbol(Integer newIntegerSymbol) {
        Integer oldIntegerSymbol = integerSymbol;
        integerSymbol = newIntegerSymbol;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OclinversionPackage.QMARK_LITERAL_EXP__INTEGER_SYMBOL, oldIntegerSymbol, integerSymbol));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Double getRealSymbol() {
        return realSymbol;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRealSymbol(Double newRealSymbol) {
        Double oldRealSymbol = realSymbol;
        realSymbol = newRealSymbol;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OclinversionPackage.QMARK_LITERAL_EXP__REAL_SYMBOL, oldRealSymbol, realSymbol));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getStringSymbol() {
        return stringSymbol;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setStringSymbol(String newStringSymbol) {
        String oldStringSymbol = stringSymbol;
        stringSymbol = newStringSymbol;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OclinversionPackage.QMARK_LITERAL_EXP__STRING_SYMBOL, oldStringSymbol, stringSymbol));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean checkStringType(DiagnosticChain diagnostics, Map<Object, Object> context) {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         ExpressionsValidator.DIAGNOSTIC_SOURCE,
                         ExpressionsValidator.STRING_LITERAL_EXP__STRING_TYPE,
                         EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "checkStringType", EObjectValidator.getObjectLabel(this, context) }),
                         new Object [] { this }));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean checkRealType(DiagnosticChain diagnostics, Map<Object, Object> context) {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         ExpressionsValidator.DIAGNOSTIC_SOURCE,
                         ExpressionsValidator.REAL_LITERAL_EXP__REAL_TYPE,
                         EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "checkRealType", EObjectValidator.getObjectLabel(this, context) }),
                         new Object [] { this }));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean checkIntegerType(DiagnosticChain diagnostics, Map<Object, Object> context) {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         ExpressionsValidator.DIAGNOSTIC_SOURCE,
                         ExpressionsValidator.INTEGER_LITERAL_EXP__INTEGER_TYPE,
                         EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "checkIntegerType", EObjectValidator.getObjectLabel(this, context) }),
                         new Object [] { this }));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean checkEnumType(DiagnosticChain diagnostics, Map<Object, Object> context) {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         ExpressionsValidator.DIAGNOSTIC_SOURCE,
                         ExpressionsValidator.ENUM_LITERAL_EXP__ENUM_TYPE,
                         EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "checkEnumType", EObjectValidator.getObjectLabel(this, context) }),
                         new Object [] { this }));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case OclinversionPackage.QMARK_LITERAL_EXP__REFERRED_ENUM_LITERAL:
                if (resolve) return getReferredEnumLiteral();
                return basicGetReferredEnumLiteral();
            case OclinversionPackage.QMARK_LITERAL_EXP__INTEGER_SYMBOL:
                return getIntegerSymbol();
            case OclinversionPackage.QMARK_LITERAL_EXP__REAL_SYMBOL:
                return getRealSymbol();
            case OclinversionPackage.QMARK_LITERAL_EXP__STRING_SYMBOL:
                return getStringSymbol();
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
            case OclinversionPackage.QMARK_LITERAL_EXP__REFERRED_ENUM_LITERAL:
                setReferredEnumLiteral((EEnumLiteral)newValue);
                return;
            case OclinversionPackage.QMARK_LITERAL_EXP__INTEGER_SYMBOL:
                setIntegerSymbol((Integer)newValue);
                return;
            case OclinversionPackage.QMARK_LITERAL_EXP__REAL_SYMBOL:
                setRealSymbol((Double)newValue);
                return;
            case OclinversionPackage.QMARK_LITERAL_EXP__STRING_SYMBOL:
                setStringSymbol((String)newValue);
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
            case OclinversionPackage.QMARK_LITERAL_EXP__REFERRED_ENUM_LITERAL:
                setReferredEnumLiteral((EEnumLiteral)null);
                return;
            case OclinversionPackage.QMARK_LITERAL_EXP__INTEGER_SYMBOL:
                setIntegerSymbol(INTEGER_SYMBOL_EDEFAULT);
                return;
            case OclinversionPackage.QMARK_LITERAL_EXP__REAL_SYMBOL:
                setRealSymbol(REAL_SYMBOL_EDEFAULT);
                return;
            case OclinversionPackage.QMARK_LITERAL_EXP__STRING_SYMBOL:
                setStringSymbol(STRING_SYMBOL_EDEFAULT);
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
            case OclinversionPackage.QMARK_LITERAL_EXP__REFERRED_ENUM_LITERAL:
                return referredEnumLiteral != null;
            case OclinversionPackage.QMARK_LITERAL_EXP__INTEGER_SYMBOL:
                return INTEGER_SYMBOL_EDEFAULT == null ? integerSymbol != null : !INTEGER_SYMBOL_EDEFAULT.equals(integerSymbol);
            case OclinversionPackage.QMARK_LITERAL_EXP__REAL_SYMBOL:
                return REAL_SYMBOL_EDEFAULT == null ? realSymbol != null : !REAL_SYMBOL_EDEFAULT.equals(realSymbol);
            case OclinversionPackage.QMARK_LITERAL_EXP__STRING_SYMBOL:
                return STRING_SYMBOL_EDEFAULT == null ? stringSymbol != null : !STRING_SYMBOL_EDEFAULT.equals(stringSymbol);
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
        if (baseClass == EnumLiteralExp.class) {
            switch (derivedFeatureID) {
                case OclinversionPackage.QMARK_LITERAL_EXP__REFERRED_ENUM_LITERAL: return ExpressionsPackage.ENUM_LITERAL_EXP__REFERRED_ENUM_LITERAL;
                default: return -1;
            }
        }
        if (baseClass == org.eclipse.ocl.ecore.EnumLiteralExp.class) {
            switch (derivedFeatureID) {
                default: return -1;
            }
        }
        if (baseClass == NumericLiteralExp.class) {
            switch (derivedFeatureID) {
                default: return -1;
            }
        }
        if (baseClass == org.eclipse.ocl.ecore.NumericLiteralExp.class) {
            switch (derivedFeatureID) {
                default: return -1;
            }
        }
        if (baseClass == IntegerLiteralExp.class) {
            switch (derivedFeatureID) {
                case OclinversionPackage.QMARK_LITERAL_EXP__INTEGER_SYMBOL: return ExpressionsPackage.INTEGER_LITERAL_EXP__INTEGER_SYMBOL;
                default: return -1;
            }
        }
        if (baseClass == org.eclipse.ocl.ecore.IntegerLiteralExp.class) {
            switch (derivedFeatureID) {
                default: return -1;
            }
        }
        if (baseClass == RealLiteralExp.class) {
            switch (derivedFeatureID) {
                case OclinversionPackage.QMARK_LITERAL_EXP__REAL_SYMBOL: return ExpressionsPackage.REAL_LITERAL_EXP__REAL_SYMBOL;
                default: return -1;
            }
        }
        if (baseClass == org.eclipse.ocl.ecore.RealLiteralExp.class) {
            switch (derivedFeatureID) {
                default: return -1;
            }
        }
        if (baseClass == StringLiteralExp.class) {
            switch (derivedFeatureID) {
                case OclinversionPackage.QMARK_LITERAL_EXP__STRING_SYMBOL: return ExpressionsPackage.STRING_LITERAL_EXP__STRING_SYMBOL;
                default: return -1;
            }
        }
        if (baseClass == org.eclipse.ocl.ecore.StringLiteralExp.class) {
            switch (derivedFeatureID) {
                default: return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
        if (baseClass == EnumLiteralExp.class) {
            switch (baseFeatureID) {
                case ExpressionsPackage.ENUM_LITERAL_EXP__REFERRED_ENUM_LITERAL: return OclinversionPackage.QMARK_LITERAL_EXP__REFERRED_ENUM_LITERAL;
                default: return -1;
            }
        }
        if (baseClass == org.eclipse.ocl.ecore.EnumLiteralExp.class) {
            switch (baseFeatureID) {
                default: return -1;
            }
        }
        if (baseClass == NumericLiteralExp.class) {
            switch (baseFeatureID) {
                default: return -1;
            }
        }
        if (baseClass == org.eclipse.ocl.ecore.NumericLiteralExp.class) {
            switch (baseFeatureID) {
                default: return -1;
            }
        }
        if (baseClass == IntegerLiteralExp.class) {
            switch (baseFeatureID) {
                case ExpressionsPackage.INTEGER_LITERAL_EXP__INTEGER_SYMBOL: return OclinversionPackage.QMARK_LITERAL_EXP__INTEGER_SYMBOL;
                default: return -1;
            }
        }
        if (baseClass == org.eclipse.ocl.ecore.IntegerLiteralExp.class) {
            switch (baseFeatureID) {
                default: return -1;
            }
        }
        if (baseClass == RealLiteralExp.class) {
            switch (baseFeatureID) {
                case ExpressionsPackage.REAL_LITERAL_EXP__REAL_SYMBOL: return OclinversionPackage.QMARK_LITERAL_EXP__REAL_SYMBOL;
                default: return -1;
            }
        }
        if (baseClass == org.eclipse.ocl.ecore.RealLiteralExp.class) {
            switch (baseFeatureID) {
                default: return -1;
            }
        }
        if (baseClass == StringLiteralExp.class) {
            switch (baseFeatureID) {
                case ExpressionsPackage.STRING_LITERAL_EXP__STRING_SYMBOL: return OclinversionPackage.QMARK_LITERAL_EXP__STRING_SYMBOL;
                default: return -1;
            }
        }
        if (baseClass == org.eclipse.ocl.ecore.StringLiteralExp.class) {
            switch (baseFeatureID) {
                default: return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
        result.append(" (integerSymbol: ");
        result.append(integerSymbol);
        result.append(", realSymbol: ");
        result.append(realSymbol);
        result.append(", stringSymbol: ");
        result.append(stringSymbol);
        result.append(')');
        return result.toString();
    }

} //QMarkLiteralExpImpl
