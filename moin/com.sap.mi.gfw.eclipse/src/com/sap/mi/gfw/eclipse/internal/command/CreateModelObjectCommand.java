package com.sap.mi.gfw.eclipse.internal.command;

import org.eclipse.draw2d.geometry.Rectangle;

import com.sap.mi.gfw.command.CommandExec;
import com.sap.mi.gfw.command.GenericFeatureCommandWithContext;
import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProvider;
import com.sap.mi.gfw.features.ICreateFeature;
import com.sap.mi.gfw.features.context.ICreateContext;

public class CreateModelObjectCommand extends GFWCommand {

	private final Rectangle rectangle;

	public CreateModelObjectCommand(IConfigurationProvider configurationProvider, ICreateFeature feature, ICreateContext context,
			Rectangle rectangle) {
		super(configurationProvider);
		setFeature(feature);
		setContext(context);
		this.rectangle = rectangle;
	}

	@Override
	public boolean canExecute() {
		boolean ret = ((ICreateFeature) getFeature()).canCreate((ICreateContext) getContext());
		return ret;
	}

	@Override
	public void execute() {
		// create business-content
		// feature.create(context);
		GenericFeatureCommandWithContext genericFeatureCommandWithContext = new GenericFeatureCommandWithContext(getFeature(), getContext());
		CommandExec.getSingleton().executeCommand(genericFeatureCommandWithContext, getConnection());
	}

	/**
	 * @return Returns the rectangle.
	 */
	protected Rectangle getRectangle() {
		return rectangle;
	}

	@Override
	public boolean canUndo() {
		return false;
	}

	@Override
	public void undo() {
	}
}