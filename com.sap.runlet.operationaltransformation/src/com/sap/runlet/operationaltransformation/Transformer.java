package com.sap.runlet.operationaltransformation;

public interface Transformer<O extends Operation<?>> {
    /**
     * Takes an operation from the client and an operation from the server, both
     * based on the same state. The complementary pair of operations is computed
     * such that if the client applies the server operation returned, and the
     * server applies the client operation returned, both end up in equal states
     * again.
     */
    ClientServerOperationPair<O> transform(O clientOp, O serverOp);
}
