/**
 * <copyright>
 * </copyright>
 *
 * $Id: TupleTypeImpl.java,v 1.1 2007/01/25 18:29:08 cdamus Exp $
 */
package org.eclipse.ocl.ecore.impl;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.DelegatingEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.ecore.impl.EClassImpl;

import org.eclipse.ocl.ecore.EcorePackage;
import org.eclipse.ocl.ecore.TupleType;
import org.eclipse.ocl.ecore.internal.OCLStandardLibraryImpl;
import org.eclipse.ocl.ecore.AnyType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tuple Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class TupleTypeImpl extends EClassImpl implements TupleType {
    private EList<EOperation> operations;
    private EList<EStructuralFeature> properties;
    
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TupleTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return EcorePackage.Literals.TUPLE_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public EList<EStructuralFeature> oclProperties() {
        if (properties == null) {
            properties = new DelegatingEList<EStructuralFeature>() {
                private static final long serialVersionUID = -4098965170992199523L;

                @Override
                protected List<EStructuralFeature> delegateList() {
                    return getEStructuralFeatures();
                }};
        }
        return properties;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public EList<EOperation> oclOperations() {
        if (operations == null) {
            operations = ((AnyType) OCLStandardLibraryImpl.INSTANCE.getOclAny())
                .oclOperations();
        }
        
        return operations;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public String getName() {
        if (name == null) {
            StringBuffer myName = new StringBuffer();
            myName.append(SINGLETON_NAME).append('(');
            
            for (Iterator<EStructuralFeature> iter = oclProperties().iterator(); iter.hasNext();) {
                EStructuralFeature next = iter.next();
                
                myName.append(next.getName());
                
                EClassifier type = next.getEType();
                if (type != null) {
                    myName.append(" : "); //$NON-NLS-1$
                    myName.append(type.getName());
                }
                
                if (iter.hasNext()) {
                    myName.append(", "); //$NON-NLS-1$
                }
            }
            
            myName.append(')');
            name = myName.toString();
        }
        
        return name;
    }

} //TupleTypeImpl
