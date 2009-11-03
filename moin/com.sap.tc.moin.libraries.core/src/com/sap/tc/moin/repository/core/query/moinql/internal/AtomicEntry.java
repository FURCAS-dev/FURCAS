/*
 * Created on 16.02.2006
 */
package com.sap.tc.moin.repository.core.query.moinql.internal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.query.moinql.shared.MQLAuxServices;
import com.sap.tc.moin.repository.spi.facility.fql.SpiFqlEntryType;
import com.sap.tc.moin.repository.spi.facility.fql.SpiFqlFromTypeCategory;
import com.sap.tc.moin.repository.spi.facility.fql.SpiFqlLocalConstraint;

/**
 * An AtomicEntry is one of two possible from-entries. It defines the MOF type
 * and possibly its subtypes via its MOF MRI. Optionally, the scope from which
 * the model elements are taken can be reduced in one of two ways: if included
 * is true, then the scope is defined by the PRIs found in the variable scope.
 * If included is false, then the scope is defined by the client scope, except
 * for the PRIs defined in the variable scope. Optionally, the elements of the
 * type can be constrained with a where-clause.
 */
public class AtomicEntry extends FromEntry implements SpiFqlEntryType {

    private List<MRI> classMRIs;

    private SpiFqlFromTypeCategory atomicEntryCategory;

    private List<String> classNames;

    private Set<PRI> scope;

    private Set<CRI> containerScope;

    // If included==false and scope.size() == 0, we assume global scope without restrictions.
    // If included==true and scope.size() == 0, the result set has to be empty
    private boolean included;

    // we keep a boolean flag indicating if the first MRI in classMRIs is that of MOF's Reflect::Element
    private boolean isReflectElement;

    // optional: null means not present
    private WhereClause whereClause = null;

    public AtomicEntry( AliasName _aliasName, List<MRI> _classMRIs, List<String> _classNames, SpiFqlFromTypeCategory _atomicEntryCategory, boolean _isReflectElement, Set<PRI> _scope, Set<CRI> _containerScope, boolean _included ) {

        this.atomicEntryCategory = _atomicEntryCategory;
        this.aliasName = _aliasName;
        this.classMRIs = ( _classMRIs == null ? new ArrayList<MRI>( 0 ) : _classMRIs );
        this.scope = ( _scope == null ? new HashSet<PRI>( 0 ) : _scope );
        this.included = _included;
        this.classNames = ( _classNames == null ? new ArrayList<String>( 0 ) : _classNames );
        this.containerScope = ( _containerScope == null ? new HashSet<CRI>( 0 ) : _containerScope );
        this.isReflectElement = _isReflectElement;
    }

    public void setWhereClause( WhereClause whereClause ) {

        this.whereClause = whereClause;
    }

    public void setClassMRIs( List<MRI> classMRIs ) {

        this.classMRIs = ( classMRIs == null ? new ArrayList<MRI>( 0 ) : classMRIs );
    }

    public void setClassNames( List<String> classNames ) {

        this.classNames = ( classNames == null ? new ArrayList<String>( 0 ) : classNames );
    }

    public void setScope( Set<PRI> scope, Set<CRI> containerScope, boolean _scopeIncluded ) {

        this.included = _scopeIncluded;
        this.scope = ( scope == null ? new HashSet<PRI>( 0 ) : scope );
        this.containerScope = ( containerScope == null ? new HashSet<CRI>( 0 ) : containerScope );
    }

    public List<MRI> getClassMRIs( ) {

        return this.classMRIs;
    }

    public boolean isScopeInclusive( ) {

        return this.included;
    }

    public Set<PRI> getScope( ) {

        return this.scope;
    }

    public WhereClause getWhereClause( ) {

        return this.whereClause;
    }

    public List<String> getClassNames( ) {

        return this.classNames;
    }

    public Set<CRI> getContainerScope( ) {

        return this.containerScope;
    }

    public MRI getClassMRI( ) {

        return getClassMRIs( ).get( 0 );
    }

    public String getClassName( ) {

        return getClassNames( ).get( 0 );
    }

    public SpiFqlFromTypeCategory getTypeCategory( ) {

        return this.atomicEntryCategory;
    }

    public void setAtomicEntryCategory( SpiFqlFromTypeCategory atomicEntryCategory ) {

        this.atomicEntryCategory = atomicEntryCategory;
    }

    public boolean isReflectElement( ) {

        return this.isReflectElement;
    }

    public void setReflectElement( boolean isReflectElement ) {

        this.isReflectElement = isReflectElement;
    }

    protected void printScope( StringBuilder mainEntryString, int indent ) {

        Set<PRI> pScope = getScope( );
        boolean _included = isScopeInclusive( );

        // shows partition scope provided it exists
        if ( pScope != null && pScope.size( ) != 0 ) {

            String prefix = MQLAuxServices.EMPTYSTR;

            // negated scope
            if ( !_included ) {
                prefix = MQLAuxServices.SPACE_T + MQLAuxServices.NOT_T + MQLAuxServices.SPACE_T + MQLAuxServices.IN_T + MQLAuxServices.SPACE_T + MQLAuxServices.PARTITION_T + MQLAuxServices.OPENCURLY_T;
            } else {
                prefix = MQLAuxServices.SPACE_T + MQLAuxServices.IN_T + MQLAuxServices.SPACE_T + MQLAuxServices.PARTITION_T + MQLAuxServices.OPENCURLY_T;
            }

            Iterator<PRI> scopeIterator = pScope.iterator( );

            mainEntryString.append( MQLAuxServices.newLine( indent ) + prefix + scopeIterator.next( ).toString( ) );

            for ( ; scopeIterator.hasNext( ); ) {
                PRI scopePRI = scopeIterator.next( );
                mainEntryString.append( MQLAuxServices.COMMA_T + MQLAuxServices.newLine( indent + prefix.length( ) ) );
                mainEntryString.append( scopePRI.toString( ) );
            }
            mainEntryString.append( MQLAuxServices.CLOSECURLY_T );
        }

        Set<CRI> cScope = getContainerScope( );

        // shows container scope provided the scope exists
        if ( cScope != null && cScope.size( ) != 0 ) {

            String prefix = MQLAuxServices.EMPTYSTR;

            // negated scope
            if ( !_included ) {
                prefix = MQLAuxServices.SPACE_T + MQLAuxServices.NOT_T + MQLAuxServices.SPACE_T + MQLAuxServices.IN_T + MQLAuxServices.SPACE_T + MQLAuxServices.CONTAINER_T + MQLAuxServices.OPENCURLY_T;
            } else {
                prefix = MQLAuxServices.SPACE_T + MQLAuxServices.IN_T + MQLAuxServices.SPACE_T + MQLAuxServices.CONTAINER_T + MQLAuxServices.OPENCURLY_T;
            }

            Iterator<CRI> containedScopeIterator = cScope.iterator( );

            mainEntryString.append( MQLAuxServices.newLine( indent ) + prefix + containedScopeIterator.next( ) );

            for ( ; containedScopeIterator.hasNext( ); ) {
                String containerName = containedScopeIterator.next( ).toString( );
                mainEntryString.append( MQLAuxServices.COMMA_T + MQLAuxServices.newLine( indent + prefix.length( ) ) );
                mainEntryString.append( containerName );
            }
            mainEntryString.append( MQLAuxServices.CLOSECURLY_T );
        }

        if ( _included && ( pScope == null || pScope.size( ) == 0 ) && ( cScope == null || cScope.size( ) == 0 ) ) {
            mainEntryString.append( MQLAuxServices.newLine( indent + 1 ) + MQLAuxServices.IN_T + MQLAuxServices.SPACE_T + MQLAuxServices.EMPTY_T );
        }
    }

    /*
     * Pretty-printing
     */
    public String toString( int indent, StringBuilder accumSb, int wIndent, StringBuilder whereSb ) {

        /* first we construct the from part */
        StringBuilder mainEntryString = new StringBuilder( );

        // MOF type and possible subtypes
        mainEntryString.append( MQLAuxServices.OPENCURLY_T );

        List<String> cNames = getClassNames( );
        List<MRI> cMRIs = getClassMRIs( );

        if ( cNames == null || cNames.size( ) == 0 ) {
            mainEntryString.append( ">>MQL Internal Format Error: no MOF types provided<<" ); //$NON-NLS-1$
        } else {
            mainEntryString.append( cNames.get( 0 ) );
            for ( int i = 1; i < cMRIs.size( ); i++ ) {
                mainEntryString.append( MQLAuxServices.COMMA_T + MQLAuxServices.newLine( indent + 1 ) + cNames.get( i ) );
            }
        }

        mainEntryString.append( MQLAuxServices.CLOSECURLY_T + MQLAuxServices.SPACE_T );

        // assign alias
        mainEntryString.append( MQLAuxServices.AS_T + MQLAuxServices.SPACE_T );
        mainEntryString.append( getAliasName( ).toString( ) );

        printScope( mainEntryString, indent );

        /* second, we construct a whereClause, provided there is one */
        StringBuilder whereEntriesString = new StringBuilder( );
        if ( getWhereClause( ) != null ) {
            whereEntriesString.append( MQLAuxServices.newLine( wIndent ) );
            String whereClausePrefix = MQLAuxServices.SPACE_T + MQLAuxServices.WHERE_T + MQLAuxServices.SPACE_T + MQLAuxServices.FOR_T + MQLAuxServices.SPACE_T + getAliasName( ).toString( ) + MQLAuxServices.OPENPAREN_T;
            int whereClauseIndent = wIndent + whereClausePrefix.length( );
            whereEntriesString.append( whereClausePrefix );
            getWhereClause( ).toString( whereClauseIndent, whereEntriesString );
            whereEntriesString.append( MQLAuxServices.CLOSEPAREN_T );
        }

        /* finalize */
        accumSb.append( mainEntryString );
        whereSb.append( whereEntriesString );

        return mainEntryString.toString( ) + MQLAuxServices.newLine( indent ) + whereSb.toString( );
    }

    @Override
    public String toString( ) {

        return toString( 0, new StringBuilder( ), 0, new StringBuilder( ) );
    }

    /*
     * FQL
     */

    public SpiFqlLocalConstraint getCondition( ) {

        return this.getWhereClause( );
    }

    public MRI[] getTypes( ) {

        List<MRI> mris = this.getClassMRIs( );
        return mris.toArray( new MRI[mris.size( )] );
    }

    public String[] getTypeNames( ) {

        List<String> typeNames = this.getClassNames( );
        return typeNames.toArray( new String[typeNames.size( )] );
    }

}
