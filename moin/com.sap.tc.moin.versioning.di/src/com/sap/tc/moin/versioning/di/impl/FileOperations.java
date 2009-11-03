package com.sap.tc.moin.versioning.di.impl;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.versioning.di.FileOperation;

public class FileOperations {
	List<FileOperation> fileOperations = new ArrayList<FileOperation>();
	boolean containsWarnings = false;
	boolean containsErrors = false;

	public void add(FileOperation fileOperation) {
		fileOperations.add(fileOperation);
	}
	
	public boolean isEmpty() {
		return fileOperations.isEmpty();
	}
	
	public boolean containsWarnings() {
		return containsWarnings;
	}

	public void setContainsWarnings(boolean containsWarnings) {
		this.containsWarnings = containsWarnings;
	}

	public boolean containsErrors() {
		return containsErrors;
	}

	public void setContainsErrors(boolean containsErrors) {
		this.containsErrors = containsErrors;
	}

	public List<FileOperation> getFileOperations() {
		return fileOperations;
	}
}



