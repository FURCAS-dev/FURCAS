//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from RowType.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

public class RowType
{
    public static final int ROWTYPE_CONTENT = 0; /**< formerly known as Term */
    public static final int ROWTYPE_ATTRIBUTE = 1;
    public static final int ROWTYPE_BRACKETOPEN = 3;
    public static final int ROWTYPE_BRACKETCLOSE = 4;
    public static final int ROWTYPE_EXPRESSION = 5;
    public static final int ROWTYPE_FREESTYLE = 7;
    public static final int ROWTYPE_NLI = 8;
    public static final int ROWTYPE_LUCENE = 9;
    public static final int ROWTYPE_OPERATOR = -2; /**< replaced with Operator... */
    public static final int ROWTYPE_OPERATORNOT = 100;
    public static final int ROWTYPE_OPERATORAND = 101;
    public static final int ROWTYPE_OPERATOROR = 102;
    public static final int ROWTYPE_OPERATORNEAR = 103;
}