/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package data.tuples.impl;

import data.tuples.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TuplesFactoryImpl extends EFactoryImpl implements TuplesFactory {
	/**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static TuplesFactory init() {
        try {
            TuplesFactory theTuplesFactory = (TuplesFactory)EPackage.Registry.INSTANCE.getEFactory("http://eclipse.org/ocl/examples/impactanalyzer/testmodel/ngpm/data/tuples.ecore"); 
            if (theTuplesFactory != null) {
                return theTuplesFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new TuplesFactoryImpl();
    }

	/**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TuplesFactoryImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case TuplesPackage.TUPLE_TYPE_DEFINITION: return createTupleTypeDefinition();
            case TuplesPackage.TUPLE_ELEMENT: return createTupleElement();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TupleTypeDefinition createTupleTypeDefinition() {
        TupleTypeDefinitionImpl tupleTypeDefinition = new TupleTypeDefinitionImpl();
        return tupleTypeDefinition;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TupleElement createTupleElement() {
        TupleElementImpl tupleElement = new TupleElementImpl();
        return tupleElement;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TuplesPackage getTuplesPackage() {
        return (TuplesPackage)getEPackage();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
	@Deprecated
	public static TuplesPackage getPackage() {
        return TuplesPackage.eINSTANCE;
    }

} //TuplesFactoryImpl
