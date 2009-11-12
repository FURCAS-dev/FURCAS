package com.sap.runlet.operationaltransformation.test;

import java.util.Random;
import java.util.UUID;

import junit.framework.TestCase;

import com.sap.runlet.operationaltransformation.AbstractOperation;
import com.sap.runlet.operationaltransformation.ClientServerOperationPair;
import com.sap.runlet.operationaltransformation.Peer;
import com.sap.runlet.operationaltransformation.PeerImpl;
import com.sap.runlet.operationaltransformation.Transformer;
import com.sap.runlet.operationaltransformation.Peer.Role;
import com.sap.runlet.operationaltransformation.test.util.Base64;

public class OperationalTransformationTests extends TestCase {
    private Peer<StringInsertOperation, StringState> server;
    private Peer<StringInsertOperation, StringState> client1, client2;
    
    public static class StringInsertOperation extends AbstractOperation<StringState> {
	private int pos;
	private String s;
	public StringInsertOperation(int pos, String s) {
	    this.pos = pos;
	    this.s = s;
	}
	public StringInsertOperation clone() {
	    return (StringInsertOperation) super.clone();
	}
	public int getPos() {
	    return pos;
	}
	public String getS() {
	    return s;
	}
	public String toString() {
	    return "insert("+getPos()+", \""+getS()+"\")";
	}
	
	@Override
	public StringState applyTo(StringState toState) {
	    return toState.apply(this);
	}
    }
   
    public static class StringInsertTransformer implements Transformer<StringInsertOperation> {
	@Override
	public ClientServerOperationPair<StringInsertOperation> transform(StringInsertOperation clientOp, StringInsertOperation serverOp) {
	    StringInsertOperation resultClientOp;
	    StringInsertOperation resultServerOp;
	    if (clientOp.getPos() >= serverOp.getPos()) {
		resultServerOp = serverOp;
		resultClientOp = new StringInsertOperation(clientOp.getPos()+serverOp.getS().length(), clientOp.getS());
	    } else {
		resultClientOp = clientOp;
		resultServerOp = new StringInsertOperation(serverOp.getPos()+clientOp.getS().length(), serverOp.getS());
	    }
	    return new ClientServerOperationPair<StringInsertOperation>(resultClientOp, resultServerOp);
	}
    }
    
    public static class StringState {
	private String state;
	private UUID id;

	public String getState() {
	    return state;
	}
	
	public boolean equals(Object o) {
	    return o instanceof StringState &&
	    	this.getState().equals(((StringState) o).getState()) &&
	    	this.id.equals(((StringState) o).id);
	}
	
	public int hashCode() {
	    return getState().hashCode() ^ id.hashCode();
	}

	public StringState(String state) {
	    super();
	    id = UUID.randomUUID();
	    this.state = state;
	}
	
	public StringState apply(StringInsertOperation operation) {
	    String s = this.getState().substring(0, operation.getPos()) +
	    			operation.getS()+this.getState().substring(operation.getPos());
	    StringState result = new StringState(s);
	    return result;
	}

	private UUID getId() {
	    return id;
	}

	protected void setId(UUID id) {
	    this.id = id;
	}
	
	public String toString() {
	    return "\""+getState()+"\" @ "+getId();
	}
    }
    
    public static class SimpleClient extends PeerImpl<StringInsertOperation, StringState> {
	public SimpleClient(String name, StringState initialState) {
	    super(name, new StringInsertTransformer(), initialState, Role.SERVER);
	}
    }
    
    public void setUp() {
	server = new PeerImpl<StringInsertOperation, StringState>(
		"Server", new StringInsertTransformer(), new StringState(""), Role.SERVER);
	client1 = new PeerImpl<StringInsertOperation, StringState>("Client1", new StringInsertTransformer(), server);
	client2 = new PeerImpl<StringInsertOperation, StringState>("Client2", new StringInsertTransformer(), server);
    }
    
    public void testBasicTransformation() {
	client1.apply(new StringInsertOperation(0, "abc"));
	client2.apply(new StringInsertOperation(0, "def"));
	client1.waitForNotRunning();
	client2.waitForNotRunning();
	server.waitForNotRunning();
	assertEquals(server.getCurrentState().getState(), client1.getCurrentState().getState());
	assertEquals(server.getCurrentState().getState(), client2.getCurrentState().getState());
	assertEquals(6, server.getCurrentState().getState().length());
	assertTrue(server.getCurrentState().getState().equals("abcdef") || server.getCurrentState().getState().equals("defabc"));
    }

    public void testTwoMassInserts() {
	final int COUNT = 100;
	for (int i = 0; i < COUNT; i++) {
	    client1.apply(new StringInsertOperation(0, "abc"));
	    client2.apply(new StringInsertOperation(0, "def"));
	}
	client1.waitForNotRunning();
	client2.waitForNotRunning();
	server.waitForNotRunning();
	assertEquals(server.getCurrentState().getState(), client1.getCurrentState().getState());
	assertEquals(server.getCurrentState().getState(), client2.getCurrentState().getState());
	assertEquals(6*COUNT, server.getCurrentState().getState().length());
    }

    /**
     * Randomizes the number of changes applied to each client per iteration,
     * the insert position and the string to be inserted.
     */
    public void testRandomInserts() {
	final int COUNT = 100;
	Random r = new Random();
	int totalLength = 0;
	for (int i = 0; i < COUNT; i++) {
	    for (int j = r.nextInt(10); j > 0; j--) {
		byte[] b = new byte[r.nextInt(10)];
		r.nextBytes(b);
		String s = Base64.encode(b);
		client1.apply(new StringInsertOperation(
			r.nextInt(client1.getCurrentState().getState().length()+1), s));
		totalLength += s.length();
	    }
	    for (int j = r.nextInt(10); j > 0; j--) {
		byte[] b = new byte[r.nextInt(10)];
		r.nextBytes(b);
		String s = Base64.encode(b);
		client2.apply(new StringInsertOperation(
			r.nextInt(client2.getCurrentState().getState().length()+1), s));
		totalLength += s.length();
	    }
	}
	client1.waitForNotRunning();
	client2.waitForNotRunning();
	server.waitForNotRunning();
	assertEquals(server.getCurrentState().getState(), client1.getCurrentState().getState());
	assertEquals(server.getCurrentState().getState(), client2.getCurrentState().getState());
	assertEquals(totalLength, server.getCurrentState().getState().length());
    }

    public void testTwoMassInsertsWithServerReplica() {
	Peer<StringInsertOperation, StringState> server2 = new PeerImpl<StringInsertOperation, StringState>("Server2",
		new StringInsertTransformer(), server);
	final int COUNT = 100;
	for (int i = 0; i < COUNT; i++) {
	    client1.apply(new StringInsertOperation(0, "abc"));
	    client2.apply(new StringInsertOperation(0, "def"));
	}
	client1.waitForNotRunning();
	client2.waitForNotRunning();
	server.waitForNotRunning();
	server2.waitForNotRunning();
	assertEquals(server.getCurrentState().getState(), client1.getCurrentState().getState());
	assertEquals(server.getCurrentState().getState(), client2.getCurrentState().getState());
	assertEquals(server.getCurrentState().getState(), server2.getCurrentState().getState());
	assertEquals(6*COUNT, server2.getCurrentState().getState().length());
    }

}
