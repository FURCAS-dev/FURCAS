package com.sap.ide.cts.dialogs;

import tcs.Template;

import com.sap.furcas.textual.tcs.TcsUtil;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public class ChooseConcreteSyntaxDialogElement 
{
	private RefObject wrappedObject;
	
	public ChooseConcreteSyntaxDialogElement(RefObject wrappedObject)
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
			sb.append(t.getConcretesyntax().getName());
			sb.append(":");
			sb.append(TcsUtil.getQualifiedName(t));
			sb.append(":mode=");
			sb.append(TcsUtil.getTemplateMode(t));
		}
		return sb.toString();
	}
	
	public RefObject getWrappedObject()
	{
		return this.wrappedObject;
	}
}
