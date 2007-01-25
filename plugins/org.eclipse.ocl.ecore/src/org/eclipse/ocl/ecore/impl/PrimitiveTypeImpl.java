/**
 * <copyright>
 * </copyright>
 *
 * $Id: PrimitiveTypeImpl.java,v 1.1 2007/01/25 18:29:09 cdamus Exp $
 */
package org.eclipse.ocl.ecore.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.impl.EDataTypeImpl;
import org.eclipse.ocl.ecore.EcorePackage;
import org.eclipse.ocl.ecore.PrimitiveType;
import org.eclipse.ocl.ecore.internal.OCLStandardLibraryImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primitive Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class PrimitiveTypeImpl extends EDataTypeImpl implements PrimitiveType {
    protected EList<EOperation> operations;
    
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PrimitiveTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return EcorePackage.Literals.PRIMITIVE_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public EList<EOperation> oclOperations() {
        if (operations == null) {
            PrimitiveType prototype;
            String myName = getName();
            
            if (BOOLEAN_NAME.equals(myName)) {
                prototype = (PrimitiveType) OCLStandardLibraryImpl.INSTANCE.getBoolean();
            } else if (STRING_NAME.equals(myName)) {
                prototype = (PrimitiveType) OCLStandardLibraryImpl.INSTANCE.getString();
            } else if (INTEGER_NAME.equals(myName)) {
                prototype = (PrimitiveType) OCLStandardLibraryImpl.INSTANCE.getInteger();
            } else if (REAL_NAME.equals(myName)) {
                prototype = (PrimitiveType) OCLStandardLibraryImpl.INSTANCE.getReal();
            } else {
                prototype = (PrimitiveType) OCLStandardLibraryImpl.INSTANCE.getUnlimitedNatural();
            }
            
            if (prototype == this) {
                // I *am* the standard library type!
                operations = OCLStandardLibraryImpl.getExistingOperations(this);
            } else {
                // the prototype defines my operations for me
                operations = prototype.oclOperations();
            }
        }
        
        return operations;
    }

} //PrimitiveTypeImpl
