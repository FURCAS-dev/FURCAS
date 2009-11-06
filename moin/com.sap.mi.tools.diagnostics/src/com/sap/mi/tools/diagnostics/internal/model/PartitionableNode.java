package com.sap.mi.tools.diagnostics.internal.model;

import java.util.Collection;

import javax.management.openmbean.CompositeData;
import javax.management.openmbean.TabularData;

/**
 * Represents a model element as root in a partition
 * 
 * @author d031150
 */
public class PartitionableNode extends DelegateNode {
	
	private static final String[][] NO_ATTRIBUTES = new String[0][0];
	//private static final Logger stracer = Logger.getLogger(PartitionableNode.class);
	
	private final CompositeData mModelElement;

    public PartitionableNode(PartitionNode node, String mriString, CompositeData modelElement) {
        super(node, mriString);
		mModelElement = modelElement;
    }
    
    @Override
    protected String getDelegate() {
        return (String) super.getDelegate();
    }
    
    @Override
    public PartitionNode getParent() {
    	return (PartitionNode) super.getParent();
    }
    
    @Override
    public boolean hasChildren() {
    	return false;
    }

    @Override
    public String getText() {
    	String type = getType();
    	int lastDot = type.lastIndexOf('.');
		if (lastDot > 0)
    		type = type.substring(lastDot + 1, type.length());
		String text = type + " [" + getMofId() + "]"; //$NON-NLS-1$ //$NON-NLS-2$
    	return text;
    }

    public String getMofId() {
    	String mofId = (String) mModelElement.get("1: MOF-ID"); //$NON-NLS-1$
    	return mofId;
    }
    
    public String getMri() {
    	return getDelegate();
    }

    public String getType() {
		String type = (String) mModelElement.get("3: Type (qual. name)"); //$NON-NLS-1$
		return type;
	}

	@SuppressWarnings("unchecked")
	public String[][] getAttributeValues() {
		TabularData attrs = (TabularData) mModelElement.get("5: Attributes"); //$NON-NLS-1$
		if (attrs != null) {
			Collection<CompositeData> values = (Collection<CompositeData>)attrs.values();
			String[][] result = new String[values.size()][2];
			int i = 0;
			for (CompositeData data : values) {
				result[i][0]= (String) data.get("1: Name"); //$NON-NLS-1$
				result[i][1]= (String) data.get("2: Value"); //$NON-NLS-1$
				i++;
			}
			return result;
		}
		return NO_ATTRIBUTES;
	}
	
}
