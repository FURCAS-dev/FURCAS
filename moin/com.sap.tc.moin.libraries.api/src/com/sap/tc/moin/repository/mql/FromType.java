/*
 * Created on 10.02.2006
 */
package com.sap.tc.moin.repository.mql;


/**
 * This type of from-entry is defined per qualified MOF name.
 */
public class FromType extends FromEntry {

    /*
     * The qualified name of the type for this from entry.
     */
    private String[] qName;

    /*
     * Optionally a container name can be provided to reduce the scope in which
     * to resolve the qualified name.
     */
    private String containerName;

    /**
     * With this type of from-entry, the from-set is defined to be all the
     * instances of the type given by the qualified name. The alias can be used
     * elsewhere to identify this from-entry. If withoutSubtypes==true, then the
     * instances of the sub-types of the qualified type name are <b>not</b>
     * considered in the from-set.
     * 
     * @param _aliasName of the FromEntry
     * @param _qName the fully qualified name of the type of the from Entry
     * @param _withoutSubtypes to indicated whether subtypes are to be included
     * or not
     */
    public FromType( String _aliasName, String[] _qName, boolean _withoutSubtypes ) {

        this.aliasName = _aliasName;
        this.qName = _qName;
        this.containerName = null;
        this.withoutSubtypes = _withoutSubtypes;
    }

    /**
     * With this type of from-entry, the from-set is defined to be all the
     * instances of the type given by the qualified name. The alias can be used
     * elsewhere to identify this from-entry. If withoutSubtypes==true, then the
     * instances of the sub-types of the qualified type name are <b>not</b>
     * considered in the from-set. A {@link QueryScopeProvider} is provided to
     * additionally limit where the instances of the type or types in this from
     * entry are to be taken from.
     * 
     * @param _aliasName of the FromEntry
     * @param _qName the fully qualified name of the type of the from Entry
     * @param _withoutSubtypes to indicated whether subtypes are to be included
     * or not
     * @param queryScopeProvider the query scope provider to limit the scope of
     * where instances are taken from
     */
    public FromType( String _aliasName, String[] _qName, boolean _withoutSubtypes, QueryScopeProvider queryScopeProvider ) {

        this( _aliasName, _qName, _withoutSubtypes );
        this.included = queryScopeProvider.isInclusiveScope( );
        this.partitionScope = queryScopeProvider.getPartitionScope( );
        this.criScope = queryScopeProvider.getContainerScope( );
    }

    /**
     * With this type of from-entry, the from-set is defined to be all the
     * instances of the type given by the qualified name. The alias can be used
     * elsewhere to identify this from-entry. If withoutSubtypes==true, then the
     * instances of the sub-types of the qualified type name are <b>not</b>
     * considered in the from set.
     * 
     * @param _aliasName of the FromEntry
     * @param _qName the fully qualified name of the type of the from Entry
     * @param _containerName the container name of the type of the from Entry
     * @param _withoutSubtypes to indicated whether subtypes are to be included
     * or not
     */
    public FromType( String _aliasName, String[] _qName, String _containerName, boolean _withoutSubtypes ) {

        this.aliasName = _aliasName;
        this.qName = _qName;
        this.containerName = _containerName;
        this.withoutSubtypes = _withoutSubtypes;
    }

    /**
     * With this type of from-entry, the from-set is defined to be all the
     * instances of the type given by the qualified name. The alias can be used
     * elsewhere to identify this from-entry. If withoutSubtypes==true, then the
     * instances of the sub-types of the qualified type name are <b>not</b>
     * considered in the from set.
     * 
     * @param _aliasName of the FromEntry
     * @param _qName the fully qualified name of the type of the from Entry
     * @param _containerName the container name of the type of the from Entry
     * @param _withoutSubtypes to indicated whether subtypes are to be included
     * or not
     * @param queryScopeProvider the query scope provider to limit the scope of
     * where instances are taken from
     */
    public FromType( String _aliasName, String[] _qName, String _containerName, boolean _withoutSubtypes, QueryScopeProvider queryScopeProvider ) {

        this.aliasName = _aliasName;
        this.qName = _qName;
        this.containerName = _containerName;
        this.withoutSubtypes = _withoutSubtypes;
        this.included = queryScopeProvider.isInclusiveScope( );
        this.criScope = queryScopeProvider.getContainerScope( );
        this.partitionScope = queryScopeProvider.getPartitionScope( );
    }

    /**
     * Returns the qualified name of this from-entry.
     * 
     * @return the qualified name of this from-entry.
     */
    public String[] getQualifiedName( ) {

        return this.qName;
    }

    /**
     * Returns the container name used to resolved the qualified name of this
     * from-entry. Returns null if no such container was provided.
     * 
     * @return the container name used to resolved the qualified name of this
     * from-entry. Returns null if no such container was provided.
     */
    public String getContainerName( ) {

        return this.containerName;
    }

    @Override
    protected void toString( StringBuilder sb, int indent ) {

        sb.append( "type: " ); //$NON-NLS-1$
        sb.append( this.containerName );
        sb.append( '#' );
        if ( this.qName != null && this.qName.length > 0 ) {
            sb.append( this.qName[0] );
            for ( int i = 1; i < this.qName.length; i++ ) {
                sb.append( "::" ); //$NON-NLS-1$
                sb.append( this.qName[i] );
            }
        }
        super.toString( sb, indent + 6 );
    }
}
