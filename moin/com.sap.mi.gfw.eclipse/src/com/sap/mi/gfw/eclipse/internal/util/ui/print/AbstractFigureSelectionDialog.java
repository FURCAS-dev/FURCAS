package com.sap.mi.gfw.eclipse.internal.util.ui.print;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.SWTGraphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.editparts.LayerManager;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;

import com.sap.mi.gfw.eclipse.Messages;
import com.sap.mi.gfw.eclipse.internal.editor.GFWFigureCanvas;
import com.sap.mi.gfw.eclipse.internal.fixed.FixedScaledGraphics;
import com.sap.mi.gfw.eclipse.internal.util.ui.DefaultPreferences;

/**
 * This is an abstract dialog, where the user can choose between the whole figure or a selection.
 */
public class AbstractFigureSelectionDialog extends Dialog implements SelectionListener {

	// initial values
	protected GraphicalViewer _graphicalViewer;

	/**
	 * <code>_allFigure</code> represents a figure that contains all printable layers
	 */
	protected IFigure _allFigure;

	/**
	 * <code>_selectionFigure</code> represents a figure which corresponds to the selected EditPart
	 */
	protected IFigure _selectionFigure;

	protected boolean _insideInternalModify = false;

	private Button _allFigureButton;

	private Button _selectionFigureButton;

	private boolean isAllFigureSelected = true;

	// selected values

	/**
	 * <code>_figure</code> corresponds either to the value of <code>_allFigure</code> or to the value of <code>_selectionFigure</code>
	 */
	protected IFigure _figure;

	protected Image _imageSelection;

	/**
	 * Image corresponding to the whole diagram (unscaled) or <b>null</b> if the diagram is too large
	 */
	protected Image _imageAll;

	/**
	 * Image corresponding to either one selected part of the diagram or the whole diagram (non-scaled version) - can be <b>null</b> if the
	 * diagram is too large and nothing is selected
	 */
	protected Image _image;

	/**
	 * Image corresponding to either one selected part of the diagram or the whole diagram (scaled version)
	 */
	private Image _scaledImage;

	protected DefaultPreferences _preferences;

	/**
	 * Creates a new AbstractPrintFigureDialog.
	 * 
	 * @param shell
	 *            The Shell of this dialog.
	 * @param graphicalViewer
	 *            The GraphicalViewer, which to print.
	 */
	public AbstractFigureSelectionDialog(Shell shell, GraphicalViewer graphicalViewer) {
		super(shell);
		_graphicalViewer = graphicalViewer;
		_preferences = new DefaultPrintPreferences();
		determinePossibleFigures();
	}

	@Override
	protected void configureShell(Shell newShell) {
		newShell.setText(Messages.AbstractFigureSelectionDialog_0_xtxt);
		super.configureShell(newShell);
	}

	protected Group createChooseFigureGroup(Composite composite) {
		Group figureGroup = new Group(composite, SWT.NONE);
		figureGroup.setText(Messages.AbstractFigureSelectionDialog_1_xtxt);
		GridData data = new GridData(GridData.GRAB_HORIZONTAL | GridData.FILL_HORIZONTAL);
		data.horizontalSpan = 1;
		figureGroup.setLayoutData(data);
		GridLayout layout = new GridLayout(1, false);
		figureGroup.setLayout(layout);

		_allFigureButton = new Button(figureGroup, SWT.RADIO);
		_allFigureButton.setText(Messages.AbstractFigureSelectionDialog_2_xbut);
		_allFigureButton.setSelection(_figure.equals(_allFigure));
		data = new GridData(GridData.GRAB_HORIZONTAL | GridData.FILL_HORIZONTAL);
		_allFigureButton.setLayoutData(data);
		_allFigureButton.addSelectionListener(this);

		_selectionFigureButton = new Button(figureGroup, SWT.RADIO);
		_selectionFigureButton.setText(Messages.AbstractFigureSelectionDialog_3_xbut);
		_selectionFigureButton.setSelection(_figure.equals(_selectionFigure));
		_selectionFigureButton.setEnabled(_selectionFigure != null);
		data = new GridData(GridData.GRAB_HORIZONTAL | GridData.FILL_HORIZONTAL);
		_selectionFigureButton.setLayoutData(data);
		_selectionFigureButton.addSelectionListener(this);

		isAllFigureSelected = _allFigureButton.getSelection();

		return figureGroup;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	public void widgetDefaultSelected(SelectionEvent e) {
		widgetSelected(e);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	public void widgetSelected(SelectionEvent e) {
		if (_insideInternalModify) // avoid endless-loops
			return;

		if (e.getSource() == _allFigureButton || e.getSource() == _selectionFigureButton) {
			_figure = _allFigureButton.getSelection() ? _allFigure : _selectionFigure;
			// _image = _allFigureButton.getSelection() ? _imageAll :
			// _imageSelection;
			isAllFigureSelected = _allFigureButton.getSelection();
			updateControls();
		}
	}

	public void updateControls() {
		// not used
	}

	// ================ access ==============================

	public final IFigure getFigure() {
		return _figure;
	}

	public final GraphicalViewer getGraphicalViewer() {
		return _graphicalViewer;
	}

	// ========================= private helper methods =======================

	// private void determinePossibleFigures() {
	//
	// GC gc;
	// ScaledGraphics graphics;
	// // determine _allFigure
	//
	// if (getGraphicalViewer() instanceof GFWScrollingGraphicalViewer) {
	// GFWScrollingGraphicalViewer gfwViewer = (GFWScrollingGraphicalViewer)
	// getGraphicalViewer();
	// if (gfwViewer.getControl() instanceof GFWFigureCanvas) {
	// GFWFigureCanvas gfwFigureCanvas = (GFWFigureCanvas)
	// gfwViewer.getControl();
	// gfwFigureCanvas.regainSpace();
	// }
	// }
	//
	// EditPart editPart = getGraphicalViewer().getRootEditPart();
	// if (editPart instanceof LayerManager) {
	// _allFigure = ((LayerManager)
	// editPart).getLayer(LayerConstants.PRINTABLE_LAYERS);
	// _imageAll = new Image(null, _allFigure.getBounds().x +
	// _allFigure.getBounds().width,
	// _allFigure.getBounds().y + _allFigure.getBounds().height);
	// gc = new GC(_imageAll);
	// graphics = new FixedScaledGraphics(new SWTGraphics(gc));
	// _allFigure.paint(graphics);
	// } else if (editPart instanceof GraphicalEditPart) {
	// _allFigure = ((GraphicalEditPart) editPart).getFigure();
	// _imageAll = new Image(null, _selectionFigure.getBounds().x +
	// _selectionFigure.getBounds().width,
	// _selectionFigure.getBounds().y + _selectionFigure.getBounds().height);
	// gc = new GC(_imageAll);
	// graphics = new FixedScaledGraphics(new SWTGraphics(gc));
	// _allFigure.paint(graphics);
	// } else
	// throw new RuntimeException("Implementation-error: Can not draw the
	// EditPart. Wrong class: " + editPart);
	//
	// // determine _selectionFigure
	// List editParts = getGraphicalViewer().getSelectedEditParts();
	// if (editParts.size() == 1) {
	// editPart = (EditPart) editParts.get(0);
	// if (editPart instanceof LayerManager) {
	// _selectionFigure = ((LayerManager)
	// editPart).getLayer(LayerConstants.PRINTABLE_LAYERS);
	// _imageSelection = new Image(null, _selectionFigure.getBounds().x +
	// _selectionFigure.getBounds().width,
	// _selectionFigure.getBounds().y + _selectionFigure.getBounds().height);
	// gc = new GC(_imageSelection);
	// graphics = new FixedScaledGraphics(new SWTGraphics(gc));
	// _selectionFigure.paint(graphics);
	// }
	//
	// else if (editPart instanceof GraphicalEditPart) {
	// _selectionFigure = ((GraphicalEditPart) editPart).getFigure();
	// Image _imageSelectionPrepare = new Image(null,
	// _selectionFigure.getBounds().x
	// + _selectionFigure.getBounds().width, _selectionFigure.getBounds().y
	// + _selectionFigure.getBounds().height);
	// gc = new GC(_imageSelectionPrepare);
	// graphics = new FixedScaledGraphics(new SWTGraphics(gc));
	// _selectionFigure.paint(graphics);
	//
	// // search for connections where source and target are contained in the
	// selected figure
	// // call to getChildren() is not intended by framework, but does not seem
	// to cause problems
	// List children = editPart.getChildren();
	// Iterator it = children.iterator();
	//
	// while (it.hasNext()) {
	// GraphicalEditPart current = (GraphicalEditPart) it.next();
	// List currentSourceConnections = current.getSourceConnections();
	// Iterator it2 = children.iterator();
	// while (it2.hasNext()) {
	// GraphicalEditPart current2 = (GraphicalEditPart) it2.next();
	// List currentTargetConnections2 = current2.getTargetConnections();
	// // check if matching connections
	// Iterator currentSources = currentSourceConnections.iterator();
	// while (currentSources.hasNext()) {
	// Object currentConnection = currentSources.next();
	// if (currentTargetConnections2.contains(currentConnection)) {
	// // add connection to figure
	// IFigure connection = ((AbstractConnectionEditPart)
	// currentConnection).getFigure();
	// // graphics.translate(_selectionFigure.getInsets().left,
	// // _selectionFigure.getInsets().top);
	// Rectangle connectionBounds = new Rectangle(connection.getBounds().x,
	// connection
	// .getBounds().y, connection.getBounds().width,
	// connection.getBounds().height);
	// int targetX = connectionBounds.x;
	// int targetY = connectionBounds.y;
	// _selectionFigure.translateToAbsolute(connectionBounds);
	// graphics.translate(targetX - connectionBounds.x, targetY -
	// connectionBounds.y);
	// connection.paint(graphics);
	// graphics.translate(-(targetX - connectionBounds.x), -(targetY -
	// connectionBounds.y));
	// }
	// }
	// }
	// }
	// _imageSelection = new Image(null, _selectionFigure.getBounds().width,
	// _selectionFigure.getBounds().height);
	// gc = new GC(_imageSelection);
	// gc.drawImage(_imageSelectionPrepare, _selectionFigure.getBounds().x,
	// _selectionFigure.getBounds().y,
	// _selectionFigure.getBounds().width, _selectionFigure.getBounds().height,
	// 0, 0, _imageSelection
	// .getBounds().width, _imageSelection.getBounds().height);
	//
	// } else
	// throw new RuntimeException("Implementation-error: Can not draw the
	// EditPart. Wrong class: " + editPart);
	// }
	//
	// // check if _selectionFigure equals contents
	// editPart = getGraphicalViewer().getContents();
	// if (editPart instanceof GraphicalEditPart) {
	// IFigure contentFigure = ((GraphicalEditPart) editPart).getFigure();
	// if (contentFigure.equals(_selectionFigure))
	// _selectionFigure = null; // better print the _allFigure (considering the
	// layers)
	// }
	//
	// // set default
	// _image = (_imageSelection != null) ? _imageSelection : _imageAll;
	// _figure = (_selectionFigure != null) ? _selectionFigure : _allFigure;
	//
	// gc.dispose();
	// graphics.dispose();
	// }

	// determine _allFigure, _selectionFigure and _figure
	private void determinePossibleFigures() {
		_allFigure = null;
		_selectionFigure = null;
		_figure = null;

		// shrink canvas to minimal necessary dimensions
		GraphicalViewer viewer = getGraphicalViewer();
		org.eclipse.swt.widgets.Control control = viewer.getControl();
		if (control instanceof GFWFigureCanvas) {
			GFWFigureCanvas canvas = (GFWFigureCanvas) control;
			canvas.regainSpace();
		}

		EditPart rootEditPart = viewer.getRootEditPart();
		if (!(rootEditPart instanceof GraphicalEditPart))
			return;

		// determine _allFigure
		GraphicalEditPart graphicalRootEditPart = (GraphicalEditPart) rootEditPart;
		IFigure rootFigure = ((LayerManager) graphicalRootEditPart).getLayer(LayerConstants.PRINTABLE_LAYERS);
		if (rootFigure == null)
			return;

		_allFigure = rootFigure;

		// determine _selectionFigure
		for (EditPart selectedEditPart : (List<EditPart>) viewer.getSelectedEditParts()) {
			if (!(selectedEditPart instanceof GraphicalEditPart) || (selectedEditPart == getGraphicalViewer().getContents())) {
				_selectionFigure = null;
				break;
			}
			_selectionFigure = ((GraphicalEditPart) selectedEditPart).getFigure();
			break;
		}

		// determine _figure
		_figure = (_selectionFigure == null) ? _allFigure : _selectionFigure;
	}

	// /**
	// * Stores the scaled image for the printer in {@link _scaledImage}. This
	// is done since scaling via the graphics
	// * object gives a high quality image. The appropriate scaling where x- and
	// y-scale differ can be done somewhere else
	// * via <code>drawImage</code>. The image should be disposed via
	// <code>cleanUp()</code>
	// *
	// * @param scaleFactor scale factor used for scaling if the resulting image
	// will not exceed
	// * <code>upperBoundPixels</code> square resolution (a very heigh
	// resolution can cause memory problems (out of
	// * Memory error...)
	// * @see AbstractFigureSelectionDialog#_allFigure
	// * @see AbstractFigureSelectionDialog#_selectionFigure
	// */
	// public void setScaledImage(double scaleFactor) {
	// GC gc = null;
	// ScaledGraphics graphics = null;
	// // upperBoundPixels forces the image which is used for printing to be of
	// maximal
	// // upperBoundPixels x upperBoundPixels size, if this value is to large it
	// may cause
	// // memory problems
	// double upperBoundPixels = 3000.0d;
	//
	// if (isAllFigureSelected()) {
	// // if the scale factor is too high, the operating system will not be able
	// to provide a handle,
	// // because the Image would require too much space. "no more
	// Handles"-Exception or "out of Memory" Error
	// // will be thrown
	// if (scaleFactor * _allFigure.getBounds().width > upperBoundPixels
	// || scaleFactor * _allFigure.getBounds().height > upperBoundPixels) {
	// scaleFactor = Math.min(upperBoundPixels / _allFigure.getBounds().width,
	// upperBoundPixels
	// / _allFigure.getBounds().height);
	// }
	// EditPart editPart = getGraphicalViewer().getRootEditPart();
	// if (editPart instanceof LayerManager) {
	//
	// _scaledImage = new Image(null, (int) (_allFigure.getBounds().width *
	// scaleFactor),
	// (int) (scaleFactor * _allFigure.getBounds().height));
	//
	// gc = new GC(_scaledImage);
	// graphics = new FixedScaledGraphics(new SWTGraphics(gc));
	// graphics.scale(scaleFactor);
	// _allFigure.paint(graphics);
	// } else if (editPart instanceof GraphicalEditPart) {
	//
	// _scaledImage = new Image(null, (int) (_allFigure.getBounds().width *
	// scaleFactor),
	// (int) (scaleFactor * _allFigure.getBounds().height));
	//
	// gc = new GC(_scaledImage);
	// graphics = new FixedScaledGraphics(new SWTGraphics(gc));
	// graphics.scale(scaleFactor);
	// _allFigure.paint(graphics);
	// } else
	// throw new RuntimeException("Implementation-error: Can not draw the
	// EditPart. Wrong class: " + editPart);
	// } else {
	// if (scaleFactor * _selectionFigure.getBounds().width > upperBoundPixels
	// || scaleFactor * _selectionFigure.getBounds().height > upperBoundPixels)
	// {
	// scaleFactor = Math.min(upperBoundPixels /
	// _selectionFigure.getBounds().width, upperBoundPixels
	// / _selectionFigure.getBounds().height);
	// }
	// List editParts = getGraphicalViewer().getSelectedEditParts();
	// if (editParts.size() == 1) {
	// EditPart editPart = (EditPart) editParts.get(0);
	// if (editPart instanceof LayerManager) {
	//
	// _scaledImage = new Image(null, (int) (_selectionFigure.getBounds().width
	// * scaleFactor),
	// (int) (scaleFactor * _selectionFigure.getBounds().height));
	//
	// gc = new GC(_scaledImage);
	// graphics = new FixedScaledGraphics(new SWTGraphics(gc));
	// graphics.scale(scaleFactor);
	// graphics.translate(-_selectionFigure.getBounds().x,
	// -_selectionFigure.getBounds().y);
	// _selectionFigure.paint(graphics);
	// } else if (editPart instanceof GraphicalEditPart) {
	//
	// _scaledImage = new Image(null, (int) (_selectionFigure.getBounds().width
	// * scaleFactor),
	// (int) (scaleFactor * _selectionFigure.getBounds().height));
	//
	// gc = new GC(_scaledImage);
	// graphics = new FixedScaledGraphics(new SWTGraphics(gc));
	// graphics.scale(scaleFactor);
	// graphics.translate(-_selectionFigure.getBounds().x,
	// -_selectionFigure.getBounds().y);
	// _selectionFigure.paint(graphics);
	//
	// // search for connections where source and target are contained in the
	// selected figure
	// // call to getChildren() is not intended by framework, but does not seem
	// to cause problems
	// List children = editPart.getChildren();
	// Iterator it = children.iterator();
	//
	// while (it.hasNext()) {
	// GraphicalEditPart current = (GraphicalEditPart) it.next();
	// List currentSourceConnections = current.getSourceConnections();
	// Iterator it2 = children.iterator();
	// while (it2.hasNext()) {
	// GraphicalEditPart current2 = (GraphicalEditPart) it2.next();
	// List currentTargetConnections2 = current2.getTargetConnections();
	// // check if matching connections
	// Iterator currentSources = currentSourceConnections.iterator();
	// while (currentSources.hasNext()) {
	// Object currentConnection = currentSources.next();
	// if (currentTargetConnections2.contains(currentConnection)) {
	// // add connection to figure
	// IFigure connection = ((AbstractConnectionEditPart)
	// currentConnection).getFigure();
	// // graphics.translate(_selectionFigure.getInsets().left,
	// // _selectionFigure.getInsets().top);
	// Rectangle connectionBounds = new Rectangle(connection.getBounds().x,
	// connection
	// .getBounds().y, connection.getBounds().width,
	// connection.getBounds().height);
	// int targetX = connectionBounds.x;
	// int targetY = connectionBounds.y;
	// _selectionFigure.translateToAbsolute(connectionBounds);
	// graphics.translate(targetX - connectionBounds.x, targetY -
	// connectionBounds.y);
	// connection.paint(graphics);
	// graphics
	// .translate(-(targetX - connectionBounds.x), -(targetY -
	// connectionBounds.y));
	// }
	// }
	// }
	// }
	// } else
	// throw new RuntimeException("Implementation-error: Can not draw the
	// EditPart. Wrong class: "
	// + editPart);
	// }
	// }
	// if (gc != null)
	// gc.dispose();
	// if (graphics != null)
	// graphics.dispose();
	// }

	public void setScaledImage(double scaleFactor) {
		cleanUp();
		_imageAll = null;
		_scaledImage = null;
		_image = null;

		double upperBoundPixels = 3000.0d;

		// create _imageAll based on _allFigure
		{
			int width = _allFigure.getBounds().width;
			int height = _allFigure.getBounds().height;

			// check whether the dimensions of the image to be created would
			// be small enough to prevent runtime exceptions
			if (width <= upperBoundPixels && height <= upperBoundPixels) {
				_imageAll = new Image(Display.getDefault(), width, height);
				GC gc = new GC(_imageAll);
				SWTGraphics graphics = new SWTGraphics(gc);

				/* move all figures into the positive region */
				EditPart contents = getGraphicalViewer().getContents();
				if (contents instanceof GraphicalEditPart) {
					IFigure contentsFigure = ((GraphicalEditPart) contents).getFigure();
					Rectangle contentBounds = contentsFigure.getBounds();
					graphics.translate(-contentBounds.x, -contentBounds.y);
				}

				_allFigure.paint(graphics);

				if (gc != null)
					gc.dispose();
				if (graphics != null)
					graphics.dispose();
			} else {
				_imageAll = null;
			}
		}

		// create _scaledImage based either on _allFigure or on _selectionFigure
		// use scaleFactor to determine scaled version
		{
			GC gc = null;
			FixedScaledGraphics graphics = null;

			if (isAllFigureSelected()) {
				// if the scale factor is too high, the operating system will
				// not be able to provide a handle,
				// because the Image would require too much space. "no more
				// Handles"-Exception or "out of Memory" Error
				// will be thrown
				if (scaleFactor * _allFigure.getBounds().width > upperBoundPixels
						|| scaleFactor * _allFigure.getBounds().height > upperBoundPixels) {
					scaleFactor = Math.min(upperBoundPixels / _allFigure.getBounds().width, upperBoundPixels
							/ _allFigure.getBounds().height);
				}

				_scaledImage = new Image(Display.getDefault(), (int) (_allFigure.getBounds().width * scaleFactor),
						(int) (scaleFactor * _allFigure.getBounds().height));
				gc = new GC(_scaledImage);
				graphics = new FixedScaledGraphics(new SWTGraphics(gc));

				graphics.scale(scaleFactor);

				/* move all figures into the positive region */
				EditPart contents = getGraphicalViewer().getContents();
				if (contents instanceof GraphicalEditPart) {
					IFigure contentsFigure = ((GraphicalEditPart) contents).getFigure();
					Rectangle contentBounds = contentsFigure.getBounds();
					graphics.translate(-contentBounds.x, -contentBounds.y);
				}

				_allFigure.paint(graphics);
			} else {
				if (scaleFactor * _selectionFigure.getBounds().width > upperBoundPixels
						|| scaleFactor * _selectionFigure.getBounds().height > upperBoundPixels) {
					scaleFactor = Math.min(upperBoundPixels / _selectionFigure.getBounds().width, upperBoundPixels
							/ _selectionFigure.getBounds().height);
				}

				_scaledImage = new Image(null, (int) (_selectionFigure.getBounds().width * scaleFactor),
						(int) (scaleFactor * _selectionFigure.getBounds().height));
				gc = new GC(_scaledImage);
				graphics = new FixedScaledGraphics(new SWTGraphics(gc));

				graphics.scale(scaleFactor);
				graphics.translate(-_selectionFigure.getBounds().x, -_selectionFigure.getBounds().y);

				_selectionFigure.paint(graphics);
			}

			if (gc != null)
				gc.dispose();
			if (graphics != null)
				graphics.dispose();
		}

		{
			if (_selectionFigure != null) {
				_image = new Image(Display.getDefault(), _selectionFigure.getBounds().width, _selectionFigure.getBounds().height);
				GC gc = new GC(_image);
				SWTGraphics graphics = new SWTGraphics(gc);

				graphics.translate(-_selectionFigure.getBounds().x, -_selectionFigure.getBounds().y);

				_selectionFigure.paint(graphics);

				if (gc != null)
					gc.dispose();
				if (graphics != null)
					graphics.dispose();
			} else {
				if (_imageAll != null) {
					_image = _imageAll;
				} else {
					_image = new Image(Display.getDefault(), 1, 1);
				}
			}
		}
	}

	public Image getImage() {
		return _image;
	}

	public Image getScaledImage() {
		return _scaledImage;
	}

	public boolean isAllFigureSelected() {
		return isAllFigureSelected;
	}

	public void cleanUp() {
		if (_scaledImage != null)
			_scaledImage.dispose();
		if (_image != null)
			_image.dispose();
		if (_imageAll != null)
			_imageAll.dispose();
	}
}