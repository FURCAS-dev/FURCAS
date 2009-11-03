package com.sap.mi.gfw.eclipse.internal.command;

import org.eclipse.gef.GraphicalEditPart;

import com.sap.mi.gfw.command.FeatureCommandWithContext;
import com.sap.mi.gfw.features.IMoveAnchorFeature;
import com.sap.mi.gfw.features.context.IMoveAnchorContext;

public class MoveAnchorFeatureCommandWithContext extends FeatureCommandWithContext {

	public MoveAnchorFeatureCommandWithContext(IMoveAnchorFeature feature, IMoveAnchorContext context, GraphicalEditPart ep) {
		super(feature, context);
	}

	public boolean canExecute() {
		IMoveAnchorContext layoutAnchorContext = getLayoutAnchorContext();
		IMoveAnchorFeature layoutAnchorFeature = getLayoutAnchorFeature();
		return layoutAnchorFeature.canMoveAnchor(layoutAnchorContext);
	}

	public boolean execute() {
		IMoveAnchorFeature layoutAnchorFeature = getLayoutAnchorFeature();
		IMoveAnchorContext layoutAnchorContext = getLayoutAnchorContext();

		layoutAnchorFeature.preMoveAnchor(layoutAnchorContext);

		layoutAnchorFeature.moveAnchor(layoutAnchorContext);

		layoutAnchorFeature.postMoveAnchor(layoutAnchorContext);

		return true;
	}

	private IMoveAnchorFeature getLayoutAnchorFeature() {
		return (IMoveAnchorFeature) getFeature();
	}

	protected IMoveAnchorContext getLayoutAnchorContext() {
		IMoveAnchorContext ret = null;
		if (getContext() instanceof IMoveAnchorContext) {
			ret = (IMoveAnchorContext) getContext();
		}
		return ret;
	}
}