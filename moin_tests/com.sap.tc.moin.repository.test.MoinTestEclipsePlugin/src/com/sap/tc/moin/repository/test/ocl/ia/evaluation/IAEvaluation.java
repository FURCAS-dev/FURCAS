package com.sap.tc.moin.repository.test.ocl.ia.evaluation;

import com.sap.tc.moin.repository.events.type.ModelChangeEvent;
import com.sap.tc.moin.repository.test.ocl.ia.evaluation.apps.IAApplication;
import com.sap.tc.moin.repository.test.ocl.ia.evaluation.data.EvaluationDataSet;
import com.sap.tc.moin.repository.test.ocl.ia.evaluation.eventgen.EventGenerator;

/**
 * This class evaluates the performance of an IAApplication. It has to be supplied with a EventGenerator and a
 * IAApplication. When executing <tt>evaluate()</tt>, ModelChangeEvents are fetched from the EventGenerator and
 * passed to the IAApplication.
 * 
 * @author d039141
 */
public class IAEvaluation {

    /**
     * Supplies the IAEvaluation with ModelChangeEvents
     */
    private EventGenerator generator;

    /**
     * The application to be evaluated
     */
    private IAApplication app;

    /**
     * The name of this evaluation
     */
    private String name = "";

    /**
     * Creates a new IAEvaluation
     * 
     * @param generator the EventGenerator to get the events from
     * @param app the application to be evaluated
     */
    public IAEvaluation( EventGenerator generator, IAApplication app ) {

        super( );
        this.generator = generator;
        this.app = app;
    }

    /**
     * Starts the process of evaluation and returns the collected data.
     * 
     * @return the collected data during evaluation
     * @throws Exception
     */
    public EvaluationDataSet evaluate( ) throws Exception {

        // initialize application
        this.app.initialize( );
        // get a new series of events
        this.generator.reset( );
        while ( this.generator.hasMoreEvents( ) ) {
            ModelChangeEvent event = this.generator.getNextEvent( );
            // notify about an event
            System.out.println( "Event: " + EventPrinter.printEvent( event ) );
            this.app.notify( event );
        }
        EvaluationDataSet dataSet = this.app.getEvaluationDataSet( );
        dataSet.setName( this.name );
        // dataSet.printAsCSL(System.out, new MRIResolverDummy(null));
        return dataSet;
    }

    /**
     * @return Returns the name.
     */
    public String getName( ) {

        return this.name;
    }

    /**
     * @param name The name to set.
     */
    public void setName( String name ) {

        this.name = name;
    }
}
