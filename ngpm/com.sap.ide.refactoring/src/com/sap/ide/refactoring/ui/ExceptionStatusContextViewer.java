package com.sap.ide.refactoring.ui;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.ltk.core.refactoring.RefactoringStatusContext;
import org.eclipse.ltk.ui.refactoring.TextStatusContextViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

/**
 * Shows the exception message and stacktrace.
 * 
 * @author Stephan Erb (d049157)
 *
 */
public class ExceptionStatusContextViewer extends TextStatusContextViewer {

    @Override
    protected SourceViewer createSourceViewer(Composite parent) {
	SourceViewer viewer = new SourceViewer(parent, null, SWT.V_SCROLL | SWT.H_SCROLL | SWT.MULTI | SWT.FULL_SELECTION);
	viewer.configure(new SourceViewerConfiguration());
	return viewer;
    }

    @Override
    public void setInput(RefactoringStatusContext input) {
	assert input instanceof ExceptionStatusContext;  
	Throwable throwable = (Throwable) input.getCorrespondingElement();

	IDocument document = new Document(getStackTraceAsString(throwable));
	setInput(document, /* region */null);
    }

    public String getStackTraceAsString(Throwable throwable) {
	StringWriter sw = new StringWriter();
	PrintWriter pw = new PrintWriter(sw);
	pw.print(" [ ");
	pw.print(throwable.getClass().getName());
	pw.print(" ] ");
	pw.print(throwable.getMessage() + "\n\n");
	throwable.printStackTrace(pw);
	return sw.toString();
    }

}
