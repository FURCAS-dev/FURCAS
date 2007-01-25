/**
 * <copyright>
 * </copyright>
 *
 * $Id: TupleTypeImpl.java,v 1.1 2007/01/25 18:24:35 cdamus Exp $
 */
package org.eclipse.ocl.types.impl;

import java.util.Iterator;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.types.TupleType;
import org.eclipse.ocl.types.TypesPackage;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;
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
			Environment<?, ?, O, P, ?, ?, ?, ?, ?, ?, ?, ?> env =
				Environment.Registry.INSTANCE.getEnvironmentFor(this);
			
            UMLReflection<?, ?, O, P, ?, ?, ?, ?, ?, ?> uml = env.getUMLReflection();

			StringBuffer myName = new StringBuffer();
			
            myName.append(SINGLETON_NAME).append('(');
            
			for (Iterator<P> iter = oclProperties().iterator(); iter.hasNext();) {
				P next = iter.next();
				
				myName.append(uml.getName(next));
				
				Object type = uml.getOCLType(next);
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
	 * @generated NOT
	 */
	public EList<P> oclProperties() {
		if (properties == null) {
			properties = new BasicEList<P>();
		}
		
		return properties;
	}

} //TupleTypeImpl
