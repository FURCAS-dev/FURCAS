package org.eclipse.emf.query.index.internal;

/**
 * Represents the strategy used to page-in or page out a {@link PageableElement}
 * 
 */
public interface PagingStrategy<T extends PageableElement> {

	public void addLocked(T element);

	public void remove(T element);

	public void lock(T element);

	public void unlock(T element);

	public void flush();

}
