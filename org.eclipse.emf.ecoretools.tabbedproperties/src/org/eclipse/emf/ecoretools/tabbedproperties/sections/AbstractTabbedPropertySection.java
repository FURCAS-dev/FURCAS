/***********************************************************************
 * Copyright (c) 2007 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 * 
 * $Id: AbstractTabbedPropertySection.java,v 1.2 2008/12/04 14:58:21 dsciamma Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.tabbedproperties.sections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecoretools.tabbedproperties.internal.sections.listeners.PropertiesAdapterImpl;
import org.eclipse.emf.ecoretools.tabbedproperties.internal.utils.MessageManager;
import org.eclipse.emf.ecoretools.tabbedproperties.utils.ObjectAdapter;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.IPage;
import org.eclipse.ui.part.PageBookView;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * An abstract implementation of a section in a tab in the tabbed property sheet
 * page for a tree editor. Clients specializing this class may implement the
 * create widgets, setFormData and hooklisteners rather than overriding the
 * create controls.
 * 
 * Creation 5 avr. 2006
 * 
 * @author Jacques Lescot
 * @author Alfredo Serrano
 */
public abstract class AbstractTabbedPropertySection extends AbstractPropertySection {

	/**
	 * The current selected object or the first object in the selection when
	 * multiple objects are selected.
	 */
	private EObject eObject;

	/**
	 * A list of selected objects.
	 */
	private List<EObject> eObjectList;

	/**
	 * The status line manager for showing messages
	 */
	private IStatusLineManager statusLineManager;

	/**
	 * Field Decorator Manager
	 */
	private MessageManager messageManager;

	/**
	 * Section composite. This composite can be return if client desire to
	 * implement other widgets in relation with the list represented by this
	 * instance.
	 */
	private Composite sectionComposite;

	/**
	 * Listener for the model notifications
	 */
	private Adapter modelListener = new PropertiesAdapterImpl() {

		/**
		 * @see org.eclipse.emf.ecoretools.tabbedproperties.internal.sections.listeners.PropertiesAdapterImpl#safeNotifyChanged(org.eclipse.emf.common.notify.Notification)
		 */
		protected void safeNotifyChanged(Notification msg) {
			handleModelChanged(msg);
		}
	};

	/**
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#createControls(org.eclipse.swt.widgets.Composite,
	 *      org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
	 */
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		sectionComposite = getMainComposite(parent);
		createWidgets(sectionComposite);
		setSectionData(sectionComposite);
		hookListeners();
		messageManager = new MessageManager();
		IActionBars actionBars = aTabbedPropertySheetPage.getSite().getActionBars();
		makeContributions(actionBars.getMenuManager(), actionBars.getToolBarManager(), actionBars.getStatusLineManager());
	}

	/**
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#setInput(org.eclipse.ui.IWorkbenchPart,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		if (!(selection instanceof IStructuredSelection)) {
			return;
		}
		Object ssel = ((IStructuredSelection) selection).getFirstElement();
		removeListener();
		eObject = adaptToEObject(ssel);
		eObjectList = new ArrayList<EObject>();
		for (Iterator<?> iter = ((IStructuredSelection) selection).iterator(); iter.hasNext();) {
			EObject element = adaptToEObject(iter.next());
			if (element != null) {
				eObjectList.add(element);
			}
		}
		addListener();
	}
	
	/**
	 * Adapt the given object into an EObject
	 * @param object the object to adapt
	 * @return the adapted object
	 */
	protected EObject adaptToEObject(Object object)
	{
		return ObjectAdapter.adaptObject(object);
	}

	/**
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#aboutToBeHidden()
	 */
	public void aboutToBeHidden() {
		removeListener();
	}

	/**
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#aboutToBeShown()
	 */
	public void aboutToBeShown() {
		addListener();
	}

	/**
	 * Sets the manager this view will use
	 * 
	 * @param toolBarManager
	 *            the toolBarManager to display buttons on the toolBar
	 * @param menuManager
	 *            the Menu manager to display menus
	 * @param statLineManager
	 *            the status line manager to show messages
	 */
	public void makeContributions(IMenuManager menuManager, IToolBarManager toolBarManager, IStatusLineManager statLineManager) {
		this.statusLineManager = statLineManager;
	}

	/**
	 * Obtains the currently active workbench page.
	 * 
	 * @return the active page, or <code>null</code> if none is active
	 */
	public IWorkbenchPage getActivePage() {
		IWorkbenchPage result = null;

		IWorkbench bench = PlatformUI.getWorkbench();
		if (bench != null) {
			IWorkbenchWindow window = bench.getActiveWorkbenchWindow();

			if (window != null) {
				result = window.getActivePage();
			}
		}

		return result;
	}

	/**
	 * @return the section Composite
	 */
	protected Composite getSectionComposite() {
		return sectionComposite;
	}

	/**
	 * Build the main composite for this section
	 * 
	 * @param parent
	 *            The Section
	 * @return The main composite for this section
	 */
	protected Composite getMainComposite(Composite parent) {
		return getWidgetFactory().createFlatFormComposite(parent);
	}

	/**
	 * 
	 * This returns whether the resource is read only in editing domain.
	 * 
	 * @return <code>false</code> when the file can be written.
	 */
	protected boolean isReadOnly() {
		Resource resource = getEObject().eResource();
		EditingDomain domain = getEditingDomain();
		if (domain != null && resource != null && domain.isReadOnly(resource)) {
			return true;
		}
		return false;
	}

	/**
	 * Sets the error message to be displayed in the status line.
	 * 
	 * @param errorMessage
	 *            the message to be displayed, or <code>null</code>
	 */
	protected void setErrorMessage(String errorMessage) {
		// show the error message
		if (statusLineManager != null) {
			statusLineManager.setErrorMessage(errorMessage);
		}
	}

	/**
	 * Sets the message to be displayed in the status line. This message is
	 * displayed when there is no error message.
	 * 
	 * @param message
	 *            the message to be displayed, or <code>null</code>
	 */
	protected void setMessage(String message) {
		// show the message
		if (statusLineManager != null) {
			statusLineManager.setMessage(message);
		}
	}

	/**
	 * Removes the model listener to this object
	 */
	protected void removeListener() {
		if (getEObject() == null) {
			return;
		}
		if (getEObject().eAdapters().contains(getModelListener())) {
			getEObject().eAdapters().remove(getModelListener());
		}
	}

	/**
	 * Adds a model listener to this object
	 */
	protected void addListener() {
		if (getEObject() == null) {
			return;
		}
		if (!getEObject().eAdapters().contains(getModelListener())) {
			getEObject().eAdapters().add(getModelListener());
		}
	}

	/**
	 * Get the standard label width when labels for sections line up on the left
	 * hand side of the composite. We line up to a fixed position, but if a
	 * string is wider than the fixed position, then we use that widest string.
	 * 
	 * @param parent
	 *            The parent composite used to create a GC.
	 * @param labels
	 *            The list of labels.
	 * @return the standard label width.
	 */
	protected int getStandardLabelWidth(Composite parent, String[] labels) {
		int standardLabelWidth = STANDARD_LABEL_WIDTH + 65;
		GC gc = new GC(parent);
		int indent = gc.textExtent("XXX").x; //$NON-NLS-1$
		for (int i = 0; i < labels.length; i++) {
			int width = gc.textExtent(labels[i]).x;
			if (width + indent > standardLabelWidth) {
				standardLabelWidth = width + indent;
			}
		}
		gc.dispose();
		return standardLabelWidth;
	}

	/**
	 * This returns the editing domain as required by the
	 * {@link IEditingDomainProvider} interface. This is important for
	 * implementing the static methods of {@link AdapterFactoryEditingDomain}
	 * and for supporting {@link org.eclipse.emf.edit.ui.action.CommandAction}.
	 * 
	 * @return The required editing domain
	 * @throws IllegalArgumentException
	 *             There is an error when the part cannot be adapted in any
	 *             EditingDomain.
	 */
	protected EditingDomain getEditingDomain() {
		IWorkbenchPart part = getPart();

		if (part.getAdapter(EditingDomain.class) != null) {
			return (EditingDomain) getPart().getAdapter(EditingDomain.class);
		}

		if (part instanceof IEditingDomainProvider) {
			return ((IEditingDomainProvider) part).getEditingDomain();
		}

		if (part.getAdapter(IEditingDomainProvider.class) != null) {
			return ((IEditingDomainProvider) part.getAdapter(IEditingDomainProvider.class)).getEditingDomain();
		}

		if (part instanceof PageBookView) {
			IPage page = ((PageBookView) part).getCurrentPage();
			if (page instanceof IEditingDomainProvider) {
				return ((IEditingDomainProvider) page).getEditingDomain();
			}
		}

		throw new IllegalArgumentException();
	}

	/**
	 * Manages a self-contained set of interrelated EMF models and the
	 * {@link Command}s that modify them. The models are maintained in the form
	 * of a {@link ResourceSet}. Commands that modify the model are typically
	 * created through the domain and are executed using the
	 * {@link CommandStack}.
	 * 
	 * @param oldValue
	 *            The previous property value
	 * @param newValue
	 *            The new value to set
	 */
	protected void createCommand(Object oldValue, Object newValue) {
		boolean equals = oldValue == null ? false : oldValue.equals(newValue);
		if (!equals) {
			EditingDomain editingDomain = getEditingDomain();
			Object value = newValue;
			if (getEObjectList().size() == 1) {
				// apply the property change to single selected object
				editingDomain.getCommandStack().execute(SetCommand.create(editingDomain, getEObject(), getFeature(), value));
			} else {
				CompoundCommand compoundCommand = new CompoundCommand();
				// apply the property change to all selected elements
				for (EObject nextObject : getEObjectList()) {
					compoundCommand.append(SetCommand.create(editingDomain, nextObject, getFeature(), value));
				}
				editingDomain.getCommandStack().execute(compoundCommand);
			}
		}
	}

	/**
	 * @return the eObject
	 */
	protected EObject getEObject() {
		return eObject;
	}

	/**
	 * @return the eObjectList
	 */
	protected List<EObject> getEObjectList() {
		return eObjectList;
	}

	/**
	 * @return the statusLineManager
	 */
	protected IStatusLineManager getStatusLineManager() {
		return statusLineManager;
	}

	/**
	 * @return the message manager to which decorates fields
	 */
	protected MessageManager getMessageManager() {
		return messageManager;
	}

	/**
	 * @param control
	 *            the Control
	 * @param message
	 *            a String
	 * @param type
	 *            the type
	 * 
	 */
	protected void setDecorator(Control control, String message, int type) {
		messageManager.addMessage("", message, null, type, control); //$NON-NLS-1$
	}

	/**
	 * Add a decorator to the given control. A tool tip will display the given
	 * message
	 * 
	 * @param control
	 * @param message
	 * 
	 * @since 1.0 M3
	 */
	protected void setErrorDecorator(Control control, String message) {
		setDecorator(control, message, IMessageProvider.ERROR);
	}

	/**
	 * Add a decorator to the given control. A tool tip will display the given
	 * message
	 * 
	 * @param control
	 * @param message
	 * 
	 * @since 1.0 M3
	 */
	protected void setWarningDecorator(Control control, String message) {
		setDecorator(control, message, IMessageProvider.WARNING);
	}

	/**
	 * Add a decorator to the given control. A tool tip will display the given
	 * message
	 * 
	 * @param control
	 * @param message
	 * 
	 * @since 1.0 M3
	 */
	protected void setInfoDecorator(Control control, String message) {
		setDecorator(control, message, IMessageProvider.INFORMATION);
	}

	/**
	 * Clear existing decorators
	 * 
	 * @since 1.0 M3
	 */
	protected void clearDecorators() {
		messageManager.removeAllMessages();
	}

	/**
	 * Returns the generic model listener
	 * 
	 * @return the model listener
	 */
	protected Adapter getModelListener() {
		return modelListener;
	}

	/**
	 * This method is called when an event occurred on the model objects
	 * 
	 * @param msg
	 *            the event notification
	 */
	protected void handleModelChanged(Notification msg) {
		Object notifier = msg.getNotifier();
		if (notifier.equals(getEObject()) && getFeature() != null) {
			if (msg.getFeatureID(getEObject().getClass()) == getFeature().getFeatureID()) {
				refresh();
			}
		}
	}

	/**
	 * Get the feature for the combo field for the section.
	 * 
	 * @return the feature for the text.
	 */
	protected abstract EStructuralFeature getFeature();

	/**
	 * Get the label for the text field for the section.
	 * 
	 * @return the label for the text field.
	 */
	protected abstract String getLabelText();

	/**
	 * Section widgets should be created inside this method. To set the layout
	 * data please implement the {@link #setSectionData(Composite)} If widgets
	 * has listeners implement the {@link #hookListeners()}.
	 * 
	 * @param composite
	 *            the parent Composite
	 * 
	 * @see #createControls(Composite, TabbedPropertySheetPage)
	 */
	protected void createWidgets(Composite composite) {
		// Implement this method

	}

	/**
	 * This method should be implemented to set layout data to the widgets
	 * created at {@link #createWidgets(Composite)}. This improves visibility
	 * 
	 * @param composite
	 *            Sometimes widgets will be set formDatas and position will
	 *            depend on parent composite.
	 */
	protected void setSectionData(Composite composite) {
		// Implement this method

	}

	/**
	 * Widgets created at {@link #createWidgets(Composite)} may listen platform
	 * events. Set them here in order to improve visibility
	 */
	protected void hookListeners() {
		// Implement this method

	}
}