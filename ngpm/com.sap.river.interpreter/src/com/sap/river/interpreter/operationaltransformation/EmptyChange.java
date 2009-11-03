package com.sap.river.interpreter.operationaltransformation;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.sap.river.interpreter.repository.RepositoryChange;

public class EmptyChange implements Change {

    @Override
    public int totalSize() {
	return 0;
    }

    @Override
    public Iterator<RepositoryChange> iterator() {
	List<RepositoryChange> emptyList = Collections.emptyList();
	return emptyList.iterator();
    }

    @Override
    public String toString() {
	return "<empty>";
    }
}
