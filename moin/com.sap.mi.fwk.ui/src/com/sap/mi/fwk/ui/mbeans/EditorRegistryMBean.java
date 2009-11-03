package com.sap.mi.fwk.ui.mbeans;

import javax.management.ObjectName;

import com.sap.tc.moin.repository.jmx.Description;

public interface EditorRegistryMBean {

	@Description("Reloads editor registry from extension points")
	public void reload();

	public ObjectName getObjectName();
}
