package com.sap.mi.gfw.pattern.template;

import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.Shape;

/**
 * The Class PositionBinder.
 */
public class PositionBinder extends LayoutBinder {

    protected XPositions xpos;
    protected YPositions ypos;
    protected boolean absolute;
    protected int xoffset = 0;
    protected int yoffset = 0;

    /**
     * Instantiates a new position binder.
     * 
     * @param fromPath
     *            the from path
     * @param toPath
     *            the to path
     * @param xpos
     *            the xpos
     * @param ypos
     *            the ypos
     * @param absolute
     *            the absolute
     */
    public PositionBinder(String fromPath, String toPath, XPositions xpos, YPositions ypos, boolean absolute) {
        super(fromPath, toPath);
        this.xpos = xpos;
        this.ypos = ypos;
        this.absolute = absolute;
    }

    /**
     * Instantiates a new position binder.
     * 
     * @param toPath
     *            the to path
     * @param xpos
     *            the xpos
     * @param ypos
     *            the ypos
     */
    public PositionBinder(String toPath, XPositions xpos, YPositions ypos) {
        this(PARENT, toPath, xpos, ypos, false);
    }

    /**
     * Instantiates a new position binder.
     * 
     * @param mainShape
     *            the main shape
     * @param gaFrom
     *            the ga from
     * @param gaTo
     *            the ga to
     * @param xpos
     *            the xpos
     * @param ypos
     *            the ypos
     * @param absolute
     *            the absolute
     */
    public PositionBinder(Shape mainShape, GraphicsAlgorithm gaFrom, GraphicsAlgorithm gaTo, XPositions xpos, YPositions ypos,
            boolean absolute) {
        this(XPath.calculatePath(mainShape, gaFrom), XPath.calculatePath(mainShape, gaTo), xpos, ypos, absolute);
        xoffset = gaTo.getX();
        yoffset = gaTo.getY();
    }

    /**
     * Instantiates a new position binder.
     * 
     * @param mainShape
     *            the main shape
     * @param gaFrom
     *            the ga from
     * @param gaTo
     *            the ga to
     * @param xpos
     *            the xpos
     * @param ypos
     *            the ypos
     */
    public PositionBinder(Shape mainShape, GraphicsAlgorithm gaFrom, GraphicsAlgorithm gaTo, XPositions xpos, YPositions ypos) {
        this(mainShape, gaFrom, gaTo, xpos, ypos, false);
    }

    /**
     * Instantiates a new position binder.
     * 
     * @param mainShape
     *            the main shape
     * @param gaTo
     *            the ga to
     * @param xpos
     *            the xpos
     * @param ypos
     *            the ypos
     */
    public PositionBinder(Shape mainShape, GraphicsAlgorithm gaTo, XPositions xpos, YPositions ypos) {
        this(PARENT, XPath.calculatePath(mainShape, gaTo), xpos, ypos, false);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.gfw.pattern.template.LayoutBinder#doLayout(com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm,
     * com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm)
     */
    @Override
    protected void doLayout(GraphicsAlgorithm ga, GraphicsAlgorithm parentGa) {
        int xoffset = this.xoffset;
        int yoffset = this.yoffset;
        if (absolute) {
            xoffset += parentGa.getX();
            yoffset += parentGa.getY();
        }
        switch (xpos) {
        case Left:
            ga.setX(xoffset);
            break;

        case Middle:
            ga.setX(xoffset + parentGa.getWidth() / 2 - ga.getWidth() / 2);
            break;
        case Right:
            ga.setX(xoffset + parentGa.getWidth() - ga.getWidth());
            break;
        case Percent:
            ga.setX(parentGa.getWidth() * xoffset / 100);
            break;
        }

        switch (ypos) {
        case Top:
            ga.setY(yoffset);
            break;

        case Middle:
            ga.setY(yoffset + parentGa.getHeight() / 2 - ga.getHeight() / 2);
            break;
        case Below:
            ga.setY(yoffset + parentGa.getHeight());
            break;
        case Above:
            ga.setY(yoffset - ga.getHeight());
            break;
        case Bottom:
            ga.setY(parentGa.getHeight() - ga.getHeight() - yoffset);
            break;
        case Percent:
            ga.setY(parentGa.getHeight() * yoffset / 100);
            break;
        }
    }
}
