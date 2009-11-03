package com.sap.tc.moin.repository.core.ocl.editorutils;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>sortedBy_orderedSet_YMSG: Results in an OrderedSet containing all elements of the source collection. The element for which body has the lowest value comes first, and so on. The type of the body expression must have the "<" operation defined. The "<" operation must return a Boolean value and must be transitive i.e. if a < b and b < c then a < c. May have at most one iterator variable.</li>
 * <li>sortedBy_set_YMSG: Results in the OrderedSet containing all elements of the source collection. The element for which body has the lowest value comes first, and so on. The type of the body expression must have the "<" operation defined. The "<" operation must return a Boolean value and must be transitive i.e. if a < b and b < c then a < c. May have at most one iterator variable.</li>
 * <li>sortedBy_sequence_YMSG: Results in the Sequence containing all elements of the source collection. The element for which body has the lowest value comes first, and so on. The type of the body expression must have the "<" operation defined. The "<" operation must return a Boolean value and must be transitive i.e. if a < b and b < c then a < c. May have at most one iterator variable.</li>
 * <li>isUnique_XMSG: Results in true if body evaluates to a different value for each element in the source collection; otherwise, results in false.  May have at most one iterator variable.</li>
 * <li>exists_XMSG: Results in true if body evaluates to true for at least one element in the source collection.</li>
 * <li>forAll_XMSG: Results in true if the body expression evaluates to true for each element in the source collection; otherwise, results in false.</li>
 * <li>one_XMSG: Results in true if there is exactly one element in the source collection for which body is true. May have at most one iterator variable.</li>
 * <li>any_YMSG: Returns any element in the source collection for which body evaluates to true. If there is more than one element for which body is true, one of them is returned. There must be at least one element fulfilling body, otherwise the result of this IteratorExp is OclUndefined. May have at most one iterator variable.</li>
 * <li>collectNested_bag_XMSG: The Bag of elements which results from applying body to every member of the source bag. May have at most one iterator variable.</li>
 * <li>collectNested_orderedSet_XMSG: The Bag of elements which results from applying body to every member of the source ordered-set. May have at most one iterator variable.</li>
 * <li>collectNested_set_XMSG: The Bag of elements which results from applying body to every member of the source set. May have at most one iterator variable.</li>
 * <li>collect_YMSG: The Collection of elements which results from applying body to every member of the source set. The result is flattened. Notice that this is based on collectNested, which can be of different type depending on the type of source. collectNested is defined individually for each subclass of CollectionType. May have at most one iterator variable.</li>
 * <li>collectNested_sequence_XMSG: The Sequence of elements which results from applying body to every member of the source sequence. May have at most one iterator variable.</li>
 * <li>reject_bag_XMSG: The sub-bag of the source bag for which body is false. May have at most one iterator variable.</li>
 * <li>select_bag_XMSG: The sub-bag of the source bag for which body is true. May have at most one iterator variable.</li>
 * <li>reject_orderedSet_XMSG: The sub-ordered-set of the source ordered-set for which body is false. May have at most one iterator variable.</li>
 * <li>select_orderedSet_XMSG: The sub-ordered-set of the source ordered-set for which body is true. May have at most one iterator variable.</li>
 * <li>reject_sequence_XMSG: The subsequence of the source sequence for which body is false. May have at most one iterator variable.</li>
 * <li>select_sequence_XMSG: The subsequence of the source sequence for which body is true. May have at most one iterator variable.</li>
 * <li>select_set_XMSG: The subset of set for which expr is true. May have at most one iterator variable.</li>
 * <li>reject_set_XMSG: The subset of the source set for which body is false. May have at most one iterator variable.</li>
 * <li>iterate_YMSG: The variable acc is the accumulator. The accumulator gets an initial value expression. When the iterate is evaluated, elem iterates over the collection and the expression-with-elem-and-acc is evaluated for each elem. After each evaluation of expression-with-elem-and-acc, its value is assigned to acc. In this way, the value of acc is built up during the iteration of the collection.</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from MoinAnnotationMessages.properties
 */
 
public enum MoinAnnotationMessages implements MoinLocalizedString {


    /**
     * Message: "Returns any element in the source collection for which body evaluates to true. If there is more than one element for which body is true, one of them is returned. There must be at least one element fulfilling body, otherwise the result of this IteratorExp is OclUndefined. May have at most one iterator variable."
     */
    ANY("any_YMSG"), //$NON-NLS-1$

    /**
     * Message: "The Bag of elements which results from applying body to every member of the source bag. May have at most one iterator variable."
     */
    COLLECTNESTED_BAG("collectNested_bag_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The Bag of elements which results from applying body to every member of the source ordered-set. May have at most one iterator variable."
     */
    COLLECTNESTED_ORDEREDSET("collectNested_orderedSet_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The Sequence of elements which results from applying body to every member of the source sequence. May have at most one iterator variable."
     */
    COLLECTNESTED_SEQUENCE("collectNested_sequence_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The Bag of elements which results from applying body to every member of the source set. May have at most one iterator variable."
     */
    COLLECTNESTED_SET("collectNested_set_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The Collection of elements which results from applying body to every member of the source set. The result is flattened. Notice that this is based on collectNested, which can be of different type depending on the type of source. collectNested is defined individually for each subclass of CollectionType. May have at most one iterator variable."
     */
    COLLECT("collect_YMSG"), //$NON-NLS-1$

    /**
     * Message: "Results in true if body evaluates to true for at least one element in the source collection."
     */
    EXISTS("exists_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Results in true if the body expression evaluates to true for each element in the source collection; otherwise, results in false."
     */
    FORALL("forAll_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Results in true if body evaluates to a different value for each element in the source collection; otherwise, results in false.  May have at most one iterator variable."
     */
    ISUNIQUE("isUnique_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The variable acc is the accumulator. The accumulator gets an initial value expression. When the iterate is evaluated, elem iterates over the collection and the expression-with-elem-and-acc is evaluated for each elem. After each evaluation of expression-with-elem-and-acc, its value is assigned to acc. In this way, the value of acc is built up during the iteration of the collection."
     */
    ITERATE("iterate_YMSG"), //$NON-NLS-1$

    /**
     * Message: "Results in true if there is exactly one element in the source collection for which body is true. May have at most one iterator variable."
     */
    ONE("one_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The sub-bag of the source bag for which body is false. May have at most one iterator variable."
     */
    REJECT_BAG("reject_bag_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The sub-ordered-set of the source ordered-set for which body is false. May have at most one iterator variable."
     */
    REJECT_ORDEREDSET("reject_orderedSet_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The subsequence of the source sequence for which body is false. May have at most one iterator variable."
     */
    REJECT_SEQUENCE("reject_sequence_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The subset of the source set for which body is false. May have at most one iterator variable."
     */
    REJECT_SET("reject_set_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The sub-bag of the source bag for which body is true. May have at most one iterator variable."
     */
    SELECT_BAG("select_bag_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The sub-ordered-set of the source ordered-set for which body is true. May have at most one iterator variable."
     */
    SELECT_ORDEREDSET("select_orderedSet_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The subsequence of the source sequence for which body is true. May have at most one iterator variable."
     */
    SELECT_SEQUENCE("select_sequence_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The subset of set for which expr is true. May have at most one iterator variable."
     */
    SELECT_SET("select_set_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Results in the Sequence containing all elements of the source collection. The element for which body has the lowest value comes first, and so on. The type of the body expression must have the "<" operation defined. The "<" operation must return a Boolean value and must be transitive i.e. if a < b and b < c then a < c. May have at most one iterator variable."
     */
    SORTEDBY_BAG("sortedBy_bag_YMSG"), //$NON-NLS-1$

    /**
     * Message: "Results in an OrderedSet containing all elements of the source collection. The element for which body has the lowest value comes first, and so on. The type of the body expression must have the "<" operation defined. The "<" operation must return a Boolean value and must be transitive i.e. if a < b and b < c then a < c. May have at most one iterator variable."
     */
    SORTEDBY_ORDEREDSET("sortedBy_orderedSet_YMSG"), //$NON-NLS-1$

    /**
     * Message: "Results in the Sequence containing all elements of the source collection. The element for which body has the lowest value comes first, and so on. The type of the body expression must have the "<" operation defined. The "<" operation must return a Boolean value and must be transitive i.e. if a < b and b < c then a < c. May have at most one iterator variable."
     */
    SORTEDBY_SEQUENCE("sortedBy_sequence_YMSG"), //$NON-NLS-1$

    /**
     * Message: "Results in the OrderedSet containing all elements of the source collection. The element for which body has the lowest value comes first, and so on. The type of the body expression must have the "<" operation defined. The "<" operation must return a Boolean value and must be transitive i.e. if a < b and b < c then a < c. May have at most one iterator variable."
     */
    SORTEDBY_SET("sortedBy_set_YMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( MoinAnnotationMessages.class );

    private final String myKey;

    private MoinAnnotationMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + MoinAnnotationMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  