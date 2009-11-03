package com.sap.tc.moin.repository.core.jmi.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.sap.tc.moin.repository.shared.util.Utilities;

/**
 * Record containg meta-model maps.
 * 
 * @author D046220
 */
public final class MetaModelExtensionRecord {

    private java.util.List<java.lang.String> jmiClasses;

    private java.util.Map<java.lang.String, java.lang.String> mofIdClassNameMap;

    private java.util.Map<java.lang.String, java.lang.String> nameClassNameMap;

    private java.util.Map<java.lang.String, java.util.List<java.lang.String>> mofIdToQualifiedNameMapping;

    private java.util.Map<java.lang.String, java.util.Set<String>> typeMofIdToSuperTypesMapping;

    public MetaModelExtensionRecord( int nmn, int nnc, int acn, int mqn, int tst ) {

        this.mofIdClassNameMap = new HashMap<String, String>( Utilities.calcInitialCapacity( nmn ) );
        this.nameClassNameMap = new HashMap<String, String>( Utilities.calcInitialCapacity( nnc ) );
        this.jmiClasses = new ArrayList<String>( acn );
        this.mofIdToQualifiedNameMapping = new HashMap<String, List<String>>( Utilities.calcInitialCapacity( mqn ) );
        this.typeMofIdToSuperTypesMapping = new HashMap<String, Set<String>>( Utilities.calcInitialCapacity( mqn ) );
    }

    public java.util.Map<java.lang.String, java.lang.String> getMofIdClassNameMap( ) {

        return mofIdClassNameMap;
    }


    public java.util.Map<java.lang.String, java.lang.String> getNameClassNameMap( ) {

        return nameClassNameMap;
    }



    public java.util.List<java.lang.String> getJmiClasses( ) {

        return jmiClasses;
    }



    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> getMofIdToQualifiedNameMapping( ) {

        return mofIdToQualifiedNameMapping;
    }


    public java.util.Map<java.lang.String, java.util.Set<String>> getTypeMofIdToSuperTypesMapping( ) {

        return typeMofIdToSuperTypesMapping;
    }


}
