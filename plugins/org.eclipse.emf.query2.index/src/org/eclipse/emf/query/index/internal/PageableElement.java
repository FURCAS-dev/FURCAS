package org.eclipse.emf.query.index.internal;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.eclipse.emf.query.index.internal.maps.MapEntry;

/**
 * Represents a PageableElement in PageableIndex
 * 
 */
public interface PageableElement extends MapEntry {

	public boolean pageIn(FileInputStream ch);

	public boolean pageOut(FileOutputStream ch);

	public boolean isPagedOut();

	public int size();

	public String getId();
}
