package org.eclipse.emf.query.index.internal;

import org.eclipse.emf.query.index.update.IndexUpdater;
/**
 * Internal implementation of IndexUpdater
 * 
 */
public interface IndexUpdaterInternal extends IndexUpdater {

	public void commit();

	public void rollback();

}
