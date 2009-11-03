package com.sap.mi.gfw.pattern.template;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.mi.gfw.Messages;
import com.sap.mi.gfw.datatypes.IInsets;
import com.sap.mi.gfw.datatypes.impl.InsetsImpl;
import com.sap.mi.gfw.features.IDirectEditingInfo;
import com.sap.mi.gfw.features.IReason;
import com.sap.mi.gfw.features.context.IAddContext;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.ICreateContext;
import com.sap.mi.gfw.features.context.ICustomContext;
import com.sap.mi.gfw.features.context.IDirectEditingContext;
import com.sap.mi.gfw.features.context.ILayoutContext;
import com.sap.mi.gfw.features.context.IUpdateContext;
import com.sap.mi.gfw.features.context.impl.AddContext;
import com.sap.mi.gfw.features.context.impl.ResizeShapeContext;
import com.sap.mi.gfw.features.context.impl.UpdateContext;
import com.sap.mi.gfw.features.custom.ICustomFeature;
import com.sap.mi.gfw.features.impl.Reason;
import com.sap.mi.gfw.func.IDirectEditing;
import com.sap.mi.gfw.mm.pictograms.ContainerShape;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.mm.pictograms.Shape;
import com.sap.mi.gfw.pattern.AbstractPattern;
import com.sap.mi.gfw.tb.IContextButtonEntry;
import com.sap.mi.gfw.util.GaUtil;
import com.sap.mi.gfw.util.ILocationInfo;
import com.sap.mi.gfw.util.LinkUtil;
import com.sap.mi.gfw.util.LocationInfo;
import com.sap.mi.gfw.util.T;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.exception.ExecutionCancelledException;

/**
 * Allows implementing a pattern much easier.
 * 
 * @author d023588 The TemplatePattern maintains two model templates, one for the domain model and one for the pictogram model, and a set of
 *         binders. With this information the TemplatePattern can do all typical features without extra code. E.g. the create feature is
 *         implemented by copying the do-main template to the target model. The add feature copies the pictogram template. The update and
 *         layout features use Binders to transfer data between objects in one or both models. To address the objects and there attributes
 *         the binders use and XPath-like syntax.
 */
public abstract class TemplatePattern extends AbstractPattern implements IBinderTemplate, ITemplateContainer, IDirectEditing {
	private static final String BLANK = " "; //$NON-NLS-1$

	private final RefClass domainModelClass;

	private final List<DataBinder> dataBinders = new ArrayList<DataBinder>();

	private final List<LayoutBinder> layoutBinders = new ArrayList<LayoutBinder>();

	private final List<TemplatePattern> nestedPatterns = new ArrayList<TemplatePattern>();

	private boolean visualTreeTemplateBuilt = false;

	private final String relativDomainPath, relativPictogramPath;

	private final String name;

	// Used to mark the Graphics Algorithm that gets the selection rectangles.
	private String selectionGaXPath;

	/**
	 * Creates a new top-level template pattern instance.
	 * 
	 * @param modelClass
	 *            The RefClass from the Domain Metamodel that best represents this pattern. You can pass null, but then you need to
	 *            implement some methods manually, e.g. createDomainTree and isMainBusinessObjectApplicable.
	 * @param name
	 *            The name of the pattern, e.g. shown in the palette and used to find a fitting icon.
	 */
	public TemplatePattern(RefClass modelClass, String name) {
		this(modelClass, name, "", "children"); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Creates a new top-level template pattern instance, using the name from the given metamodel class.
	 * 
	 * @param modelClass
	 *            the model class
	 */
	public TemplatePattern(RefClass modelClass) {
		this(modelClass, modelClass.refMetaObject().getName());
	}

	/**
	 * Creates a new nested template pattern instance.
	 * 
	 * @param modelClass
	 *            The RefClass from the Domain Metamodel that best represents this pattern. You can pass null, but then you need to
	 *            implement some methods manually, e.g. createDomainTree and isMainBusinessObjectApplicable.
	 * @param name
	 *            The name of the pattern, e.g. shown in the palette.
	 * @param relativeDomainPath
	 *            the relative domain path
	 * @param relativePictogramPath
	 *            the relative pictogram path
	 */
	public TemplatePattern(RefClass modelClass, String name, String relativeDomainPath, String relativePictogramPath) {
		super(null); // chb @ Reiner: you should provide a configuration for
		// the colors
		this.domainModelClass = modelClass;
		this.name = name;
		this.relativDomainPath = relativeDomainPath;
		this.relativPictogramPath = relativePictogramPath;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.pattern.template.ITemplateContainer#addDataBinder(com.sap.mi.gfw.pattern.template.DataBinder)
	 */
	public void addDataBinder(DataBinder elementBinder) {
		this.dataBinders.add(elementBinder);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.pattern.template.ITemplateContainer#addLayoutBinder(com.sap.mi.gfw.pattern.template.LayoutBinder)
	 */
	public void addLayoutBinder(LayoutBinder posBinder) {
		this.layoutBinders.add(posBinder);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seecom.sap.mi.gfw.pattern.template.ITemplateContainer#addNestedTemplatePattern(com.sap.mi.gfw.pattern.template. TemplatePattern)
	 */
	public void addNestedTemplatePattern(TemplatePattern nested) {
		nested.setFeatureProvider(this.getFeatureProvider());
		nestedPatterns.add(nested);
	}

	/**
	 * Call this method from <tt>buildVisualTree</tt> to specify the GraphicsAlgorith that shows the selection rectangle.
	 * 
	 * @param mainShape
	 *            the main shape
	 * @param selectionGa
	 *            the selection ga
	 */
	protected void setSelectionGraphicsAlgorithm(Shape mainShape, GraphicsAlgorithm selectionGa) {
		this.selectionGaXPath = XPath.calculatePath(mainShape, selectionGa);
	}

	// ///////////////////////////////////////////////////////////////////////////////////////
	// Pattern feature methods
	// ///////////////////////////////////////////////////////////////////////////////////////

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.pattern.AbstractPattern#isMainBusinessObjectApplicable(com.sap.tc.moin.repository.mmi.reflect.RefObject)
	 */
	@Override
	public boolean isMainBusinessObjectApplicable(Object mainBusinessObject) {
		if (mainBusinessObject != null) {
			if (mainBusinessObject instanceof RefObject) {
				RefObject mbo = (RefObject) mainBusinessObject;

				MofClass myClass = (MofClass) mbo.refMetaObject();
				MofClass patternClass = this.domainModelClass.refMetaObject();
				return (myClass.equals(patternClass));
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.pattern.AbstractBasePattern#canAdd(com.sap.mi.gfw.features.context.IAddContext)
	 */
	@Override
	public boolean canAdd(IAddContext context) {
		RefObject ro = (RefObject) context.getNewObject();
		return isMainBusinessObjectApplicable(ro);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.pattern.AbstractPattern#getCreateName()
	 */
	@Override
	public String getCreateName() {
		return deCamelCase(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.pattern.DefaultPattern#getCreateDescription()
	 */
	@Override
	public String getCreateDescription() {
		String name = getCreateName().toLowerCase(Locale.ENGLISH);
		String desc = MessageFormat.format(Messages.TemplatePattern_0_xmsg, new Object[] { name });
		return desc;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.pattern.AbstractPattern#canCreate(com.sap.mi.gfw.features.context.ICreateContext)
	 */
	@Override
	public boolean canCreate(ICreateContext context) {
		return context.getTargetContainer() instanceof Diagram;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.pattern.DefaultPattern#getCreateImageId()
	 */
	@Override
	public String getCreateImageId() {
		return name;
	}

	/**
	 * Puts the domain object created from the domain template({@link buildDomainTree}) into the target domain model. The default
	 * implementation uses the "relativeDomainPath" that you passed in from the constructor: It follows the XPath from the given
	 * "domainContainer" and assumes that this is a collection where the new "mainDomainObject" is added. Override this method to apply the
	 * template differently. E.g. this method could add the object from the "mainDomainObject" parameter to some of the properties in the
	 * object from the "domainContainer" parameter.
	 * 
	 * @param mainDomainObject
	 *            The new domain object created by buildDomainTree
	 * @param domainContainer
	 *            The domain object that is liked with the container where the new object was added.
	 * @return Return the modified main domain object. Usually you simply return the parameter "mainDomainObject"
	 * @see buildDomainTree
	 */
	protected RefObject applyDomainTemplate(RefObject mainDomainObject, RefObject domainContainer) {
		if (this.relativDomainPath != null && !this.relativDomainPath.equals("")) { //$NON-NLS-1$
			Collection<RefObject> targetList = (Collection<RefObject>) XPath.getValue(domainContainer, relativDomainPath);
			targetList.add(mainDomainObject);
		}
		return mainDomainObject;
	}

	/**
	 * Override this method if the other overload of this method does not fit the needs. Note that you should only do changes in the domain
	 * model.
	 * 
	 * @param mainDomainObject
	 *            The new domain object created by buildDomainTree
	 * @param context
	 *            The context of the create feature.
	 * @return Return the modified main domain object. Usually you simply return the parameter "mainDomainObject"
	 */
	protected RefObject applyDomainTemplate(RefObject mainDomainObject, ICreateContext context) {
		RefObject domainContainer = getBusinessObjectAsRefObjectForLinkedPictogramElement(context.getTargetContainer());
		mainDomainObject = applyDomainTemplate(mainDomainObject, domainContainer);
		return mainDomainObject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.ICreateFeature#create(com.sap.mi.gfw.features.context.ICreateContext)
	 */
	@Override
	public Object[] create(final ICreateContext context) {

		LocalCommand command = new LocalCommand<RefObject>(getConnection(), getCreateDescription()) {

			@Override
			public RefObject internalDoExecute() {
				RefObject res = buildDomainTree();
				applyDomainTemplate(res, context);

				addGraphicalRepresentation(context, res);
				DataBinder directEdit = getImmediateDirectEditBinder();
				if (directEdit != null) {
					PictogramElement mainShape = LinkUtil.getPictogramElements(
							getFeatureProvider().getDiagramTypeProvider().getDiagramLink(), res).get(0);
					GraphicsAlgorithm ga = (GraphicsAlgorithm) XPath.getObject(mainShape, directEdit.getPictogramPath(), 0);
					if (Boolean.getBoolean("TemplatePattern.disableDirectEditing") == false && ga != null //$NON-NLS-1$
							&& GaUtil.getTransparency(ga, true) < 1) {
						IDirectEditingInfo dei = getFeatureProvider().getDirectEditingInfo();
						dei.setActive(true);
						dei.setMainPictogramElement(mainShape);
						dei.setGraphicsAlgorithm(ga);
						// dei.setPictogramElement((PictogramElement)
						// XPath.getObject(mainShape, directEdit.getPictogramPath(),
						// 1));
						dei.setPictogramElement(mainShape);
					}
				}
				return res;
			}

		};
		command.execute();

		// return newly created business object(s)
		return new Object[] { command.getResult() };

	}

	private int counter = 0;

	/**
	 * Gets the default name.
	 * 
	 * @return the default name
	 */
	protected String getDefaultName() {
		return getCreateName() + BLANK + Integer.toString(counter++);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.pattern.AbstractPattern#isPatternControlled(com.sap.mi.gfw.mm.pictograms.PictogramElement)
	 */
	@Override
	protected boolean isPatternControlled(PictogramElement pictogramElement) {
		if (pictogramElement != null) {
			if (isPatternRoot(pictogramElement))
				return true;

			if (pictogramElement instanceof Shape) {
				Shape shape = (Shape) pictogramElement;
				return isPatternControlled(shape.getContainer());
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.pattern.AbstractPattern#isPatternRoot(com.sap.mi.gfw.mm.pictograms.PictogramElement)
	 */
	@Override
	protected boolean isPatternRoot(PictogramElement pictogramElement) {
		Object bo = getBusinessObjectForPictogramElement(pictogramElement);
		return pictogramElement instanceof ContainerShape && isMainBusinessObjectApplicable(bo);
	}

	/**
	 * Returns the main shape of a pattern. This is typically a ContainerShape and has the Diagram or a ContainerShape of another pattern as
	 * parent.
	 * 
	 * @param pictogramElement
	 *            the pictogram element
	 * @return The main shape or null.
	 */
	protected Shape getMainShape(PictogramElement pictogramElement) {
		if (pictogramElement instanceof Shape) {
			Shape shape = (Shape) pictogramElement;
			Object bo = getBusinessObjectForPictogramElement(pictogramElement);
			if (bo != null && isMainBusinessObjectApplicable(bo))
				return shape;
			else {
				return getMainShape(shape.getContainer());
			}
		}
		return null;
	}

	/**
	 * Converts a string in camel case to a "multi word string".
	 * 
	 * @param value
	 * @return
	 */
	private String deCamelCase(String value) {
		StringBuffer result = new StringBuffer();
		boolean caseWasLow = false;
		boolean wasHyphen = false;
		for (int i = 0; i < value.length(); i++) {
			char c = value.charAt(i);
			if (Character.isUpperCase(c)) {
				if (caseWasLow && !wasHyphen) {
					result.append(' ');
				}
				caseWasLow = false;
			} else
				caseWasLow = true;
			if (c == '-')
				wasHyphen = true;
			else
				wasHyphen = false;
			result.append(c);
		}
		return result.toString();
	}

	/**
	 * Override this method to to apply the static pictogram content that was created by "buildVisualTree" to the target shape. The default
	 * implementation simply adds the pictogram tree to the "targetContainter".
	 * 
	 * @param mainPe
	 *            The new PictogramElement created by buildDomainTree
	 * @param targetContainter
	 *            The ContainerShape where the new pictograms should be added, e.g. the Diagram.
	 * @return Usually you return "mainPe", except you want to modify the result content created by buildVisualTree.
	 */
	protected PictogramElement applyPictogramTemplate(PictogramElement mainPe, ContainerShape targetContainter) {

		Collection targetList = (Collection) XPath.getValue(targetContainter, relativPictogramPath);
		targetList.add(mainPe);
		return mainPe;
	}

	/**
	 * Override this method if you need to apply changes on the content created by buildVisualTree based on the IAddContext "context. The
	 * default implementation changes the size of the new shape to the given size. Note that this method internally calls the other overload
	 * of "applyPictogramTemplate".
	 * 
	 * @param mainPe
	 *            The new PictogramElement created by buildDomainTree
	 * @param context
	 *            the context
	 * @return Usually you return "mainPe", except you want to modify the result content created by buildVisualTree.
	 */
	protected PictogramElement applyPictogramTemplate(PictogramElement mainPe, IAddContext context) {
		ContainerShape targetDiagram = context.getTargetContainer();
		mainPe = applyPictogramTemplate(mainPe, targetDiagram);

		IInsets insets = getSelectionInsets(mainPe);

		mainPe.getGraphicsAlgorithm().setX(context.getX() - insets.getLeft());
		mainPe.getGraphicsAlgorithm().setY(context.getY() - insets.getTop());
		if (context.getWidth() > 0 && context.getHeight() > 0) {
			ResizeShapeContext rsc = new ResizeShapeContext((Shape) mainPe);
			rsc.setHeight(context.getHeight() + insets.getTop() + insets.getBottom());
			rsc.setWidth(context.getWidth() + insets.getLeft() + insets.getRight());
			if (this.canResizeShape(rsc)) {
				// mainPe.getGraphicsAlgorithm().setWidth(rsc.getWidth());
				// mainPe.getGraphicsAlgorithm().setHeight(rsc.getHeight());
				this.resizeShape(rsc);
				// Instead we could also call resize();
			}
		}
		return mainPe;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.pattern.AbstractBasePattern#add(com.sap.mi.gfw.features.context.IAddContext)
	 */
	@Override
	public PictogramElement add(final IAddContext context) {
		final RefObject addedDomainObject = (RefObject) context.getNewObject();

		cleanBinders();
		String desc = Messages.TemplatePattern_1_xmsg + BLANK + getCreateName();
		LocalCommand<PictogramElement> command = new LocalCommand<PictogramElement>(getConnection(), desc) {

			@Override
			protected PictogramElement internalDoExecute() {
				PictogramElement mainPe = buildVisualTree();
				visualTreeTemplateBuilt = true;

				link(mainPe, addedDomainObject);

				layoutPictogramElement(mainPe);

				mainPe = applyPictogramTemplate(mainPe, context);

				updatePictogramElement(mainPe);

				return mainPe;
			}
		};
		command.execute();
		return command.getResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.pattern.AbstractPattern#updateNeeded(com.sap.mi.gfw.features.context.IUpdateContext)
	 */
	@Override
	public IReason updateNeeded(IUpdateContext context) {
		PictogramElement pe = context.getPictogramElement();
		RefObject ro = getBusinessObjectAsRefObjectForLinkedPictogramElement(pe);
		ensureBinders();
		for (DataBinder elBinder : this.dataBinders) {
			String updateWarning = elBinder.getUpdateWarning(ro, (Shape) pe);
			if (updateWarning != null)
				return new Reason(true, updateWarning);
		}
		return new Reason(false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.pattern.AbstractPattern#update(com.sap.mi.gfw.features.context.IUpdateContext)
	 */
	@Override
	public boolean update(IUpdateContext context) {
		PictogramElement pe = context.getPictogramElement();
		RefObject ro = getBusinessObjectAsRefObjectForLinkedPictogramElement(pe);
		ensureBinders();

		for (TemplatePattern nested : nestedPatterns) {
			nested.updateCollection(ro, pe);
		}

		for (DataBinder elBinder : this.dataBinders) {
			elBinder.update(ro, (Shape) pe);
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.pattern.AbstractPattern#canUpdate(com.sap.mi.gfw.features.context.IUpdateContext)
	 */
	@Override
	public boolean canUpdate(IUpdateContext context) {
		return isPatternRoot(context.getPictogramElement());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.pattern.AbstractPattern#canLayout(com.sap.mi.gfw.features.context.ILayoutContext)
	 */
	@Override
	public boolean canLayout(ILayoutContext context) {
		return isPatternRoot(context.getPictogramElement());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.pattern.AbstractPattern#layout(com.sap.mi.gfw.features.context.ILayoutContext)
	 */
	@Override
	public boolean layout(ILayoutContext context) {
		ensureBinders();
		for (LayoutBinder binder : layoutBinders) {
			binder.layout((Shape) context.getPictogramElement());
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.pattern.template.IBinderTemplate#buildDomainTree()
	 */
	public RefObject buildDomainTree() {
		String newElementName = getDefaultName();

		// create new element
		RefObject ro = domainModelClass.refCreateInstance();

		try {
			XPath.setValue(ro, "@name", newElementName); //$NON-NLS-1$
		} catch (Exception e) {
			T.racer().error("set value failed", e); //$NON-NLS-1$
		}
		// newElement.setName(newPackageName);
		// do the add
		return ro;
	}

	private void cleanBinders() {
		dataBinders.clear();
		layoutBinders.clear();
		nestedPatterns.clear();
	}

	private void ensureBinders() {
		// TODO: Replace with usage of temporary partitions
		if (!visualTreeTemplateBuilt) {
			visualTreeTemplateBuilt = true;
			Command c = new Command(getConnection()) {
				@Override
				public boolean canExecute() {
					return true;
				}

				@Override
				public void doExecute() {
					// This is a trick: We need to build the pictogram template,
					// to get all the binders filled,
					// but we don't need the MOIN content. Therefore we throw an
					// exception afterwards, which will
					// undo all MOIN changes.
					buildVisualTree();
					// Template Generation completed successfully
					throw new ExecutionCancelledException();
				}

				@Override
				public Collection<PartitionOperation> getAffectedPartitions() {
					return new ArrayList<PartitionOperation>();
				}
			};
			try {
				c.execute();
			} catch (ExecutionCancelledException ex) {
				// $JL-EXC$
				// we expect it;
			}
		}
	}

	private void updateCollection(RefObject domainObject, PictogramElement rootShape) {
		Collection sourceList = (Collection) XPath.getValue(domainObject, relativDomainPath);
		Collection targetList = (Collection) XPath.getValue(rootShape, relativPictogramPath);

		for (Iterator iter = sourceList.iterator(); iter.hasNext();) {
			RefObject ro = (RefObject) iter.next();
			List<PictogramElement> pes = LinkUtil.getPictogramElements(getFeatureProvider().getDiagramTypeProvider().getDiagramLink(), ro);
			if (pes == null || pes.size() == 0) {
				AddContext ac = new AddContext();
				ac.setNewObject(ro);
				ac.setTargetContainer((ContainerShape) rootShape);
				add(ac);
			}
		}

		for (Iterator iter = targetList.iterator(); iter.hasNext();) {
			PictogramElement pe = (PictogramElement) iter.next();
			Object ro = getBusinessObjectForPictogramElement(pe);
			if (ro == null) {
				iter.remove();
				pe.refDelete();
			}
		}

	}

	/**
	 * Gets the domain ref class.
	 * 
	 * @return the domain ref class
	 */
	public RefClass getDomainRefClass() {
		return domainModelClass;
	}

	/**
	 * Gets the domain model class.
	 * 
	 * @return the domain model class
	 */
	public MofClass getDomainModelClass() {
		return domainModelClass.refMetaObject();
	}

	// / IDirectEditing

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.IDirectEditing#canDirectEdit(com.sap.mi.gfw.features.context.IDirectEditingContext)
	 */
	public boolean canDirectEdit(IDirectEditingContext context) {
		Shape mainShape = getMainShape(context.getPictogramElement());
		Object ro = getBusinessObjectForPictogramElement(mainShape);
		return (ro != null && getDirectEditBinderFor(mainShape, context.getGraphicsAlgorithm()) != null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.IDirectEditing#checkValueValid(java.lang.String, com.sap.mi.gfw.features.context.IDirectEditingContext)
	 */
	public String checkValueValid(String value, IDirectEditingContext context) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.IDirectEditing#completeValue(java.lang.String, int, java.lang.String,
	 * com.sap.mi.gfw.features.context.IDirectEditingContext)
	 */
	public String completeValue(String value, int caretPosition, String choosenValue, IDirectEditingContext context) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.IDirectEditing#getEditingType()
	 */
	public int getEditingType() {
		return IDirectEditing.TYPE_TEXT;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.IDirectEditing#getInitialValue(com.sap.mi.gfw.features.context.IDirectEditingContext)
	 */
	public String getInitialValue(IDirectEditingContext context) {
		Shape mainShape = getMainShape(context.getPictogramElement());
		RefObject ro = getBusinessObjectAsRefObjectForLinkedPictogramElement(mainShape);
		if (ro != null) {
			DataBinder binder = getDirectEditBinderFor(mainShape, context.getGraphicsAlgorithm());
			if (binder != null) {
				Object o = XPath.getSingleValue(ro, binder.getDomainPath());
				if (o != null)
					return o.toString();
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.IDirectEditing#getPossibleValues(com.sap.mi.gfw.features.context.IDirectEditingContext)
	 */
	public String[] getPossibleValues(IDirectEditingContext context) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.IDirectEditing#getValueProposals(java.lang.String, int,
	 * com.sap.mi.gfw.features.context.IDirectEditingContext)
	 */
	public String[] getValueProposals(String value, int caretPosition, IDirectEditingContext context) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.IDirectEditing#isAutoCompletionEnabled()
	 */
	public boolean isAutoCompletionEnabled() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.IDirectEditing#isCompletionAvailable()
	 */
	public boolean isCompletionAvailable() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.IDirectEditing#setValue(java.lang.String, com.sap.mi.gfw.features.context.IDirectEditingContext)
	 */
	public void setValue(String value, IDirectEditingContext context) {
		setValue((Object) value, context);
	}

	protected void setValue(Object value, IDirectEditingContext context) {
		Shape mainShape = getMainShape(context.getPictogramElement());
		RefObject ro = getBusinessObjectAsRefObjectForLinkedPictogramElement(mainShape);
		if (ro != null) {
			DataBinder binder = getDirectEditBinderFor(mainShape, context.getGraphicsAlgorithm());
			if (binder != null) {
				XPath.setValue(ro, binder.getDomainXPathWithoutAttribute(), value);
				UpdateContext uc = new UpdateContext(mainShape);
				if (updateNeeded(uc).toBoolean())
					update(uc);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.func.IDirectEditing#stretchTextfieldToFitText()
	 */
	public boolean stretchTextfieldToFitText() {
		return false;
	}

	private DataBinder getDirectEditBinderFor(Shape mainShape, GraphicsAlgorithm ga) {
		for (DataBinder binder : this.dataBinders) {
			if (binder.canDirectEdit(mainShape, ga))
				return binder;
		}
		return null;
	}

	private DataBinder getImmediateDirectEditBinder() {
		for (DataBinder binder : dataBinders) {
			if (binder.canImmediateDirectEdit())
				return binder;
		}
		return null;
	}

	/**
	 * This method will be called indirectly from the ToolBehaviour provider finds the best Graphics algorithm for direct editing. The
	 * implementation uses the fitting data binder the is marked for direct editing or the default one (the one with immediate direct
	 * editing).
	 * 
	 * @param mainShape
	 *            The currently selected main shape
	 * @param locationInfo
	 *            the location info
	 * @return the default location info for direct editing
	 */
	public ILocationInfo getDefaultLocationInfoForDirectEditing(Shape mainShape, ILocationInfo locationInfo) {
		GraphicsAlgorithm ga = null;
		if (locationInfo != null) {
			ga = locationInfo.getGraphicsAlgorithm();
		}
		if (ga != null && getDirectEditBinderFor(mainShape, ga) != null)
			return new LocationInfo(mainShape, ga);
		else {
			DataBinder defaultBinder = getImmediateDirectEditBinder();
			if (defaultBinder != null) {
				Object o = XPath.getValue(mainShape, defaultBinder.getPictogramPathWithoutAttribute());
				if (o instanceof GraphicsAlgorithm) {
					return new LocationInfo(mainShape, (GraphicsAlgorithm) o);
				}
			}
		}
		return null;
	}

	/**
	 * Simple small helper.
	 * 
	 * @param pe
	 *            the pe
	 * @return the business object as ref object for linked pictogram element
	 */
	protected RefObject getBusinessObjectAsRefObjectForLinkedPictogramElement(PictogramElement pe) {
		Object o = getBusinessObjectForPictogramElement(pe);
		if (o instanceof RefObject) {
			return (RefObject) o;
		} else {
			return null;
		}
	}

	/**
	 * Call this method if some external conditions changed and the templates must be rebuild.
	 */
	public void refreshTemplate() {
		this.visualTreeTemplateBuilt = false;
		cleanBinders();
	}

	// //////////////////////////////////////////////////////////////////////////////////////
	// Methods that are called from corresponding Tool
	// FeatureProvider/ToolBehaviorProvider
	// //////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Allows the TemplatePattern to expose pattern-specific custom features. The FeatureProvider can selectivly delegate the request for
	 * custom features to the selected patterns.
	 * 
	 * @param context
	 *            the context
	 * @return the custom features
	 */
	public ICustomFeature[] getCustomFeatures(ICustomContext context) {
		return new ICustomFeature[0];
	}

	/**
	 * Allows the TemplatePattern to expose pattern-specific context buttons.
	 * 
	 * @param context
	 * @return
	 */
	public IContextButtonEntry[] getContextButtons(IContext context) {
		return null;
	}

	/**
	 * Gets the selection graphics algorithm.
	 * 
	 * @param mainShape
	 *            the main shape
	 * @return the selection graphics algorithm
	 */
	public GraphicsAlgorithm getSelectionGraphicsAlgorithm(PictogramElement mainShape) {
		ensureBinders();
		if (this.selectionGaXPath != null) {
			return (GraphicsAlgorithm) XPath.getValue(mainShape, this.selectionGaXPath);
		} else
			return null;
	}

	/**
	 * If there is a Selection GA, returns the offsets to the Ghosts
	 * 
	 * @param mainShape
	 * @return
	 */
	public IInsets getSelectionInsets(PictogramElement mainShape) {
		int l = 0, t = 0, r = 0, b = 0;
		GraphicsAlgorithm selectionGa = getSelectionGraphicsAlgorithm(mainShape);
		if (selectionGa != null) {
			GraphicsAlgorithm ghost = mainShape.getGraphicsAlgorithm();
			l = selectionGa.getX() - ghost.getX();
			t = selectionGa.getY() - ghost.getY();
			r = ghost.getWidth() - selectionGa.getWidth() - l;
			b = ghost.getHeight() - selectionGa.getHeight() - t;
		}
		InsetsImpl result = new InsetsImpl(l, r, t, b);
		return result;
	}

	private IInsets contextButtonInsets = null;

	public IInsets getContextButtonInsets() {
		return contextButtonInsets;
	}

	protected void setContextButtonInsets(IInsets insets) {
		this.contextButtonInsets = insets;
	}

	private abstract class LocalCommand<E> extends Command {

		private E result;

		protected LocalCommand(Connection connection, String description) {
			super(connection, description);
		}

		@Override
		public boolean canExecute() {
			return true;
		}

		@Override
		public Collection<PartitionOperation> getAffectedPartitions() {
			return new ArrayList<PartitionOperation>();
		}

		protected abstract E internalDoExecute();

		@Override
		public void doExecute() {
			result = internalDoExecute();
		}

		public E getResult() {
			return result;
		}
	}
}
