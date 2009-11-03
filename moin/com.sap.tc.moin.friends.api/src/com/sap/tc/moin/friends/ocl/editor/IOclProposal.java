package com.sap.tc.moin.friends.ocl.editor;

import java.util.List;
import java.util.Locale;


/**
 * Represents a Proposal for the OCL Editor
 */
public interface IOclProposal extends Comparable<IOclProposal> {

    /**
     * @param locale
     * @return the String
     */
    public String getProposalString( Locale locale );

    /**
     * @return the replacement
     */
    public String getReplacement( );

    /**
     * The proposal type
     */
    public static enum TYPE {
        /** Attribute */
        ATTRIBUTE,
        /** Operation */
        OPERATION,
        /** Reference */
        REFERENCE,
        /** AssociationEnd */
        ASSOCIATIONEND,
        /** Package */
        PACKAGE,
        /** Class */
        CLASS,
        /** Association */
        ASSOCIATION,
        /** Undefined */
        UNDEFINED,
        /** Enumeration Label */
        ENUMLABEL,
        /** Enumeration type */
        ENUMTYPE,
        /** Structure Type */
        STRUCTURETYPE,
        /** Constant */
        CONSTANT,
        /** Variable */
        VARIABLE,
        /** Pattern */
        PATTERN,
        /** CollectionType */
        COLLECTIONTYPE,
        /** Standard Classifier */
        OCL,
        /** Primitive Type */
        PRIMITIVETYPE,


        /** Delete */
        DELETE,
        /** Insert */
        INSERT,
        /** Replace */
        REPLACE

    }

    /**
     * @return the parameters
     */
    public List<String> getParams( );

    /**
     * @return the delimiters
     */
    public List<String> getDelimiters( );

    /**
     * @return the type
     */
    public TYPE getType( );

    /**
     * @return the offset
     */
    public int getOffset( );

    /**
     * @return the delete length
     */
    public int getDelLength( );

    /**
     * @return the priority
     */
    public int getPriority( );

    /**
     * @param locale
     * @return additional information
     */
    public String getAdditionalinfo( Locale locale );

}
