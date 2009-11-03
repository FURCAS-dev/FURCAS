/**
 * 
 */
package com.sap.ide.cts.parser.incremental;


import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;

import ngpm.NgpmPackage;

import org.junit.Ignore;
import org.junit.Test;

import textblocks.AbstractToken;
import textblocks.TextBlock;
import textblocks.VersionEnum;
import behavioral.actions.Block;

import com.sap.ap.cts.monet.parser.ActionsParserFactory;
import com.sap.ide.cts.parser.incremental.antlr.IncrementalParserFacade;
import com.sap.mi.textual.parsing.textblocks.TbChangeUtil;
import com.sap.mi.textual.parsing.textblocks.TbVersionUtil;
import com.sap.mi.textual.parsing.textblocks.TextBlocksAwareModelAdapter;
import com.sap.mi.textual.textblocks.model.TextBlocksModel;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.textual.moinadapter.adapter.MOINModelAdapter;

/**
 * 
 */
public class TestParsingObserverWithActionsSyntax extends NGPMTextBlockTest {

	private static class Replacement {
		
		int offset;
		int length;
		String conent;
		public Replacement(int offset, int length, String conent) {
			super();
			this.offset = offset;
			this.length = length;
			this.conent = conent;
		}
	}
    
	@Test
	@Ignore
	public void test1() throws Exception {
		IncrementalParserFacade facade = getParserFacade();
		File Test1 = new File("scenariotestResource/ActionsTest.act");

		AbstractToken content = createToken("");
		TextBlock root = initialiseTextBlocksWithContentToken(content);

		TextBlocksModel tbModel = new TextBlocksModel(root, null);
		tbModel.replace(0, 0, getActionsFileContent(Test1));
		

		Object blockObject = facade.parse(root, "main");
		// assert no exception
		assertNotNull(blockObject);
		assertTrue(blockObject instanceof Block);
		
		TextBlock currentVersionTb = TbVersionUtil.getOtherVersion(root, VersionEnum.CURRENT);
		assertNotNull(currentVersionTb); // future version
		//assertEquals(15, currentVersionTb.getSubNodes().size());
	}
	
	@Test
	public void test2() {
		IncrementalParserFacade facade = getParserFacade();

		String initialConent = "{return 0;}";
		//add space to return statement afterwards:
		//{return  0;}
		Replacement replacement = new Replacement(7,0," ");
		TextBlock root = doReplacementWithInitialContent(facade, initialConent, replacement);
		
		TextBlock currentVersionTb = TbVersionUtil.getOtherVersion(root, VersionEnum.CURRENT);
        assertNotNull(currentVersionTb); // future version
	}
	
	@Test
	public void test3() {
		IncrementalParserFacade facade = getParserFacade();

		String initialConent = "{return this.length(123);}";
		//add space to return statement afterwards:
		//{return this.length (123);}
		Replacement replacement = new Replacement(19,0," ");
		TextBlock root = doReplacementWithInitialContent(facade, initialConent, replacement);
		
		TextBlock currentVersionTb = TbVersionUtil.getOtherVersion(root, VersionEnum.CURRENT);
        assertNotNull(currentVersionTb); // future version
	}
	
	@Test
	public void test4() {
		IncrementalParserFacade facade = getParserFacade();

		String initialConent = "{return 0;}";
		//add space to return statement afterwards:
		//{return this.length();}
		Replacement replacement = new Replacement(8,1,"this.length()");
		TextBlock root = doReplacementWithInitialContent(facade, initialConent, replacement);
		
		TextBlock currentVersionTb = TbVersionUtil.getOtherVersion(root, VersionEnum.CURRENT);
        assertNotNull(currentVersionTb); // future version
	}
	
	@Test
	public void test5() {
		IncrementalParserFacade facade = getParserFacade();

		String initialConent = "{return 0;}";
		//add space to return statement afterwards:
		//{return 10;}
		Replacement replacement = new Replacement(8,0,"1");
		TextBlock root = doReplacementWithInitialContent(facade, initialConent, replacement);
		
		TextBlock currentVersionTb = TbVersionUtil.getOtherVersion(root, VersionEnum.CURRENT);
        assertNotNull(currentVersionTb); // future version
	}
	
	@Test
	public void test6() {
		IncrementalParserFacade facade = getParserFacade();

		String initialConent = "{return 10;}";
		//add space to return statement afterwards:
		//{return 100;}
		Replacement replacement = new Replacement(10,0,"0");
		TextBlock root = doReplacementWithInitialContent(facade, initialConent, replacement);
		
		TextBlock currentVersionTb = TbVersionUtil.getOtherVersion(root, VersionEnum.CURRENT);
        assertNotNull(currentVersionTb); // future version
	}
	
	@Test
	public void test7() {
		IncrementalParserFacade facade = getParserFacade();

		String initialConent = "{return 100;}";
		//add space to return statement afterwards:
		//{return this;}
		Replacement replacement = new Replacement(8,3,"this");
		TextBlock root = doReplacementWithInitialContent(facade, initialConent, replacement);
		
		TextBlock currentVersionTb = TbVersionUtil.getOtherVersion(root, VersionEnum.CURRENT);
        assertNotNull(currentVersionTb); // future version
	}
	
	@Test
	public void test8() {
		IncrementalParserFacade facade = getParserFacade();

		String initialConent = "{return this.length();}";
		//how the text should look afterwards:
		//{return this.length(123);}
		Replacement replacement = new Replacement(20,0,"123");
		TextBlock root = doReplacementWithInitialContent(facade, initialConent, replacement);
		
		TextBlock currentVersionTb = TbVersionUtil.getOtherVersion(root, VersionEnum.CURRENT);
        assertNotNull(currentVersionTb); // future version
	}
	
	@Test
	public void test9() {
		IncrementalParserFacade facade = getParserFacade();

		String initialConent = "{this.length();}";
		//how the text should look afterwards:
		//{this;
		//this.length()}
		Replacement replacement = new Replacement(1,0,"this;\n");
		TextBlock root = doReplacementWithInitialContent(facade, initialConent, replacement);
		
		TextBlock currentVersionTb = TbVersionUtil.getOtherVersion(root, VersionEnum.CURRENT);
        assertNotNull(currentVersionTb); // future version
	}
	
	@Test
	public void test10() {
		IncrementalParserFacade facade = getParserFacade();

		String initialConent = "{this.length(0);}";
		//how the text should look afterwards:
		//{this.length();}
		Replacement replacement = new Replacement(13,1,"");
		TextBlock root = doReplacementWithInitialContent(facade, initialConent, replacement);
		
		TextBlock currentVersionTb = TbVersionUtil.getOtherVersion(root, VersionEnum.CURRENT);
        assertNotNull(currentVersionTb); // future version
	}
	
	@Test
	public void test11() {
		IncrementalParserFacade facade = getParserFacade();

		String initialConent = "{this.length();}";
		//how the text should look afterwards:
		//{this.length();}
		Replacement replacement = new Replacement(13,0,"1");
		TextBlock root = doReplacementWithInitialContent(facade, initialConent, replacement);
		
		TextBlock currentVersionTb = TbVersionUtil.getOtherVersion(root, VersionEnum.CURRENT);
        assertNotNull(currentVersionTb); // future version
	}
	
	@Test
	public void test12() {
		IncrementalParserFacade facade = getParserFacade();

		String initialConent = "{\nthis;\n}";
		//how the text should look afterwards:
		//{
		//this;
		//this;
		//;}
		Replacement replacement = new Replacement(1,0,"this;\n");
		TextBlock root = doReplacementWithInitialContent(facade, initialConent, replacement);
		
		TextBlock currentVersionTb = TbVersionUtil.getOtherVersion(root, VersionEnum.CURRENT);
        assertNotNull(currentVersionTb); // future version
	}
	
	@Test
	public void test13() {
		IncrementalParserFacade facade = getParserFacade();

		String initialConent = "{\nthis;\n}";
		//how the text should look afterwards:
		//{
		//this;
		//this;
		//;}
		Replacement replacement = new Replacement(1,0,"this;\n");
		TextBlock root = doReplacementWithInitialContent(facade, initialConent, replacement);
	
		TextBlock currentVersionTb = TbVersionUtil.getOtherVersion(root, VersionEnum.CURRENT);
        assertNotNull(currentVersionTb); // future version
		TbChangeUtil.cleanUp(currentVersionTb);
		
		replacement = new Replacement(1,0,"this;\n");
		root = doReplacement(facade, replacement, currentVersionTb);
		
		assertNotNull(root);
		
	}
	
	private TextBlock doReplacementWithInitialContent(IncrementalParserFacade facade,
			String initialConent, Replacement replacement) {
		AbstractToken content = createToken(
				initialConent);
		TextBlock root = initialiseTextBlocksWithContentToken(content);

		return doReplacement(facade, replacement, root);
	}

	private TextBlock doReplacement(IncrementalParserFacade facade,
			Replacement replacement, TextBlock root) {
		TextBlocksModel tbModel = new TextBlocksModel(root, null);
		
		tbModel.replace(replacement.offset, replacement.length, replacement.conent);
		
		TextBlock result = facade.parseIncrementally(root);
		Object blockObject = IncrementalParserFacade.getParsingResult(result);
		
		if(facade.getErrors().size() > 0) {
			if(facade.getErrors().get(0).getMessage().startsWith("Cannot evaluate OCLExpression")) {
				
			} else {
				//FAIL
				assertNotNull(facade.getErrors().size() + " Errors occured, first is:"+
					facade.getErrors().get(0).getMessage(), null);
			}
		}
		
		// assert no exception
		assertNotNull(blockObject);
		assertTrue(blockObject instanceof Block);
		return result;
	}
	
	

	/**
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     */
    private IncrementalParserFacade getParserFacade() {
        NgpmPackage ngpmPackage = connection
				.getPackage(NgpmPackage.PACKAGE_DESCRIPTOR);
		 Collection<PRI> priList = new ArrayList<PRI>();
	        Moin moin = getBuildMoin();
	        PRI pri1 = moin.createPri("PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/PrimitiveTypes.moinmm");
	        PRI pri2 = moin.createPri("PF.MetaModelDataArea:DCs/demo.sap.com/tcsmeta/_comp/moin/meta/Metamodel.moinmm");
	        PRI pri3 = moin.createPri("PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/Model.moinmm");
	        PRI pri4 = moin.createPri("PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/MOIN.moinmm");
	        PRI pri5 = moin.createPri("PF.MetaModelDataArea:DCs/sap.com/moin/mm/ap/core/_comp/moin/meta/ngpm.moinmm");
	        PRI pri6 = moin.createPri("PF.MetaModelDataArea:DCs/sap.com/moin/mm/ap/core/_comp/moin/meta/data.moinmm");
	        PRI pri7 = moin.createPri("PF.MetaModelDataArea:DCs/sap.com/moin/mm/ap/core/_comp/moin/meta/behavioral.moinmm");
	        PRI pri8 = moin.createPri("PF.MetaModelDataArea:DCs/sap.com/moin/mm/ap/core/_comp/moin/meta/dataaccess.moinmm");
	        priList.add(pri1);
	        priList.add(pri2);
	        priList.add(pri3);
	        priList.add(pri4);
	        priList.add(pri5);
	        priList.add(pri6);
	        priList.add(pri7);
	        priList.add(pri8);

		IncrementalParserFacade facade = new IncrementalParserFacade(
		        new ActionsParserFactory(),
		        new TextBlocksAwareModelAdapter(new MOINModelAdapter(
						ngpmPackage, connection, priList, null)),
				connection, null);
        return facade;
    }

	private String getActionsFileContent(File syntaxDefFile) {
		String content = null;
		if (syntaxDefFile != null) {
			try {
				FileInputStream inputStream = new FileInputStream(syntaxDefFile);
				StringBuilder out = new StringBuilder();
				byte[] b = new byte[4096];
				for (int n; (n = inputStream.read(b)) != -1;) {
					out.append(new String(b, 0, n));
				}
				content = out.toString();
				inputStream.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return content;
	}

}
