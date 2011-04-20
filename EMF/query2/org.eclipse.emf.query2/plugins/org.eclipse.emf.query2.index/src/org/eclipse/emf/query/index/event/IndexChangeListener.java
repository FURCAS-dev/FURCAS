package org.eclipse.emf.query.index.event;

/**
 * Should be implemented to get notification for change in index
 */
public interface IndexChangeListener {

	void indexChanged(IndexChangeEvent event);
}
