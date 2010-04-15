package com.sap.tc.moin.ocl.utils.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.DirectionKindEnum;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.Parameter;
import com.sap.tc.moin.repository.mmi.model.__impl.ModelElementInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.MofPackageInternal;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import org.omg.ocl.expressions.OclExpression;

import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.repository.core.CoreConnection;

/**
 * This class serializes <tt>OclStatement</tt>s and <tt>OclExpression</tt>s into
 * OCL concrete syntax in a way such that it can be parsed again. OclSerializer
 * also supports indentation and spans statements across several lines. Names
 * can be serialized as fully qualified names or package local names. <h3>
 * Example:</h3> with <tt>printPackage=true</tt>, <tt>localNames=false</tt>,
 * <tt>indentationStep=2</tt>, <tt>baseIndentation=0</tt>,
 * 
 * <pre>
 *  package ServiceInteractions
 *    context ServiceInteractions::Message
 *      inv MyInvariant: 
 *        not self.reply_to.isFault
 *  endpackage
 * </pre>
 * 
 * <h3>Example:</h3> with <tt>printPackage=false</tt>, <tt>localNames=true</tt>,
 * <tt>indentationStep=0</tt>, <tt>baseIndentation=0</tt>,
 * 
 * <pre>
 *  context Message
 *  inv MyInvariant: 
 *  not self.reply_to.isFault
 *  </pre>
 */
public class OclSerializer {

    /**
     * amount of spaces to indent per step
     */
    private final int myIndentation;

    /**
     * the base indentation
     */
    private final int myBaseIndentation;

    /**
     * whether to print the package information "package A::B ... endpackage"
     */
    private final boolean myPrintPackage;

    /**
     * whether to print package local names or fully qualified names.
     */
    private final boolean myLocalNames;

    /**
     * the current indentation
     */
    private String myCurrentIndentation = OclConstants.EMPTY;

    private final SerializationHelper mySerializationHelper = new SerializationHelper( );

    private final CoreConnection connection;

    /**
     * @param connection the core connection
     * @return a default instances
     */
    public static OclSerializer getInstance( CoreConnection connection ) {

        return new OclSerializer( connection, false, false, 4, 4 );
    }

    /**
     * Creates a new OclSerializer
     * 
     * @param printPackage whether to print the package statement
     * @param localNames whether to print package local or fully qualified names
     * @param indentationStep amount of spaces to indent on each step
     * @param baseIndentation amount of spaces of the base indentation
     */
    private OclSerializer( CoreConnection actConnection, boolean printPackage, boolean localNames, int indentationStep, int baseIndentation ) {

        this.connection = actConnection;
        this.myIndentation = indentationStep;
        this.myBaseIndentation = baseIndentation;
        this.myPrintPackage = printPackage;
        this.myLocalNames = localNames;
        for ( int i = 0; i < baseIndentation; i++ ) {
            this.myCurrentIndentation += " "; //$NON-NLS-1$
        }
    }

    /**
     * Serializes a <tt>OclExpression</tt> into a string representation in OCL
     * concrete syntax.
     * 
     * @param expr the OclExpression to serialize
     * @param packages the packages to which the types in the expression belong
     * to. If left empty all pathnames are serialized to global names. If
     * <tt>localNames</tt> is set, types contained in these packages are
     * serialized using package local names. Others are serialized using global
     * names.
     * @return a String representation in OCL concrete syntax of the expression
     * @throws OclSerializationException if anything unexpected happens.
     */
    public String serialize( OclExpression expr, RefPackage[] packages ) throws OclSerializationException {

        MofPackage[] mp;
        try {
            mp = toMofPackage( packages );
            Ocl2TextTW ocl2text = new Ocl2TextTW( this.connection, mp );

            return ocl2text.transformToText( expr );
        } catch ( RuntimeException e ) {
            throw new OclSerializationException( e );
        }
    }

    /**
     * Serializes an OclStatement. <tt>stmt</tt> must have exactly one package
     * if <tt>printPackage</tt> is set to<tt>true</tt>, otherwise it cannot be
     * serialized.
     * 
     * @param stmt the OclStatement to serialize
     * @return a string representation of stmt in OCL concrete syntax
     * @throws OclSerializationException <tt>stmt</tt> has more than one package
     * and printPackage is set to true, or anything unexpected happens
     */
    public String serialize( OclStatement stmt ) throws OclSerializationException {

        if ( stmt == null ) {
            throw new OclSerializationException( OclConstants.CANNOT_SERIALIZE_NULL_EXCEPTION );
        }

        // the package which contains all types used in the statement
        MofPackage[] mp = toMofPackage( new RefPackage[] { stmt.getContext( ).refOutermostPackage( ) } );
        List<List<String>> packageNames = new Vector<List<String>>( );
        for ( int i = 0; i < mp.length; i++ ) {
            packageNames.add( ( (MofPackageInternal) mp[i] ).getQualifiedName( this.connection ) );
        }

        String serializedStmt = OclConstants.EMPTY;
        // print "package ..." only if required
        if ( this.myPrintPackage ) {
            // "package" can only be printed if there is exactly one package
            // if (stmt.getPackages().length != 1) {
            // throw new OclSerializationException("OclStatements must have exactly one
            // RefPackage!");
            // }
            // indent "package" is necessary
            serializedStmt += getIndentation( );
            serializedStmt += "package " + toPathName( ( (MofPackageInternal) mp[0] ).getQualifiedName( this.connection ) ) + "\n"; //$NON-NLS-1$ //$NON-NLS-2$
            // indent one step for the "context"
            increaseIndentation( );
        }
        // indent
        serializedStmt += getIndentation( );
        // serialize the context: "contex MyClass " ...
        serializedStmt += serializeContext( stmt, packageNames ) + "\n"; //$NON-NLS-1$
        increaseIndentation( );

        // serialize the stereotype "inv MyInvariant:"
        if ( stmt.getKind( ) != OclStatement.EXPRESSION ) {
            serializedStmt += getIndentation( ) + serializeStereoType( stmt );
            // indent for the actual ocl expression
            increaseIndentation( );
        }
        serializedStmt += getIndentation( );
        try {
            // serialize the actual OCL Expression
            Ocl2TextTW ocl2Text;
            if ( this.myLocalNames ) {
                ocl2Text = new Ocl2TextTW( this.connection, mp );
            } else {
                ocl2Text = new Ocl2TextTW( this.connection, new MofPackage[] {} );
            }
            serializedStmt += ocl2Text.transformToText( stmt.getExpression( ) );
        } catch ( RuntimeException e ) {
            throw new OclSerializationException( e );
        }
        // un-indent to stereotype level
        decreaseIndentation( );
        // un-indent to "context"-level
        decreaseIndentation( );
        // print "endpackage" only if required
        if ( this.myPrintPackage ) {
            // decrease indentation of package
            decreaseIndentation( );
            serializedStmt += "\n"; //$NON-NLS-1$
            serializedStmt += getIndentation( ) + "endpackage"; //$NON-NLS-1$
        }
        // return serialized statement
        return serializedStmt;
    }

    /**
     * Serializes the context of a statement. Example: "<tt>context MyClass</tt>
     * " or "<tt>context myOperation(i:Integer,r:Real):Boolean</tt>"
     * 
     * @param stmt the statement
     * @param packageNames the MOF package containing the context
     * @return a String representing the <tt>context</tt> expression.
     */
    private String serializeContext( OclStatement stmt, List<List<String>> packageNames ) {

        String s = OclConstants.EMPTY;
        if ( stmt.getContext( ) instanceof Classifier ) {
            Classifier context = (Classifier) stmt.getContext( );
            s += "context " + serializeQName( ( (ModelElementInternal) context ).getQualifiedName( this.connection ), packageNames ); //$NON-NLS-1$
        } else if ( stmt.getContext( ) instanceof Operation ) {
            Operation op = (Operation) stmt.getContext( );
            s += "context " + serializeOperation( op, packageNames ); //$NON-NLS-1$
        } else if ( stmt.getContext( ) instanceof Attribute ) {
            Attribute attr = (Attribute) stmt.getContext( );
            s += "context " + serializeQName( ( (ModelElementInternal) attr ).getQualifiedName( this.connection ), packageNames ); //$NON-NLS-1$
        } else if ( stmt.getContext( ) instanceof Association ) {
            Association assoc = (Association) stmt.getContext( );
            s += "context " + serializeQName( ( (ModelElementInternal) assoc ).getQualifiedName( this.connection ), packageNames ); //$NON-NLS-1$
        } else if ( stmt.getContext( ).refMetaObject( ) instanceof Classifier ) {
            Classifier context = (Classifier) stmt.getContext( ).refMetaObject( );
            s += "context " + serializeQName( ( (ModelElementInternal) context ).getQualifiedName( this.connection ), packageNames ); //$NON-NLS-1$

        }
        return s;
    }

    /**
     * Serializes the stereotype of a statement and the statement's name.
     * Example: "<tt>inv MyInvariant:</tt>"
     * 
     * @param stmt the statement
     * @return a String representing the stereotype and the name of the
     * statement with a trailing space.
     */
    private String serializeStereoType( OclStatement stmt ) {

        String name = stmt.getName( );
        if ( name == null ) {
            name = OclConstants.EMPTY;
        }
        // if the name is not empty prepend a space
        if ( !name.equals( OclConstants.EMPTY ) ) {
            name = OclConstants.SPACE + name;
        }

        String s = OclConstants.EMPTY;

        switch ( stmt.getKind( ) ) {
            case OclStatement.INVARIANT:
                s = "inv"; //$NON-NLS-1$
                break;
            case OclStatement.DEFINITION:
                s = "def";//$NON-NLS-1$
                break;
            case OclStatement.DERIVATION:
                s = "derive";//$NON-NLS-1$
                break;
            case OclStatement.EXPRESSION:
                // nothing to do
                return "";//$NON-NLS-1$
            case OclStatement.INIT_EXPRESSION:
                s = "init";//$NON-NLS-1$
                break;
            case OclStatement.OPERATION_BODY:
                s = "body";//$NON-NLS-1$
                break;
            case OclStatement.POST_CONDITION:
                s = "post";//$NON-NLS-1$
                break;
            case OclStatement.PRE_CONDITION:
                s = "pre";//$NON-NLS-1$
                break;
        }
        return s + name + ": \n";//$NON-NLS-1$
    }

    /**
     * Serializes an operation with all its parameter definitions and its return
     * type.
     * 
     * @param op the operation to create a string representation for
     * @param packageNames the package used to lookup types.
     * @return a String representing Operation op.
     */
    private String serializeOperation( Operation op, List<List<String>> packageNames ) {

        String s = OclConstants.EMPTY;
        s = serializeQName( op.getQualifiedName( ), packageNames );
        s += "("; //$NON-NLS-1$
        boolean prependComma = false;
        Classifier returnType = null;
        for ( Iterator<ModelElement> i = op.getContents( ).iterator( ); i.hasNext( ); ) {
            Parameter p = (Parameter) i.next( );
            if ( p.getDirection( ) == DirectionKindEnum.IN_DIR ) {
                if ( prependComma ) {
                    s += ", "; //$NON-NLS-1$
                }
                prependComma = true;
                s += p.getName( ) + ":" + serializeQName( p.getType( ).getQualifiedName( ), packageNames ); //$NON-NLS-1$

            } else if ( p.getDirection( ) == DirectionKindEnum.RETURN_DIR ) {
                returnType = p.getType( );
            }
        }
        if ( returnType != null ) {
            s += "):" + serializeQName( returnType.getQualifiedName( ), packageNames ); //$NON-NLS-1$
        } else {
            s += "):void"; //$NON-NLS-1$
        }
        return s;
    }

    /**
     * Takes a List of names (i.e. the fully qualified name) and turns it into a
     * String with double colons between the elements of pathName.
     * 
     * @param pathName
     * @return String with double colons between the elements of pathName.
     */
    private String toPathName( List<String> qname ) {

        StringBuilder s = new StringBuilder( );
        if ( qname.size( ) > 0 ) {
            if ( qname.get( 0 ) != null ) {
                s.append( qname.get( 0 ) );
            }
            for ( int i = 1; i < qname.size( ); i++ ) {
                if ( qname.get( 0 ) != null ) {
                    s.append( OclConstants.PATHSEP );
                    s.append( qname.get( i ) );
                }
            }
            return s.toString( );
        }
        return OclConstants.EMPTY;

    }

    /**
     * Turns a qualified name into a string. It transforms fully qualified names
     * into package local names.
     * 
     * @param qName the fully qualified name to be serialized
     * @param packageNames the packages to which qName can be local
     * @return a String representation of the qualified name
     */
    private String serializeQName( List<String> qName, List<List<String>> packageNames ) {

        if ( this.myLocalNames ) {
            return this.mySerializationHelper.qNameToLocalString( qName, packageNames );
        }
        return this.mySerializationHelper.qNameToString( qName );

    }

    /**
     * @return the current amount of spaces as indentation
     */
    private String getIndentation( ) {

        return this.myCurrentIndentation;
    }

    /**
     * increases the current indentation by <tt>indentationStep</tt>
     */
    private void increaseIndentation( ) {

        for ( int i = 0; i < this.myIndentation; i++ ) {
            this.myCurrentIndentation += OclConstants.SPACE;
        }
    }

    /**
     * decreases the current indentation by <tt>indentationStep</tt>
     */
    private void decreaseIndentation( ) {

        if ( this.myCurrentIndentation.length( ) >= this.myIndentation + this.myBaseIndentation ) {
            this.myCurrentIndentation = this.myCurrentIndentation.substring( this.myIndentation );
        }
    }

    /**
     * Converts an array of RefPackages to an array of MofPackages
     * 
     * @param p the array of RefPackages
     * @return an array of MofPackages
     */
    private MofPackage[] toMofPackage( RefPackage[] p ) {

        MofPackage[] mofPackages = new MofPackage[p.length];
        for ( int i = 0; i < p.length; i++ ) {
            if ( p[i] instanceof MofPackage ) {
                mofPackages[i] = (MofPackage) p[i];
            } else {
                mofPackages[i] = p[i].refMetaObject( );
            }
        }
        return mofPackages;
    }

}
