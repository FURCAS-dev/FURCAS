package org.eclipse.emf.query.index.event;

/**
 * Various event types possible by index change
 */
public interface IndexChangeEvent {

	enum Type {	ADDED, REMOVED, MODIFIED };

	Type getType();

	Object getDescriptor();

}
