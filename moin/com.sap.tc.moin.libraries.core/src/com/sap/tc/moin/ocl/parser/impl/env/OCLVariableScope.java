package com.sap.tc.moin.ocl.parser.impl.env;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationEndImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.ClassifierInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.MofClassInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ReferenceInternal;

import org.omg.ocl.expressions.VariableDeclaration;
import org.omg.ocl.expressions.__impl.VariableDeclarationImpl;
import org.omg.ocl.expressions.__impl.VariableDeclarationInternal;

import com.sap.tc.moin.ocl.parser.IOCLLookupTables;
import com.sap.tc.moin.ocl.parser.IOCLTypeChecker;
import com.sap.tc.moin.ocl.parser.IOCLVariableScope;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.jmi.util.MoinMetamodelCode;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;

/**
 * This class implements a scope of variable declarations and offers some basic
 * operations to access variable declarations in this scope.
 */
public class OCLVariableScope implements IOCLVariableScope {

    private final CoreConnection connection;

    /**
     * Creates a new VariableScope
     * 
     * @param actConnection the connection
     */
    public OCLVariableScope( CoreConnection actConnection ) {

        this.connection = actConnection;
    }

    /**
     * Maps a variable name to a VariableDeclaration
     */
    private Map<String, VariableDeclaration> varNameToDecl = new HashMap<String, VariableDeclaration>( );

    /**
     * A linear way of keeping the variables in Scope
     */
    protected List<VariableDeclarationInternal> varDeclList = new ArrayList<VariableDeclarationInternal>( );

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.ocl.parser.impl.env.IOCLVariableScope#declareVariable
     * (org.omg.ocl.expressions.VariableDeclaration)
     */
    public void declareVariable( VariableDeclaration varDecl ) {

        this.varNameToDecl.put( varDecl.getVarName( ), varDecl );
        this.varDeclList.add( (VariableDeclarationInternal) varDecl );
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.ocl.parser.impl.env.IOCLVariableScope#lookupVarByName
     * (java.lang.String)
     */
    public VariableDeclaration lookupVarByName( String varName ) {

        return this.varNameToDecl.get( varName );
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.ocl.parser.impl.env.IOCLVariableScope#lookupImplicitAttribute
     * (java.lang.String)
     */
    public Attribute lookupImplicitAttribute( String name ) {

        SpiJmiHelper jmiHelper = this.connection.getCoreJmiHelper( );
        // go through the stack of VariableDeclaration form top to bottom
        for ( int j = this.varDeclList.size( ) - 1; j >= 0; j-- ) {
            VariableDeclarationInternal varDecl = this.varDeclList.get( j );
            Classifier c = varDecl.getType( this.connection );
            if ( c instanceof MofClass ) {
                List<Attribute> attributes = jmiHelper.getAttributes( this.connection.getSession( ), (MofClass) c, true );
                for ( Iterator<Attribute> i = attributes.iterator( ); i.hasNext( ); ) {
                    Attribute a = i.next( );
                    if ( a.getName( ).equals( name ) ) {
                        return a;
                    }
                }
            }
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * @seecom.sap.tc.moin.ocl.parser.impl.env.IOCLVariableScope#
     * lookupImplicitAssociationEnd(java.lang.String)
     */
    public AssociationEnd lookupImplicitAssociationEnd( String name ) {

        SpiJmiHelper jmiHelper = this.connection.getCoreJmiHelper( );
        // go through the stack of VariableDeclaration form top to bottom
        for ( int j = this.varDeclList.size( ) - 1; j >= 0; j-- ) {
            VariableDeclarationInternal varDecl = this.varDeclList.get( j );
            ClassifierInternal c = (ClassifierInternal) varDecl.getType( this.connection );
            if ( c instanceof MofClassInternal ) {

                // as reference
                List<Reference> references = jmiHelper.getReferences( this.connection.getSession( ), (MofClass) c, true );
                for ( Iterator<Reference> i = references.iterator( ); i.hasNext( ); ) {
                    ReferenceInternal r = (ReferenceInternal) i.next( );
                    if ( r.getName( ).equals( name ) ) {
                        return r.getReferencedEnd( this.connection );
                    }

                }

                // as association end
                Set<AssociationEnd> associationEnds = jmiHelper.getAssociationEnds( this.connection.getSession( ), (Classifier) c, true );
                for ( Iterator<AssociationEnd> i = associationEnds.iterator( ); i.hasNext( ); ) {
                    AssociationEnd a = i.next( );
                    if ( a.getName( ).equals( name ) ) {
                        return a;
                    }
                }
            }
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * @seecom.sap.tc.moin.ocl.parser.impl.env.IOCLVariableScope#
     * findImplicitSourceForAssociation(java.lang.String)
     */
    public VariableDeclaration findImplicitSourceForAssociation( String name ) {

        SpiJmiHelper jmiHelper = this.connection.getCoreJmiHelper( );

        // go through the stack of VariableDeclaration form top to bottom
        for ( int j = this.varDeclList.size( ) - 1; j >= 0; j-- ) {
            VariableDeclarationInternal varDecl = this.varDeclList.get( j );
            ClassifierInternal c = (ClassifierInternal) varDecl.getType( this.connection );
            if ( c instanceof MofClassInternal ) {
                // as reference
                List<Reference> references = jmiHelper.getReferences( this.connection.getSession( ), (MofClass) c, true );
                for ( Iterator<Reference> i = references.iterator( ); i.hasNext( ); ) {
                    Reference r = i.next( );
                    if ( r.getName( ).equals( name ) ) {
                        return (VariableDeclaration) varDecl;
                    }

                }

                // as association end
                Set<AssociationEnd> associationEnds = jmiHelper.getAssociationEnds( this.connection.getSession( ), (Classifier) c, true );
                for ( Iterator<AssociationEnd> i = associationEnds.iterator( ); i.hasNext( ); ) {
                    AssociationEnd a = i.next( );
                    if ( a.getName( ).equals( name ) ) {
                        return (VariableDeclaration) varDecl;
                    }
                }
            }
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * @seecom.sap.tc.moin.ocl.parser.impl.env.IOCLVariableScope#
     * findImplicitSourceForAttr(java.lang.String)
     */
    public VariableDeclaration findImplicitSourceForAttr( String name ) {

        // go through the stack of VariableDeclaration form top to bottom
        for ( int j = this.varDeclList.size( ) - 1; j >= 0; j-- ) {
            VariableDeclarationInternal varDecl = this.varDeclList.get( j );
            ClassifierInternal c = (ClassifierInternal) varDecl.getType( this.connection );
            if ( c instanceof MofClassInternal ) {
                List<Attribute> attributes = this.connection.getCoreJmiHelper( ).getAttributes( this.connection.getSession( ), (MofClass) c, true );
                for ( Iterator<Attribute> i = attributes.iterator( ); i.hasNext( ); ) {
                    Attribute a = i.next( );
                    if ( a.getName( ).equals( name ) ) {
                        return (VariableDeclaration) varDecl;
                    }
                }
            }
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.ocl.parser.impl.env.IOCLVariableScope#findImplicitSourceForOp
     * (java.lang.String, java.util.List,
     * com.sap.tc.moin.ocl.parser.IOCLLookupTables,
     * com.sap.tc.moin.ocl.parser.IOCLTypeChecker)
     */
    public VariableDeclaration findImplicitSourceForOp( String opName, List<Classifier> args, IOCLLookupTables lookupTables, IOCLTypeChecker oclTypeChecker ) {

        // go through the stack of VariableDeclaration form top to bottom
        for ( int i = this.varDeclList.size( ) - 1; i >= 0; i-- ) {
            VariableDeclarationImpl varDecl = (VariableDeclarationImpl) this.varDeclList.get( i );
            Classifier c = varDecl.getType( this.connection );
            if ( lookupTables.lookupOperation( c, opName, args, oclTypeChecker ) != null ) {
                return varDecl;
            }
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * @seecom.sap.tc.moin.ocl.parser.impl.env.IOCLVariableScope#
     * findImplicitSourceForQualifiedAssociation(com.sap.tc.moin.repository.mmi.model.AssociationEnd,
     * com.sap.tc.moin.ocl.parser.IOCLTypeChecker)
     */
    public VariableDeclaration findImplicitSourceForQualifiedAssociation( AssociationEnd end, IOCLTypeChecker oclTypeChecker ) {

        // go through the stack of VariableDeclaration form top to bottom
        for ( int j = this.varDeclList.size( ) - 1; j >= 0; j-- ) {
            VariableDeclarationImpl varDecl = (VariableDeclarationImpl) this.varDeclList.get( j );
            Classifier c = varDecl.getType( this.connection );
            if ( c instanceof MofClass ) {
                // check for type conformity
                if ( oclTypeChecker.typesConform( c, ( (AssociationEndImpl) MoinMetamodelCode.otherEnd( this.connection, (AssociationEndImpl) end ) ).getType( this.connection ) ) ) {
                    return varDecl;
                }
            }
        }
        return null;
    }
}
