//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from Operator.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

public class Operator
{
    public static final int OPERATOR_EQ = 2; /**< equal */
    public static final int OPERATOR_LT = 1; /**< less than */
    public static final int OPERATOR_GT = 3; /**< greater than */
    public static final int OPERATOR_NE = 4; /**< not equal */
    public static final int OPERATOR_GE = 5; /**< greater or equal */
    public static final int OPERATOR_LE = 6; /**< less or equal */
    public static final int OPERATOR_BT = 0; /**< between */
    public static final int OPERATOR_NB = 7; /**< not between */
    public static final int OPERATOR_MATCH = 8;
    public static final int OPERATOR_JOIN = 9;
    public static final int OPERATOR_LEFTOUTERJOIN = 10;
    public static final int OPERATOR_RIGHTOUTERJOIN = 11;
    public static final int OPERATOR_FULLOUTERJOIN = 12;
    public static final int OPERATOR_PATTERN = 13;
}