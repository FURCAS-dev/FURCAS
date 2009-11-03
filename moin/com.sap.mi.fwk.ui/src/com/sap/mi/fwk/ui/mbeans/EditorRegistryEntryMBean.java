package com.sap.mi.fwk.ui.mbeans;

import javax.management.ObjectName;
import javax.management.openmbean.CompositeData;
import javax.management.openmbean.TabularData;

import com.sap.tc.moin.repository.jmx.Description;

public interface EditorRegistryEntryMBean {

	@Description("Deletes the current entry")
	public void delete();

	@Description("Returns the class name")
	public String getClassName();

	@Description("Returns a list of all registered editors for this class name")
	public TabularData getEditors();

	@Description("Returns a list of all registered editors for this class name")
	public CompositeData getDefaultEditor();
	
	public ObjectName getObjectName();
}
