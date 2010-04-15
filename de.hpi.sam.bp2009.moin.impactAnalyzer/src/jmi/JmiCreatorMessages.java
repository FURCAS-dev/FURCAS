package com.sap.tc.moin.ocl.utils.jmi;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>JmiCreator_0101_XMSG: "{0}"-iterator may have at most one iterator variable</li>
 * <li>JmiCreator_0226_XMSG: A LetExpression must have an "in" expression</li>
 * <li>JmiCreator_0103_XMSG: Accumulator variable "{0}" must be initialized</li>
 * <li>JmiCreator_0236_XMSG: Arguments must not be null</li>
 * <li>JmiCreator_0249_XMSG: AssociationEnd must not be null</li>
 * <li>JmiCreator_0209_XMSG: Attribute of an AttributeCallExpression must not be null</li>
 * <li>JmiCreator_0104_XMSG: Body of a "{0}"-iterator must be of type "{1}" and not of type "{2}"</li>
 * <li>JmiCreator_0212_XMSG: CollectionItem type must not be null</li>
 * <li>JmiCreator_0214_XMSG: CollectionParts must not be null</li>
 * <li>JmiCreator_0220_XMSG: Condition expression must not be null</li>
 * <li>JmiCreator_0222_XMSG: Else expression must not be null</li>
 * <li>JmiCreator_0219_XMSG: Enumeration literal must not be null or empty</li>
 * <li>JmiCreator_0216_XMSG: First element of a CollectionRange must not be null</li>
 * <li>JmiCreator_0225_XMSG: Integer literal is not a number</li>
 * <li>JmiCreator_0211_XMSG: Item of a CollectionItem must not be null</li>
 * <li>JmiCreator_0110_XMSG: Iterate operation "{0}" unknown</li>
 * <li>JmiCreator_0109_XMSG: Iterate operation must have a CollectionType as source</li>
 * <li>JmiCreator_0108_XMSG: Iterate operation must have an accumulator variable defined</li>
 * <li>JmiCreator_0102_XMSG: Iterator operation must have a CollectionType as source</li>
 * <li>JmiCreator_0111_XMSG: Iterator variable "{0}" must not be initialized</li>
 * <li>JmiCreator_0107_XMSG: Iterator variable "{0}:{1}" must conform to the element type of the source collection "{2}"</li>
 * <li>JmiCreator_0217_XMSG: Last element of a CollectionRange must not be null</li>
 * <li>JmiCreator_0241_XMSG: List of tuple part must not be null</li>
 * <li>JmiCreator_0206_XMSG: Name of an Attribute must not be null or empty</li>
 * <li>JmiCreator_0302_XMSG: OCL Standard Library package could not be found</li>
 * <li>JmiCreator_0235_XMSG: Operation does not have a valid return type</li>
 * <li>JmiCreator_0234_XMSG: OperationCallExpression must have a source</li>
 * <li>JmiCreator_0239_XMSG: Real literal is not a number</li>
 * <li>JmiCreator_0202_XMSG: Referred AssociationEnd of a AssociationEndCallExp must not be null</li>
 * <li>JmiCreator_0233_XMSG: Referred Operation of an OperationCallExpression must not be null</li>
 * <li>JmiCreator_0201_XMSG: Source of AssociationEndCallExp must not be null</li>
 * <li>JmiCreator_0203_XMSG: Source of a "@pre" operation must not be null</li>
 * <li>JmiCreator_0208_XMSG: Source of an AttributeCallExpression must not be null</li>
 * <li>JmiCreator_0300_XMSG: Standard library operation {0} of type {1} not found</li>
 * <li>JmiCreator_0240_XMSG: String literal must not be null</li>
 * <li>JmiCreator_0221_XMSG: Then expression must not be null</li>
 * <li>JmiCreator_0243_XMSG: TupleParts with duplicate names found</li>
 * <li>JmiCreator_0213_XMSG: Type of a Collection must not be null</li>
 * <li>JmiCreator_0224_XMSG: Type of a Condition must be Boolean</li>
 * <li>JmiCreator_0244_XMSG: Type of a TypeExpression must not be null</li>
 * <li>JmiCreator_0246_XMSG: Type of a VariableDeclaration must not be null</li>
 * <li>JmiCreator_0248_XMSG: Type of a VariableExpression must not be null</li>
 * <li>JmiCreator_0250_XMSG: Type of an AssociationEnd must not be null</li>
 * <li>JmiCreator_0210_XMSG: Type of an Attribute must not be null</li>
 * <li>JmiCreator_0218_XMSG: Type of an EnumLiterlExp must not be null</li>
 * <li>JmiCreator_0223_XMSG: Type of an IfExpression must not be null</li>
 * <li>JmiCreator_0238_XMSG: Type of an argument must not be null</li>
 * <li>JmiCreator_0229_XMSG: Type of the "in" expression must not be null</li>
 * <li>JmiCreator_0204_XMSG: Type of the source of a "@pre" operation must not be null</li>
 * <li>JmiCreator_0301_XMSG: Type {0} not found in Standard Library package</li>
 * <li>JmiCreator_0245_XMSG: Variable name must not be null</li>
 * <li>JmiCreator_0228_XMSG: Variable of a LetExpression must have an "init" expression</li>
 * <li>JmiCreator_0247_XMSG: VariableDeclaration must not be null</li>
 * <li>JmiCreator_0227_XMSG: VariableDeclaration of a LetExpression must not be null</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from JmiCreatorMessages.properties
 */
 
public enum JmiCreatorMessages implements MoinLocalizedString {


    /**
     * Message: ""{0}"-iterator may have at most one iterator variable"
     */
    JMICREATOR_0101("JmiCreator_0101_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Iterator operation must have a CollectionType as source"
     */
    JMICREATOR_0102("JmiCreator_0102_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Accumulator variable "{0}" must be initialized"
     */
    JMICREATOR_0103("JmiCreator_0103_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Body of a "{0}"-iterator must be of type "{1}" and not of type "{2}""
     */
    JMICREATOR_0104("JmiCreator_0104_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Iterator variable "{0}:{1}" must conform to the element type of the source collection "{2}""
     */
    JMICREATOR_0107("JmiCreator_0107_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Iterate operation must have an accumulator variable defined"
     */
    JMICREATOR_0108("JmiCreator_0108_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Iterate operation must have a CollectionType as source"
     */
    JMICREATOR_0109("JmiCreator_0109_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Iterate operation "{0}" unknown"
     */
    JMICREATOR_0110("JmiCreator_0110_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Iterator variable "{0}" must not be initialized"
     */
    JMICREATOR_0111("JmiCreator_0111_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Source of AssociationEndCallExp must not be null"
     */
    JMICREATOR_0201("JmiCreator_0201_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Referred AssociationEnd of a AssociationEndCallExp must not be null"
     */
    JMICREATOR_0202("JmiCreator_0202_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Source of a "@pre" operation must not be null"
     */
    JMICREATOR_0203("JmiCreator_0203_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Type of the source of a "@pre" operation must not be null"
     */
    JMICREATOR_0204("JmiCreator_0204_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Name of an Attribute must not be null or empty"
     */
    JMICREATOR_0206("JmiCreator_0206_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Type of an Attribute must not be null"
     */
    JMICREATOR_0207("JmiCreator_0207_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Source of an AttributeCallExpression must not be null"
     */
    JMICREATOR_0208("JmiCreator_0208_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Attribute of an AttributeCallExpression must not be null"
     */
    JMICREATOR_0209("JmiCreator_0209_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Type of an Attribute must not be null"
     */
    JMICREATOR_0210("JmiCreator_0210_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Item of a CollectionItem must not be null"
     */
    JMICREATOR_0211("JmiCreator_0211_XMSG"), //$NON-NLS-1$

    /**
     * Message: "CollectionItem type must not be null"
     */
    JMICREATOR_0212("JmiCreator_0212_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Type of a Collection must not be null"
     */
    JMICREATOR_0213("JmiCreator_0213_XMSG"), //$NON-NLS-1$

    /**
     * Message: "CollectionParts must not be null"
     */
    JMICREATOR_0214("JmiCreator_0214_XMSG"), //$NON-NLS-1$

    /**
     * Message: "First element of a CollectionRange must not be null"
     */
    JMICREATOR_0216("JmiCreator_0216_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Last element of a CollectionRange must not be null"
     */
    JMICREATOR_0217("JmiCreator_0217_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Type of an EnumLiterlExp must not be null"
     */
    JMICREATOR_0218("JmiCreator_0218_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Enumeration literal must not be null or empty"
     */
    JMICREATOR_0219("JmiCreator_0219_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Condition expression must not be null"
     */
    JMICREATOR_0220("JmiCreator_0220_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Then expression must not be null"
     */
    JMICREATOR_0221("JmiCreator_0221_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Else expression must not be null"
     */
    JMICREATOR_0222("JmiCreator_0222_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Type of an IfExpression must not be null"
     */
    JMICREATOR_0223("JmiCreator_0223_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Type of a Condition must be Boolean"
     */
    JMICREATOR_0224("JmiCreator_0224_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Integer literal is not a number"
     */
    JMICREATOR_0225("JmiCreator_0225_XMSG"), //$NON-NLS-1$

    /**
     * Message: "A LetExpression must have an "in" expression"
     */
    JMICREATOR_0226("JmiCreator_0226_XMSG"), //$NON-NLS-1$

    /**
     * Message: "VariableDeclaration of a LetExpression must not be null"
     */
    JMICREATOR_0227("JmiCreator_0227_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Variable of a LetExpression must have an "init" expression"
     */
    JMICREATOR_0228("JmiCreator_0228_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Type of the "in" expression must not be null"
     */
    JMICREATOR_0229("JmiCreator_0229_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Referred Operation of an OperationCallExpression must not be null"
     */
    JMICREATOR_0233("JmiCreator_0233_XMSG"), //$NON-NLS-1$

    /**
     * Message: "OperationCallExpression must have a source"
     */
    JMICREATOR_0234("JmiCreator_0234_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Operation does not have a valid return type"
     */
    JMICREATOR_0235("JmiCreator_0235_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Arguments must not be null"
     */
    JMICREATOR_0236("JmiCreator_0236_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Type of an argument must not be null"
     */
    JMICREATOR_0238("JmiCreator_0238_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Real literal is not a number"
     */
    JMICREATOR_0239("JmiCreator_0239_XMSG"), //$NON-NLS-1$

    /**
     * Message: "String literal must not be null"
     */
    JMICREATOR_0240("JmiCreator_0240_XMSG"), //$NON-NLS-1$

    /**
     * Message: "List of tuple part must not be null"
     */
    JMICREATOR_0241("JmiCreator_0241_XMSG"), //$NON-NLS-1$

    /**
     * Message: "TupleParts with duplicate names found"
     */
    JMICREATOR_0243("JmiCreator_0243_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Type of a TypeExpression must not be null"
     */
    JMICREATOR_0244("JmiCreator_0244_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Variable name must not be null"
     */
    JMICREATOR_0245("JmiCreator_0245_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Type of a VariableDeclaration must not be null"
     */
    JMICREATOR_0246("JmiCreator_0246_XMSG"), //$NON-NLS-1$

    /**
     * Message: "VariableDeclaration must not be null"
     */
    JMICREATOR_0247("JmiCreator_0247_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Type of a VariableExpression must not be null"
     */
    JMICREATOR_0248("JmiCreator_0248_XMSG"), //$NON-NLS-1$

    /**
     * Message: "AssociationEnd must not be null"
     */
    JMICREATOR_0249("JmiCreator_0249_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Type of an AssociationEnd must not be null"
     */
    JMICREATOR_0250("JmiCreator_0250_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Standard library operation {0} of type {1} not found"
     */
    JMICREATOR_0300("JmiCreator_0300_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Type {0} not found in Standard Library package"
     */
    JMICREATOR_0301("JmiCreator_0301_XMSG"), //$NON-NLS-1$

    /**
     * Message: "OCL Standard Library package could not be found"
     */
    JMICREATOR_0302("JmiCreator_0302_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( JmiCreatorMessages.class );

    private final String myKey;

    private JmiCreatorMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + JmiCreatorMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  