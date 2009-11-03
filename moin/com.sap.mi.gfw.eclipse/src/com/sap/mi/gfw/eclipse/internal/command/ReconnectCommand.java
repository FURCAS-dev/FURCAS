package com.sap.mi.gfw.eclipse.internal.command;

import com.sap.mi.gfw.command.CommandExec;
import com.sap.mi.gfw.command.GenericFeatureCommandWithContext;
import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProvider;
import com.sap.mi.gfw.features.IFeature;
import com.sap.mi.gfw.features.IFeatureAndContext;
import com.sap.mi.gfw.features.IReconnectionFeature;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.IReconnectionContext;
import com.sap.mi.gfw.features.context.impl.ReconnectionContext;
import com.sap.mi.gfw.mm.pictograms.Anchor;
import com.sap.mi.gfw.mm.pictograms.Connection;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

public class ReconnectCommand extends AbstractCommand implements IFeatureAndContext {

	private IReconnectionContext ctx;

	private IReconnectionFeature feature;

	/**
	 * Instantiate a command that can reconnect a Connection instance to a different source or target endpoint.
	 * 
	 * @param conn
	 *            the connection instance to reconnect (non-null)
	 * @throws IllegalArgumentException
	 *             if conn is null
	 */
	public ReconnectCommand(IConfigurationProvider configurationProvider, Connection connection, Anchor oldAnchor, Anchor newAnchor,
			PictogramElement newTargetPictogramElement, String reconnectType) {
		super(configurationProvider);

		this.ctx = new ReconnectionContext(connection, oldAnchor, newAnchor);
		ctx.setTargetPictogramElement(newTargetPictogramElement);
		((ReconnectionContext) ctx).setReconnectType(reconnectType);
		this.feature = getFeatureProvider().getReconnectionFeature(ctx);
	}

	@Override
	public boolean canExecute() {
		if (feature != null) {
			return feature.canReconnect(ctx);
		}
		return false;
	}

	/**
	 * Reconnect the connection to newSource (if setNewSource(...) was invoked before) or newTarget (if setNewTarget(...) was invoked
	 * before).
	 */
	@Override
	public void execute() {
		if (feature != null) {
			// feature.reconnnect(ctx);
			GenericFeatureCommandWithContext genericFeatureCommandWithContext = new GenericFeatureCommandWithContext(feature, ctx);
			CommandExec.getSingleton().executeCommand(genericFeatureCommandWithContext, getConnection());
		}
	}

	public IFeature getFeature() {
		return feature;
	}

	public IContext getContext() {
		return ctx;
	}
}