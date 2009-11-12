//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from IndexType.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

public class IndexType
{
    public static final int INDEXTYPE_UNKNOWN = 0;
    public static final int INDEXTYPE_PHYSICAL = 1;
    /**< removed Memory=2 */
    public static final int INDEXTYPE_TEMPORARY = 3;
    public static final int INDEXTYPE_SPLIT = 4; /**< previously named 'Logical' */
    public static final int INDEXTYPE_OLAP = 5;
    public static final int INDEXTYPE_JOIN = 6;
    public static final int INDEXTYPE_HIERARCHY = 7;
    public static final int INDEXTYPE_PROPERTY = 8;
    public static final int INDEXTYPE_GLOBALDICT = 10;
}