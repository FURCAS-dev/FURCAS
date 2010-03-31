package com.sap.tc.moin.repository.test.ocl.ia.evaluation.eventgen;

import java.util.Collections;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.ModelPackage;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.events.type.ModelChangeEvent;

/**
 * @author d039141
 */
public class RandomEventGenerator extends EventGenerator {



    /**
     * @param mp model package
     * @throws Exception
     */
    public RandomEventGenerator( ModelPackage mp ) throws Exception {

        super( mp );
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.rcbne.ocl20.ia.evaluation.eventgen.EventGenerator#generateEvents()
     */
    @Override
    protected List<ModelChangeEvent> generateEvents( CoreConnection connection ) throws Exception {

        // TODO Auto-generated method stub
        return Collections.emptyList( );
    }



}
