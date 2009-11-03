/**
 * 
 */
package com.sap.mi.gfw.pattern.template;

import com.sap.mi.gfw.mm.datatypes.Point;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.Polygon;
import com.sap.mi.gfw.mm.pictograms.Polyline;
import com.sap.mi.gfw.mm.pictograms.Shape;
import com.sap.mi.gfw.util.GaUtil;

/**
 * Allows to place {@link Point} objects into or relative to a {@link GraphicsAlgorithm} .
 * 
 * @author d023588 Typically this binder is used to layout the points of a {@link Polyline} or {@link Polygon} relative
 *         the the {@link Polyline} or {@link Polygon} itself. But the class can also layout other points.
 */
public class PointPositionBinder extends PositionBinder {

    /**
     * Creates a {@link PointPositionBinder} from {@link XPath} of the source {@link GraphicsAlgorithm} and target
     * {@link Point} .
     * 
     * @param fromGAPath
     *            The {@link XPath} to the {@link GraphicsAlgorithm} from with the coordinates are taken to update the
     *            {@link Point} specified in toPointPath.
     * @param toPointPath
     *            The {@link Point} to be updated according to the settings in the other parameters.
     * @param xpos
     *            The {@link XPositions} policy for the placement of the Point.
     * @param ypos
     *            The {@link YPositions} policy for the placement of the Point.
     * @param xoffset
     *            The pixel offset relative to xpos or the percentage of fromGAPath's width, if xpos is
     *            {@link XPositions.Percent} .
     * @param yoffset
     *            The pixel offset relative to ypos or the percentage of fromGAPath's height, if ypos is
     *            {@link YPositions.Percent} .
     */
    public PointPositionBinder(String fromGAPath, String toPointPath, XPositions xpos, YPositions ypos, int xoffset, int yoffset) {
        super(fromGAPath, toPointPath, xpos, ypos, false);
        this.xoffset = xoffset;
        this.yoffset = yoffset;
    }

    /**
     * Convenience constructor to use {@link PositionBinder} with {@link Polyline} or {@link Polygon}.
     * 
     * @param mainShape
     *            The main shape of the pattern (used to calculate the {@link XPath} to polygon and the points.
     * @param polygon
     *            The {@link Polygon} or {@link Polyline} (or other GA that has a points collection).
     * @param point
     *            The 0-based index of the point that should be updated by this binder.
     * @param xpos
     *            The {@link XPositions} policy for the placement of the Point.
     * @param ypos
     *            The {@link YPositions} policy for the placement of the Point.
     * @param xoffset
     *            The pixel offset relative to xpos or the percentage of fromGAPath's width, if xpos is
     *            {@link XPositions.Percent} .
     * @param yoffset
     *            The pixel offset relative to ypos or the percentage of fromGAPath's height, if ypos is
     *            {@link YPositions.Percent} .
     */
    public PointPositionBinder(Shape mainShape, GraphicsAlgorithm polygon, int point, XPositions xpos, YPositions ypos, int xoffset,
            int yoffset) {
        this(XPath.calculatePath(mainShape, polygon), XPath.calculatePath(mainShape, polygon) + "/points[" + Integer.toString(point) + "]", //$NON-NLS-1$//$NON-NLS-2$
                xpos, ypos, xoffset, yoffset);
    }

    @Override
    public void layout(Shape mainShape) {

        GraphicsAlgorithm fromGa = (GraphicsAlgorithm) XPath.getValue(mainShape, fromPath);
        if (fromGa != null) {

            GraphicsAlgorithm dummy = GaUtil.createRectangle(fromGa);
            dummy.setX((Integer) XPath.getValue(mainShape, toPath + "/x")); //$NON-NLS-1$
            dummy.setY((Integer) XPath.getValue(mainShape, toPath + "/y")); //$NON-NLS-1$
            doLayout(dummy, fromGa);
            XPath.setValue(mainShape, toPath, GaUtil.createPoint(fromGa, dummy.getX(), dummy.getY()));
            dummy.refDelete();

        }
    }

}
