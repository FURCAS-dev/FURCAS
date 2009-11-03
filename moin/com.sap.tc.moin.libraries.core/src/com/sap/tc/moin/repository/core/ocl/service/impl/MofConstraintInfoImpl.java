package com.sap.tc.moin.repository.core.ocl.service.impl;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Constraint;
import com.sap.tc.moin.repository.mmi.model.EvaluationKindEnum;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.ocl.freestyle.OclRegistrationType;
import com.sap.tc.moin.repository.ocl.metamodel.OclMetaModelConstraintRegistration;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationCategory;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationSeverity;

/**
 * The OclMetaModelConstraintRegistration implementation
 */
public class MofConstraintInfoImpl implements OclMetaModelConstraintRegistration {

    private final static Map<String, MoinLocalizedString> contextNamesToMessages = new HashMap<String, MoinLocalizedString>( );

    private final static Map<String, String> contextNamesToIds = new HashMap<String, String>( );

    private final static Set<String> warnings = new HashSet<String>( );

    private final Constraint constraint;

    private final Set<String> constrainedElements;

    private final String name;

    private final Set<String> categories = new HashSet<String>( );

    private String message;

    private Locale lastLocale;

    static {
        // contextNamesToIds.put("<Placeholder for a deleted constraint>",
        // "[C-18]");
        contextNamesToMessages.put( "AbstractClassesCannotBeSingleton", MMC.ABSTRACTCLASSESCANNOTBESINGLETON ); //$NON-NLS-1$
        contextNamesToMessages.put( "AssociationContainmentRules", MMC.ASSOCIATIONCONTAINMENTRULES ); //$NON-NLS-1$
        contextNamesToMessages.put( "AssociationMustBeRootAndLeaf", MMC.ASSOCIATIONMUSTBEROOTANDLEAF ); //$NON-NLS-1$
        contextNamesToMessages.put( "AssociationsCannotBeAbstract", MMC.ASSOCIATIONSCANNOTBEABSTRACT ); //$NON-NLS-1$
        contextNamesToMessages.put( "AssociationsCannotBeTypes", MMC.ASSOCIATIONSCANNOTBETYPES ); //$NON-NLS-1$
        contextNamesToMessages.put( "AssociationsHaveNoSupertypes", MMC.ASSOCIATIONSHAVENOSUPERTYPES ); //$NON-NLS-1$
        contextNamesToMessages.put( "AssociationsMustBeBinary", MMC.ASSOCIATIONSMUSTBEBINARY ); //$NON-NLS-1$
        contextNamesToMessages.put( "AssociationsMustBePublic", MMC.ASSOCIATIONSMUSTBEPUBLIC ); //$NON-NLS-1$
        contextNamesToMessages.put( "AssociationsMustNotBeDerived", MMC.ASSOCIATIONSMUSTNOTBEDERIVED ); //$NON-NLS-1$
        contextNamesToMessages.put( "AttributesMustNotBeDerived", MMC.ATTRIBUTESMUSTNOTBEDERIVED ); //$NON-NLS-1$
        contextNamesToMessages.put( "AttributesMustNotBeStatic", MMC.ATTRIBUTESMUSTNOTBESTATIC ); //$NON-NLS-1$
        contextNamesToMessages.put( "CannotConstrainThisElement", MMC.CANNOTCONSTRAINTHISELEMENT ); //$NON-NLS-1$
        contextNamesToMessages.put( "CannotHaveTwoAggregateEnds", MMC.CANNOTHAVETWOAGGREGATEENDS ); //$NON-NLS-1$
        contextNamesToMessages.put( "CannotHaveTwoOrderedEnds", MMC.CANNOTHAVETWOORDEREDENDS ); //$NON-NLS-1$
        contextNamesToMessages.put( "CannotImportNestedComponents", MMC.CANNOTIMPORTNESTEDCOMPONENTS ); //$NON-NLS-1$
        contextNamesToMessages.put( "CannotImportSelf", MMC.CANNOTIMPORTSELF ); //$NON-NLS-1$
        contextNamesToMessages.put( "CanOnlyImportPackagesAndClasses", MMC.CANONLYIMPORTPACKAGESANDCLASSES ); //$NON-NLS-1$
        contextNamesToMessages.put( "ChangeableReferenceMustHaveChangeableEnd", MMC.CHANGEABLEREFERENCEMUSTHAVECHANGEABLEEND ); //$NON-NLS-1$
        contextNamesToMessages.put( "ClassContainmentRules", MMC.CLASSCONTAINMENTRULES ); //$NON-NLS-1$
        contextNamesToMessages.put( "CompositeAssociationEndsUpperBoundIs1", MMC.COMPOSITEASSOCIATIONENDSUPPERBOUNDIS1 ); //$NON-NLS-1$
        contextNamesToMessages.put( "ConstantsTypeMustBePrimitive", MMC.CONSTANTSTYPEMUSTBEPRIMITIVE ); //$NON-NLS-1$
        // TODO C-52 not implemented in OCL
        contextNamesToMessages.put( "ConstantsValueMustMatchType", MMC.CONSTANTSVALUEMUSTMATCHTYPE ); //$NON-NLS-1$
        // TODO C-51 not implemented in OCL
        contextNamesToMessages.put( "ConstraintsLimitedToContainer", MMC.CONSTRAINTSLIMITEDTOCONTAINER ); //$NON-NLS-1$
        contextNamesToMessages.put( "ContainerMustMatchExposedType", MMC.CONTAINERMUSTMATCHEXPOSEDTYPE ); //$NON-NLS-1$
        contextNamesToMessages.put( "ContentNamesMustNotCollide", MMC.CONTENTNAMESMUSTNOTCOLLIDE ); //$NON-NLS-1$
        contextNamesToMessages.put( "ContentsMustNotCollideWithSupertypes", MMC.CONTENTSMUSTNOTCOLLIDEWITHSUPERTYPES ); //$NON-NLS-1$
        contextNamesToMessages.put( "DataTypeContainmentRules", MMC.DATATYPECONTAINMENTRULES ); //$NON-NLS-1$
        contextNamesToMessages.put( "DataTypesCannotBeAbstract", MMC.DATATYPESCANNOTBEABSTRACT ); //$NON-NLS-1$
        contextNamesToMessages.put( "DataTypesHaveNoSupertypes", MMC.DATATYPESHAVENOSUPERTYPES ); //$NON-NLS-1$
        contextNamesToMessages.put( "DataTypeMustBeRootAndLeaf", MMC.DATATYPEMUSTBEROOTANDLEAF ); //$NON-NLS-1$
        contextNamesToMessages.put( "DerivedAssocEndsMustMatchChangeability", MMC.DERIVEDASSOCENDSMUSTMATCHCHANGEABILITY ); //$NON-NLS-1$
        // TODO C-9 not implemented
        contextNamesToMessages.put( "DiamondRuleMustBeObeyed", MMC.DIAMONDRULEMUSTBEOBEYED ); //$NON-NLS-1$
        contextNamesToMessages.put( "EndsMustBeUnique", MMC.ENDSMUSTBEUNIQUE ); //$NON-NLS-1$
        contextNamesToMessages.put( "EndTypeMustBeClass", MMC.ENDTYPEMUSTBECLASS ); //$NON-NLS-1$
        contextNamesToMessages.put( "ExceptionContainmentRules", MMC.EXCEPTIONCONTAINMENTRULES ); //$NON-NLS-1$
        contextNamesToMessages.put( "ExceptionsHaveOnlyOutParameters", MMC.EXCEPTIONSHAVEONLYOUTPARAMETERS ); //$NON-NLS-1$
        contextNamesToMessages.put( "ExpressionMustBeBoolean", MMC.EXPRESSIONMUSTBEBOOLEAN ); //$NON-NLS-1$
        // TODO C-2 not implemented
        contextNamesToMessages.put( "FrozenAttributesCannotBeChanged", MMC.FROZENATTRIBUTESCANNOTBECHANGED ); //$NON-NLS-1$
        // TODO C-4 not implemented
        contextNamesToMessages.put( "FrozenDependenciesCannotBeChanged", MMC.FROZENDEPENDENCIESCANNOTBECHANGED ); //$NON-NLS-1$
        // TODO C-3 not implemented
        contextNamesToMessages.put( "FrozenElementsCannotBeDeleted", MMC.FROZENELEMENTSCANNOTBEDELETED ); //$NON-NLS-1$
        contextNamesToMessages.put( "InitExpressionMustBePrimitiveOrEnumLiteral", MMC.INITEXPRESSIONMUSTBEPRIMITIVEORENUMLITERAL ); //$NON-NLS-1$
        contextNamesToMessages.put( "InitializedAttributeUpperBoundsMustBeOne", MMC.INITIALIZEDATTRIBUTEUPPERBOUNDSMUSTBEONE ); //$NON-NLS-1$
        contextNamesToMessages.put( "LowerCannotBeNegativeOrUnbounded", MMC.LOWERCANNOTBENEGATIVEORUNBOUNDED ); //$NON-NLS-1$
        contextNamesToMessages.put( "LowerCannotExceedUpper", MMC.LOWERCANNOTEXCEEDUPPER ); //$NON-NLS-1$
        contextNamesToMessages.put( "MustBeContainedUnlessPackage", MMC.MUSTBECONTAINEDUNLESSPACKAGE ); //$NON-NLS-1$
        contextNamesToMessages.put( "MustBeUnorderedNonunique", MMC.MUSTBEUNORDEREDNONUNIQUE ); //$NON-NLS-1$
        contextNamesToMessages.put( "MustHaveFields", MMC.MUSTHAVEFIELDS ); //$NON-NLS-1$
        contextNamesToMessages.put( "NestedPackagesCannotImport", MMC.NESTEDPACKAGESCANNOTIMPORT ); //$NON-NLS-1$
        contextNamesToMessages.put( "NoSingletonsAllowed", MMC.NOSINGLETONSALLOWED ); //$NON-NLS-1$
        contextNamesToMessages.put( "NoSubtypesAllowedForLeaf", MMC.NOSUBTYPESALLOWEDFORLEAF ); //$NON-NLS-1$
        contextNamesToMessages.put( "NoSupertypesAllowedForRoot", MMC.NOSUPERTYPESALLOWEDFORROOT ); //$NON-NLS-1$
        contextNamesToMessages.put( "OperationContainmentRules", MMC.OPERATIONCONTAINMENTRULES ); //$NON-NLS-1$
        contextNamesToMessages.put( "OperationsHaveAtMostOneReturn", MMC.OPERATIONSHAVEATMOSTONERETURN ); //$NON-NLS-1$
        contextNamesToMessages.put( "OrderedEndsRequireStorageOnOtherEnd", MMC.ORDEREDENDSREQUIRESTORAGEONOTHEREND ); //$NON-NLS-1$
        contextNamesToMessages.put( "PackageContainmentRules", MMC.PACKAGECONTAINMENTRULES ); //$NON-NLS-1$
        contextNamesToMessages.put( "PackagesCannotBeAbstract", MMC.PACKAGESCANNOTBEABSTRACT ); //$NON-NLS-1$
        contextNamesToMessages.put( "PackageMustBeRootAndLeaf", MMC.PACKAGEMUSTBEROOTANDLEAF ); //$NON-NLS-1$
        contextNamesToMessages.put( "ReferencedEndMustBeNavigable", MMC.REFERENCEDENDMUSTBENAVIGABLE ); //$NON-NLS-1$
        contextNamesToMessages.put( "ReferenceMultiplicityMustMatchEnd", MMC.REFERENCEMULTIPLICITYMUSTMATCHEND ); //$NON-NLS-1$
        contextNamesToMessages.put( "ReferenceMustBeInstanceScoped", MMC.REFERENCEMUSTBEINSTANCESCOPED ); //$NON-NLS-1$
        contextNamesToMessages.put( "ReferenceTypeMustMatchEndType", MMC.REFERENCETYPEMUSTMATCHENDTYPE ); //$NON-NLS-1$
        // TODO C-58 not implemented
        contextNamesToMessages.put( "StructuralFeatureName", MMC.STRUCTURALFEATURENAME ); //$NON-NLS-1$
        contextNamesToMessages.put( "StructureFieldContainmentRules", MMC.STRUCTUREFIELDCONTAINMENTRULES ); //$NON-NLS-1$
        contextNamesToMessages.put( "StructureFieldsCannotBeObjectValued", MMC.STRUCTUREFIELDSCANNOTBEOBJECTVALUED ); //$NON-NLS-1$
        // TODO C-7 not implemented
        contextNamesToMessages.put( "SupertypeKindMustBeSame", MMC.SUPERTYPEKINDMUSTBESAME ); //$NON-NLS-1$
        contextNamesToMessages.put( "SupertypeMustNotBeSelf", MMC.SUPERTYPEMUSTNOTBESELF ); //$NON-NLS-1$
        contextNamesToMessages.put( "UpperMustBePositive", MMC.UPPERMUSTBEPOSITIVE ); //$NON-NLS-1$

        // contextNamesToIds.put("<Placeholder for a deleted constraint>",
        // "[C-18]");
        contextNamesToIds.put( "AbstractClassesCannotBeSingleton", "[C-16]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "AssociationContainmentRules", "[C-33]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "AssociationMustBeRootAndLeaf", "[C-35]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "AssociationsCannotBeAbstract", "[C-36]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "AssociationsCannotBeTypes", "[C-13]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "AssociationsHaveNoSupertypes", "[C-34]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "AssociationsMustBeBinary", "[C-38]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "AssociationsMustBePublic", "[C-37]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "AssociationsMustNotBeDerived", "[MMC-11]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "AttributesMustNotBeDerived", "[MMC-12]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "AttributesMustNotBeStatic", "[MMC-02]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "CannotConstrainThisElement", "[C-50]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "CannotHaveTwoAggregateEnds", "[C-42]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "CannotHaveTwoOrderedEnds", "[C-41]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "CannotImportNestedComponents", "[C-48]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "CannotImportSelf", "[C-47]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "CanOnlyImportPackagesAndClasses", "[C-46]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "ChangeableReferenceMustHaveChangeableEnd", "[C-23]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "ClassContainmentRules", "[C-15]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "CompositeAssociationEndsUpperBoundIs1", "[MMC-05]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "ConstantsTypeMustBePrimitive", "[C-53]" ); //$NON-NLS-1$//$NON-NLS-2$
        // TODO C-52 not implemented in OCL
        contextNamesToIds.put( "ConstantsValueMustMatchType", "[C-52]" ); //$NON-NLS-1$//$NON-NLS-2$
        // TODO C-51 not implemented in OCL
        contextNamesToIds.put( "ConstraintsLimitedToContainer", "[C-51]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "ContainerMustMatchExposedType", "[C-26]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "ContentNamesMustNotCollide", "[C-05]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "ContentsMustNotCollideWithSupertypes", "[C-08]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "DataTypeContainmentRules", "[C-17]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "DataTypesCannotBeAbstract", "[C-20]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "DataTypesHaveNoSupertypes", "[C-19]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "DataTypeMustBeRootAndLeaf", "[MMC-14]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "DerivedAssocEndsMustMatchChangeability", "[MMC-03]" ); //$NON-NLS-1$//$NON-NLS-2$
        // TODO C-9 not implemented
        contextNamesToIds.put( "DiamondRuleMustBeObeyed", "[C-09]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "EndsMustBeUnique", "[C-40]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "EndTypeMustBeClass", "[C-39]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "ExceptionContainmentRules", "[C-31]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "ExceptionsHaveOnlyOutParameters", "[C-32]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "ExpressionMustBeBoolean", "[MMC-06]" ); //$NON-NLS-1$//$NON-NLS-2$
        // TODO C-2 not implemented
        contextNamesToIds.put( "FrozenAttributesCannotBeChanged", "[C-02]" ); //$NON-NLS-1$//$NON-NLS-2$
        // TODO C-4 not implemented
        contextNamesToIds.put( "FrozenDependenciesCannotBeChanged", "[C-04]" ); //$NON-NLS-1$//$NON-NLS-2$
        // TODO C-3 not implemented
        contextNamesToIds.put( "FrozenElementsCannotBeDeleted", "[C-03]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "InitExpressionMustBePrimitiveOrEnumLiteral", "[MMC-15]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "InitializedAttributeUpperBoundsMustBeOne", "[MMC-16]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "LowerCannotBeNegativeOrUnbounded", "[C-54]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "LowerCannotExceedUpper", "[C-55]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "MustBeContainedUnlessPackage", "[C-01]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "MustBeUnorderedNonunique", "[C-57]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "MustHaveFields", "[C-59]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "NestedPackagesCannotImport", "[C-49]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "NoSingletonsAllowed", "[MMC-10]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "NoSubtypesAllowedForLeaf", "[C-12]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "NoSupertypesAllowedForRoot", "[C-10]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "OperationContainmentRules", "[C-28]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "OperationsHaveAtMostOneReturn", "[C-29]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "OrderedEndsRequireStorageOnOtherEnd", "[MMC-07]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "PackageContainmentRules", "[C-43]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "PackagesCannotBeAbstract", "[C-44]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "PackageMustBeRootAndLeaf", "[MMC-13]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "ReferencedEndMustBeNavigable", "[C-25]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "ReferenceMultiplicityMustMatchEnd", "[C-21]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "ReferenceMustBeInstanceScoped", "[C-22]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "ReferenceTypeMustMatchEndType", "[C-24]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "StructuralFeatureName", "[MMC-09]" ); //$NON-NLS-1$//$NON-NLS-2$
        // TODO C-58 not implemented        
        contextNamesToIds.put( "StructureFieldContainmentRules", "[C-58]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "StructureFieldsCannotBeObjectValued", "[MMC-01]" ); //$NON-NLS-1$//$NON-NLS-2$
        // TODO C-7 not implemented
        contextNamesToIds.put( "SupertypeKindMustBeSame", "[C-07]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "SupertypeMustNotBeSelf", "[C-06]" ); //$NON-NLS-1$//$NON-NLS-2$
        contextNamesToIds.put( "UpperMustBePositive", "[C-56]" ); //$NON-NLS-1$//$NON-NLS-2$

        warnings.add( "InitializedAttributeUpperBoundsMustBeOne" ); //$NON-NLS-1$
    }

    /**
     * @param actConstraint the constraint
     * @param actConstrainedElements the elements
     */
    public MofConstraintInfoImpl( Constraint actConstraint, Set<String> actConstrainedElements ) {

        this.constraint = actConstraint;
        this.name = actConstraint.getName( );
        this.constrainedElements = actConstrainedElements;
        if ( actConstraint.getEvaluationPolicy( ).equals( EvaluationKindEnum.IMMEDIATE ) ) {
            this.categories.add( OclRegistrationCategory.immediate.toString( ) );
        } else {
            this.categories.add( OclRegistrationCategory.deferred.toString( ) );
        }
    }

    public OclRegistrationType getType( ) {

        return OclRegistrationType.Invariant;
    }

    public OclRegistrationSeverity getSeverity( ) {

        if ( warnings.contains( this.getName( ) ) ) {
            return OclRegistrationSeverity.Warning;
        }
        return OclRegistrationSeverity.Error;
    }

    public String getOclExpression( ) {

        return this.constraint.getExpression( );
    }

    public String getName( ) {

        return this.name;
    }

    /**
     * @param locale Locale
     * @return the message message
     */
    public synchronized String getMessage( Locale locale ) {

        if ( this.message == null || this.lastLocale == null || ( !locale.equals( this.lastLocale ) ) ) {
            this.lastLocale = locale;
            if ( contextNamesToIds.containsKey( this.name ) ) {
                MoinLocalizedString msgid = contextNamesToMessages.get( this.name );
                String id = contextNamesToIds.get( this.name );
                this.message = MessageFormat.format( msgid.getLocalizedMessage( locale ), id );
            } else {
                this.message = this.name;
            }
        }
        return this.message;
    }

    public Set<String> getCategories( ) {

        return this.categories;
    }

    public List<String> getQualifiedName( ) {

        return this.constraint.getQualifiedName( );
    }

    public Set<String> getConstrainedElements( ) {

        return this.constrainedElements;
    }

    /**
     * For testing mainly
     * 
     * @param name name
     * @return the ID of the constraint registration
     */
    public static String getId( String name ) {

        return contextNamesToIds.get( name );
    }
}
