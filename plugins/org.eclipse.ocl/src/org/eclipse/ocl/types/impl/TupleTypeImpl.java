/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2008 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   IBM - Initial API and implementation
 * 
 * </copyright>
 *
 * $Id: TupleTypeImpl.java,v 1.6 2008/03/28 20:33:33 cdamus Exp $
 */
package org.eclipse.ocl.types.impl;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import java.util.Iterator;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.types.TupleType;
import org.eclipse.ocl.types.TypesPackage;
import org.eclipse.ocl.types.operations.TupleTypeOperations;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.UMLReflection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tuple Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class TupleTypeImpl<O, P> extends EObjectImpl implements TupleType<O, P> {
	private String name;
	
	private EList<O> operations;
	private EList<P> properties;
	
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
        return TypesPackage.Literals.TUPLE_TYPE;
    }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getName() {
		if (name == null) {
			Environment<?, Object, O, P, ?, ?, ?, ?, ?, ?, ?, ?> env =
				Environment.Registry.INSTANCE.getEnvironmentFor(this);
			
            UMLReflection<?, Object, O, P, ?, ?, ?, ?, ?, ?> uml = env.getUMLReflection();

			StringBuffer myName = new StringBuffer();
			
            myName.append(SINGLETON_NAME).append('(');
            
			for (Iterator<P> iter = oclProperties().iterator(); iter.hasNext();) {
				P next = iter.next();
				
				myName.append(uml.getName(next));
				
				Object type = TypeUtil.resolveType(env, uml.getOCLType(next));
				if (type != null) {
					myName.append(" : "); //$NON-NLS-1$
					myName.append(uml.getName(type));
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<O> oclOperations() {
		if (operations == null) {
			Environment<?, ?, O, ?, ?, ?, ?, ?, ?, ?, ?, ?> env =
				Environment.Registry.INSTANCE.getEnvironmentFor(this);
			
			operations = new BasicEList<O>(
					OCLStandardLibraryUtil.createAnyTypeOperations(env));
		}
		
		return operations;
	}

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean checkTupleTypeName(DiagnosticChain diagnostics, Map<Object, Object> context) {
        return TupleTypeOperations.checkTupleTypeName(this, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean checkPartNamesUnique(DiagnosticChain diagnostics, Map<Object, Object> context) {
        return TupleTypeOperations.checkPartNamesUnique(this, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean checkFeaturesOnlyProperties(DiagnosticChain diagnostics, Map<Object, Object> context) {
        return TupleTypeOperations.checkFeaturesOnlyProperties(this, diagnostics, context);
    }

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<P> oclProperties() {
		if (properties == null) {
			properties = new BasicEList<P>();
		}
		
		return properties;
	}

} //TupleTypeImpl
