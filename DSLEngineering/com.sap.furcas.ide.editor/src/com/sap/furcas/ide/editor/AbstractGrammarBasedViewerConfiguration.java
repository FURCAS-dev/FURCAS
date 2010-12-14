/**
 * 
 */
package com.sap.furcas.ide.editor;

import java.util.ArrayList;
import java.util.Iterator;

import org.antlr.runtime.Lexer;
import org.antlr.runtime.Parser;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.reconciler.IReconciler;
import org.eclipse.jface.text.reconciler.MonoReconciler;
import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationHover;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

import com.sap.furcas.ide.editor.autoedit.ClosingBraceAutoEditStrategy;
import com.sap.furcas.ide.editor.autoedit.CtsAutoEditStrategy;
import com.sap.furcas.ide.editor.document.CtsDocument;
import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.runtime.textblocks.TbUtil;


public class AbstractGrammarBasedViewerConfiguration extends SourceViewerConfiguration {

    	protected final AbstractGrammarBasedEditor editor;
    	private final IAnnotationModel annotationModel;
	private final Class<? extends Lexer> myLexerClass;
	private final Class<? extends Parser> parserClass;
	private final ITokenMapper myMapper;
//	private Parameter[] context = null;
	private ContentAssistant myAssistant;
        private final ResourceSet connection;
	private final String languageId;


	/**
	 * 
	 */
	public AbstractGrammarBasedViewerConfiguration(ResourceSet connection,
			IAnnotationModel annotationModel,
			/*Parameter[] context,*/ Class<? extends Lexer> lexerClass,
			Class<? extends Parser> parserClass, ITokenMapper myMapper, String languageId,
			AbstractGrammarBasedEditor editor) {
		this.annotationModel = annotationModel;
		this.myLexerClass = lexerClass;
		this.parserClass = parserClass;
		this.myMapper = myMapper;
		this.connection = connection;
//		this.context = context;
		this.languageId = languageId;
		//added editor 
		this.editor=editor;
	}
	//added by Armagan
	@Override
	public IAutoEditStrategy[] getAutoEditStrategies(ISourceViewer sourceViewer, String contentType) {
		return new IAutoEditStrategy[]{new CtsAutoEditStrategy(),new ClosingBraceAutoEditStrategy()};
	} 
	
	@Override
	public int getTabWidth(ISourceViewer sourceViewer) {		
		return 2;
	}
	@Override
	public IReconciler getReconciler(ISourceViewer sourceViewer)
	    {
	        CtsReconcilingStrategy strategy = new CtsReconcilingStrategy();
	        strategy.setEditor(editor);
	                
	        MonoReconciler reconciler = new MonoReconciler(strategy,false);
	        
	        return reconciler;
	    }

	@Override
	public IContentAssistant getContentAssistant(ISourceViewer sourceViewer) {
//		if (getMyAssistant() == null) {
//			setMyAssistant(new ContentAssistant());
//			getMyAssistant().setContentAssistProcessor(
//					new CtsContentAssistProcessor(connection, getLexerClass(), getParserClass(),
//							languageId),
//					IDocument.DEFAULT_CONTENT_TYPE);
//			getMyAssistant().setAutoActivationDelay(1);
//			getMyAssistant().enableAutoActivation(true);
//		}
		return getMyAssistant();
	}
	
	@Override
	public String[] getConfiguredContentTypes(ISourceViewer sourceViewer) {
		return new String[] {IDocument.DEFAULT_CONTENT_TYPE, FurcasPartitionScanner.COMMENT};
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.text.source.SourceViewerConfiguration#getPresentationReconciler(org.eclipse.jface.text.source.ISourceViewer)
	 */
	@Override
	public IPresentationReconciler getPresentationReconciler(
			ISourceViewer sourceViewer) {
		PresentationReconciler reconciler = new PresentationReconciler();
		reconciler.setDocumentPartitioning(FurcasDocumentSetupParticpant.PARTITIONING);

		MultilineDamagerRepairer dr = new MultilineDamagerRepairer(getKeywordScanner());
		reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
		reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);

		TextAttribute commentAttr = TextAttribute();
		dr = new MultilineDamagerRepairer(null, commentAttr);
		reconciler.setDamager(dr, FurcasPartitionScanner.COMMENT);
		reconciler.setRepairer(dr, FurcasPartitionScanner.COMMENT);

		return reconciler;
	}
	
	private TextAttribute TextAttribute() {
	    return myMapper.getComment();
	}

	@Override
	public String getConfiguredDocumentPartitioning(ISourceViewer sourceViewer) {
		return FurcasDocumentSetupParticpant.PARTITIONING;
	}

	@Override
	public IAnnotationHover getAnnotationHover(ISourceViewer sourceViewer) {
		return new AnnotationHover(annotationModel);
	}

	private ITokenScanner getKeywordScanner() {
		return new ANTLRTokenScannerAdapter(myLexerClass,myMapper);
	}

	public void setMyAssistant(ContentAssistant myAssistant) {
		this.myAssistant = myAssistant;
	}

	public ContentAssistant getMyAssistant() {
		return myAssistant;
	}
	
	@Override
	public ITextHover getTextHover(ISourceViewer sourceViewer, String contentType) {
		return new CtsTextHover(sourceViewer);
	}

	protected Class<? extends Lexer> getLexerClass() {
		return myLexerClass;
	}

	protected Class<? extends Parser> getParserClass() {
		return parserClass;
	}



// annotation hover manager
public static class AnnotationHover implements IAnnotationHover, ITextHover {
	private final IAnnotationModel fAnnotationModel;

	public AnnotationHover(IAnnotationModel annotationModel) {
		this.fAnnotationModel = annotationModel;
	}

	@Override
	public String getHoverInfo(ISourceViewer sourceViewer, int lineNumber) {
	    if (fAnnotationModel == null) {
	        // TODO remove if robust
	        CtsActivator.logWarning("Bug (non-critical) in getHoverInfo: Annotationmodel is null");
	        return "";
	    }
		Iterator<?> ite = fAnnotationModel.getAnnotationIterator();

		ArrayList<String> all = new ArrayList<String>();

		while (ite.hasNext()) {
			Annotation a = (Annotation) ite.next();
			if (a instanceof Annotation) {
				try {
					int lineOfAnnotation = sourceViewer.getDocument().getLineOfOffset(fAnnotationModel.getPosition(a).getOffset());
					if(lineOfAnnotation == lineNumber) {
						all.add((a).getText());
					}
				} catch (BadLocationException e) {
					//do not add annotation
				}
			}
		}

		StringBuffer total = new StringBuffer();
		for (int x = 0; x < all.size(); x++) {
			String str = all.get(x);
			total.append(" " + str + (x == (all.size() - 1) ? "" : "\n"));
		}

		return total.toString();
	}

	@Override
	public String getHoverInfo(ITextViewer viewer, IRegion hoverRegion) {
		AbstractToken token = ((CtsDocument)viewer.getDocument()).getTextBlocksModelStore().getFloorToken(hoverRegion.getOffset());
		return token.toString();
	}

	@Override
	public IRegion getHoverRegion(ITextViewer viewer, int offset) {
			AbstractToken token = ((CtsDocument)viewer.getDocument()).getTextBlocksModelStore().getFloorToken(offset);
			IRegion region = new Region(TbUtil.getAbsoluteOffset(token), token.getLength());
			return region;
	}
}
}