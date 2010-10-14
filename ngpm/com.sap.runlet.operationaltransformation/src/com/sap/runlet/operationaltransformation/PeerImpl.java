package com.sap.runlet.operationaltransformation;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * A very simple peer implementation for operational transformations that starts
 * out with a provided initial state and then receives operations which it applies
 * to its state. It manages a set of clients. Using the <tt>server</tt> constructor
 * parameter one can configure whether this peer is a client or a server.
 * 
 * @author Axel Uhl D043530
 *
 * @param <O> type of change operations to be processed by this server
 * @param <S> type of state managed by this server to which the operations can be applied
 */
public class PeerImpl<O extends Operation<S>, S> implements Peer<O, S> {
    
    private String name;
    
    private StatesAndOperations<O, S> statesAndOperations;
    
    /**
     * Tells if this peer acts in the server or client role. This is used to determine in which
     * direction to apply the operational transformation.
     */
    private Role role;
    
    /**
     * Tells if this peer is currently actively running, with a certain number of pending / running requests
     */
    private int running = 0;

    /**
     * Queues operations sent out to a peer in {@link #updatePeers(Operation, Peer)} and whose
     * merging has not yet been confirmed by that peer. Those messages are transformed when an
     * operation from that peer is applied. When applying an operation to the peer has been
     * confirmed, the first operation from the queue is removed because operations sent
     * from this peer to the remote peer are processed in order.
     */
    private Map<Peer<O, S>, UnmergedOperationsQueue<O, S>> unmergedOperationsForPeer = new HashMap<Peer<O, S>, UnmergedOperationsQueue<O, S>>();
    
    /**
     * Remembers per peer how many of that peer's operations this peer has already
     * applied locally.
     */
    private Map<Peer<O, S>, Integer> numberOfMergedOperations = new HashMap<Peer<O, S>, Integer>();

    private Transformer<O> transformer;
    
    /**
     * The background task handler which sends out the asynchronous updates to the peers.
     */
    private ExecutorService merger;

    public PeerImpl(Transformer<O> transformer, S initialState, Role role) {
	this.transformer = transformer;
	statesAndOperations = new StatesAndOperations<O, S>(initialState);
	this.role = role;
	this.merger = Executors.newSingleThreadExecutor();
    }
    
    public PeerImpl(String name, Transformer<O> transformer, S initialState, Role role) {
	this(transformer, initialState, role);
	this.name = name;
    }
    
    /**
     * Constructs a client peer and connects it to the <tt>server</tt> peer, establishing
     * the two-way link between client and server peers. The initial state is taken from
     * the server.
     */
    public PeerImpl(Transformer<O> transformer, Peer<O, S> server) {
	this.transformer = transformer;
	S initialState = server.addPeer(this);
	statesAndOperations = new StatesAndOperations<O, S>(initialState);
	this.role = Role.CLIENT;
	this.merger = Executors.newSingleThreadExecutor();
	addPeer(server);
    }

    /**
     * Constructs a client peer with a name and connects it to the
     * <tt>server</tt> peer, establishing the two-way link between client and
     * server peers. The initial state is taken from the server.
     */
    public PeerImpl(String name, Transformer<O> transformer, Peer<O, S> server) {
	this(transformer, server);
	this.name = name;
    }
    
    @Override
    public void finalize() {
	merger.shutdown();
    }

    private Transformer<O> getTransformer() {
        return transformer;
    }
    
    @Override
    public S addPeer(Peer<O, S> peer) {
	if ( role == Role.CLIENT && getPeers().size() > 0) {
	    throw new RuntimeException("A client must be connected to at most one server");
	}
	unmergedOperationsForPeer.put(peer, new UnmergedOperationsQueue<O, S>());
	numberOfMergedOperations.put(peer, 0);
	return getCurrentState();
    }
    
    private Collection<Peer<O, S>> getPeers() {
	return unmergedOperationsForPeer.keySet();
    }
    
    public S getCurrentState() {
	return statesAndOperations.getCurrentState();
    }
    
    @Override
    public synchronized void apply(O operation) {
	taskStarted();
	statesAndOperations.apply(operation);
	updatePeers(operation, /* except */ null);
	taskFinished();
    }

    @Override
    public synchronized void apply(final Peer<O, S> source, O operation,
	    final int numberOfOperationsSourceHasMergedFromThis) {
	taskStarted();
	if (!getPeers().contains(source)) {
	    throw new RuntimeException("Peer "+source+" not registered with peer "+this);
	}
	// Starting from base up to current, compute transformed operation sequence to send
	// to client; this will create a sequence of states for the client which eventually
	// leads up to a state that equals the server's current state.
	O transformedOp = operation;
	UnmergedOperationsQueue<O, S> unmergedOperationsForSource = unmergedOperationsForPeer.get(source);
	int localOpNumber = numberOfOperationsSourceHasMergedFromThis;
	for (O unconfirmedOperation : unmergedOperationsForSource.getUnmergedOperations(numberOfOperationsSourceHasMergedFromThis)) {
	    if (role == Role.SERVER) {
		ClientServerOperationPair<O> pair = getTransformer().transform(transformedOp, unconfirmedOperation);
		transformedOp = pair.getClientOp();
		unmergedOperationsForSource.updateWithTransformed(localOpNumber, pair.getServerOp());
	    } else {
		ClientServerOperationPair<O> pair = getTransformer().transform(unconfirmedOperation, transformedOp);
		transformedOp = pair.getServerOp();
		unmergedOperationsForSource.updateWithTransformed(localOpNumber, pair.getClientOp());
	    }
	    localOpNumber++;
	}
	statesAndOperations.apply(transformedOp); // produce a new current state
	final int numberOfMergedOperationsFromSource = numberOfMergedOperations.get(source)+1;
	numberOfMergedOperations.put(source, numberOfMergedOperationsFromSource);
	// It's important that the following call to confirm is synchronized with the
	// sending of updates to the source peer. Therefore, the confirm call is executed
	// in the same serializing background thread:
	scheduleTask(new Runnable() {
	    public void run() {
		source.confirm(PeerImpl.this, numberOfMergedOperationsFromSource);
	    }
	});
	updatePeers(transformedOp, /* except */source);
	taskFinished();
    }

    /**
     * Propagates the changes described by <tt>operation</tt> to all registered
     * peers (except the peer identified by <tt>except</tt> if not <tt>null</tt>
     * ). For each peer, the operation is sent along to that peer's
     * {@link #apply(Peer, Operation, int)} method together with the
     * {@link #numberOfMergedOperations number of operations currently merged
     * from that peer}.
     */
    private synchronized void updatePeers(final O operation, Peer<O, S> except) {
	for (final Peer<O, S> peer : getPeers()) {
	    if (except == null || !except.equals(peer)) {
		unmergedOperationsForPeer.get(peer).sentOutOperation(operation);
		// remember the number of merged operations while still in synchronized block
		final int numberOfMergedOpsForPeer = numberOfMergedOperations.get(peer);
		scheduleTask(new Runnable() {
		    public void run() {
			/* 
			 * Thoughts on locking: The peer runs the folling apply(...) call synchronized.
			 * Therefore, it can't take other apply calls (local or from other peers) during
			 * that time. It may, though, have pending tasks in its updatePeers that can
			 * continue to run. This may include updates for this peer which would be received
			 * by this peer's apply(...) method.
			 */
			peer.apply(PeerImpl.this, operation, numberOfMergedOpsForPeer);
		    }
		});
	    }
	}
    }
    
    public String toString() {
	if (name != null) {
	    return name;
	} else {
	    return (role == Role.SERVER?"server":"client")+" "+super.toString();
	}
    }

    @Override
    public void confirm(Peer<O, S> source, int numberOfMergedOperations) {
	unmergedOperationsForPeer.get(source).confirm(numberOfMergedOperations);
    }

    /**
     * Records that a new task is scheduled by incrementing {@link #running} by one, then
     * schedules the <tt>runnable</tt> with the {@link #merger} executor service. The
     * <tt>runnable</tt> is wrapped such that when its execution has finished,
     * {@link #taskFinished()} will be called such that {@link #running} is decremented
     * properly again and waiting clients in {@link #waitForNotRunning()} can be unblocked.
     */
    private void scheduleTask(final Runnable runnable) {
	taskStarted();
	merger.execute(new Runnable() {
	    public void run() {
		runnable.run();
		taskFinished();
	    }
	});
    }

    private void taskStarted() {
	running++;
    }

    /**
     * Must be called by all tasks submitted to the {@link #merger} when finished.
     * Unblocks {@link #waitForNotRunning()} if the merger's queue got empty by this.
     */
    private synchronized void taskFinished() {
	running--;
	if (running == 0) {
	    notifyAll();
	}
    }

    @Override
    public synchronized void waitForNotRunning() {
	while (running > 0) {
	    try {
		wait();
	    } catch (InterruptedException e) {
		// ignore interruption, try again
	    }
	}
    }
}
