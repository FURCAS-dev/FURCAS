/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.tc.moin.repository.mmi.Model.impl;

import com.sap.tc.moin.repository.mmi.Model.AggregationKind;
import com.sap.tc.moin.repository.mmi.Model.AliasType;
import com.sap.tc.moin.repository.mmi.Model.Association;
import com.sap.tc.moin.repository.mmi.Model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.Model.Attribute;
import com.sap.tc.moin.repository.mmi.Model.BehavioralFeature;
import com.sap.tc.moin.repository.mmi.Model.Classifier;
import com.sap.tc.moin.repository.mmi.Model.CollectionType;
import com.sap.tc.moin.repository.mmi.Model.Constant;
import com.sap.tc.moin.repository.mmi.Model.Constraint;
import com.sap.tc.moin.repository.mmi.Model.DataType;
import com.sap.tc.moin.repository.mmi.Model.DirectionKind;
import com.sap.tc.moin.repository.mmi.Model.EnumerationType;
import com.sap.tc.moin.repository.mmi.Model.Feature;
import com.sap.tc.moin.repository.mmi.Model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.Model.Import;
import com.sap.tc.moin.repository.mmi.Model.ModelElement;
import com.sap.tc.moin.repository.mmi.Model.ModelFactory;
import com.sap.tc.moin.repository.mmi.Model.ModelPackage;
import com.sap.tc.moin.repository.mmi.Model.MultiplicityType;
import com.sap.tc.moin.repository.mmi.Model.Namespace;
import com.sap.tc.moin.repository.mmi.Model.Operation;
import com.sap.tc.moin.repository.mmi.Model.Parameter;
import com.sap.tc.moin.repository.mmi.Model.PrimitiveType;
import com.sap.tc.moin.repository.mmi.Model.Reference;
import com.sap.tc.moin.repository.mmi.Model.ScopeKind;
import com.sap.tc.moin.repository.mmi.Model.StructuralFeature;
import com.sap.tc.moin.repository.mmi.Model.StructureField;
import com.sap.tc.moin.repository.mmi.Model.StructureType;
import com.sap.tc.moin.repository.mmi.Model.Tag;
import com.sap.tc.moin.repository.mmi.Model.TypedElement;
import com.sap.tc.moin.repository.mmi.Model.VisibilityKind;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelPackageImpl extends EPackageImpl implements ModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namespaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass generalizableElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiplicityTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structuralFeatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behavioralFeatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exceptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass associationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass associationEndEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass packageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass importEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constantEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tagEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structureTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumerationTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aliasTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structureFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum visibilityKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum scopeKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum aggregationKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum directionKindEEnum = null;

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
	 * @see com.sap.tc.moin.repository.mmi.Model.ModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ModelPackageImpl() {
		super(eNS_URI, ModelFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ModelPackage init() {
		if (isInited) return (ModelPackage)EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);

		// Obtain or create and register package
		ModelPackageImpl theModelPackage = (ModelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ModelPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theModelPackage.createPackageContents();

		// Initialize created meta-data
		theModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theModelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ModelPackage.eNS_URI, theModelPackage);
		return theModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelElement() {
		return modelElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelElement_Name() {
		return (EAttribute)modelElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelElement_QualifiedName() {
		return (EAttribute)modelElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelElement_Annotation() {
		return (EAttribute)modelElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelElement_RequiredElements() {
		return (EReference)modelElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelElement_Container() {
		return (EReference)modelElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelElement_Constraints() {
		return (EReference)modelElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamespace() {
		return namespaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNamespace_Contents() {
		return (EReference)namespaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGeneralizableElement() {
		return generalizableElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneralizableElement_IsRoot() {
		return (EAttribute)generalizableElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneralizableElement_IsLeaf() {
		return (EAttribute)generalizableElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneralizableElement_IsAbstract() {
		return (EAttribute)generalizableElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneralizableElement_Visibility() {
		return (EAttribute)generalizableElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGeneralizableElement_Supertypes() {
		return (EReference)generalizableElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypedElement() {
		return typedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypedElement_Type() {
		return (EReference)typedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassifier() {
		return classifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClass_() {
		return classEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClass_IsSingleton() {
		return (EAttribute)classEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataType() {
		return dataTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeature() {
		return featureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeature_Scope() {
		return (EAttribute)featureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeature_Visibility() {
		return (EAttribute)featureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultiplicityType() {
		return multiplicityTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiplicityType_Lower() {
		return (EAttribute)multiplicityTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiplicityType_Upper() {
		return (EAttribute)multiplicityTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiplicityType_IsOrdered() {
		return (EAttribute)multiplicityTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiplicityType_IsUnique() {
		return (EAttribute)multiplicityTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStructuralFeature() {
		return structuralFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructuralFeature_Multiplicity() {
		return (EReference)structuralFeatureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStructuralFeature_IsChangeable() {
		return (EAttribute)structuralFeatureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttribute() {
		return attributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttribute_IsDerived() {
		return (EAttribute)attributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReference() {
		return referenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReference_ExposedEnd() {
		return (EReference)referenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReference_ReferencedEnd() {
		return (EReference)referenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBehavioralFeature() {
		return behavioralFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperation() {
		return operationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperation_IsQuery() {
		return (EAttribute)operationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperation_Exceptions() {
		return (EReference)operationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getException() {
		return exceptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssociation() {
		return associationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssociation_IsDerived() {
		return (EAttribute)associationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssociationEnd() {
		return associationEndEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssociationEnd_IsNavigable() {
		return (EAttribute)associationEndEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssociationEnd_Aggregation() {
		return (EAttribute)associationEndEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssociationEnd_Multiplicity() {
		return (EReference)associationEndEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssociationEnd_IsChangeable() {
		return (EAttribute)associationEndEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPackage() {
		return packageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImport() {
		return importEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImport_Visibility() {
		return (EAttribute)importEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImport_IsClustered() {
		return (EAttribute)importEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImport_ImportedNamespace() {
		return (EReference)importEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameter() {
		return parameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameter_Direction() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameter_Multiplicity() {
		return (EReference)parameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstraint() {
		return constraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstraint_Expression() {
		return (EAttribute)constraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstraint_Language() {
		return (EAttribute)constraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstraint_EvaluationPolicy() {
		return (EAttribute)constraintEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraint_ConstrainedElements() {
		return (EReference)constraintEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstant() {
		return constantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstant_Value() {
		return (EAttribute)constantEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTag() {
		return tagEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTag_TagId() {
		return (EAttribute)tagEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTag_Values() {
		return (EAttribute)tagEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTag_Elements() {
		return (EReference)tagEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimitiveType() {
		return primitiveTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStructureType() {
		return structureTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumerationType() {
		return enumerationTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumerationType_Labels() {
		return (EAttribute)enumerationTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAliasType() {
		return aliasTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStructureField() {
		return structureFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollectionType() {
		return collectionTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionType_Multiplicity() {
		return (EReference)collectionTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getVisibilityKind() {
		return visibilityKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getScopeKind() {
		return scopeKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAggregationKind() {
		return aggregationKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDirectionKind() {
		return directionKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelFactory getModelFactory() {
		return (ModelFactory)getEFactoryInstance();
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
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		modelElementEClass = createEClass(MODEL_ELEMENT);
		createEAttribute(modelElementEClass, MODEL_ELEMENT__NAME);
		createEAttribute(modelElementEClass, MODEL_ELEMENT__QUALIFIED_NAME);
		createEAttribute(modelElementEClass, MODEL_ELEMENT__ANNOTATION);
		createEReference(modelElementEClass, MODEL_ELEMENT__REQUIRED_ELEMENTS);
		createEReference(modelElementEClass, MODEL_ELEMENT__CONTAINER);
		createEReference(modelElementEClass, MODEL_ELEMENT__CONSTRAINTS);

		namespaceEClass = createEClass(NAMESPACE);
		createEReference(namespaceEClass, NAMESPACE__CONTENTS);

		generalizableElementEClass = createEClass(GENERALIZABLE_ELEMENT);
		createEAttribute(generalizableElementEClass, GENERALIZABLE_ELEMENT__IS_ROOT);
		createEAttribute(generalizableElementEClass, GENERALIZABLE_ELEMENT__IS_LEAF);
		createEAttribute(generalizableElementEClass, GENERALIZABLE_ELEMENT__IS_ABSTRACT);
		createEAttribute(generalizableElementEClass, GENERALIZABLE_ELEMENT__VISIBILITY);
		createEReference(generalizableElementEClass, GENERALIZABLE_ELEMENT__SUPERTYPES);

		typedElementEClass = createEClass(TYPED_ELEMENT);
		createEReference(typedElementEClass, TYPED_ELEMENT__TYPE);

		classifierEClass = createEClass(CLASSIFIER);

		classEClass = createEClass(CLASS);
		createEAttribute(classEClass, CLASS__IS_SINGLETON);

		dataTypeEClass = createEClass(DATA_TYPE);

		featureEClass = createEClass(FEATURE);
		createEAttribute(featureEClass, FEATURE__SCOPE);
		createEAttribute(featureEClass, FEATURE__VISIBILITY);

		multiplicityTypeEClass = createEClass(MULTIPLICITY_TYPE);
		createEAttribute(multiplicityTypeEClass, MULTIPLICITY_TYPE__LOWER);
		createEAttribute(multiplicityTypeEClass, MULTIPLICITY_TYPE__UPPER);
		createEAttribute(multiplicityTypeEClass, MULTIPLICITY_TYPE__IS_ORDERED);
		createEAttribute(multiplicityTypeEClass, MULTIPLICITY_TYPE__IS_UNIQUE);

		structuralFeatureEClass = createEClass(STRUCTURAL_FEATURE);
		createEReference(structuralFeatureEClass, STRUCTURAL_FEATURE__MULTIPLICITY);
		createEAttribute(structuralFeatureEClass, STRUCTURAL_FEATURE__IS_CHANGEABLE);

		attributeEClass = createEClass(ATTRIBUTE);
		createEAttribute(attributeEClass, ATTRIBUTE__IS_DERIVED);

		referenceEClass = createEClass(REFERENCE);
		createEReference(referenceEClass, REFERENCE__EXPOSED_END);
		createEReference(referenceEClass, REFERENCE__REFERENCED_END);

		behavioralFeatureEClass = createEClass(BEHAVIORAL_FEATURE);

		operationEClass = createEClass(OPERATION);
		createEAttribute(operationEClass, OPERATION__IS_QUERY);
		createEReference(operationEClass, OPERATION__EXCEPTIONS);

		exceptionEClass = createEClass(EXCEPTION);

		associationEClass = createEClass(ASSOCIATION);
		createEAttribute(associationEClass, ASSOCIATION__IS_DERIVED);

		associationEndEClass = createEClass(ASSOCIATION_END);
		createEAttribute(associationEndEClass, ASSOCIATION_END__IS_NAVIGABLE);
		createEAttribute(associationEndEClass, ASSOCIATION_END__AGGREGATION);
		createEReference(associationEndEClass, ASSOCIATION_END__MULTIPLICITY);
		createEAttribute(associationEndEClass, ASSOCIATION_END__IS_CHANGEABLE);

		packageEClass = createEClass(PACKAGE);

		importEClass = createEClass(IMPORT);
		createEAttribute(importEClass, IMPORT__VISIBILITY);
		createEAttribute(importEClass, IMPORT__IS_CLUSTERED);
		createEReference(importEClass, IMPORT__IMPORTED_NAMESPACE);

		parameterEClass = createEClass(PARAMETER);
		createEAttribute(parameterEClass, PARAMETER__DIRECTION);
		createEReference(parameterEClass, PARAMETER__MULTIPLICITY);

		constraintEClass = createEClass(CONSTRAINT);
		createEAttribute(constraintEClass, CONSTRAINT__EXPRESSION);
		createEAttribute(constraintEClass, CONSTRAINT__LANGUAGE);
		createEAttribute(constraintEClass, CONSTRAINT__EVALUATION_POLICY);
		createEReference(constraintEClass, CONSTRAINT__CONSTRAINED_ELEMENTS);

		constantEClass = createEClass(CONSTANT);
		createEAttribute(constantEClass, CONSTANT__VALUE);

		tagEClass = createEClass(TAG);
		createEAttribute(tagEClass, TAG__TAG_ID);
		createEAttribute(tagEClass, TAG__VALUES);
		createEReference(tagEClass, TAG__ELEMENTS);

		primitiveTypeEClass = createEClass(PRIMITIVE_TYPE);

		structureTypeEClass = createEClass(STRUCTURE_TYPE);

		enumerationTypeEClass = createEClass(ENUMERATION_TYPE);
		createEAttribute(enumerationTypeEClass, ENUMERATION_TYPE__LABELS);

		aliasTypeEClass = createEClass(ALIAS_TYPE);

		structureFieldEClass = createEClass(STRUCTURE_FIELD);

		collectionTypeEClass = createEClass(COLLECTION_TYPE);
		createEReference(collectionTypeEClass, COLLECTION_TYPE__MULTIPLICITY);

		// Create enums
		visibilityKindEEnum = createEEnum(VISIBILITY_KIND);
		scopeKindEEnum = createEEnum(SCOPE_KIND);
		aggregationKindEEnum = createEEnum(AGGREGATION_KIND);
		directionKindEEnum = createEEnum(DIRECTION_KIND);
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
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		namespaceEClass.getESuperTypes().add(this.getModelElement());
		generalizableElementEClass.getESuperTypes().add(this.getNamespace());
		typedElementEClass.getESuperTypes().add(this.getModelElement());
		classifierEClass.getESuperTypes().add(this.getGeneralizableElement());
		classEClass.getESuperTypes().add(this.getClassifier());
		dataTypeEClass.getESuperTypes().add(this.getClassifier());
		featureEClass.getESuperTypes().add(this.getModelElement());
		structuralFeatureEClass.getESuperTypes().add(this.getFeature());
		structuralFeatureEClass.getESuperTypes().add(this.getTypedElement());
		attributeEClass.getESuperTypes().add(this.getStructuralFeature());
		referenceEClass.getESuperTypes().add(this.getStructuralFeature());
		behavioralFeatureEClass.getESuperTypes().add(this.getFeature());
		behavioralFeatureEClass.getESuperTypes().add(this.getNamespace());
		operationEClass.getESuperTypes().add(this.getBehavioralFeature());
		exceptionEClass.getESuperTypes().add(this.getBehavioralFeature());
		associationEClass.getESuperTypes().add(this.getClassifier());
		associationEndEClass.getESuperTypes().add(this.getTypedElement());
		packageEClass.getESuperTypes().add(this.getGeneralizableElement());
		importEClass.getESuperTypes().add(this.getModelElement());
		parameterEClass.getESuperTypes().add(this.getTypedElement());
		constraintEClass.getESuperTypes().add(this.getModelElement());
		constantEClass.getESuperTypes().add(this.getTypedElement());
		tagEClass.getESuperTypes().add(this.getModelElement());
		primitiveTypeEClass.getESuperTypes().add(this.getDataType());
		structureTypeEClass.getESuperTypes().add(this.getDataType());
		enumerationTypeEClass.getESuperTypes().add(this.getDataType());
		aliasTypeEClass.getESuperTypes().add(this.getDataType());
		aliasTypeEClass.getESuperTypes().add(this.getTypedElement());
		structureFieldEClass.getESuperTypes().add(this.getTypedElement());
		collectionTypeEClass.getESuperTypes().add(this.getTypedElement());
		collectionTypeEClass.getESuperTypes().add(this.getDataType());

		// Initialize classes and features; add operations and parameters
		initEClass(modelElementEClass, ModelElement.class, "ModelElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModelElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, ModelElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getModelElement_QualifiedName(), ecorePackage.getEString(), "qualifiedName", null, 1, -1, ModelElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModelElement_Annotation(), ecorePackage.getEString(), "annotation", null, 1, 1, ModelElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getModelElement_RequiredElements(), this.getModelElement(), null, "requiredElements", null, 0, -1, ModelElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getModelElement_Container(), this.getNamespace(), this.getNamespace_Contents(), "container", null, 0, 1, ModelElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getModelElement_Constraints(), this.getConstraint(), this.getConstraint_ConstrainedElements(), "constraints", null, 0, -1, ModelElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		EOperation op = addEOperation(modelElementEClass, this.getModelElement(), "findRequiredElements", 0, -1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "kinds", 1, -1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "recursive", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(modelElementEClass, ecorePackage.getEBoolean(), "isRequiredBecause", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getModelElement(), "otherElement", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "reason", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		addEOperation(modelElementEClass, ecorePackage.getEBoolean(), "isFrozen", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(modelElementEClass, ecorePackage.getEBoolean(), "isVisible", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getModelElement(), "otherElement", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		initEClass(namespaceEClass, Namespace.class, "Namespace", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNamespace_Contents(), this.getModelElement(), this.getModelElement_Container(), "contents", null, 0, -1, Namespace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(namespaceEClass, this.getModelElement(), "lookupElement", 0, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(namespaceEClass, this.getModelElement(), "resolveQualifiedName", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "qualifiedName", 1, -1, !IS_UNIQUE, IS_ORDERED);

		op = addEOperation(namespaceEClass, this.getModelElement(), "findElementsByType", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getClass_(), "ofType", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "includeSubtypes", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(namespaceEClass, ecorePackage.getEBoolean(), "nameIsValid", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "proposedName", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		initEClass(generalizableElementEClass, GeneralizableElement.class, "GeneralizableElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGeneralizableElement_IsRoot(), ecorePackage.getEBoolean(), "isRoot", null, 1, 1, GeneralizableElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getGeneralizableElement_IsLeaf(), ecorePackage.getEBoolean(), "isLeaf", null, 1, 1, GeneralizableElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getGeneralizableElement_IsAbstract(), ecorePackage.getEBoolean(), "isAbstract", null, 1, 1, GeneralizableElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getGeneralizableElement_Visibility(), this.getVisibilityKind(), "visibility", null, 1, 1, GeneralizableElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGeneralizableElement_Supertypes(), this.getGeneralizableElement(), null, "supertypes", null, 0, -1, GeneralizableElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(generalizableElementEClass, this.getGeneralizableElement(), "allSupertypes", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(generalizableElementEClass, this.getModelElement(), "lookupElementExtended", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(generalizableElementEClass, this.getModelElement(), "findElementsByTypeExtended", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getClass_(), "ofType", 1, 1, !IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "includeSubtypes", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		initEClass(typedElementEClass, TypedElement.class, "TypedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypedElement_Type(), this.getClassifier(), null, "type", null, 1, 1, TypedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(classifierEClass, Classifier.class, "Classifier", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(classEClass, com.sap.tc.moin.repository.mmi.Model.Class.class, "Class", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClass_IsSingleton(), ecorePackage.getEBoolean(), "isSingleton", null, 1, 1, com.sap.tc.moin.repository.mmi.Model.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(dataTypeEClass, DataType.class, "DataType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(featureEClass, Feature.class, "Feature", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFeature_Scope(), this.getScopeKind(), "scope", null, 1, 1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFeature_Visibility(), this.getVisibilityKind(), "visibility", null, 1, 1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(multiplicityTypeEClass, MultiplicityType.class, "MultiplicityType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMultiplicityType_Lower(), ecorePackage.getEInt(), "lower", null, 1, 1, MultiplicityType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMultiplicityType_Upper(), ecorePackage.getEInt(), "upper", null, 1, 1, MultiplicityType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMultiplicityType_IsOrdered(), ecorePackage.getEBoolean(), "isOrdered", null, 1, 1, MultiplicityType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMultiplicityType_IsUnique(), ecorePackage.getEBoolean(), "isUnique", null, 1, 1, MultiplicityType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(structuralFeatureEClass, StructuralFeature.class, "StructuralFeature", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStructuralFeature_Multiplicity(), this.getMultiplicityType(), null, "multiplicity", null, 1, 1, StructuralFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStructuralFeature_IsChangeable(), ecorePackage.getEBoolean(), "isChangeable", null, 1, 1, StructuralFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(attributeEClass, Attribute.class, "Attribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAttribute_IsDerived(), ecorePackage.getEBoolean(), "isDerived", null, 1, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(referenceEClass, Reference.class, "Reference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReference_ExposedEnd(), this.getAssociationEnd(), null, "exposedEnd", null, 1, 1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getReference_ReferencedEnd(), this.getAssociationEnd(), null, "referencedEnd", null, 1, 1, Reference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(behavioralFeatureEClass, BehavioralFeature.class, "BehavioralFeature", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(operationEClass, Operation.class, "Operation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOperation_IsQuery(), ecorePackage.getEBoolean(), "isQuery", null, 1, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOperation_Exceptions(), this.getException(), null, "exceptions", null, 0, -1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(exceptionEClass, com.sap.tc.moin.repository.mmi.Model.Exception.class, "Exception", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(associationEClass, Association.class, "Association", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAssociation_IsDerived(), ecorePackage.getEBoolean(), "isDerived", null, 1, 1, Association.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(associationEndEClass, AssociationEnd.class, "AssociationEnd", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAssociationEnd_IsNavigable(), ecorePackage.getEBoolean(), "isNavigable", null, 1, 1, AssociationEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getAssociationEnd_Aggregation(), this.getAggregationKind(), "aggregation", null, 1, 1, AssociationEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAssociationEnd_Multiplicity(), this.getMultiplicityType(), null, "multiplicity", null, 1, 1, AssociationEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getAssociationEnd_IsChangeable(), ecorePackage.getEBoolean(), "isChangeable", null, 1, 1, AssociationEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		addEOperation(associationEndEClass, this.getAssociationEnd(), "otherEnd", 1, 1, !IS_UNIQUE, !IS_ORDERED);

		initEClass(packageEClass, com.sap.tc.moin.repository.mmi.Model.Package.class, "Package", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(importEClass, Import.class, "Import", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImport_Visibility(), this.getVisibilityKind(), "visibility", null, 1, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getImport_IsClustered(), ecorePackage.getEBoolean(), "isClustered", null, 1, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getImport_ImportedNamespace(), this.getNamespace(), null, "importedNamespace", null, 1, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(parameterEClass, Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParameter_Direction(), this.getDirectionKind(), "direction", null, 1, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getParameter_Multiplicity(), this.getMultiplicityType(), null, "multiplicity", null, 1, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(constraintEClass, Constraint.class, "Constraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConstraint_Expression(), ecorePackage.getEString(), "expression", null, 1, 1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getConstraint_Language(), ecorePackage.getEString(), "language", null, 1, 1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getConstraint_EvaluationPolicy(), ecorePackage.getEString(), "evaluationPolicy", null, 1, 1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getConstraint_ConstrainedElements(), this.getModelElement(), this.getModelElement_Constraints(), "constrainedElements", null, 1, -1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(constantEClass, Constant.class, "Constant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConstant_Value(), ecorePackage.getEString(), "value", null, 1, 1, Constant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(tagEClass, Tag.class, "Tag", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTag_TagId(), ecorePackage.getEString(), "tagId", null, 1, 1, Tag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getTag_Values(), ecorePackage.getEString(), "values", null, 0, -1, Tag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTag_Elements(), this.getModelElement(), null, "elements", null, 1, -1, Tag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(primitiveTypeEClass, PrimitiveType.class, "PrimitiveType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(structureTypeEClass, StructureType.class, "StructureType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(enumerationTypeEClass, EnumerationType.class, "EnumerationType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEnumerationType_Labels(), ecorePackage.getEString(), "labels", null, 1, -1, EnumerationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(aliasTypeEClass, AliasType.class, "AliasType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(structureFieldEClass, StructureField.class, "StructureField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(collectionTypeEClass, CollectionType.class, "CollectionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCollectionType_Multiplicity(), this.getMultiplicityType(), null, "multiplicity", null, 1, 1, CollectionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(visibilityKindEEnum, VisibilityKind.class, "VisibilityKind");
		addEEnumLiteral(visibilityKindEEnum, VisibilityKind.PUBLIC_VIS);
		addEEnumLiteral(visibilityKindEEnum, VisibilityKind.PROTECTED_VIS);
		addEEnumLiteral(visibilityKindEEnum, VisibilityKind.PRIVATE_VIS);

		initEEnum(scopeKindEEnum, ScopeKind.class, "ScopeKind");
		addEEnumLiteral(scopeKindEEnum, ScopeKind.INSTANCE_LEVEL);
		addEEnumLiteral(scopeKindEEnum, ScopeKind.CLASSIFIER_LEVEL);

		initEEnum(aggregationKindEEnum, AggregationKind.class, "AggregationKind");
		addEEnumLiteral(aggregationKindEEnum, AggregationKind.NONE);
		addEEnumLiteral(aggregationKindEEnum, AggregationKind.SHARED);
		addEEnumLiteral(aggregationKindEEnum, AggregationKind.COMPOSITE);

		initEEnum(directionKindEEnum, DirectionKind.class, "DirectionKind");
		addEEnumLiteral(directionKindEEnum, DirectionKind.IN_DIR);
		addEEnumLiteral(directionKindEEnum, DirectionKind.OUT_DIR);
		addEEnumLiteral(directionKindEEnum, DirectionKind.INOUT_DIR);
		addEEnumLiteral(directionKindEEnum, DirectionKind.RETURN_DIR);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://sap.com/MOIN
		createMOINAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://sap.com/MOIN</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createMOINAnnotations() {
		String source = "http://sap.com/MOIN";		
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "Model.DependsOn", "//ModelElement/requiredElements",
			 "Model.Contains", "//Namespace/contents",
			 "Model.Constrains", "//Constraint/constrainedElements",
			 "Model.Generalizes", "//GeneralizableElement/supertypes",
			 "Model.IsOfType", "//TypedElement/type",
			 "Model.Class", "//Class",
			 "Model.MultiplicityType", "//MultiplicityType",
			 "Model.Attribute", "//Attribute",
			 "Model.Reference", "//Reference",
			 "Model.Exposes", "//Reference/exposedEnd",
			 "Model.RefersTo", "//Reference/referencedEnd",
			 "Model.Operation", "//Operation",
			 "Model.CanRaise", "//Operation/exceptions",
			 "Model.Exception", "//Exception",
			 "Model.Association", "//Association",
			 "Model.AssociationEnd", "//AssociationEnd",
			 "Model.Package", "//Package",
			 "Model.Import", "//Import",
			 "Model.Aliases", "//Import/importedNamespace",
			 "Model.Parameter", "//Parameter",
			 "Model.Constraint", "//Constraint",
			 "Model.Constant", "//Constant",
			 "Model.Tag", "//Tag",
			 "Model.AttachesTo", "//Tag/elements",
			 "Model.PrimitiveType", "//PrimitiveType",
			 "Model.StructureType", "//StructureType",
			 "Model.EnumerationType", "//EnumerationType",
			 "Model.AliasType", "//AliasType",
			 "Model.StructureField", "//StructureField",
			 "Model.CollectionType", "//CollectionType"
		   });		
		addAnnotation
		  (getModelElement_RequiredElements(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "Model.DependsOn",
			 "metaObjectMofId", "45ED2E2942C3DA8923564C501065F240D01C18FB",
			 "storedEnd", "0",
			 "compositeEnd", "-1",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "0"
		   });		
		addAnnotation
		  (getModelElement_Container(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "Model.Contains",
			 "metaObjectMofId", "45ED2E29A15C5D7FDF8D483F1CFA93E430ADEDCC",
			 "storedEnd", "0",
			 "compositeEnd", "0",
			 "orderedEnd", "1",
			 "exposedEndNumber", "1"
		   });		
		addAnnotation
		  (getModelElement_Constraints(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "Model.Constrains",
			 "metaObjectMofId", "45ED2E290BBB4E28BAC041E52E7FE0AD24662FFD",
			 "storedEnd", "0",
			 "compositeEnd", "-1",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "1"
		   });		
		addAnnotation
		  (getNamespace_Contents(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "Model.Contains",
			 "metaObjectMofId", "45ED2E29A15C5D7FDF8D483F1CFA93E430ADEDCC",
			 "storedEnd", "0",
			 "compositeEnd", "0",
			 "orderedEnd", "1",
			 "exposedEndNumber", "0"
		   });		
		addAnnotation
		  (getGeneralizableElement_Supertypes(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "Model.Generalizes",
			 "metaObjectMofId", "45ED2E29EBEA040675924D782BC3C9E3F7C65DCA",
			 "storedEnd", "1",
			 "compositeEnd", "-1",
			 "orderedEnd", "0",
			 "exposedEndNumber", "1"
		   });		
		addAnnotation
		  (getTypedElement_Type(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "Model.IsOfType",
			 "metaObjectMofId", "45ED2E29DA5028C85512452C3856E282A65D065B",
			 "storedEnd", "1",
			 "compositeEnd", "-1",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "1"
		   });		
		addAnnotation
		  (classEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "Model.Class",
			 "metaObjectMofId", "45ED2E29E9B8C271FD484D6E2F52CCB9570C451A",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (multiplicityTypeEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "Model.MultiplicityType",
			 "metaObjectMofId", "45ED2E299F5225CD29E84EB0243ADAA73062CA12",
			 "isStructureType", "true"
		   });		
		addAnnotation
		  (getStructuralFeature_Multiplicity(), 
		   source, 
		   new String[] {
			 "ovaMofId", "45ED2E29E564ECD211A1449105FDCEEB38C6634A"
		   });		
		addAnnotation
		  (attributeEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "Model.Attribute",
			 "metaObjectMofId", "45ED2E29726BF05A1AA847C8298F93D7745C3BFB",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (referenceEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "Model.Reference",
			 "metaObjectMofId", "45ED2E2927D6234A5FEB4A9136C380ABBE1B3593",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (getReference_ExposedEnd(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "Model.Exposes",
			 "metaObjectMofId", "45ED2E29192FDBB8BCE642AC2DE4C73FB0EB657F",
			 "storedEnd", "0",
			 "compositeEnd", "-1",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "0"
		   });		
		addAnnotation
		  (getReference_ReferencedEnd(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "Model.RefersTo",
			 "metaObjectMofId", "45ED2E2935733359781E47111E31E56279382F75",
			 "storedEnd", "0",
			 "compositeEnd", "-1",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "0"
		   });		
		addAnnotation
		  (operationEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "Model.Operation",
			 "metaObjectMofId", "45ED2E2948001DB42F8D441738FBAFABABE65AA3",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (getOperation_Exceptions(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "Model.CanRaise",
			 "metaObjectMofId", "45ED2E29DA34D1C256274702244395A0C00735CF",
			 "storedEnd", "0",
			 "compositeEnd", "-1",
			 "orderedEnd", "1",
			 "exposedEndNumber", "0"
		   });		
		addAnnotation
		  (exceptionEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "Model.Exception",
			 "metaObjectMofId", "45ED2E2917FC03460E674B3C2CE48DD24D503C87",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (associationEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "Model.Association",
			 "metaObjectMofId", "45ED2E293423E542EE1D4C2F09318449887E2FCC",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (associationEndEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "Model.AssociationEnd",
			 "metaObjectMofId", "45ED2E294D5F42A5B94C462B13F4F76DE1C16DBF",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (getAssociationEnd_Multiplicity(), 
		   source, 
		   new String[] {
			 "ovaMofId", "45ED2E29C7FBD27A2BCB41EE3695E4606F8C01E9"
		   });		
		addAnnotation
		  (packageEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "Model.Package",
			 "metaObjectMofId", "45ED2E2925D14D728A6546C630BDE3FB4BDA77C3",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (importEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "Model.Import",
			 "metaObjectMofId", "45ED2E29372BCE32CB9241CD1FB9E2F08880B940",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (getImport_ImportedNamespace(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "Model.Aliases",
			 "metaObjectMofId", "45ED2E297C6E4C4F64E543CC20E2ED5F34992C72",
			 "storedEnd", "0",
			 "compositeEnd", "-1",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "0"
		   });		
		addAnnotation
		  (parameterEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "Model.Parameter",
			 "metaObjectMofId", "45ED2E29A900062A80A049E01ED7EBBBCB1ECB46",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (getParameter_Multiplicity(), 
		   source, 
		   new String[] {
			 "ovaMofId", "45ED2E29DFC4906A7103466E07DE9423EFE4A909"
		   });		
		addAnnotation
		  (constraintEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "Model.Constraint",
			 "metaObjectMofId", "45ED2E295D0743E18F8045991708E8A92C8F47B3",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (getConstraint_ConstrainedElements(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "Model.Constrains",
			 "metaObjectMofId", "45ED2E290BBB4E28BAC041E52E7FE0AD24662FFD",
			 "storedEnd", "0",
			 "compositeEnd", "-1",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "0"
		   });		
		addAnnotation
		  (constantEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "Model.Constant",
			 "metaObjectMofId", "45ED2E29050B855406AE42C81E9EA97E02EFA276",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (tagEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "Model.Tag",
			 "metaObjectMofId", "45ED2E29545D7A2836A940A93CC3A3E5E8010D2D",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (getTag_Elements(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "Model.AttachesTo",
			 "metaObjectMofId", "45ED2E29092EBA89637D4A76065DC0F48C45219D",
			 "storedEnd", "1",
			 "compositeEnd", "-1",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "1"
		   });		
		addAnnotation
		  (primitiveTypeEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "Model.PrimitiveType",
			 "metaObjectMofId", "45ED2E29173C68FD5A6C4BF42864A453CFA3A06A",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (structureTypeEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "Model.StructureType",
			 "metaObjectMofId", "45ED2E298D5E991960034F400D80DA4E826005D8",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (enumerationTypeEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "Model.EnumerationType",
			 "metaObjectMofId", "45ED2E298AE1492A468A47C708BCEF140B9DFA3F",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (aliasTypeEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "Model.AliasType",
			 "metaObjectMofId", "45ED2E296B2DEAF0EEDF46AB1F1CEED41B59E942",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (structureFieldEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "Model.StructureField",
			 "metaObjectMofId", "45ED2E29BE383680B04644141089C76967789B2A",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (collectionTypeEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "Model.CollectionType",
			 "metaObjectMofId", "E07A6DE164E626510A3611DEB84F0019993BA221",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (getCollectionType_Multiplicity(), 
		   source, 
		   new String[] {
			 "ovaMofId", "E07A6DE164E626500A3611DEB6450019993BA221"
		   });
	}

} //ModelPackageImpl
