/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package primitivetypes;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see primitivetypes.PrimitivetypesPackage
 * @generated
 */
public interface PrimitivetypesFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    PrimitivetypesFactory eINSTANCE = primitivetypes.impl.PrimitivetypesFactoryImpl.init();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    PrimitivetypesPackage getPrimitivetypesPackage();

} //PrimitivetypesFactory
