package com.sap.tc.moin.repository.spi.ps.errorhandler;

import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.StructureType;

import com.sap.tc.moin.repository.spi.ps.SpiAssociation;
import com.sap.tc.moin.repository.spi.ps.SpiClass;
import com.sap.tc.moin.repository.spi.ps.SpiStructuredValueBase;
import com.sap.tc.moin.repository.spi.ps.SpiType;
import com.sap.tc.moin.repository.spi.ps.parser.SpiElement;
import com.sap.tc.moin.repository.spi.ps.parser.SpiParserCallback;

/**
 * The methods of {@link SpiParserErrorHandler} are called by the
 * {@link SpiParserCallback} in case of certain error situations during parsing,
 * caused by incompatible metamodel changes. Examples include:
 * <ul>
 * <li>unresolvable meta objects (classes, associations, attributes), because of
 * MOF id / qualified name changes in the metamodel, or simply because the meta
 * object has been deleted from the metamodel</li>
 * <li>illegal attribute values due to attribute type changes (e.g. String ->
 * {@link StructureType})</li>
 * </ul>
 * The error handler is intended to be implemented by a domain after
 * introduction of an incompatible metamodel change, allowing in many cases for
 * an on-the-fly migration of legacy data. The main idea is that in many
 * situations, only the specific domain can know what exactly was changed
 * incompatibly, and with the error handler the domain is given the possibility
 * to mitigate or fully correct the consequences of their change.
 * <p>
 * <b>Example:</b> An attribute <code>abc</code> of some MofClass was renamed to
 * <code>xyz</code>. During parsing of a legacy file containing <code>abc</code>
 * attributes, only the domain owning the metamodel can know that the attribute
 * changed its name to <code>xyz</code>, while MOIN can only treat it as an
 * unknown attribute.
 * <p>
 * <b>Note:</b> Instead of implementing this interface directly, clients are
 * strongly encouraged to inherit their error handler from
 * {@link SpiDefaultParserErrorHandler} instead, since additional interface
 * methods might be introduced by MOIN in the future.
 */
public interface SpiParserErrorHandler {

    /**
     * This method is called by the {@link SpiParserCallback} if a type (
     * {@link SpiType}, {@link SpiClass} or {@link SpiAssociation}) was
     * requested by the parser via one of the methods
     * {@link SpiParserCallback#getType(String, String, String)},
     * {@link SpiParserCallback#getClass(String, String, String)} or
     * {@link SpiParserCallback#getAssociation(String, String, String)}, but the
     * type could not be resolved (e.g. because a {@link MofClass} was moved to
     * a different {@link MofPackage}, and as a result both MOF id and qualified
     * name have changed).
     * <p>
     * Using domain specific knowledge and using the provided
     * {@link SpiParserCallback}, the error handler has the possibility to
     * return the correct type.
     * 
     * @param callback the {@link SpiParserCallback} the error handler can
     * interact with
     * @param typeMofId the MOF id of the type requested by the parser that
     * could not be resolved
     * @param metamodelContainer the metamodel container of the type requested
     * by the parser that could not be resolved
     * @param dotSeparatedQualifiedName the dot-separated qualified name of the
     * type requested by the parser that could not be resolved
     * @return the correct type, or <code>null</code> if the type cannot be
     * resolved; returning <code>null</code> will result in a subsequent generic
     * error handling in MOIN
     */
    public SpiType handleUnknownType( SpiParserCallback callback, String typeMofId, String metamodelContainer, String dotSeparatedQualifiedName );

    /**
     * This method is called by the {@link SpiParserCallback} if an attribute
     * value was added for an {@link SpiElement} by the parser via one of the
     * methods
     * {@link SpiElement#add___PrimitiveOrEnumerationValue(String, String)},
     * {@link SpiElement#add___StructuredValue(String, SpiStructuredValueBase)},
     * {@link SpiElement#add___ElementValue(String, SpiElement)} or
     * {@link SpiElement#add___ExternalElementValue(String, String)}, but the
     * attribute could not be resolved (e.g. because the attribute was renamed
     * in the metamodel).
     * <p>
     * Using domain specific knowledge and using the provided
     * {@link SpiParserCallback}, the error handler has the possibility to add
     * the value for a different attribute, or even spread the old value across
     * several new attributes.
     * 
     * @param callback the {@link SpiParserCallback} the error handler can
     * interact with
     * @param element the element whose attribute <code>attributeName</code>
     * could not be resolved
     * @param attributeName the name of the unknown attribute as reported by the
     * parser
     * @param attributeValue the value of the unknown attribute as reported by
     * the parser
     * @return whether the error handler considers the error as handled or not;
     * returning <code>false</code> will result in a subsequent generic error
     * handling in MOIN
     */
    public boolean handleUnknownAttribute( SpiParserCallback callback, SpiElement element, String attributeName, Object attributeValue );

    /**
     * This method is called by the {@link SpiParserCallback} if an illegal
     * value was added for an attribute of an {@link SpiElement} by the parser
     * via one of the methods
     * {@link SpiElement#add___PrimitiveOrEnumerationValue(String, String)},
     * {@link SpiElement#add___StructuredValue(String, SpiStructuredValueBase)},
     * {@link SpiElement#add___ElementValue(String, SpiElement)} or
     * {@link SpiElement#add___ExternalElementValue(String, String)}. Example:
     * in the metamodel the attribute currently has the type String, but the
     * parser reported an instance of {@link SpiStructuredValueBase} (because in
     * a former version of the metamodel, the attribute was of type
     * {@link StructureType}).
     * <p>
     * Using domain specific knowledge and using the provided
     * {@link SpiParserCallback}, the error handler has the possibility to
     * convert the illegal attribute value to the correct type.
     * 
     * @param callback the {@link SpiParserCallback} the error handler can
     * interact with
     * @param element the element carrying the attribute
     * <code>attributeName</code> for which an illegal value was reported by the
     * parser
     * @param attributeName the name of the attribute for which an illegal value
     * was reported by the parser
     * @param attributeValue the illegal attribute value as reported by the
     * parser
     * @return whether the error handler considers the error as handled or not;
     * returning <code>false</code> will result in a subsequent generic error
     * handling in MOIN
     */
    public boolean handleIllegalAttributeValue( SpiParserCallback callback, SpiElement element, String attributeName, Object attributeValue );
}