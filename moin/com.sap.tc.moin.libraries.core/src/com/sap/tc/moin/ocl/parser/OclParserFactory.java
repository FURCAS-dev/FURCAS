package com.sap.tc.moin.ocl.parser;

import com.sap.tc.moin.ocl.utils.jmi.MoinJmiCreator;
import com.sap.tc.moin.repository.ProcessReport;
import com.sap.tc.moin.repository.shared.util.ProcessReportImpl;

/**
 * OclParser factory
 */
public class OclParserFactory {

    /**
     * @param jmiCreator the {@link MoinJmiCreator}
     * @param report the {@link ProcessReport}
     * @return the parser
     */
    static public IOclParser create( MoinJmiCreator jmiCreator, ProcessReport report ) {

        return OclParserLPG.create( jmiCreator );
    }

    /**
     * @param jmiCreator the {@link MoinJmiCreator}
     * @return the parser
     */
    static public IOclParser create( MoinJmiCreator jmiCreator ) {

        return create( jmiCreator, new ProcessReportImpl( ) );
    }

}
