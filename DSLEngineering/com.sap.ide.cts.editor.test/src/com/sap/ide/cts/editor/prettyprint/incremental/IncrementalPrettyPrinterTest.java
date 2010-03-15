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
import com.sap.mi.textual.parsing.textblocks.TbNavigationUtil;
import com.sap.tc.moin.repository.mmi.model.MofClass;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.FunctionSignatureImplementation;
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
        SapClass clazz = (SapClass) rootPkg.getData().getClasses().getSapClass().refCreateInstanceInPartition(ModelManager.getPartitionService().getPartition(connection, getProject(), new Path("src/Package1235568260162.types")));
        clazz.setName("IppClass2");
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
	
	@Test
	public void testPrettyPrintMethodAfterChangesInDomainModel()
	{
		NgpmPackage rootPkg = connection.getPackage(NgpmPackage.PACKAGE_DESCRIPTOR);
        SapClass clazz = (SapClass) rootPkg.getData().getClasses().getSapClass().refCreateInstanceInPartition(ModelManager.getPartitionService().getPartition(connection, getProject(), new Path("src/Package1235568260162.types")));
        clazz.setName("IppClass3");
		MethodSignature method = (MethodSignature) rootPkg.getData().getClasses().getMethodSignature().
				refCreateInstanceInPartition(ModelManager.getPartitionService().getPartition(connection, 
						getProject(), new Path("src/Package1235568260162.types")));
		method.setName("testMethod");
		method.setOwner(clazz);
		
		PrettyPrintAction action = new PrettyPrintAction((MofClass) clazz.refMetaObject(), clazz, false);
		action.runWithEvent(null);
		
		try
		{
			connection.save();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return;
		}
		
		method.setName("testMethodChanged");
		
		PrettyPrintAction action2 = new PrettyPrintAction((MofClass) method.refMetaObject(), method, true);
		action2.runWithEvent(null);
		
		try
		{
			connection.save();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return;
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
	}
	
	@Test
	public void testPrettyPrintAssociationAfterRename()
	{
		NgpmPackage rootPkg = connection.getPackage(NgpmPackage.PACKAGE_DESCRIPTOR);
        SapClass clazz = (SapClass) rootPkg.getData().getClasses().getSapClass().refCreateInstanceInPartition(
                ModelManager.getPartitionService().getPartition(connection, getProject(),
                        new Path("src/Package1235568260162.types")));
        clazz.setName("IppClass4");
        SapClass clazz2 = (SapClass) rootPkg.getData().getClasses().getSapClass().refCreateInstanceInPartition(
                ModelManager.getPartitionService().getPartition(connection, getProject(),
                        new Path("src/Package1235568260162.types")));
        clazz2.setName("IppClass5");
        Association assoc = (Association) rootPkg.getData().getClasses().getAssociation().refCreateInstanceInPartition(
                ModelManager.getPartitionService().getPartition(connection, getProject(),
                        new Path("src/Package1235568260162.types")));
        AssociationEnd a1 = (AssociationEnd) rootPkg.getData().getClasses().getAssociationEnd().refCreateInstance();
        AssociationEnd a2 = (AssociationEnd) rootPkg.getData().getClasses().getAssociationEnd().refCreateInstance();
        a1.setName("a1");
        a1.setNavigable(true);
        a2.setName("a2");
        a2.setNavigable(true);
        ClassTypeDefinition a1ctd = (ClassTypeDefinition) rootPkg.getData().getClasses().getClassTypeDefinition()
                .refCreateInstance();
        a1ctd.setLowerMultiplicity(0);
        a1ctd.setUpperMultiplicity(1);
        a1ctd.setClazz(clazz2);
        ClassTypeDefinition a2ctd = (ClassTypeDefinition) rootPkg.getData().getClasses().getClassTypeDefinition()
                .refCreateInstance();
        a2ctd.setLowerMultiplicity(0);
        a2ctd.setUpperMultiplicity(1);
        a2ctd.setClazz(clazz);
        a1.setType(a1ctd);
        a2.setType(a2ctd);
        assoc.getEnds().add(a1);
        assoc.getEnds().add(a2);
        
        PrettyPrintAction action = new PrettyPrintAction((MofClass) clazz.refMetaObject(), clazz, false);
		action.runWithEvent(null);
		
		String ppClazz = action.getRootBlock().getCachedString();
		if(ppClazz != null)
		{
			System.out.println(ppClazz);
		}
		else
		{
			Assert.assertTrue("Pretty Printing not successfull!", false);
		}
		
		try
		{
			connection.save();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return;
		}
		
		a1.setName("new_a1");
		
		PrettyPrintAction action2 = new PrettyPrintAction((MofClass) a2ctd.refMetaObject(), a2ctd, true);
		action2.runWithEvent(null);
		
		try
		{
			connection.save();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return;
		}
		
		TextBlock newBlock = action2.getRootBlock();
		ppClazz = TbNavigationUtil.getUltraRoot(newBlock).getCachedString();
		if(ppClazz != null)
		{
			System.out.println(ppClazz);
		}
		else
		{
			Assert.assertTrue("Pretty Printing not successfull!", false);
		}
	}
	
//	@Test
//	public void testPrettyPrintMethodAfterAddedImplementation()
//	{
//		NgpmPackage rootPkg = connection.getPackage(NgpmPackage.PACKAGE_DESCRIPTOR);
//        SapClass clazz = (SapClass) rootPkg.getData().getClasses().getSapClass().refCreateInstanceInPartition(ModelManager.getPartitionService().getPartition(connection, getProject(), new Path("src/Package1235568260162.types")));
//        clazz.setName("IppClass5");
//		MethodSignature method = (MethodSignature) rootPkg.getData().getClasses().getMethodSignature().
//				refCreateInstanceInPartition(ModelManager.getPartitionService().getPartition(connection, 
//						getProject(), new Path("src/Package1235568260162.types")));
//		method.setName("testMethod");
//		method.setOwner(clazz);
//		
//		PrettyPrintAction action = new PrettyPrintAction((MofClass) clazz.refMetaObject(), clazz, false);
//		action.runWithEvent(null);
//		
//		try
//		{
//			connection.save();
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//			return;
//		}
//		
//		FunctionSignatureImplementation impl = (FunctionSignatureImplementation) rootPkg.getData().getClasses().
//				getFunctionSignatureImplementation().refCreateInstanceInPartition(ModelManager.getPartitionService().
//						getPartition(connection, getProject(), new Path("src/Package1235568260162.types")));
//		impl.setImplements(method);
//		
//		PrettyPrintAction action2 = new PrettyPrintAction((MofClass) method.refMetaObject(), method, true);
//		action2.runWithEvent(null);
//		
//		try
//		{
//			connection.save();
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//			return;
//		}
//		
//		String ppClazz = action.getRootBlock().getCachedString();
//		if(ppClazz != null)
//		{
//			System.out.println(ppClazz);
//			Assert.assertTrue(ppClazz.contains("void " + method.getName()));
//		}
//		else
//		{
//			Assert.assertTrue("Pretty Printing not successfull!", false);
//		}
//	}
	
//	private TextBlock getTextBlockForModelElement(RefObject modelElement)
//	{
//		Connection connection = modelElement.get___Connection();
//		MQLProcessor mql = connection.getMQLProcessor();
//		String mqlTextBlocks = "select tb \n" +
// 				"from \"demo.sap.com/tcsmeta\"#textblocks::TextBlock as tb, \n" + 
// 				"\"" + ( (Partitionable) modelElement ).get___Mri( ) + "\" as me \n" + 
// 				"where tb.correspondingModelElements = me";
//		MQLResultSet resultSet = mql.execute(mqlTextBlocks);
//		RefObject[] textBlocks = resultSet.getRefObjects("tb");
//		
//		if(textBlocks.length == 1)
//		{
//			return (TextBlock) textBlocks[0];
//		}
//		else
//		{
//			return null;
//		}
//	}
	
}
