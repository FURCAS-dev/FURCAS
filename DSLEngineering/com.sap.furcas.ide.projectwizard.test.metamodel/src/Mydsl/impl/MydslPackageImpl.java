/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package Mydsl.impl;

import Mydsl.ExampleClass;
import Mydsl.MydslFactory;
import Mydsl.MydslPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MydslPackageImpl extends EPackageImpl implements MydslPackage
{
  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  private EClass exampleClassEClass = null;

  /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see Mydsl.MydslPackage#eNS_URI
     * @see #init()
     * @generated
     */
  private MydslPackageImpl()
  {
        super(eNS_URI, MydslFactory.eINSTANCE);
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  private static boolean isInited = false;

  /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>This method is used to initialize {@link MydslPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
  public static MydslPackage init()
  {
        if (isInited) return (MydslPackage)EPackage.Registry.INSTANCE.getEPackage(MydslPackage.eNS_URI);

        // Obtain or create and register package
        MydslPackageImpl theMydslPackage = (MydslPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MydslPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MydslPackageImpl());

        isInited = true;

        // Create package meta-data objects
        theMydslPackage.createPackageContents();

        // Initialize created meta-data
        theMydslPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theMydslPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(MydslPackage.eNS_URI, theMydslPackage);
        return theMydslPackage;
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public EClass getExampleClass()
  {
        return exampleClassEClass;
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public MydslFactory getMydslFactory()
  {
        return (MydslFactory)getEFactoryInstance();
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  private boolean isCreated = false;

  /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public void createPackageContents()
  {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        exampleClassEClass = createEClass(EXAMPLE_CLASS);
    }

  /**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  private boolean isInitialized = false;

  /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public void initializePackageContents()
  {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes

        // Initialize classes and features; add operations and parameters
        initEClass(exampleClassEClass, ExampleClass.class, "ExampleClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        // Create resource
        createResource(eNS_URI);
    }

} //MydslPackageImpl
