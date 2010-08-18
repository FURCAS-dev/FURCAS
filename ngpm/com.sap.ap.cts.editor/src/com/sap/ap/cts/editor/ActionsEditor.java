package com.sap.ap.cts.editor;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;

import behavioral.actions.Block;

import com.sap.ap.cts.monet.parser.ActionsParserFactory;
import com.sap.furcas.metamodel.textblocks.TextBlock;
import com.sap.ide.cts.editor.AbstractGrammarBasedEditor;
import com.sap.ide.cts.parser.errorhandling.SemanticParserException;
import com.sun.corba.se.pept.transport.Connection;

import data.classes.ClassTypeDefinition;
import data.classes.MethodSignature;
import data.classes.SapClass;
import dataaccess.expressions.This;

public class ActionsEditor extends AbstractGrammarBasedEditor {

	

	private static final String ACTIONS_LANGUAGE_ID = "Actions";

	public ActionsEditor() {
		super(new ActionsParserFactory(), new ActionsMapper());
	}

	@Override
	public TextBlock parse(TextBlock rootBlock) throws SemanticParserException {
		Connection connection = getWorkingConnection();
		initializeNewParser(connection);

		Block oldBlock = (Block) rootBlock.getCorrespondingModelElements().iterator().next();
		//Call super implementation to do the actual stuff
		TextBlock newRoot =  super.parse(rootBlock);
		
		// replace old block with new one
		Block block =null;
		if (oldBlock != null && newRoot.getCorrespondingModelElements().size() > 0) {
			for (Iterator<?> it = newRoot.getCorrespondingModelElements().iterator(); it.hasNext();) {
				block = (Block) it.next();
				if(!oldBlock.equals(block)) {
					EObject parent = (EObject) oldBlock.refImmediateComposite();
					if(parent instanceof MethodSignature) {
						//((MethodSignature)parent).setImplementation(block);
						block.setImplements((MethodSignature) parent);
						((EObject)parent).get___Partition().assignElementIncludingChildren(block);
						((EObject)parent).get___Partition().assignElementIncludingChildren(newRoot);
					}
					oldBlock.refDelete();
				}
			}
		}
		
		MQLResultSet resultThis =getWorkingConnection().getMQLProcessor().execute("select this from dataaccess::expressions::This as this");
		EObject[] thisObjects = resultThis.getRefObjects("this");
		
		for (int i = 0; i < thisObjects.length; i++) {
			ClassTypeDefinition ctd = getWorkingConnection().createElementInPartition(
					ClassTypeDefinition.CLASS_DESCRIPTOR, ((EObject)rootBlock).get___Partition());
			ctd.setClazz((SapClass) block.getImplementedSignature().refImmediateComposite());
			ctd.setLowerMultiplicity(1);
			ctd.setUpperMultiplicity(1);
			((This)thisObjects[i]).setOwnedTypeDefinition(ctd);
		}
		getParser().setDelayedReferencesAfterParsing();
		
		
		return newRoot;
	}

	@Override
	public String getLanguageId() {
		return ACTIONS_LANGUAGE_ID;
	}

}
