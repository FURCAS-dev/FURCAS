package com.sap.mi.fwk.ui.databinding.controls;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.eclipse.core.databinding.AggregateValidationStatus;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.mi.fwk.ui.databinding.MoinDataBindingContext;
import com.sap.mi.fwk.ui.internal.MiFwkUIPlugin;
import com.sap.mi.fwk.util.StringUtil;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.events.EventChain;
import com.sap.tc.moin.repository.events.UpdateListener;
import com.sap.tc.moin.repository.events.filter.AndFilter;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.filter.EventTypeFilter;
import com.sap.tc.moin.repository.events.filter.OrFilter;
import com.sap.tc.moin.repository.events.filter.PartitionFilter;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.PartitionChangeEvent;
import com.sap.tc.moin.repository.events.type.PartitionSaveEvent;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * Base class for a UI area that uses MOIN data binding. The area can be used
 * inside editor sections and property sheet sections. This composite provides
 * on the one hand the possibility for reuse between editors and property
 * sheets; on the other hand this class cares about establishing the lifecycle
 * for data binding, validation and validation visualization.
 * <p>
 * Clients should subclass this class, type it with the specific
 * {@link RefObject} subclass (the model element the attributes and references
 * displayed belong to) and implement the methods
 * {@link #createControls(Composite, FormToolkit)} (to create the UI without any
 * setting of data to display) and
 * {@link #createBindings(MoinDataBindingContext, RefObject)} to establish the
 * data binding that cares about the data transfer from the model to the UI and
 * back again.
 * <p>
 * After creating an instance of a subclass of this class clients need to call
 * {@link #createClient()} to hook this class into the UI hierarchy. After that
 * (and whenever a new input object is set) clients should call
 * {@link #setInput(Object)} to update the data bindings of this composite.
 * 
 * @author d027044, d022960
 * 
 */
public abstract class DataBoundSectionComposite<T extends RefObject> {

	private static final Logger sTracer = Logger.getLogger(MiLocations.MI_DATABINDING);
	private static final String DESCRIPTION_ERROR_WARNING = "<form><li style=\"image\" value=\"image\"> {0} </li></form>"; //$NON-NLS-1$
	private static final String DESCRIPTION_INFO = "<form> {0} </form>"; //$NON-NLS-1$

	private T mRefObject = null;
	private Section mSection = null;
	private FormToolkit mFormToolkit = null;
	private Composite mRootComposite = null;

	private String mTitle = null;
	private String mDescription = null;

	/**
	 * The MOIN data binding context that should be used for all bindings within
	 * this composite
	 */
	private MoinDataBindingContext mDbc = null;

	/**
	 * The status aggregator for all status reports of the data binding context
	 * for this composite.
	 */
	private AggregateValidationStatus mAggregateValidationStatus = null;

	private boolean mIsStale = false;
	private PartitionChangeListener mPartitionContentChangeListener = null;

	/**
	 * Creates a new {@link DataBoundSectionComposite}
	 * 
	 * @param section
	 *            The {@link Section} that will hold this UI. Can be either an
	 *            editor section or a property sheet section. Must not be
	 *            <code>null</code>.
	 * @param formToolkit
	 *            The {@link FormToolkit} to be used to create an controls. Must
	 *            not be <code>null</code>.
	 * @param title
	 *            The title for this UI. This {@link String} will be set as
	 *            title for the passed {@link Section}. Must not be
	 *            <code>null</code>.
	 * @param description
	 *            The description for this UI. This {@link String} will be set
	 *            as description for the passed {@link Section}. The description
	 *            area will also be used for displaying status results of a
	 *            higher category than info. Must not be <code>null</code>.
	 */
	public DataBoundSectionComposite(Section section, FormToolkit formToolkit, String title, String description) {
		super();
		Assert.isLegal(section != null, "Parameter <section> must not be null"); //$NON-NLS-1$
		Assert.isLegal(formToolkit != null, "Parameter <formToolkit> must not be null"); //$NON-NLS-1$
		Assert.isLegal(title != null, "Parameter <title> must not be null"); //$NON-NLS-1$
		Assert.isLegal(description != null, "Parameter <description> must not be null"); //$NON-NLS-1$
		mSection = section;
		mFormToolkit = formToolkit;
		mTitle = title;
		mDescription = description;
	}

	/**
	 * Creates the client area for this UI which will hold the controls for the
	 * UI. This method needs to be called by users to create the UI after
	 * creating an instance of a {@link DataBoundSectionComposite}.
	 */
	final public void createClient() {
		mSection.setText(mTitle);
		FormText formText = mFormToolkit.createFormText(mSection, true);
		mSection.setDescriptionControl(formText);
		setInfo(mDescription);

		mSection.addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				dispose();
			}
		});

		mRootComposite = mFormToolkit.createComposite(mSection);
		mFormToolkit.paintBordersFor(mRootComposite);

		mSection.setClient(mRootComposite);
		createControls(mRootComposite, mFormToolkit);
	}

	/**
	 * Updates the given message and icon information in the section header.
	 * Update is done in separate update task if not called from UI thread.
	 * 
	 * @param message
	 *            the new message to display
	 * @param parseTags
	 *            if <code>true</code>, formatting tags will be parsed.
	 *            Otherwise, text will be rendered as-is.
	 * @param expandURLs
	 *            if <code>true</code>, URLs found in the untagged text will be
	 *            converted into hyperlinks.
	 * @param key
	 *            unique key that matches the value of the <code>href</code>
	 *            attribute.
	 * @param image
	 *            an object of a type <code>Image</code>.
	 */
	private void updateDescription(final String message, final boolean parseTags, final boolean expandURLs,
			final String imageKey, final Image image) {
		if (!mSection.isDisposed()) {
			final FormText descControl = (FormText) mSection.getDescriptionControl();
			// only asyncExec if not called in UI thread
			if (Display.getCurrent() == null) {
				PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
					public void run() {
						doUpdateDescription(descControl, message, parseTags, expandURLs, imageKey, image);
					}
				});
			} else {
				doUpdateDescription(descControl, message, parseTags, expandURLs, imageKey, image);
			}
		}
	}

	/**
	 * Updates the given message and icon information in the section header.
	 * Update is done in separate update task if not called from UI thread.
	 * 
	 * @param descControl
	 *            the control embedded in the header of the section that has to
	 *            be updated
	 * @param text
	 *            the new message to display
	 * @param parseTags
	 *            if <code>true</code>, formatting tags will be parsed.
	 *            Otherwise, text will be rendered as-is.
	 * @param expandURLs
	 *            if <code>true</code>, URLs found in the untagged text will be
	 *            converted into hyperlinks.
	 * @param key
	 *            unique key that matches the value of the <code>href</code>
	 *            attribute.
	 * @param image
	 *            an object of a type <code>Image</code>.
	 */
	private void doUpdateDescription(FormText descControl, final String text, final boolean parseTags,
			final boolean expandURLs, final String imageKey, final Image image) {
		if (!descControl.isDisposed()) {
			if (image != null) {
				descControl.setImage(imageKey, image);
			}
			if (text != null) {
				descControl.setText(text, parseTags, expandURLs);
			}
			mSection.layout(true);
		}
	}

	/**
	 * Sets the given message as an error message to the description area.
	 * 
	 * @param message
	 *            The message to set.
	 */
	private void setError(String message) {
		Image image = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJS_ERROR_TSK);
		String text = MessageFormat.format(DESCRIPTION_ERROR_WARNING, message != null ? StringUtil
				.escapeForHTML(message) : "null");//$NON-NLS-1$
		updateDescription(text, true, false, "image", image); //$NON-NLS-1$
	}

	/**
	 * Sets the given message as a warning message to the description area.
	 * 
	 * @param message
	 *            The message to set.
	 */
	private void setWarning(String message) {
		Image image = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJS_WARN_TSK);
		String text = MessageFormat.format(DESCRIPTION_ERROR_WARNING, message != null ? StringUtil
				.escapeForHTML(message) : "null");//$NON-NLS-1$
		updateDescription(text, true, false, "image", image); //$NON-NLS-1$
	}

	/**
	 * Sets the given message as an info message to the description area.
	 * 
	 * @param message
	 *            The message to set.
	 */
	private void setInfo(String message) {
		String text = MessageFormat.format(DESCRIPTION_INFO, message != null ? StringUtil.escapeForHTML(message)
				: "null");//$NON-NLS-1$
		updateDescription(text, true, false, null, null);
	}

	/**
	 * Sets the given status object as message with the status severity to the
	 * description area.
	 * 
	 * @param status
	 *            The status to set. Relevant is the severity and the text
	 *            itself.
	 */
	private void setStatus(IStatus status) {
		switch (status.getSeverity()) {
		case IStatus.ERROR:
			setError(status.getMessage());
			break;
		case IStatus.WARNING:
			setWarning(status.getMessage());
			break;
		default:
			setInfo(mDescription);
			break;
		}
	}

	/**
	 * Sets the root object for this UI. This is usually an object or an object
	 * structure wrapping a {@link RefObject}, but could of course also be the
	 * {@link RefObject} directly.
	 * <p>
	 * Supported as wrapping objects are all objects that support adaptation to
	 * {@link RefObject}. In case of a {@link StructuredSelection} the first
	 * element contained is used and potentially adapted to {@link RefObject}.
	 * <p>
	 * This method needs to be called after creating a new
	 * {@link DataBoundSectionComposite} and creating the client area with the
	 * UI for the first initialization of the data binding or if the root object
	 * for this UI has changed, e.g. in a master/detail scenario. It cleans up
	 * any already existing data bindings and establishes the data binding for
	 * the newly passed object if input is not <code>null</code> and can be
	 * resolved to a {@link RefObject} that differs (via instance comparison) to
	 * the previously set input object.
	 * 
	 * @param input
	 *            The {@link RefObject} or an object wrapping the
	 *            {@link RefObject} to be used as root object for this UI. May
	 *            be <code>null</code> to reset the UI to show no information at
	 *            all.
	 */
	@SuppressWarnings("unchecked")
	public void setInput(Object input) {
		// Analyze new input object
		RefObject refObject = ModelAdapterUI.getInstance().getRefObject(input);

		// In case of same object instance nothing has changed and no update is
		// needed
		if (refObject != mRefObject) {

			deRegisterPartitionChangeListener();

			mRefObject = (T) refObject;

			// Clean-up old bindings
			cleanupBindingsInternal(true); // Also clean-up client bindings
			mIsStale = false;

			if (mRefObject != null && ((Partitionable) mRefObject).is___Alive()) {
				// register PartitionChangeListener
				registerPartitionChangeListener();

				// Define new bindings if input object is a valid RefObject
				mDbc = new MoinDataBindingContext();

				try {
					createBindings(mDbc, mRefObject);
				} catch (ClassCastException e) {
					if (input instanceof RefObject) {
						MiFwkUIPlugin.logError("Input does not match required type", e, sTracer); //$NON-NLS-1$
					} else {
						MiFwkUIPlugin
								.logError(
										"Input could not be adapted to required type. Input was of type < " + input.getClass() + ">", e, sTracer); //$NON-NLS-1$ //$NON-NLS-2$
					}
					throw e;
				}

				// Validation support
				mAggregateValidationStatus = new AggregateValidationStatus(mDbc.getValidationStatusProviders(),
						AggregateValidationStatus.MAX_SEVERITY);
				mAggregateValidationStatus.addValueChangeListener(new IValueChangeListener() {
					public void handleValueChange(ValueChangeEvent event) {
						IStatus stat = (IStatus) event.diff.getNewValue();
						setStatus(stat);
					}
				});
				setStatus((IStatus) mAggregateValidationStatus.getValue());
			}
		}
	}

	/**
	 * Clients need to override this method in order to create the actual UI.
	 * Within this method only the plain and empty UI should be created, no data
	 * should be set for displaying, e.g. no text should be set for {@link Text}
	 * widgets. The actual text should be set using data binding by defining the
	 * bindings inside the method
	 * {@link #createBindings(MoinDataBindingContext, RefObject)}.
	 * 
	 * @param parent
	 *            The parent {@link Composite} that can be used to create the UI
	 *            upon.
	 * @param toolkit
	 *            The {@link FormToolkit} to be used to create the controls with
	 *            (white light look&feel).
	 */
	protected abstract void createControls(Composite parent, FormToolkit toolkit);

	/**
	 * Clients need to override this method in order to create the data bindings
	 * for the controls created in
	 * {@link #createControls(Composite, FormToolkit)}.
	 * <p>
	 * <b>Note:</b> Clients must not hold an own reference to the
	 * {@link MoinDataBindingContext} passed to this method since this context
	 * is only valid until the bindings for this section are cleaned (see
	 * {@link #cleanupBindings()}).
	 * 
	 * @param dbc
	 *            The {@link MoinDataBindingContext} to be used for the bindings
	 * @param refObject
	 *            The base {@link RefObject} that is the current root object for
	 *            this UI.
	 */
	protected abstract void createBindings(MoinDataBindingContext dbc, T refObject);

	/**
	 * Clients may want to overwrite in order to do additional cleanup, e.g.
	 * clearing input of <code>Viewer</code> instances.<br>
	 * Note: The <code>DataBindingContext</code> including the corresponding
	 * bindings and validation support will be disposed by the framework.
	 */
	protected void cleanupBindings() {

	}

	/**
	 * Cleans-up the data binding for setting a new root object as input to this
	 * UI by cleaning the {@link AggregateValidationStatus} and the
	 * {@link MoinDataBindingContext} used within this UI.
	 */
	private void cleanupBindingsInternal(boolean cleanupClientBindings) {
		if (cleanupClientBindings) {
			// hook for clients in order to cleanup additional stuff
			cleanupBindings();
		}

		// First dispose AggregateValidationStatus in order to avoid obsolete
		// validation status updates
		if (mAggregateValidationStatus != null) {
			mAggregateValidationStatus.dispose();
			mAggregateValidationStatus = null;
		}
		if (mDbc != null) {
			mDbc.dispose();
			mDbc = null;
		}
	}

	/**
	 * Disposes this UI. Should be called when the containing section is no
	 * longer used (e.g. the editor or the property sheet view is closed).
	 * Clients may override to dispose off their own stuff.
	 */
	protected void dispose() {
		deRegisterPartitionChangeListener();
		cleanupBindingsInternal(false); // Do not clean-up client bindings
		mRefObject = null;
	}

	/**
	 * Sets the focus to this composite by delegation the call to the underlying
	 * section.
	 */
	public void setFocus() {
		if (mIsStale) {
			refresh();
		}
		mSection.setFocus();
	}

	/**
	 * Refreshes the section in case the section has become stale (falling
	 * behind data in the model).
	 */
	public final void refresh() {
		if (mRefObject != null) {
			if (((Partitionable) mRefObject).is___Alive()) {
				if (mIsStale && !mRootComposite.isDisposed()) {
					// Content in partition has changed but UI refresh is
					// still needed because data binding was not informed about
					// changes (happened outside of data binding scope).
					// --> Re-establish data binding
					cleanupBindingsInternal(true); // Also clean-up client
					mDbc = new MoinDataBindingContext();
					createBindings(mDbc, mRefObject);

					// Validation support
					mAggregateValidationStatus = new AggregateValidationStatus(mDbc.getValidationStatusProviders(),
							AggregateValidationStatus.MAX_SEVERITY);
					mAggregateValidationStatus.addValueChangeListener(new IValueChangeListener() {
						public void handleValueChange(ValueChangeEvent event) {
							IStatus stat = (IStatus) event.diff.getNewValue();
							setStatus(stat);
						}
					});
					setStatus((IStatus) mAggregateValidationStatus.getValue());
				}
			} else {
				// complete cleanup
				deRegisterPartitionChangeListener();
				cleanupBindingsInternal(true); // Also clean-up client
				// bindings
				mRefObject = null;
			}
		}
		mIsStale = false;
	}

	/**
	 * Convenience method in order to force a refresh even if this data bound
	 * section is not marked as stale.
	 * 
	 * @param changed
	 *            if <code>true</code>: a immediate refresh is triggered<br>
	 *            if <code>false</code>: a refresh will only be triggered in
	 *            case the section is stale (the UI does not reflect the model
	 *            state).
	 * @see DataBoundSectionComposite#refresh()
	 */
	public final void refresh(boolean changed) {
		if (changed) {
			markStale();
		}
		refresh();
	}

	/**
	 * Clients may overwrite this method in order to add additional partitions
	 * that should be observed. A <code>PartitionChangeEvent</code> caused by a
	 * change in one of the observed partitions causes this section composite to
	 * be refreshed.
	 * <p>
	 * This implementation returns the <code>ModelPartition</code> the
	 * corresponding <code>RefObject</code> instance belongs to.
	 */
	protected ModelPartition[] getPartitionsToObserve(RefObject refObject) {
		return new ModelPartition[] { refObject.get___Partition() };
	}

	/**
	 * Marks the section composite stale.
	 */
	private final void markStale() {
		mIsStale = true;
	}

	/**
	 * Registers a <code>PartitionChangeEvent</code> listener for the
	 * corresponding <code>RefObject</code>. The caller has to check whether the
	 * <code>RefObject</code> is still alive before calling this method.
	 */
	private void registerPartitionChangeListener() {
		EventFilter partitionFilter = new EventTypeFilter(PartitionChangeEvent.class);
		mPartitionContentChangeListener = new PartitionChangeListener();

		ModelPartition[] partitions = getPartitionsToObserve(mRefObject);

		// optimization for standard use case
		if (partitions.length == 1) {
			AndFilter andFilter = new AndFilter(partitionFilter, new PartitionFilter(partitions[0]));
			mRefObject.get___Connection().getSession().getEventRegistry().registerUpdateListener(
					mPartitionContentChangeListener, andFilter);
		} else {
			// more than one partitions to register for
			Map<ModelPartition, AndFilter> andFilters = new HashMap<ModelPartition, AndFilter>(partitions.length);
			for (int i = 0; i < partitions.length; i++) {
				if (!andFilters.containsKey(partitions[i])) {
					andFilters.put(partitions[i], new AndFilter(partitionFilter, new PartitionFilter(partitions[i])));
				}
			}
			mRefObject.get___Connection().getSession().getEventRegistry().registerUpdateListener(
					mPartitionContentChangeListener,
					new OrFilter(andFilters.values().toArray(new AndFilter[andFilters.size()])));
		}
	}

	/**
	 * Deregisters the <code>PartitionChangeEvent</code> listener.
	 */
	private void deRegisterPartitionChangeListener() {
		// skip if not alive, moin is using weak references
		if (mRefObject != null && mPartitionContentChangeListener != null && mRefObject.get___Connection().isAlive()) {
			mRefObject.get___Connection().getSession().getEventRegistry().deregister(mPartitionContentChangeListener);
		}
		mPartitionContentChangeListener = null;
	}

	/**
	 * This listener handels PartitionChanges:
	 * <p>
	 * For all <code>PartitionChangeEvent</code>s contained in
	 * <code>eventChain</code> 2. it is checked whether the triggering
	 * connection equals the connection of <code>mRefObject</code> instance. If
	 * this is <code>true</code> for all <code>PartitionChangeEvent</code>s NO
	 * refresh is performed and the section is not marked as stale.
	 * <p>
	 * Otherwise: A <code>refresh(true)</code> is triggered - the current
	 * implementation does not check whether the corresponding section widget is
	 * visible or not.
	 */
	private class PartitionChangeListener implements UpdateListener {
		public void notifyUpdate(EventChain eventChain) {
			// do not refresh UI in case the PartitionChangeEvent is caused by a
			// partition save operation triggered from our editor
			List<ChangeEvent> events = eventChain.getEvents();
			boolean doRefresh = true;

			for (ChangeEvent changeEvent : events) {
				if (changeEvent instanceof PartitionSaveEvent) {
					PartitionSaveEvent partitionSaveEvent = (PartitionSaveEvent) changeEvent;
					Connection triggerConnection = partitionSaveEvent.getEventTriggerConnection();

					if (triggerConnection != null
							&& triggerConnection.equals(ModelAdapter.getInstance().getConnection(mRefObject))) {
						doRefresh = false;
						break;
					}
				}
				// PartitionContentChangeEvents are also received here. They
				// seem to be always refer to another connection than the
				// RefObject's connection. So there is no need (and no potential
				// to optimize here)
			}

			if (doRefresh) {
				PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
					public void run() {
						// immediately update this section as detail sections
						// and tabbed property sections are not updated
						// otherwise (refresh is only called on registered
						// section parts)
						refresh(true);
					}
				});
			}
		}
	}
}
