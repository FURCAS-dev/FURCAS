package com.sap.mi.gfw.eclipse.internal.command;

import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProvider;
import com.sap.mi.gfw.features.IFeature;
import com.sap.mi.gfw.features.context.IContext;

public class GFWCommand extends AbstractCommand {

	private IContext context = null;

	private IFeature feature = null;

	public GFWCommand(IConfigurationProvider configurationProvider) {
		super(configurationProvider);
		// TODO Auto-generated constructor stub
	}

	public GFWCommand(IConfigurationProvider configurationProvider, String label) {
		super(configurationProvider, label);
		// TODO Auto-generated constructor stub
	}

	public IContext getContext() {
		return context;
	}

	public IFeature getFeature() {
		return feature;
	}

	public void setFeature(IFeature feature) {
		this.feature = feature;
	}

	public void setContext(IContext context) {
		this.context = context;
	}

}
