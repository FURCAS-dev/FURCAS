package com.sap.tc.moin.repository.spi.facility;

import java.util.Set;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.spi.facility.fql.SpiFqlComparisonOperation;
import com.sap.tc.moin.repository.spi.facility.fql.SpiFqlPrimitiveType;

/**
 * This version of the slim index
 * 
 * @author D045917
 */
public interface SpiFacilitySlimVariantIndexQueryService extends SpiFacilitySlimIndexQueryService {

    /**
     * This function returns the PRIs for which the attribute (with name
     * attributeName) of one ore more elements in the provided partition
     * compares positively to the provided value. The attribute name has to be
     * owned by the type. The attribute has to be of one of MOF's 6 simple types
     * (i.e. int, long, float, double, boolean, string). Null is a legal
     * constant to compare attribute values with. This result set is a subset of
     * the scope of queryClientScope. The following restrictions are in place:
     * <ul>
     * <li>int, long, float, double: all operations are permitted with the
     * expected semantics
     * <li>boolean: only the operation EQUAL is permitted with the expected
     * semantics
     * <li>string: only the operations NOTEQUAL, and EQUAL are permitted. Note
     * that an empty string is a legal value for a comparison. In addition, we
     * have the following restrictions:
     * <ul>
     * <li>LIMITATION 1: a comparison for a string-typed attribute does not
     * allow a string constant which is longer than 200 characters. Moreover, if
     * the stored attribute has more than 200 characters, only the first 200
     * characters are considered in the comparison.
     * <li>LIMITATION 2: a string attribute comparison does not allow the string
     * constant to have trailing blanks. For example, it is not allowed to
     * compare with 'myStr '. Moreover, the comparison happens modulo trailing
     * blanks for <i>stored</i> attributes (it is possible to persist strings
     * with trailing blanks in MOIN). For example, the comparison attr = 'myStr'
     * will be true if attr is 'myStr' <i>or</i> 'myStr '.
     * </ul>
     * </ul>
     * <p>
     * The attributeName has to exist for the type. Similarly, the provided
     * attribute value has to be of the type of the attribute.
     * 
     * @param queryClientScope Defines the scope for the query (e.g.
     * ClientSpecs, Partitions); must not be <code>null</code>.
     * @param attributeName the attribute name, pointing to the attribute value
     * @param operation the actual operation which is used to determine the
     * comparability of the attribute values
     * @param value The actual value which is used in the comparison
     * @param type The type of the element holding the attribute
     * @param attributeType The primitive type of the attribute
     * @return the partitions for which there is at least one element, whose
     * attribute (with name attributeName) compares positively to the provided
     * value.
     */
    Set<PRI> prisForAttributeCondition( SpiFacilityQueryClientScope queryClientScope, MRI[] types, String attributeName, SpiFqlPrimitiveType attributeType, SpiFqlComparisonOperation operation, Object value );

    /**
     * * This function returns true if the attribute (with name attributeName)
     * of one ore more elements in the provided partition matches the provided
     * string pattern. The attribute name has to be part of the provided type. A
     * pattern may contain the following special pattern matching characters:
     * <ul>
     * <li>'?' : matches with any character</li> <li>'*' : matches with any
     * sequence of characters, including the empty sequence</li> <li>'\' :
     * escapes the pattern matching characters '?' and '*', including '\', i.e.
     * itself </li>
     * </ul>
     * Note that the empty string is a legal pattern. Null however is not!
     * Moreover, the following limitations are in place:
     * <ul>
     * <li> LIMITATION 1: the pattern constant part cannot be longer than 200
     * characters. Moreover, a match will only take place on the first 200
     * characters. <li> LIMITATION 2: the pattern is not allowed to have
     * trailing blanks, also not when they are preceded with a pattern variable.
     * For example, 'myStr ' and 'myStr * ' are both illegal patterns. Trailing
     * pattern variables do not match blanks. E.g. 'myStr*' will not match a
     * stored value 'myStr ', but it will match 'myStr str'. Moreover, a
     * trailing pattern with preceding blanks does not match blanks or the empty
     * string. For example the pattern 'myStr *' is permitted and matches 'myStr
     * str', but not 'myStr', or even 'myStr '.
     * </ul>
     * <p>
     * The attributeName has to exist for the type.
     * 
     * @param queryClientScope Defines the scope for the query (e.g.
     * ClientSpecs, Partitions); must not be <code>null</code>.
     * @param attributeName the attribute name, pointing to the attribute value
     * @param pattern The actual pattern which is used in the comparison
     * @param type The type of the attribute name
     * @param not is true if the pattern is negated
     * @return the partitions for which there is at least one element, whose
     * string attribute (with name attributeName) matches positively to the
     * provided value.
     */
    Set<PRI> prisForMatchingStringPattern( SpiFacilityQueryClientScope queryClientScope, MRI[] types, String attributeName, boolean not, String pattern );
}
