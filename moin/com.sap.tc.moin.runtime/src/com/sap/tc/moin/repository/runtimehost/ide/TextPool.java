package com.sap.tc.moin.repository.runtimehost.ide;

import org.eclipse.core.runtime.Platform;

/**
 * This class is the single access-point for all texts of this plugin.
 */
public class TextPool {

    // general
    public static final String PREFERENCES_PAGE_TITLE = "%_preferences_page_title"; //$NON-NLS-1$

    public static final String PREFERENCES_PAGE_DESCRIPTION = "%_preferences_page_description"; //$NON-NLS-1$

    /**
     * Returns the text for a key, which can be found in the resources.
     * 
     * @param key The key, which to find in the resources.
     * @return The text for a key, which can be found in the resources.
     */
    public static String getString( String key ) {

        return Platform.getResourceString( IdeRuntimeHostImpl.getDefault( ).getBundle( ), key );
    }
}
