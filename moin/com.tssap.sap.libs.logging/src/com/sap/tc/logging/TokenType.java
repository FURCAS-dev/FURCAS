/*
 * Created on Mar 2, 2004
 * Created by D036224
 */
package com.sap.tc.logging;

/**
 * @author D036224
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class TokenType {

  public static final int UNKNOWN  = -1,
						  NONE     = 0,
						  UNPARSED = NONE + 1,
						  IDENT    = UNPARSED + 1;
  public static final int MAX      = IDENT;

}
