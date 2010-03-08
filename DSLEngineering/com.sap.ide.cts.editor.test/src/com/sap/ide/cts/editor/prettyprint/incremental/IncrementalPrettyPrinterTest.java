package com.sap.ide.cts.editor.prettyprint.incremental;

import junit.framework.Assert;
import ngpm.NgpmPackage;

import org.eclipse.core.runtime.Path;
import org.eclipse.ui.PartInitException;
import org.junit.Test;

import textblocks.TextBlock;

import com.sap.ide.cts.editor.AbstractGrammarBasedEditor;
import com.sap.ide.cts.editor.action.PrettyPrintAction;
import com.sap.ide.cts.editor.test.RunletEditorTest;
import com.sap.mi.fwk.ModelManager;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mql.MQLProcessor;
import com.sap.tc.moin.repository.mql.MQLResultSet;

import data.classes.MethodSignature;
import data.classes.SapClass;

public class IncrementalPrettyPrinterTest extends RunletEditorTest
{
	@Test
	public void testPrettyPrintEmptyClass()
	{
		NgpmPackage rootPkg = connection.getPackage(NgpmPackage.PACKAGE_DESCRIPTOR);
        SapClass clazz = (SapClass) rootPkg.getData().getClasses().getSapClass().refCreateInstanceInPartition(ModelManager.getPartitionService().getPartition(connection, getProject(), new Path("src/Package1235568260162.types")));
        clazz.setName("IppClass1");
        PrettyPrintAction action = new PrettyPrintAction((MofClass) clazz.refMetaObject(), clazz, true);
        action.runWithEvent(null);
        AbstractGrammarBasedEditor editor = null;
		try
		{
			editor = openEditor(clazz);
		}
		catch (PartInitException e)
		{
			e.printStackTrace();
		}
		
		String ppClazz = action.getRootBlock().getCachedString();
		if(ppClazz != null)
		{
			System.out.println(ppClazz);
			Assert.assertTrue(ppClazz.contains("class " + clazz.getName()));
		}
		
        close(editor);
	}
	
	@Test
	public void testPrettyPrintMethodWithinClass()
	{
		NgpmPackage rootPkg = connection.getPackage(NgpmPackage.PACKAGE_DESCRIPTOR);
		SapClass clazz = findClass("Humba");
		MethodSignature method = (MethodSignature) rootPkg.getData().getClasses().getMethodSignature().
				refCreateInstanceInPartition(ModelManager.getPartitionService().getPartition(connection, 
						getProject(), new Path("src/Package1235568260162.types")));
		method.setName("testMethod");
		method.setOwner(clazz);
		try
		{
			connection.save();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		PrettyPrintAction action = new PrettyPrintAction((MofClass) clazz.refMetaObject(), clazz, true);
		action.runWithEvent(null);
		AbstractGrammarBasedEditor editor = null;
		try
		{
			editor = openEditor(clazz);
		}
		catch (PartInitException e)
		{
			e.printStackTrace();
		}
		
		String ppClazz = action.getRootBlock().getCachedString();
		if(ppClazz != null)
		{
			System.out.println(ppClazz);
			Assert.assertTrue(ppClazz.contains("void " + method.getName()));
		}
		else
		{
			Assert.assertTrue("Pretty Printing not successfull!", false);
		}
		
        close(editor);
	}
	
	private TextBlock getTextBlockForModelElement(RefObject modelElement)
	{
		Connection connection = modelElement.get___Connection();
		MQLProcessor mql = connection.getMQLProcessor();
		String mqlTextBlocks = "select tb \n" +
 				"from \"demo.sap.com/tcsmeta\"#textblocks::TextBlock as tb, \n" + 
 				"\"" + ( (Partitionable) modelElement ).get___Mri( ) + "\" as me \n" + 
 				"where tb.correspondingModelElements = me";
		MQLResultSet resultSet = mql.execute(mqlTextBlocks);
		RefObject[] textBlocks = resultSet.getRefObjects("tb");
		
		if(textBlocks.length == 1)
		{
			return (TextBlock) textBlocks[0];
		}
		else
		{
			return null;
		}
	}
}
