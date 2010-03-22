/**
 * <copyright>
 * 
 * Copyright (c) 2010 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: OCLForEcoreTestFile.java,v 1.1 2010/03/22 01:27:22 ewillink Exp $
 */
package org.eclipse.ocl.examples.test.editor;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.examples.editor.ocl.ui.ecore.OCLInEcoreSynchronizer;
import org.eclipse.ocl.examples.editor.ui.imp.CommonParseResult;
import org.eclipse.ocl.examples.modelregistry.model.ModelNameAccessor;
import org.eclipse.ocl.examples.parser.environment.ICSTRootEnvironment;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.part.FileEditorInput;

public class OCLForEcoreTestFile implements OCLTestFile
{
	public class InvariantChecker
	{
		private final Resource resource;
		private ICSTRootEnvironment<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> rootEnvironment;
		private final Map<String, Constraint> constraints = new HashMap<String, Constraint>();
		
		public InvariantChecker(CommonParseResult parseResult, EClass eClass) {
			this.resource = parseResult.getAST();
			rootEnvironment = parseResult.getRootEnvironment();
			for (EObject eObject : resource.getContents()) {
				if (eObject instanceof Constraint) {
					Constraint constraint = (Constraint) eObject;
					EList<EModelElement> constrainedElements = constraint.getConstrainedElements();
					if (!constrainedElements.isEmpty() && (constrainedElements.get(0) == eClass)) {
						constraints.put(constraint.getName(), constraint);
					}
				}
			}
		}
		
		public void checkConstraint(String when, String which, String what) {
			Constraint constraint = constraints.get(which);
			OCLExpression oclExpression = (OCLExpression) constraint.getSpecification().getBodyExpression();
			String expression = OCLInEcoreSynchronizer.getSourceText(rootEnvironment, oclExpression);
			TestCase.assertEquals(when, what, expression);
		}
		
		public void checkConstraints(String when, String... whiches) {
			Collection<String> constraintNames = constraints.keySet();		
			TestCase.assertEquals(when + " - constraint count", whiches.length, constraints.size());
			for (String which : whiches) {
				AbstractEditorTestCase.checkPresent(when, constraintNames, which);
			}
		}
	}

	private final IFile file;
	private final EcoreTestFileBase ecoreTestFile;
	private final ModelRegistryTestFile modelRegistryTestFile;
	private FileEditorInput fileEditorInput = null;
	private StringBuffer text = new StringBuffer();
	
	public OCLForEcoreTestFile(IFile file, EcoreTestFileBase ecoreTestFile) {
		this.file = file;
		this.ecoreTestFile = ecoreTestFile;
		modelRegistryTestFile = new ModelRegistryTestFile(file);
	}

	public void createInvariant(EClass eClass, String name, String expression) {
		text.append("context ");
		text.append(eClass.getEPackage().getName());
		text.append("::");
		text.append(eClass.getName());
		text.append("\ninv ");
		text.append(name);
		text.append(":");
		text.append(expression);
		text.append("\n");
	}

	public EClass getEClass(CommonParseResult parseResult, EClass initClass) {
		Resource resource = parseResult.getAST();	
		return ecoreTestFile.getEClass(resource.getResourceSet(), initClass);
	}

	public IFileEditorInput getEditorInput() throws CoreException, IOException {
		if (fileEditorInput == null) {
			ecoreTestFile.getEditorInput();
			for (EPackage ePackage : ecoreTestFile.getEPackages()) {
				modelRegistryTestFile.createRegistration(ModelNameAccessor.NAMESPACE.getName(), ePackage.getName(), ecoreTestFile.getFile().getProjectRelativePath().toString());
			}
			modelRegistryTestFile.getEditorInput();
			file.create(new ByteArrayInputStream(text.toString().getBytes()), 0, null);
			text = null;
			fileEditorInput = new FileEditorInput(file);
		}
		return fileEditorInput;
	}

	public IFile getFile() {
		return file;
	}

	public InvariantChecker createInvariantChecker(CommonParseResult parseResult, EClass initClass) {
		EClass eClass = getEClass(parseResult, initClass);
		return new InvariantChecker(parseResult, eClass);
	}

	public String reload() throws IOException, CoreException {
		file.refreshLocal(IResource.DEPTH_ZERO, null);
		InputStream inputStream = file.getContents();
		StringBuffer s = new StringBuffer();
		LineNumberReader reader = new LineNumberReader(new InputStreamReader(inputStream));
		String line;
		while ((line = reader.readLine()) != null) {
			s.append(line);
			s.append("\n");
		}
		return s.toString();
	}

}