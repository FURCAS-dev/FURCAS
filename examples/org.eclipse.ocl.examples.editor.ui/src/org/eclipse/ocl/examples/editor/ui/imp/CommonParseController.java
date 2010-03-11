/**
 * <copyright>
 * 
 * Copyright (c) 2008,2010 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Robert Fuhrer (rfuhrer@watson.ibm.com) - initial API and implementation
 * E.D.Willink - abstracted API for common editing framework
 * 
 * </copyright>
 *
 * $Id: CommonParseController.java,v 1.1 2010/03/11 14:51:20 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ui.imp;
/*******************************************************************************
* Copyright (c) 2007 IBM Corporation.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*    Robert Fuhrer (rfuhrer@watson.ibm.com) - initial API and implementation

*******************************************************************************/

import java.io.IOException;
import java.io.StringReader;
import java.util.Iterator;
import java.util.List;

import lpg.runtime.IToken;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.imp.core.ErrorHandler;
import org.eclipse.imp.language.Language;
import org.eclipse.imp.language.ServiceFactory;
import org.eclipse.imp.model.ISourceProject;
import org.eclipse.imp.parser.IMessageHandler;
import org.eclipse.imp.parser.ISourcePositionLocator;
import org.eclipse.imp.services.IAnnotationTypeInfo;
import org.eclipse.imp.services.ILanguageSyntaxProperties;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.ocl.examples.common.utils.TracingOption;
import org.eclipse.ocl.examples.editor.ui.ICreationFactory;
import org.eclipse.ocl.examples.editor.ui.OCLExamplesEditorPlugin;
import org.eclipse.ocl.examples.editor.ui.builder.MarkerProblemHandler;
import org.eclipse.ocl.examples.editor.ui.builder.ProblemLimit;
import org.eclipse.ocl.examples.modelregistry.eclipse.EclipseFileHandle;
import org.eclipse.ocl.examples.modelregistry.eclipse.EclipseProjectHandle;
import org.eclipse.ocl.examples.modelregistry.environment.FileHandle;
import org.eclipse.ocl.examples.parser.environment.ICSTFileEnvironment;
import org.eclipse.ocl.lpg.AbstractParser;
import org.eclipse.ocl.lpg.ProblemHandler;

/**
 * Base class for an IParseController implementation that encapsulates a simple LPG-based
 * scanner and parser.  Implements IParseController because methods defined there are
 * used here.
 * 
 * @author rfuhrer
 */
public abstract class CommonParseController implements ICommonParseController
{
	public static TracingOption parserProgress = new TracingOption(OCLExamplesEditorPlugin.PLUGIN_ID, "parser/progress");
	private static int counter = 0;
	
	protected final ICreationFactory creationFactory;
	protected final Language fLanguage;
    protected ISourceProject fProject;
    protected IPath fFilePath;
    protected IMessageHandler handler;   
    private ResourceSet resourceSet;
	private ICSTFileEnvironment<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> fileEnvironment;
    protected CommonParseResult fCurrentAst;
    private final CommonAnnotationTypeInfo fSimpleAnnotationTypeInfo = new CommonAnnotationTypeInfo();
	private final String id;
	private CommonParseHelper parseHelper = null;

    public CommonParseController(ICreationFactory creationFactory) {
		this.creationFactory = creationFactory;
        fLanguage= creationFactory.getLanguage();
		id = getClass().getSimpleName() + "-" + ++ counter;
		if (parserProgress.isActive())
			parserProgress.println(id + " created");
		getAnnotationTypeInfo().addProblemMarkerType(creationFactory.getErrorMarkerId());
	}

	protected ICSTFileEnvironment<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> createEnvironment(FileHandle fileHandle) {
		if (resourceSet == null) {
			resourceSet = createResourceSet();
			initializeResourceSet(resourceSet);
		}
		URI astURI = fileHandle.getURI().appendFileExtension(creationFactory.getXMLExtension());
		return creationFactory.createFileEnvironment(fileHandle, resourceSet, astURI);
	}

	protected ICommonKeyword createKeyword(String text) {
		return new CommonKeyword(text);
	}

	protected CommonParseHelper createParseHelper(AbstractParser parser) {
		return new CommonParseHelper(parser);
	}

	protected CommonParseResult createParsedResult(ICSTFileEnvironment<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> fileEnvironment) {
		return new CommonParseResult(this, fileEnvironment);
	}

	protected ProblemHandler createProblemHandler(ICSTFileEnvironment<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> environment) {
		if (handler instanceof ProblemHandler) {
			((ProblemHandler)handler).setParser(environment.getParser());
			if (handler instanceof MarkerProblemHandler<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?>)
				((MarkerProblemHandler<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?>)handler).setProblemLimit(new ProblemLimit(50, 50, 50));
			return (ProblemHandler) handler;
		}
		else {
			CommonProblemHandler commonProblemHandler = new CommonProblemHandler(environment.getParser(), handler);
			commonProblemHandler.setProblemLimit(new ProblemLimit(50, 50, 50));
			return commonProblemHandler;
		}
	}

	protected ResourceSet createResourceSet() {
		return new ResourceSetImpl();
	}
	
    public IAnnotationTypeInfo getAnnotationTypeInfo() {
        return fSimpleAnnotationTypeInfo;
    }

    public ICreationFactory getCreationFactory() {
		return creationFactory;
	}

	public CommonParseResult getCurrentAst() {
    	return fCurrentAst;
    }

	public CommonParseResult getCurrentResult() {
    	return fCurrentAst;
    }

	protected FileHandle getFileHandle() {
		IProject rawProject = fProject.getRawProject();
		EclipseProjectHandle projectHandle = new EclipseProjectHandle(rawProject);
		EclipseFileHandle fileHandle = projectHandle.getFileHandle(fFilePath.toString());
		return fileHandle;
	}

    public IMessageHandler getHandler() {
    	return handler;
    }

	public List<ICommonKeyword> getKeywords() {
		return parseHelper != null ? parseHelper.getKeywords() : null;
	}

	public ILabelProvider getLabelProvider() {
		return ServiceFactory.getInstance().getLabelProvider(fLanguage);
	}

    public Language getLanguage() {
        return fLanguage;
    }

	@Deprecated // Use getSourcePositionLocator()
	public final ISourcePositionLocator getNodeLocator() {
		return getSourcePositionLocator();
	}

    public IPath getPath() {
    	return fFilePath;
    }

    public ISourceProject getProject() {
    	return fProject;
    }

	public ResourceSet getResourceSet() {
		return resourceSet;
	}

    @Deprecated // use method on ParsedResult
	public ISourcePositionLocator getSourcePositionLocator() {
//		throw new UnsupportedOperationException(getClass().getSimpleName() + ".getSourcePositionLocator");
		if (fCurrentAst == null)
			return null;
		return fCurrentAst.getSourcePositionLocator();
	}

	public ILanguageSyntaxProperties getSyntaxProperties() {
		return null;
	}
	
    @Deprecated // use method on ParsedResult
	public Iterator<IToken> getTokenIterator(final IRegion region) {
//		throw new UnsupportedOperationException(getClass().getSimpleName() + ".getTokenIterator");
		if (fCurrentAst != null)
			 return fCurrentAst.getTokenIterator(region);
		else
			return new CommonParseResult.NullTokenIterator();
    }

    /*
     * Defined in the IParseController interface.  The implementation here serves
     * as a super method to support initialization of lexer and parser in a concrete
     * subtype where the concrete lexer and parser types are known.
     * 
     * The handler parameter is required by the IParseController interface and is
     * used in a concrete subtype along with a concrete parser type.
     */
    public void initialize(IPath filePath, ISourceProject project, IMessageHandler handler) {
		this.fProject= project;
		this.fFilePath= filePath;	
		this.handler = handler;
		if (parserProgress.isActive())
			parserProgress.println(id + " initialized for " + fFilePath.toString());
    }

	protected void initializeResourceSet(ResourceSet resourceSet) {}

    public boolean isCompleteable(int kind) {
    	switch (getTokenKind(kind)) {
	    	case IDENTIFIER:
	    	case INTEGER:
	    	case KEYWORD:
	    	case REAL:
	    	case STRING:
	    		return true;
	    }
    	return false;
    }

    public boolean isIdentifier(int kind) {
    	return getTokenKind(kind) == TokenKind.IDENTIFIER;
    }

    public boolean isKeyword(int kind) {
		return parseHelper != null ? parseHelper.isKeyword(kind) : false;
    }

    public CommonParseResult parse(String contents, IProgressMonitor progressMonitor) {
		fCurrentAst = parseWithoutCaching(contents, progressMonitor);
		// FIXME my_monitor
		return fCurrentAst;
	}

    // FIXME This is a workaround to Bug 257627
    public CommonParseResult parseWithoutCaching(String contents, IProgressMonitor progressMonitor) {
		if (parserProgress.isActive())
			parserProgress.println(id + " Parse " + fFilePath.toString() + " " + fLanguage + " handler = " + handler.getClass().getName());
		if (progressMonitor.isCanceled())
			return fCurrentAst;
		if (fileEnvironment == null)
			fileEnvironment = createEnvironment(getFileHandle());
		fileEnvironment.setProblemHandler(createProblemHandler(fileEnvironment));
		CommonParseResult newResult = null;
		try {
			CommonParseResult workingResult = createParsedResult(fileEnvironment);
			workingResult.parse(new StringReader(contents), progressMonitor);
			newResult = workingResult;
			if (parseHelper == null)
				parseHelper = createParseHelper(newResult.getParser());
		} catch (IOException e) {
            ErrorHandler.reportError("Failed to parse language " + getLanguage().getName() + " and input " + getPath() + ":", e);
		} catch (CoreException e) {
            ErrorHandler.reportError("Failed to parse language " + getLanguage().getName() + " and input " + getPath() + ":", e);
		}
		return newResult;
	}

	public void setResourceSet(ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
	}
}
