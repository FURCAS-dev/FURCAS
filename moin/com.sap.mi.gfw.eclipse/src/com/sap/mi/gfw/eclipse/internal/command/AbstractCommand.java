package com.sap.mi.gfw.eclipse.internal.command;

import org.eclipse.gef.commands.Command;

import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProvider;
import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProviderHolder;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.tc.moin.repository.Connection;

public abstract class AbstractCommand extends Command implements IConfigurationProviderHolder {

	private IConfigurationProvider configurationProvider;

	public AbstractCommand(IConfigurationProvider configurationProvider, String label) {
		super(label);
		this.configurationProvider = configurationProvider;
	}

	public AbstractCommand(IConfigurationProvider configurationProvider) {
		super();
		this.configurationProvider = configurationProvider;
	}

	public IConfigurationProvider getConfigurationProvider() throws IllegalStateException {
		return configurationProvider;
	}

	protected IFeatureProvider getFeatureProvider() {
		return getConfigurationProvider().getDiagramTypeProvider().getFeatureProvider();
	}

	protected Connection getConnection() {
		return getFeatureProvider().getConnection();
	}
}