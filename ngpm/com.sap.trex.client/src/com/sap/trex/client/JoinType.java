//
// TrexClient - (c) Copyright 2008-2009 SAP AG
//
// created from JoinType.xsd/wsdl.  ! do not edit !
//
package com.sap.trex.client;

public class JoinType
{
    public static final int JOINTYPE_INNERJOIN = 0; /**< only use one of Inner/Outer-Join */
    public static final int JOINTYPE_LEFTOUTERJOIN = 1;
    public static final int JOINTYPE_RIGHTOUTERJOIN = 2;
    public static final int JOINTYPE_FULLOUTERJOIN = 3;
}