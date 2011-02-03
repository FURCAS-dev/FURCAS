package com.sap.furcas.ide.editor.action;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.Lexer;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.query.index.ui.IndexFactory;
import org.eclipse.emf.query2.QueryContext;
import org.eclipse.emf.query2.QueryProcessor;
import org.eclipse.emf.query2.QueryProcessorFactory;
import org.eclipse.emf.query2.ResultSet;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import com.sap.furcas.ide.editor.EditorUtil;
import com.sap.furcas.ide.editor.dialogs.ChooseConcreteSyntaxDialog;
import com.sap.furcas.ide.editor.dialogs.PrettyPrinterInfoDialog;
import com.sap.furcas.ide.parserfactory.AbstractParserFactory;
import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage;
import com.sap.furcas.runtime.common.util.EcoreHelper;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.unparser.extraction.textblocks.TextBlockTCSExtractorStream;
import com.sap.furcas.unparser.textblocks.IncrementalTextBlockPrettyPrinter;

/**
 * 
 * @author Andreas Landerer
 * @version 1.0
 * 
 */
public class PrettyPrintAction extends Action {

    private final EObject modelElement;
    private final EClass clazz;
    private final boolean openEditorAfterPrettyPrint;
    private TextBlock resultBlock;
    private final QueryProcessor queryProcessor;

    public PrettyPrintAction(EClass clazz, EObject modelElement,
            boolean openEditorAfterPrettyPrint) {
        super("Pretty Print", PlatformUI.getWorkbench().getSharedImages()
                .getImageDescriptor(ISharedImages.IMG_ETOOL_PRINT_EDIT));
        this.setDisabledImageDescriptor(PlatformUI
                .getWorkbench()
                .getSharedImages()
                .getImageDescriptor(ISharedImages.IMG_ETOOL_PRINT_EDIT_DISABLED));
        this.setId("prettyPrint");
        this.clazz = clazz;
        this.modelElement = modelElement;
        this.openEditorAfterPrettyPrint = openEditorAfterPrettyPrint;
        queryProcessor = QueryProcessorFactory.getDefault().createQueryProcessor(IndexFactory.getInstance());
    }

    @Override
    public void runWithEvent(Event event) {
        try {
            Resource resource = modelElement.eResource();
            ResourceSet connection = resource.getResourceSet();

            Template template = determineTemplate(connection);
            ConcreteSyntax syntax = template.getConcreteSyntax();
            TextBlock textBlockToReuse = determineTextBlockToReuse(connection,
                    template);

            try {
                AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory = EditorUtil
                        .constructParserFactoryForSyntax(syntax);
                TextBlockTCSExtractorStream stream = new TextBlockTCSExtractorStream(TextblocksPackage.eINSTANCE, parserFactory);

                IncrementalTextBlockPrettyPrinter prettyPrinter = new IncrementalTextBlockPrettyPrinter();
                prettyPrinter.prettyPrint(modelElement, textBlockToReuse,
                        syntax, template, stream);
                resultBlock = stream.getPrintedResultRootBlock();
                if (resultBlock != null) {
                    resource.save(null);
                    PrettyPrinterInfoDialog dialog = new PrettyPrinterInfoDialog(
                            "Pretty Printer",
                            "Pretty Printer finished successfully!");
                    dialog.execute(null);
                    if (this.openEditorAfterPrettyPrint) {
                        //FIXME: Open editor
                    }
                } else {
                    PrettyPrinterInfoDialog dialog = new PrettyPrinterInfoDialog(
                            "Pretty Printer",
                            "Model Element was not pretty printed, please try superior model element!");
                    dialog.execute(null);
                }
            } catch (Exception e) {
                //FIXME: is this the correct way to revert the resource?
                resource.unload();
                e.printStackTrace();
                PrettyPrinterInfoDialog dialog = new PrettyPrinterInfoDialog(
                        "Pretty Printer",
                        "Pretty Printer failed with exception, see console!");
                dialog.execute(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Template determineTemplate(ResourceSet rs) throws Exception {
        
        Template template = null;

        QueryContext context = EcoreHelper.getQueryContext(rs);
        
        // select corresponding templates
        String mqlTemplates = "select template \n"
            + "from [" + EcoreUtil.getURI(TCSPackage.eINSTANCE.getClassTemplate()) + "] as template,"
            + "[" + EcoreUtil.getURI(EcorePackage.eINSTANCE.getEClass()) + "] as class in elements { "
            + "[" + EcoreUtil.getURI(clazz) + "] } "
                + "where template.metaReference = class";
        ResultSet resultSet = queryProcessor.execute(mqlTemplates, context);
        URI[] resultURIs = resultSet.getUris("template");
        List<EObject> templates = new ArrayList<EObject>(resultURIs.length);
        
        for (URI uri : resultURIs) {
            templates.add(rs.getEObject(uri, true));
        }

        if (templates.size() > 1) {
            // search and choose main template
            for (Object o : templates) {
                if (o instanceof ClassTemplate && ((ClassTemplate) o).isIsMain()) {
                    template = (ClassTemplate) o;
                }
            }
            if (template == null || template.getConcreteSyntax() == null) {
                ChooseConcreteSyntaxDialog dialog = new ChooseConcreteSyntaxDialog(
                        templates);
                Object o = dialog.execute(null);
                if (o instanceof ClassTemplate) {
                    template = (ClassTemplate) o;
                }
            }
        } else if (templates.size() == 1) {
            if (templates.iterator().next() instanceof ClassTemplate) {
                template = (ClassTemplate) templates.iterator().next();
            }
        } else {
            throw new Exception("No template found to print model element!");
        }
        return template;
    }

    public TextBlock determineTextBlockToReuse(ResourceSet rs,
            Template template) {
        TextBlock oldTextBlock = null;
        QueryContext context = EcoreHelper.getQueryContext(rs);

     // select corresponding text blocks to model element
        String mqlTextBlocks = "select template \n"
            + "from [" + EcoreUtil.getURI(TextblocksPackage.eINSTANCE.getTextBlock()) + "] as tb,"
            + "[" + EcoreUtil.getURI(EcorePackage.eINSTANCE.getEObject()) + "] as me in elements { "
            + "[" + EcoreUtil.getURI(modelElement) + "] } "
            + " as me  where tb.correspondingModelElements = me";
        ResultSet resultSet = queryProcessor.execute(mqlTextBlocks, context);
        URI[] resultURIs = resultSet.getUris("tb");
        List<EObject> rootTbs = new ArrayList<EObject>(resultURIs.length);
        
        for (URI uri : resultURIs) {
            rootTbs.add(rs.getEObject(uri, true));
        }  

        for (EObject o : rootTbs) {
            if (o instanceof TextBlock) {
                oldTextBlock = (TextBlock) o;

                // if template has no syntax contribution, pretty printing is
                // currently not possible
                if (oldTextBlock.getType() == null
                        || !template.equals(oldTextBlock.getType()
                                .getParseRule())) {
                    oldTextBlock = null;
                } else {
                    break;
                }
            }
        }
        return oldTextBlock;
    }

    public TextBlock getRootBlock() {
        return resultBlock;
    }
}