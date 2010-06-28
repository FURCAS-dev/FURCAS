/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.textblocks.impl;

import com.sap.furcas.metamodel.TCS.TCSPackage;

import com.sap.furcas.metamodel.textblockdefinition.TextblockdefinitionPackage;

import com.sap.furcas.metamodel.textblockdefinition.impl.TextblockdefinitionPackageImpl;

import com.sap.furcas.metamodel.textblocks.AbstractToken;
import com.sap.furcas.metamodel.textblocks.DocumentNode;
import com.sap.furcas.metamodel.textblocks.LexedToken;
import com.sap.furcas.metamodel.textblocks.OmittedToken;
import com.sap.furcas.metamodel.textblocks.TextBlock;
import com.sap.furcas.metamodel.textblocks.TextblocksFactory;
import com.sap.furcas.metamodel.textblocks.TextblocksPackage;
import com.sap.furcas.metamodel.textblocks.UnlexedToken;
import com.sap.furcas.metamodel.textblocks.Version;

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TextblocksPackageImpl extends EPackageImpl implements TextblocksPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass textBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractTokenEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass omittedTokenEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lexedTokenEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unlexedTokenEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum versionEEnum = null;

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
	 * @see com.sap.furcas.metamodel.textblocks.TextblocksPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TextblocksPackageImpl() {
		super(eNS_URI, TextblocksFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link TextblocksPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TextblocksPackage init() {
		if (isInited) return (TextblocksPackage)EPackage.Registry.INSTANCE.getEPackage(TextblocksPackage.eNS_URI);

		// Obtain or create and register package
		TextblocksPackageImpl theTextblocksPackage = (TextblocksPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TextblocksPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TextblocksPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		TCSPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		TextblockdefinitionPackageImpl theTextblockdefinitionPackage = (TextblockdefinitionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TextblockdefinitionPackage.eNS_URI) instanceof TextblockdefinitionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TextblockdefinitionPackage.eNS_URI) : TextblockdefinitionPackage.eINSTANCE);

		// Create package meta-data objects
		theTextblocksPackage.createPackageContents();
		theTextblockdefinitionPackage.createPackageContents();

		// Initialize created meta-data
		theTextblocksPackage.initializePackageContents();
		theTextblockdefinitionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTextblocksPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TextblocksPackage.eNS_URI, theTextblocksPackage);
		return theTextblocksPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTextBlock() {
		return textBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTextBlock_StartRow() {
		return (EAttribute)textBlockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTextBlock_StartColumn() {
		return (EAttribute)textBlockEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTextBlock_EndRow() {
		return (EAttribute)textBlockEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTextBlock_EndColumn() {
		return (EAttribute)textBlockEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTextBlock_Tokens() {
		return (EReference)textBlockEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTextBlock_SubNodes() {
		return (EReference)textBlockEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTextBlock_Type() {
		return (EReference)textBlockEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTextBlock_SubBlocks() {
		return (EReference)textBlockEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTextBlock_ParentAltChoices() {
		return (EAttribute)textBlockEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTextBlock_ElementsInContext() {
		return (EReference)textBlockEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractToken() {
		return abstractTokenEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractToken_Value() {
		return (EAttribute)abstractTokenEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractToken_Lookahead() {
		return (EAttribute)abstractTokenEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractToken_Lookback() {
		return (EAttribute)abstractTokenEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractToken_State() {
		return (EAttribute)abstractTokenEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOmittedToken() {
		return omittedTokenEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLexedToken() {
		return lexedTokenEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnlexedToken() {
		return unlexedTokenEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDocumentNode() {
		return documentNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentNode_Version() {
		return (EAttribute)documentNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentNode_OtherVersions() {
		return (EReference)documentNodeEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentNode_ChildrenChanged() {
		return (EAttribute)documentNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentNode_RelexingNeeded() {
		return (EAttribute)documentNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentNode_Parent() {
		return (EReference)documentNodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentNode_CorrespondingModelElements() {
		return (EReference)documentNodeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentNode_ReferencedElements() {
		return (EReference)documentNodeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentNode_SequenceElement() {
		return (EReference)documentNodeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentNode_Offset() {
		return (EAttribute)documentNodeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentNode_Length() {
		return (EAttribute)documentNodeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getVersion() {
		return versionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextblocksFactory getTextblocksFactory() {
		return (TextblocksFactory)getEFactoryInstance();
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
		textBlockEClass = createEClass(TEXT_BLOCK);
		createEAttribute(textBlockEClass, TEXT_BLOCK__START_ROW);
		createEAttribute(textBlockEClass, TEXT_BLOCK__START_COLUMN);
		createEAttribute(textBlockEClass, TEXT_BLOCK__END_ROW);
		createEAttribute(textBlockEClass, TEXT_BLOCK__END_COLUMN);
		createEReference(textBlockEClass, TEXT_BLOCK__TOKENS);
		createEReference(textBlockEClass, TEXT_BLOCK__SUB_NODES);
		createEReference(textBlockEClass, TEXT_BLOCK__TYPE);
		createEReference(textBlockEClass, TEXT_BLOCK__SUB_BLOCKS);
		createEAttribute(textBlockEClass, TEXT_BLOCK__PARENT_ALT_CHOICES);
		createEReference(textBlockEClass, TEXT_BLOCK__ELEMENTS_IN_CONTEXT);

		abstractTokenEClass = createEClass(ABSTRACT_TOKEN);
		createEAttribute(abstractTokenEClass, ABSTRACT_TOKEN__VALUE);
		createEAttribute(abstractTokenEClass, ABSTRACT_TOKEN__LOOKAHEAD);
		createEAttribute(abstractTokenEClass, ABSTRACT_TOKEN__LOOKBACK);
		createEAttribute(abstractTokenEClass, ABSTRACT_TOKEN__STATE);

		omittedTokenEClass = createEClass(OMITTED_TOKEN);

		lexedTokenEClass = createEClass(LEXED_TOKEN);

		unlexedTokenEClass = createEClass(UNLEXED_TOKEN);

		documentNodeEClass = createEClass(DOCUMENT_NODE);
		createEAttribute(documentNodeEClass, DOCUMENT_NODE__VERSION);
		createEAttribute(documentNodeEClass, DOCUMENT_NODE__CHILDREN_CHANGED);
		createEAttribute(documentNodeEClass, DOCUMENT_NODE__RELEXING_NEEDED);
		createEReference(documentNodeEClass, DOCUMENT_NODE__PARENT);
		createEReference(documentNodeEClass, DOCUMENT_NODE__CORRESPONDING_MODEL_ELEMENTS);
		createEReference(documentNodeEClass, DOCUMENT_NODE__REFERENCED_ELEMENTS);
		createEReference(documentNodeEClass, DOCUMENT_NODE__SEQUENCE_ELEMENT);
		createEAttribute(documentNodeEClass, DOCUMENT_NODE__OFFSET);
		createEAttribute(documentNodeEClass, DOCUMENT_NODE__LENGTH);
		createEReference(documentNodeEClass, DOCUMENT_NODE__OTHER_VERSIONS);

		// Create enums
		versionEEnum = createEEnum(VERSION);
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

		// Obtain other dependent packages
		TextblockdefinitionPackage theTextblockdefinitionPackage = (TextblockdefinitionPackage)EPackage.Registry.INSTANCE.getEPackage(TextblockdefinitionPackage.eNS_URI);
		TCSPackage theTCSPackage = (TCSPackage)EPackage.Registry.INSTANCE.getEPackage(TCSPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		textBlockEClass.getESuperTypes().add(this.getDocumentNode());
		abstractTokenEClass.getESuperTypes().add(this.getDocumentNode());
		omittedTokenEClass.getESuperTypes().add(this.getAbstractToken());
		lexedTokenEClass.getESuperTypes().add(this.getAbstractToken());
		unlexedTokenEClass.getESuperTypes().add(this.getAbstractToken());

		// Initialize classes and features; add operations and parameters
		initEClass(textBlockEClass, TextBlock.class, "TextBlock", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTextBlock_StartRow(), ecorePackage.getEInt(), "startRow", null, 0, 1, TextBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTextBlock_StartColumn(), ecorePackage.getEInt(), "startColumn", null, 0, 1, TextBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTextBlock_EndRow(), ecorePackage.getEInt(), "endRow", null, 0, 1, TextBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTextBlock_EndColumn(), ecorePackage.getEInt(), "endColumn", null, 0, 1, TextBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTextBlock_Tokens(), this.getAbstractToken(), null, "tokens", null, 0, -1, TextBlock.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTextBlock_SubNodes(), this.getDocumentNode(), this.getDocumentNode_Parent(), "subNodes", null, 0, -1, TextBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTextBlock_Type(), theTextblockdefinitionPackage.getTextblockDefinition(), null, "type", null, 0, 1, TextBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTextBlock_SubBlocks(), this.getTextBlock(), null, "subBlocks", null, 0, -1, TextBlock.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getTextBlock_ParentAltChoices(), ecorePackage.getEInt(), "parentAltChoices", null, 0, -1, TextBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTextBlock_ElementsInContext(), ecorePackage.getEObject(), null, "elementsInContext", null, 0, -1, TextBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractTokenEClass, AbstractToken.class, "AbstractToken", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractToken_Value(), ecorePackage.getEString(), "value", null, 0, 1, AbstractToken.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractToken_Lookahead(), ecorePackage.getEInt(), "lookahead", null, 0, 1, AbstractToken.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractToken_Lookback(), ecorePackage.getEInt(), "lookback", null, 0, 1, AbstractToken.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractToken_State(), ecorePackage.getEInt(), "state", null, 0, 1, AbstractToken.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(omittedTokenEClass, OmittedToken.class, "OmittedToken", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(lexedTokenEClass, LexedToken.class, "LexedToken", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(unlexedTokenEClass, UnlexedToken.class, "UnlexedToken", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(documentNodeEClass, DocumentNode.class, "DocumentNode", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDocumentNode_Version(), this.getVersion(), "version", null, 0, 1, DocumentNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentNode_ChildrenChanged(), ecorePackage.getEBoolean(), "childrenChanged", null, 0, 1, DocumentNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentNode_RelexingNeeded(), ecorePackage.getEBoolean(), "relexingNeeded", null, 0, 1, DocumentNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentNode_Parent(), this.getTextBlock(), this.getTextBlock_SubNodes(), "parent", null, 0, 1, DocumentNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentNode_CorrespondingModelElements(), ecorePackage.getEObject(), null, "correspondingModelElements", null, 0, -1, DocumentNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentNode_ReferencedElements(), ecorePackage.getEObject(), null, "referencedElements", null, 0, -1, DocumentNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentNode_SequenceElement(), theTCSPackage.getSequenceElement(), null, "sequenceElement", null, 0, 1, DocumentNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentNode_Offset(), ecorePackage.getEInt(), "offset", null, 0, 1, DocumentNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentNode_Length(), ecorePackage.getEInt(), "length", null, 0, 1, DocumentNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentNode_OtherVersions(), this.getDocumentNode(), null, "otherVersions", null, 0, 2, DocumentNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(versionEEnum, Version.class, "Version");
		addEEnumLiteral(versionEEnum, Version.REFERENCE);
		addEEnumLiteral(versionEEnum, Version.PREVIOUS);
		addEEnumLiteral(versionEEnum, Version.CURRENT);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/ocl/examples/OCL
		createOCLAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/ocl/examples/OCL</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createOCLAnnotations() {
		String source = "http://www.eclipse.org/ocl/examples/OCL";		
		addAnnotation
		  (getTextBlock_Tokens(), 
		   source, 
		   new String[] {
			 "derive", "self.subNodes->(n | n.oclIsTypeOf(textblocks::TextBlock))"
		   });
	}

} //TextblocksPackageImpl
