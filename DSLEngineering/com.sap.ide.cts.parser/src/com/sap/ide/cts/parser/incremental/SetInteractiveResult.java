package com.sap.ide.cts.parser.incremental;

import com.sap.tc.moin.repository.PRI;

public class SetInteractiveResult {
	private PRI pri_Result;
	private String mainPartitionContent;
	private boolean interactivePartition;
	
	public SetInteractiveResult(PRI pri_Result, String mainPartitionContent, boolean interactivePartition) {
		this.pri_Result = pri_Result;
		this.mainPartitionContent = mainPartitionContent;
		this.interactivePartition = interactivePartition;
	}
	
	public boolean isInteractivePartition() {
		return interactivePartition;
	}

	public void setInteractivePartition(boolean interactivePartition) {
		this.interactivePartition = interactivePartition;
	}

	public PRI getPri_Result() {
		return pri_Result;
	}

	public void setPri_Result(PRI priResult) {
		pri_Result = priResult;
	}

	public String getMainPartitionContent() {
		return mainPartitionContent;
	}

	public void setMainPartitionContent(String mainPartitionContent) {
		this.mainPartitionContent = mainPartitionContent;
	}

}
