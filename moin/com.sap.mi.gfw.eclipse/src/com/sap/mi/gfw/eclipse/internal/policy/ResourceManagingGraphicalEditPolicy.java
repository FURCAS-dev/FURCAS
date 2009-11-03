package com.sap.mi.gfw.eclipse.internal.policy;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.swt.graphics.Color;

import com.sap.mi.gfw.eclipse.internal.IDisposable;
import com.sap.mi.gfw.eclipse.internal.IResourceRegistry;
import com.sap.mi.gfw.eclipse.internal.ResourceRegistry;

public abstract class ResourceManagingGraphicalEditPolicy extends GraphicalEditPolicy {

	private IResourceRegistry resourceRegistry = new ResourceRegistry();

	public ResourceManagingGraphicalEditPolicy() {
		super();
	}

	protected void disposeFigure(IFigure figure) {
		if (figure instanceof IDisposable) {
			IDisposable d = (IDisposable) figure;
			d.dispose();
		}
	}

	protected Color manageColor(Color color) {
		int red = color.getRed();
		int green = color.getGreen();
		int blue = color.getBlue();
		Color ret = getResourceRegistry().getSwtColor(red, green, blue);
		color.dispose();
		return ret;
	}

	protected IResourceRegistry getResourceRegistry() {
		return resourceRegistry;
	}
}