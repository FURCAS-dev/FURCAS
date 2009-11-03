package com.sap.mi.gfw.eclipse.internal.util.gef;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.ExclusionSearch;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;

import com.sap.mi.gfw.datatypes.IDimension;
import com.sap.mi.gfw.eclipse.internal.figures.GfwMultilineText;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.util.GaUtil;
import com.sap.mi.gfw.util.PeUtil;

/**
 * A collection of static helper methods regarding GEF.
 */
public class GEFUtil {

	private static final String PE = "*PE* "; //$NON-NLS-1$
	private static final boolean FULL_QUALIFIED = false;
	private static final boolean ADD_OBJECT_INFO = false;

	/**
	 * Selects the EditPart for the given model Object.
	 * 
	 * @param viewer
	 *            The viewer, which contains the EditParts.
	 * @param modelObject
	 *            The model Object, which EditPart to select.
	 */
	public static void selectEditPart(EditPartViewer viewer, Object modelObject) {
		if (modelObject == null)
			return;

		viewer.getControl().forceFocus();
		Object editpart = viewer.getEditPartRegistry().get(modelObject);
		if (editpart instanceof EditPart) {
			viewer.flush();
			viewer.select((EditPart) editpart);
		}
	}

	/**
	 * Returns the translation between the coordinate-systems of EditParts. It will translate from the coordinate-system of the source
	 * EditPart to the coordinate-system of the target EditPart. Both EditParts must be an instance of GraphicalEditPart. Otherwise it
	 * throws an Exception.
	 * 
	 * @param source
	 *            The EditPart with the source coordinate-system.
	 * @param target
	 *            The EditPart with the target coordinate-system.
	 * @return Returns the translation between the coordinate-systems of EditParts.
	 */
	public static Point calculateTranslation(EditPart source, EditPart target) {
		if (!(source instanceof GraphicalEditPart && target instanceof GraphicalEditPart))
			throw new RuntimeException("Both EditParts must be an instance of GraphicalEditPart: " + source + " " + target); //$NON-NLS-1$ //$NON-NLS-2$

		Point result = new Point(0, 0);
		if (source == target) // quick-check
			return result;

		((GraphicalEditPart) source).getContentPane().translateToAbsolute(result);
		((GraphicalEditPart) target).getContentPane().translateToRelative(result);
		return result;
	}

	/**
	 * Returns the layout constraint for the given EditPart. It returns null, if the constraint can not be determined, for example because
	 * the child has no parent or the parent has no LayoutManager.
	 * 
	 * @param editPart
	 *            The EditPart for which to return the layout constraint.
	 * @return Returns the layout constraint for the given EditPart.
	 */
	public static Object getLayoutConstraint(EditPart editPart) {
		if (editPart instanceof GraphicalEditPart) {
			IFigure childFigure = ((GraphicalEditPart) editPart).getFigure();
			if (childFigure.getParent() != null && childFigure.getParent().getLayoutManager() != null) { // should
				// always be
				// true
				// ask the parent for the current constraints
				Object constraint = childFigure.getParent().getLayoutManager().getConstraint(childFigure);
				return constraint;
			}
		}
		return null;
	}

	public static EditPart findEditPartAt(EditPartViewer viewer, Point location, boolean includeConnections) {

		EditPart editPart = findObjectAt(viewer, location, includeConnections);

		if (editPart instanceof ScalableRootEditPartAnimated) {
			List<EditPart> children = editPart.getChildren();
			if (children.size() > 0) {
				editPart = children.get(0);
			}
		}
		return editPart;
	}

	private static EditPart findObjectAt(final EditPartViewer viewer, Point pt, boolean includeConnections) {
		class ConditionalTreeSearch extends ExclusionSearch {
			ConditionalTreeSearch(Collection coll) {
				super(coll);
			}

			@Override
			public boolean accept(IFigure figure) {
				EditPart editpart = null;
				while (editpart == null && figure != null) {
					editpart = (EditPart) viewer.getVisualPartMap().get(figure);
					figure = figure.getParent();
				}
				return editpart != null;
			}
		}

		ScalableFreeformRootEditPart rootEditPart = (ScalableFreeformRootEditPart) viewer.getRootEditPart();
		IFigure figure = null;

		if (includeConnections) {
			IFigure connectionLayer = rootEditPart.getLayer(LayerConstants.CONNECTION_LAYER);
			figure = connectionLayer.findFigureAt(pt.x, pt.y, new ConditionalTreeSearch(Collections.EMPTY_LIST));
		}
		// if figure not searched or not found on connection layer try to find a figure on the primary layer
		if (figure == null) {
			IFigure primaryLayer = rootEditPart.getLayer(LayerConstants.PRIMARY_LAYER);
			figure = primaryLayer.findFigureAt(pt.x, pt.y, new ConditionalTreeSearch(Collections.EMPTY_LIST));
		}

		EditPart part = null;
		while (part == null && figure != null) {
			part = (EditPart) viewer.getVisualPartMap().get(figure);
			figure = figure.getParent();
		}
		if (part == null)
			return viewer.getContents();
		return part;
	}

	public static void dumpFigureTree(IFigure figure) {
		System.out.println("\nFigure Tree"); //$NON-NLS-1$
		dumpFigureTree(figure, 0);
	}

	public static void dumpFigureTree(IFigure figure, int indent) {
		String indentString = createIndentString(indent);

		String additional = ""; //$NON-NLS-1$
		if (figure instanceof Label) {
			Label label = (Label) figure;
			additional = " (text: " + label.getText() + ")"; //$NON-NLS-1$ //$NON-NLS-2$
		}
		if (figure instanceof GfwMultilineText) {
			GfwMultilineText mlt = (GfwMultilineText) figure;
			additional = additional + " (text: " + mlt.getText() + ")"; //$NON-NLS-1$ //$NON-NLS-2$
		}
		if (!figure.isVisible()) {
			additional = additional + " (NOT visible)"; //$NON-NLS-1$
		}
		additional = additional + " (" + figure.getBounds() + ")"; //$NON-NLS-1$ //$NON-NLS-2$
		if (ADD_OBJECT_INFO) {
			additional = additional + " (" + getObjectInfo(figure) + ")"; //$NON-NLS-1$ //$NON-NLS-2$
		}

		System.out.println(indentString + getClassName(figure, FULL_QUALIFIED) + additional);

		List ch = figure.getChildren();
		for (Object o : ch) {
			if (o instanceof IFigure) {
				dumpFigureTree((IFigure) o, indent + 2);
			}
		}
	}

	private static String getObjectInfo(Object o) {
		return o.toString();
	}

	public static void dumpEditPartTree(EditPart editPart) {
		System.out.println("\nEdit Part Tree()"); //$NON-NLS-1$
		dumpEditPartTree(editPart, 0);
	}

	public static void dumpEditPartTree(EditPart editPart, int indent) {
		String indentString = createIndentString(indent);
		Object m = editPart.getModel();
		String additional = ""; //$NON-NLS-1$
		if (m instanceof PictogramElement) {
			PictogramElement pe = (PictogramElement) m;
			GraphicsAlgorithm ga = pe.getGraphicsAlgorithm();
			if (ga != null) {
				additional = additional + " (" + getClassName(ga, FULL_QUALIFIED) + ")"; //$NON-NLS-1$ //$NON-NLS-2$
				if (ADD_OBJECT_INFO) {
					additional = additional + " (" + getObjectInfo(ga) + ")"; //$NON-NLS-1$ //$NON-NLS-2$
				}
			}
		}
		System.out.println(indentString + getClassName(editPart, FULL_QUALIFIED) + additional);

		List ch = editPart.getChildren();
		for (Object o : ch) {
			if (o instanceof EditPart) {
				EditPart epChild = (EditPart) o;
				dumpEditPartTree(epChild, indent + 2);
			}
		}
	}

	public static void dumpPictogramModelTree(PictogramElement pe) {
		System.out.println("\nPictogram Model Tree()"); //$NON-NLS-1$
		dumpPictogramModelTree(pe, 0);
	}

	public static void dumpPictogramModelTree(PictogramElement pe, int indent) {
		String indentString = createIndentString(indent);

		String additional = ""; //$NON-NLS-1$
		additional = additional + " (" + (pe.isActive() ? "active" : "inactive") + ")"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		additional = additional + " (" + (pe.isVisible() ? "visible" : "invisible") + ")"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$

		System.out.println(indentString + PE + getClassName(pe, FULL_QUALIFIED) + additional);

		dumpGATree(pe.getGraphicsAlgorithm(), indent + 2);

		Collection<PictogramElement> peChildren = PeUtil.getPictogramElementChildren(pe);
		for (PictogramElement peChild : peChildren) {
			dumpPictogramModelTree(peChild, indent + 2);
		}
	}

	public static void dumpGATree(GraphicsAlgorithm ga) {
		dumpGATree(ga, 0);
	}

	public static void dumpGATree(GraphicsAlgorithm ga, int indent) {
		String indentString = createIndentString(indent);
		if (ga == null) {
			return;
		}

		String additional = ""; //$NON-NLS-1$
		IDimension size = GaUtil.calculateSizeOfGraphicsAlgorithm(ga);
		additional = additional + " (" + ga.getX() + ", " + ga.getY() + ", " + size.getWidth() + ", " + size.getHeight() + ")"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
		if (ADD_OBJECT_INFO) {
			additional = additional + " (" + getObjectInfo(ga) + ")"; //$NON-NLS-1$ //$NON-NLS-2$
		}

		System.out.println(indentString + getClassName(ga, FULL_QUALIFIED) + additional);

		List<GraphicsAlgorithm> gaChildren = ga.getGraphicsAlgorithmChildren();
		for (GraphicsAlgorithm gaChild : gaChildren) {
			dumpGATree(gaChild, indent + 2);
		}
	}

	private static String getClassName(Object o, boolean fullQualified) {
		if (fullQualified) {
			return o.getClass().getName();
		} else {
			return o.getClass().getSimpleName();
		}
	}

	private static String createIndentString(int indent) {
		int s = 0;
		String indentString = ""; //$NON-NLS-1$
		while (s < indent) {
			indentString = indentString + " "; //$NON-NLS-1$
			s++;
		}
		return indentString;
	}
}
