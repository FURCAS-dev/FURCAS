package com.sap.mi.tools.diagnostics.internal.model;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.management.openmbean.CompositeData;

import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.tools.diagnostics.internal.messages.DiagnosticsMessages;

/**
 * <p>Title:       PartitionNode</p>
 * <p>Description: </p>
 * <p>Copyright:   Copyright (c) 2006</p>
 * <p>Company:     SAP AG</p>
 * @author        d031150
 * @since         NYC
 */
public class PartitionNode extends DelegateNode {
	
	private static final Logger stracer = Logger.getLogger(MiLocations.MI_DIAGNOSTICS);

    private final boolean mIsNullPartition;

	public PartitionNode(
    		ConnectionNode node, String partition, 
    		boolean isNullPartition) {
        super(node, partition);
		mIsNullPartition = isNullPartition;
    }
    
    @Override
    public ConnectionNode getParent() {
    	return (ConnectionNode) super.getParent();
    }
    
    @Override
    public String getDelegate() {
        return (String) super.getDelegate();
    }
    
    @Override
    public Object[] getChildren() {
    	try {
			String[] elements = getParent().getRootElementsInPartition(getDelegate());
			PartitionableNode[] children = new PartitionableNode[elements.length];
			for (int i = 0; i < elements.length; i++) {
				String mriString = elements[i];
				CompositeData modelElement = getParent().getModelElement(mriString);
				children[i] = new PartitionableNode(this, mriString, modelElement);
			}
			return children;
		} catch (IOException e) {
			stracer.log(Level.SEVERE, e.getMessage(), e);
			return super.getChildren();
		}
    }
    
    @Override
    public String getText() {
    	String text;
    	if (isNullPartition())
    		text = DiagnosticsMessages.PartitionNode_nullPartition_label;
    	else
    		text = getDelegate();
        return text;
    }
    
    public boolean isNullPartition() {
		return mIsNullPartition;
    }
    
}
