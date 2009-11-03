package com.sap.tc.moin.ocl.utils;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.omg.ocl.expressions.OclExpression;

/**
 * Since <tt>OclExpression</tt>s are not attached to their constrained objects by default this class holds all the
 * information needed to attach the <tt>OclExpression</tt> later on. It gives you access to the context used during
 * parsing, the packages used to lookup types and the kind of the parsed <tt>OclExpression</tt> which van be a pre
 * condition, a post condition, an invariant, an operation's body or just an expression. You can use
 * <tt>Parser.connectStatementsToContext()</tt> to connect the <tt>OclExpression</tt> to its context.
 * 
 * @author Thomas Hettel (D039141)
 */
public interface OclStatement {

    /**
     * the parsed ocl statement started with "pre: ..."
     */
    public static final int PRE_CONDITION = 0;

    /**
     * the parsed ocl statement started with "post: ..."
     */
    public static final int POST_CONDITION = 1;

    /**
     * the parsed ocl statement started with "inv: ..."
     */
    public static final int INVARIANT = 2;

    /**
     * the parsed ocl statement is not a constraint just a simple expression.
     */
    public static final int EXPRESSION = 3;

    /**
     * the parsed ocl statement is the body of an operation.
     */
    public static final int OPERATION_BODY = 4;

    /**
     * the parsed ocl statement is the init expression of a Attribute or AssociationEnd.
     */
    public static final int INIT_EXPRESSION = 5;

    /**
     * the parsed ocl statement is a defintion of an attribute or operation.
     */
    public static final int DEFINITION = 6;

    /**
     * the parsed ocl statement describles how to derive the value of an Attribute or associationEnd
     */
    public static final int DERIVATION = 7;

    /**
     * Returns the kind (Stereotype) of the statement.
     * 
     * @return <code>PRE_CONDITION</code>,<code>POST_CONDITION</code>, <code>INVARIANT</code>,<code>OPERATION_BODY</code>
     * or <code>EXPRESSION</code>
     */
    public int getKind( );

    /**
     * Returns the OclExpression
     * 
     * @return the OclExpression of this OclStatement
     */
    public OclExpression getExpression( );

    /**
     * The object to which this statement is related to. This has either been supplied directly to the parser or has
     * been determined during parsing by the <code>context</code> statement.
     * 
     * @return the context of this OclStatement
     */
    public RefObject getContext( );

    /**
     * @return Returns the name of the statement. The name can be specified after the stereotype of a statement. E.g.
     * "inv myConstaraint: self....".
     */
    public String getName( );
}