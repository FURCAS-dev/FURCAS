/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2009-04-23 14:54:43 +0200 (Do, 23 Apr 2009) $
 * @version $Revision: 6272 $
 * @author: $Author: c5106462 $
 *******************************************************************************/
package com.sap.furcas.parsergenerator;

import java.util.Map;

import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.runtime.parser.TextLocation;

/**
 * Data Object to transport a syntax definition and the keywords used in that syntax.
 * 
 * @author C5107456
 */
public class TCSSyntaxContainerBean {

    private ConcreteSyntax syntax;
    private Map<Object, TextLocation> elementToLocationMap;

    public ConcreteSyntax getSyntax() {
        return syntax;
    }

    public void setSyntax(ConcreteSyntax syntax) {
        this.syntax = syntax;
    }

    public Map<Object, TextLocation> getElementToLocationMap() {
        return elementToLocationMap;
    }

    public void setElementToLocationMap(Map<Object, TextLocation> elementToLocationMap) {
        this.elementToLocationMap = elementToLocationMap;
    }

}
