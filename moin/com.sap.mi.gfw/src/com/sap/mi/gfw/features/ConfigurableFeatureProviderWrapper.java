/**
 * 
 */
package com.sap.mi.gfw.features;

import java.util.ArrayList;
import java.util.List;

import com.sap.mi.gfw.features.context.IAddBendpointContext;
import com.sap.mi.gfw.features.context.IAddContext;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.ICustomContext;
import com.sap.mi.gfw.features.context.IDeleteContext;
import com.sap.mi.gfw.features.context.IDirectEditingContext;
import com.sap.mi.gfw.features.context.ILayoutContext;
import com.sap.mi.gfw.features.context.IMoveAnchorContext;
import com.sap.mi.gfw.features.context.IMoveBendpointContext;
import com.sap.mi.gfw.features.context.IMoveConnectionDecoratorContext;
import com.sap.mi.gfw.features.context.IMoveShapeContext;
import com.sap.mi.gfw.features.context.IPasteContext;
import com.sap.mi.gfw.features.context.IPictogramElementContext;
import com.sap.mi.gfw.features.context.IReconnectionContext;
import com.sap.mi.gfw.features.context.IRemoveBendpointContext;
import com.sap.mi.gfw.features.context.IRemoveContext;
import com.sap.mi.gfw.features.context.IResizeShapeContext;
import com.sap.mi.gfw.features.context.IUpdateContext;
import com.sap.mi.gfw.features.custom.ICustomFeature;
import com.sap.mi.gfw.features.impl.Reason;
import com.sap.mi.gfw.tb.IToolBehaviorProvider;

/**
 * @author d025638
 * 
 */
public class ConfigurableFeatureProviderWrapper extends DefaultFeatureProviderWrapper {

	/**
	 * @param innerFeatureProvider
	 */
	public ConfigurableFeatureProviderWrapper(IFeatureProvider innerFeatureProvider) {
		super(innerFeatureProvider);
	}

	@Override
	public IReason canAdd(IAddContext context) {
		IFeatureChecker featureChecker = getFeatureChecker();
		if (featureChecker == null || featureChecker.allowAdd(context)) {
			return super.canAdd(context);
		} else {
			return Reason.createFalseReason();
		}
	}

	@Override
	public IReason canLayout(ILayoutContext context) {
		IFeatureChecker featureChecker = getFeatureChecker();
		if (featureChecker == null || featureChecker.allowLayout(context)) {
			return super.canLayout(context);
		} else {
			return Reason.createFalseReason();
		}
	}

	@Override
	public IReason canUpdate(IUpdateContext context) {
		IFeatureChecker featureChecker = getFeatureChecker();
		if (featureChecker == null || featureChecker.allowUpdate(context)) {
			return super.canUpdate(context);
		} else {
			return Reason.createFalseReason();
		}
	}

	@Override
	public IAddBendpointFeature getAddBendpointFeature(IAddBendpointContext context) {
		IFeatureChecker featureChecker = getFeatureChecker();
		if (featureChecker == null || featureChecker.allowAdd(context)) {
			return super.getAddBendpointFeature(context);
		} else {
			return null;
		}
	}

	@Override
	public IAddFeature getAddFeature(IAddContext context) {
		IFeatureChecker featureChecker = getFeatureChecker();
		if (featureChecker == null || featureChecker.allowAdd(context)) {
			return super.getAddFeature(context);
		} else {
			return null;
		}
	}

	@Override
	public ICreateConnectionFeature[] getCreateConnectionFeatures() {
		IFeatureChecker featureChecker = getFeatureChecker();
		if (featureChecker == null || featureChecker.allowCreate()) {
			return super.getCreateConnectionFeatures();
		} else {
			return new ICreateConnectionFeature[0];
		}
	}

	@Override
	public ICreateFeature[] getCreateFeatures() {
		IFeatureChecker featureChecker = getFeatureChecker();
		if (featureChecker == null || featureChecker.allowCreate()) {
			return super.getCreateFeatures();
		} else {
			return new ICreateFeature[0];
		}
	}

	@Override
	public ICustomFeature[] getCustomFeatures(ICustomContext context) {
		IFeatureChecker featureChecker = getFeatureChecker();
		if (featureChecker == null) {
			return super.getCustomFeatures(context);
		} else if (featureChecker.allowCustomFeatures(context)) {
			ICustomFeature[] customFeatures = super.getCustomFeatures(context);
			return filterAllowedCustomFeatures(customFeatures, context);
		} else {
			return new ICustomFeature[0];
		}
	}

	private ICustomFeature[] filterAllowedCustomFeatures(ICustomFeature[] features, IContext context) {
		List<ICustomFeature> retList = new ArrayList<ICustomFeature>();
		for (int i = 0; i < features.length; i++) {
			ICustomFeature feature = features[i];
			if (getFeatureChecker().allow(feature, context)) {
				retList.add(feature);
			}
		}
		return retList.toArray(new ICustomFeature[0]);
	}

	@Override
	public IDeleteFeature getDeleteFeature(IDeleteContext context) {
		IFeatureChecker featureChecker = getFeatureChecker();
		if (featureChecker == null || featureChecker.allowDelete(context)) {
			return super.getDeleteFeature(context);
		} else {
			return null;
		}
	}

	@Override
	public IDirectEditingFeature getDirectEditingFeature(IDirectEditingContext context) {
		IFeatureChecker featureChecker = getFeatureChecker();
		if (featureChecker == null || featureChecker.allowAdd(context)) {
			return super.getDirectEditingFeature(context);
		} else {
			return null;
		}
	}

	@Override
	public IFeature[] getDragAndDropFeatures(IPictogramElementContext context) {
		IFeatureChecker featureChecker = getFeatureChecker();
		if (featureChecker == null || featureChecker.allowDragAndDrop(context)) {
			return super.getDragAndDropFeatures(context);
		} else {
			return new IFeature[0];
		}
	}

	protected IFeatureChecker getFeatureChecker() {
		IToolBehaviorProvider currentToolBehaviorProvider = getDiagramTypeProvider().getCurrentToolBehaviorProvider();
		if (currentToolBehaviorProvider instanceof IFeatureCheckerHolder) {
			IFeatureCheckerHolder holder = (IFeatureCheckerHolder) currentToolBehaviorProvider;
			IFeatureChecker featureChecker = holder.getFeatureChecker();
			return featureChecker;
		}
		return null;
	}

	@Override
	public ILayoutFeature getLayoutFeature(ILayoutContext context) {
		IFeatureChecker featureChecker = getFeatureChecker();
		if (featureChecker == null || featureChecker.allowAdd(context)) {
			return super.getLayoutFeature(context);
		} else {
			return null;
		}
	}

	@Override
	public IMoveAnchorFeature getMoveAnchorFeature(IMoveAnchorContext context) {
		IFeatureChecker featureChecker = getFeatureChecker();
		if (featureChecker == null || featureChecker.allowMove(context)) {
			return super.getMoveAnchorFeature(context);
		} else {
			return null;
		}
	}

	@Override
	public IMoveBendpointFeature getMoveBendpointFeature(IMoveBendpointContext context) {
		IFeatureChecker featureChecker = getFeatureChecker();
		if (featureChecker == null || featureChecker.allowMove(context)) {
			return super.getMoveBendpointFeature(context);
		} else {
			return null;
		}
	}

	@Override
	public IMoveConnectionDecoratorFeature getMoveConnectionDecoratorFeature(IMoveConnectionDecoratorContext context) {
		IFeatureChecker featureChecker = getFeatureChecker();
		if (featureChecker == null || featureChecker.allowMove(context)) {
			return super.getMoveConnectionDecoratorFeature(context);
		} else {
			return null;
		}
	}

	@Override
	public IMoveShapeFeature getMoveShapeFeature(IMoveShapeContext context) {
		IFeatureChecker featureChecker = getFeatureChecker();
		if (featureChecker == null || featureChecker.allowMove(context)) {
			return super.getMoveShapeFeature(context);
		} else {
			return null;
		}
	}

	@Override
	public IPasteFeature getPasteFeature(IPasteContext context) {
		IFeatureChecker featureChecker = getFeatureChecker();
		if (featureChecker == null || featureChecker.allowPaste(context)) {
			return super.getPasteFeature(context);
		} else {
			return null;
		}
	}

	@Override
	public IReconnectionFeature getReconnectionFeature(IReconnectionContext context) {
		IFeatureChecker featureChecker = getFeatureChecker();
		if (featureChecker == null || featureChecker.allowReconnect(context)) {
			return super.getReconnectionFeature(context);
		} else {
			return null;
		}
	}

	@Override
	public IRemoveBendpointFeature getRemoveBendpointFeature(IRemoveBendpointContext context) {
		IFeatureChecker featureChecker = getFeatureChecker();
		if (featureChecker == null || featureChecker.allowRemove(context)) {
			return super.getRemoveBendpointFeature(context);
		} else {
			return null;
		}
	}

	@Override
	public IRemoveFeature getRemoveFeature(IRemoveContext context) {
		IFeatureChecker featureChecker = getFeatureChecker();
		if (featureChecker == null || featureChecker.allowRemove(context)) {
			return super.getRemoveFeature(context);
		} else {
			return null;
		}
	}

	@Override
	public IResizeShapeFeature getResizeShapeFeature(IResizeShapeContext context) {
		IFeatureChecker featureChecker = getFeatureChecker();
		if (featureChecker == null || featureChecker.allowResize(context)) {
			return super.getResizeShapeFeature(context);
		} else {
			return null;
		}
	}

	@Override
	public IUpdateFeature getUpdateFeature(IUpdateContext context) {
		IFeatureChecker featureChecker = getFeatureChecker();
		if (featureChecker == null || featureChecker.allowUpdate(context)) {
			return super.getUpdateFeature(context);
		} else {
			return null;
		}
	}
}
