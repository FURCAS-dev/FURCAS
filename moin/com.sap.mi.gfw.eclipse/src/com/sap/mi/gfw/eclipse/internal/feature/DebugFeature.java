package com.sap.mi.gfw.eclipse.internal.feature;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.GraphicalEditPart;

import com.sap.mi.gfw.eclipse.internal.editor.DiagramEditor;
import com.sap.mi.gfw.eclipse.internal.util.gef.GEFUtil;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.ICustomContext;
import com.sap.mi.gfw.features.custom.AbstractCustomFeature;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

public class DebugFeature extends AbstractCustomFeature {

	private static final String NAME_DUMP_PICTOGRAM_DATA = "Dump pictogram data"; //$NON-NLS-1$
	private static final String NAME_DUMP_FIGURE_DATA = "Dump figure data"; //$NON-NLS-1$
	private static final String NAME_DUMP_EDIT_PART_DATA = "Dump editpart tree"; //$NON-NLS-1$
	private static final String NAME_DUMP_ALL = "Dump all data"; //$NON-NLS-1$
	private static final String NAME_REFRESH = "Refresh"; //$NON-NLS-1$

	public static final int TYPE_DUMP_PICTOGRAM_DATA = 0;
	public static final int TYPE_DUMP_FIGURE_DATA = 1;
	public static final int TYPE_DUMP_EDIT_PART_DATA = 2;
	public static final int TYPE_DUMP_ALL = 3;
	public static final int TYPE_REFRESH = 4;

	private int type;

	public DebugFeature(IFeatureProvider fp, int type) {
		super(fp);
		setType(type);
	}

	public void execute(ICustomContext context) {
		PictogramElement[] pes = context.getPictogramElements();
		if (pes != null && pes.length > 0 && pes[0] != null) {
			PictogramElement pe = pes[0];
			DiagramEditor diagramEditor = (DiagramEditor) getDiagramEditor();
			GraphicalEditPart ep = diagramEditor.getEditPartForPictogramElement(pe);
			IFigure figure = diagramEditor.getFigureForPictogramElement(pe);

			switch (getType()) {
			case TYPE_DUMP_PICTOGRAM_DATA:
				GEFUtil.dumpPictogramModelTree(pe);
				break;
			case TYPE_DUMP_EDIT_PART_DATA:
				GEFUtil.dumpEditPartTree(ep);
				break;
			case TYPE_DUMP_FIGURE_DATA:
				GEFUtil.dumpFigureTree(figure);
				break;
			case TYPE_DUMP_ALL:
				GEFUtil.dumpPictogramModelTree(pe);
				GEFUtil.dumpEditPartTree(ep);
				GEFUtil.dumpFigureTree(figure);
				break;
			case TYPE_REFRESH:
				ep.refresh();
				break;
			}
		}
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		return true;
	}

	@Override
	public String getName() {
		String ret = ""; //$NON-NLS-1$
		switch (getType()) {
		case TYPE_DUMP_PICTOGRAM_DATA:
			ret = NAME_DUMP_PICTOGRAM_DATA;
			break;
		case TYPE_DUMP_FIGURE_DATA:
			ret = NAME_DUMP_FIGURE_DATA;
			break;
		case TYPE_DUMP_EDIT_PART_DATA:
			ret = NAME_DUMP_EDIT_PART_DATA;
			break;
		case TYPE_DUMP_ALL:
			ret = NAME_DUMP_ALL;
			break;
		case TYPE_REFRESH:
			ret = NAME_REFRESH;
			break;
		}
		return ret;
	}

	protected int getType() {
		return type;
	}

	protected void setType(int type) {
		this.type = type;
	}

}
