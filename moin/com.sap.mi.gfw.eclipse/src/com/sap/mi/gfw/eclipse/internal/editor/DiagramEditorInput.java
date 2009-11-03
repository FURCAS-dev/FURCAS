package com.sap.mi.gfw.eclipse.internal.editor;

import java.lang.ref.WeakReference;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import org.eclipse.ui.IMemento;

import com.sap.mi.fwk.ui.editor.ModelEditorInput;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.tc.moin.repository.Connection;

/**
 * The Class DiagramEditorInput.
 */
public class DiagramEditorInput extends ModelEditorInput {

	private WeakReference<Connection> externalConnection;

	private String providerId;

	/**
	 * The KE y_ provide r_ id.
	 */
	public static String KEY_PROVIDER_ID = "PROVIDERID"; //$NON-NLS-1$

	/**
	 * The Constructor.
	 * 
	 * @param diagramMriString
	 *            the diagram mri string
	 * @param providerId
	 *            the provider id
	 */
	public DiagramEditorInput(String diagramMriString, String providerId) {
		super(diagramMriString);
		setProviderId(providerId);
	}

	/**
	 * Instantiates a new diagram editor input.
	 * 
	 * @param diagram
	 *            the diagram
	 * @param externalConnection
	 *            a connection that will be used by the diagram editor. To be
	 *            used in special situations only (e.g. tests), usually this
	 *            should be <code>null</code>.
	 * @param providerId
	 *            the provider id
	 */
	public DiagramEditorInput(Diagram diagram, Connection externalConnection, String providerId) {
		super(diagram);
		setExternalConnection(externalConnection);
		setProviderId(providerId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.fwk.ui.editor.ModelEditorInput#getLiveName()
	 */
	@Override
	public String getLiveName() {
		Diagram diagram = getDiagram();
		if (diagram != null)
			return diagram.getName();
		return super.getLiveName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.fwk.ui.editor.ModelEditorInput#getLiveToolTipText()
	 */
	@Override
	public String getLiveToolTipText() {
		Diagram diagram = getDiagram();
		if (diagram != null && diagram.getDiagramTypeId() != null) {
			String id = diagram.getDiagramTypeId();
			if (id != null) {
				String tip = getLiveName();
				tip += " (" + id + ")"; //$NON-NLS-1$ //$NON-NLS-2$
				return tip;
			}
		}
		return super.getLiveToolTipText();
	}

	/**
	 * Gets the diagram.
	 * 
	 * @return Returns the diagram.
	 */
	public Diagram getDiagram() {
		return (Diagram) getAdapter(Diagram.class);
	}

	/**
	 * Gets the provider id.
	 * 
	 * @return Returns the providerId.
	 */
	public String getProviderId() {
		return providerId;
	}

	/**
	 * Sets the provider id.
	 * 
	 * @param providerId
	 *            The providerId to set.
	 */
	protected void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.fwk.ui.editor.ModelEditorInput#getFactoryId()
	 */
	@Override
	public String getFactoryId() {
		return DiagramEditorFactory.class.getName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sap.mi.fwk.ui.editor.ModelEditorInput#saveState(org.eclipse.ui.IMemento
	 * )
	 */
	@Override
	public void saveState(IMemento memento) {
		super.saveState(memento);
		memento.putString(KEY_PROVIDER_ID, providerId);
	}

	/**
	 * Gets the connection.
	 * 
	 * @return the connection
	 */
	Connection getExternalConnection() {
		if (externalConnection != null)
			return externalConnection.get();
		return null;
	}

	private void setExternalConnection(Connection externalConnection) {
		this.externalConnection = new WeakReference<Connection>(externalConnection);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sap.mi.fwk.ui.editor.ModelEditorInput#getAdapter(java.lang.Class)
	 */
	@Override
	public Object getAdapter(Class adapter) {
		if (Diagram.class.isAssignableFrom(adapter)) {
			RefBaseObject obj = getRefObject();
			if (obj instanceof Diagram) {
				return obj;
			}
		}
		return super.getAdapter(adapter);
	}
}