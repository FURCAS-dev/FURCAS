package com.sap.ide.cts.editor.prettyprint.imported;

import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.TCS.SequenceElement;
import com.sap.furcas.metamodel.TCS.Template;

public class DebugPrintTCSExtractorStream implements TCSExtractorStream {

	TCSExtractorStream target;

	public DebugPrintTCSExtractorStream(TCSExtractorStream target) {
		this.target = target;
	}

	private void print(String msg) {
		System.out.println(msg);
	}

	@Override
	public void close() {
		print("<CLOSE>");
		target.close();
	}

	@Override
	public void debug(String string) {
		print(string);
		target.debug(string);
	}

	@Override
	public void endClassTemplate(int handle) {
		print("<END_CLASSTEMPLATE with handle: " + handle + ">");
		target.endClassTemplate(handle);
	}

	@Override
	public void resetToSafePoint(int handle) {
		print("<RESET_TO_SAFEPOINT " + handle + ">");
		target.resetToSafePoint(handle);

	}

	@Override
	public void printBoolean(boolean v) {
		print("" + v);
		target.printBoolean(v);
	}

	@Override
	public void printComment(String c) {
		print(c);
		target.printComment(c);
	}

	@Override
	public void printEscapedIdentifier(String identEscStart, String ident,
			String identEscEnd) {
		print(identEscStart + ident + identEscEnd);
		target.printEscapedIdentifier(identEscStart, ident, identEscEnd);
	}

	@Override
	public void printIdentifier(String ident) {
		print(ident);
		target.printIdentifier(ident);
	}

	@Override
	public void printInteger(int v) {
		print("" + v);
		target.printInteger(v);
	}

	@Override
	public void printKeyword(String keyword) {
		print(keyword);
		target.printKeyword(keyword);
	}

	@Override
	public void printReal(String string) {
		print(string);
		target.printReal(string);
	}

	@Override
	public void printString(String stringDelim, String v) {
		print(stringDelim + v + stringDelim);
		target.printString(stringDelim, v);
	}

	@Override
	public void printSymbol(String symbol) {
		print(symbol);
		target.printSymbol(symbol);
	}

	@Override
	public void printWhiteSpace(String ws) {
		print(ws);
		target.printWhiteSpace(ws);
	}

	@Override
	public int createSafePoint() {
		int handle = target.createSafePoint();
		print("<CREATE_SAFEPOINT " + handle + ">");
		return handle;
	}

	@Override
	public int startClassTemplateForObject(EObject object, Template template) {
		int handle = target.startClassTemplateForObject(object, template);
		print("<START_CLASSTEMPLATE with handle: " + handle + ">");
		return handle;
	}

	@Override
	public void enterSequenceElement(SequenceElement e) {
		print("<ENTER_SEQ_ELEM>");
		target.enterSequenceElement(e);

	}

	@Override
	public void exitSequenceElement() {
		print("<EXIT_SEQ_ELEM>");
		target.exitSequenceElement();

	}

	@Override
	public void printDefault(String value)
	{
		target.printDefault(value);
	}

}
