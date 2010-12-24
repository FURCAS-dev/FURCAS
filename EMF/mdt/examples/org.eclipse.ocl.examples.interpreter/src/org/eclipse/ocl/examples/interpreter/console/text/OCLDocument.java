/**
 * <copyright>
 *
 * Copyright (c) 2007, 2010 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Kenn Hussey - 332962
 *
 * </copyright>
 *
 * $Id: OCLDocument.java,v 1.2 2010/12/22 12:19:57 asanchez Exp $
 */

package org.eclipse.ocl.examples.interpreter.console.text;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.OCL;
import org.eclipse.ocl.examples.interpreter.console.IOCLFactory;
import org.eclipse.ocl.examples.interpreter.console.ModelingLevel;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.helper.Choice;
import org.eclipse.ocl.helper.OCLHelper;
import org.eclipse.ocl.utilities.OCLFactory;
import org.eclipse.ocl.utilities.UMLReflection;


/**
 * In-memory document implementation for the OCL Console's input area.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class OCLDocument
    extends Document {

    private EObject context;
    private Map<String, EClassifier> parameters;
    private IOCLFactory<Object> oclFactory;
    private ModelingLevel level;
    
	/**
	 * @since 3.1
	 */
	public OCLDocument(String initialContent) {
		super(initialContent);

		IDocumentPartitioner partitioner = new FastPartitioner(
			new OCLPartitionScanner(),
			new String[]{OCLPartitionScanner.COMMENT});

		partitioner.connect(this);
		setDocumentPartitioner(partitioner);
	}

    public OCLDocument() {
    	this(null);
    }
    
    public void setOCLContext(EObject context) {
        this.context = context;
    }
    
    public EObject getOCLContext() {
        return context;
    }
    
	/**
	 * @since 3.1
	 */
	public void setOCLParameters(Map<String, EClassifier> parameters) {
		this.parameters = parameters;
	}

	/**
	 * @since 3.1
	 */
	public Map<String, EClassifier> getOCLParameters() {
		return parameters;
	}

	public void setOCLFactory(IOCLFactory<Object> factory) {
        this.oclFactory = factory;
    }
    
    public IOCLFactory<Object> getOCLFactory() {
        return oclFactory;
    }
    
    public void setModelingLevel(ModelingLevel level) {
        this.level = level;
    }
    
    public ModelingLevel getModelingLevel() {
        return level;
    }
    
    List<Choice> getOCLChoices(int offset) {
        if (context == null) {
            return Collections.emptyList();
        }
        
        try {
            String text = get(0, offset);
            
            OCL<?, Object, ?, ?, ?, Object, ?, ?, ?, ?, ?, ?> ocl = oclFactory.createOCL(
                getModelingLevel());
            OCLHelper<Object, ?, ?, ?> helper = ocl.createOCLHelper();
            
			if (parameters != null) {
				// create variables with specified names and types
				@SuppressWarnings("unchecked")
				Environment<?, Object, ?, ?, ?, Object, ?, ?, ?, ?, ?, ?> environment = (Environment<?, Object, ?, ?, ?, Object, ?, ?, ?, ?, ?, ?>) helper
					.getEnvironment();
				OCLFactory oclFactory = environment.getOCLFactory();
				UMLReflection<?, Object, ?, ?, ?, Object, ?, ?, ?, ?> umlReflection = environment
					.getUMLReflection();

				for (Map.Entry<String, EClassifier> entry : parameters
					.entrySet()) {
					Variable<Object, Object> variable = oclFactory
						.createVariable();
					variable.setName(entry.getKey());
					variable
						.setType(umlReflection.getOCLType(entry.getValue()));

					environment.addElement(entry.getKey(), variable, true);
				}
			}

            return helper.getSyntaxHelp(
                level.setContext(helper, context, oclFactory),
                text);
        } catch (Exception e) {
            // just don't provide proposals
            return Collections.emptyList();
        }
    }
}
