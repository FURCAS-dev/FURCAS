/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package runtime.primitivetypes;

import java.lang.String;

import org.eclipse.emf.ecore.EClass;
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
 * @see runtime.primitivetypes.PrimitivetypesFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://de.hpi.sam.bp2009.OCL' validationDelegates='http://de.hpi.sam.bp2009.OCL'"
 * @generated
 */
public interface PrimitivetypesPackage extends EPackage
{
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
  String eNS_URI = "http:///runtime/primitivetypes.ecore";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "runtime.primitivetypes";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  PrimitivetypesPackage eINSTANCE = runtime.primitivetypes.impl.PrimitivetypesPackageImpl.init();

  /**
   * The meta object id for the '{@link runtime.primitivetypes.impl.BinaryImpl <em>Binary</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see runtime.primitivetypes.impl.BinaryImpl
   * @see runtime.primitivetypes.impl.PrimitivetypesPackageImpl#getBinary()
   * @generated
   */
  int BINARY = 0;

  /**
   * The number of structural features of the '<em>Binary</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link runtime.primitivetypes.impl.BooleanImpl <em>Boolean</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see runtime.primitivetypes.impl.BooleanImpl
   * @see runtime.primitivetypes.impl.PrimitivetypesPackageImpl#getBoolean()
   * @generated
   */
  int BOOLEAN = 1;

  /**
   * The number of structural features of the '<em>Boolean</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link runtime.primitivetypes.impl.DateTimeImpl <em>Date Time</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see runtime.primitivetypes.impl.DateTimeImpl
   * @see runtime.primitivetypes.impl.PrimitivetypesPackageImpl#getDateTime()
   * @generated
   */
  int DATE_TIME = 2;

  /**
   * The number of structural features of the '<em>Date Time</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATE_TIME_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link runtime.primitivetypes.impl.NumberImpl <em>Number</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see runtime.primitivetypes.impl.NumberImpl
   * @see runtime.primitivetypes.impl.PrimitivetypesPackageImpl#getNumber()
   * @generated
   */
  int NUMBER = 3;

  /**
   * The number of structural features of the '<em>Number</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMBER_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link runtime.primitivetypes.impl.StringImpl <em>String</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see runtime.primitivetypes.impl.StringImpl
   * @see runtime.primitivetypes.impl.PrimitivetypesPackageImpl#getString()
   * @generated
   */
  int STRING = 4;

  /**
   * The number of structural features of the '<em>String</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_FEATURE_COUNT = 0;


  /**
   * Returns the meta object for class '{@link runtime.primitivetypes.Binary <em>Binary</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Binary</em>'.
   * @see runtime.primitivetypes.Binary
   * @generated
   */
  EClass getBinary();

  /**
   * Returns the meta object for class '{@link runtime.primitivetypes.Boolean <em>Boolean</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Boolean</em>'.
   * @see runtime.primitivetypes.Boolean
   * @generated
   */
  EClass getBoolean();

  /**
   * Returns the meta object for class '{@link runtime.primitivetypes.DateTime <em>Date Time</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Date Time</em>'.
   * @see runtime.primitivetypes.DateTime
   * @generated
   */
  EClass getDateTime();

  /**
   * Returns the meta object for class '{@link runtime.primitivetypes.Number <em>Number</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Number</em>'.
   * @see runtime.primitivetypes.Number
   * @generated
   */
  EClass getNumber();

  /**
   * Returns the meta object for class '{@link runtime.primitivetypes.String <em>String</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String</em>'.
   * @see runtime.primitivetypes.String
   * @generated
   */
  EClass getString();

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
  interface Literals
  {
    /**
     * The meta object literal for the '{@link runtime.primitivetypes.impl.BinaryImpl <em>Binary</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see runtime.primitivetypes.impl.BinaryImpl
     * @see runtime.primitivetypes.impl.PrimitivetypesPackageImpl#getBinary()
     * @generated
     */
    EClass BINARY = eINSTANCE.getBinary();

    /**
     * The meta object literal for the '{@link runtime.primitivetypes.impl.BooleanImpl <em>Boolean</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see runtime.primitivetypes.impl.BooleanImpl
     * @see runtime.primitivetypes.impl.PrimitivetypesPackageImpl#getBoolean()
     * @generated
     */
    EClass BOOLEAN = eINSTANCE.getBoolean();

    /**
     * The meta object literal for the '{@link runtime.primitivetypes.impl.DateTimeImpl <em>Date Time</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see runtime.primitivetypes.impl.DateTimeImpl
     * @see runtime.primitivetypes.impl.PrimitivetypesPackageImpl#getDateTime()
     * @generated
     */
    EClass DATE_TIME = eINSTANCE.getDateTime();

    /**
     * The meta object literal for the '{@link runtime.primitivetypes.impl.NumberImpl <em>Number</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see runtime.primitivetypes.impl.NumberImpl
     * @see runtime.primitivetypes.impl.PrimitivetypesPackageImpl#getNumber()
     * @generated
     */
    EClass NUMBER = eINSTANCE.getNumber();

    /**
     * The meta object literal for the '{@link runtime.primitivetypes.impl.StringImpl <em>String</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see runtime.primitivetypes.impl.StringImpl
     * @see runtime.primitivetypes.impl.PrimitivetypesPackageImpl#getString()
     * @generated
     */
    EClass STRING = eINSTANCE.getString();

  }

} //PrimitivetypesPackage
