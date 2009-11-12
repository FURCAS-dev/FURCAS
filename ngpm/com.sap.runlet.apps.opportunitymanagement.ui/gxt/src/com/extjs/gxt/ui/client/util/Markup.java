/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.client.util;

/**
 * Raw html content.
 */
public class Markup {

  public static String BOTTOM_BOX;

  public static String BOX;

  public static String BBOX;

  public static String SHADOW;

  public static String TREETABLE_ITEM;

  static {
    StringBuffer sb = new StringBuffer();
    sb.append("<div class={0}-tl><div class={0}-tr><div class={0}-tc></div></div></div>");
    sb.append("<div class={0}-ml><div class={0}-mr><div class={0}-mc></div></div></div>");
    sb.append("<div class={0}-bl><div class={0}-br><div class={0}-bc></div></div></div>");

    BBOX = sb.toString();

    sb = new StringBuffer();
    sb.append("<div><table class={0} cellpadding=0 cellspacing=0><tbody>");
    sb.append("<tr><td class={0}-ml><div></div></td><td class={0}-mc></td><td class={0}-mr><div></div></td></tr>");
    sb.append("<tr><td class={0}-bl><div></div></td><td class={0}-bc></td><td class={0}-br><div></div></td></tr>");
    sb.append("</tbody></table></div>");

    BOTTOM_BOX = sb.toString();

    sb = new StringBuffer();
    sb.append("<table class={0} cellpadding=0 cellspacing=0><tbody>");
    sb.append("<tr class={0}-trow><td class={0}-tl><div>&nbsp;</div></td><td class={0}-tc></td><td class={0}-tr><div>&nbsp;</div></td></tr>");
    sb.append("<tr><td class={0}-ml></td><td class={0}-mc></td><td class={0}-mr></td></tr>");
    sb.append("<tr class={0}-brow><td class={0}-bl></td><td class={0}-bc></td><td class={0}-br></td></tr>");
    sb.append("</tr></tbody></table>");

    BOX = sb.toString();

    sb = new StringBuffer();
    sb.append("<div class=x-shadow><div class=xst><div class=xstl></div><div class=xstc></div><div class=xstr></div></div><div class=xsc><div class=xsml></div><div class=xsmc></div><div class=xsmr></div></div><div class=xsb><div class=xsbl></div><div class=xsbc></div><div class=xsbr></div></div></div>");

    SHADOW = sb.toString();

    sb = new StringBuffer();
    sb.append("<div class=my-treetbl-item><table cellpadding=0 cellspacing=0 style='table-layout: fixed;'><tbody><tr>");
    sb.append("<td class=my-treetbl-cell index=0><div class=my-treetbl-cell-overflow><div class=my-treetbl-cell-text>");
    sb.append("<table cellpadding=0 cellspacing=0>");
    sb.append("<tbody><tr><td><div class=my-treetbl-indent></div></td>");
    sb.append("<td class=my-treetbl-joint align=center valign=middle><div>&nbsp;</div></td>");
    sb.append("<td class=my-treetbl-left><div></div></td>");
    sb.append("<td class=my-treetbl-check><div class=my-treetbl-notchecked></div></td>");
    sb.append("<td class=my-treetbl-icon><div>&nbsp;</div></td>");
    sb.append("<td class=my-treetbl-item-text><span>{0}</span></td>");
    sb.append("<td class=my-treetbl-right><div></div></td></tr></tbody></table></div></div></td></tr></tbody></table></div>");
    sb.append("<div class=my-treetbl-ct style='display: none'></div>");

    TREETABLE_ITEM = sb.toString();

  }

}
