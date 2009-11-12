package com.sap.ide.moftool.editor.graphics.pattern;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.StructureField;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.ide.moftool.editor.core.MOFToolConstants;
import com.sap.ide.moftool.editor.core.commands.InternalErrorException;
import com.sap.ide.moftool.editor.core.service.ModelElementService;
import com.sap.ide.moftool.editor.core.service.StyleService;
import com.sap.ide.moftool.editor.graphics.IImageConstants;
import com.sap.ide.moftool.editor.graphics.connection.association.AddAllAssociationCustomFeature;
import com.sap.mi.gfw.GfwUtil;
import com.sap.mi.gfw.features.IDirectEditingInfo;
import com.sap.mi.gfw.features.IReason;
import com.sap.mi.gfw.features.IRemoveFeature;
import com.sap.mi.gfw.features.context.IAddContext;
import com.sap.mi.gfw.features.context.ICustomContext;
import com.sap.mi.gfw.features.context.ILayoutContext;
import com.sap.mi.gfw.features.context.IRemoveContext;
import com.sap.mi.gfw.features.context.IUpdateContext;
import com.sap.mi.gfw.features.context.impl.AddContext;
import com.sap.mi.gfw.features.context.impl.AreaContext;
import com.sap.mi.gfw.features.context.impl.CustomContext;
import com.sap.mi.gfw.features.context.impl.RemoveContext;
import com.sap.mi.gfw.features.custom.ICustomFeature;
import com.sap.mi.gfw.features.impl.Reason;
import com.sap.mi.gfw.internal.util.MoinHelper;
import com.sap.mi.gfw.mapping.ILinkCreationInfo;
import com.sap.mi.gfw.mapping.IStructureMapping;
import com.sap.mi.gfw.mapping.IStructureMappingMulti;
import com.sap.mi.gfw.mapping.IStructureMappingSingle;
import com.sap.mi.gfw.mapping.data.LabelDataMapping;
import com.sap.mi.gfw.mm.datatypes.Point;
import com.sap.mi.gfw.mm.links.PictogramLink;
import com.sap.mi.gfw.mm.pictograms.ContainerShape;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.Image;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.mm.pictograms.Polyline;
import com.sap.mi.gfw.mm.pictograms.Rectangle;
import com.sap.mi.gfw.mm.pictograms.RoundedRectangle;
import com.sap.mi.gfw.mm.pictograms.Shape;
import com.sap.mi.gfw.mm.pictograms.Style;
import com.sap.mi.gfw.mm.pictograms.Text;
import com.sap.mi.gfw.pattern.AbstractPattern;
import com.sap.mi.gfw.util.GaUtil;
import com.sap.mi.gfw.util.LinkUtil;
import com.sap.mi.gfw.util.PeUtil;

public abstract class AbstractMofCompartmentPattern extends AbstractPattern {

	private static final int NO_UPDATE = 0;
	private static final int UPDATE_DONE = 1;
	private static final int FULL_UPDATE = 2;

	private static final String PACKAGE_SHAPE = "packageShape"; //$NON-NLS-1$

	private final static int TEXT_HEIGHT = 20;

	private IStructureMappingSingle headerMapping;

	private IStructureMappingMulti[] compartmentMappings;

	public boolean innerSelectionIsActive = true;

	public AbstractMofCompartmentPattern() {
		super(new DefaultMofCompartmentPatternConfiguration());
	}

	@Override
	public boolean canAdd(IAddContext context) {
		Object object = context.getNewObject();
		if (object instanceof ModelElement) {
			ModelElement newModelElement = (ModelElement) object;
			if (!ModelElementService.isVisibleObject(getDiagram(), newModelElement)) {
				// Foreign objects (from other projects) must not be added to
				// the diagram,
				// unless the reuse hack is enabled
				return false;
			}
		}
		return true;
	}

	@Override
	public PictogramElement add(IAddContext context) {
		RefObject mainBusinessObject = (RefObject) context.getNewObject();
		ContainerShape parentContainerShape = context.getTargetContainer();

		// Outer container shape with rounded rectangle
		ContainerShape containerShape = PeUtil.createContainerShape(parentContainerShape, true);
		getFeatureProvider().getDirectEditingInfo().setMainPictogramElement(containerShape);

		{
			// Check whether valid size is available, e.g. if called from the
			// create feature
			int width = context.getWidth() <= 0 ? 150 : context.getWidth();
			int height = context.getHeight() <= 0 ? getConfiguration().getMinimumHeight() : context.getHeight();

			// Create and set graphics algorithm
			RoundedRectangle roundedRectangle = GaUtil.createRoundedRectangle(containerShape, getConfiguration().getCornerWidth(),
					getConfiguration().getCornerHeight());
			GaUtil.ignoreAll(roundedRectangle);
			roundedRectangle.setStyle(getCompartmentStyle());
			GaUtil.setLocationAndSizeOfGraphicsAlgorithm(roundedRectangle, context.getX(), context.getY(), width, height);

			// Create link and wire it
			link(containerShape, mainBusinessObject);
		}

		// Header
		{
			// Create shape for header along with rectangle as graphics
			// algorithm
			// <innerSelection> header remains inactive
			ContainerShape headerShape = PeUtil.createContainerShape(containerShape, false);
			PeUtil.setPropertyValue(headerShape, MOFToolConstants.PROPERTY_COMPARTMENT_TYPE, MOFToolConstants.COMPARTMENT_TYPE_HEADER);
			Rectangle rectangle = GaUtil.createRectangle(headerShape);
			GaUtil.ignoreAll(rectangle);
			rectangle.setStyle(StyleService.getInnerCompartmentStyle(getDiagram()));

			// Create shape and text graphics algorithm for name
			Shape nameShape = PeUtil.createShape(headerShape, false);
			link(nameShape, mainBusinessObject);
			Text text = GaUtil.createText(nameShape);
			GaUtil.ignoreAll(text);
			text.setStyle(StyleService.getObjectNameStyle(PeUtil.getDiagramForPictogramElement(nameShape)));

			// Create shape and text graphics algorithm for container name if
			// the container differs
			// from the container of the diagram
			{
				if (mainBusinessObject instanceof ModelElement) {
					ModelElement element = (ModelElement) mainBusinessObject;
					Namespace objectNamespace = element.getContainer();
					Namespace diagramNamespace = (Namespace) LinkUtil.getBusinessObjectForLinkedPictogramElement(getDiagram());
					if (!objectNamespace.equals(diagramNamespace)) {
						Shape packShape = PeUtil.createShape(headerShape, false);
						Text packName = GaUtil.createText(packShape);
						GaUtil.ignoreAll(packName);
						packName.setStyle(StyleService.getObjectContainerStyle(PeUtil.getDiagramForPictogramElement(packShape)));
						LinkUtil.setLinkProperty(packShape, PACKAGE_SHAPE);
					}
				}
			}

			IDirectEditingInfo dei = getFeatureProvider().getDirectEditingInfo();
			dei.setPictogramElement(headerShape);
			dei.setGraphicsAlgorithm(text);

			// create link and wire it
			ILinkCreationInfo linkCreationInfo = getHeaderMapping().getLinkCreationInfo(mainBusinessObject);
			String linkProperty = linkCreationInfo.getProperty();
			if (linkProperty != null) {
				LinkUtil.setLinkProperty(headerShape, linkProperty);
			}
			link(headerShape, linkCreationInfo.getBusinessObjects());
		}

		{
			for (int compartmentIndex = 0; compartmentIndex < getCompartmentCount(); compartmentIndex++) {

				// Create a line shape above each compartment
				{
					// Create shape for line
					Shape shape = PeUtil.createShape(containerShape, false);

					// Create and set graphics algorithm
					Polyline polyline = GaUtil.createPolyline(shape, new int[] { 0, 0, 0, 0 });
					GaUtil.ignoreAll(polyline);
					polyline.setStyle(getCompartmentSeparatorStyle());
				}

				// <innerSelection>
				ContainerShape compartmentContainerShape = PeUtil.createContainerShape(containerShape, innerSelectionIsActive);

				Rectangle compartmentRectangle = GaUtil.createRectangle(compartmentContainerShape);
				GaUtil.ignoreAll(compartmentRectangle);
				compartmentRectangle.setStyle(StyleService.getInnerCompartmentStyle(getDiagram()));
				// Compartment indicator
				PeUtil.setPropertyValue(compartmentContainerShape, MOFToolConstants.COMPARTMENT_NUMBER, Integer.toString(compartmentIndex));
			}
		}

		PeUtil.createChopboxAnchor(containerShape);

		// Do not call the update feature here to avoid multiple calls to update
		// -> Update must be called by all subclasses in their add feature!

		return containerShape;
	}

	/**
	 * Activates direct editing for header text control
	 */
	protected void activateHeaderTextAutoDirectEditing() {
		getFeatureProvider().getDirectEditingInfo().setActive(true);
	}

	@Override
	public boolean layout(ILayoutContext context) {
		ContainerShape outerContainerShape = (ContainerShape) context.getPictogramElement();

		// Start layout at top indent position
		int overallVerticalPosition = getConfiguration().getOuterIndentTop();

		// Outer container width
		int outerContainerWidth = outerContainerShape.getGraphicsAlgorithm().getWidth();
		int minimumWidth = getConfiguration().getMinimumWidth();
		if (outerContainerWidth < minimumWidth) {
			outerContainerShape.getGraphicsAlgorithm().setWidth(minimumWidth);
			outerContainerWidth = minimumWidth;
		}

		// The available space inside the outer container
		int spaceWithinOuterContainer = outerContainerWidth - getConfiguration().getOuterIndentLeft()
				- getConfiguration().getOuterIndentRight();

		// Loop over the children and set their sizes
		List<Shape> outerContainerChildren = outerContainerShape.getChildren();
		Iterator<Shape> iter = outerContainerChildren.iterator();
		while (iter.hasNext()) {
			Shape shape = iter.next();

			GraphicsAlgorithm ga = shape.getGraphicsAlgorithm();

			// Separation line
			if (ga instanceof Polyline) {
				Polyline pl = (Polyline) ga;

				// ... should spread across the complete outer container
				List<Point> points = pl.getPoints();
				int oldX = points.get(0).getX();
				points.set(0, GaUtil.createPoint(pl, oldX, overallVerticalPosition));
				points.set(1, GaUtil.createPoint(pl, outerContainerWidth, overallVerticalPosition));
			}

			// Compartment
			else if (shape instanceof ContainerShape) {
				ContainerShape compartmentContainerShape = (ContainerShape) shape;

				// Set vertical start position
				compartmentContainerShape.getGraphicsAlgorithm().setY(overallVerticalPosition);

				// Header compartment shape
				if (MOFToolConstants.COMPARTMENT_TYPE_HEADER.equals(PeUtil.getPropertyValue(compartmentContainerShape,
						MOFToolConstants.PROPERTY_COMPARTMENT_TYPE))) {
					List<Shape> children = compartmentContainerShape.getChildren();

					// First child is the shape for the name
					Shape nameShape = children.get(0);
					GaUtil.setLocationAndSizeOfGraphicsAlgorithm(nameShape.getGraphicsAlgorithm(), 0, 0, spaceWithinOuterContainer,
							TEXT_HEIGHT);

					// If a second child exists it is the shape for the
					// container
					if (children.size() > 1) {
						Shape packageShape = children.get(1);
						GaUtil.setLocationAndSizeOfGraphicsAlgorithm(packageShape.getGraphicsAlgorithm(), 0, TEXT_HEIGHT,
								spaceWithinOuterContainer, TEXT_HEIGHT);
					}
				}

				// Any other compartment
				else {
					// Loop over the shapes inside the compartment and do the
					// vertical positioning inside
					// the compartment
					int innerVerticalPosition = 0;
					Iterator<Shape> innerShapeIterator = compartmentContainerShape.getChildren().iterator();
					while (innerShapeIterator.hasNext()) {
						Shape innerCompartmentShape = innerShapeIterator.next();

						// The shape has a graphics algorithm that again holds
						// two graphics algorithms
						// for the image (visibility) and the name of the sub
						// object
						GraphicsAlgorithm innerGa = innerCompartmentShape.getGraphicsAlgorithm();
						GaUtil.setLocationAndSizeOfGraphicsAlgorithm(innerGa, 0, innerVerticalPosition, spaceWithinOuterContainer,
								TEXT_HEIGHT);
						GraphicsAlgorithm imageGa = innerGa.getGraphicsAlgorithmChildren().get(0);
						GaUtil.setLocationAndSizeOfGraphicsAlgorithm(imageGa, 0, 0, TEXT_HEIGHT, TEXT_HEIGHT);
						GraphicsAlgorithm textGa = innerGa.getGraphicsAlgorithmChildren().get(1);
						GaUtil.setLocationAndSizeOfGraphicsAlgorithm(textGa, TEXT_HEIGHT, 0, spaceWithinOuterContainer - TEXT_HEIGHT,
								TEXT_HEIGHT);

						// Increase inner vertical position
						innerVerticalPosition += TEXT_HEIGHT;
					}
				}

				// Set the overall height of the compartment according to the
				// number of the children
				int compartmentHeight = compartmentContainerShape.getChildren().size() * TEXT_HEIGHT;
				if (compartmentHeight == 0) {
					compartmentHeight = getConfiguration().getCornerHeight() / 2;
				}
				GaUtil.setLocationAndSizeOfGraphicsAlgorithm(compartmentContainerShape.getGraphicsAlgorithm(), getConfiguration()
						.getOuterIndentLeft(), overallVerticalPosition, spaceWithinOuterContainer, compartmentHeight, true);

				// Increase the overall vertical position
				overallVerticalPosition += GaUtil.calculateSizeOfGraphicsAlgorithm(ga).getHeight();
			}
		}

		// Recalculate the height of the outer compartment
		int outerContainerHeight = outerContainerShape.getGraphicsAlgorithm().getHeight();
		int newHeight = overallVerticalPosition + getConfiguration().getOuterIndentBottom();
		newHeight = Math.max(outerContainerHeight, newHeight);
		newHeight = Math.max(newHeight, getConfiguration().getMinimumHeight());
		if (outerContainerHeight != newHeight) {
			outerContainerShape.getGraphicsAlgorithm().setHeight(newHeight);
		}

		return true;
	}

	@Override
	public boolean update(IUpdateContext context) {
		boolean ret = false;

		PictogramElement pe = context.getPictogramElement();

		if (isPatternRoot(pe)) {
			if (updateRoot((ContainerShape) pe) == UPDATE_DONE) {
				ret = true;
			}
		} else {
			ContainerShape rootContainer = getPatternRoot(pe);
			if (rootContainer != null) {
				if (updateRoot(rootContainer) == UPDATE_DONE) {
					ret = true;
				}
			}
		}

		return ret;
	}

	@Override
	public IReason updateNeeded(IUpdateContext context) {

		// check only if the given pictogram element is the outer container
		// shape

		PictogramElement pe = context.getPictogramElement();
		ContainerShape outerContainerShape = null;

		if (isPatternRoot(pe)) {

			outerContainerShape = (ContainerShape) pe;

			// check header
			if (!(getHeaderMapping().getDataMapping() instanceof LabelDataMapping)) {
				List<Shape> outerContainerChildren = outerContainerShape.getChildren();
				if (outerContainerChildren != null && outerContainerChildren.size() > 0) {
					Shape shape = outerContainerChildren.get(0);
					if (shape instanceof ContainerShape) {
						ContainerShape headerShape = (ContainerShape) shape;
						List<Shape> headerChildren = headerShape.getChildren();
						if (headerChildren != null && headerChildren.size() > 0) {
							Shape nameShape = headerChildren.get(0);
							PictogramLink linkForPictogramElement = LinkUtil.getLinkForPictogramElement(nameShape);
							if (linkForPictogramElement != null) {
								GraphicsAlgorithm ga = nameShape.getGraphicsAlgorithm();
								if (!(ga instanceof Text)) {
									// Wrong object at this position -> update
									System.out.println(ga.getClass().getName());
									return Reason.createTrueReason();
								}
								String currentValue = ((Text) ga).getValue();
								String value = getText(getHeaderMapping(), linkForPictogramElement);
								// compare values
								if (currentValue == null || !currentValue.equals(value)) {
									return Reason.createTrueReason(getHeaderMapping().getDataMapping().getUpdateWarning(
											linkForPictogramElement)); // (
									// "header out of date"
									// )
									// ;
								}
							}
						}
					}
				} else {
					// Old shape (without own container shape for header) ->
					// re-add
					return Reason.createTrueReason("Old visualization"); //$NON-NLS-1$
				}
			}
		} else {
			// The given pictogram element is not the pattern root object, but
			// it could be the object
			// of one of the inner shapes --> try to find the pattern root
			// container shape for it
			outerContainerShape = getPatternRoot(pe);
			if (outerContainerShape == null) {
				outerContainerShape = (ContainerShape) pe;
			}
		}

		// <sw03072008>: if the corresponding graphics algorithm is a text, set
		// reason to false to avoid red header text
		if (pe.getGraphicsAlgorithm() instanceof Text) {
			return Reason.createFalseReason();
		}
		// </sw03072008>

		// TODO Improvement potential: check only the relevant compartment or
		// even better
		// only the relevant object in the relevant compartment
		Object mainBusinessObject = getBusinessObjectForPictogramElement(outerContainerShape);
		for (int compartmentIndex = 0; compartmentIndex < getCompartmentCount(); compartmentIndex++) {
			ContainerShape compartmentContainerShape = getContainerShapeForCompartment(outerContainerShape, compartmentIndex);
			if (compartmentContainerShape != null) {
				IStructureMappingMulti mapping = getCompartmentMapping(compartmentIndex);

				IReason ret = updateCompartmentNeeded(compartmentContainerShape, (RefObject) mainBusinessObject, mapping);
				if (ret.toBoolean()) {
					return ret;
				}
			} else {
				// Older version (header not within own container shape) ->
				// update anyway
				return Reason.createTrueReason("Remove and add may be needed"); //$NON-NLS-1$
			}
		}

		return Reason.createFalseReason();
	}

	abstract protected IStructureMappingMulti[] createCompartmentMappings();

	abstract protected IStructureMappingSingle createHeaderMapping();

	/**
	 * @param compartmentContainerShape
	 * @param linkCreationInfos
	 */
	private void createShapesInCompartment(ContainerShape compartmentContainerShape, List<ILinkCreationInfo> linkCreationInfos) {
		if (linkCreationInfos.size() != 0) {
			// <remove old expand shape>
			// createEmptyShapeInCompartment(compartmentContainerShape,
			// IPlatformImageConstants.IMG_EDIT_COLLAPSEALL);
			// </remove old expand shape>
		}
		// add text shapes
		for (ILinkCreationInfo linkCreationInfo : linkCreationInfos) {

			Style textStyle = null;
			Object[] objects = linkCreationInfo.getBusinessObjects();
			if (objects.length > 0) {
				if (objects[0] instanceof ModelElement) {
					ModelElement element = (ModelElement) objects[0];
					textStyle = getTextStyle(element);
				}
			}
			if (textStyle == null) {
				throw new InternalErrorException("No text style found"); //$NON-NLS-1$
			}

			// <innerSelection>
			Shape shape = PeUtil.createShape(compartmentContainerShape, innerSelectionIsActive);

			Rectangle rectangle = GaUtil.createRectangle(shape);
			GaUtil.ignoreAll(rectangle);
			rectangle.setStyle(StyleService.getInnerWrapperStyle(getDiagram()));

			GaUtil.createImage(rectangle, IImageConstants.IMG_EMPTY);

			Text text = GaUtil.createText(rectangle);
			GaUtil.ignoreAll(text);
			text.setStyle(textStyle);

			// create link and wire it
			link(shape, linkCreationInfo.getBusinessObjects());
			String linkProperty = linkCreationInfo.getProperty();
			if (linkProperty != null) {
				LinkUtil.setLinkProperty(shape, linkProperty);
			}

		}
	}

	protected abstract Style getTextStyle(ModelElement element);

	protected abstract Style getCompartmentStyle();

	protected abstract Style getCompartmentSeparatorStyle();

	/**
	 * @return Returns the compartmentCount.
	 */
	private int getCompartmentCount() {
		return getCompartmentMappings().length;
	}

	private IStructureMappingMulti getCompartmentMapping(int index) {
		return getCompartmentMappings()[index];
	}

	private IStructureMappingMulti[] getCompartmentMappings() {
		if (compartmentMappings == null) {
			compartmentMappings = createCompartmentMappings();
		}
		return compartmentMappings;
	}

	private IStructureMappingSingle getHeaderMapping() {
		if (headerMapping == null) {
			headerMapping = createHeaderMapping();
		}
		return headerMapping;
	}

	public ContainerShape getPatternRoot(PictogramElement pe) {
		ContainerShape ret = null;

		if (!MoinHelper.isObjectAlive(pe)) {
			return ret;
		}

		int i = 0;
		do {
			if (isPatternRoot(pe)) {
				ret = (ContainerShape) pe;
			} else if (pe instanceof Shape) {
				pe = ((Shape) pe).getContainer();
			}
			i++;
		} while (ret == null && i < 3);
		return ret;
	}

	public boolean isCompartment(PictogramElement pe) {
		boolean ret = false;
		if (pe instanceof ContainerShape) {
			ContainerShape cs = (ContainerShape) pe;
			ContainerShape container = cs.getContainer();
			ret = isPatternRoot(container);
		}
		return ret;
	}

	@SuppressWarnings("unused")
	public boolean isCompartmentEntry(PictogramElement pe) {
		boolean ret = false;
		if (pe instanceof Shape) {
			Shape s = (Shape) pe;
			ContainerShape container = s.getContainer();
			ret = isCompartment(container);
		}
		return ret;
	}

	@SuppressWarnings("unused")
	public boolean isHeader(PictogramElement pe) {
		boolean ret = false;
		if (pe instanceof Shape) {
			Shape shape = (Shape) pe;
			GraphicsAlgorithm ga = shape.getGraphicsAlgorithm();
			if (ga instanceof Text) {
				ContainerShape container = shape.getContainer();
				ret = isPatternRoot(container);
			}
		}
		return ret;
	}

	@Override
	public boolean isPatternControlled(PictogramElement pictogramElement) {
		ContainerShape patternRoot = getPatternRoot(pictogramElement);
		return patternRoot != null;
	}

	@Override
	public boolean isPatternRoot(PictogramElement pe) {
		boolean ret = false;
		if (pe instanceof ContainerShape && MoinHelper.isObjectAlive(pe)) {
			ContainerShape cs = (ContainerShape) pe;
			ContainerShape container = cs.getContainer();
			// <innerSelection> new root check
			if ((container != null) && (container instanceof Diagram)) {
				Object object = getBusinessObjectForPictogramElement(pe);
				if (object == null) {
					ret = true;
				} else {
					if (object instanceof RefObject) {
						RefObject bo = (RefObject) object;
						ret = isMainBusinessObjectApplicable(bo);
					}
				}

			}
			// GraphicsAlgorithm ga = pe.getGraphicsAlgorithm();
			// if (ga instanceof RoundedRectangle) {
			// RefObject bo = getFirstBusinessObjectForPictogramElement(pe);
			// ret = isMainBusinessObjectApplicable(bo);
			// }
		}
		return ret;
	}

	// TODO: This method has been overridden because of a bug in GF
	// The default implementation in AbstractPattern is wrong because it does
	// not cover the case businessObject = null
	// Moreover, in DefaultJamFeatureProviderWithPattern the results of
	// canUpdate and of checkPattern should be joined by && instead of ||
	@Override
	public boolean canUpdate(IUpdateContext context) {
		PictogramElement pictogramElement = context.getPictogramElement();
		Object businessObject = getBusinessObjectForPictogramElement(pictogramElement);
		if (businessObject == null) {
			return false;
		}
		return super.canUpdate(context);
	}

	private int updateCompartment(RefObject mainBusinessObject, ContainerShape compartmentContainerShape, IStructureMappingMulti mapping) {
		int ret = NO_UPDATE;
		int entryUpdated = NO_UPDATE;
		boolean allEntriesUpdated = false;

		List<ILinkCreationInfo> linkCreationInfos = mapping.getLinkCreationInfos(mainBusinessObject);
		List<Shape> currentCompartmentElements = compartmentContainerShape.getChildren();
		if (linkCreationInfos.size() != currentCompartmentElements.size()
				|| PeUtil.getProperty(compartmentContainerShape.getContainer(), MOFToolConstants.COLLAPSE_FEATURE) != null) {
			Object[] a = compartmentContainerShape.getChildren().toArray();
			for (int i = 0; i < a.length; i++) {
				PeUtil.deletePictogramElement((PictogramElement) a[i]);
			}
			if (PeUtil.getProperty(compartmentContainerShape.getContainer(), MOFToolConstants.COLLAPSE_FEATURE) == null) {
				createShapesInCompartment(compartmentContainerShape, linkCreationInfos);
			}
			ret = UPDATE_DONE;
		} else {
			// try to update shapes
			allEntriesUpdated = true;
			for (Shape shape : currentCompartmentElements) {
				entryUpdated = updateCompartmentEntry(shape, mapping);
				if (entryUpdated == FULL_UPDATE) {
					return FULL_UPDATE;
				} else if (entryUpdated == UPDATE_DONE) {
					ret = UPDATE_DONE;
				} else {
					// failed because of broken link
					allEntriesUpdated = false;
					break;
				}
			}
			// if it does not work, recreate shapes
			if (!allEntriesUpdated) {
				triggerReAdd(compartmentContainerShape, getBusinessObjectForPictogramElement(compartmentContainerShape));
				return FULL_UPDATE;
			}

		}
		// update new children if not already done
		if (!allEntriesUpdated) {
			List<Shape> childShapes = compartmentContainerShape.getChildren();
			for (Shape shape : childShapes) {
				int ret2 = updateCompartmentEntry(shape, mapping);
				if (ret2 == FULL_UPDATE) {
					return FULL_UPDATE;
				} else if (ret2 == UPDATE_DONE) {
					ret = UPDATE_DONE;
				}
			}
		}
		return ret;
	}

	private int updateCompartmentEntry(Shape shape, IStructureMappingMulti mapping) {
		int ret = NO_UPDATE;

		PictogramLink linkForPictogramElement = LinkUtil.getLinkForPictogramElement(shape);
		if (linkForPictogramElement != null) {
			List<GraphicsAlgorithm> gaList = shape.getGraphicsAlgorithm().getGraphicsAlgorithmChildren();
			Image imageGa = null;
			if (gaList.size() > 0) {
				GraphicsAlgorithm ga = gaList.get(0);
				if (ga instanceof Image) {
					imageGa = (Image) ga;
					imageGa.setId(getImage(mapping, linkForPictogramElement));
					ret = UPDATE_DONE;
				} else {
					// Wrong element found --> something wrong --> trigger
					// re-add
					ContainerShape outerContainerShape = shape.getContainer();
					triggerReAdd(outerContainerShape, getBusinessObjectForPictogramElement(outerContainerShape));
					ret = FULL_UPDATE;
				}
			}
			Text textGa = null;
			if (gaList.size() > 1) {
				GraphicsAlgorithm ga = gaList.get(1);
				if (ga instanceof Text) {
					textGa = (Text) ga;
					String text = getText(mapping, linkForPictogramElement);
					textGa.setValue(text);
					ret = UPDATE_DONE;
				} else {
					// Wrong element found --> something wrong --> trigger
					// re-add
					ContainerShape outerContainerShape = shape.getContainer();
					triggerReAdd(outerContainerShape, getBusinessObjectForPictogramElement(outerContainerShape));
					ret = FULL_UPDATE;
				}
			} else {
				// Wrong number of elements found --> something wrong -->
				// trigger re-add
				ContainerShape outerContainerShape = shape.getContainer().getContainer();
				triggerReAdd(outerContainerShape, getBusinessObjectForPictogramElement(outerContainerShape));
				ret = FULL_UPDATE;
			}
		}
		return ret;
	}

	private IReason updateCompartmentNeeded(ContainerShape compartmentContainerShape, RefObject mainBusinessObject,
			IStructureMappingMulti mapping) {
		PictogramLink linkForPictogramElement;
		List<ILinkCreationInfo> linkCreationInfos = mapping.getLinkCreationInfos(mainBusinessObject);
		List<Shape> childShapes = compartmentContainerShape.getChildren();
		int childShapeCount = childShapes.size();
		// <add new expand feature>
		// if (PeUtil.getProperty(compartmentContainerShape,
		// MOFToolConstants.COLLAPSE_FEATURE) != null) {
		if (PeUtil.getProperty(compartmentContainerShape.getContainer(), MOFToolConstants.COLLAPSE_FEATURE) != null) {
			// </add new expand feature>
			return Reason.createFalseReason();
		} else if (linkCreationInfos.size() == 0) {
			// According to business model there should be no children
			if (childShapeCount == 0) {
				// There are no -> ok
				return Reason.createFalseReason();
			} else {
				// There are children -> update
				return Reason.createTrueReason();
			}
			// <remove old expand shape>
			// } else if (linkCreationInfos.size() != childShapeCount - 1) {
		} else if (linkCreationInfos.size() != childShapeCount) {
			// </remove old expand shape>
			// structural change inside the compartment
			return Reason.createTrueReason("compartment changes"); //$NON-NLS-1$
		} else {
			// check whether compartment content has changed
			for (Shape shape : childShapes) {
				linkForPictogramElement = LinkUtil.getLinkForPictogramElement(shape);
				if (linkForPictogramElement != null) {
					Object element0 = shape.getGraphicsAlgorithm().getGraphicsAlgorithmChildren().get(0);
					Object element1 = shape.getGraphicsAlgorithm().getGraphicsAlgorithmChildren().get(1);
					if (element0 instanceof Image && element1 instanceof Text) {
						Image imageGa = (Image) element0;
						Text textGa = (Text) element1;
						String currentImage = imageGa.getId();
						String currentText = textGa.getValue();
						String image = getImage(mapping, linkForPictogramElement);
						String text = getText(mapping, linkForPictogramElement);
						// compare values
						if (currentText == null || !currentText.equals(text)) {
							return Reason.createTrueReason(mapping.getDataMapping().getUpdateWarning(linkForPictogramElement)); // (
							// "text differs"
							// );
						}
						if (!(currentImage == null && image == null)) {
							if (currentImage == null || !currentImage.equals(image)) {
								return Reason.createTrueReason(mapping.getDataMapping().getUpdateWarning(linkForPictogramElement)); // (
								// "image differs"
								// )
								// ;
							}
						}
					}
				}
			}
		}
		return Reason.createFalseReason();
	}

	private int updateRoot(ContainerShape outerContainerShape) {
		Object mainBusinessObject = getBusinessObjectForPictogramElement(outerContainerShape);
		int ret = NO_UPDATE;

		// Update header
		// Get the first container shape in the outer container shape.
		// (It is the container shape for the header area.)
		Shape shape = outerContainerShape.getChildren().get(0);
		if (shape instanceof ContainerShape) {
			ContainerShape headerContainerShape = (ContainerShape) shape;
			List<Shape> children = headerContainerShape.getChildren();

			// The first child is the shape for the name
			Shape nameShape = null;
			if (children.size() > 0) {
				nameShape = children.get(0);
			} else {
				// Something wrong --> re-add
				triggerReAdd(outerContainerShape, getBusinessObjectForPictogramElement(outerContainerShape));
				return FULL_UPDATE;
			}

			// If a second one exists it is the one of the container
			Shape packageShape = null;
			if (children.size() > 1) {
				packageShape = children.get(1);
			}

			// Retrieve and update UI texts
			PictogramLink linkForPictogramElement = LinkUtil.getLinkForPictogramElement(headerContainerShape);
			if (linkForPictogramElement != null) {
				String value = getText(getHeaderMapping(), linkForPictogramElement);
				((Text) nameShape.getGraphicsAlgorithm()).setValue(value);
				if (packageShape != null) {
					((Text) packageShape.getGraphicsAlgorithm()).setValue(getPackageName(headerMapping, linkForPictogramElement));
				}
				ret = UPDATE_DONE;
			}
		} else {
			triggerReAdd(outerContainerShape, getBusinessObjectForPictogramElement(outerContainerShape));
			return FULL_UPDATE;
		}

		// compartments
		for (int compartmentIndex = 0; compartmentIndex < getCompartmentCount(); compartmentIndex++) {
			ContainerShape compartmentContainerShape = getContainerShapeForCompartment(outerContainerShape, compartmentIndex);
			if (compartmentContainerShape != null && compartmentContainerShape.getGraphicsAlgorithm().getStyle() != null) {
				IStructureMappingMulti mapping = getCompartmentMapping(compartmentIndex);
				int ret2 = updateCompartment((RefObject) mainBusinessObject, compartmentContainerShape, mapping);

				if (ret2 == FULL_UPDATE) {
					return FULL_UPDATE;
				}
				boolean updateDone = (ret == UPDATE_DONE) | (ret2 == UPDATE_DONE);
				if (updateDone) {
					ret = UPDATE_DONE;
				}
			} else {
				// Older version (header not within own container shape) ->
				// trigger re-add
				triggerReAdd(outerContainerShape, mainBusinessObject);
				return FULL_UPDATE;
			}
		}

		// add associations
//sw15.10.08		bringUpAssociationsDialog(outerContainerShape);

		// Call this method because no layout is triggered by framework in case
		// of add attribute etc.
		layoutPictogramElement(outerContainerShape);

		return ret;
	}

	private void bringUpAssociationsDialog(ContainerShape containerShape) {
		Object businessObject = getBusinessObjectForPictogramElement(containerShape);
		if (businessObject instanceof MofClass) {
			// get references(association ends) from current domain model
			MofClass mofClass = (MofClass) businessObject;
			List<ModelElement> modelElements = mofClass.getContents();
			HashSet<AssociationEnd> associationEnds = new HashSet<AssociationEnd>();
			for (ModelElement modelElement : modelElements) {
				if (modelElement instanceof Reference) {
					Reference reference = (Reference) modelElement;
					associationEnds.add(reference.getExposedEnd());
				}
			}

			// count number of references in current pictogram model
			int oldReferences = 0;
			Collection<PictogramElement> pictogramElements = PeUtil.getPictogramElementChildren(containerShape);
			for (PictogramElement pictogramElement : pictogramElements) {
				if (pictogramElement instanceof Rectangle && getBusinessObjectForPictogramElement(pictogramElement) instanceof Reference) {
					oldReferences++;
				}
			}

			// if domain model contains new reference, find out whether a corresponding association exists on the diagram
			if (associationEnds.size() > oldReferences) {
				// all model elements of the domain model
				List<ModelElement> allModelElements = mofClass.getContainer().getContents();
				Outer: for (ModelElement modelElement : allModelElements) {
					// examine all associations in the domain model
					if (modelElement instanceof Association) {
						Association association = (Association) modelElement;
						List<ModelElement> associationContents = association.getContents();
						// check whether all domain model associations have a corresponding pictogram element
						for (ModelElement associationModelElement : associationContents) {
							if (associationModelElement instanceof AssociationEnd) {
								AssociationEnd associationEnd = (AssociationEnd) associationModelElement;
								if (associationEnds.contains(associationEnd)
										&& (PeUtil.getLinkedPictogramElements(new RefObject[] { association }, getDiagram()).length > 0)) {
									associationEnds.remove(associationEnd);
								}
								if (associationEnds.size() == 0) {
									break Outer;
								}
							}
						}
					}
				}
				// if there is an association which is not yet on the diagram, ask the user what to do
				if (associationEnds.size() > 0) {
					String className = mofClass.getName();
					Boolean answer = GfwUtil.getPlatformService().askUser(Messages.AbstractMofCompartmentPattern_0_xmsg,
							MessageFormat.format(Messages.AbstractMofCompartmentPattern_1_xmsg, new Object[] { className }));
					if (answer) {
						ICustomContext customContext = new CustomContext(new PictogramElement[] { containerShape });
						ICustomFeature[] customFeatures = getFeatureProvider().getCustomFeatures(customContext);

						for (ICustomFeature customFeature : customFeatures) {
							if (customFeature instanceof AddAllAssociationCustomFeature) {
								((AddAllAssociationCustomFeature) customFeature).execute(customContext);
								break;
							}
						}
					}
				}
			}
		}
	}

	private void triggerReAdd(ContainerShape outerContainerShape, Object mainBusinessObject) {
		// Get old layout information
		int x = outerContainerShape.getGraphicsAlgorithm().getX();
		int y = outerContainerShape.getGraphicsAlgorithm().getY();
		int width = outerContainerShape.getGraphicsAlgorithm().getWidth();
		int height = outerContainerShape.getGraphicsAlgorithm().getHeight();

		// Remove the old representation
		IRemoveContext removeContext = new RemoveContext(outerContainerShape);
		IRemoveFeature removeFeature = getFeatureProvider().getRemoveFeature(removeContext);
		removeFeature.execute(removeContext);

		// Add it anew
		AreaContext areaContext = new AreaContext();
		areaContext.setLocation(x, y);
		areaContext.setWidth(width);
		areaContext.setHeight(height);
		AddContext addContext = new AddContext(areaContext, mainBusinessObject);
		addContext.setTargetContainer(getDiagram());
		getFeatureProvider().addIfPossible(addContext);
	}

	protected IMofCompartmentPatternConfiguration getConfiguration() {
		return (IMofCompartmentPatternConfiguration) getPatternConfiguration();
	}

	@Override
	public void completeInfo(IDirectEditingInfo info, Object bo) {
		super.completeInfo(info, bo);
		PictogramElement mainPictogramElement = info.getMainPictogramElement();
		ContainerShape mainCs = (ContainerShape) mainPictogramElement;
		if (mainCs != null) {
			for (Object childShape : mainCs.getChildren()) {
				if (childShape instanceof ContainerShape) {
					ContainerShape compartmentCs = (ContainerShape) childShape;
					for (Object compartmentEntry : compartmentCs.getChildren()) {
						if (compartmentEntry instanceof Shape) {
							Shape compartmentEntryShape = (Shape) compartmentEntry;
							RefObject firstBusinessObjectForPictogramElement = (RefObject) getBusinessObjectForPictogramElement(compartmentEntryShape);
							if (bo.equals(firstBusinessObjectForPictogramElement)) {
								GraphicsAlgorithm ga = compartmentEntryShape.getGraphicsAlgorithm().getGraphicsAlgorithmChildren().get(1);
								if (ga instanceof Text) {
									// <direct editing>
									// TODO use pattern instead of model
									if (innerSelectionIsActive) {
										if (bo instanceof Attribute || bo instanceof Operation || bo instanceof StructureField) {
											info.setMainPictogramElement(compartmentEntryShape);
										}
									}
									// </direct editing>
									info.setPictogramElement(compartmentEntryShape);
									info.setGraphicsAlgorithm(ga);
									return;
								}
							}
						}
					}
				}
			}
		}
	}

	protected abstract String getPackageName(IStructureMapping structureMapping, PictogramLink linkForPictogramElement);

	private ContainerShape getContainerShapeForCompartment(ContainerShape outerContainerShape, int compartmentIndex) {
		List<Shape> children = outerContainerShape.getChildren();
		int index = (compartmentIndex + 1) * 2;
		if (children.get(index) instanceof ContainerShape) {
			return (ContainerShape) children.get(index);
		}
		return null;
	}

	// private addAllAssociations(PictogramElement pictogramElement){
	//
	// Object bo = getBusinessObjectForPictogramElement(pictogramElement);
	// if (bo instanceof MofClass) {
	// MofClass mofClass = (MofClass) bo;
	// List<Association> assocs = ClassService.getAllAssociations(mofClass);
	// if (!assocs.isEmpty()) {
	// int classCount = 1;
	// for (Iterator<Association> iter = assocs.iterator(); iter.hasNext();) {
	// Association association = iter.next();
	// AssociationEnd[] aes =
	// AssociationService.getAssociationEnds(association);
	// if (aes[0].getType().equals(mofClass)) {
	// addAssociationToDiagram(association, (MofClass) aes[1].getType(),
	// classShape, classCount);
	// } else if(aes[1].getType().equals(mofClass)){
	// addAssociationToDiagram(association, (MofClass) aes[0].getType(),
	// classShape, classCount);
	// }
	// }
	// }
	// }
	// }
}
