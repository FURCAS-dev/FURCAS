package com.sap.ide.cts.editor.action;

import org.antlr.runtime.Lexer;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import tcs.ConcreteSyntax;
import textblocks.TextblocksPackage;

import com.sap.ide.cts.dialogs.ChooseConcreteSyntaxDialog;
import com.sap.ide.cts.dialogs.PrettyPrinterInfoDialog;
import com.sap.ide.cts.editor.prettyprint.CtsPrettyPrinter;
import com.sap.ide.cts.editor.prettyprint.CtsTextBlockTCSExtractorStream;
import com.sap.ide.cts.editor.prettyprint.imported.TCSExtractorPrintStream;
import com.sap.ide.cts.editor.prettyprint.imported.TCSExtractorStream;
import com.sap.ide.cts.parser.incremental.ParserFactory;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
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

	public PrettyPrintAction(MofClass clazz, RefObject modelElement)
	{
		super("Pretty Print", PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ETOOL_PRINT_EDIT));
		this.setDisabledImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(
			ISharedImages.IMG_ETOOL_PRINT_EDIT_DISABLED));
		this.setId("prettyPrint");
		//super(clazz.getName());
		//setImageDescriptor(Activator.getImageDescriptor(clazz));
		this.clazz = clazz;
		this.modelElement = modelElement;
		// TODO Auto-generated constructor stub
	}
	
	 @Override
	 public void runWithEvent(Event event) 
	 {
		 try
		 {
			 Connection connection = modelElement.get___Connection();
			 MQLProcessor mql = connection.getMQLProcessor();
			 String mqlSyntaxes = "select cs \n" +
			 		"from \"demo.sap.com/tcsmeta\"#TCS::ConcreteSyntax as cs, \n" +
			 		"\"demo.sap.com/tcsmeta\"#TCS::ClassTemplate as template, \n" +
			 		"\"" + ( (Partitionable) clazz ).get___Mri( ) + "\" as class \n" +
			 		"where template.metaReference = class \n" + 
			        "where template.concreteSyntax = cs \n" +
			        "where template.isMain=true";
			 String mqlTextBlocks = "select tb \n" +
			 		"from \"demo.sap.com/tcsmeta\"#textblocks::TextBlock as tb, \n" + 
			 		"\"" + ( (Partitionable) modelElement ).get___Mri( ) + "\" as me \n" + 
			 		"where tb.correspondingModelElements = me " + 
			 		"where tb.parentBlock = null";
			 MQLResultSet resultSet = mql.execute(mqlSyntaxes);
			 RefObject[] syntaxes = resultSet.getRefObjects("cs");
			 resultSet = mql.execute(mqlTextBlocks);
			 RefObject[] rootTbs = resultSet.getRefObjects("tb");
			 
			 if(syntaxes.length > 0)
			 {
				 for(RefObject o : rootTbs)
				 {
					 o.refDelete();
				 }
				 
				 try
				 {
					 ConcreteSyntax s = null;
					 TCSExtractorStream stream = null;
					 if(syntaxes.length > 1)
					 {
						 ChooseConcreteSyntaxDialog dialog = new ChooseConcreteSyntaxDialog(syntaxes);
						 s = (ConcreteSyntax) dialog.execute(null);
					 }
					 else
					 {
						 s = (ConcreteSyntax) syntaxes[0];
						 
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
					 connection.save();
					 PrettyPrinterInfoDialog dialog = new PrettyPrinterInfoDialog("Pretty Printer", "Pretty Printer finished successfully!");
					 dialog.execute(null);
				 }
				 catch(Exception e)
				 {
					 e.printStackTrace();
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
