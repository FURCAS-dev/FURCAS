package com.sap.mi.fwk.ui.properties;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.views.properties.tabbed.AdvancedPropertySection;

import com.sap.mi.fwk.ui.editor.IModelEditor;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.events.EventChain;
import com.sap.tc.moin.repository.events.EventRegistry;
import com.sap.tc.moin.repository.events.UpdateListener;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.filter.EventTypeFilter;
import com.sap.tc.moin.repository.events.filter.OrFilter;
import com.sap.tc.moin.repository.events.type.ElementChangeEvent;
import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;

/**
 * An advanced property section for the tabbed property sheet showing all
 * attributes of a {@link RefObject} with their values. If the selected object
 * is owned by an {@link IModelEditor} the values may be modified.
 * 
 * @author d031150
 */
public final class DefaultPropertySection extends AdvancedPropertySection {

	private static final TracerI sTracer = TracingManager.getTracer(DefaultPropertySection.class);

	private UpdateListener dirtyChangeListener;

	@Override
	public void aboutToBeHidden() {
		IModelEditor editor = (IModelEditor) getPart().getAdapter(IModelEditor.class);
		if (editor != null) {
			Connection connection = editor.getWorkingConnection();
			if (connection != null && connection.isAlive()) {
				connection.getSession().getEventRegistry().deregister(dirtyChangeListener);
			} else {
				sTracer.error(DefaultPropertySection.class, "aboutToBeHidden", //$NON-NLS-1$
						"Connection was null or not alive. connection:" + connection + ", editor:" + editor); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
		dirtyChangeListener = null;
		super.aboutToBeHidden();
	}

	@Override
	public void aboutToBeShown() {
		IModelEditor editor = (IModelEditor) getPart().getAdapter(IModelEditor.class);

		if (editor != null) {

			super.page.setPropertySourceProvider(new RefObjectPropertySourceManager());

			dirtyChangeListener = new UpdateListener() {
				public void notifyUpdate(EventChain events) {
					Display.getDefault().asyncExec(new Runnable() {
						public void run() {
							refresh();
						}
					});
				}
			};
			EventFilter filter = new OrFilter(new EventTypeFilter(ElementChangeEvent.class));
			EventRegistry eventRegistry = editor.getWorkingConnection().getSession().getEventRegistry();
			eventRegistry.registerUpdateListener(dirtyChangeListener, filter);
		}
		super.aboutToBeShown();
	}
}
