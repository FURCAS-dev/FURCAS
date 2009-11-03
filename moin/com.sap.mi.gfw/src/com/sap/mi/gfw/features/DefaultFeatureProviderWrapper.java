package com.sap.mi.gfw.features;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.mi.gfw.dt.IDiagramTypeProvider;
import com.sap.mi.gfw.features.context.IAddBendpointContext;
import com.sap.mi.gfw.features.context.IAddContext;
import com.sap.mi.gfw.features.context.ICopyContext;
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
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.commands.PartitionOperation;

public class DefaultFeatureProviderWrapper implements IFeatureProvider {
	private IFeatureProvider innerFeatureProvider;

	public DefaultFeatureProviderWrapper(IFeatureProvider innerFeatureProvider) {
		setInnerFeatureProvider(innerFeatureProvider);
	}

	/**
	 * @param context
	 * @return
	 * @see com.sap.mi.gfw.features.IFeatureProvider#addIfPossible(com.sap.mi.gfw.features.context.IAddContext)
	 */
	public PictogramElement addIfPossible(IAddContext context) {
		return getInnerFeatureProvider().addIfPossible(context);
	}

	/**
	 * @param context
	 * @return
	 * @see com.sap.mi.gfw.features.IFeatureProvider#canAdd(com.sap.mi.gfw.features.context.IAddContext)
	 */
	public IReason canAdd(IAddContext context) {
		return getInnerFeatureProvider().canAdd(context);
	}

	/**
	 * @param context
	 * @return
	 * @see com.sap.mi.gfw.features.IFeatureProvider#canLayout(com.sap.mi.gfw.features.context.ILayoutContext)
	 */
	public IReason canLayout(ILayoutContext context) {
		return getInnerFeatureProvider().canLayout(context);
	}

	/**
	 * @param context
	 * @return
	 * @see com.sap.mi.gfw.features.IFeatureProvider#canUpdate(com.sap.mi.gfw.features.context.IUpdateContext)
	 */
	public IReason canUpdate(IUpdateContext context) {
		return getInnerFeatureProvider().canUpdate(context);
	}

	/**
	 * @param context
	 * @return
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getAddBendpointFeature(com.sap.mi.gfw.features.context.IAddBendpointContext)
	 */
	public IAddBendpointFeature getAddBendpointFeature(IAddBendpointContext context) {
		return getInnerFeatureProvider().getAddBendpointFeature(context);
	}

	/**
	 * @param context
	 * @return
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getAddFeature(com.sap.mi.gfw.features.context.IAddContext)
	 */
	public IAddFeature getAddFeature(IAddContext context) {
		return getInnerFeatureProvider().getAddFeature(context);
	}

	/**
	 * @return
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getAffectedPartitionsForModification()
	 */
	public Collection<PartitionOperation> getAffectedPartitionsForModification() {
		return getInnerFeatureProvider().getAffectedPartitionsForModification();
	}

	/**
	 * @param pictogramElement
	 * @return
	 * @see com.sap.mi.gfw.features.IMappingProvider#getAllBusinessObjectsForPictogramElement(com.sap.mi.gfw.mm.pictograms.PictogramElement)
	 */
	public Object[] getAllBusinessObjectsForPictogramElement(PictogramElement pictogramElement) {
		return getInnerFeatureProvider().getAllBusinessObjectsForPictogramElement(pictogramElement);
	}

	/**
	 * @param businessObject
	 * @return
	 * @see com.sap.mi.gfw.features.IMappingProvider#getAllPictogramElementsForBusinessObject(java.lang.Object)
	 */
	public PictogramElement[] getAllPictogramElementsForBusinessObject(Object businessObject) {
		return getInnerFeatureProvider().getAllPictogramElementsForBusinessObject(businessObject);
	}

	/**
	 * @param pictogramElement
	 * @return
	 * @see com.sap.mi.gfw.features.IMappingProvider#getBusinessObjectForPictogramElement(com.sap.mi.gfw.mm.pictograms.PictogramElement)
	 */
	public Object getBusinessObjectForPictogramElement(PictogramElement pictogramElement) {
		return getInnerFeatureProvider().getBusinessObjectForPictogramElement(pictogramElement);
	}

	/**
	 * @return
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getConnection()
	 */
	public Connection getConnection() {
		return getInnerFeatureProvider().getConnection();
	}

	/**
	 * @param context
	 * @return
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getCopyFeature(com.sap.mi.gfw.features.context.ICopyContext)
	 */
	public ICopyFeature getCopyFeature(ICopyContext context) {
		return getInnerFeatureProvider().getCopyFeature(context);
	}

	/**
	 * @return
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getCreateConnectionFeatures()
	 */
	public ICreateConnectionFeature[] getCreateConnectionFeatures() {
		return getInnerFeatureProvider().getCreateConnectionFeatures();
	}

	/**
	 * @return
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getCreateFeatures()
	 */
	public ICreateFeature[] getCreateFeatures() {
		return getInnerFeatureProvider().getCreateFeatures();
	}

	/**
	 * @param context
	 * @return
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getCustomFeatures(com.sap.mi.gfw.features.context.ICustomContext)
	 */
	public ICustomFeature[] getCustomFeatures(ICustomContext context) {
		return getInnerFeatureProvider().getCustomFeatures(context);
	}

	/**
	 * @param context
	 * @return
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getDeleteFeature(com.sap.mi.gfw.features.context.IDeleteContext)
	 */
	public IDeleteFeature getDeleteFeature(IDeleteContext context) {
		return getInnerFeatureProvider().getDeleteFeature(context);
	}

	/**
	 * @return
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getDiagramTypeProvider()
	 */
	public IDiagramTypeProvider getDiagramTypeProvider() {
		return getInnerFeatureProvider().getDiagramTypeProvider();
	}

	/**
	 * @param context
	 * @return
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getDirectEditingFeature(com.sap.mi.gfw.features.context.IDirectEditingContext)
	 */
	public IDirectEditingFeature getDirectEditingFeature(IDirectEditingContext context) {
		return getInnerFeatureProvider().getDirectEditingFeature(context);
	}

	/**
	 * @return
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getDirectEditingInfo()
	 */
	public IDirectEditingInfo getDirectEditingInfo() {
		return getInnerFeatureProvider().getDirectEditingInfo();
	}

	/**
	 * @param context
	 * @return
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getDragAndDropFeatures(com.sap.mi.gfw.features.context.IPictogramElementContext)
	 */
	public IFeature[] getDragAndDropFeatures(IPictogramElementContext context) {
		return getInnerFeatureProvider().getDragAndDropFeatures(context);
	}

	public IFeatureProvider getInnerFeatureProvider() {
		return innerFeatureProvider;
	}

	/**
	 * @param context
	 * @return
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getLayoutFeature(com.sap.mi.gfw.features.context.ILayoutContext)
	 */
	public ILayoutFeature getLayoutFeature(ILayoutContext context) {
		return getInnerFeatureProvider().getLayoutFeature(context);
	}

	/**
	 * @param context
	 * @return
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getMoveAnchorFeature(com.sap.mi.gfw.features.context.IMoveAnchorContext)
	 */
	public IMoveAnchorFeature getMoveAnchorFeature(IMoveAnchorContext context) {
		return getInnerFeatureProvider().getMoveAnchorFeature(context);
	}

	/**
	 * @param context
	 * @return
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getMoveBendpointFeature(com.sap.mi.gfw.features.context.IMoveBendpointContext)
	 */
	public IMoveBendpointFeature getMoveBendpointFeature(IMoveBendpointContext context) {
		return getInnerFeatureProvider().getMoveBendpointFeature(context);
	}

	/**
	 * @param context
	 * @return
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getMoveConnectionDecoratorFeature(com.sap.mi.gfw.features.context.IMoveConnectionDecoratorContext)
	 */
	public IMoveConnectionDecoratorFeature getMoveConnectionDecoratorFeature(IMoveConnectionDecoratorContext context) {
		return getInnerFeatureProvider().getMoveConnectionDecoratorFeature(context);
	}

	/**
	 * @param context
	 * @return
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getMoveShapeFeature(com.sap.mi.gfw.features.context.IMoveShapeContext)
	 */
	public IMoveShapeFeature getMoveShapeFeature(IMoveShapeContext context) {
		return getInnerFeatureProvider().getMoveShapeFeature(context);
	}

	/**
	 * @param packageName
	 * @return
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getPackage(java.lang.String)
	 */
	public RefPackage getPackage(String packageName) {
		return getInnerFeatureProvider().getPackage(packageName);
	}

	/**
	 * @param context
	 * @return
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getPasteFeature(com.sap.mi.gfw.features.context.IPasteContext)
	 */
	public IPasteFeature getPasteFeature(IPasteContext context) {
		return getInnerFeatureProvider().getPasteFeature(context);
	}

	/**
	 * @param businessObject
	 * @return
	 * @see com.sap.mi.gfw.features.IMappingProvider#getPictogramElementForBusinessObject(java.lang.Object)
	 */
	public PictogramElement getPictogramElementForBusinessObject(Object businessObject) {
		return getInnerFeatureProvider().getPictogramElementForBusinessObject(businessObject);
	}

	/**
	 * @return
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getPrintFeature()
	 */
	public IPrintFeature getPrintFeature() {
		return getInnerFeatureProvider().getPrintFeature();
	}

	/**
	 * @param context
	 * @return
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getReconnectionFeature(com.sap.mi.gfw.features.context.IReconnectionContext)
	 */
	public IReconnectionFeature getReconnectionFeature(IReconnectionContext context) {
		return getInnerFeatureProvider().getReconnectionFeature(context);
	}

	/**
	 * @param context
	 * @return
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getRemoveBendpointFeature(com.sap.mi.gfw.features.context.IRemoveBendpointContext)
	 */
	public IRemoveBendpointFeature getRemoveBendpointFeature(IRemoveBendpointContext context) {
		return getInnerFeatureProvider().getRemoveBendpointFeature(context);
	}

	/**
	 * @param context
	 * @return
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getRemoveFeature(com.sap.mi.gfw.features.context.IRemoveContext)
	 */
	public IRemoveFeature getRemoveFeature(IRemoveContext context) {
		return getInnerFeatureProvider().getRemoveFeature(context);
	}

	/**
	 * @param context
	 * @return
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getResizeShapeFeature(com.sap.mi.gfw.features.context.IResizeShapeContext)
	 */
	public IResizeShapeFeature getResizeShapeFeature(IResizeShapeContext context) {
		return getInnerFeatureProvider().getResizeShapeFeature(context);
	}

	/**
	 * @return
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getSaveImageFeature()
	 */
	public ISaveImageFeature getSaveImageFeature() {
		return getInnerFeatureProvider().getSaveImageFeature();
	}

	/**
	 * @param context
	 * @return
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getUpdateFeature(com.sap.mi.gfw.features.context.IUpdateContext)
	 */
	public IUpdateFeature getUpdateFeature(IUpdateContext context) {
		return getInnerFeatureProvider().getUpdateFeature(context);
	}

	/**
	 * @param businessObject
	 * @return
	 * @see com.sap.mi.gfw.features.IMappingProvider#hasPictogramElementForBusinessObject(java.lang.Object)
	 */
	public boolean hasPictogramElementForBusinessObject(Object businessObject) {
		return getInnerFeatureProvider().hasPictogramElementForBusinessObject(businessObject);
	}

	/**
	 * @param context
	 * @return
	 * @see com.sap.mi.gfw.features.IFeatureProvider#layoutIfPossible(com.sap.mi.gfw.features.context.ILayoutContext)
	 */
	public IReason layoutIfPossible(ILayoutContext context) {
		return getInnerFeatureProvider().layoutIfPossible(context);
	}

	/**
	 * @param pictogramElement
	 * @param businessObject
	 * @see com.sap.mi.gfw.features.IMappingProvider#link(com.sap.mi.gfw.mm.pictograms.PictogramElement, java.lang.Object)
	 */
	public void link(PictogramElement pictogramElement, Object businessObject) {
		getInnerFeatureProvider().link(pictogramElement, businessObject);
	}

	/**
	 * @param pictogramElement
	 * @param businessObjects
	 * @see com.sap.mi.gfw.features.IMappingProvider#link(com.sap.mi.gfw.mm.pictograms.PictogramElement, java.lang.Object[])
	 */
	public void link(PictogramElement pictogramElement, Object[] businessObjects) {
		getInnerFeatureProvider().link(pictogramElement, businessObjects);
	}

	private void setInnerFeatureProvider(IFeatureProvider innerFeatureProvider) {
		this.innerFeatureProvider = innerFeatureProvider;
	}

	/**
	 * @param context
	 * @return
	 * @see com.sap.mi.gfw.features.IFeatureProvider#updateIfPossible(com.sap.mi.gfw.features.context.IUpdateContext)
	 */
	public IReason updateIfPossible(IUpdateContext context) {
		return getInnerFeatureProvider().updateIfPossible(context);
	}

	/**
	 * @param context
	 * @return
	 * @see com.sap.mi.gfw.features.IFeatureProvider#updateIfPossibleAndNeeded(com.sap.mi.gfw.features.context.IUpdateContext)
	 */
	public IReason updateIfPossibleAndNeeded(IUpdateContext context) {
		return getInnerFeatureProvider().updateIfPossibleAndNeeded(context);
	}

	/**
	 * @param context
	 * @return
	 * @see com.sap.mi.gfw.features.IFeatureProvider#updateNeeded(com.sap.mi.gfw.features.context.IUpdateContext)
	 */
	public IReason updateNeeded(IUpdateContext context) {
		return getInnerFeatureProvider().updateNeeded(context);
	}

}
