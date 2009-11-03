package com.sap.tc.moin.repository.core.ocl.editorutils;

import com.sap.tc.moin.repository.exception.MoinExternalizedString;
import com.sap.tc.moin.repository.localization.ExternalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Externalized Messages in alphabetical order:
 * <ol>
 * <li>ComputeProposalTime_XMSG: Estimated time for computing proposals: {0} nanoseconds</li>
 * <li>FirstParseTime_XMSG: First parsing time: {0} nanoseconds</li>
 * <li>OverallParseTime_XMSG: Overall time for parsing: {0} nanoseconds</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from OclEditorServiceTraces.properties
 */
 
public enum OclEditorServiceTraces implements MoinExternalizedString {


    /**
     * Message: "Estimated time for computing proposals: {0} nanoseconds"
     */
    COMPUTEPROPOSALTIME("ComputeProposalTime_XMSG"), //$NON-NLS-1$

    /**
     * Message: "First parsing time: {0} nanoseconds"
     */
    FIRSTPARSETIME("FirstParseTime_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Overall time for parsing: {0} nanoseconds"
     */
    OVERALLPARSETIME("OverallParseTime_XMSG"); //$NON-NLS-1$

    private final static ExternalizedResourceBundleAccessor ACCESSOR = new ExternalizedResourceBundleAccessor( OclEditorServiceTraces.class );

    private final String myKey;

    private OclEditorServiceTraces( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );

    }

}  