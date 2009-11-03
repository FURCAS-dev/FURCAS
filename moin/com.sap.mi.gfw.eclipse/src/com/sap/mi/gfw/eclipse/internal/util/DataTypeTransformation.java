package com.sap.mi.gfw.eclipse.internal.util;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.draw2d.AbsoluteBendpoint;
import org.eclipse.draw2d.Bendpoint;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.RGB;

import com.sap.mi.gfw.datatypes.IInsets;
import com.sap.mi.gfw.datatypes.impl.InsetsImpl;
import com.sap.mi.gfw.eclipse.internal.IResourceRegistry;
import com.sap.mi.gfw.eclipse.internal.IResourceRegistryHolder;
import com.sap.mi.gfw.mm.datatypes.Point;
import com.sap.mi.gfw.mm.pictograms.AbstractText;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.mi.gfw.mm.pictograms.Font;
import com.sap.mi.gfw.mm.pictograms.LineStyleEnum;
import com.sap.mi.gfw.util.GaUtil;
import com.sap.mi.gfw.util.IColorConstant;

public class DataTypeTransformation {

	public static org.eclipse.draw2d.geometry.Point toDraw2dPoint(Point pictogramsPoint) {
		org.eclipse.draw2d.geometry.Point ret = new org.eclipse.draw2d.geometry.Point();
		syncToDraw2dPoint(pictogramsPoint, ret);
		return ret;
	}

	public static Bendpoint toDraw2dBendPoint(Point pictogramsPoint) {
		Bendpoint ret = new AbsoluteBendpoint(toDraw2dPoint(pictogramsPoint));
		return ret;
	}

	public static void syncToDraw2dPoint(Point pictogramsPoint, org.eclipse.draw2d.geometry.Point draw2dPoint) {
		if (pictogramsPoint != null) {
			draw2dPoint.x = pictogramsPoint.getX();
			draw2dPoint.y = pictogramsPoint.getY();
		}
	}

	public static Color toSwtColor(IResourceRegistryHolder rrh, com.sap.mi.gfw.mm.datatypes.Color pictogramsColor) {
		IResourceRegistry rr = rrh.getResourceRegistry();
		if (pictogramsColor != null)
			return rr.getSwtColor(pictogramsColor.getRed(), pictogramsColor.getGreen(), pictogramsColor.getBlue());
		else
			return rr.getSwtColor(100, 100, 100);
	}

	public static Color toSwtColor(IResourceRegistryHolder rrh, IColorConstant color) {
		IResourceRegistry rr = rrh.getResourceRegistry();
		if (color != null)
			return rr.getSwtColor(color.getRed(), color.getGreen(), color.getBlue());
		else
			return rr.getSwtColor(100, 100, 100);
	}

	public static Color toSwtColor(IResourceRegistryHolder rrh, int red, int green, int blue) {
		IResourceRegistry rr = rrh.getResourceRegistry();
		return rr.getSwtColor(red, green, blue);
	}

	// public static Color toSwtColor(com.sap.mi.gfw.mm.datatypes.Color
	// pictogramsColor) {
	// if (pictogramsColor != null)
	// return new Color(null, pictogramsColor.getRed(),
	// pictogramsColor.getGreen(), pictogramsColor.getBlue());
	// else
	// return new Color(null, 100, 100, 100);
	// }
	//
	// public static Color toSwtColor(IColorConstant color) {
	// if (color != null)
	// return new Color(null, color.getRed(), color.getGreen(),
	// color.getBlue());
	// else
	// return new Color(null, 100, 100, 100);
	// }
	//
	public static com.sap.mi.gfw.mm.datatypes.Color toPictogramsColor(Color swtColor, Diagram diagram) {
		return GaUtil.manageColor(diagram, swtColor.getRed(), swtColor.getGreen(), swtColor.getBlue());

	}

	public static com.sap.mi.gfw.mm.datatypes.Color toPictogramsColor(RGB rgb, Diagram diagram) {
		return GaUtil.manageColor(diagram, rgb.red, rgb.green, rgb.blue);

	}

	public static PointList toDraw2dPointList(Collection points) {
		PointList pointList = new PointList();
		for (Iterator iter = points.iterator(); iter.hasNext();) {
			Point dtp = (Point) iter.next();
			pointList.addPoint(dtp.getX(), dtp.getY());
		}
		return pointList;
	}

	public static org.eclipse.swt.graphics.Font syncToSwtFont(Font pictogramFont, org.eclipse.swt.graphics.Font swtFont) {
		org.eclipse.swt.graphics.Font ret = swtFont;

		FontData fontDataFromPictogramFont = toFontData(pictogramFont);
		FontData fontDataFromSwtFont = swtFont.getFontData()[0];

		if (!fontDataFromPictogramFont.equals(fontDataFromSwtFont)) {
			ret = toSwtFont(pictogramFont);
		}

		return ret;
	}

	/**
	 * @param swtFont
	 * @return
	 */
	public static Font toPictogramsFont(AbstractText text, org.eclipse.swt.graphics.Font swtFont) {
		Font ret;

		FontData fontData = swtFont.getFontData()[0];
		ret = toPictogramsFont(text, fontData);

		return ret;
	}

	/**
	 * @param fontData
	 * @return
	 */
	public static Font toPictogramsFont(AbstractText text, FontData fontData) {
		if (fontData == null) {
			return null;
		}
		Font ret;
		String name = fontData.getName();
		int height = fontData.getHeight();
		boolean italic = (fontData.getStyle() & SWT.ITALIC) != 0;
		boolean bold = (fontData.getStyle() & SWT.BOLD) != 0;
		ret = GaUtil.createFont(text, name, height, italic, bold);
		return ret;
	}

	/**
	 * @param pictogramFont
	 * @return
	 */
	public static org.eclipse.swt.graphics.Font toSwtFont(Font pictogramFont) {
		FontData fontData;
		fontData = toFontData(pictogramFont);
		return new org.eclipse.swt.graphics.Font(null, new FontData[] { fontData });
	}

	/**
	 * @param pictogramFont
	 * @return
	 */
	public static FontData toFontData(Font pictogramFont) {
		FontData fontData;
		if (pictogramFont != null) {
			int style = SWT.NORMAL;
			if (pictogramFont.isItalic()) {
				style |= SWT.ITALIC;
			}
			if (pictogramFont.isBold()) {
				style |= SWT.BOLD;
			}
			int size = pictogramFont.getSize();
			String name = pictogramFont.getName();
			fontData = new FontData(name, size, style);
		} else {
			fontData = new FontData();
		}
		return fontData;
	}

	public static int toDraw2dLineStyle(LineStyleEnum lineStyle) {
		int draw2dLineStyle = Graphics.LINE_SOLID;
		if (lineStyle == LineStyleEnum.DASH) {
			draw2dLineStyle = Graphics.LINE_DASH;
		} else if (lineStyle == LineStyleEnum.DASHDOT) {
			draw2dLineStyle = Graphics.LINE_DASHDOT;
		} else if (lineStyle == LineStyleEnum.DASHDOTDOT) {
			draw2dLineStyle = Graphics.LINE_DASHDOTDOT;
		} else if (lineStyle == LineStyleEnum.DOT) {
			draw2dLineStyle = Graphics.LINE_DOT;
		} else if (lineStyle == LineStyleEnum.SOLID) {
			draw2dLineStyle = Graphics.LINE_SOLID;
		}
		return draw2dLineStyle;
	}

	public static IInsets toGfwInsets(Insets draw2dInsets) {
		if (draw2dInsets != null) {
			return new InsetsImpl(draw2dInsets.left, draw2dInsets.right, draw2dInsets.top, draw2dInsets.bottom);
		} else {
			return new InsetsImpl(0, 0, 0, 0);
		}
	}

	public static Insets toDraw2dInsets(IInsets gfwInsets) {
		if (gfwInsets != null) {
			return new Insets(gfwInsets.getTop(), gfwInsets.getLeft(), gfwInsets.getBottom(), gfwInsets.getRight());
		} else {
			return new Insets(0);
		}
	}
}