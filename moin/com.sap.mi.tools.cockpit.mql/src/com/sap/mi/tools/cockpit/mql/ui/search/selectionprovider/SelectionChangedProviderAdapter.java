package com.sap.mi.tools.cockpit.mql.ui.search.selectionprovider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;

import com.sap.mi.tools.cockpit.mql.search.MQLSearchResult;
import com.sap.mi.tools.cockpit.mql.ui.search.MQLSearchResultPage;

/**
 * @author d003456
 * 
 */
public final class SelectionChangedProviderAdapter implements ISelectionProvider, ISelectionChangedListener {

	private final List<ISelectionChangedListener> listeners = new ArrayList<ISelectionChangedListener>(5);

	private final MQLSearchResultPage page;

	/**
	 * Creates {@link SelectionChangedProviderAdapter}.
	 * 
	 * @param page
	 *            the {@link MQLSearchResult} page
	 */
	public SelectionChangedProviderAdapter(MQLSearchResultPage page) {

		super();
		this.page = page;
	}

	public void addSelectionChangedListener(ISelectionChangedListener listener) {

		this.listeners.add(listener);
	}

	public ISelection getSelection() {

		if (this.page.getViewer() != null) {
			return this.page.getViewer().getSelection();
		}
		return null;

	}

	public void removeSelectionChangedListener(ISelectionChangedListener listener) {

		this.listeners.remove(listener);
	}

	public void setSelection(ISelection selection) {

		this.page.getViewer().setSelection(selection);
	}

	public void selectionChanged(SelectionChangedEvent event) {

		// forward to my listeners
		final SelectionChangedEvent wrappedEvent = new SelectionChangedEvent(this, event.getSelection());
		for (final Iterator<ISelectionChangedListener> listnrs = this.listeners.iterator(); listnrs.hasNext();) {
			final ISelectionChangedListener listener = listnrs.next();
			listener.selectionChanged(wrappedEvent);
		}
	}

}
