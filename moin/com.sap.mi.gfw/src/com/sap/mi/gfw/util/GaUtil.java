package com.sap.mi.gfw.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.mi.gfw.GfwTestConfiguration;
import com.sap.mi.gfw.datatypes.IDimension;
import com.sap.mi.gfw.datatypes.impl.DimensionImpl;
import com.sap.mi.gfw.internal.GaUtilInternal;
import com.sap.mi.gfw.mm.datatypes.Color;
import com.sap.mi.gfw.mm.datatypes.Point;
import com.sap.mi.gfw.mm.pictograms.AbstractStyle;
import com.sap.mi.gfw.mm.pictograms.AbstractText;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.mi.gfw.mm.pictograms.Ellipse;
import com.sap.mi.gfw.mm.pictograms.Font;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithmContainer;
import com.sap.mi.gfw.mm.pictograms.Image;
import com.sap.mi.gfw.mm.pictograms.LineStyle;
import com.sap.mi.gfw.mm.pictograms.LineStyleEnum;
import com.sap.mi.gfw.mm.pictograms.MultiText;
import com.sap.mi.gfw.mm.pictograms.Orientation;
import com.sap.mi.gfw.mm.pictograms.OrientationEnum;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.mm.pictograms.PlatformGraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.Polygon;
import com.sap.mi.gfw.mm.pictograms.Polyline;
import com.sap.mi.gfw.mm.pictograms.Rectangle;
import com.sap.mi.gfw.mm.pictograms.RenderingStyle;
import com.sap.mi.gfw.mm.pictograms.RoundedRectangle;
import com.sap.mi.gfw.mm.pictograms.Style;
import com.sap.mi.gfw.mm.pictograms.StyleContainer;
import com.sap.mi.gfw.mm.pictograms.Text;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.mmi.descriptors.StructureFieldContainer;

/**
 * The Class GaUtil.
 */
public class GaUtil {

	private static final String DEFAULT_FONT = "Arial"; //$NON-NLS-1$

	/**
	 * Calculates the size of the given graphics algorithm. If the graphics algorithm is a polyline or polygon then the size will be
	 * calculated. Otherwise the size of the graphics algorithm is simply returned.
	 * 
	 * @param ga
	 *            GraphicsAlgorithm
	 * @return the i dimension
	 */
	public static IDimension calculateSizeOfGraphicsAlgorithm(GraphicsAlgorithm ga) {
		IDimension ret = null;
		if (ga instanceof Polyline) {
			Polyline pl = (Polyline) ga;
			ret = calculatePolylineMinSize(pl);
		} else {
			ret = new DimensionImpl(ga.getWidth(), ga.getHeight());
		}
		return ret;
	}

	/**
	 * Calculates the size of the given graphics algorithm. If the graphics algorithm is a polyline or polygon then the size will be
	 * calculated. Otherwise the size of the graphics algorithm is simply returned.
	 * 
	 * @param ga
	 *            GraphicsAlgorithm
	 * @param considerLineWidth
	 *            the consider line width
	 * @return the i dimension
	 */
	public static IDimension calculateSizeOfGraphicsAlgorithm(GraphicsAlgorithm ga, boolean considerLineWidth) {
		IDimension ret = calculateSizeOfGraphicsAlgorithm(ga);
		if (considerLineWidth) {
			int lineWidth = GaUtilInternal.getLineWidth(ga, true);
			if (lineWidth > 1) {
				int extent = lineWidth - 1;
				ret.setWidth(ret.getWidth() + extent);
				ret.setHeight(ret.getHeight() + extent);
			}
		}
		return ret;
	}

	/**
	 * Creates an ellipse graphics algorithm.
	 * <p>
	 * The following values are set by default:
	 * <p>
	 * graphicsAlgorithm.setFilled(true); <br>
	 * graphicsAlgorithm.setLineStyle(LineStyleEnum.SOLID); <br>
	 * graphicsAlgorithm.setLineVisible(true); <br>
	 * graphicsAlgorithm.setLineWidth(1);<br>
	 * graphicsAlgorithm.setTransparency(0);<br>
	 * 
	 * @param gaContainer
	 *            the ga container
	 * @return the new ellipse
	 */
	public static Ellipse createEllipse(GraphicsAlgorithmContainer gaContainer) {
		Ellipse ret = getPartition(gaContainer).createElement(Ellipse.CLASS_DESCRIPTOR);
		setDefaultGraphicsAlgorithmValues(ret);
		setContainer(ret, gaContainer);
		return ret;
	}

	/**
	 * Creates a font datatype.
	 * 
	 * @param name
	 *            the name
	 * @param size
	 *            the size
	 * @param text
	 *            the text
	 * @return the new font
	 */
	public static Font createFont(AbstractText text, String name, int size) {
		return createFont(text, name, size, false, false);
	}

	/**
	 * Creates a font datatype.
	 * 
	 * @param name
	 *            the name
	 * @param size
	 *            the size
	 * @param isItalic
	 *            the is italic
	 * @param isBold
	 *            the is bold
	 * @param text
	 *            the text
	 * @return the new font
	 */
	public static Font createFont(AbstractText text, String name, int size, boolean isItalic, boolean isBold) {
		Font ret = getPartition(text).createElement(Font.CLASS_DESCRIPTOR);
		ret.setName(name);
		ret.setSize(size);
		ret.setItalic(isItalic);
		ret.setBold(isBold);
		Font oldFont = text.getFont();
		text.setFont(ret);
		if (oldFont != null) {// remove old font from the transient partition
			oldFont.refDelete();
		}

		return ret;
	}

	/**
	 * Creates a image graphics algorithm with the given image id.
	 * <p>
	 * The following values are set by default:
	 * <p>
	 * graphicsAlgorithm.setFilled(true); <br>
	 * graphicsAlgorithm.setLineStyle(LineStyleEnum.SOLID); <br>
	 * graphicsAlgorithm.setLineVisible(true); <br>
	 * graphicsAlgorithm.setLineWidth(1);<br>
	 * graphicsAlgorithm.setTransparency(0);<br>
	 * image.setId(imageId);<br>
	 * image.setProportional(false);<br>
	 * image.setStretchH(false);<br>
	 * image.setStretchV(false);<br>
	 * 
	 * @param imageId
	 *            the image id
	 * @param gaContainer
	 *            the ga container
	 * @return the new image
	 */
	public static Image createImage(GraphicsAlgorithmContainer gaContainer, String imageId) {
		Image ret = getPartition(gaContainer).createElement(Image.CLASS_DESCRIPTOR);
		setDefaultGraphicsAlgorithmValues(ret);
		ret.setId(imageId);
		ret.setProportional(false);
		ret.setStretchH(false);
		ret.setStretchV(false);
		setContainer(ret, gaContainer);
		return ret;
	}

	/**
	 * Creates the platform graphics algorithm.
	 * 
	 * @param gaContainer
	 *            the ga container
	 * @param id
	 *            the id
	 * @return the platform graphics algorithm
	 */
	public static PlatformGraphicsAlgorithm createPlatformGraphicsAlgorithm(GraphicsAlgorithmContainer gaContainer, String id) {
		PlatformGraphicsAlgorithm ret = getPartition(gaContainer).createElement(PlatformGraphicsAlgorithm.CLASS_DESCRIPTOR);
		setDefaultGraphicsAlgorithmValues(ret);
		ret.setId(id);
		setContainer(ret, gaContainer);
		return ret;
	}

	/**
	 * Creates a multitext graphics algorithm.
	 * <p>
	 * The following values are set by default:
	 * <p>
	 * graphicsAlgorithm.setFilled(true); <br>
	 * graphicsAlgorithm.setLineStyle(LineStyleEnum.SOLID); <br>
	 * graphicsAlgorithm.setLineVisible(true); <br>
	 * graphicsAlgorithm.setLineWidth(1);<br>
	 * graphicsAlgorithm.setTransparency(0);<br>
	 * text.setAngle(0);<br>
	 * text.setHorizontalAlignment(OrientationEnum.ALIGNMENT_LEFT);<br>
	 * text.setVerticalAlignment(OrientationEnum.ALIGNMENT_CENTER);<br>
	 * 
	 * @param gaContainer
	 *            the ga container
	 * @return the new multiline text
	 */
	public static MultiText createMultiText(GraphicsAlgorithmContainer gaContainer) {
		return createMultiText(gaContainer, ""); //$NON-NLS-1$
	}

	/**
	 * Creates a multitext graphics algorithm with the given text.
	 * <p>
	 * The following values are set by default:
	 * <p>
	 * graphicsAlgorithm.setFilled(true); <br>
	 * graphicsAlgorithm.setLineStyle(LineStyleEnum.SOLID); <br>
	 * graphicsAlgorithm.setLineVisible(true); <br>
	 * graphicsAlgorithm.setLineWidth(1);<br>
	 * graphicsAlgorithm.setTransparency(0);<br>
	 * text.setAngle(0);<br>
	 * text.setHorizontalAlignment(OrientationEnum.ALIGNMENT_LEFT);<br>
	 * text.setVerticalAlignment(OrientationEnum.ALIGNMENT_CENTER);<br>
	 * 
	 * @param value
	 *            initial text
	 * @param gaContainer
	 *            the ga container
	 * @return the new multiline text
	 */
	public static MultiText createMultiText(GraphicsAlgorithmContainer gaContainer, String value) {
		return (MultiText) createText(gaContainer, true, value, false);
	}

	/**
	 * Creates a multitext graphics algorithm.
	 * <p>
	 * The following values are set by default:
	 * <p>
	 * graphicsAlgorithm.setFilled(true); <br>
	 * graphicsAlgorithm.setLineStyle(LineStyleEnum.SOLID); <br>
	 * graphicsAlgorithm.setLineVisible(true); <br>
	 * graphicsAlgorithm.setLineWidth(1);<br>
	 * graphicsAlgorithm.setTransparency(0);<br>
	 * text.setFont(createFont(DEFAULT_FONT, 8));<br>
	 * text.setAngle(0);<br>
	 * text.setHorizontalAlignment(OrientationEnum.ALIGNMENT_LEFT);<br>
	 * text.setVerticalAlignment(OrientationEnum.ALIGNMENT_CENTER);<br>
	 * 
	 * @param gaContainer
	 *            the ga container
	 * @return the new multiline text
	 */
	public static MultiText createDefaultMultiText(GraphicsAlgorithmContainer gaContainer) {
		return createDefaultMultiText(gaContainer, ""); //$NON-NLS-1$
	}

	/**
	 * Creates a multitext graphics algorithm with the given text.
	 * <p>
	 * The following values are set by default:
	 * <p>
	 * graphicsAlgorithm.setFilled(true); <br>
	 * graphicsAlgorithm.setLineStyle(LineStyleEnum.SOLID); <br>
	 * graphicsAlgorithm.setLineVisible(true); <br>
	 * graphicsAlgorithm.setLineWidth(1);<br>
	 * graphicsAlgorithm.setTransparency(0);<br>
	 * text.setFont(createFont(DEFAULT_FONT, 8));<br>
	 * text.setAngle(0);<br>
	 * text.setHorizontalAlignment(OrientationEnum.ALIGNMENT_LEFT);<br>
	 * text.setVerticalAlignment(OrientationEnum.ALIGNMENT_CENTER);<br>
	 * 
	 * @param value
	 *            initial text
	 * @param gaContainer
	 *            the ga container
	 * @return the new multiline text
	 */
	public static MultiText createDefaultMultiText(GraphicsAlgorithmContainer gaContainer, String value) {
		return (MultiText) createText(gaContainer, true, value, true);
	}

	private static AbstractText createText(GraphicsAlgorithmContainer gaContainer, boolean multiText, String value, boolean createFont) {
		ModelPartition partition = getPartition(gaContainer);
		AbstractText ret = multiText ? partition.createElement(MultiText.CLASS_DESCRIPTOR) : partition.createElement(Text.CLASS_DESCRIPTOR);
		setDefaultTextAttributes(ret, value, createFont);
		setContainer(ret, gaContainer);
		return ret;
	}

	/**
	 * Creates a point datatype for the given x/y coordinates.
	 * 
	 * @return the new point
	 */
	public static Point createPoint(RefObject refObject, int x, int y) {
		return createPoint(refObject, x, y, 0, 0);
	}

	/**
	 * Creates a point datatype for the given x/y coordinates. The additional before/after parameters defined at which distance before/after
	 * the point a rounded curve will start/end. Note, that before/after parameters have only an effect, if the graphics algorithm support
	 * them, e.g. polygon and polyline.
	 * 
	 * @return the new point
	 */
	public static Point createPoint(RefObject refObject, int x, int y, int before, int after) {
		StructureFieldContainer<Point> container = new StructureFieldContainer<Point>();
		container.put(Point.DESCRIPTORS.X(), x);
		container.put(Point.DESCRIPTORS.Y(), y);
		container.put(Point.DESCRIPTORS.BEFORE(), before);
		container.put(Point.DESCRIPTORS.AFTER(), after);
		Point ret = PackageUtil.getDataTypesPackage(refObject).createPoint(container);
		return ret;
	}

	/**
	 * Creates a list of point datatypes for the given x/y coordinates.
	 * 
	 * @param xy
	 *            The x/y coordinates: [x0, y0, ...,xN, yN]
	 * 
	 * @return the point list
	 */
	public static List<Point> createPointList(RefObject refObject, int[] xy) {
		assert (xy != null && xy.length % 2 == 0);
		List<Point> points = new ArrayList<Point>(xy.length / 2);
		for (int i = 0; i < xy.length; i += 2) {
			points.add(createPoint(refObject, xy[i], xy[i + 1]));
		}
		return points;
	}

	/**
	 * Creates a list of point datatypes for the given x/y coordinates.
	 * 
	 * @param xy
	 *            The x/y coordinates: [x0, y0, ..., xN, yN]
	 * @param beforeAfter
	 *            The before/after parameters: [before0, after0, ..., beforeN, afterN]
	 * 
	 * @return the point list
	 */
	public static List<Point> createPointList(RefObject refObject, int[] xy, int beforeAfter[]) {
		assert (xy != null && xy.length % 2 == 0);
		assert (beforeAfter != null && beforeAfter.length == xy.length);
		List<Point> points = new ArrayList<Point>(xy.length / 2);
		for (int i = 0; i < xy.length; i += 2) {
			points.add(createPoint(refObject, xy[i], xy[i + 1], beforeAfter[i], beforeAfter[i + 1]));
		}
		return points;
	}

	/**
	 * Creates a polygon graphics algorithm.
	 * <p>
	 * The following values are set by default:
	 * <p>
	 * graphicsAlgorithm.setFilled(true); <br>
	 * graphicsAlgorithm.setLineStyle(LineStyleEnum.SOLID); <br>
	 * graphicsAlgorithm.setLineVisible(true); <br>
	 * graphicsAlgorithm.setLineWidth(1);<br>
	 * graphicsAlgorithm.setTransparency(0);<br>
	 * 
	 * @param gaContainer
	 *            the ga container
	 * @return the new polygon
	 */
	public static Polygon createPolygon(GraphicsAlgorithmContainer gaContainer) {
		Polygon ret = getPartition(gaContainer).createElement(Polygon.CLASS_DESCRIPTOR);
		setDefaultGraphicsAlgorithmValues(ret);
		ret.setFilled(true);
		setContainer(ret, gaContainer);
		return ret;
	}

	/**
	 * Creates a polygon graphics algorithm with the given points.
	 * <p>
	 * The following values are set by default:
	 * <p>
	 * graphicsAlgorithm.setFilled(true); <br>
	 * graphicsAlgorithm.setLineStyle(LineStyleEnum.SOLID); <br>
	 * graphicsAlgorithm.setLineVisible(true); <br>
	 * graphicsAlgorithm.setLineWidth(1);<br>
	 * graphicsAlgorithm.setTransparency(0);<br>
	 * 
	 * @param points
	 *            collection of point
	 * @param gaContainer
	 *            the ga container
	 * @return the new polygon
	 */
	public static Polygon createPolygon(GraphicsAlgorithmContainer gaContainer, Collection<Point> points) {
		Polygon ret = createPolygon(gaContainer);
		ret.getPoints().addAll(points);
		return ret;
	}

	/**
	 * Creates a polygon graphics algorithm with the given points.
	 * <p>
	 * The following values are set by default:
	 * <p>
	 * graphicsAlgorithm.setFilled(true); <br>
	 * graphicsAlgorithm.setLineStyle(LineStyleEnum.SOLID); <br>
	 * graphicsAlgorithm.setLineVisible(true); <br>
	 * graphicsAlgorithm.setLineWidth(1);<br>
	 * graphicsAlgorithm.setTransparency(0);<br>
	 * 
	 * @param gaContainer
	 *            the ga container
	 * @param xy
	 *            The x/y coordinates: [x0, y0, ..., xN, yN]
	 * @return the new polygon
	 */
	public static Polygon createPolygon(GraphicsAlgorithmContainer gaContainer, int[] xy) {
		List<Point> points = createPointList(gaContainer, xy);
		Polygon ret = createPolygon(gaContainer, points);
		return ret;
	}

	/**
	 * Creates a polygon graphics algorithm with the given points.
	 * <p>
	 * The following values are set by default:
	 * <p>
	 * graphicsAlgorithm.setFilled(true); <br>
	 * graphicsAlgorithm.setLineStyle(LineStyleEnum.SOLID); <br>
	 * graphicsAlgorithm.setLineVisible(true); <br>
	 * graphicsAlgorithm.setLineWidth(1);<br>
	 * graphicsAlgorithm.setTransparency(0);<br>
	 * 
	 * @param gaContainer
	 *            the ga container
	 * @param xy
	 *            The x/y coordinates: [x0, y0, ..., xN, yN]
	 * @param beforeAfter
	 *            The before/after parameters: [before0, after0, ..., beforeN, afterN]
	 * @return the new polygon
	 */
	public static Polygon createPolygon(GraphicsAlgorithmContainer gaContainer, int[] xy, int beforeAfter[]) {
		List<Point> points = createPointList(gaContainer, xy, beforeAfter);
		Polygon ret = createPolygon(gaContainer, points);
		return ret;
	}

	/**
	 * Creates a polyline graphics algorithm.
	 * <p>
	 * The following values are set by default:
	 * <p>
	 * graphicsAlgorithm.setFilled(true); <br>
	 * graphicsAlgorithm.setLineStyle(LineStyleEnum.SOLID); <br>
	 * graphicsAlgorithm.setLineVisible(true); <br>
	 * graphicsAlgorithm.setLineWidth(1);<br>
	 * graphicsAlgorithm.setTransparency(0);<br>
	 * 
	 * @param gaContainer
	 *            the ga container
	 * @return the new polyline
	 */
	public static Polyline createPolyline(GraphicsAlgorithmContainer gaContainer) {
		Polyline ret = getPartition(gaContainer).createElement(Polyline.CLASS_DESCRIPTOR);
		setDefaultGraphicsAlgorithmValues(ret);
		ret.setFilled(false);
		setContainer(ret, gaContainer);
		return ret;
	}

	/**
	 * Creates a polyline graphics algorithm with the given points.
	 * <p>
	 * The following values are set by default:
	 * <p>
	 * graphicsAlgorithm.setFilled(true); <br>
	 * graphicsAlgorithm.setLineStyle(LineStyleEnum.SOLID); <br>
	 * graphicsAlgorithm.setLineVisible(true); <br>
	 * graphicsAlgorithm.setLineWidth(1);<br>
	 * graphicsAlgorithm.setTransparency(0);<br>
	 * 
	 * @param points
	 *            collection of point
	 * @param gaContainer
	 *            the ga container
	 * @return the new polyline
	 */
	public static Polyline createPolyline(GraphicsAlgorithmContainer gaContainer, Collection<Point> points) {
		Polyline ret = createPolyline(gaContainer);
		ret.getPoints().addAll(points);
		return ret;
	}

	/**
	 * Creates a polyline graphics algorithm with the given points.
	 * <p>
	 * The following values are set by default:
	 * <p>
	 * graphicsAlgorithm.setFilled(true); <br>
	 * graphicsAlgorithm.setLineStyle(LineStyleEnum.SOLID); <br>
	 * graphicsAlgorithm.setLineVisible(true); <br>
	 * graphicsAlgorithm.setLineWidth(1);<br>
	 * graphicsAlgorithm.setTransparency(0);<br>
	 * 
	 * @param gaContainer
	 *            the ga container
	 * @param xy
	 *            The x/y coordinates: [x0, y0, ..., xN, yN]
	 * @return the new polyline
	 */
	public static Polyline createPolyline(GraphicsAlgorithmContainer gaContainer, int[] xy) {
		List<Point> points = createPointList(gaContainer, xy);
		Polyline ret = createPolyline(gaContainer, points);
		return ret;
	}

	/**
	 * Creates a polyline graphics algorithm with the given points.
	 * <p>
	 * The following values are set by default:
	 * <p>
	 * graphicsAlgorithm.setFilled(true); <br>
	 * graphicsAlgorithm.setLineStyle(LineStyleEnum.SOLID); <br>
	 * graphicsAlgorithm.setLineVisible(true); <br>
	 * graphicsAlgorithm.setLineWidth(1);<br>
	 * graphicsAlgorithm.setTransparency(0);<br>
	 * 
	 * @param gaContainer
	 *            the ga container
	 * @param xy
	 *            The x/y coordinates: [x0, y0, ..., xN, yN]
	 * @param beforeAfter
	 *            The before/after parameters: [before0, after0, ..., beforeN, afterN]
	 * @return the new polyline
	 */
	public static Polyline createPolyline(GraphicsAlgorithmContainer gaContainer, int[] xy, int beforeAfter[]) {
		List<Point> points = createPointList(gaContainer, xy, beforeAfter);
		Polyline ret = createPolyline(gaContainer, points);
		return ret;
	}

	/**
	 * Creates a rectangle graphics algorithm.
	 * <p>
	 * The following values are set by default:
	 * <p>
	 * graphicsAlgorithm.setFilled(true); <br>
	 * graphicsAlgorithm.setLineStyle(LineStyleEnum.SOLID); <br>
	 * graphicsAlgorithm.setLineVisible(true); <br>
	 * graphicsAlgorithm.setLineWidth(1);<br>
	 * graphicsAlgorithm.setTransparency(0);<br>
	 * 
	 * @param gaContainer
	 *            the ga container
	 * @return the new rectangle
	 */
	public static Rectangle createRectangle(GraphicsAlgorithmContainer gaContainer) {
		Rectangle ret = getPartition(gaContainer).createElement(Rectangle.CLASS_DESCRIPTOR);
		setDefaultGraphicsAlgorithmValues(ret);
		setContainer(ret, gaContainer);
		return ret;
	}

	/**
	 * Create an invisible rectangle.
	 * 
	 * @param pe
	 *            the PE to create the GA in
	 * @return the rectangle GA
	 */
	public static Rectangle createInvisibleRectangle(PictogramElement pe) {
		final Rectangle ret = GaUtil.createRectangle(pe);
		if (GfwTestConfiguration.areInvisibleRectanglesShown()) {
			final Color bg = GaUtil.manageColor(PeUtil.getDiagramForPictogramElement(pe), IColorConstant.LIGHT_GRAY);
			ret.setBackground(bg);
			final Color fg = GaUtil.manageColor(PeUtil.getDiagramForPictogramElement(pe), IColorConstant.YELLOW);
			ret.setForeground(fg);
			ret.setLineWidth(2);
			ret.setTransparency(0.75);
		} else {
			ret.setFilled(false);
			ret.setLineVisible(false);
		}
		return ret;
	}

	/**
	 * DEPRECATED. Change your coding as described here:
	 * <p>
	 * OLD coding: <code>
	 * RenderingStyle renderingStyle = GaUtil.createRenderingStyle(startColor, endColor, 20);
	 * ga.setRenderingStyle(renderingStyle);
	 * </code> NEW coding: <code>    
	 * GaUtil.setRenderingStyle(ga, IPredefinedRenderingStyle.BLUE_WHITE_GLOSS_ID);
	 * </code>
	 * 
	 * @deprecated use setRenderingStyle(abstractStyle, IPredefinedColoredAreas.BLUE_WHITE_GLOSS_ID) instead.
	 */
	@Deprecated
	public static RenderingStyle createRenderingStyle(Color startColor, Color endColor, int split) {
		RenderingStyle ret = getPartition(startColor).createElement(RenderingStyle.CLASS_DESCRIPTOR);
		ret.setPredefinedStyleId(IPredefinedRenderingStyle.BLUE_WHITE_GLOSS_ID);
		return ret;
	}

	/**
	 * Sets a RenderingStyle with a given ID for the given AbstractStyle. The ID must be defined in {@link IPredefinedRenderingStyle}.
	 * 
	 * @param abstractStyle
	 *            The AbstractStyle for which to set the RenderingStyle.
	 * @param id
	 *            The ID of the RenderingStyle.
	 */
	public static void setRenderingStyle(AbstractStyle abstractStyle, String id) {
		// is the ID supported?
		boolean idSupported = false;
		for (int i = 0; i < IPredefinedRenderingStyle.ALL_IDS.length; i++) {
			if (IPredefinedRenderingStyle.ALL_IDS[i].equals(id)) {
				idSupported = true;
			}
		}
		if (!idSupported) {
			throw new IllegalArgumentException("The ID '" + id + "' is not supported."); //$NON-NLS-1$ //$NON-NLS-2$
		}

		// set the RenderingStyle with ID
		RenderingStyle renderingStyle = abstractStyle.getRenderingStyle();
		if (renderingStyle == null) {
			renderingStyle = getPartition(abstractStyle).createElement(RenderingStyle.CLASS_DESCRIPTOR);
			abstractStyle.setRenderingStyle(renderingStyle);
		}
		renderingStyle.setPredefinedStyleId(id);
	}

	/**
	 * Deletes the RenderingStyle from the given AbstractStyle.
	 * 
	 * @param abstractStyle
	 *            The AbstractStyle from which to delete the RenderingStyle.
	 */
	public static void deleteRenderingStyle(AbstractStyle abstractStyle) {
		// it is not sufficient to call abstractStyle.setRenderingStyle(null),
		// because then the old RenderingStyle would be left as garbage in the
		// model.
		if (abstractStyle.getRenderingStyle() != null) {
			abstractStyle.getRenderingStyle().refDelete();
		}
	}

	/**
	 * Creates a rounded rectangle graphics algorithm with the given corner dimensions.
	 * <p>
	 * The following values are set by default:
	 * <p>
	 * graphicsAlgorithm.setFilled(true); <br>
	 * graphicsAlgorithm.setLineStyle(LineStyleEnum.SOLID); <br>
	 * graphicsAlgorithm.setLineVisible(true); <br>
	 * graphicsAlgorithm.setLineWidth(1);<br>
	 * graphicsAlgorithm.setTransparency(0);<br>
	 * 
	 * @param cornerWidth
	 *            the corner width
	 * @param cornerHeight
	 *            the corner height
	 * @param gaContainer
	 *            the ga container
	 * @return the new rounded rectangle
	 */
	public static RoundedRectangle createRoundedRectangle(GraphicsAlgorithmContainer gaContainer, int cornerWidth, int cornerHeight) {
		RoundedRectangle ret = getPartition(gaContainer).createElement(RoundedRectangle.CLASS_DESCRIPTOR);
		setDefaultGraphicsAlgorithmValues(ret);
		ret.setCornerWidth(cornerWidth);
		ret.setCornerHeight(cornerHeight);
		setContainer(ret, gaContainer);
		return ret;
	}

	/**
	 * Shifts the color darker or lighter.
	 * 
	 * @param color
	 *            the color to be changed
	 * @param shift
	 *            negative shifts means darken the color
	 * @param diagram
	 *            the diagram
	 * @return a new color datatype with the shiftet values
	 */
	public static Color createShiftedColor(Color color, int shift, Diagram diagram) {
		if (color == null) {
			throw new IllegalArgumentException("color must not be null"); //$NON-NLS-1$
		}
		int red = color.getRed();
		int green = color.getGreen();
		int blue = color.getBlue();

		red = fitColorInt(red + shift);
		green = fitColorInt(green + shift);
		blue = fitColorInt(blue + shift);

		Color ret = manageColor(diagram, red, green, blue);
		return ret;
	}

	/**
	 * Shifts the color constant darker or lighter.
	 * 
	 * @param colorConstant
	 *            the color constant to be changed
	 * @param shift
	 *            negative shifts means darken the color
	 * @return the color constant with the shifted values
	 */
	public static IColorConstant createShiftedColor(IColorConstant colorConstant, int shift) {
		int red = colorConstant.getRed();
		int green = colorConstant.getGreen();
		int blue = colorConstant.getBlue();

		red = fitColorInt(red + shift);
		green = fitColorInt(green + shift);
		blue = fitColorInt(blue + shift);

		IColorConstant ret = new ColorConstant(red, green, blue);
		return ret;
	}

	private static int fitColorInt(int c) {
		c = Math.max(0, c);
		c = Math.min(255, c);
		return c;
	}

	/**
	 * Creates a style with the given id. The style is aggregated under the given container style.
	 * 
	 * @param styleContainer
	 *            container style
	 * @param id
	 *            style id
	 * @return the newly created style
	 */
	public static Style createStyle(StyleContainer styleContainer, String id) {
		Style ret = getPartition(styleContainer).createElement(Style.CLASS_DESCRIPTOR);
		ret.setId(id);
		ret.setStyleContainer(styleContainer);
		return ret;
	}

	/**
	 * Sets the provided {@link AbstractStyle} (could be a {@link GraphicsAlgorithm} or a {@link Style}) to ignore all locally set
	 * attributes and instead use the ones provided by the style set to the {@link AbstractStyle}.
	 * 
	 * @param abstractStyle
	 *            The abstract style (style or graphics algorithm)
	 */
	public static void ignoreAll(AbstractStyle abstractStyle) {
		abstractStyle.setBackground(null);
		abstractStyle.setFilled(null);
		abstractStyle.setForeground(null);
		abstractStyle.setLineStyle(null);
		abstractStyle.setLineVisible(null);
		abstractStyle.setLineWidth(null);
		GaUtil.deleteRenderingStyle(abstractStyle);
		abstractStyle.setTransparency(null);
		if (abstractStyle instanceof AbstractText) {
			AbstractText text = (AbstractText) abstractStyle;
			text.setAngle(null);
			deleteFont(text);
			text.setHorizontalAlignment(null);
			text.setVerticalAlignment(null);
		}
	}

	/**
	 * Delete font.
	 * 
	 * @param abstractText
	 *            the abstract text
	 */
	public static void deleteFont(AbstractText abstractText) {
		final Font oldFont = abstractText.getFont();
		if (oldFont != null) {
			oldFont.refDelete();
		}
	}

	/**
	 * Creates a text graphics algorithm.
	 * <p>
	 * The following values are set by default:
	 * <p>
	 * graphicsAlgorithm.setFilled(true); <br>
	 * graphicsAlgorithm.setLineStyle(LineStyleEnum.SOLID); <br>
	 * graphicsAlgorithm.setLineVisible(true); <br>
	 * graphicsAlgorithm.setLineWidth(1);<br>
	 * graphicsAlgorithm.setTransparency(0);<br>
	 * text.setAngle(0);<br>
	 * text.setHorizontalAlignment(OrientationEnum.ALIGNMENT_LEFT);<br>
	 * text.setVerticalAlignment(OrientationEnum.ALIGNMENT_CENTER);<br>
	 * 
	 * @param gaContainer
	 *            the ga container
	 * @return the new text
	 */
	public static Text createText(GraphicsAlgorithmContainer gaContainer) {
		return createText(gaContainer, ""); //$NON-NLS-1$
	}

	/**
	 * Creates a text graphics algorithm with the given text.
	 * <p>
	 * The following values are set by default:
	 * <p>
	 * graphicsAlgorithm.setFilled(true); <br>
	 * graphicsAlgorithm.setLineStyle(LineStyleEnum.SOLID); <br>
	 * graphicsAlgorithm.setLineVisible(true); <br>
	 * graphicsAlgorithm.setLineWidth(1);<br>
	 * graphicsAlgorithm.setTransparency(0);<br>
	 * text.setAngle(0);<br>
	 * text.setHorizontalAlignment(OrientationEnum.ALIGNMENT_LEFT);<br>
	 * text.setVerticalAlignment(OrientationEnum.ALIGNMENT_CENTER);<br>
	 * 
	 * @param value
	 *            initial text
	 * @param gaContainer
	 *            the ga container
	 * @return the new text
	 */
	public static Text createText(GraphicsAlgorithmContainer gaContainer, String value) {
		return (Text) createText(gaContainer, false, value, false);
	}

	/**
	 * Creates a text graphics algorithm.
	 * <p>
	 * The following values are set by default:
	 * <p>
	 * graphicsAlgorithm.setFilled(true); <br>
	 * graphicsAlgorithm.setLineStyle(LineStyleEnum.SOLID); <br>
	 * graphicsAlgorithm.setLineVisible(true); <br>
	 * graphicsAlgorithm.setLineWidth(1);<br>
	 * graphicsAlgorithm.setTransparency(0);<br>
	 * text.setFont(createFont(DEFAULT_FONT, 8));<br>
	 * text.setAngle(0);<br>
	 * text.setHorizontalAlignment(OrientationEnum.ALIGNMENT_LEFT);<br>
	 * text.setVerticalAlignment(OrientationEnum.ALIGNMENT_CENTER);<br>
	 * 
	 * @param gaContainer
	 *            the ga container
	 * @return the new text
	 */
	public static Text createDefaultText(GraphicsAlgorithmContainer gaContainer) {
		return createDefaultText(gaContainer, ""); //$NON-NLS-1$
	}

	/**
	 * Creates a text graphics algorithm with the given text.
	 * <p>
	 * The following values are set by default:
	 * <p>
	 * graphicsAlgorithm.setFilled(true); <br>
	 * graphicsAlgorithm.setLineStyle(LineStyleEnum.SOLID); <br>
	 * graphicsAlgorithm.setLineVisible(true); <br>
	 * graphicsAlgorithm.setLineWidth(1);<br>
	 * graphicsAlgorithm.setTransparency(0);<br>
	 * text.setFont(createFont(DEFAULT_FONT, 8));<br>
	 * text.setAngle(0);<br>
	 * text.setHorizontalAlignment(OrientationEnum.ALIGNMENT_LEFT);<br>
	 * text.setVerticalAlignment(OrientationEnum.ALIGNMENT_CENTER);<br>
	 * 
	 * @param value
	 *            initial text
	 * @param gaContainer
	 *            the ga container
	 * @return the new text
	 */
	public static Text createDefaultText(GraphicsAlgorithmContainer gaContainer, String value) {
		return (Text) createText(gaContainer, false, value, true);
	}

	/**
	 * Searches for a style with the given id. The search scope is the given style container (which will usually be the diagram).
	 * 
	 * @param styleContainer
	 *            container style
	 * @param id
	 *            style id
	 * @return the found style; null if not found
	 */
	public static Style findStyle(StyleContainer styleContainer, String id) {
		Collection childStyled = styleContainer.getStyles();
		for (Object child : childStyled) {
			Style childStyle = (Style) child;
			if (id.equals(childStyle.getId())) {
				return childStyle;
			}
			Style findStyle = findStyle(childStyle, id);
			if (findStyle != null) {
				return findStyle;
			}
		}
		return null;
	}

	/**
	 * Provides a color instance with the given given color constant by either creating a new one and aggregating it to the diagram or
	 * finding it in the diagrams palette of colors.
	 * 
	 * @param diagram
	 *            the diagram that aggregates and the colors
	 * @param colorConstant
	 *            which contains the RGB values.
	 * @return the color instance
	 */
	public static Color manageColor(Diagram diagram, IColorConstant colorConstant) {
		return manageColor(diagram, colorConstant.getRed(), colorConstant.getGreen(), colorConstant.getBlue());
	}

	/**
	 * Provides a color instance with the given RGB values by either creating a new one and aggregating it to the diagram or finding it in
	 * the diagrams palette of colors.
	 * 
	 * @param diagram
	 *            the diagram that aggregates and the colors
	 * @param red
	 *            the red
	 * @param green
	 *            the green
	 * @param blue
	 *            the blue
	 * @return the color instance
	 */
	public static Color manageColor(Diagram diagram, int red, int green, int blue) {
		Collection<Color> colors = diagram.getColors();
		for (Color existingColor : colors) {
			if (existingColor.getRed() == red && existingColor.getGreen() == green && existingColor.getBlue() == blue) {
				return existingColor;
			}
		}

		Color newColor = diagram.get___Partition().createElement(Color.class);
		newColor.setRed(red);
		newColor.setGreen(green);
		newColor.setBlue(blue);
		colors.add(newColor);
		return newColor;
	}

	/**
	 * Changes location and size of the given graphics algorithm.
	 * 
	 * @param ga
	 *            GraphicsAlgorithm
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @param width
	 *            the width
	 * @param height
	 *            the height
	 */
	public static void setLocationAndSizeOfGraphicsAlgorithm(GraphicsAlgorithm ga, int x, int y, int width, int height) {
		setLocationAndSizeOfGraphicsAlgorithm(ga, x, y, width, height, false);
	}

	/**
	 * Changes location and size of the given graphics algorithm.
	 * 
	 * @param ga
	 *            GraphicsAlgorithm
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @param width
	 *            the width
	 * @param height
	 *            the height
	 * @param avoidNegativeCoordinates
	 *            the avoid negative coordinates
	 */
	public static void setLocationAndSizeOfGraphicsAlgorithm(GraphicsAlgorithm ga, int x, int y, int width, int height,
			boolean avoidNegativeCoordinates) {
		setLocationOfGraphicsAlgorithm(ga, x, y, avoidNegativeCoordinates);
		setSizeOfGraphicsAlgorithm(ga, width, height);
	}

	/**
	 * Changes location of the given graphics algorithm.
	 * 
	 * @param ga
	 *            GraphicsAlgorithm
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 */
	public static void setLocationOfGraphicsAlgorithm(GraphicsAlgorithm ga, int x, int y) {
		setLocationOfGraphicsAlgorithm(ga, x, y, false);
	}

	/**
	 * Changes location of the given graphics algorithm.
	 * 
	 * @param ga
	 *            GraphicsAlgorithm
	 * @param newX
	 *            the new x
	 * @param newY
	 *            the new y
	 * @param avoidNegativeCoordinates
	 *            the avoid negative coordinates
	 */
	public static void setLocationOfGraphicsAlgorithm(GraphicsAlgorithm ga, int newX, int newY, boolean avoidNegativeCoordinates) {

		if (ga == null) {
			return;
		}

		if (avoidNegativeCoordinates) {
			newX = Math.max(newX, 0);
			newY = Math.max(newY, 0);
		}

		int oldX = ga.getX();
		if (oldX != newX) {
			ga.setX(newX);
		}
		int oldY = ga.getY();
		if (oldY != newY) {
			ga.setY(newY);
		}

	}

	/**
	 * Changes the size of the given graphics algorithm.
	 * 
	 * @param ga
	 *            GraphicsAlgorithm
	 * @param newWidth
	 *            the new width
	 * @param newHeight
	 *            the new height
	 */
	public static void setSizeOfGraphicsAlgorithm(GraphicsAlgorithm ga, int newWidth, int newHeight) {
		setWidthOfGraphicsAlgorithm(ga, newWidth);
		setHeightOfGraphicsAlgorithm(ga, newHeight);
	}

	/**
	 * Changes the width of the given graphics algorithm.
	 * 
	 * @param ga
	 *            GraphicsAlgorithm
	 * @param width
	 *            the width
	 */
	public static void setWidthOfGraphicsAlgorithm(GraphicsAlgorithm ga, int width) {
		ga.setWidth(width);
	}

	/**
	 * Changes the height of the given graphics algorithm.
	 * 
	 * @param ga
	 *            GraphicsAlgorithm
	 * @param height
	 *            the height
	 */
	public static void setHeightOfGraphicsAlgorithm(GraphicsAlgorithm ga, int height) {
		ga.setHeight(height);
	}

	private static IDimension calculatePolylineMinSize(Polyline polyline) {
		Collection<Point> points = polyline.getPoints();

		int minX = points.isEmpty() ? 0 : ((Point) points.toArray()[0]).getX();
		int minY = points.isEmpty() ? 0 : ((Point) points.toArray()[0]).getY();
		int maxX = minX;
		int maxY = minY;

		for (Iterator<Point> iter = points.iterator(); iter.hasNext();) {
			Point point = iter.next();
			int x = point.getX();
			int y = point.getY();
			minX = Math.min(minX, x);
			minY = Math.min(minY, y);
			maxX = Math.max(maxX, x);
			maxY = Math.max(maxY, y);
		}
		return new DimensionImpl(Math.abs(maxX - minX) + 1, Math.abs(maxY - minY) + 1);
	}

	private static void setContainer(GraphicsAlgorithm ga, GraphicsAlgorithmContainer gaContainer) {
		if (gaContainer instanceof PictogramElement) {
			PictogramElement pe = (PictogramElement) gaContainer;
			pe.setGraphicsAlgorithm(ga);
		} else if (gaContainer instanceof GraphicsAlgorithm) {
			GraphicsAlgorithm parentGa = (GraphicsAlgorithm) gaContainer;
			parentGa.getGraphicsAlgorithmChildren().add(ga);
		}
	}

	private static void setDefaultGraphicsAlgorithmValues(GraphicsAlgorithm graphicsAlgorithm) {
		setLocationAndSizeOfGraphicsAlgorithm(graphicsAlgorithm, 0, 0, 0, 0);
	}

	private static void setDefaultTextAttributes(AbstractText ret, String value, boolean createFont) {
		setDefaultGraphicsAlgorithmValues(ret);
		ret.setValue(value);
		if (createFont) {
			createFont(ret, DEFAULT_FONT, 8);
		}
	}

	/**
	 * Move polyline point.
	 * 
	 * @param polyline
	 *            the polyline
	 * @param index
	 *            the index
	 * @param deltaX
	 *            the delta x
	 * @param deltaY
	 *            the delta y
	 */
	public static void movePolylinePoint(Polyline polyline, int index, int deltaX, int deltaY) {
		Point point = polyline.getPoints().get(index);
		int oldX = point.getX();
		int oldY = point.getY();

		polyline.getPoints().set(index, GaUtil.createPoint(polyline, oldX + deltaX, oldY + deltaY));
	}

	private static ModelPartition getPartition(RefObject object) {
		ModelPartition partition = null;
		if (object != null) {
			partition = object.get___Partition();
		}
		return partition;
	}

	/**
	 * Gets the angle.
	 * 
	 * @param at
	 *            the at
	 * @param checkStyles
	 *            the check styles
	 * @return the angle
	 */
	public static int getAngle(AbstractText at, boolean checkStyles) {
		Integer angle = at.getAngle();
		if (angle == null) {
			if (checkStyles) {
				Style style = at.getStyle();
				if (style != null) {
					Integer styleValue = getAngle(style);
					if (styleValue != null)
						return styleValue;
				}
			}
		} else {
			return angle;
		}
		return 0; // default value
	}

	/**
	 * Gets the background color.
	 * 
	 * @param ga
	 *            the ga
	 * @param checkStyles
	 *            the check styles
	 * @return the background color
	 */
	public static Color getBackgroundColor(GraphicsAlgorithm ga, boolean checkStyles) {
		Color bc = ga.getBackground();
		if (bc == null) {
			if (checkStyles) {
				Style style = ga.getStyle();
				if (style != null) {
					Color styleValue = getBackgroundColor(style);
					if (styleValue != null)
						return styleValue;
				}
			}
		} else {
			return bc;
		}
		return null; // default value
	}

	/**
	 * Gets the font.
	 * 
	 * @param at
	 *            the at
	 * @param checkStyles
	 *            the check styles
	 * @return the font
	 */
	public static Font getFont(AbstractText at, boolean checkStyles) {
		Font font = at.getFont();
		if (font == null) {
			if (checkStyles) {
				Style style = at.getStyle();
				if (style != null) {
					Font styleValue = getFont(style);
					if (styleValue != null)
						return styleValue;
				}
			}
		} else {
			return font;
		}
		return null; // default value
	}

	/**
	 * Gets the foreground color.
	 * 
	 * @param ga
	 *            the ga
	 * @param checkStyles
	 *            the check styles
	 * @return the foreground color
	 */
	public static Color getForegroundColor(GraphicsAlgorithm ga, boolean checkStyles) {
		Color fc = ga.getForeground();
		if (fc == null) {
			if (checkStyles) {
				Style style = ga.getStyle();
				if (style != null) {
					Color styleValue = getForegroundColor(style);
					if (styleValue != null)
						return styleValue;
				}
			}
		} else {
			return fc;
		}
		return null; // default value
	}

	/**
	 * Gets the horizontal alignment.
	 * 
	 * @param at
	 *            the at
	 * @param checkStyles
	 *            the check styles
	 * @return the horizontal alignment
	 */
	public static Orientation getHorizontalAlignment(AbstractText at, boolean checkStyles) {
		Orientation ha = at.getHorizontalAlignment();
		if (ha == null) {
			if (checkStyles) {
				Style style = at.getStyle();
				if (style != null) {
					Orientation styleValue = getHorizontalAlignment(style);
					if (styleValue != null)
						return styleValue;
				}
			}
		} else {
			return ha;
		}
		return OrientationEnum.ALIGNMENT_LEFT; // default value
	}

	/**
	 * Gets the line style.
	 * 
	 * @param ga
	 *            the ga
	 * @param checkStyles
	 *            the check styles
	 * @return the line style
	 */
	public static LineStyle getLineStyle(GraphicsAlgorithm ga, boolean checkStyles) {
		LineStyle ls = ga.getLineStyle();
		if (ls == null) {
			if (checkStyles) {
				Style style = ga.getStyle();
				if (style != null) {
					LineStyle styleValue = getLineStyle(style);
					if (styleValue != null)
						return styleValue;
				}
			}
		} else {
			return ls;
		}
		return LineStyleEnum.SOLID; // default value
	}

	/**
	 * Gets the line width.
	 * 
	 * @param ga
	 *            the ga
	 * @param checkStyles
	 *            the check styles
	 * @return the line width
	 */
	public static int getLineWidth(GraphicsAlgorithm ga, boolean checkStyles) {
		Integer lw = ga.getLineWidth();
		if (lw == null) {
			if (checkStyles) {
				Style style = ga.getStyle();
				if (style != null) {
					Integer styleValue = getLineWidth(style);
					if (styleValue != null)
						return styleValue;
				}
			}
		} else {
			return lw;
		}
		return 1; // default value
	}

	/**
	 * Gets the rendering style.
	 * 
	 * @param ga
	 *            the ga
	 * @param checkStyles
	 *            the check styles
	 * @return the rendering style
	 */
	public static RenderingStyle getRenderingStyle(GraphicsAlgorithm ga, boolean checkStyles) {
		RenderingStyle rs = ga.getRenderingStyle();
		if (rs == null) {
			if (checkStyles) {
				Style style = ga.getStyle();
				if (style != null) {
					RenderingStyle styleValue = getRenderingStyle(style);
					if (styleValue != null)
						return styleValue;
				}
			}
		} else {
			return rs;
		}
		return null; // default value
	}

	/**
	 * Gets the transparency.
	 * 
	 * @param ga
	 *            the ga
	 * @param checkStyles
	 *            the check styles
	 * @return the transparency
	 */
	public static double getTransparency(GraphicsAlgorithm ga, boolean checkStyles) {
		Double transparency = ga.getTransparency();
		if (transparency == null) {
			if (checkStyles) {
				Style style = ga.getStyle();
				if (style != null) {
					Double styleValue = getTransparency(style);
					if (styleValue != null)
						return styleValue;
				}
			}
		} else {
			return transparency;
		}
		return 0; // default value
	}

	/**
	 * Gets the vertical alignment.
	 * 
	 * @param at
	 *            the at
	 * @param checkStyles
	 *            the check styles
	 * @return the vertical alignment
	 */
	public static Orientation getVerticalAlignment(AbstractText at, boolean checkStyles) {
		Orientation va = at.getVerticalAlignment();
		if (va == null) {
			if (checkStyles) {
				Style style = at.getStyle();
				if (style != null) {
					Orientation styleValue = getVerticalAlignment(style);
					if (styleValue != null)
						return styleValue;
				}
			}
		} else {
			return va;
		}
		return OrientationEnum.ALIGNMENT_CENTER; // default value
	}

	/**
	 * Checks if is filled.
	 * 
	 * @param ga
	 *            the ga
	 * @param checkStyles
	 *            the check styles
	 * @return true, if is filled
	 */
	public static boolean isFilled(GraphicsAlgorithm ga, boolean checkStyles) {
		Boolean filled = ga.isFilled();
		if (ga.isFilled() == null) {
			if (checkStyles) {
				Style style = ga.getStyle();
				if (style != null) {
					Boolean styleValue = isFilled(style);
					if (styleValue != null)
						return styleValue;
				}
			}
		} else {
			return filled;
		}
		return true; // default value
	}

	/**
	 * Checks if line is visible.
	 * 
	 * @param ga
	 *            the ga
	 * @param checkStyles
	 *            the check styles
	 * @return true, if line is visible
	 */
	public static boolean isLineVisible(GraphicsAlgorithm ga, boolean checkStyles) {
		Boolean lv = ga.isLineVisible();
		if (lv == null) {
			if (checkStyles) {
				Style style = ga.getStyle();
				if (style != null) {
					Boolean styleValue = isLineVisible(style);
					if (styleValue != null)
						return styleValue;
				}
			}
		} else {
			return lv;
		}
		return true; // default value
	}

	/**
	 * Checks if is proportional.
	 * 
	 * @param image
	 *            the image
	 * @param checkStyles
	 *            the check styles
	 * @return true, if is proportional
	 */
	public static boolean isProportional(Image image, boolean checkStyles) {
		Boolean prop = image.isProportional();
		if (prop == null) {
			if (checkStyles) {
				Style style = image.getStyle();
				if (style != null) {
					Boolean styleValue = isProportional(style);
					if (styleValue != null)
						return styleValue;
				}
			}
		} else {
			return prop;
		}
		return false; // default value
	}

	/**
	 * Checks if is stretch h.
	 * 
	 * @param image
	 *            the image
	 * @param checkStyles
	 *            the check styles
	 * @return true, if is stretch h
	 */
	public static boolean isStretchH(Image image, boolean checkStyles) {
		Boolean sh = image.isStretchH();
		if (sh == null) {
			if (checkStyles) {
				Style style = image.getStyle();
				if (style != null) {
					Boolean styleValue = isStretchH(style);
					if (styleValue != null)
						return styleValue;
				}
			}
		} else {
			return sh;
		}
		return false; // default value
	}

	/**
	 * Checks if is stretch v.
	 * 
	 * @param image
	 *            the image
	 * @param checkStyles
	 *            the check styles
	 * @return true, if is stretch v
	 */
	public static boolean isStretchV(Image image, boolean checkStyles) {
		Boolean sv = image.isStretchV();
		if (sv == null) {
			if (checkStyles) {
				Style style = image.getStyle();
				if (style != null) {
					Boolean styleValue = isStretchV(style);
					if (styleValue != null)
						return styleValue;
				}
			}
		} else {
			return sv;
		}
		return false; // default value
	}

	private static Integer getAngle(Style style) {
		Integer angle = style.getAngle();
		if (angle == null) {
			StyleContainer styleContainer = style.getStyleContainer();
			if (styleContainer instanceof Style) {
				Style parentStyle = (Style) styleContainer;
				return getAngle(parentStyle);
			} else {
				return null;
			}
		} else {
			return angle;
		}
	}

	private static Color getBackgroundColor(Style style) {
		Color bg = style.getBackground();
		if (bg == null) {
			StyleContainer styleContainer = style.getStyleContainer();
			if (styleContainer instanceof Style) {
				Style parentStyle = (Style) styleContainer;
				return getBackgroundColor(parentStyle);
			} else {
				return null;
			}
		} else {
			return bg;
		}
	}

	private static Font getFont(Style style) {
		Font font = style.getFont();
		if (font == null) {
			StyleContainer styleContainer = style.getStyleContainer();
			if (styleContainer instanceof Style) {
				Style parentStyle = (Style) styleContainer;
				return getFont(parentStyle);
			} else {
				return null;
			}
		} else {
			return font;
		}
	}

	private static Color getForegroundColor(Style style) {
		Color fg = style.getForeground();
		if (fg == null) {
			StyleContainer styleContainer = style.getStyleContainer();
			if (styleContainer instanceof Style) {
				Style parentStyle = (Style) styleContainer;
				return getForegroundColor(parentStyle);
			} else {
				return null;
			}
		} else {
			return fg;
		}
	}

	private static Orientation getHorizontalAlignment(Style style) {
		Orientation ha = style.getHorizontalAlignment();
		if (ha == null) {
			StyleContainer styleContainer = style.getStyleContainer();
			if (styleContainer instanceof Style) {
				Style parentStyle = (Style) styleContainer;
				return getHorizontalAlignment(parentStyle);
			} else {
				return null;
			}
		} else {
			return ha;
		}
	}

	private static LineStyle getLineStyle(Style style) {
		LineStyle ls = style.getLineStyle();
		if (ls == null) {
			StyleContainer styleContainer = style.getStyleContainer();
			if (styleContainer instanceof Style) {
				Style parentStyle = (Style) styleContainer;
				return getLineStyle(parentStyle);
			} else {
				return null;
			}
		} else {
			return ls;
		}
	}

	private static Integer getLineWidth(Style style) {
		Integer lw = style.getLineWidth();
		if (lw == null) {
			StyleContainer styleContainer = style.getStyleContainer();
			if (styleContainer instanceof Style) {
				Style parentStyle = (Style) styleContainer;
				return getLineWidth(parentStyle);
			} else {
				return null;
			}
		} else {
			return lw;
		}
	}

	private static RenderingStyle getRenderingStyle(Style style) {
		RenderingStyle rs = style.getRenderingStyle();
		if (rs == null) {
			StyleContainer styleContainer = style.getStyleContainer();
			if (styleContainer instanceof Style) {
				Style parentStyle = (Style) styleContainer;
				return getRenderingStyle(parentStyle);
			} else {
				return null;
			}
		} else {
			return rs;
		}
	}

	private static Double getTransparency(Style style) {
		Double trans = style.getTransparency();
		if (trans == null) {
			StyleContainer styleContainer = style.getStyleContainer();
			if (styleContainer instanceof Style) {
				Style parentStyle = (Style) styleContainer;
				return getTransparency(parentStyle);
			} else {
				return null;
			}
		} else {
			return trans;
		}
	}

	private static Orientation getVerticalAlignment(Style style) {
		Orientation va = style.getVerticalAlignment();
		if (va == null) {
			StyleContainer styleContainer = style.getStyleContainer();
			if (styleContainer instanceof Style) {
				Style parentStyle = (Style) styleContainer;
				return getVerticalAlignment(parentStyle);
			} else {
				return null;
			}
		} else {
			return va;
		}
	}

	private static Boolean isFilled(Style style) {
		Boolean filled = style.isFilled();
		if (filled == null) {
			StyleContainer styleContainer = style.getStyleContainer();
			if (styleContainer instanceof Style) {
				Style parentStyle = (Style) styleContainer;
				return isFilled(parentStyle);
			} else {
				return null;
			}
		} else {
			return filled;
		}
	}

	private static Boolean isLineVisible(Style style) {
		Boolean lv = style.isLineVisible();
		if (lv == null) {
			StyleContainer styleContainer = style.getStyleContainer();
			if (styleContainer instanceof Style) {
				Style parentStyle = (Style) styleContainer;
				return isLineVisible(parentStyle);
			} else {
				return null;
			}
		} else {
			return lv;
		}
	}

	private static Boolean isProportional(Style style) {
		Boolean prop = style.isProportional();
		if (prop == null) {
			StyleContainer styleContainer = style.getStyleContainer();
			if (styleContainer instanceof Style) {
				Style parentStyle = (Style) styleContainer;
				return isProportional(parentStyle);
			} else {
				return null;
			}
		} else {
			return prop;
		}
	}

	private static Boolean isStretchH(Style style) {
		Boolean sh = style.isStretchH();
		if (sh == null) {
			StyleContainer styleContainer = style.getStyleContainer();
			if (styleContainer instanceof Style) {
				Style parentStyle = (Style) styleContainer;
				return isStretchH(parentStyle);
			} else {
				return null;
			}
		} else {
			return sh;
		}
	}

	private static Boolean isStretchV(Style style) {
		Boolean sv = style.isStretchV();
		if (sv == null) {
			StyleContainer styleContainer = style.getStyleContainer();
			if (styleContainer instanceof Style) {
				Style parentStyle = (Style) styleContainer;
				return isStretchV(parentStyle);
			} else {
				return null;
			}
		} else {
			return sv;
		}
	}
}
