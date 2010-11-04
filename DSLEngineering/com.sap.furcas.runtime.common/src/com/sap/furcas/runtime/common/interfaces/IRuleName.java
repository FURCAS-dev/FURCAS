package com.sap.furcas.runtime.common.interfaces;

import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.runtime.common.exceptions.SyntaxElementException;


public interface IRuleName {

	public String getRuleName(Template tmpl, String mode) throws SyntaxElementException;
}
