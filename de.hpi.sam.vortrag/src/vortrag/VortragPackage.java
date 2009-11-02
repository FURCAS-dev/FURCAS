/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package vortrag;

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
 * @see vortrag.VortragFactory
 * @model kind="package"
 * @generated
 */
public interface VortragPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "vortrag";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://vortrag/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "vortrag";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	VortragPackage eINSTANCE = vortrag.impl.VortragPackageImpl.init();

	/**
	 * The meta object id for the '{@link vortrag.impl.PersonImpl <em>Person</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see vortrag.impl.PersonImpl
	 * @see vortrag.impl.VortragPackageImpl#getPerson()
	 * @generated
	 */
	int PERSON = 0;

	/**
	 * The feature id for the '<em><b>Alter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__ALTER = 0;

	/**
	 * The feature id for the '<em><b>Autos</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__AUTOS = 1;

	/**
	 * The feature id for the '<em><b>Kinder</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__KINDER = 2;

	/**
	 * The feature id for the '<em><b>Eltern</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__ELTERN = 3;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__CONTAINER = 4;

	/**
	 * The number of structural features of the '<em>Person</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link vortrag.impl.AutoImpl <em>Auto</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see vortrag.impl.AutoImpl
	 * @see vortrag.impl.VortragPackageImpl#getAuto()
	 * @generated
	 */
	int AUTO = 1;

	/**
	 * The feature id for the '<em><b>Kennzeichen</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTO__KENNZEICHEN = 0;

	/**
	 * The feature id for the '<em><b>Marke</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTO__MARKE = 1;

	/**
	 * The feature id for the '<em><b>Erstzulassung</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTO__ERSTZULASSUNG = 2;

	/**
	 * The feature id for the '<em><b>Baujahr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTO__BAUJAHR = 3;

	/**
	 * The feature id for the '<em><b>Besitzer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTO__BESITZER = 4;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTO__CONTAINER = 5;

	/**
	 * The feature id for the '<em><b>EReference0</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTO__EREFERENCE0 = 6;

	/**
	 * The number of structural features of the '<em>Auto</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTO_FEATURE_COUNT = 7;


	/**
	 * The meta object id for the '{@link vortrag.impl.ContainerImpl <em>Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see vortrag.impl.ContainerImpl
	 * @see vortrag.impl.VortragPackageImpl#getContainer()
	 * @generated
	 */
	int CONTAINER = 2;

	/**
	 * The feature id for the '<em><b>Person</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__PERSON = 0;

	/**
	 * The feature id for the '<em><b>Auto</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__AUTO = 1;

	/**
	 * The number of structural features of the '<em>Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link vortrag.Person <em>Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Person</em>'.
	 * @see vortrag.Person
	 * @generated
	 */
	EClass getPerson();

	/**
	 * Returns the meta object for the attribute '{@link vortrag.Person#getAlter <em>Alter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alter</em>'.
	 * @see vortrag.Person#getAlter()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_Alter();

	/**
	 * Returns the meta object for the reference list '{@link vortrag.Person#getAutos <em>Autos</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Autos</em>'.
	 * @see vortrag.Person#getAutos()
	 * @see #getPerson()
	 * @generated
	 */
	EReference getPerson_Autos();

	/**
	 * Returns the meta object for the reference list '{@link vortrag.Person#getKinder <em>Kinder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Kinder</em>'.
	 * @see vortrag.Person#getKinder()
	 * @see #getPerson()
	 * @generated
	 */
	EReference getPerson_Kinder();

	/**
	 * Returns the meta object for the reference list '{@link vortrag.Person#getEltern <em>Eltern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Eltern</em>'.
	 * @see vortrag.Person#getEltern()
	 * @see #getPerson()
	 * @generated
	 */
	EReference getPerson_Eltern();

	/**
	 * Returns the meta object for the container reference '{@link vortrag.Person#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Container</em>'.
	 * @see vortrag.Person#getContainer()
	 * @see #getPerson()
	 * @generated
	 */
	EReference getPerson_Container();

	/**
	 * Returns the meta object for class '{@link vortrag.Auto <em>Auto</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Auto</em>'.
	 * @see vortrag.Auto
	 * @generated
	 */
	EClass getAuto();

	/**
	 * Returns the meta object for the attribute '{@link vortrag.Auto#getKennzeichen <em>Kennzeichen</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kennzeichen</em>'.
	 * @see vortrag.Auto#getKennzeichen()
	 * @see #getAuto()
	 * @generated
	 */
	EAttribute getAuto_Kennzeichen();

	/**
	 * Returns the meta object for the attribute '{@link vortrag.Auto#getMarke <em>Marke</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Marke</em>'.
	 * @see vortrag.Auto#getMarke()
	 * @see #getAuto()
	 * @generated
	 */
	EAttribute getAuto_Marke();

	/**
	 * Returns the meta object for the attribute '{@link vortrag.Auto#getErstzulassung <em>Erstzulassung</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Erstzulassung</em>'.
	 * @see vortrag.Auto#getErstzulassung()
	 * @see #getAuto()
	 * @generated
	 */
	EAttribute getAuto_Erstzulassung();

	/**
	 * Returns the meta object for the attribute '{@link vortrag.Auto#getBaujahr <em>Baujahr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Baujahr</em>'.
	 * @see vortrag.Auto#getBaujahr()
	 * @see #getAuto()
	 * @generated
	 */
	EAttribute getAuto_Baujahr();

	/**
	 * Returns the meta object for the reference '{@link vortrag.Auto#getBesitzer <em>Besitzer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Besitzer</em>'.
	 * @see vortrag.Auto#getBesitzer()
	 * @see #getAuto()
	 * @generated
	 */
	EReference getAuto_Besitzer();

	/**
	 * Returns the meta object for the container reference '{@link vortrag.Auto#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Container</em>'.
	 * @see vortrag.Auto#getContainer()
	 * @see #getAuto()
	 * @generated
	 */
	EReference getAuto_Container();

	/**
	 * Returns the meta object for the reference '{@link vortrag.Auto#getEReference0 <em>EReference0</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EReference0</em>'.
	 * @see vortrag.Auto#getEReference0()
	 * @see #getAuto()
	 * @generated
	 */
	EReference getAuto_EReference0();

	/**
	 * Returns the meta object for class '{@link vortrag.Container <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Container</em>'.
	 * @see vortrag.Container
	 * @generated
	 */
	EClass getContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link vortrag.Container#getPerson <em>Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Person</em>'.
	 * @see vortrag.Container#getPerson()
	 * @see #getContainer()
	 * @generated
	 */
	EReference getContainer_Person();

	/**
	 * Returns the meta object for the containment reference list '{@link vortrag.Container#getAuto <em>Auto</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Auto</em>'.
	 * @see vortrag.Container#getAuto()
	 * @see #getContainer()
	 * @generated
	 */
	EReference getContainer_Auto();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	VortragFactory getVortragFactory();

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
		 * The meta object literal for the '{@link vortrag.impl.PersonImpl <em>Person</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see vortrag.impl.PersonImpl
		 * @see vortrag.impl.VortragPackageImpl#getPerson()
		 * @generated
		 */
		EClass PERSON = eINSTANCE.getPerson();

		/**
		 * The meta object literal for the '<em><b>Alter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__ALTER = eINSTANCE.getPerson_Alter();

		/**
		 * The meta object literal for the '<em><b>Autos</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERSON__AUTOS = eINSTANCE.getPerson_Autos();

		/**
		 * The meta object literal for the '<em><b>Kinder</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERSON__KINDER = eINSTANCE.getPerson_Kinder();

		/**
		 * The meta object literal for the '<em><b>Eltern</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERSON__ELTERN = eINSTANCE.getPerson_Eltern();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERSON__CONTAINER = eINSTANCE.getPerson_Container();

		/**
		 * The meta object literal for the '{@link vortrag.impl.AutoImpl <em>Auto</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see vortrag.impl.AutoImpl
		 * @see vortrag.impl.VortragPackageImpl#getAuto()
		 * @generated
		 */
		EClass AUTO = eINSTANCE.getAuto();

		/**
		 * The meta object literal for the '<em><b>Kennzeichen</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUTO__KENNZEICHEN = eINSTANCE.getAuto_Kennzeichen();

		/**
		 * The meta object literal for the '<em><b>Marke</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUTO__MARKE = eINSTANCE.getAuto_Marke();

		/**
		 * The meta object literal for the '<em><b>Erstzulassung</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUTO__ERSTZULASSUNG = eINSTANCE.getAuto_Erstzulassung();

		/**
		 * The meta object literal for the '<em><b>Baujahr</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUTO__BAUJAHR = eINSTANCE.getAuto_Baujahr();

		/**
		 * The meta object literal for the '<em><b>Besitzer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AUTO__BESITZER = eINSTANCE.getAuto_Besitzer();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AUTO__CONTAINER = eINSTANCE.getAuto_Container();

		/**
		 * The meta object literal for the '<em><b>EReference0</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AUTO__EREFERENCE0 = eINSTANCE.getAuto_EReference0();

		/**
		 * The meta object literal for the '{@link vortrag.impl.ContainerImpl <em>Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see vortrag.impl.ContainerImpl
		 * @see vortrag.impl.VortragPackageImpl#getContainer()
		 * @generated
		 */
		EClass CONTAINER = eINSTANCE.getContainer();

		/**
		 * The meta object literal for the '<em><b>Person</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTAINER__PERSON = eINSTANCE.getContainer_Person();

		/**
		 * The meta object literal for the '<em><b>Auto</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTAINER__AUTO = eINSTANCE.getContainer_Auto();

	}

} //VortragPackage
