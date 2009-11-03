package com.sap.tc.moin.friends.merge;

/**
 * The configuration of the invoker
 */
public class OperationInvokerConfiguration {


    private final boolean copyDeep;

    private final boolean unitMode;

    /**
     * @param copyObjectsDeep true if copying of an object should include the
     * composition hierarchy
     * @param theUnitMode if there are dependent operations being calculated
     * using the merge partitioning
     */
    public OperationInvokerConfiguration( boolean copyObjectsDeep, boolean theUnitMode ) {

        this.copyDeep = copyObjectsDeep;
        this.unitMode = theUnitMode;
    }

    /**
     * @return the mode
     */
    public boolean getUnitMode( ) {

        return this.unitMode;
    }

    /**
     * @return the mode
     */
    public boolean getDeepCopyMode( ) {

        return this.copyDeep;
    }

}
