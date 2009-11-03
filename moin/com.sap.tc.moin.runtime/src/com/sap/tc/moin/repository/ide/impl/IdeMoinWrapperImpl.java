/**
 * 
 */
package com.sap.tc.moin.repository.ide.impl;

import com.sap.tc.moin.repository.cdam.CompoundDataAreaManager;
import com.sap.tc.moin.repository.cdam.ide.IdeCompoundDataAreaManager;
import com.sap.tc.moin.repository.core.CoreMoin;
import com.sap.tc.moin.repository.core.MoinWrapper;
import com.sap.tc.moin.repository.ide.IdeMoin;
import com.sap.tc.moin.repository.spi.core.SpiMoin;


/**
 * Eclipse specific wrapper of the MOIN instance.
 * <p>
 * Implements the eclipse specific {@link IdeMoin} interface and thereby exposes
 * the {@link CompoundDataAreaManager} as scenario-specific
 * {@link IdeCompoundDataAreaManager}.
 * <p>
 * TODO: implement a destroy method which invalidates the wrapper instance and
 * nulls out the reference to the wrapped object, so that it can be collected
 * 
 * @author d032434
 */
public class IdeMoinWrapperImpl extends MoinWrapper implements IdeMoin {

    /**
     * @param moin
     */
    public IdeMoinWrapperImpl( SpiMoin moin ) {

        super( (CoreMoin) moin );
        // TODO Auto-generated constructor stub
    }

    /**
     * @see JsMoin#getCompoundDataAreaManager()
     */
    @Override
    public IdeCompoundDataAreaManager getCompoundDataAreaManager( ) {

        return (IdeCompoundDataAreaManager) super.getCompoundDataAreaManager( );
    }
}
