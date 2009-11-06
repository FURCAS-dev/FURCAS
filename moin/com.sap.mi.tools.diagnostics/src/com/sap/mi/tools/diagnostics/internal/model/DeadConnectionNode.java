package com.sap.mi.tools.diagnostics.internal.model;

import java.io.IOException;

import javax.management.ObjectName;
import javax.management.openmbean.CompositeData;

import com.sap.tc.moin.repository.jmx.ConnectionMBean;

/**
 * Represents one connection which is not alive anymore
 * 
 * @author d031150
 */
public class DeadConnectionNode extends ConnectionNode {
	
	//private static final Logger stracer = Logger.getLogger(DeadConnectionNode.class);

	public DeadConnectionNode(ConnectionsNode node, ObjectName name) throws IOException {
        super(node, name, null, null);
    }
    
    @Override
    protected ConnectionMBean getDelegate() {
        return null;
    }
    
    @Override
    public Object[] getChildren() {
		return NO_CHILDREN;
    }
    
    @Override
	public boolean isAlive() {
    	return false;
    }

    @Override
	public boolean isDirty() throws IOException {
        return false;
    }
    
    @Override
    public String getText() {
    	return getId();
    }
    
    @Override
	public int getNumberOfElementsInNullPartition() throws IOException {
    	throw new UnsupportedOperationException();
    }
    
    @Override
	public void deleteAllElementsInNullPartition() throws IOException {
    	throw new UnsupportedOperationException();
    }
    
    @Override
	public String showAllocationStackTrace() throws IOException {
    	throw new UnsupportedOperationException();
    }
    
    @Override
	public String showContentOfModelPartition(String priString) throws IOException {
    	throw new UnsupportedOperationException();
    }
    
    public String[] getRootElementsInPartition(String priString) throws IOException {
    	throw new UnsupportedOperationException();
    }
    
    public CompositeData getModelElement(String mriString) throws IOException {
    	throw new UnsupportedOperationException();
    }

    @Override
	public void revert() throws IOException {
    	throw new UnsupportedOperationException();
    }

    @Override
	public void save() throws IOException {
    	throw new UnsupportedOperationException();
    }
    
    @Override
    public void close() throws IOException {
    	throw new UnsupportedOperationException();
    }

}
