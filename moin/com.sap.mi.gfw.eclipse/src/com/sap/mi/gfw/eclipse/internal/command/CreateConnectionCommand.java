package com.sap.mi.gfw.eclipse.internal.command;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

import com.sap.mi.gfw.command.CommandExec;
import com.sap.mi.gfw.command.GenericFeatureCommandWithContext;
import com.sap.mi.gfw.eclipse.Messages;
import com.sap.mi.gfw.eclipse.internal.ImagePool;
import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProvider;
import com.sap.mi.gfw.eclipse.internal.editor.DiagramEditor;
import com.sap.mi.gfw.eclipse.internal.util.ui.PopupMenu;
import com.sap.mi.gfw.features.ICreateConnectionFeature;
import com.sap.mi.gfw.features.IFeature;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.impl.CreateConnectionContext;
import com.sap.mi.gfw.features.context.impl.CustomContext;
import com.sap.mi.gfw.features.custom.ICustomFeature;
import com.sap.mi.gfw.func.ICreateInfo;
import com.sap.mi.gfw.mm.pictograms.Anchor;
import com.sap.mi.gfw.mm.pictograms.AnchorContainer;
import com.sap.mi.gfw.mm.pictograms.Connection;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.util.PeUtil;

public class CreateConnectionCommand extends AbstractCommand {

	/** The connection instance. */
	// private Connection connection;
	private List<IFeature> features;

	// the location when connection is dropped on canvas
	private Point location;

	/** Start endpoint for the connection. */
	private final PictogramElement sourceObject;

	/** Target endpoint for the connection. */
	private PictogramElement targetObject;

	/**
	 * Instantiate a command that can create a connection between two anchors.
	 * 
	 * @param source
	 *            the source endpoint (a non-null Shape instance)
	 * @param lineStyle
	 *            the desired line style. See Connection#setLineStyle(int) for details
	 * @throws IllegalArgumentException
	 *             if source is null
	 * @see Connection#setLineStyle(int)
	 */
	public CreateConnectionCommand(IConfigurationProvider configurationProvider, PictogramElement pe, List<IFeature> features) {
		super(configurationProvider);
		setLabel(Messages.CreateConnectionCommand_0_xmsg);

		this.features = features;
		this.sourceObject = pe;
	}

	@Override
	public boolean canExecute() {

		// allow connections only from anchor to anchor
		Anchor sourceAnchor = getAnchor(sourceObject);
		Anchor targetAnchor = getAnchor(targetObject);

		// if (sourceAnchor != null) {

		CreateConnectionContext connectionContext = new CreateConnectionContext();
		connectionContext.setSourceAnchor(sourceAnchor);
		connectionContext.setTargetAnchor(targetAnchor);
		connectionContext.setSourcePictogramElement(sourceObject);
		connectionContext.setTargetPictogramElement(targetObject);

		CustomContext customContext = new CustomContext();
		customContext.setPictogramElements(new PictogramElement[] { sourceObject, targetObject });
		customContext.setX(location.x);
		customContext.setY(location.y);

		IContext context = null;

		for (IFeature feature : features) {

			if (feature instanceof ICreateConnectionFeature)
				context = connectionContext;
			else
				context = customContext;

			GenericFeatureCommandWithContext ccc = new GenericFeatureCommandWithContext(feature, context);

			if (ccc.canExecute())
				return true;

		}

		return false;
	}

	@Override
	public void execute() {
		// create a new connection between source- and target-anchor
		Anchor sourceAnchor = getAnchor(sourceObject);
		Anchor targetAnchor = getAnchor(targetObject);

		// if (sourceAnchor != null) {
		CreateConnectionContext connectionContext = new CreateConnectionContext();
		connectionContext.setSourceAnchor(sourceAnchor);
		connectionContext.setTargetAnchor(targetAnchor);
		connectionContext.setSourcePictogramElement(sourceObject);
		connectionContext.setTargetPictogramElement(targetObject);

		CustomContext customContext = new CustomContext();
		customContext.setPictogramElements(new PictogramElement[] { sourceObject, targetObject });

		DiagramEditor diagramEditor = (DiagramEditor) getFeatureProvider().getDiagramTypeProvider().getDiagramEditor();
		Point newLocation = diagramEditor.calculateRealMouseLocation(location);
		customContext.setLocation(newLocation.x, newLocation.y);

		List<GenericFeatureCommandWithContext> commands = new ArrayList<GenericFeatureCommandWithContext>();

		IContext context = null;

		for (IFeature feature : features) {

			if (feature instanceof ICreateConnectionFeature)
				context = connectionContext;
			else
				context = customContext;

			GenericFeatureCommandWithContext ccc = new GenericFeatureCommandWithContext(feature, context);

			if (ccc.canExecute())
				commands.add(ccc);

		}
		if (commands.size() == 0)
			return;

		if (commands.size() == 1) {

			CommandExec.getSingleton().executeCommand(commands.get(0), getConnection());
			return;
		}

		PopupMenu popupMenu = new PopupMenu(commands, labelProvider);

		boolean b = popupMenu.show(Display.getCurrent().getActiveShell());

		if (b) {
			GenericFeatureCommandWithContext result = (GenericFeatureCommandWithContext) popupMenu.getResult();
			CommandExec.getSingleton().executeCommand(result, getConnection());

		}

	}

	public boolean canStartConnection() {
		// allow connections only from anchor to anchor
		Anchor sourceAnchor = getAnchor(sourceObject);
		Anchor targetAnchor = null;

		// if (sourceAnchor == null){
		// return false;

		CreateConnectionContext connectionContext = new CreateConnectionContext();
		connectionContext.setSourceAnchor(sourceAnchor);
		connectionContext.setTargetAnchor(targetAnchor);
		connectionContext.setSourcePictogramElement(sourceObject);
		connectionContext.setTargetPictogramElement(null);

		for (IFeature feature : features) {

			if (feature instanceof ICreateConnectionFeature) {
				ICreateConnectionFeature ccf = (ICreateConnectionFeature) feature;
				if (ccf.canStartConnection(connectionContext)) {
					return true;
				}
			} else
				return true;
		}

		return false;
	}

	@Override
	public void redo() {
		// connection.reconnect();
	}

	/**
	 * Set the target endpoint for the connection.
	 * 
	 * @param target
	 *            that target endpoint (a non-null Shape instance)
	 * @throws IllegalArgumentException
	 *             if target is null
	 */
	public void setTarget(PictogramElement pe) {
		targetObject = pe;
	}

	@Override
	public void undo() {
		// connection.disconnect();
	}

	private Anchor getAnchor(PictogramElement pe) {
		Anchor ret = null;
		if (pe instanceof Anchor) {
			ret = (Anchor) pe;
		} else if (pe instanceof AnchorContainer) {
			ret = PeUtil.getChopboxAnchor((AnchorContainer) pe);
		}
		return ret;
	}

	public PictogramElement getSourceObject() {
		return sourceObject;
	}

	/**
	 * sets the location for the command when connection is dropped into nowhere
	 * 
	 * @param location
	 */
	public void setLocation(Point location) {
		this.location = location;
	}

	/**
	 * label provider for popup menu
	 */
	private static ILabelProvider labelProvider = new ILabelProvider() {

		public void removeListener(ILabelProviderListener listener) {
		}

		public boolean isLabelProperty(Object element, String property) {
			return false;
		}

		public void dispose() {

		}

		public void addListener(ILabelProviderListener listener) {

		}

		public String getText(Object element) {

			GenericFeatureCommandWithContext command = (GenericFeatureCommandWithContext) element;

			IFeature feature = command.getFeature();

			if (feature instanceof ICreateInfo) // e.g. ICreateConnectionFeature
				return ((ICreateInfo) feature).getCreateName();
			if (feature instanceof ICustomFeature)
				return ((ICustomFeature) feature).getName();

			return null;
		}

		public Image getImage(Object element) {
			GenericFeatureCommandWithContext command = (GenericFeatureCommandWithContext) element;

			IFeature feature = command.getFeature();
			if (feature instanceof ICreateInfo) // e.g. ICreateConnectionFeature
				return ImagePool.getImageForId(((ICreateInfo) feature).getCreateImageId());
			if (feature instanceof ICustomFeature)
				return ImagePool.getImageForId(((ICustomFeature) feature).getImageId());

			return null;
		}

	};

	public IFeature[] getFeatures() {
		return features.toArray(new IFeature[0]);
	}
}