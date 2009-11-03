package com.sap.mi.fwk.mbeans;

import javax.management.ObjectName;

import com.sap.tc.moin.repository.jmx.Description;

public interface MarkerManagerMBean {

	@Description("Returns the class name")
	public String[] getListeners();

	@Description("Returns the object name")
	public ObjectName getObjectName();

	@Description("Returns the marker cache hits")
	public long getCacheHits();

	@Description("Returns the marker cache misses")
	public long getCacheMisses();

	@Description("Clears the marker cache")
	public void clearCache();

	@Description("Gets the number of cache additions")
	public long getAdds();

	@Description("Gets the number of cache removes")
	public long getRemoves();

	@Description("Gets the number of partitions in cache")
	public long getPartitionCount();

	@Description("Gets the number of markers in cache")
	public long getTotalMarkerCount();

	@Description("Gets the number of model elements currently in cache")
	public long getTotalElementCount();
}
