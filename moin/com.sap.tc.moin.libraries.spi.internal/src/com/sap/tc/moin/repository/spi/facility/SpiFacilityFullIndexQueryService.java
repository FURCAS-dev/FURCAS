package com.sap.tc.moin.repository.spi.facility;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.spi.facility.fql.SpiFqlComparisonOperation;

/**
 * The full index query service is the low-level interface to be implemented by
 * a facility for efficient MQL execution if not a full FQL is provided.
 */
public interface SpiFacilityFullIndexQueryService extends SpiMQLQueryService {

    /**
     * This method returns all immediate instances of any of the provided types,
     * as long as they are in the provided query client scope. If no types are
     * provided at all, all instances regardless of their type are requested.
     * This only makes sense if the provided scope is limited. However, it is
     * not illegal to provide a universal scope (i.e. empty set and negative
     * inclusion) when no types are provided. None of the parameters of this
     * method can be null.
     * 
     * @param queryClientScope Defines the scope for the query (e.g.
     * ClientSpecs, Partitions); must not be <code>null</code>.
     * @param types Array of {@link MRI MRIs} of MofClasses for which all
     * instances have to be returned; must not be <code>null</code>.
     * @return All immediate instances of any of the provided types, as long as
     * they are in the provided queryClientScope
     */
    MRI[] getInstances( SpiFacilityQueryClientScope queryClientScope, MRI[] types );

    /**
     * Given a fromElement, this query returns all linked elements in the
     * provided queryClientScope. This includes all intra and inter partition
     * links. Observe that if the fromElement is not inside the
     * queryClientScope, the result will be empty. Moreover, it is assumed that
     * the fromElement is at the fromEnd side. It should matter where links are
     * stored. None of the parameters should be null.
     * 
     * @param queryClientScope queryClientScope Defines the scope for the query
     * (e.g. ClientSpecs, Partitions); must not be <code>null</code>.
     * @param association The association from which links have to be
     * considered, encoded as a MRI. Note that this includes Attribute-style
     * associations.
     * @param fromEnd The fromEnd encoding from which we navigate
     * @param fromElement The seed element from which all links are taken
     * @return All linked elements in the queryClientScope as typed by the
     * provided association, where a given fromElement is at the fromEnd side.
     */
    MRI[] getAssociationLinkedElements( SpiFacilityQueryClientScope queryClientScope, MRI association, int fromEnd, MRI fromElement );

    /**
     * This query returns the attribute value of the attribute with name
     * attributeName of the provided element and of the provided type. The
     * attribute must be of one of MOF's 6 primitive types. It is returned in a
     * boxed manner. Moreover, if the attribute is multi-valued, then the return
     * value should be of type Object[]. The result of this query is null if the
     * element does not reside in the provided scope. The attributeName has to
     * exist for the type and the provided element is has to be of the provided
     * type
     * 
     * @param queryClientScope queryClientScope Defines the scope for the query
     * (e.g. ClientSpecs, Partitions); must not be <code>null</code>.
     * @param type The type of the provided element
     * @param element The element from which the attribute is taken
     * @param attributeName The attribute name of attribute value, which is to
     * be taken from the element
     * @return The attribute value of the attribute with name attributeName of
     * the provided element.
     */
    Object getAttribute( SpiFacilityQueryClientScope queryClientScope, MRI type, MRI element, String attributeName );

    /**
     * Returns true if there exists a link between the fromElement and toElement
     * for the given association where the fromEnd is on the side fromElement.
     * Note that it does not matter where the link is stored. None of the
     * provided parameters should be null. Moreover, only links within the
     * queryClientScope are considered.
     * 
     * @param queryClientScope queryClientScope Defines the scope for the query
     * (e.g. ClientSpecs, Partitions); must not be <code>null</code>.
     * @param association The association from which links have to be
     * considered, encoded as a MRI. Note that this includes Attribute-style
     * associations.
     * @param fromEnd The fromEnd encoding from which we navigate
     * @param fromElement The element on one side of the link (as indicated by
     * fromEnd)
     * @param toElement The elemen on the other side of the link
     * @return <code>true</code> if there exists a link between the fromElement
     * and toElement for the given association where the fromEnd is on the side
     * fromElement, <code>false</code> otherwise.
     */
    boolean elementsAreLinkedPerAssociation( SpiFacilityQueryClientScope queryClientScope, MRI association, int fromEnd, MRI fromElement, MRI toElement );

    /**
     * This function returns true if the attribute with name oneAttributeName of
     * the element oneElement compares positively to the attribute with name
     * otherAttributeName of element otherElement as described by
     * {@link SpiFqlComparisonOperation}, wher the respective attribute names
     * have to belong to the respective types. The provided attributes have to
     * be of one of MOF's 6 simple types (i.e. int, long, float, double,
     * boolean, string). In the case of string, the comparison operation reduces
     * to equality or inequality. In the case of boolean, the comparison reduces
     * to equality. If either one or both attributes are multi-valued, the
     * operation returns true as soon as one pair of values satisfies the
     * comparison. If one or both of the elements in not in the provided scope,
     * the method automatically returns false.
     * <p>
     * We have the following additional limitations
     * <ul>
     * <li>LIMITATION 1: an attribute comparison on string-typed values will
     * ignore trailing blanks, so the (in-)equality on strings happens modulo
     * these trailing blanks.
     * <li>LIMITATION 2: an attribute comparison on string-typed values will
     * only consider the first 200 characters, so the equality on strings
     * happens modulo the first 200 characters.
     * <ul>
     * <p>
     * The oneAttributeName has to exist for the type and the provided one
     * element has to be of the provided type. The otherAttributeName has to be
     * of the provded type.
     * 
     * @param queryClientScope Defines the scope for the query (e.g.
     * ClientSpecs, Partitions); must not be <code>null</code>.
     * @param oneType The type of the one element
     * @param oneElement one element from which an attribute is taken for
     * comparison
     * @param oneAttributeName one attribute name, pointing to the attribute
     * value
     * @param operation the actual operation which is used to determine the
     * comparability of the attribute values
     * @param otherType The type of the other element
     * @param otherElement other element from which an attribute is taken for
     * comparison
     * @param otherAttributeName other attribute name, pointing to the attribute
     * value
     * @return <code>true</code> if the attribute with name oneAttributeName of
     * the element oneElement compares positively to the attribute with name
     * otherAttributeName of element otherElement as described by
     * {@link SpiFqlComparisonOperation}, <code>false</code> otherwise.
     */
    boolean elementsHaveComparableAttributes( SpiFacilityQueryClientScope queryClientScope, MRI oneType, MRI oneElement, String oneAttributeName, SpiFqlComparisonOperation operation, MRI otherType, MRI otherElement, String otherAttributeName );

    /**
     * This function returns true if the attribute (with name attributeName) of
     * the provided element compares positively to the provided value. The
     * attribute name has to be owned by the type and the element has to be an
     * instance of the type. The attribute has to be of one of MOF's 6 simple
     * types (i.e. int, long, float, double, boolean, string). Null is a legal
     * constant to compare attribute values with. The function returns true if
     * the attribute is not set. The following restrictions are in place:
     * <ul>
     * <li> int, long, float, double: all operations are permitted with the
     * expected semantics <li> boolean: only the operation EQUAL is permitted
     * with the expected semantics <li> string: only the operations NOTEQUAL,
     * and EQUAL are permitted. Note that an empty string is a legal value for a
     * comparison. In addition, we have the following restrictions:
     * <ul>
     * <li> LIMITATION 1: a comparison for a string-typed attribute does not
     * allow a string constant which is longer than 200 characters. Moreover, if
     * the stored attribute has more than 200 characters, only the first 200
     * characters are considered in the comparison. <li> LIMITATION 2: a string
     * attribute comparison does not allow the string constant to have trailing
     * blanks. For example, it is not allowed to compare with 'myStr '.
     * Moreover, the comparison happens modulo trailing blanks for <i>stored</i>
     * attributes (it is possible to persist strings with trailing blanks in
     * MOIN). For example, the comparison attr = 'myStr' will be true if attr is
     * 'myStr' <i>or</i> 'myStr '.
     * </ul>
     * </ul>
     * <p>
     * The attributeName has to exist for the type and the provided element has
     * to be of the provided type. The provided attribute value has to be of the
     * type of the attribute.
     * 
     * @param queryClientScope Defines the scope for the query (e.g.
     * ClientSpecs, Partitions); must not be <code>null</code>.
     * @param element the element from which an attribute is taken for
     * comparison
     * @param attributeName the attribute name, pointing to the attribute value
     * @param operation the actual operation which is used to determine the
     * comparability of the attribute values
     * @param value The actual value which is used in the comparison
     * @return <code>true</code> if the attribute (with name attributeName) of
     * the provided element compares positively to the provided value <code>
     * false</code> otherwise.
     */
    boolean elementHasAttributeCondition( SpiFacilityQueryClientScope queryClientScope, MRI type, MRI element, String attributeName, SpiFqlComparisonOperation operation, Object value );

    /**
     * This function returns true if the string attribute (with name
     * attributeName) of the provided element matches the provided string
     * pattern. The attribute name has to be part of the provided type and the
     * element has to be an instance of the type. A pattern may contain the
     * following special pattern matching characters:
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
     * The attributeName has to exist for the type and the provided element has
     * to be of the provided type.
     * 
     * @param queryClientScope Defines the scope for the query (e.g.
     * ClientSpecs, Partitions); must not be <code>null</code>.
     * @param element the element from which an attribute is taken for
     * comparison
     * @param attributeName the attribute name, pointing to the attribute value
     * @param pattern The actual pattern which is used in the comparison
     * @return <code>true</code> if the string attribute (with name
     * attributeName) of the provided element matches the provided string
     * pattern, <code>false</code> otherwise.
     */
    boolean elementHasMatchingStringPattern( SpiFacilityQueryClientScope queryClientScope, MRI type, MRI element, String attributeName, String pattern );

}
