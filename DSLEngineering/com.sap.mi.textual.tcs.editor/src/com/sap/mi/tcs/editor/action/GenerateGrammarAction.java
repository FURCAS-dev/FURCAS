package com.sap.mi.tcs.editor.action;

import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import tcs.ConcreteSyntax;
import tcs.Keyword;

import com.sap.mi.textual.common.exceptions.GrammarGenerationException;
import com.sap.mi.textual.common.exceptions.MetaModelLookupException;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import com.sap.mi.textual.grammar.impl.TextLocation;
import com.sap.mi.textual.grammar.impl.tcs.t2m.TCSSyntaxContainerBean;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.ANTLR3GrammarWriter;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.ANTLRGrammarGenerator;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.GenerationReport;
import com.sap.mi.textual.grammar.impl.tcs.t2m.validation.SyntaxDefinitionValidation;
import com.sap.mi.textual.moinlookup.MoinMetaLookup;
import com.sap.mi.textual.syntaxmodel.moinadapter.MOINTCSAdapter;
import com.sap.tc.moin.repository.Connection;

public class GenerateGrammarAction extends Action {

    private static final String GENERATIONDIR = "generated";
    private ConcreteSyntax syntax;
    private Connection connection;

    public GenerateGrammarAction(ConcreteSyntax modelElement, boolean b) {
        super("Generate Grammar", PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ETOOL_PRINT_EDIT));
        this.setDisabledImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(
                ISharedImages.IMG_ETOOL_PRINT_EDIT_DISABLED));
        this.setId("generateGrammar");
        //super(clazz.getName());
        //setImageDescriptor(Activator.getImageDescriptor(clazz));
        this.syntax = modelElement;
        this.connection = syntax.get___Connection();
    }

    @Override
    @SuppressWarnings("unchecked")
    public void runWithEvent(Event event) {
        ANTLR3GrammarWriter writer = new ANTLR3GrammarWriter();
        ANTLRGrammarGenerator mapper = new ANTLRGrammarGenerator();
        MoinMetaLookup lookup = new  MoinMetaLookup(connection, null);
        MOINTCSAdapter handler = new MOINTCSAdapter(syntax.get___Connection(), null);
        
        TCSSyntaxContainerBean bean = new TCSSyntaxContainerBean();
        bean.setSyntax(syntax);
        Set<?> keywords = handler.getElementsByType("TCS::Keyword");
        bean.setKeywords((Set<Keyword>)keywords);

        bean.setElementToLocationMap(new HashMap<Object, TextLocation>());

        try {
            GenerationReport report = mapper.generateGrammar(writer,
                    lookup, bean, new SyntaxDefinitionValidation(), ObservableInjectingParser.class);

            writer.setTargetPackage("generated");
            
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            // write OuputStream
            try {
                out.write(writer.getOutput().getBytes());
            } catch (GrammarGenerationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                out.flush();
                out.close();
            }
            String grammarFile = GENERATIONDIR + syntax.getName() + ".g";
            FileWriter fileWriter;
            
                fileWriter = new FileWriter(grammarFile);
            
            fileWriter.write(out.toString());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MetaModelLookupException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
