package com.sap.mi.gfw.eclipse.internal.parts.directedit;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.gef.editparts.ZoomListener;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.jface.fieldassist.ContentProposalAdapter;
import org.eclipse.jface.fieldassist.IContentProposalProvider;
import org.eclipse.jface.fieldassist.TextContentAdapter;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.CellEditorActionHandler;

import com.sap.mi.fwk.ui.editor.ModelEditorManager;
import com.sap.mi.gfw.eclipse.internal.editor.DiagramEditor;
import com.sap.mi.gfw.eclipse.internal.figures.GfwMultilineText;
import com.sap.mi.gfw.eclipse.internal.figures.GfwText;
import com.sap.mi.gfw.eclipse.internal.parts.ShapeEditPart;
import com.sap.mi.gfw.eclipse.internal.requests.GfwDirectEditRequest;
import com.sap.mi.gfw.features.IDirectEditingFeature;
import com.sap.mi.gfw.features.context.IDirectEditingContext;
import com.sap.mi.gfw.func.IDirectEditing;

public class GfwDirectEditManager extends DirectEditManager implements IDirectEditHolder {

	// private static final int MIN_DIRECT_EDITING_FONT = 12;

	private IDirectEditingContext directEditingContext;

	private IDirectEditingFeature directEditingFeature;

	private TextCellLocator locator;

	private DiagramEditor diagramEditor;

	private Font cellEditorFont = null;

	private IActionBars actionBars;

	private CellEditorActionHandler actionHandler;

	private IAction copy, cut, paste, undo, redo, find, selectAll, delete;

	private double cachedZoom = -1.0;

	private ZoomListener zoomListener = new ZoomListener() {
		public void zoomChanged(double newZoom) {
			updateScaledFont();
		}
	};

	public GfwDirectEditManager(ShapeEditPart part, Class uiElementClass, TextCellLocator cellEditorLocator) {
		super(part, uiElementClass, cellEditorLocator);
		locator = cellEditorLocator;
		diagramEditor = part.getConfigurationProvider().getDiagramEditor();
	}

	public IDirectEditingContext getDirectEditingContext() {
		return directEditingContext;
	}

	public IDirectEditingFeature getDirectEditingFeature() {
		return directEditingFeature;
	}

	public void setDirectEditingContext(IDirectEditingContext directEditingContext) {
		this.directEditingContext = directEditingContext;
	}

	public void setDirectEditingFeature(IDirectEditingFeature directEditingFeature) {
		this.directEditingFeature = directEditingFeature;
	}

	@Override
	protected CellEditor createCellEditorOn(Composite composite) {
		CellEditor ret;

		IFigure locatorFigure = locator.getFigure();

		int editingType = directEditingFeature.getEditingType();

		if (editingType == IDirectEditing.TYPE_MULTILINETEXT) {
			int horizontalAlignment = SWT.LEFT;
			if (locatorFigure instanceof GfwMultilineText) {
				int textAlignment = ((GfwMultilineText) locatorFigure).getHorizontalAligment();
				if (textAlignment == PositionConstants.CENTER) {
					horizontalAlignment = SWT.CENTER;
				} else if (textAlignment == PositionConstants.RIGHT) {
					horizontalAlignment = SWT.RIGHT;
				}
			}
			ret = new TextCellEditor(composite, SWT.MULTI | SWT.WRAP | horizontalAlignment);
		} else if (editingType == IDirectEditing.TYPE_TEXT) {
			int horizontalAlignment = SWT.LEFT;
			if (locatorFigure instanceof GfwText) {
				int textAlignment = ((GfwText) locatorFigure).getLabelAlignment();
				if (textAlignment == PositionConstants.CENTER) {
					horizontalAlignment = SWT.CENTER;
				} else if (textAlignment == PositionConstants.RIGHT) {
					horizontalAlignment = SWT.RIGHT;
				}
			}
			ret = new TextCellEditor(composite, horizontalAlignment);
		} else if (directEditingFeature.getEditingType() == IDirectEditing.TYPE_DROPDOWN) {
			String[] possibleValues = directEditingFeature.getPossibleValues(directEditingContext);
			ret = new ComboBoxCellEditor(composite, possibleValues);
			// return new ComboBoxCellEditorFixed(composite, possibleValues,
			// SWT.NONE);
		} else {
			ret = super.createCellEditorOn(composite);
		}

		ret.setValidator(new GfwCellEditorValidator(this));

		return ret;
	}

	private void disposeCellEditorFont() {
		if (cellEditorFont != null) {
			cellEditorFont.dispose();
			cellEditorFont = null;
		}
	}

	private void updateScaledFont() {
		if (getCellEditor().getControl() instanceof Text) {
			double zoom = 1.0;
			ZoomManager zoomMgr = (ZoomManager) getEditPart().getViewer().getProperty(ZoomManager.class.toString());
			if (zoomMgr != null) {
				zoom = zoomMgr.getZoom();
			}

			if (cachedZoom == zoom)
				return;
			cachedZoom = zoom;

			disposeCellEditorFont();
			Font lf = locator.getFigure().getFont();
			FontData fd = lf.getFontData()[0];
			fd.setHeight((int) (fd.getHeight() * zoom));
			cellEditorFont = new Font(lf.getDevice(), fd);

			Text text = (Text) getCellEditor().getControl();
			text.setForeground(locator.getFigure().getForegroundColor());
			text.setFont(cellEditorFont);
		}
	}

	@Override
	protected DirectEditRequest createDirectEditRequest() {
		GfwDirectEditRequest req = new GfwDirectEditRequest();
		req.setCellEditor(getCellEditor());
		req.setDirectEditingContext(this);
		return req;
	}

	@Override
	protected void initCellEditor() {
		String initialValue = directEditingFeature.getInitialValue(directEditingContext);

		if (directEditingFeature.getEditingType() == IDirectEditing.TYPE_MULTILINETEXT) {
			getCellEditor().setValue(initialValue);
		} else if (directEditingFeature.getEditingType() == IDirectEditing.TYPE_DROPDOWN) {
			ComboBoxCellEditor comboBoxCellEditor = (ComboBoxCellEditor) getCellEditor();

			setDirty(true);

			String[] possibleValues = directEditingFeature.getPossibleValues(directEditingContext);
			for (int x = 0; x < possibleValues.length; x++) {
				if (possibleValues[x].equals(initialValue))
					comboBoxCellEditor.setValue(x);
			}
		} else if (directEditingFeature.getEditingType() == IDirectEditing.TYPE_TEXT) {

			if (initialValue != null) {
				getCellEditor().setValue(initialValue);
			}

			if (directEditingFeature.isCompletionAvailable()) {

				String value = (String) getCellEditor().getValue();
				if (value == null)
					value = ""; //$NON-NLS-1$

				TextContentAdapter controlContentAdapter = new TextContentAdapter();
				IContentProposalProvider contentProposalProvider = new ContentProposalProvider(this);

				// if auto code completion disabled then open code completion on
				// CTRL+Space
				KeyStroke keyStroke = directEditingFeature.isAutoCompletionEnabled() ? null : KeyStroke.getInstance(SWT.CTRL, 32);

				ContentProposalAdapter contentProposalAdapter = new ContentProposalAdapter(getCellEditor().getControl(),
						controlContentAdapter, contentProposalProvider, keyStroke, null);
				contentProposalAdapter.setProposalAcceptanceStyle(ContentProposalAdapter.PROPOSAL_REPLACE);

				// <sw03072008> removed to avoid direct closing of cell editor after value selection from value help
				// contentProposalAdapter.addContentProposalListener(new IContentProposalListener() {
				// public void proposalAccepted(IContentProposal proposal) {
				// commit();
				// }
				// });
				// </sw03072008>
			}
		}

		// this will force the font to be set
		cachedZoom = -1.0;
		updateScaledFont();
		ZoomManager zoomMgr = (ZoomManager) getEditPart().getViewer().getProperty(ZoomManager.class.toString());
		if (zoomMgr != null) {
			zoomMgr.addZoomListener(zoomListener);
		}

		locator.relocate(getCellEditor());

		// Hook the cell editor's copy/paste actions to the actionBars so that
		// they can
		// be invoked via keyboard shortcuts.
		actionBars = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor().getEditorSite().getActionBars();
		saveCurrentActions(actionBars);
		actionHandler = new CellEditorActionHandler(actionBars);
		actionHandler.addCellEditor(getCellEditor());
		actionBars.updateActionBars();

	}

	@Override
	protected void bringDown() {
		ZoomManager zoomMgr = (ZoomManager) getEditPart().getViewer().getProperty(ZoomManager.class.toString());
		if (zoomMgr != null) {
			zoomMgr.removeZoomListener(zoomListener);
		}

		if (actionHandler != null) {
			actionHandler.dispose();
			actionHandler = null;
		}
		if (actionBars != null) {
			restoreSavedActions(actionBars);
			actionBars.updateActionBars();
			actionBars = null;
		}

		if (diagramEditor.isAlive()) {
			super.bringDown();
			disposeCellEditorFont();
			ModelEditorManager.getInstance().getActiveStatusLineManager().setErrorMessage(null);
		}
	}

	@Override
	public void show() {
		// this is a bugfix
		// celleditor not shown initially when figure has insets
		// or mouse is not directly over control
		super.show();
		locator.relocate(getCellEditor());
	}

	private void restoreSavedActions(IActionBars actionBars) {
		actionBars.setGlobalActionHandler(ActionFactory.COPY.getId(), copy);
		actionBars.setGlobalActionHandler(ActionFactory.PASTE.getId(), paste);
		actionBars.setGlobalActionHandler(ActionFactory.DELETE.getId(), delete);
		actionBars.setGlobalActionHandler(ActionFactory.SELECT_ALL.getId(), selectAll);
		actionBars.setGlobalActionHandler(ActionFactory.CUT.getId(), cut);
		actionBars.setGlobalActionHandler(ActionFactory.FIND.getId(), find);
		actionBars.setGlobalActionHandler(ActionFactory.UNDO.getId(), undo);
		actionBars.setGlobalActionHandler(ActionFactory.REDO.getId(), redo);
	}

	private void saveCurrentActions(IActionBars actionBars) {
		copy = actionBars.getGlobalActionHandler(ActionFactory.COPY.getId());
		paste = actionBars.getGlobalActionHandler(ActionFactory.PASTE.getId());
		delete = actionBars.getGlobalActionHandler(ActionFactory.DELETE.getId());
		selectAll = actionBars.getGlobalActionHandler(ActionFactory.SELECT_ALL.getId());
		cut = actionBars.getGlobalActionHandler(ActionFactory.CUT.getId());
		find = actionBars.getGlobalActionHandler(ActionFactory.FIND.getId());
		undo = actionBars.getGlobalActionHandler(ActionFactory.UNDO.getId());
		redo = actionBars.getGlobalActionHandler(ActionFactory.REDO.getId());
	}
}
