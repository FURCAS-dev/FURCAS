package com.sap.tc.moin.ocl.utils.impl;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.omg.ocl.expressions.OclExpression;

import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.ocl.utils.OclStatement;

/**
 * This implementation should always be used internally since it implements the
 * hashCode and equals operations properly
 */
public class OclStatementImpl implements OclStatement {

    /**
     * The context of the OclExpression
     */
    private final RefObject context;

    /**
     * The oclExpression
     */
    private final OclExpression expression;

    /**
     * The stereotype of the OclStatement
     */
    private final int kind;

    /**
     * The name of the OclStatement; not final so that it can be set after
     * creation
     */
    private String name;

    /**
     * @param theContext context
     * @param theExpression expression
     * @param theKind kind
     * @param theName name
     */
    public OclStatementImpl( RefObject theContext, OclExpression theExpression, int theKind, String theName ) {

        this.context = theContext;
        this.expression = theExpression;
        this.kind = theKind;
        this.name = theName;
    }

    @Override
    public boolean equals( Object arg0 ) {

        if ( arg0 instanceof OclStatement ) {
            OclStatement stmt = (OclStatement) arg0;
            if ( this.kind == stmt.getKind( ) && this.context.equals( stmt.getContext( ) ) && this.expression.equals( stmt.getExpression( ) ) && this.name.equals( stmt.getName( ) ) ) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode( ) {

        int code = this.context.hashCode( );
        code = code ^ this.expression.hashCode( );
        code = code ^ this.name.hashCode( );
        // code = code ^ this.refPackages.hashCode();
        return code;
    }

    public RefObject getContext( ) {

        return this.context;
    }

    public OclExpression getExpression( ) {

        return this.expression;
    }

    public int getKind( ) {

        return this.kind;
    }

    public String getName( ) {

        return this.name;
    }

    /**
     * @param newName the new name
     */
    public void setName( String newName ) {

        this.name = newName;
    }

    @Override
    public String toString( ) {

        StringBuilder result = new StringBuilder( );
        if ( this.name != null ) {
            result.append( this.name );
        }
        try {
            result.append( " Context: " + this.context.refGetValue( OclConstants.F_NAME ) ); //$NON-NLS-1$
        } catch ( RuntimeException e ) {
            result.append( " Context: <unknown>" ); //$NON-NLS-1$
        }
        try {
            result.append( " Expression type: " ); //$NON-NLS-1$
            result.append( this.expression.getType( ).getName( ) );
        } catch ( RuntimeException e ) {
            result.append( " Expression type: <unknown>" ); //$NON-NLS-1$
        }
        return result.toString( );
    }
}
