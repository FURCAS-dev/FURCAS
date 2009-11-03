/*
 * Created on 10.02.2006
 */
package com.sap.tc.moin.repository.mql;

import com.sap.tc.moin.repository.MRI;


/**
 * A select alias is a type of select-entry, which only refers to an alias of a
 * from-entry. It specifies a column which will contain the {@link MRI}s of the
 * found model elements.
 */
final public class SelectAlias extends SelectEntry {

    /**
     * Constructs a select-entry, which selects the model elements represented
     * by the alias. The alias has to refer a MOF Class (e.g. it is not possible
     * to select a structure type). Each selection should only occur once in a
     * select-clause. The result set will have a column for this alias.
     * 
     * @param _aliasName the alias name of the selection
     */
    public SelectAlias( String _aliasName ) {

        this.aliasName = _aliasName;
    }

    @Override
    protected void toString( StringBuilder sb, int ident ) {

        sb.append( this.aliasName );
    }

}
