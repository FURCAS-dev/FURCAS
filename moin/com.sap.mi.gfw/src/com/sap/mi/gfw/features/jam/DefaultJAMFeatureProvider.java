package com.sap.mi.gfw.features.jam;

import java.util.ArrayList;
import java.util.List;

import com.sap.mi.gfw.dt.IDiagramTypeProvider;
import com.sap.mi.gfw.features.IAddBendpointFeature;
import com.sap.mi.gfw.features.ICopyFeature;
import com.sap.mi.gfw.features.IDeleteFeature;
import com.sap.mi.gfw.features.IMoveAnchorFeature;
import com.sap.mi.gfw.features.IMoveBendpointFeature;
import com.sap.mi.gfw.features.IMoveConnectionDecoratorFeature;
import com.sap.mi.gfw.features.IMoveShapeFeature;
import com.sap.mi.gfw.features.IPasteFeature;
import com.sap.mi.gfw.features.IRemoveBendpointFeature;
import com.sap.mi.gfw.features.IRemoveFeature;
import com.sap.mi.gfw.features.IResizeShapeFeature;
import com.sap.mi.gfw.features.IUpdateFeature;
import com.sap.mi.gfw.features.context.IAddBendpointContext;
import com.sap.mi.gfw.features.context.ICopyContext;
import com.sap.mi.gfw.features.context.ICustomContext;
import com.sap.mi.gfw.features.context.IDeleteContext;
import com.sap.mi.gfw.features.context.IMoveAnchorContext;
import com.sap.mi.gfw.features.context.IMoveBendpointContext;
import com.sap.mi.gfw.features.context.IMoveConnectionDecoratorContext;
import com.sap.mi.gfw.features.context.IMoveShapeContext;
import com.sap.mi.gfw.features.context.IPasteContext;
import com.sap.mi.gfw.features.context.IRemoveBendpointContext;
import com.sap.mi.gfw.features.context.IRemoveContext;
import com.sap.mi.gfw.features.context.IResizeShapeContext;
import com.sap.mi.gfw.features.context.IUpdateContext;
import com.sap.mi.gfw.features.custom.ICustomFeature;
import com.sap.mi.gfw.features.custom.impl.QuickFixFeature;
import com.sap.mi.gfw.features.impl.AbstractFeatureProvider;
import com.sap.mi.gfw.features.impl.DefaultAddBendpointFeature;
import com.sap.mi.gfw.features.impl.DefaultMoveBendpointFeature;
import com.sap.mi.gfw.features.impl.DefaultMoveConnectionDecoratorFeature;
import com.sap.mi.gfw.features.impl.DefaultRemoveBendpointFeature;
import com.sap.mi.gfw.features.impl.DefaultResizeShapeFeature;

/**
 * The Class DefaultJAMFeatureProvider.
 */
public class DefaultJAMFeatureProvider extends AbstractFeatureProvider {

	/**
	 * Instantiates a new default jam feature provider.
	 * 
	 * @param dtp
	 *            the dtp
	 */
	public DefaultJAMFeatureProvider(IDiagramTypeProvider dtp) {
		super(dtp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sap.mi.gfw.features.impl.AbstractFeatureProvider#getAddBendpointFeature(com.sap.mi.gfw.features.context.IAddBendpointContext)
	 */
	@Override
	public IAddBendpointFeature getAddBendpointFeature(IAddBendpointContext context) {
		IAddBendpointFeature ret = new DefaultAddBendpointFeature(this);
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getCopyFeature(com.sap.mi.gfw.features.context.ICopyContext)
	 */
	public ICopyFeature getCopyFeature(ICopyContext context) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.impl.AbstractFeatureProvider#getCustomFeatures(com.sap.mi.gfw.features.context.ICustomContext)
	 */
	@Override
	public ICustomFeature[] getCustomFeatures(ICustomContext context) {
		ICustomFeature[] ret = super.getCustomFeatures(context);
		List<ICustomFeature> retList = new ArrayList<ICustomFeature>();
		for (int i = 0; i < ret.length; i++) {
			retList.add(ret[i]);
		}

		retList.add(new QuickFixFeature(this));

		ret = retList.toArray(ret);
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.edit.IFeatureProvider#getDeleteFeatures()
	 */
	@Override
	public IDeleteFeature getDeleteFeature(IDeleteContext context) {
		IDeleteFeature ret = null;
		ret = new DefaultDeleteFeature(this);
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.impl.AbstractFeatureProvider#getMoveAnchorFeature(com.sap.mi.gfw.features.context.IMoveAnchorContext)
	 */
	@Override
	public IMoveAnchorFeature getMoveAnchorFeature(IMoveAnchorContext context) {
		IMoveAnchorFeature ret = new DefaultMoveAnchorFeature(this);
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sap.mi.gfw.features.impl.AbstractFeatureProvider#getMoveBendpointFeature(com.sap.mi.gfw.features.context.IMoveBendpointContext)
	 */
	@Override
	public IMoveBendpointFeature getMoveBendpointFeature(IMoveBendpointContext context) {
		IMoveBendpointFeature ret = new DefaultMoveBendpointFeature(this);
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seecom.sap.mi.gfw.features.impl.AbstractFeatureProvider#getMoveConnectionDecoratorFeature(com.sap.mi.gfw.features.context.
	 * IMoveConnectionDecoratorContext)
	 */
	@Override
	public IMoveConnectionDecoratorFeature getMoveConnectionDecoratorFeature(IMoveConnectionDecoratorContext context) {
		IMoveConnectionDecoratorFeature ret = new DefaultMoveConnectionDecoratorFeature(this);
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.impl.AbstractFeatureProvider#getMoveShapeFeature(com.sap.mi.gfw.features.context.IMoveShapeContext)
	 */
	@Override
	public IMoveShapeFeature getMoveShapeFeature(IMoveShapeContext context) {
		IMoveShapeFeature ret = new DefaultMoveShapeFeature(this);
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getPasteFeature(com.sap.mi.gfw.features.context.IPasteContext)
	 */
	public IPasteFeature getPasteFeature(IPasteContext context) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sap.mi.gfw.features.impl.AbstractFeatureProvider#getRemoveBendpointFeature(com.sap.mi.gfw.features.context.IRemoveBendpointContext
	 * )
	 */
	@Override
	public IRemoveBendpointFeature getRemoveBendpointFeature(IRemoveBendpointContext context) {
		IRemoveBendpointFeature ret = new DefaultRemoveBendpointFeature(this);
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.impl.AbstractFeatureProvider#getResizeShapeFeature(com.sap.mi.gfw.features.context.IResizeShapeContext)
	 */
	@Override
	public IResizeShapeFeature getResizeShapeFeature(IResizeShapeContext context) {
		IResizeShapeFeature ret = new DefaultResizeShapeFeature(this);
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.impl.AbstractFeatureProvider#getRemoveFeature(com.sap.mi.gfw.features.context.IRemoveContext)
	 */
	@Override
	public IRemoveFeature getRemoveFeature(IRemoveContext context) {
		return new DefaultRemoveFeature(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.impl.AbstractFeatureProvider#getUpdateFeature(com.sap.mi.gfw.features.context.IUpdateContext)
	 */
	@Override
	public IUpdateFeature getUpdateFeature(IUpdateContext context) {
		IUpdateFeature ret = null;

		Object[] bos = getAllBusinessObjectsForPictogramElement(context.getPictogramElement());
		if (bos.length == 0) {
			ret = new UpdateNoBoFeature(this);
		} else {
			ret = super.getUpdateFeature(context);
		}

		return ret;
	}
}