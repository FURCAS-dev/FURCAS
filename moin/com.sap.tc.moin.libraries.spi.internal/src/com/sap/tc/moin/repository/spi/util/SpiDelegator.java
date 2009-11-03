package com.sap.tc.moin.repository.spi.util;


/**
 * This simple class supports the delegation pattern. You get the chance to
 * unwrap the target object. This is necessary if you plan to cast to an
 * implementation class (Heavily used in test cases).
 */
public abstract class SpiDelegator<T> {

    private T delegation_target;

    protected SpiDelegator( T target ) {

        this.delegation_target = target;
    }

    public static <T> T dismantle( T instance ) {

        while ( instance instanceof SpiDelegator ) {
            // TODO This is indeed potentially unsafe. 
            // This occurs if you 
            // 1. implement a delegator with more interfaces as the delegation target
            //    AND
            // 2. call the dismantle based on an interface that is not present in the delegation target
            //
            // 
            instance = ( (SpiDelegator<T>) instance ).getDelegatedInstance( );
        }
        return instance;
    }

    protected T dismantleInstance( ) {

        return dismantle( delegation_target );
    }

    public final T getDelegatedInstance( ) {

        return delegation_target;
    }
}
