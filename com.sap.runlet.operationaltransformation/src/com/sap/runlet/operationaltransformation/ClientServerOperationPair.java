package com.sap.runlet.operationaltransformation;

public class ClientServerOperationPair<O extends Operation<?>> {
    private O clientOp;
    private O serverOp;

    public ClientServerOperationPair(O clientOp, O serverOp) {
	super();
	this.clientOp = clientOp;
	this.serverOp = serverOp;
    }
    
    public O getClientOp() {
        return clientOp;
    }
    
    public O getServerOp() {
        return serverOp;
    }
}
