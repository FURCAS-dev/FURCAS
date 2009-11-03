package com.sap.tc.moin.repository.core.transactions.microtransactionables;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>NoNonDerivedInstanceLevelAttributes_XMSG: Can not create an instance of class "{0}" with the attribute values "{1}". Class "{0}" has no non-derived and instance level attributes</li>
 * <li>CannotCreateInstanceBecauseAttributeNumberMismatch_XMSG: Can not create an instance of class "{0}" with the attribute values "{1}". Class has {2} non-derived instance level attributes, but it was tried to set {3} attributes</li>
 * <li>CannotCreateInstanceOfAbstractClass_XMSG: Can not create an instance of class "{0}", because it is an abstract class. </li>
 * <li>CannotSetAttributeBecauseUpperMultiplicity_XMSG: Can not set attribute "{0}" of class "{1}" with value "{2}" of type "{3}". The attribute has an upper multiplicity of "{4}", but it was tried to set {5} values.</li>
 * <li>CannotSetAttributeWrongType_XMSG: Can not set attribute "{0}" of class "{1}" with value "{2}" of type "{3}". The attribute is multi-valued and ordered. The value has to be of type "{4}", but it is of type {5}</li>
 * <li>CannotSetAttribute_XMSG: Can not set attribute "{0}" of class "{1}" with value "{2}" of type "{3}". The attribute is multi-valued. The value of each element must not be null</li>
 * <li>CannotCompareInstancesComparisonListOutdated_XMSG: Cannot compare instances of the class "{0}" and "{1}". The comparison list for classes is outdated.</li>
 * <li>CouldNotFindEndStorageLinkToDelete_XMSG: Could not find EndStorageLink to delete after creating private copy</li>
 * <li>MriOfElementIsNull_XMSG: MRI of element to assign is null.</li>
 * <li>NewPartitionPriIsNull_XMSG: The new partition PRI is null</li>
 * <li>OldPartitionPriIsNull_XMSG: The old partition PRI is null</li>
 * <li>MoreThanOneLinkForRemoval_XMSG: There is more than one link for implicit removal</li>
 * <li>IndexIsBiggerThanNumberOfElements_XMSG: Tried to remove an element at index "{0}" from the feature "{1}" of class "{2}". Index ({0}) is bigger than the number of elements ({3}) of feature "{1}"</li>
 * <li>AssociationEndAlreadyContainsElement_XMSG: association end "{0}" of association "{1}" already contains this element: {2}</li>
 * <li>AssociationEndHasUpperMultiplicity_XMSG: association end "{0}" of association "{1}" has an upper multiplicity of "{2}"</li>
 * <li>AssociationEndHasWrongType_XMSG: association end "{0}" of association "{1}" has to be of type "{2}", but it is of type {3}</li>
 * <li>AssociationEndsCannotBeNull_XMSG: association ends can not be null</li>
 * <li>AssociationEndsCannotBeSetToNull_XMSG: association ends can not be set to null</li>
 * <li>AssociationEndsHaveToBeChangable_XMSG: both association ends have to be changeable</li>
 * <li>FeatureHasUpperMultiplicity_XMSG: feature "{0}" of class "{1}" has an upper multiplicity of "{2}"</li>
 * <li>FeatureWrongType_XMSG: feature "{0}" of class "{1}" has to be of type "{2}", but it is of type {3}</li>
 * <li>FeatureOfClassIsMultivaluedNoSet_XMSG: feature "{0}" of class "{1}" is a multi-valued attribute, elements of multi-valued attributes can not be set to null</li>
 * <li>MultiValuedAttributesNotSetAsWhole_XMSG: feature "{0}" of class "{1}" is a multi-valued attribute, multi-valued attributes can not be set as a whole</li>
 * <li>FeatureOfClassIsMultivaluedNoAdd_XMSG: feature "{0}" of class "{1}" is a multi-valued attribute, null values can not be added to the elements of multi-valued attributes</li>
 * <li>FeatureOfClassIsMultivaluedNoRemove_XMSG: feature "{0}" of class "{1}" is a multi-valued attribute, null values can not be contained in multi-valued attributes and can therefore not be removed</li>
 * <li>MultiValuedReferencesNotSetAsWhole_XMSG: feature "{0}" of class "{1}" is a multi-valued reference, multi-valued references can not be set as a whole</li>
 * <li>FeatureIsUnique_XMSG: feature "{0}" of class "{1}" is unique</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from MicroTransactionablesMessages.properties
 */
 
public enum MicroTransactionablesMessages implements MoinLocalizedString {


    /**
     * Message: "association end "{0}" of association "{1}" already contains this element: {2}"
     */
    ASSOCIATIONENDALREADYCONTAINSELEMENT("AssociationEndAlreadyContainsElement_XMSG"), //$NON-NLS-1$

    /**
     * Message: "association end "{0}" of association "{1}" has an upper multiplicity of "{2}""
     */
    ASSOCIATIONENDHASUPPERMULTIPLICITY("AssociationEndHasUpperMultiplicity_XMSG"), //$NON-NLS-1$

    /**
     * Message: "association end "{0}" of association "{1}" has to be of type "{2}", but it is of type {3}"
     */
    ASSOCIATIONENDHASWRONGTYPE("AssociationEndHasWrongType_XMSG"), //$NON-NLS-1$

    /**
     * Message: "association ends can not be null"
     */
    ASSOCIATIONENDSCANNOTBENULL("AssociationEndsCannotBeNull_XMSG"), //$NON-NLS-1$

    /**
     * Message: "association ends can not be set to null"
     */
    ASSOCIATIONENDSCANNOTBESETTONULL("AssociationEndsCannotBeSetToNull_XMSG"), //$NON-NLS-1$

    /**
     * Message: "both association ends have to be changeable"
     */
    ASSOCIATIONENDSHAVETOBECHANGABLE("AssociationEndsHaveToBeChangable_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Cannot compare instances of the class "{0}" and "{1}". The comparison list for classes is outdated."
     */
    CANNOTCOMPAREINSTANCESCOMPARISONLISTOUTDATED("CannotCompareInstancesComparisonListOutdated_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Can not create an instance of class "{0}" with the attribute values "{1}". Class has {2} non-derived instance level attributes, but it was tried to set {3} attributes"
     */
    CANNOTCREATEINSTANCEBECAUSEATTRIBUTENUMBERMISMATCH("CannotCreateInstanceBecauseAttributeNumberMismatch_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Can not create an instance of class "{0}", because it is an abstract class. "
     */
    CANNOTCREATEINSTANCEOFABSTRACTCLASS("CannotCreateInstanceOfAbstractClass_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Can not set attribute "{0}" of class "{1}" with value "{2}" of type "{3}". The attribute has an upper multiplicity of "{4}", but it was tried to set {5} values."
     */
    CANNOTSETATTRIBUTEBECAUSEUPPERMULTIPLICITY("CannotSetAttributeBecauseUpperMultiplicity_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Can not set attribute "{0}" of class "{1}" with value "{2}" of type "{3}". The attribute is multi-valued and ordered. The value has to be of type "{4}", but it is of type {5}"
     */
    CANNOTSETATTRIBUTEWRONGTYPE("CannotSetAttributeWrongType_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Can not set attribute "{0}" of class "{1}" with value "{2}" of type "{3}". The attribute is multi-valued. The value of each element must not be null"
     */
    CANNOTSETATTRIBUTE("CannotSetAttribute_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Could not find EndStorageLink to delete after creating private copy"
     */
    COULDNOTFINDENDSTORAGELINKTODELETE("CouldNotFindEndStorageLinkToDelete_XMSG"), //$NON-NLS-1$

    /**
     * Message: "feature "{0}" of class "{1}" has an upper multiplicity of "{2}""
     */
    FEATUREHASUPPERMULTIPLICITY("FeatureHasUpperMultiplicity_XMSG"), //$NON-NLS-1$

    /**
     * Message: "feature "{0}" of class "{1}" is unique"
     */
    FEATUREISUNIQUE("FeatureIsUnique_XMSG"), //$NON-NLS-1$

    /**
     * Message: "feature "{0}" of class "{1}" is a multi-valued attribute, null values can not be added to the elements of multi-valued attributes"
     */
    FEATUREOFCLASSISMULTIVALUEDNOADD("FeatureOfClassIsMultivaluedNoAdd_XMSG"), //$NON-NLS-1$

    /**
     * Message: "feature "{0}" of class "{1}" is a multi-valued attribute, null values can not be contained in multi-valued attributes and can therefore not be removed"
     */
    FEATUREOFCLASSISMULTIVALUEDNOREMOVE("FeatureOfClassIsMultivaluedNoRemove_XMSG"), //$NON-NLS-1$

    /**
     * Message: "feature "{0}" of class "{1}" is a multi-valued attribute, elements of multi-valued attributes can not be set to null"
     */
    FEATUREOFCLASSISMULTIVALUEDNOSET("FeatureOfClassIsMultivaluedNoSet_XMSG"), //$NON-NLS-1$

    /**
     * Message: "feature "{0}" of class "{1}" has to be of type "{2}", but it is of type {3}"
     */
    FEATUREWRONGTYPE("FeatureWrongType_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Tried to remove an element at index "{0}" from the feature "{1}" of class "{2}". Index ({0}) is bigger than the number of elements ({3}) of feature "{1}""
     */
    INDEXISBIGGERTHANNUMBEROFELEMENTS("IndexIsBiggerThanNumberOfElements_XMSG"), //$NON-NLS-1$

    /**
     * Message: "There is more than one link for implicit removal"
     */
    MORETHANONELINKFORREMOVAL("MoreThanOneLinkForRemoval_XMSG"), //$NON-NLS-1$

    /**
     * Message: "MRI of element to assign is null."
     */
    MRIOFELEMENTISNULL("MriOfElementIsNull_XMSG"), //$NON-NLS-1$

    /**
     * Message: "feature "{0}" of class "{1}" is a multi-valued attribute, multi-valued attributes can not be set as a whole"
     */
    MULTIVALUEDATTRIBUTESNOTSETASWHOLE("MultiValuedAttributesNotSetAsWhole_XMSG"), //$NON-NLS-1$

    /**
     * Message: "feature "{0}" of class "{1}" is a multi-valued reference, multi-valued references can not be set as a whole"
     */
    MULTIVALUEDREFERENCESNOTSETASWHOLE("MultiValuedReferencesNotSetAsWhole_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The new partition PRI is null"
     */
    NEWPARTITIONPRIISNULL("NewPartitionPriIsNull_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Can not create an instance of class "{0}" with the attribute values "{1}". Class "{0}" has no non-derived and instance level attributes"
     */
    NONONDERIVEDINSTANCELEVELATTRIBUTES("NoNonDerivedInstanceLevelAttributes_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The old partition PRI is null"
     */
    OLDPARTITIONPRIISNULL("OldPartitionPriIsNull_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( MicroTransactionablesMessages.class );

    private final String myKey;

    private MicroTransactionablesMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            // $JL-EXC$        
            return "Localization failed for ResourceBundle " + MicroTransactionablesMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  