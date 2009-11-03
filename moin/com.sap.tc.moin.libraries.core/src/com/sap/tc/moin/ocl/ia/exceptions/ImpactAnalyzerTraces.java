package com.sap.tc.moin.ocl.ia.exceptions;

import com.sap.tc.moin.repository.exception.MoinExternalizedString;
import com.sap.tc.moin.repository.localization.ExternalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Externalized Messages in alphabetical order:
 * <ol>
 * <li>AnalyzeOutput_XMSG: ImpactAnalyzer.analyze() for {0} statements resulted in {1} events, took {2} ms for class scope analysis, {3} ms for instance scope analysis and {4} ms for filtering </li>
 * <li>AnalyzeStart_XMSG: ImpactAnalyzer.analyze(): OclStatement [{0}]</li>
 * <li>FilterEnd_XMSG: ImpactAnalyzer.filter() for one ModelChangeEvent took {0} ms and returned {1} evaluation units</li>
 * <li>FilterMultEnd_XMSG: ImpactAnalyzer.filter() for {0} events took {1} ms and returned {2} evaluation units</li>
 * <li>FilterMultStart_XMSG: ImpactAnalyzer.filter(): ModelChangeEvent[{0}]</li>
 * <li>FilterStart_XMSG: ImpactAnalyzer.filter(): model change event "{0}"</li>
 * <li>FilterForClassEnd_XMSG: ImpactAnalyzer.filterForClasses() for {0} classes took {1} ms and returned {2} evaluation units</li>
 * <li>FilterForClassStart_XMSG: ImpactAnalyzer.filterForClasses(): Classifier[{0}]</li>
 * <li>FilterForClassEvents_XMSG: ImpactAnalyzer.filterForClasses(): Number of internal events: {0}</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from ImpactAnalyzerTraces.properties
 */
 
public enum ImpactAnalyzerTraces implements MoinExternalizedString {


    /**
     * Message: "ImpactAnalyzer.analyze() for {0} statements resulted in {1} events, took {2} ms for class scope analysis, {3} ms for instance scope analysis and {4} ms for filtering "
     */
    ANALYZEOUTPUT("AnalyzeOutput_XMSG"), //$NON-NLS-1$

    /**
     * Message: "ImpactAnalyzer.analyze(): OclStatement [{0}]"
     */
    ANALYZESTART("AnalyzeStart_XMSG"), //$NON-NLS-1$

    /**
     * Message: "ImpactAnalyzer.filter() for one ModelChangeEvent took {0} ms and returned {1} evaluation units"
     */
    FILTEREND("FilterEnd_XMSG"), //$NON-NLS-1$

    /**
     * Message: "ImpactAnalyzer.filterForClasses() for {0} classes took {1} ms and returned {2} evaluation units"
     */
    FILTERFORCLASSEND("FilterForClassEnd_XMSG"), //$NON-NLS-1$

    /**
     * Message: "ImpactAnalyzer.filterForClasses(): Number of internal events: {0}"
     */
    FILTERFORCLASSEVENTS("FilterForClassEvents_XMSG"), //$NON-NLS-1$

    /**
     * Message: "ImpactAnalyzer.filterForClasses(): Classifier[{0}]"
     */
    FILTERFORCLASSSTART("FilterForClassStart_XMSG"), //$NON-NLS-1$

    /**
     * Message: "ImpactAnalyzer.filter() for {0} events took {1} ms and returned {2} evaluation units"
     */
    FILTERMULTEND("FilterMultEnd_XMSG"), //$NON-NLS-1$

    /**
     * Message: "ImpactAnalyzer.filter(): ModelChangeEvent[{0}]"
     */
    FILTERMULTSTART("FilterMultStart_XMSG"), //$NON-NLS-1$

    /**
     * Message: "ImpactAnalyzer.filter(): model change event "{0}""
     */
    FILTERSTART("FilterStart_XMSG"); //$NON-NLS-1$

    private final static ExternalizedResourceBundleAccessor ACCESSOR = new ExternalizedResourceBundleAccessor( ImpactAnalyzerTraces.class );

    private final String myKey;

    private ImpactAnalyzerTraces( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );

    }

}  