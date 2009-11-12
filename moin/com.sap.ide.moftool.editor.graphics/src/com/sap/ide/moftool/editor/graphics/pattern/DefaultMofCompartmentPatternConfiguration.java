package com.sap.ide.moftool.editor.graphics.pattern;

import com.sap.mi.gfw.util.IColorConstant;

public class DefaultMofCompartmentPatternConfiguration implements IMofCompartmentPatternConfiguration {

    private int lineWidth = 1;

    private int minimumHeight = 40;

    private int minimumWidth = 25;

    private int outerIndentTop = 2;

    private int outerIndentBottom = 2;

    private int outerIndentLeft = 5;

    private int outerIndentRight = 5;

    private IColorConstant foregroundColor = IColorConstant.BLACK;

    private IColorConstant backgroundColor = IColorConstant.WHITE;

    private IColorConstant textColor = IColorConstant.BLACK;

    private double transparency = 0;

    private int cornerHeight = 5;

    private int cornerWidth = 5;

    public IColorConstant getBackgroundColor() {
        return backgroundColor;
    }

    public int getCornerHeight() {
        return cornerHeight;
    }

    public int getCornerWidth() {
        return cornerWidth;
    }

    public IColorConstant getForegroundColor() {
        return foregroundColor;
    }

    /**
     * @return the lineWidth
     */
    public int getLineWidth() {
        return lineWidth;
    }

    public int getMinimumHeight() {
        return minimumHeight;
    }

    public int getMinimumWidth() {
        return minimumWidth;
    }

    public int getOuterIndentBottom() {
        return outerIndentBottom;
    }

    public int getOuterIndentLeft() {
        return outerIndentLeft;
    }

    public int getOuterIndentRight() {
        return outerIndentRight;
    }

    public int getOuterIndentTop() {
        return outerIndentTop;
    }

    public IColorConstant getTextColor() {
        return textColor;
    }

    public double getTransparency() {
        return transparency;
    }

    public void setBackgroundColor(IColorConstant color) {
        backgroundColor = color;
    }

    public void setForegroundColor(IColorConstant color) {
        foregroundColor = color;
    }

    /**
     * @param lineWidth the lineWidth to set
     */
    public void setLineWidth(int lineWidth) {
        this.lineWidth = lineWidth;
    }

    public void setMinimumHeight(int minimumHeight) {
        this.minimumHeight = minimumHeight;
    }

    public void setMinimumWidth(int minimumWidth) {
        this.minimumWidth = minimumWidth;
    }

    public void setOuterIndentBottom(int outerIndentBottom) {
        this.outerIndentBottom = outerIndentBottom;
    }

    public void setOuterIndentLeft(int outerIndentLeft) {
        this.outerIndentLeft = outerIndentLeft;
    }

    public void setOuterIndentRight(int outerIndentRight) {
        this.outerIndentRight = outerIndentRight;
    }

    public void setOuterIndentTop(int outerIndentTop) {
        this.outerIndentTop = outerIndentTop;
    }

    public void setTextColor(IColorConstant color) {
        textColor = color;
    }

    public void setTransparency(int t) {
        transparency = t;
    }

    public void setCornerHeight(int cornerHeight) {
        this.cornerHeight = cornerHeight;
    }

    public void setCornerWidth(int cornerWidth) {
        this.cornerWidth = cornerWidth;
    }

    public void setTransparency(double transparency) {
        this.transparency = transparency;
    }
}
