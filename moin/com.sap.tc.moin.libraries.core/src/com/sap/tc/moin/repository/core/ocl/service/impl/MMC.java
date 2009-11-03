package com.sap.tc.moin.repository.core.ocl.service.impl;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>ClassContainmentRules_XMSG: A Class may contain only Classes, DataTypes, Attributes, References, Operations, Exceptions, Constants, OclConstraints, Constraints, and Tags (Constraint {0})</li>
 * <li>AbstractClassesCannotBeSingleton_XMSG: A Class that is marked as abstract cannot also be marked as singleton (Constraint {0})</li>
 * <li>ConstraintsLimitedToContainer_XMSG: A Constraint can only constrain ModelElements that are defined by or inherited by its immediate container (Constraint {0})</li>
 * <li>DataTypesCannotBeAbstract_XMSG: A DataType cannot be abstract (Constraint {0})</li>
 * <li>DataTypeContainmentRules_XMSG: A DataType may contain only TypeAliases, Constraints, Tags; StructureTypes may also contain StructureFields, TupleTypes may contain Attributes (Constraint {0})</li>
 * <li>SupertypeMustNotBeSelf_XMSG: A Generalizable Element cannot be its own direct or indirect supertype (Constraint {0})</li>
 * <li>NoSubtypesAllowedForLeaf_XMSG: A GeneralizableElement cannot inherit from a GeneralizableElement defined as a "leaf" (Constraint {0})</li>
 * <li>MustBeContainedUnlessPackage_XMSG: A ModelElement that is not a Package must have a container (Constraint {0})</li>
 * <li>PackageContainmentRules_XMSG: A Package may only contain Packages, Classes, DataTypes, Associations, Exceptions, Constants, OclConstraints, Constraints, Imports, OclExpressions, VariableDeclarations, and Tags (Constraint {0})</li>
 * <li>ChangeableReferenceMustHaveChangeableEnd_XMSG: A Reference can be changeable only if the referenced AssociationEnd is also changeable (Constraint {0})</li>
 * <li>ReferencedEndMustBeNavigable_XMSG: A Reference is only allowed for a navigable AssociationEnd (Constraint {0})</li>
 * <li>StructureFieldContainmentRules_XMSG: A StructureField contains Constraints and Tags (Constraint {0})</li>
 * <li>StructureFieldsCannotBeObjectValued_XMSG: A StructureField must not be object valued (Constraint {0})</li>
 * <li>MustHaveFields_XMSG: A StructureType must contain at least one StructureField (Constraint {0})</li>
 * <li>FrozenElementsCannotBeDeleted_XMSG: A frozen ModelElement which is in a frozen Namespace can only be deleted, by deleting the Namespace (Constraint {0})</li>
 * <li>ExceptionsHaveOnlyOutParameters_XMSG: All Parameters of an Exception must all have direction "out" (Constraint {0})</li>
 * <li>SupertypeKindMustBeSame_XMSG: All supertypes of a GeneralizableElement must be of the same OCL type as the GeneralizableElement itself (Constraint {0})</li>
 * <li>AssociationsCannotBeAbstract_XMSG: An Association cannot be abstract (Constraint {0})</li>
 * <li>AssociationsCannotBeTypes_XMSG: An Association cannot be the type of a TypedElement (Constraint {0})</li>
 * <li>CannotHaveTwoAggregateEnds_XMSG: An Association cannot have aggregation semantic specified for both AssociationEnds (Constraint {0})</li>
 * <li>CannotHaveTwoOrderedEnds_XMSG: An Association cannot have both AssociationEnds marked as "ordered" (Constraint {0})</li>
 * <li>AssociationContainmentRules_XMSG: An Association may only contain AssociationEnds, Constraints, and Tags (Constraint {0})</li>
 * <li>AssociationsMustBeBinary_XMSG: An Association must have exactly two AssociationEnds (Constraint {0})</li>
 * <li>ExceptionContainmentRules_XMSG: An Exception may only contain Parameters and Tags (Constraint {0})</li>
 * <li>OperationsHaveAtMostOneReturn_XMSG: An Operation may have at most one Parameter whose direction is "return" (Constraint {0})</li>
 * <li>OperationContainmentRules_XMSG: An Operation may only contain Parameters, Constraints, and Tags (Constraint {0})</li>
 * <li>AssociationsMustBePublic_XMSG: Associations must have visibility of "public" (Constraint {0})</li>
 * <li>DerivedAssocEndsMustMatchChangeability_XMSG: Both association ends of a derived association have to have the same changeability (Constraint {0})</li>
 * <li>ReferenceMustBeInstanceScoped_XMSG: Classifier scoped References are not meaningful in the current M1 level computational model (Constraint {0})</li>
 * <li>CannotConstrainThisElement_XMSG: Constraints, Tags, Imports, and Constants cannot be constrained (Constraint {0})</li>
 * <li>NoSupertypesAllowedForRoot_XMSG: If a Generalizable Element is marked as a "root", it cannot have any supertypes (Constraint {0})</li>
 * <li>MustBeUnorderedNonunique_XMSG: If a MultiplicityType specifies bounds of [0..1] or [1..1]), the "is_ordered" and "is_unique" values must be false (Constraint {0})</li>
 * <li>OrderedEndsRequireStorageOnOtherEnd_XMSG: If an AssociationEnd is ordered, then the other end must be stored (Constraint {0})</li>
 * <li>AssociationsHaveNoSupertypes_XMSG: Inheritance / generalization is not applicable to Associations (Constraint {0})</li>
 * <li>DataTypesHaveNoSupertypes_XMSG: Inheritance / generalization is not applicable to DataTypes (Constraint {0})</li>
 * <li>CanOnlyImportPackagesAndClasses_XMSG: It is only legal for a Package to import or cluster Packages or Classes (Constraint {0})</li>
 * <li>AssociationsMustNotBeDerived_XMSG: MOIN does not support derived associations (Constraint {0})</li>
 * <li>AttributesMustNotBeDerived_XMSG: MOIN does not support derived attributes (Constraint {0})</li>
 * <li>AttributesMustNotBeStatic_XMSG: MOIN does not support static attributes (Constraint {0})</li>
 * <li>DiamondRuleMustBeObeyed_XMSG: Multiple inheritance must obey the "Diamond Rule" (Constraint {0})</li>
 * <li>NestedPackagesCannotImport_XMSG: Nested Packages cannot import or cluster other Packages or Classes (Constraint {0})</li>
 * <li>InitializedAttributeUpperBoundsMustBeOne_XMSG: Only attributes which have a multiplicity with an upper bound of one (0..1 or 1..1) can be initialized (Constraint {0})</li>
 * <li>PackagesCannotBeAbstract_XMSG: Packages cannot be declared as abstract (Constraint {0})</li>
 * <li>CannotImportNestedComponents_XMSG: Packages cannot import or cluster Packages or Classes that they contain (Constraint {0})</li>
 * <li>CannotImportSelf_XMSG: Packages cannot import or cluster themselves (Constraint {0})</li>
 * <li>NoSingletonsAllowed_XMSG: Singleton classes are not supported by MOIN (Constraint {0})</li>
 * <li>EndsMustBeUnique_XMSG: The "isUnique" flag in an AssociationEnd''s multiplicity must be true (Constraint {0})</li>
 * <li>LowerCannotExceedUpper_XMSG: The "lower" bound of a MultiplicityType cannot exceed the "upper" bound (Constraint {0})</li>
 * <li>LowerCannotBeNegativeOrUnbounded_XMSG: The "lower" bound of a MultiplicityType to be "Unbounded" (Constraint {0})</li>
 * <li>UpperMustBePositive_XMSG: The "upper" bound of a MultiplicityType cannot be less than 1 (Constraint {0})</li>
 * <li>ExpressionMustBeBoolean_XMSG: The Expression of an OCL Constraint must be of Boolean type (Constraint {0})</li>
 * <li>CompositeAssociationEndsUpperBoundIs1_XMSG: The Multiplicity''s upper bound of a composite AssociationEnd must be 1 (Constraint {0})</li>
 * <li>InitExpressionMustBePrimitiveOrEnumLiteral_XMSG: The OCL expression for an attribute or field initializer must be a PrimitiveLiteral or an EnumLiteral expression (Constraint {0})</li>
 * <li>FrozenAttributesCannotBeChanged_XMSG: The attribute values of a ModelElement which is frozen cannot be changed (Constraint {0})</li>
 * <li>ContainerMustMatchExposedType_XMSG: The containing Class for a Reference must be equal to or a subtype of the type of the Reference''s exposed AssociationEnd (Constraint {0})</li>
 * <li>FrozenDependenciesCannotBeChanged_XMSG: The link sets that express dependencies of a frozen Element on other Elements cannot be explicitly changed (Constraint {0})</li>
 * <li>ReferenceMultiplicityMustMatchEnd_XMSG: The multiplicity for a Reference must be the same as the multiplicity for the referenced AssociationEnd (Constraint {0})</li>
 * <li>StructuralFeatureName_XMSG: The name of a StructuralFeature must not start with two or three underscores (Constraint {0})</li>
 * <li>ContentsMustNotCollideWithSupertypes_XMSG: The names of the contents of a GeneralizableElement should not collide with the names of the contents of any direct or indirect supertype (Constraint {0})</li>
 * <li>ContentNamesMustNotCollide_XMSG: The names of the contents of a Namespace must not collide (Constraint {0})</li>
 * <li>ReferenceTypeMustMatchEndType_XMSG: The type attribute of a Reference and its referenced AssociationEnd must be the same (Constraint {0})</li>
 * <li>ConstantsValueMustMatchType_XMSG: The type of a Constant and its value must be compatible (Constraint {0})</li>
 * <li>ConstantsTypeMustBePrimitive_XMSG: The type of a Constant must be a PrimitiveType (Constraint {0})</li>
 * <li>EndTypeMustBeClass_XMSG: The type of an AssociationEnd must be Class (Constraint {0})</li>
 * <li>AssociationMustBeRootAndLeaf_XMSG: The values for "isLeaf" and "isRoot" on an Association must be true (Constraint {0})</li>
 * <li>DataTypeMustBeRootAndLeaf_XMSG: The values for "isLeaf" and "isRoot" on an DataType must be true (Constraint {0})</li>
 * <li>PackageMustBeRootAndLeaf_XMSG: The values for "isLeaf" and "isRoot" on an Package must be true (Constraint {0})</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from MMC.properties
 */
 
public enum MMC implements MoinLocalizedString {


    /**
     * Message: "A Class that is marked as abstract cannot also be marked as singleton (Constraint {0})"
     */
    ABSTRACTCLASSESCANNOTBESINGLETON("AbstractClassesCannotBeSingleton_XMSG"), //$NON-NLS-1$

    /**
     * Message: "An Association may only contain AssociationEnds, Constraints, and Tags (Constraint {0})"
     */
    ASSOCIATIONCONTAINMENTRULES("AssociationContainmentRules_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The values for "isLeaf" and "isRoot" on an Association must be true (Constraint {0})"
     */
    ASSOCIATIONMUSTBEROOTANDLEAF("AssociationMustBeRootAndLeaf_XMSG"), //$NON-NLS-1$

    /**
     * Message: "An Association cannot be abstract (Constraint {0})"
     */
    ASSOCIATIONSCANNOTBEABSTRACT("AssociationsCannotBeAbstract_XMSG"), //$NON-NLS-1$

    /**
     * Message: "An Association cannot be the type of a TypedElement (Constraint {0})"
     */
    ASSOCIATIONSCANNOTBETYPES("AssociationsCannotBeTypes_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Inheritance / generalization is not applicable to Associations (Constraint {0})"
     */
    ASSOCIATIONSHAVENOSUPERTYPES("AssociationsHaveNoSupertypes_XMSG"), //$NON-NLS-1$

    /**
     * Message: "An Association must have exactly two AssociationEnds (Constraint {0})"
     */
    ASSOCIATIONSMUSTBEBINARY("AssociationsMustBeBinary_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Associations must have visibility of "public" (Constraint {0})"
     */
    ASSOCIATIONSMUSTBEPUBLIC("AssociationsMustBePublic_XMSG"), //$NON-NLS-1$

    /**
     * Message: "MOIN does not support derived associations (Constraint {0})"
     */
    ASSOCIATIONSMUSTNOTBEDERIVED("AssociationsMustNotBeDerived_XMSG"), //$NON-NLS-1$

    /**
     * Message: "MOIN does not support derived attributes (Constraint {0})"
     */
    ATTRIBUTESMUSTNOTBEDERIVED("AttributesMustNotBeDerived_XMSG"), //$NON-NLS-1$

    /**
     * Message: "MOIN does not support static attributes (Constraint {0})"
     */
    ATTRIBUTESMUSTNOTBESTATIC("AttributesMustNotBeStatic_XMSG"), //$NON-NLS-1$

    /**
     * Message: "It is only legal for a Package to import or cluster Packages or Classes (Constraint {0})"
     */
    CANONLYIMPORTPACKAGESANDCLASSES("CanOnlyImportPackagesAndClasses_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Constraints, Tags, Imports, and Constants cannot be constrained (Constraint {0})"
     */
    CANNOTCONSTRAINTHISELEMENT("CannotConstrainThisElement_XMSG"), //$NON-NLS-1$

    /**
     * Message: "An Association cannot have aggregation semantic specified for both AssociationEnds (Constraint {0})"
     */
    CANNOTHAVETWOAGGREGATEENDS("CannotHaveTwoAggregateEnds_XMSG"), //$NON-NLS-1$

    /**
     * Message: "An Association cannot have both AssociationEnds marked as "ordered" (Constraint {0})"
     */
    CANNOTHAVETWOORDEREDENDS("CannotHaveTwoOrderedEnds_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Packages cannot import or cluster Packages or Classes that they contain (Constraint {0})"
     */
    CANNOTIMPORTNESTEDCOMPONENTS("CannotImportNestedComponents_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Packages cannot import or cluster themselves (Constraint {0})"
     */
    CANNOTIMPORTSELF("CannotImportSelf_XMSG"), //$NON-NLS-1$

    /**
     * Message: "A Reference can be changeable only if the referenced AssociationEnd is also changeable (Constraint {0})"
     */
    CHANGEABLEREFERENCEMUSTHAVECHANGEABLEEND("ChangeableReferenceMustHaveChangeableEnd_XMSG"), //$NON-NLS-1$

    /**
     * Message: "A Class may contain only Classes, DataTypes, Attributes, References, Operations, Exceptions, Constants, OclConstraints, Constraints, and Tags (Constraint {0})"
     */
    CLASSCONTAINMENTRULES("ClassContainmentRules_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The Multiplicity''s upper bound of a composite AssociationEnd must be 1 (Constraint {0})"
     */
    COMPOSITEASSOCIATIONENDSUPPERBOUNDIS1("CompositeAssociationEndsUpperBoundIs1_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The type of a Constant must be a PrimitiveType (Constraint {0})"
     */
    CONSTANTSTYPEMUSTBEPRIMITIVE("ConstantsTypeMustBePrimitive_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The type of a Constant and its value must be compatible (Constraint {0})"
     */
    CONSTANTSVALUEMUSTMATCHTYPE("ConstantsValueMustMatchType_XMSG"), //$NON-NLS-1$

    /**
     * Message: "A Constraint can only constrain ModelElements that are defined by or inherited by its immediate container (Constraint {0})"
     */
    CONSTRAINTSLIMITEDTOCONTAINER("ConstraintsLimitedToContainer_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The containing Class for a Reference must be equal to or a subtype of the type of the Reference''s exposed AssociationEnd (Constraint {0})"
     */
    CONTAINERMUSTMATCHEXPOSEDTYPE("ContainerMustMatchExposedType_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The names of the contents of a Namespace must not collide (Constraint {0})"
     */
    CONTENTNAMESMUSTNOTCOLLIDE("ContentNamesMustNotCollide_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The names of the contents of a GeneralizableElement should not collide with the names of the contents of any direct or indirect supertype (Constraint {0})"
     */
    CONTENTSMUSTNOTCOLLIDEWITHSUPERTYPES("ContentsMustNotCollideWithSupertypes_XMSG"), //$NON-NLS-1$

    /**
     * Message: "A DataType may contain only TypeAliases, Constraints, Tags; StructureTypes may also contain StructureFields, TupleTypes may contain Attributes (Constraint {0})"
     */
    DATATYPECONTAINMENTRULES("DataTypeContainmentRules_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The values for "isLeaf" and "isRoot" on an DataType must be true (Constraint {0})"
     */
    DATATYPEMUSTBEROOTANDLEAF("DataTypeMustBeRootAndLeaf_XMSG"), //$NON-NLS-1$

    /**
     * Message: "A DataType cannot be abstract (Constraint {0})"
     */
    DATATYPESCANNOTBEABSTRACT("DataTypesCannotBeAbstract_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Inheritance / generalization is not applicable to DataTypes (Constraint {0})"
     */
    DATATYPESHAVENOSUPERTYPES("DataTypesHaveNoSupertypes_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Both association ends of a derived association have to have the same changeability (Constraint {0})"
     */
    DERIVEDASSOCENDSMUSTMATCHCHANGEABILITY("DerivedAssocEndsMustMatchChangeability_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Multiple inheritance must obey the "Diamond Rule" (Constraint {0})"
     */
    DIAMONDRULEMUSTBEOBEYED("DiamondRuleMustBeObeyed_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The type of an AssociationEnd must be Class (Constraint {0})"
     */
    ENDTYPEMUSTBECLASS("EndTypeMustBeClass_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The "isUnique" flag in an AssociationEnd''s multiplicity must be true (Constraint {0})"
     */
    ENDSMUSTBEUNIQUE("EndsMustBeUnique_XMSG"), //$NON-NLS-1$

    /**
     * Message: "An Exception may only contain Parameters and Tags (Constraint {0})"
     */
    EXCEPTIONCONTAINMENTRULES("ExceptionContainmentRules_XMSG"), //$NON-NLS-1$

    /**
     * Message: "All Parameters of an Exception must all have direction "out" (Constraint {0})"
     */
    EXCEPTIONSHAVEONLYOUTPARAMETERS("ExceptionsHaveOnlyOutParameters_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The Expression of an OCL Constraint must be of Boolean type (Constraint {0})"
     */
    EXPRESSIONMUSTBEBOOLEAN("ExpressionMustBeBoolean_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The attribute values of a ModelElement which is frozen cannot be changed (Constraint {0})"
     */
    FROZENATTRIBUTESCANNOTBECHANGED("FrozenAttributesCannotBeChanged_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The link sets that express dependencies of a frozen Element on other Elements cannot be explicitly changed (Constraint {0})"
     */
    FROZENDEPENDENCIESCANNOTBECHANGED("FrozenDependenciesCannotBeChanged_XMSG"), //$NON-NLS-1$

    /**
     * Message: "A frozen ModelElement which is in a frozen Namespace can only be deleted, by deleting the Namespace (Constraint {0})"
     */
    FROZENELEMENTSCANNOTBEDELETED("FrozenElementsCannotBeDeleted_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The OCL expression for an attribute or field initializer must be a PrimitiveLiteral or an EnumLiteral expression (Constraint {0})"
     */
    INITEXPRESSIONMUSTBEPRIMITIVEORENUMLITERAL("InitExpressionMustBePrimitiveOrEnumLiteral_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Only attributes which have a multiplicity with an upper bound of one (0..1 or 1..1) can be initialized (Constraint {0})"
     */
    INITIALIZEDATTRIBUTEUPPERBOUNDSMUSTBEONE("InitializedAttributeUpperBoundsMustBeOne_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The "lower" bound of a MultiplicityType to be "Unbounded" (Constraint {0})"
     */
    LOWERCANNOTBENEGATIVEORUNBOUNDED("LowerCannotBeNegativeOrUnbounded_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The "lower" bound of a MultiplicityType cannot exceed the "upper" bound (Constraint {0})"
     */
    LOWERCANNOTEXCEEDUPPER("LowerCannotExceedUpper_XMSG"), //$NON-NLS-1$

    /**
     * Message: "A ModelElement that is not a Package must have a container (Constraint {0})"
     */
    MUSTBECONTAINEDUNLESSPACKAGE("MustBeContainedUnlessPackage_XMSG"), //$NON-NLS-1$

    /**
     * Message: "If a MultiplicityType specifies bounds of [0..1] or [1..1]), the "is_ordered" and "is_unique" values must be false (Constraint {0})"
     */
    MUSTBEUNORDEREDNONUNIQUE("MustBeUnorderedNonunique_XMSG"), //$NON-NLS-1$

    /**
     * Message: "A StructureType must contain at least one StructureField (Constraint {0})"
     */
    MUSTHAVEFIELDS("MustHaveFields_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Nested Packages cannot import or cluster other Packages or Classes (Constraint {0})"
     */
    NESTEDPACKAGESCANNOTIMPORT("NestedPackagesCannotImport_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Singleton classes are not supported by MOIN (Constraint {0})"
     */
    NOSINGLETONSALLOWED("NoSingletonsAllowed_XMSG"), //$NON-NLS-1$

    /**
     * Message: "A GeneralizableElement cannot inherit from a GeneralizableElement defined as a "leaf" (Constraint {0})"
     */
    NOSUBTYPESALLOWEDFORLEAF("NoSubtypesAllowedForLeaf_XMSG"), //$NON-NLS-1$

    /**
     * Message: "If a Generalizable Element is marked as a "root", it cannot have any supertypes (Constraint {0})"
     */
    NOSUPERTYPESALLOWEDFORROOT("NoSupertypesAllowedForRoot_XMSG"), //$NON-NLS-1$

    /**
     * Message: "An Operation may only contain Parameters, Constraints, and Tags (Constraint {0})"
     */
    OPERATIONCONTAINMENTRULES("OperationContainmentRules_XMSG"), //$NON-NLS-1$

    /**
     * Message: "An Operation may have at most one Parameter whose direction is "return" (Constraint {0})"
     */
    OPERATIONSHAVEATMOSTONERETURN("OperationsHaveAtMostOneReturn_XMSG"), //$NON-NLS-1$

    /**
     * Message: "If an AssociationEnd is ordered, then the other end must be stored (Constraint {0})"
     */
    ORDEREDENDSREQUIRESTORAGEONOTHEREND("OrderedEndsRequireStorageOnOtherEnd_XMSG"), //$NON-NLS-1$

    /**
     * Message: "A Package may only contain Packages, Classes, DataTypes, Associations, Exceptions, Constants, OclConstraints, Constraints, Imports, OclExpressions, VariableDeclarations, and Tags (Constraint {0})"
     */
    PACKAGECONTAINMENTRULES("PackageContainmentRules_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The values for "isLeaf" and "isRoot" on an Package must be true (Constraint {0})"
     */
    PACKAGEMUSTBEROOTANDLEAF("PackageMustBeRootAndLeaf_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Packages cannot be declared as abstract (Constraint {0})"
     */
    PACKAGESCANNOTBEABSTRACT("PackagesCannotBeAbstract_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The multiplicity for a Reference must be the same as the multiplicity for the referenced AssociationEnd (Constraint {0})"
     */
    REFERENCEMULTIPLICITYMUSTMATCHEND("ReferenceMultiplicityMustMatchEnd_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Classifier scoped References are not meaningful in the current M1 level computational model (Constraint {0})"
     */
    REFERENCEMUSTBEINSTANCESCOPED("ReferenceMustBeInstanceScoped_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The type attribute of a Reference and its referenced AssociationEnd must be the same (Constraint {0})"
     */
    REFERENCETYPEMUSTMATCHENDTYPE("ReferenceTypeMustMatchEndType_XMSG"), //$NON-NLS-1$

    /**
     * Message: "A Reference is only allowed for a navigable AssociationEnd (Constraint {0})"
     */
    REFERENCEDENDMUSTBENAVIGABLE("ReferencedEndMustBeNavigable_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The name of a StructuralFeature must not start with two or three underscores (Constraint {0})"
     */
    STRUCTURALFEATURENAME("StructuralFeatureName_XMSG"), //$NON-NLS-1$

    /**
     * Message: "A StructureField contains Constraints and Tags (Constraint {0})"
     */
    STRUCTUREFIELDCONTAINMENTRULES("StructureFieldContainmentRules_XMSG"), //$NON-NLS-1$

    /**
     * Message: "A StructureField must not be object valued (Constraint {0})"
     */
    STRUCTUREFIELDSCANNOTBEOBJECTVALUED("StructureFieldsCannotBeObjectValued_XMSG"), //$NON-NLS-1$

    /**
     * Message: "All supertypes of a GeneralizableElement must be of the same OCL type as the GeneralizableElement itself (Constraint {0})"
     */
    SUPERTYPEKINDMUSTBESAME("SupertypeKindMustBeSame_XMSG"), //$NON-NLS-1$

    /**
     * Message: "A Generalizable Element cannot be its own direct or indirect supertype (Constraint {0})"
     */
    SUPERTYPEMUSTNOTBESELF("SupertypeMustNotBeSelf_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The "upper" bound of a MultiplicityType cannot be less than 1 (Constraint {0})"
     */
    UPPERMUSTBEPOSITIVE("UpperMustBePositive_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( MMC.class );

    private final String myKey;

    private MMC( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + MMC.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  