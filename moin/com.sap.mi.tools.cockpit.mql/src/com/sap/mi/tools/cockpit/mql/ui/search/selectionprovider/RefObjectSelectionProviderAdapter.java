package com.sap.mi.tools.cockpit.mql.ui.search.selectionprovider;

import org.eclipse.core.runtime.ListenerList;
import org.eclipse.jface.viewers.IPostSelectionProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;

/**
 * @author d003456
 * 
 */
public final class RefObjectSelectionProviderAdapter implements IPostSelectionProvider, ISelectionChangedListener {

	private final ListenerList selectionListeners;

	private final ListenerList postSelectionListeners;

	private ISelection currSelection;

	/**
	 * 
	 */
	public RefObjectSelectionProviderAdapter() {

		this.selectionListeners = new ListenerList();
		this.postSelectionListeners = new ListenerList();
		this.currSelection = StructuredSelection.EMPTY;

	}

	public void addPostSelectionChangedListener(ISelectionChangedListener listener) {

		this.postSelectionListeners.add(listener);
	}

	public void removePostSelectionChangedListener(ISelectionChangedListener listener) {

		this.postSelectionListeners.add(listener);
	}

	public void addSelectionChangedListener(ISelectionChangedListener listener) {

		this.selectionListeners.add(listener);
	}

	public ISelection getSelection() {

		return this.currSelection;
	}

	public void removeSelectionChangedListener(ISelectionChangedListener listener) {

		this.selectionListeners.remove(listener);
	}

	public void setSelection(ISelection selection) {

		if (selection == null) {
			this.currSelection = StructuredSelection.EMPTY;
		} else {
			this.currSelection = selection;
		}
	}

	public void selectionChanged(SelectionChangedEvent event) {

		final SelectionChangedEvent wrappedEvent = new SelectionChangedEvent(this, event.getSelection());
		Object[] listeners = this.selectionListeners.getListeners();
		for (int i = 0; i < listeners.length; i++) {
			final ISelectionChangedListener listener = (ISelectionChangedListener) listeners[i];
			listener.selectionChanged(wrappedEvent);
		}

		listeners = this.postSelectionListeners.getListeners();
		for (int i = 0; i < listeners.length; i++) {
			final ISelectionChangedListener listener = (ISelectionChangedListener) listeners[i];
			listener.selectionChanged(wrappedEvent);
		}

	}

}
