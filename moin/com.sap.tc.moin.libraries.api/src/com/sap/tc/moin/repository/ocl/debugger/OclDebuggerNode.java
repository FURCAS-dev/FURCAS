package com.sap.tc.moin.repository.ocl.debugger;

import com.sap.tc.moin.repository.ocl.exceptions.InvalidValueException;


/**
 * This represents a node in an OCL Debugger tree.
 * <p>
 * This is essentially the Abstract Syntax tree enriched with the actual value
 * returned during evaluation.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface OclDebuggerNode {

    /** The type of the value */
    public enum NodeValueTypes {
        /**
         * A non-primitive single value
         */
        ModelElement,
        /**
         * Any multiple value
         */
        Collection,
        /**
         * Null
         */
        Void,
        /**
         * Boolean
         */
        Boolean,
        /**
         * Float
         */
        Float,
        /**
         * Long
         */
        Long,
        /**
         * Double
         */
        Double,
        /**
         * Enumeration Type
         */
        EnumerationType,
        /**
         * Integer
         */
        Integer,
        /**
         * String
         */
        String,
        /**
         * A Type expression (a classifier)
         */
        Type,
        /**
         * Unknown (because the value is null, for example)
         */
        Unknown
    }

    /** The "role" of the node */
    public enum NodeRoleTypes {
        /**
         * The argument (parameter) of an operation
         */
        Argument,
        /**
         * The Accumulator
         */
        Accumulator,
        /**
         * The Body of an operation
         */
        Body,
        /**
         * The parts of a literal collection
         */
        CollectionPart,
        /**
         * A List of Values
         */
        Listing,
        /**
         * The "if"-part of an if-then-else construct
         */
        IfCondition,
        /**
         * The "then" part of an if-then-else construct
         */
        Then,
        /**
         * The "else" part of an if-then-else construct
         */
        Else,
        /**
         * Initialization
         */
        Initialization,
        /**
         * A VariableDeclaration
         */
        VariableDeclaration,
        /** The Root expression */
        Root,
        /**
         * The source of an expression
         */
        Source,
        /**
         * An In-expression during a variable declaration
         */
        InStatement,
        /**
         * Anything else
         */
        Unknown
    }

    /**
     * @return a human-readable name
     */
    public String getNodeName( );

    /**
     * @return the value type
     */
    public NodeValueTypes getNodeValueType( );

    /**
     * @return the node role
     */
    public NodeRoleTypes getNodeRole( );

    /**
     * @return a String representation of the OCL expression
     */
    public String getOclExpression( );

    /**
     * Depending on the value type, this returns the corresponding Java value
     * (Boolean, Double and so on). The following value types are treated in a
     * special way:
     * <ul>
     * <li> {@link NodeValueTypes#Collection}: the result is a Java Collection
     * containing he values.<br>
     * The objects in this collection can be any object corresponding to one of
     * the value types, including (nested) Collections.</li> <li>
     * {@link NodeValueTypes#EnumerationType}: the result is <code>null</code>
     * </li> <li> {@link NodeValueTypes#ModelElement}: the result is not the
     * ModelElement, but a MRI </li> <li> {@link NodeValueTypes#Type}: the
     * result is the qualified name of the classifier (a List&ltString&gt) </li>
     * <li> {@link NodeValueTypes#Unknown}: this typically happens for parts of
     * the evaluation tree that have not been evaluated (for example because
     * they are in a conditional part); the result is <code>null</code></li> 
     * <li> {@link NodeValueTypes#Void}: the result is <code>null</code></li>
     * </ul>
     * <p>
     * OCL has the concept of "invalid values", for example the result of a
     * division by zero. This is different from "absence of value" (an attribute
     * value getter returning <code>null</code>, for example). In order to
     * distinguish "invalid" from "absence of value", the Exception must be
     * used.
     * 
     * @return the value
     * @throws InvalidValueException indicating an invalid value
     */
    public Object getResultValue( ) throws InvalidValueException;

    /**
     * @return the children, if any, or an empty array
     */
    public OclDebuggerNode[] getChildren( );

}
