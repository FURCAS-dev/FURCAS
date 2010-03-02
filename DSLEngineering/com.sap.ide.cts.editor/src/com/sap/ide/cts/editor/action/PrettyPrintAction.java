package com.sap.ide.cts.editor.action;

import org.antlr.runtime.Lexer;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import tcs.ConcreteSyntax;
import tcs.Template;
import textblocks.TextBlock;
import textblocks.TextblocksPackage;

import com.sap.ide.cts.dialogs.ChooseConcreteSyntaxDialog;
import com.sap.ide.cts.dialogs.PrettyPrintPreviewDialog;
import com.sap.ide.cts.dialogs.PrettyPrinterInfoDialog;
import com.sap.ide.cts.editor.AbstractGrammarBasedEditor;
import com.sap.ide.cts.editor.prettyprint.CtsPrettyPrinter;
import com.sap.ide.cts.editor.prettyprint.CtsTextBlockTCSExtractorStream;
import com.sap.ide.cts.editor.prettyprint.imported.TCSExtractorStream;
import com.sap.ide.cts.parser.incremental.ParserFactory;
import com.sap.mi.fwk.ui.ModelManagerUI;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import com.sap.mi.textual.parsing.textblocks.TbChangeUtil;
import com.sap.mi.textual.parsing.textblocks.TbNavigationUtil;
import com.sap.mi.textual.parsing.textblocks.TbUtil;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mql.MQLProcessor;
import com.sap.tc.moin.repository.mql.MQLResultSet;


public class PrettyPrintAction extends Action
{

	private final RefObject modelElement;
	private final MofClass clazz;
	private TextBlock rootBlock;
	private final boolean openEditorAfterPrettyPrint;

	public PrettyPrintAction(MofClass clazz, RefObject modelElement, boolean openEditorAfterPrettyPrint)
	{
		super("Pretty Print", PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ETOOL_PRINT_EDIT));
		this.setDisabledImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(
			ISharedImages.IMG_ETOOL_PRINT_EDIT_DISABLED));
		this.setId("prettyPrint");
		//super(clazz.getName());
		//setImageDescriptor(Activator.getImageDescriptor(clazz));
		this.clazz = clazz;
		this.modelElement = modelElement;
		this.openEditorAfterPrettyPrint = openEditorAfterPrettyPrint;
		// TODO Auto-generated constructor stub
	}
	
	 @Override
	 public void runWithEvent(Event event) 
	 {
		 try
		 {
			 Connection connection = modelElement.get___Connection();
			 MQLProcessor mql = connection.getMQLProcessor();
			 
			 String mqlTemplates = "select template \n" +
			 		"from \"demo.sap.com/tcsmeta\"#TCS::ClassTemplate as template, \n" +
			 		"\"" + ( (Partitionable) clazz ).get___Mri( ) + "\" as class \n" +
			 		"where template.metaReference = class";
			 String mqlTextBlocks = "select tb \n" +
			 		"from \"demo.sap.com/tcsmeta\"#textblocks::TextBlock as tb, \n" + 
			 		"\"" + ( (Partitionable) modelElement ).get___Mri( ) + "\" as me \n" + 
			 		"where tb.correspondingModelElements = me";
			 
			 MQLResultSet resultSet = mql.execute(mqlTemplates);
			 RefObject[] templates = resultSet.getRefObjects("template");
			 resultSet = mql.execute(mqlTextBlocks);
			 RefObject[] rootTbs = resultSet.getRefObjects("tb");
			 
			 if(templates.length > 0)
			 {
				 TextBlock parent = null;
				 int oldTbLength = 0;
				 int oldTbIndex = 0;
				 int oldOffset = 0;
				 int oldAbsoluteOffset = 0;
				 String cachedString = null;
				 String toDelete = null;
				 for(RefObject o : rootTbs)
				 {
					 if(o instanceof TextBlock)
					 {
						 TextBlock t = (TextBlock) o;
						 oldTbLength = t.getLength();
						 if (t != null && t.getParentBlock() != null)
						 {
							 parent = t.getParentBlock();
							 oldAbsoluteOffset = t.getAbsoluteOffset();
							 oldOffset = t.getOffset();
							 oldTbIndex = parent.getSubBlocks().indexOf(o);
							 parent.getSubBlocks().remove(o);
							 cachedString = TbNavigationUtil.getUltraRoot(parent).getCachedString();
							 if(cachedString!=null)
							 {
								 toDelete = cachedString.substring(oldAbsoluteOffset, oldAbsoluteOffset+oldTbLength);
							 }
							 cachedString = cachedString.replace(toDelete, "");
							 parent.setCachedString(cachedString);
						 }
					 }
					 o.refDelete();
				 }
				 
				 try
				 {
					 ConcreteSyntax s = null;
					 TCSExtractorStream stream = null;
					 if(templates.length > 1)
					 {
						 ChooseConcreteSyntaxDialog dialog = new ChooseConcreteSyntaxDialog(templates);
						 Object o = dialog.execute(null);
						 if(o instanceof Template)
						 {
							 s = ((Template) o).getConcretesyntax();
						 }
					 }
					 else
					 {
						 if(templates[0] instanceof Template)
						 {
							 s = ((Template) templates[0]).getConcretesyntax();
						 }
					 }
					 IConfigurationElement[] config = Platform.getExtensionRegistry().
					 		getConfigurationElementsFor("com.sap.ide.cts.parser.parserFactory");
					 if(config != null && config.length > 0)
					 {
						 for(IConfigurationElement configElement : config)
						 {
	
							 String languageID = configElement.getAttribute("languageID");
							 if(languageID != null && languageID.equals(s.getName()))
							 {
								 ParserFactory<ObservableInjectingParser, Lexer> parserFactory = (ParserFactory<ObservableInjectingParser, Lexer>) configElement.createExecutableExtension("dynamicParserFactoryClass");
								 stream = new CtsTextBlockTCSExtractorStream(connection.getPackage(TextblocksPackage.PACKAGE_DESCRIPTOR),
										 	modelElement.get___Partition(), parserFactory);
								 break;
							 }
						 }
					 }
					 else
					 {
						 throw new Exception("No Parser Factory registered!");
					 }
					 CtsPrettyPrinter.prettyPrint(modelElement, s, stream);
					 if(stream instanceof CtsTextBlockTCSExtractorStream)
					 {
						 this.rootBlock = ((CtsTextBlockTCSExtractorStream) stream).getRootBlock();
						 if(parent != null)
						 {
							 this.rootBlock.setOffset(oldOffset);
							 parent.getSubBlocks().add(oldTbIndex, this.rootBlock);
							 int lengthToAdd = this.rootBlock.getLength()-oldTbLength;
							 TbChangeUtil.updateOffsetsWithinTextBlock(this.rootBlock, lengthToAdd);
							 TbChangeUtil.updateLengthAscending(parent, lengthToAdd);
							 StringBuffer newCachedString = new StringBuffer(cachedString);
							 newCachedString.insert(oldAbsoluteOffset, this.rootBlock.getCachedString());
							 TbNavigationUtil.getUltraRoot(this.rootBlock).setCachedString(newCachedString.toString());
						 }
					 }
					 connection.save();
					 PrettyPrinterInfoDialog dialog = new PrettyPrinterInfoDialog("Pretty Printer", "Pretty Printer finished successfully!");
					 dialog.execute(null);
					 if(this.openEditorAfterPrettyPrint)
					 {
						 ModelManagerUI.getEditorManager().openEditor(modelElement, null, null);
					 }
				 }
				 catch(Exception e)
				 {
					 connection.revert();
					 e.printStackTrace();
					 PrettyPrinterInfoDialog dialog = new PrettyPrinterInfoDialog("Pretty Printer", "Pretty Printer failed with exception, see console!");
					 dialog.execute(null);
				 }
			 }
			 else
			 {
				 PrettyPrinterInfoDialog dialog = new PrettyPrinterInfoDialog("Pretty Printer", "Please select root element to start Pretty Printer!");
				 dialog.execute(null);
			 }
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
	 }

	public TextBlock getRootBlock()
	{
		return rootBlock;
	}
}

/**
 * ParserFactory<? extends ObservableInjectingParser, ? extends Lexer> myParserFactory =
					new ParserFactory<? extends ObservableInjectingParser, ? extends Lexer>(){
	
						@Override
						public ITextBlocksTokenStream createIncrementalTokenStream(
								IncrementalLexer incrementalLexer)
						{
							// TODO Auto-generated method stub
							return null;
						}
	
						@Override 
						public Lexer createLexer(CharStream input){// TODO Auto-generated method stub
						try
						{
							return (Lexer) getClass().forName("ClassLexer").newInstance();
						}
						catch(InstantiationException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						catch(IllegalAccessException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						catch(ClassNotFoundException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return null;
						}
	
						@Override public Lexer createLexer(CharStream input,ITokenFactory<? extends ANTLR3LocationToken> factory){// TODO Auto-generated method stub
						return null;}
	
						@Override public ObservableInjectingParser createParser(TokenStream input,Connection connection,Collection<PRI> additionalScope,Collection<CRI> collection){// TODO Auto-generated method stub
						return null;}
	
						@Override public ObservableInjectingParser createParser(TokenStream input,Connection connection){// TODO Auto-generated method stub
						return null;}
	
						@Override
						public String getLanguageId()
						{
							// TODO Auto-generated method stub
							return null;
						}
	
						@Override
						public Class<? extends Lexer> getLexerClass()
						{
							// TODO Auto-generated method stub
							return null;
						}
	
						@Override
						public CRI getMetamodelCri(Connection connection)
						{
							// TODO Auto-generated method stub
							return null;
						}
	
						@Override
						public RefPackage getMetamodelPackage(Connection connection)
						{
							// TODO Auto-generated method stub
							return null;
						}
	
						@Override
						public Class<? extends ObservableInjectingParser> getParserClass()
						{
							// TODO Auto-generated method stub
							return null;
						}
	
						@Override
						public Collection<PRI> getParserLookupScope(
								Connection connection)
						{
							// TODO Auto-generated method stub
							return null;
						}
	
						@Override
						public String getSyntaxUUID()
						{
							// TODO Auto-generated method stub
							return null;
						}}
			 ;
			 **/
