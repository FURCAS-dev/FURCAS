package com.sap.mi.gfw.features.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.mi.gfw.command.AddFeatureCommandWithContext;
import com.sap.mi.gfw.command.CommandExec;
import com.sap.mi.gfw.command.GenericFeatureCommandWithContext;
import com.sap.mi.gfw.dt.IDiagramTypeProvider;
import com.sap.mi.gfw.features.IAddBendpointFeature;
import com.sap.mi.gfw.features.IAddFeature;
import com.sap.mi.gfw.features.ICreateConnectionFeature;
import com.sap.mi.gfw.features.ICreateFeature;
import com.sap.mi.gfw.features.IDeleteFeature;
import com.sap.mi.gfw.features.IDirectEditingFeature;
import com.sap.mi.gfw.features.IDirectEditingInfo;
import com.sap.mi.gfw.features.IFeature;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.ILayoutFeature;
import com.sap.mi.gfw.features.IMoveAnchorFeature;
import com.sap.mi.gfw.features.IMoveBendpointFeature;
import com.sap.mi.gfw.features.IMoveConnectionDecoratorFeature;
import com.sap.mi.gfw.features.IMoveShapeFeature;
import com.sap.mi.gfw.features.IPrintFeature;
import com.sap.mi.gfw.features.IReason;
import com.sap.mi.gfw.features.IReconnectionFeature;
import com.sap.mi.gfw.features.IRemoveBendpointFeature;
import com.sap.mi.gfw.features.IRemoveFeature;
import com.sap.mi.gfw.features.IResizeShapeFeature;
import com.sap.mi.gfw.features.ISaveImageFeature;
import com.sap.mi.gfw.features.IUpdateFeature;
import com.sap.mi.gfw.features.context.IAddBendpointContext;
import com.sap.mi.gfw.features.context.IAddContext;
import com.sap.mi.gfw.features.context.ICustomContext;
import com.sap.mi.gfw.features.context.IDeleteContext;
import com.sap.mi.gfw.features.context.IDirectEditingContext;
import com.sap.mi.gfw.features.context.ILayoutContext;
import com.sap.mi.gfw.features.context.IMoveAnchorContext;
import com.sap.mi.gfw.features.context.IMoveBendpointContext;
import com.sap.mi.gfw.features.context.IMoveConnectionDecoratorContext;
import com.sap.mi.gfw.features.context.IMoveShapeContext;
import com.sap.mi.gfw.features.context.IPictogramElementContext;
import com.sap.mi.gfw.features.context.IReconnectionContext;
import com.sap.mi.gfw.features.context.IRemoveBendpointContext;
import com.sap.mi.gfw.features.context.IRemoveContext;
import com.sap.mi.gfw.features.context.IResizeShapeContext;
import com.sap.mi.gfw.features.context.IUpdateContext;
import com.sap.mi.gfw.features.context.impl.base.PictogramElementContext;
import com.sap.mi.gfw.features.custom.ICustomFeature;
import com.sap.mi.gfw.features.jam.DefaultReconnectionFeature;
import com.sap.mi.gfw.features.jam.IIndependenceSolver;
import com.sap.mi.gfw.internal.util.MoinHelper;
import com.sap.mi.gfw.mm.links.DiagramLink;
import com.sap.mi.gfw.mm.links.PictogramLink;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.mm.pictograms.Property;
import com.sap.mi.gfw.platform.IDiagramEditor;
import com.sap.mi.gfw.util.LinkUtil;
import com.sap.mi.gfw.util.PackageUtil;
import com.sap.mi.gfw.util.PeUtil;
import com.sap.mi.gfw.util.T;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.commands.PartitionOperation;

/**
 * The Class AbstractFeatureProvider.
 */
public abstract class AbstractFeatureProvider implements IFeatureProvider {

	private static final ICustomFeature[] ZERO_CUSTOM_FEATURES = new ICustomFeature[0];

	/**
	 * The Constant EMPTY_REF_OBJECTS.
	 */
	protected static final RefObject[] EMPTY_REF_OBJECTS = new RefObject[0];

	/**
	 * The Constant EMPTY_PICTOGRAM_ELEMENTS.
	 */
	protected static final PictogramElement[] EMPTY_PICTOGRAM_ELEMENTS = new PictogramElement[0];

	private IDiagramTypeProvider dtp;

	private IDirectEditingInfo directEditingInfo = new DefaultDirectEditingInfo();

	private IIndependenceSolver independenceSolver = null;

	/**
	 * Instantiates a new abstract feature provider.
	 * 
	 * @param diagramTypeProvider
	 *            the diagram type provider
	 */
	public AbstractFeatureProvider(IDiagramTypeProvider diagramTypeProvider) {
		super();
		dtp = diagramTypeProvider;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getAddFeature(com.sap.mi.gfw.features.context.IAddContext)
	 */
	public IAddFeature getAddFeature(IAddContext context) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getCreateConnectionFeatures()
	 */
	public ICreateConnectionFeature[] getCreateConnectionFeatures() {
		return new ICreateConnectionFeature[0];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.edit.IFeatureProvider#getCreateFeatures()
	 */
	public ICreateFeature[] getCreateFeatures() {
		return new ICreateFeature[0];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getCustomFeatures(com.sap.mi.gfw.features.IContext)
	 */
	public ICustomFeature[] getCustomFeatures(ICustomContext context) {
		return ZERO_CUSTOM_FEATURES;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getDeleteFeature(com.sap.mi.gfw.features.context.IDeleteContext)
	 */
	public IDeleteFeature getDeleteFeature(IDeleteContext context) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getDiagramTypeProvider()
	 */
	public IDiagramTypeProvider getDiagramTypeProvider() {
		return dtp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.edit.IFeatureProvider#getPropertyFeatures()
	 */

	public IMoveAnchorFeature getMoveAnchorFeature(IMoveAnchorContext context) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.edit.IFeatureProvider#getRemoveFeature(com.sap.mi.gfw.dt.IContext)
	 */
	public IRemoveFeature getRemoveFeature(IRemoveContext context) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getUpdateFeature(com.sap.mi.gfw.features.context.IUpdateContext)
	 */
	public IUpdateFeature getUpdateFeature(IUpdateContext context) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getLayoutFeature(com.sap.mi.gfw.features.context.ILayoutContext)
	 */
	public ILayoutFeature getLayoutFeature(ILayoutContext context) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getMoveShapeFeatures(com.sap.mi.gfw.features.context.IMoveShapeContext)
	 */
	public IMoveShapeFeature getMoveShapeFeature(IMoveShapeContext context) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seecom.sap.mi.gfw.features.IFeatureProvider#getMoveConnectionDecoratorFeatures(com.sap.mi.gfw.features.context.
	 * IMoveConnectionDecoratorContext)
	 */
	public IMoveConnectionDecoratorFeature getMoveConnectionDecoratorFeature(IMoveConnectionDecoratorContext context) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getMoveBendpointFeatures(com.sap.mi.gfw.features.context.IMoveBendpointContext)
	 */
	public IMoveBendpointFeature getMoveBendpointFeature(IMoveBendpointContext context) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getResizeShapeFeatures(com.sap.mi.gfw.features.context.IResizeShapeContext)
	 */
	public IResizeShapeFeature getResizeShapeFeature(IResizeShapeContext context) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getAddBendpointFeature(com.sap.mi.gfw.features.context.IAddBendpointContext)
	 */
	public IAddBendpointFeature getAddBendpointFeature(IAddBendpointContext context) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getRemoveBendpointFeature(com.sap.mi.gfw.features.context.IRemoveBendpointContext)
	 */
	public IRemoveBendpointFeature getRemoveBendpointFeature(IRemoveBendpointContext context) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getDirectEditingFeature(com.sap.mi.gfw.features.context.IDirectEditingContext)
	 */
	public IDirectEditingFeature getDirectEditingFeature(IDirectEditingContext context) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IConvenientFeatureProvider#canUpdate(com.sap.mi.gfw.features.context.IUpdateContext)
	 */
	public IReason canUpdate(IUpdateContext context) {
		final String SIGNATURE = "canUpdate(IUpdateContext)"; //$NON-NLS-1$
		boolean info = T.racer().info();
		if (info) {
			T.racer().entering(AbstractFeatureProvider.class, SIGNATURE, new Object[] { context });
		}
		IReason ret = Reason.createFalseReason();
		IUpdateFeature updateFeature = getUpdateFeature(context);
		if (updateFeature != null) {
			boolean b = updateFeature.canUpdate(context);
			ret = new Reason(b);
		}
		if (info) {
			T.racer().exiting(AbstractFeatureProvider.class, SIGNATURE, ret);
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeatureProvider#canLayout(com.sap.mi.gfw.features.context.ILayoutContext)
	 */
	public IReason canLayout(ILayoutContext context) {
		final String SIGNATURE = "canLayout(ILayoutContext)"; //$NON-NLS-1$
		boolean info = T.racer().info();
		if (info) {
			T.racer().entering(AbstractFeatureProvider.class, SIGNATURE, new Object[] { context });
		}
		IReason ret = Reason.createFalseReason();
		ILayoutFeature layoutFeature = getLayoutFeature(context);
		if (layoutFeature != null) {
			boolean b = layoutFeature.canLayout(context);
			ret = new Reason(b);
		}
		if (info) {
			T.racer().exiting(AbstractFeatureProvider.class, SIGNATURE, ret);
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IConvenientFeatureProvider#updateIfPossible(com.sap.mi.gfw.features.context.IUpdateContext)
	 */
	public IReason updateIfPossible(IUpdateContext context) {
		final String SIGNATURE = "updateIfPossible(IUpdateContext)"; //$NON-NLS-1$
		boolean info = T.racer().info();
		if (info) {
			T.racer().entering(AbstractFeatureProvider.class, SIGNATURE, new Object[] { context });
		}
		boolean b = false;
		IUpdateFeature updateFeature = getUpdateFeature(context);
		if (updateFeature != null) {
			// if (updateSemanticsFeature != null &&
			// updateSemanticsFeature.canUpdate(context)) {
			// ret = updateSemanticsFeature.update(context);
			// }
			b = CommandExec.getSingleton().executeCommand(new GenericFeatureCommandWithContext(updateFeature, context), getConnection());
		}
		IReason reason = new Reason(b);
		if (info) {
			T.racer().exiting(AbstractFeatureProvider.class, SIGNATURE, reason);
		}
		return reason;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeatureProvider#layoutIfPossible(com.sap.mi.gfw.features.context.ILayoutContext)
	 */
	public IReason layoutIfPossible(ILayoutContext context) {
		final String SIGNATURE = "layoutIfPossible(ILayoutContext)"; //$NON-NLS-1$
		boolean info = T.racer().info();
		if (info) {
			T.racer().entering(AbstractFeatureProvider.class, SIGNATURE, new Object[] { context });
		}
		boolean b = false;
		ILayoutFeature layoutSemanticsFeature = getLayoutFeature(context);
		if (layoutSemanticsFeature != null) {
			b = CommandExec.getSingleton().executeCommand(new GenericFeatureCommandWithContext(layoutSemanticsFeature, context),
					getConnection());
		}
		IReason res = new Reason(b);
		if (info) {
			T.racer().exiting(AbstractFeatureProvider.class, SIGNATURE, res);
		}
		return res;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IConvenientFeatureProvider#updateNeeded(com.sap.mi.gfw.features.context.IUpdateContext)
	 */
	public IReason updateNeeded(IUpdateContext context) {
		final String SIGNATURE = "updateNeeded(IUpdateContext)"; //$NON-NLS-1$
		boolean info = T.racer().info();
		if (info) {
			T.racer().entering(AbstractFeatureProvider.class, SIGNATURE, new Object[] { context });
		}
		IReason ret = Reason.createFalseReason();
		PictogramElement pe = context.getPictogramElement();
		if (pe != null && MoinHelper.isObjectAlive(pe)) {
			IUpdateFeature updateFeature = getUpdateFeature(context);
			if (updateFeature != null) {
				ret = updateFeature.updateNeeded(context);
			}
		}
		if (info) {
			T.racer().exiting(AbstractFeatureProvider.class, SIGNATURE, ret);
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IConvenientFeatureProvider#updateIfPossibleAndNeeded(com.sap.mi.gfw.features.context.IUpdateContext)
	 */
	public IReason updateIfPossibleAndNeeded(IUpdateContext context) {
		final String SIGNATURE = "updateIfPossibleAndNeeded(IUpdateContext)"; //$NON-NLS-1$
		boolean info = T.racer().info();
		if (info) {
			T.racer().entering(AbstractFeatureProvider.class, SIGNATURE, new Object[] { context });
		}
		IReason ret = canUpdate(context);
		if (ret.toBoolean()) {
			ret = updateNeeded(context);
			if (ret.toBoolean()) {
				ret = updateIfPossible(context);
			}
		}
		if (info) {
			T.racer().exiting(AbstractFeatureProvider.class, SIGNATURE, ret);
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IConvenientFeatureProvider#addIfPossible(com.sap.mi.gfw.features.context.IAddContext)
	 */
	public PictogramElement addIfPossible(IAddContext context) {
		final String SIGNATURE = "addIfPossible(IAddContext)"; //$NON-NLS-1$
		boolean info = T.racer().info();
		if (info) {
			T.racer().entering(AbstractFeatureProvider.class, SIGNATURE, new Object[] { context });
		}
		PictogramElement ret = null;
		if (canAdd(context).toBoolean()) {
			IAddFeature feature = getAddFeature(context);
			AddFeatureCommandWithContext addFeatureCommandWithContext = new AddFeatureCommandWithContext(feature, context);
			boolean b = CommandExec.getSingleton().executeCommand(addFeatureCommandWithContext, getConnection());
			if (b) {
				ret = addFeatureCommandWithContext.getAddedPictogramElements();
				IDiagramEditor diagramEditor = getDiagramTypeProvider().getDiagramEditor();
				if (diagramEditor != null) {
					diagramEditor.setPictogramElementForSelection(ret);
				}
			}
		}
		if (info) {
			T.racer().exiting(AbstractFeatureProvider.class, SIGNATURE, ret);
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IConvenientFeatureProvider#canAdd(com.sap.mi.gfw.features.context.IAddContext)
	 */
	public IReason canAdd(IAddContext context) {
		final String SIGNATURE = "canAdd(IAddContext)"; //$NON-NLS-1$
		boolean info = T.racer().info();
		if (info) {
			T.racer().entering(AbstractFeatureProvider.class, SIGNATURE, new Object[] { context });
		}
		IReason ret = Reason.createFalseReason();
		IAddFeature feature = getAddFeature(context);
		if (feature != null) {
			boolean b = feature.canAdd(context);
			ret = new Reason(b);
		}
		if (info) {
			T.racer().exiting(AbstractFeatureProvider.class, SIGNATURE, ret);
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getDirectEditingInfo()
	 */
	final public IDirectEditingInfo getDirectEditingInfo() {
		return directEditingInfo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getDragAndDropFeatures(PictogramElementContext context)
	 */
	/**
	 * Gets the drag and drop features.
	 * 
	 * @param context
	 *            the context
	 * @return the drag and drop features
	 */
	public IFeature[] getDragAndDropFeatures(PictogramElementContext context) {
		return new IFeature[0];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getReconnectionFeature(com.sap.mi.gfw.features.context.IReconnectionContext)
	 */
	public IReconnectionFeature getReconnectionFeature(IReconnectionContext context) {
		return new DefaultReconnectionFeature(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getPrintFeature()
	 */
	public IPrintFeature getPrintFeature() {
		return new DefaultPrintFeature(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getSaveImageFeature()
	 */
	public ISaveImageFeature getSaveImageFeature() {
		return new DefaultSaveImageFeature(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getConnection()
	 */
	public Connection getConnection() {
		final String SIGNATURE = "getConnection()"; //$NON-NLS-1$
		boolean info = T.racer().info();
		if (info) {
			T.racer().entering(AbstractFeatureProvider.class, SIGNATURE, new Object[0]);
		}
		Connection ret = null;

		IDiagramEditor diagramEditor = getDiagramTypeProvider().getDiagramEditor();
		if (diagramEditor != null) {
			ret = diagramEditor.getConnection();
		}

		if (ret == null) {
			Diagram diagram = getDiagramTypeProvider().getDiagram();
			if (diagram != null) {
				ret = diagram.get___Connection();
			}
		}
		if (info) {
			T.racer().exiting(AbstractFeatureProvider.class, SIGNATURE, ret);
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getPackage(java.lang.String)
	 */
	public RefPackage getPackage(String packageName) {
		return getConnection().getPackage(null, packageName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getDragAndDropFeatures(com.sap.mi.gfw.features.context.IPictogramElementContext)
	 */
	public IFeature[] getDragAndDropFeatures(IPictogramElementContext context) {
		return new IFeature[0];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IMappingProvider#getAllBusinessObjectsForPictogramElement(com.sap.mi.gfw.mm.pictograms.PictogramElement)
	 */
	public Object[] getAllBusinessObjectsForPictogramElement(PictogramElement pictogramElement) {
		final String SIGNATURE = "getAllBusinessObjectsForPictogramElement(PictogramElement)"; //$NON-NLS-1$
		boolean info = T.racer().info();
		if (info) {
			T.racer().entering(AbstractFeatureProvider.class, SIGNATURE, new Object[] { pictogramElement });
		}
		Object[] ret = new Object[0];
		List<Object> retList = new ArrayList<Object>();

		if (getIndependenceSolver() != null) {
			Property property = LinkUtil.getIndependentProperty(pictogramElement);
			if (property != null && property.getValue() != null) {
				// TODO currently only a single linked business object is
				// supported
				retList.add(getIndependenceSolver().getBusinessObjectForKey(property.getValue()));
			}
		}

		RefObject[] allBusinessObjectsForLinkedPictogramElement = LinkUtil.getAllBusinessObjectsForLinkedPictogramElement(pictogramElement);
		for (RefObject refObject : allBusinessObjectsForLinkedPictogramElement) {
			retList.add(refObject);
		}
		if (info) {
			T.racer().exiting(AbstractFeatureProvider.class, SIGNATURE, ret);
		}
		return retList.toArray(ret);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IMappingProvider#getBusinessObjectForPictogramElement(com.sap.mi.gfw.mm.pictograms.PictogramElement)
	 */
	public Object getBusinessObjectForPictogramElement(PictogramElement pictogramElement) {
		final String SIGNATURE = "getBusinessObjectForPictogramElement(PictogramElement)"; //$NON-NLS-1$
		boolean info = T.racer().info();
		if (info) {
			T.racer().entering(AbstractFeatureProvider.class, SIGNATURE, new Object[] { pictogramElement });
		}
		Object ret = null;

		if (getIndependenceSolver() != null) {
			Property property = LinkUtil.getIndependentProperty(pictogramElement);
			if (property != null && property.getValue() != null) {
				ret = getIndependenceSolver().getBusinessObjectForKey(property.getValue());
				if (ret != null) {
					if (info) {
						T.racer().exiting(AbstractFeatureProvider.class, SIGNATURE, ret);
					}
					return ret;
				}
			}
		}

		ret = LinkUtil.getBusinessObjectForLinkedPictogramElement(pictogramElement);
		if (info) {
			T.racer().exiting(AbstractFeatureProvider.class, SIGNATURE, ret);
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IMappingProvider#getAllPictogramElementsForBusinessObject(java.lang.Object)
	 */
	public PictogramElement[] getAllPictogramElementsForBusinessObject(Object businessObject) {
		final String SIGNATURE = "getAllPictogramElementsForBusinessObject(Object)"; //$NON-NLS-1$
		boolean info = T.racer().info();
		if (info) {
			T.racer().entering(AbstractFeatureProvider.class, SIGNATURE, new Object[] { businessObject });
		}
		List<PictogramElement> retList = new ArrayList<PictogramElement>();

		IIndependenceSolver solver = getIndependenceSolver();
		if (solver != null) {
			String keyForBusinessObject = solver.getKeyForBusinessObject(businessObject);
			if (keyForBusinessObject != null) {
				Collection<PictogramElement> allContainedPictogramElements = PeUtil
						.getAllContainedPictogramElements(getDiagramTypeProvider().getDiagram());
				for (PictogramElement pe : allContainedPictogramElements) {
					Property property = LinkUtil.getIndependentProperty(pe);
					if (property != null && keyForBusinessObject.equals(property.getValue())) {
						retList.add(pe);
					}
				}
			}
		}

		if (businessObject instanceof RefObject) {
			DiagramLink diagramLink = getDiagramTypeProvider().getDiagramLink();
			if (diagramLink != null) {
				Collection<PictogramLink> pictogramLinks = diagramLink.getPictogramLinks();
				for (PictogramLink pictogramLink : pictogramLinks) {
					Collection<Object> businessObjects = (Collection) pictogramLink.getBusinessObjects();
					if (businessObjects.contains(businessObject)) {
						PictogramElement pe = pictogramLink.getPictogramElement();
						if (pe != null) {
							retList.add(pe);
						}
					}
				}
			}
		}

		PictogramElement[] res = retList.toArray(new PictogramElement[0]);
		if (info) {
			T.racer().exiting(AbstractFeatureProvider.class, SIGNATURE, res);
		}
		return res;
	}

	/**
	 * This method is similar to.
	 * 
	 * @param businessObject
	 *            the business object
	 * @return the pictogram element for business object
	 * @see "getPictogramElementsForBusinessObject()", but only return the first PictogramElement.
	 */
	public PictogramElement getPictogramElementForBusinessObject(Object businessObject) {
		final String SIGNATURE = "getPictogramElementForBusinessObject(Object)"; //$NON-NLS-1$
		boolean info = T.racer().info();
		if (info) {
			T.racer().entering(AbstractFeatureProvider.class, SIGNATURE, new Object[] { businessObject });
		}
		PictogramElement result = null;

		if (businessObject instanceof RefObject) {
			DiagramLink diagramLink = getDiagramTypeProvider().getDiagramLink();
			if (diagramLink != null) {
				Collection<PictogramLink> pictogramLinks = diagramLink.getPictogramLinks();
				for (PictogramLink pictogramLink : pictogramLinks) {
					Collection<Object> businessObjects = (Collection) pictogramLink.getBusinessObjects();
					if (businessObjects.contains(businessObject)) {
						PictogramElement pe = pictogramLink.getPictogramElement();
						if (pe != null) {
							result = pe;
							break;
						}
					}
				}
			}
		} else {
			IIndependenceSolver solver = getIndependenceSolver();
			if (solver != null) {
				String keyForBusinessObject = solver.getKeyForBusinessObject(businessObject);
				if (keyForBusinessObject != null) {
					Collection<PictogramElement> allContainedPictogramElements = PeUtil
							.getAllContainedPictogramElements(getDiagramTypeProvider().getDiagram());
					for (PictogramElement pe : allContainedPictogramElements) {
						Property property = LinkUtil.getIndependentProperty(pe);
						if (property != null && keyForBusinessObject.equals(property.getValue())) {
							result = pe;
							break;
						}
					}
				}
			}
		}
		if (info) {
			T.racer().exiting(AbstractFeatureProvider.class, SIGNATURE, result);
		}
		return result;
	}

	/**
	 * Check does there have pictogram element linked to this business object.
	 * 
	 * @param businessObject
	 *            the business object
	 * @return true when at least one pictogram element is linked, otherwise return false.
	 */
	public boolean hasPictogramElementForBusinessObject(Object businessObject) {
		return getPictogramElementForBusinessObject(businessObject) != null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IMappingProvider#link(com.sap.mi.gfw.mm.pictograms.PictogramElement, java.lang.Object)
	 */
	public void link(PictogramElement pictogramElement, Object businessObject) {
		link(pictogramElement, new Object[] { businessObject });
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IMappingProvider#link(com.sap.mi.gfw.mm.pictograms.PictogramElement, java.lang.Object[])
	 */
	public void link(PictogramElement pictogramElement, Object[] businessObjects) {
		final String SIGNATURE = "link(PictogramElement, Object[])"; //$NON-NLS-1$
		boolean info = T.racer().info();
		if (info) {
			T.racer().entering(AbstractFeatureProvider.class, SIGNATURE, new Object[] { pictogramElement, businessObjects });
		}
		IIndependenceSolver is = getIndependenceSolver();
		if (getIndependenceSolver() == null) {
			PictogramLink link = createOrGetPictogramLink(pictogramElement);
			if (link != null) {
				// remove currently linked BOs and add new BOs
				link.getBusinessObjects().clear();
				if (businessObjects != null) {
					for (int i = 0; i < businessObjects.length; i++) {
						RefObject bo = (RefObject) businessObjects[i];
						if (bo != null) {
							link.getBusinessObjects().add(bo);
						}
					}
				}
			}
		} else {
			// TODO currently only a single linked business object is supported
			String propertyValue = is.getKeyForBusinessObject(businessObjects[0]);
			LinkUtil.setIndependentProperty(pictogramElement, propertyValue);
		}
		if (info) {
			T.racer().exiting(AbstractFeatureProvider.class, SIGNATURE);
		}
	}

	private PictogramLink createPictogramLink(PictogramElement pe) {
		PictogramLink ret = null;
		Diagram diagram = getDiagramTypeProvider().getDiagram();
		if (diagram != null) {
			// create new link
			ret = (PictogramLink) PackageUtil.getLinksPackage(diagram).getPictogramLink()
					.refCreateInstanceInPartition(pe.get___Partition());
			ret.setPictogramElement(pe);

			// add new link to diagram-link
			DiagramLink diagramLink = getDiagramTypeProvider().getDiagramLink();
			if (diagramLink != null) {
				diagramLink.getPictogramLinks().add(ret);
			}
		}
		return ret;
	}

	private PictogramLink createOrGetPictogramLink(PictogramElement pe) {
		PictogramLink link = pe.getLink();
		if (link == null) {
			link = createPictogramLink(pe);
		}
		return link;
	}

	/**
	 * Gets the independence solver.
	 * 
	 * @return the independence solver
	 */
	protected final IIndependenceSolver getIndependenceSolver() {
		return independenceSolver;
	}

	/**
	 * Sets the independence solver.
	 * 
	 * @param independenceSolver
	 *            the new independence solver
	 */
	protected final void setIndependenceSolver(IIndependenceSolver independenceSolver) {
		this.independenceSolver = independenceSolver;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeatureProvider#getAffectedPartitionsForModification()
	 */
	public Collection<PartitionOperation> getAffectedPartitionsForModification() {
		return null;
	}
}
