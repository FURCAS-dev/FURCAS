package com.sap.mi.gfw.eclipse.internal.config;

import org.eclipse.core.internal.resources.ResourceException;

import com.sap.mi.gfw.dt.IDiagramTypeProvider;
import com.sap.mi.gfw.eclipse.internal.IResourceRegistry;
import com.sap.mi.gfw.eclipse.internal.editor.DiagramEditor;
import com.sap.mi.gfw.eclipse.internal.partfactory.PictogramsEditPartFactory;
import com.sap.mi.gfw.eclipse.internal.policy.DefaultEditPolicyFactory;
import com.sap.mi.gfw.eclipse.internal.policy.IEditPolicyFactory;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.mm.pictograms.Diagram;

/**
 * A concrete implementation of the interface IConfigurationProvider, which works on a JMI Model.
 */
public class ConfigurationProvider extends AbstractConfigurationProvider {

	private IDiagramTypeProvider diagramTypeProvider;

	/**
	 * The Constructor.
	 * 
	 * @param diagramEditor
	 *            the diagram editor
	 * @param diagramTypeProvider
	 *            the diagram type provider
	 * 
	 * @throws ResourceException
	 */
	public ConfigurationProvider(DiagramEditor diagramEditor, IDiagramTypeProvider diagramTypeProvider) {
		super(diagramEditor);
		setDiagramTypeProvider(diagramTypeProvider);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.pf.eclipse.internal.config.AbstractConfigurationProvider#createEditPolicyFactory()
	 */
	@Override
	protected IEditPolicyFactory createEditPolicyFactory() {
		return new DefaultEditPolicyFactory(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.pf.eclipse.internal.config.AbstractConfigurationProvider#createEditPartFactory()
	 */
	@Override
	protected IEditPartFactory createEditPartFactory() {
		return new PictogramsEditPartFactory(this);
	}

	// ===================== overwriteable behaviour ==========================

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.pf.eclipse.internal.config.IConfigurationProvider#getDiagram()
	 */
	public Diagram getDiagram() {
		return getDiagramTypeProvider().getDiagram();
	}

	/**
	 * @param diagramTypeProvider
	 *            The diagramTypeProvider to set.
	 */
	private void setDiagramTypeProvider(IDiagramTypeProvider diagramTypeProvider) {
		this.diagramTypeProvider = diagramTypeProvider;
	}

	/**
	 * Gets the diagram type provider.
	 * 
	 * @return Returns the diagramTypeProvider.
	 */
	public IDiagramTypeProvider getDiagramTypeProvider() {
		return diagramTypeProvider;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.pf.eclipse.internal.config.IConfigurationProvider#getFeatureProvider()
	 */
	public IFeatureProvider getFeatureProvider() {
		return getDiagramTypeProvider().getFeatureProvider();
	}

	public IResourceRegistry getResourceRegistry() {
		return getDiagramEditor().getResourceRegistry();
	}
}