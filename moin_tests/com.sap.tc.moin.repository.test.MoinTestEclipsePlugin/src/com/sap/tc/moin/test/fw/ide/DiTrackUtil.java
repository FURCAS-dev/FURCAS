package com.sap.tc.moin.test.fw.ide;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IStatus;

import com.sap.ide.dii05.model.api.IDevelopmentComponent;
import com.sap.ide.dii05.model.api.IDevelopmentConfiguration;
import com.sap.ide.dii05.model.api.ISoftwareComponent;
import com.sap.ide.dii05.repository.api.CheckoutState;
import com.sap.ide.dii05.repository.api.IChangelistProvider;
import com.sap.ide.dii05.repository.api.LocationState;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.PRI;


@SuppressWarnings( "nls" )
public interface DiTrackUtil {

    // Caution: 
    // Name server is configured the way, that it only allowes: "sap.com" as vendor for a test DC "test/..." ("test.sap.com" is not configured on this name server)
    static final String TEST_DC_VENDOR_IN_DI_TRACK = "sap.com";

    void importDevConfig( ) throws Exception;

    void cleanupDevConfig( );

    IDevelopmentConfiguration getDevConfig( ) throws Exception;

    /**
     * Returns first found modifiable Software Component
     */
    ISoftwareComponent getEditableSC( IDevelopmentConfiguration config );

    // Scenario 3: 
    // Remove DC (which is synced from DTR) from local disc --> sync state = not synced, but remote
    // Remark: Scenario 2 --> delete DC (is not supported in scenario 3)
    boolean removeDcs( IDevelopmentComponent[] developmentComponents ) throws Exception;

    void excludeFromSourceControl( IResource resource );

    CheckoutState getCheckoutState( IFile fileHandle ) throws Exception;

    boolean hasCheckoutLock( IFile fileHandle ) throws Exception;

    LocationState getLocationState( IFile fileHandle ) throws Exception;

    IStatus checkInChangeList( IDevelopmentConfiguration devConfig, IChangelistProvider changelistProvider, String changelistId );

    void createAndCheckInPartition( Connection connection, PRI pri, boolean partitionContainsTexts, boolean xlfFileExists, boolean performCheckIn, IDevelopmentConfiguration devConfig, IChangelistProvider changelistProvider, String changelistId ) throws Exception;

    void enableTestMode( String changelistId );

}
