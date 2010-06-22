/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package primitivetypes;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * The PrimitiveTypes Package contains MOF's standard collection of technology-neutral primitive data types. 
 * These types are available for use in all MOF metamodels and are also used by the MOF Model. 
 * Note: Technology mappings shall recognize standard PrimitiveType instance based on their qualified names. 
 * Multiple primitiveType instances with the samename shall be deemed to mean the same thing.
 * <!-- end-model-doc -->
 * @see primitivetypes.PrimitivetypesFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://de.hpi.sam.bp2009.OCL' settingDelegates='http://de.hpi.sam.bp2009.OCL' validationDelegates='http://de.hpi.sam.bp2009.OCL'"
 * @generated
 */
public interface PrimitivetypesPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "primitivetypes";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http:///primitivetypes.ecore";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "primitivetypes";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    PrimitivetypesPackage eINSTANCE = primitivetypes.impl.PrimitivetypesPackageImpl.init();

    /**
     * The meta object id for the '<em>Integer</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see primitivetypes.impl.PrimitivetypesPackageImpl#getInteger()
     * @generated
     */
    int INTEGER = 0;

    /**
     * The meta object id for the '<em>Float</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see primitivetypes.impl.PrimitivetypesPackageImpl#getFloat()
     * @generated
     */
    int FLOAT = 1;

    /**
     * The meta object id for the '<em>Double</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see primitivetypes.impl.PrimitivetypesPackageImpl#getDouble()
     * @generated
     */
    int DOUBLE = 2;

    /**
     * The meta object id for the '<em>String</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.String
     * @see primitivetypes.impl.PrimitivetypesPackageImpl#getString()
     * @generated
     */
    int STRING = 3;

    /**
     * The meta object id for the '<em>Long</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see primitivetypes.impl.PrimitivetypesPackageImpl#getLong()
     * @generated
     */
    int LONG = 4;

    /**
     * The meta object id for the '<em>Boolean</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see primitivetypes.impl.PrimitivetypesPackageImpl#getBoolean()
     * @generated
     */
    int BOOLEAN = 5;


    /**
     * Returns the meta object for data type '<em>Integer</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Integer</em>'.
     * @model instanceClass="int"
     * @generated
     */
    EDataType getInteger();

    /**
     * Returns the meta object for data type '<em>Float</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Float</em>'.
     * @model instanceClass="float"
     * @generated
     */
    EDataType getFloat();

    /**
     * Returns the meta object for data type '<em>Double</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Double</em>'.
     * @model instanceClass="double"
     * @generated
     */
    EDataType getDouble();

    /**
     * Returns the meta object for data type '{@link java.lang.String <em>String</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>String</em>'.
     * @see java.lang.String
     * @model instanceClass="java.lang.String"
     * @generated
     */
    EDataType getString();

    /**
     * Returns the meta object for data type '<em>Long</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Long</em>'.
     * @model instanceClass="long"
     * @generated
     */
    EDataType getLong();

    /**
     * Returns the meta object for data type '<em>Boolean</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Boolean</em>'.
     * @model instanceClass="boolean"
     * @generated
     */
    EDataType getBoolean();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    PrimitivetypesFactory getPrimitivetypesFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '<em>Integer</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see primitivetypes.impl.PrimitivetypesPackageImpl#getInteger()
         * @generated
         */
        EDataType INTEGER = eINSTANCE.getInteger();

        /**
         * The meta object literal for the '<em>Float</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see primitivetypes.impl.PrimitivetypesPackageImpl#getFloat()
         * @generated
         */
        EDataType FLOAT = eINSTANCE.getFloat();

        /**
         * The meta object literal for the '<em>Double</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see primitivetypes.impl.PrimitivetypesPackageImpl#getDouble()
         * @generated
         */
        EDataType DOUBLE = eINSTANCE.getDouble();

        /**
         * The meta object literal for the '<em>String</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see java.lang.String
         * @see primitivetypes.impl.PrimitivetypesPackageImpl#getString()
         * @generated
         */
        EDataType STRING = eINSTANCE.getString();

        /**
         * The meta object literal for the '<em>Long</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see primitivetypes.impl.PrimitivetypesPackageImpl#getLong()
         * @generated
         */
        EDataType LONG = eINSTANCE.getLong();

        /**
         * The meta object literal for the '<em>Boolean</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see primitivetypes.impl.PrimitivetypesPackageImpl#getBoolean()
         * @generated
         */
        EDataType BOOLEAN = eINSTANCE.getBoolean();

    }

} //PrimitivetypesPackage
