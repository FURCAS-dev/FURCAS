package com.sap.tc.moin.friends;


/**
 * The interface Constants provides several useful constants for use within the
 * "friends" API.
 */
public interface Constants {

    /**
     * The name of the tag used on association ends on the metamodel to specify
     * whether or not to store references at that end. Possible values are
     * either one of {@link #MARK_LINK_END_DONTSTORE},
     * {@link #MARK_LINK_END_REFERENCE} and {@link #MARK_LINK_END_STORE}. All
     * other values are considered as "no storage", i.e. as equal to
     * {@link #MARK_LINK_END_DONTSTORE}
     */
    public static final String MARK_LINK_END = "org.omg.sap2mof.store"; //$NON-NLS-1$

    /**
     * The value for the mark on association ends in the metamodel that
     * specifies that this end is stored in any case, regardless of whether or
     * not the association end is exposed by a reference.
     */
    public static final String MARK_LINK_END_STORE = "yes"; //$NON-NLS-1$

    /**
     * The value for the mark on association ends in the metamodel that
     * specifies that this end is definitely not stored, regardless of whether
     * or not the association end is exposed by a reference.
     */
    public static final String MARK_LINK_END_DONTSTORE = "no"; //$NON-NLS-1$

    /**
     * The value for the mark on association ends in the metamodel that
     * specifies that this end is stored if and only if the corresponding
     * association end is exposed by a reference. This value is at the same time
     * the default in case the tag is not present.
     */
    public static final String MARK_LINK_END_REFERENCE = "reference"; //$NON-NLS-1$

}
