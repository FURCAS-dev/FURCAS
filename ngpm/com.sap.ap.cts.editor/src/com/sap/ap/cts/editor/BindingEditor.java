package com.sap.ap.cts.editor;

//import java.util.Iterator;

//import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.ap.cts.monet.parser.BindingParserFactory;
import com.sap.furcas.metamodel.textblocks.TextBlock;
import com.sap.ide.cts.editor.AbstractGrammarBasedEditor;
import com.sap.ide.cts.parser.errorhandling.SemanticParserException;


//import data.classes.SapClass;

public class BindingEditor extends AbstractGrammarBasedEditor {

	private static final String BINDING_LANGUAGE_ID = "Binding";

	public BindingEditor() {
		super(new BindingParserFactory(), new BindingMapper());
	}

	@Override
	public TextBlock parse(TextBlock rootBlock) throws SemanticParserException {
		ResourceSet connection = getWorkingConnection();
		initializeNewParser(connection);

//		Iterator<RefObject> iterator = rootBlock.getCorrespondingModelElements().iterator();
//		SapClass oldClass = null;
//		if(iterator.hasNext()) {
//			oldClass = (SapClass) iterator.next();
//		}
		//Call super implementation to do the actual stuff
		TextBlock newRoot =  super.parse(rootBlock);
		
//		// replace old class with new one
//		SapClass clazz=null;
//		if (oldClass != null && newRoot.getCorrespondingModelElements().size() == 1) {
//			//TODO it makes only sense to use one class so just take the first one?
//			clazz = replaceOldClassIfANewOneExists(oldClass, newRoot);
//		} else if(newRoot.getCorrespondingModelElements().size() > 1) {
//			clazz = replaceOldClassIfANewOneExists(oldClass, newRoot);
//			MessageDialog
//					.openWarning(
//							getEditorSite().getShell(),
//							"Ambigious parse result",
//							"There was more then one SapClass created during parsing," +
//							" this may be an error. The following is used:"
//									+ clazz.getName()
//									+ "("
//									+ clazz.refMofId()
//									+ ")");
//		}
		return newRoot;
	}

//	private SapClass replaceOldClassIfANewOneExists(SapClass oldClass, TextBlock newRoot) {
//		SapClass clazz;
//		Iterator<?> it = newRoot.getCorrespondingModelElements().iterator();
//		clazz = (SapClass) it.next();
//		if (!oldClass.equals(clazz)) {
//			RefObject parent = (RefObject) oldClass.refImmediateComposite();
//			if (parent instanceof modelmanagement.Package) {
//				clazz.setPackage((modelmanagement.Package) parent);
//				((Partitionable) parent).get___Partition()
//						.assignElementIncludingChildren(clazz);
//				((Partitionable) parent).get___Partition()
//						.assignElementIncludingChildren(newRoot);
//			}
//			oldClass.refDelete();
//		}
//		return clazz;
//	}

	@Override
	public String getLanguageId() {
		return BINDING_LANGUAGE_ID;
	}

}
