/*
 * Created on 10.02.2006
 */
package com.sap.tc.moin.repository.mql;

import com.sap.tc.moin.repository.MRI;

/**
 * This type of from-entry is defined by the {@link MRI} of a meta-model
 * element.
 */
public class FromTypeMri extends FromEntry {

    /*
     * The from entry refers to a type via a MRI
     */
    private MRI mri;

    /**
     * With this type of from-entry, the from-set is defined to be all the
     * instances of the type given by the {@link MRI} of meta-model element. The
     * alias can be used elsewhere to identify this from-entry. If
     * withoutSubtypes==true, then the instances of the sub-types of the
     * qualified type name are <b>not</b> considered in the from-set.
     * 
     * @param _aliasName of the FromEntry
     * @param _mri the MRI of the type of the from entry
     * @param _withoutSubtypes to indicated whether subtypes are to be included
     * or not
     */
    public FromTypeMri( String _aliasName, MRI _mri, boolean _withoutSubtypes ) {

        this.aliasName = _aliasName;
        this.mri = _mri;
        this.withoutSubtypes = _withoutSubtypes;
    }

    /**
     * With this type of from-entry, the from-set is defined to be all the
     * instances of the type given by the {@link MRI} of meta-model element. The
     * alias can be used elsewhere to identify this from-entry. If
     * withoutSubtypes==true, then the instances of the sub-types of the
     * qualified type name are <b>not</b> considered in the from-set.
     * 
     * @param _aliasName of the FromEntry
     * @param _mri the MRI of the type of the from entry
     * @param _withoutSubtypes to indicated whether subtypes are to be included
     * or not
     * @param queryScopeProvider the query scope provider to limit the scope of
     * where instances are taken from
     */
    public FromTypeMri( String _aliasName, MRI _mri, boolean _withoutSubtypes, QueryScopeProvider queryScopeProvider ) {

        this.aliasName = _aliasName;
        this.mri = _mri;
        this.withoutSubtypes = _withoutSubtypes;
        this.included = queryScopeProvider.isInclusiveScope( );
        this.partitionScope = queryScopeProvider.getPartitionScope( );
        this.criScope = queryScopeProvider.getContainerScope( );
    }

    /**
     * Returns the MRI which defines the type of this from-entry.
     * 
     * @return the MRI which defines the type of this from-entry.
     */
    public MRI getMri( ) {

        return this.mri;
    }

    @Override
    protected void toString( StringBuilder sb, int indent ) {

        sb.append( "type: " ); //$NON-NLS-1$
        sb.append( this.mri.toString( ) );
        super.toString( sb, indent + 6 );
    }

}
