package com.sap.river.interpreter.operationaltransformation;

import com.sap.river.interpreter.repository.RepositoryChange;

public interface Change extends Iterable<RepositoryChange> {
    /**
     * The total number of {@link RepositoryChange} objects the iterator
     * will produce
     */
    int totalSize();
}
