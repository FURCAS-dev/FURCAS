package com.sap.tc.moin.repository.mql;

/**
 * This record defines the form of one column in an MQL result set.
 */
final public class MQLColumnType {

    /**
     * the name of the alias as it was used during execution
     */
    public String newRuntimeAlias;

    /**
     * the name of the alias involved
     */
    public String alias;

    /**
     * this value is null if the column actually has the MRI of the alias,
     * otherwise this String value indicates the attribute of the column
     */
    public String attribute = null;

    /**
     * if the column is actually an attribute, it is possibly multi-valued. This
     * value is only relevant if attribute !=null
     */
    public boolean multiValued = false;

    /**
     * if the column is multi-valued, this attribute indicates if the values are
     * ordered
     */
    public boolean isOrdered = false;

    /**
     * if the column is multi-valued, this attribute indicates if the values are
     * unique
     */
    public boolean isUnique = false;

    /**
     * indicates the type name of the values in the column. If we have model
     * elements, it contains the fully qualified type name of the alias,
     * otherwise the (Java) primitive type of the attribute, or, if it is
     * multi-valued, the Java primitive type of the elements in the returned
     * collection
     */
    public String typeName;
}
