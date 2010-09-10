/**
 * 
 */
package com.sap.mi.textual.bootstrap;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.sap.ide.cts.editor.test.util.StandaloneMoinLookUp;
import com.sap.mi.textual.common.interfaces.IMetaModelLookup;
import com.sap.mi.textual.epi.filedefinition.GrammarWritingHelper;
import com.sap.mi.textual.moin.standalone.MOINTCSMetaConnectionProvider;
import com.sap.mi.textual.syntaxmodel.emfadapter.MoinContext;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 *
 */
public class TCSBootStrap {

    
    private static final String GENERATIONDIR = "./bootstrap/";
    
    public static void main(String[] args)  {
        try {
            File grammarFile = new File(GENERATIONDIR + "TCS.g");
    
            File syntaxDefFile = new File(GENERATIONDIR + "TCS.tcs");
            
            Connection connection = MOINTCSMetaConnectionProvider.getTestConnection();
//            String metamodelLocation = "./scenarioTestResource/metamodels/";
//            File classifiers = new File(GENERATIONDIR  + "TCS.ecore");
//            File primitives = new File(GENERATIONDIR  + "TCS1.ecore");
            
//            IMetaModelLookup lookup = new EcoreMetaLookUp(classifiers, primitives);
            
            Collection<PRI> priList = new ArrayList<PRI>();

            Moin moin = MOINTCSMetaConnectionProvider.getBuildMoin();
            // required for further code to run, else Eclipse Moin will tried to be started.
            MoinContext.setMoin(moin);
            
            PRI pri = moin.createPri("PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/PrimitiveTypes.moinmm");
            priList.add(pri);
            pri = moin.createPri("PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/Model.moinmm");
            priList.add(pri);
            pri = moin.createPri("PF.MetaModelDataArea:DCs/demo.sap.com/tcsmeta/_comp/moin/meta/Metamodel.moinmm");
            priList.add(pri);
            
            
            
            IMetaModelLookup<RefObject> lookup = new StandaloneMoinLookUp(connection, priList);
            
            Collection<String> warnings = GrammarWritingHelper.writeGrammarIfChanged(lookup, syntaxDefFile, grammarFile, "::", "com.sap.mi.textual.grammar.parser", connection, null);
            for (Iterator<String> iterator = warnings.iterator(); iterator.hasNext();) {
                String message = iterator.next();
                System.out.println("Warning: " + message);
            }
            System.out.println("Wrote grammar to " + grammarFile.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Grammar Generation Failed");
        } finally {
            
        }
    }
    
}
