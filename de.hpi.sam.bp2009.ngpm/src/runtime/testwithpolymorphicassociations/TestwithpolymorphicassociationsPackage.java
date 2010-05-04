/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package runtime.testwithpolymorphicassociations;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see runtime.testwithpolymorphicassociations.TestwithpolymorphicassociationsFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://de.hpi.sam.bp2009.OCL' validationDelegates='http://de.hpi.sam.bp2009.OCL'"
 * @generated
 */
public interface TestwithpolymorphicassociationsPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "testwithpolymorphicassociations";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http:///runtime/testwithpolymorphicassociations.ecore";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "runtime.testwithpolymorphicassociations";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  TestwithpolymorphicassociationsPackage eINSTANCE = runtime.testwithpolymorphicassociations.impl.TestwithpolymorphicassociationsPackageImpl.init();

  /**
   * The meta object id for the '{@link runtime.testwithpolymorphicassociations.impl.AImpl <em>A</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see runtime.testwithpolymorphicassociations.impl.AImpl
   * @see runtime.testwithpolymorphicassociations.impl.TestwithpolymorphicassociationsPackageImpl#getA()
   * @generated
   */
  int A = 0;

  /**
   * The feature id for the '<em><b>Ato B</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int A__ATO_B = 0;

  /**
   * The feature id for the '<em><b>B</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int A__B = 1;

  /**
   * The number of structural features of the '<em>A</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int A_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link runtime.testwithpolymorphicassociations.impl.CImpl <em>C</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see runtime.testwithpolymorphicassociations.impl.CImpl
   * @see runtime.testwithpolymorphicassociations.impl.TestwithpolymorphicassociationsPackageImpl#getC()
   * @generated
   */
  int C = 1;

  /**
   * The feature id for the '<em><b>Cto D</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int C__CTO_D = 0;

  /**
   * The feature id for the '<em><b>Ato B</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int C__ATO_B = 1;

  /**
   * The feature id for the '<em><b>B</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int C__B = 2;

  /**
   * The number of structural features of the '<em>C</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int C_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link runtime.testwithpolymorphicassociations.impl.BImpl <em>B</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see runtime.testwithpolymorphicassociations.impl.BImpl
   * @see runtime.testwithpolymorphicassociations.impl.TestwithpolymorphicassociationsPackageImpl#getB()
   * @generated
   */
  int B = 2;

  /**
   * The feature id for the '<em><b>A</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int B__A = 0;

  /**
   * The number of structural features of the '<em>B</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int B_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link runtime.testwithpolymorphicassociations.impl.DImpl <em>D</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see runtime.testwithpolymorphicassociations.impl.DImpl
   * @see runtime.testwithpolymorphicassociations.impl.TestwithpolymorphicassociationsPackageImpl#getD()
   * @generated
   */
  int D = 3;

  /**
   * The feature id for the '<em><b>A</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int D__A = 0;

  /**
   * The number of structural features of the '<em>D</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int D_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link runtime.testwithpolymorphicassociations.impl.EImpl <em>E</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see runtime.testwithpolymorphicassociations.impl.EImpl
   * @see runtime.testwithpolymorphicassociations.impl.TestwithpolymorphicassociationsPackageImpl#getE()
   * @generated
   */
  int E = 4;

  /**
   * The feature id for the '<em><b>Eto F</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int E__ETO_F = 0;

  /**
   * The feature id for the '<em><b>B</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int E__B = 1;

  /**
   * The number of structural features of the '<em>E</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int E_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link runtime.testwithpolymorphicassociations.impl.FImpl <em>F</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see runtime.testwithpolymorphicassociations.impl.FImpl
   * @see runtime.testwithpolymorphicassociations.impl.TestwithpolymorphicassociationsPackageImpl#getF()
   * @generated
   */
  int F = 5;

  /**
   * The feature id for the '<em><b>A</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int F__A = 0;

  /**
   * The number of structural features of the '<em>F</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int F_FEATURE_COUNT = 1;


  /**
   * Returns the meta object for class '{@link runtime.testwithpolymorphicassociations.A <em>A</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>A</em>'.
   * @see runtime.testwithpolymorphicassociations.A
   * @generated
   */
  EClass getA();

  /**
   * Returns the meta object for the attribute '{@link runtime.testwithpolymorphicassociations.A#getAtoB <em>Ato B</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ato B</em>'.
   * @see runtime.testwithpolymorphicassociations.A#getAtoB()
   * @see #getA()
   * @generated
   */
  EAttribute getA_AtoB();

  /**
   * Returns the meta object for the reference list '{@link runtime.testwithpolymorphicassociations.A#getB <em>B</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>B</em>'.
   * @see runtime.testwithpolymorphicassociations.A#getB()
   * @see #getA()
   * @generated
   */
  EReference getA_B();

  /**
   * Returns the meta object for class '{@link runtime.testwithpolymorphicassociations.C <em>C</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>C</em>'.
   * @see runtime.testwithpolymorphicassociations.C
   * @generated
   */
  EClass getC();

  /**
   * Returns the meta object for the attribute '{@link runtime.testwithpolymorphicassociations.C#getCtoD <em>Cto D</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Cto D</em>'.
   * @see runtime.testwithpolymorphicassociations.C#getCtoD()
   * @see #getC()
   * @generated
   */
  EAttribute getC_CtoD();

  /**
   * Returns the meta object for the attribute '{@link runtime.testwithpolymorphicassociations.C#getAtoB <em>Ato B</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ato B</em>'.
   * @see runtime.testwithpolymorphicassociations.C#getAtoB()
   * @see #getC()
   * @generated
   */
  EAttribute getC_AtoB();

  /**
   * Returns the meta object for the reference list '{@link runtime.testwithpolymorphicassociations.C#getB <em>B</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>B</em>'.
   * @see runtime.testwithpolymorphicassociations.C#getB()
   * @see #getC()
   * @generated
   */
  EReference getC_B();

  /**
   * Returns the meta object for class '{@link runtime.testwithpolymorphicassociations.B <em>B</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>B</em>'.
   * @see runtime.testwithpolymorphicassociations.B
   * @generated
   */
  EClass getB();

  /**
   * Returns the meta object for the reference list '{@link runtime.testwithpolymorphicassociations.B#getA <em>A</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>A</em>'.
   * @see runtime.testwithpolymorphicassociations.B#getA()
   * @see #getB()
   * @generated
   */
  EReference getB_A();

  /**
   * Returns the meta object for class '{@link runtime.testwithpolymorphicassociations.D <em>D</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>D</em>'.
   * @see runtime.testwithpolymorphicassociations.D
   * @generated
   */
  EClass getD();

  /**
   * Returns the meta object for the reference list '{@link runtime.testwithpolymorphicassociations.D#getA <em>A</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>A</em>'.
   * @see runtime.testwithpolymorphicassociations.D#getA()
   * @see #getD()
   * @generated
   */
  EReference getD_A();

  /**
   * Returns the meta object for class '{@link runtime.testwithpolymorphicassociations.E <em>E</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>E</em>'.
   * @see runtime.testwithpolymorphicassociations.E
   * @generated
   */
  EClass getE();

  /**
   * Returns the meta object for the attribute '{@link runtime.testwithpolymorphicassociations.E#getEtoF <em>Eto F</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Eto F</em>'.
   * @see runtime.testwithpolymorphicassociations.E#getEtoF()
   * @see #getE()
   * @generated
   */
  EAttribute getE_EtoF();

  /**
   * Returns the meta object for the reference list '{@link runtime.testwithpolymorphicassociations.E#getB <em>B</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>B</em>'.
   * @see runtime.testwithpolymorphicassociations.E#getB()
   * @see #getE()
   * @generated
   */
  EReference getE_B();

  /**
   * Returns the meta object for class '{@link runtime.testwithpolymorphicassociations.F <em>F</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>F</em>'.
   * @see runtime.testwithpolymorphicassociations.F
   * @generated
   */
  EClass getF();

  /**
   * Returns the meta object for the reference list '{@link runtime.testwithpolymorphicassociations.F#getA <em>A</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>A</em>'.
   * @see runtime.testwithpolymorphicassociations.F#getA()
   * @see #getF()
   * @generated
   */
  EReference getF_A();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  TestwithpolymorphicassociationsFactory getTestwithpolymorphicassociationsFactory();

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
     * The meta object literal for the '{@link runtime.testwithpolymorphicassociations.impl.AImpl <em>A</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see runtime.testwithpolymorphicassociations.impl.AImpl
     * @see runtime.testwithpolymorphicassociations.impl.TestwithpolymorphicassociationsPackageImpl#getA()
     * @generated
     */
    EClass A = eINSTANCE.getA();

    /**
     * The meta object literal for the '<em><b>Ato B</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute A__ATO_B = eINSTANCE.getA_AtoB();

    /**
     * The meta object literal for the '<em><b>B</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference A__B = eINSTANCE.getA_B();

    /**
     * The meta object literal for the '{@link runtime.testwithpolymorphicassociations.impl.CImpl <em>C</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see runtime.testwithpolymorphicassociations.impl.CImpl
     * @see runtime.testwithpolymorphicassociations.impl.TestwithpolymorphicassociationsPackageImpl#getC()
     * @generated
     */
    EClass C = eINSTANCE.getC();

    /**
     * The meta object literal for the '<em><b>Cto D</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute C__CTO_D = eINSTANCE.getC_CtoD();

    /**
     * The meta object literal for the '<em><b>Ato B</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute C__ATO_B = eINSTANCE.getC_AtoB();

    /**
     * The meta object literal for the '<em><b>B</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference C__B = eINSTANCE.getC_B();

    /**
     * The meta object literal for the '{@link runtime.testwithpolymorphicassociations.impl.BImpl <em>B</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see runtime.testwithpolymorphicassociations.impl.BImpl
     * @see runtime.testwithpolymorphicassociations.impl.TestwithpolymorphicassociationsPackageImpl#getB()
     * @generated
     */
    EClass B = eINSTANCE.getB();

    /**
     * The meta object literal for the '<em><b>A</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference B__A = eINSTANCE.getB_A();

    /**
     * The meta object literal for the '{@link runtime.testwithpolymorphicassociations.impl.DImpl <em>D</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see runtime.testwithpolymorphicassociations.impl.DImpl
     * @see runtime.testwithpolymorphicassociations.impl.TestwithpolymorphicassociationsPackageImpl#getD()
     * @generated
     */
    EClass D = eINSTANCE.getD();

    /**
     * The meta object literal for the '<em><b>A</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference D__A = eINSTANCE.getD_A();

    /**
     * The meta object literal for the '{@link runtime.testwithpolymorphicassociations.impl.EImpl <em>E</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see runtime.testwithpolymorphicassociations.impl.EImpl
     * @see runtime.testwithpolymorphicassociations.impl.TestwithpolymorphicassociationsPackageImpl#getE()
     * @generated
     */
    EClass E = eINSTANCE.getE();

    /**
     * The meta object literal for the '<em><b>Eto F</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute E__ETO_F = eINSTANCE.getE_EtoF();

    /**
     * The meta object literal for the '<em><b>B</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference E__B = eINSTANCE.getE_B();

    /**
     * The meta object literal for the '{@link runtime.testwithpolymorphicassociations.impl.FImpl <em>F</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see runtime.testwithpolymorphicassociations.impl.FImpl
     * @see runtime.testwithpolymorphicassociations.impl.TestwithpolymorphicassociationsPackageImpl#getF()
     * @generated
     */
    EClass F = eINSTANCE.getF();

    /**
     * The meta object literal for the '<em><b>A</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference F__A = eINSTANCE.getF_A();

  }

} //TestwithpolymorphicassociationsPackage
