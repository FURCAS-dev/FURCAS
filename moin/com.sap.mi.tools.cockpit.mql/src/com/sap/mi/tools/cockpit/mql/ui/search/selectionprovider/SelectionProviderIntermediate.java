package com.sap.mi.tools.cockpit.mql.ui.search.selectionprovider;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;

/**
 * @author d003456
 * 
 */
public final class SelectionProviderIntermediate implements ISelectionProvider, ISelectionChangedListener {

	private final ListenerList selectionListeners = new ListenerList();

	private ISelectionProvider delegate;

	private final ISelectionChangedListener selectionListener = new ISelectionChangedListener() {
		public void selectionChanged(SelectionChangedEvent event) {

			if (event.getSelectionProvider() == SelectionProviderIntermediate.this.delegate) {
				fireSelectionChanged(event.getSelection());
			}
		}
	};

	/**
	 * Creates {@link SelectionProviderIntermediate}.
	 * 
	 * @param delegate
	 *            the initial {@link ISelectionProvider} delegate
	 */
	public SelectionProviderIntermediate(ISelectionProvider delegate) {

		super();
		Assert.isNotNull(delegate);
		this.delegate = delegate;
	}

	/**
	 * Sets a new selection provider to delegate to. Selection listeners registered with the previous delegate are removed before.
	 * 
	 * @param newDelegate
	 *            new selection provider
	 */
	public void setSelectionProviderDelegate(ISelectionProvider newDelegate) {

		if (this.delegate != null) {
			this.delegate.removeSelectionChangedListener(this.selectionListener);
		}
		this.delegate = newDelegate;
		if (newDelegate != null) {
			newDelegate.addSelectionChangedListener(this.selectionListener);
			fireSelectionChanged(newDelegate.getSelection());
		}
	}

	public void fireSelectionChanged(ISelection selection) {

		fireSelectionChanged(this.selectionListeners, selection);
	}

	private void fireSelectionChanged(ListenerList list, ISelection selection) {

		final SelectionChangedEvent event = new SelectionChangedEvent(this.delegate, selection);
		if (list != null && list.size() > 0) {
			final Object[] listeners = list.getListeners();
			for (int i = 0; i < listeners.length; i++) {
				final ISelectionChangedListener listener = (ISelectionChangedListener) listeners[i];
				listener.selectionChanged(event);
			}
		}
	}

	// IPostSelectionProvider Implementation

	public void addSelectionChangedListener(ISelectionChangedListener listener) {

		this.selectionListeners.add(listener);
	}

	public void removeSelectionChangedListener(ISelectionChangedListener listener) {

		this.selectionListeners.remove(listener);
	}

	public ISelection getSelection() {

		return this.delegate == null ? null : this.delegate.getSelection();
	}

	public void setSelection(ISelection selection) {

		if (this.delegate != null) {
			this.delegate.setSelection(selection);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
	 */
	public void selectionChanged(SelectionChangedEvent event) {

		fireSelectionChanged(event.getSelection());

	}
}
