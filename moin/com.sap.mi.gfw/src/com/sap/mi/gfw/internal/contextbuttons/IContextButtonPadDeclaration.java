package com.sap.mi.gfw.internal.contextbuttons;

import java.awt.Rectangle;
import java.util.List;

import com.sap.mi.gfw.util.IColorConstant;

/**
 * This interface provides the visual definition for the context button pad.
 * <p>
 * The context button pad consists of three pads (top, right, bottom), which are slightly overlapping, so that they build one coherent area.
 * Several context buttons are placed inside those three pads and also outside (e.g. the collapse button).
 */
public interface IContextButtonPadDeclaration {

	public enum PadStyle {
		STANDARD, APPENDAGE
	};

	/**
	 * Returns the context buttons to be placed on the context button pad. Each {@link PositionedContextButton} contains information about
	 * the visual definition of the context button.
	 * 
	 * @return The context buttons to be placed on the context button pad.
	 */
	List<PositionedContextButton> getPositionedContextButtons();

	/**
	 * Returns the rectangular bounds of the top pad. Can be null.
	 * 
	 * @return The rectangular bounds of the top pad. Can be null.
	 */
	Rectangle getTopPad();

	/**
	 * Returns the rectangular bounds of the right pad. Can be null.
	 * 
	 * @return The rectangular bounds of the right pad. Can be null.
	 */
	Rectangle getRightPad();

	/**
	 * Returns the rectangular bounds of the bottom pad. Can be null.
	 * 
	 * @return The rectangular bounds of the bottom pad. Can be null.
	 */
	Rectangle getBottomPad();

	/**
	 * Returns the top pad style.
	 * 
	 * @return The top pad style.
	 */
	PadStyle getTopPadStyle();

	/**
	 * Returns the top pad style.
	 * 
	 * @return The top pad style.
	 */
	PadStyle getRightPadStyle();

	/**
	 * Returns the rectangular bounds around all visible areas of the context button pad. They might or might not overlap. A point is
	 * defined to be on the context button pad, if it is inside one of those rectangles.
	 * 
	 * @return The rectangular bounds around all visible areas of the context button pad.
	 */
	List<Rectangle> getContainmentRectangles();

	/**
	 * Returns the overlapping rectangular bounds around all visible areas of the context button pad. All rectangles overlap and build an
	 * area, which has no free space in the middle. A point is defined to be on or inside the context button pad, if it is inside one of
	 * those rectangles.
	 * 
	 * @return The overlapping rectangular bounds around all visible areas of the context button pad.
	 */
	List<Rectangle> getOverlappingContainmentRectangles();

	/**
	 * Returns the corner radius which is used to paint all corners of the pad.
	 * 
	 * @return The corner radius which is used to paint all corners of the pad.
	 */
	int getPadCornerRadius();

	/**
	 * Returns the line width which is used to paint the outline of the pad.
	 * 
	 * @return The line width which is used to paint the outline of the pad.
	 */
	int getPadLineWidth();

	/**
	 * Returns the color in which the outer line of the pads outline is painted. Note, that the pad is outlined with three adjacent lines
	 * (outer, middle, inner) and then filled inside.
	 * 
	 * @return The color in which the outer line of the pads outline is painted.
	 */
	IColorConstant getPadOuterLineColor();

	/**
	 * Returns the color in which the middle line of the pads outline is painted. Note, that the pad is outlined with three adjacent lines
	 * (outer, middle, inner) and then filled inside.
	 * 
	 * @return The color in which the middle line of the pads outline is painted.
	 */
	IColorConstant getPadMiddleLineColor();

	/**
	 * Returns the color in which the inner line of the pads outline is painted. Note, that the pad is outlined with three adjacent lines
	 * (outer, middle, inner) and then filled inside.
	 * 
	 * @return The color in which the inner line of the pads outline is painted.
	 */
	IColorConstant getPadInnerLineColor();

	/**
	 * Returns the color in which the pads outline is filled. Note, that the pad is outlined with three adjacent lines (outer, middle,
	 * inner) and then filled inside.
	 * 
	 * @return The color in which the pads outline is filled.
	 */
	IColorConstant getPadFillColor();

	/**
	 * Returns the opacity which is used when painting the pad. Possible values are between 0.0 (invisible, transparent) and 1.0 (completely
	 * visible, opaque).
	 * 
	 * @return The opacity which is used when painting the pad.
	 */
	double getPadDefaultOpacity();
}
