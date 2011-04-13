package org.eclipse.emf.query.index.event;

/**
 * Registry containing all the {@link IndexChangeListener}.
 * Add a lister using addIndexChangeListener method and remove a listener using removeIndexChangeListener
 * 
 */
public interface IndexChangeListenerRegistry {

	void addIndexChangeListener(IndexChangeListener listener);

	void removeIndexChangeListener(IndexChangeListener listener);

}
