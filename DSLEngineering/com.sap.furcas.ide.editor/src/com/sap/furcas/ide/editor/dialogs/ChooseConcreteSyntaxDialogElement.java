package com.sap.furcas.ide.editor.dialogs;

import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.runtime.tcs.TcsUtil;

public class ChooseConcreteSyntaxDialogElement 
{
	private final EObject wrappedObject;
	
	public ChooseConcreteSyntaxDialogElement(EObject wrappedObject)
	{
		this.wrappedObject = wrappedObject;
	}

	@Override
	public String toString() 
	{
		StringBuffer sb = new StringBuffer();
		if(this.wrappedObject instanceof Template)
		{
			Template t = (Template) wrappedObject;
			sb.append(t.getConcreteSyntax().getName());
			sb.append(":");
			sb.append(TcsUtil.getQualifiedName(t));
			sb.append(":mode=");
			sb.append(TcsUtil.getTemplateMode(t));
		}
		return sb.toString();
	}
	
	public EObject getWrappedObject()
	{
		return this.wrappedObject;
	}
}
