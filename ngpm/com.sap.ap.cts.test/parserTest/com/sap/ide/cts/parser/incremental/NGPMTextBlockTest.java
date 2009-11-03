package com.sap.ide.cts.parser.incremental;

import java.util.Arrays;

import ngpm.NgpmPackage;

import org.junit.BeforeClass;

import textblocks.AbstractToken;
import textblocks.LexedToken;
import textblocks.TextBlock;
import textblocks.VersionEnum;

import com.sap.mi.textual.moin.standalone.StandaloneConnectionFactoryFacade;
import com.sap.mi.textual.parsing.textblocks.TestTextBlocksModelElementFactory;
import com.sap.mi.textual.parsing.textblocks.TestTextBlocksModelElementMoinFactory;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Moin;

/**
 * Base class for TextBlock related test cases. Sets up a common fixture model
 * and makes all elements available through protected members.
 * 
 * @author D052602
 * 
 */
public class NGPMTextBlockTest {

	protected static TestTextBlocksModelElementFactory modelFactory;
	protected static Connection connection;
	private static final String[] MMJars = new String[]{"mmbuild/ngpm.zip",  "mmbuild/tcs.zip"};


	private static boolean warningDone;

    /**
     * @param content
     * @return
     */
    protected LexedToken createToken(String content) {
        LexedToken contentToken = modelFactory.createLexedToken();
        contentToken.setValue(content);
        contentToken.setLength(content.length());
        contentToken.setEndColumn(content.length());
        contentToken.setType(0);
        contentToken.setVersion(VersionEnum.REFERENCE);
        return contentToken;
    }
    
    public static Connection getTestConnection(String[] jarpaths) {
        if (connection == null || !connection.isAlive()) {            
            if (! warningDone) {
                System.out.println("Getting standalone MOIN connection using jarpath: " + Arrays.toString(jarpaths));
                System.out.println("NullPointer or ClassNotFound or JMIExeptions in later following code may be due to outdated jar file.");
            }
            warningDone = true;
            //"C:\\japro\\moin_dev\\local\\moin.imoin\\CoreDev_stream\\src\\SCs\\sap.com\\TCSMeta\\DCs\\sap.com\\tcsmeta\\_comp\\gen\\default\\public\\def_assmbl\\lib\\moin\\demo.sap.com~tcsmeta~def_assmbl.zip";
//          StandaloneArgumentsBean bean = new StandaloneArgumentsBean();
////        path to jar file as created by build
//          bean.setMetamodelJars(new String[]{"C:\\japro\\moin_dev\\local\\moin.imoin\\CoreDev_stream\\src\\SCs\\sap.com\\TCSMeta\\DCs\\sap.com\\tcsmeta\\_comp\\gen\\default\\public\\def_assmbl\\lib\\moin\\demo.sap.com~tcsmeta~def_assmbl.zip"});
////        path to eclipse wrapper project
//          bean.setSourcePath( "C:\\japro\\moin_dev\\local\\moin.test\\CoreDev_stream\\src\\_com.sap.demo.tcsmeta.mm.eclips2e");

            Connection co = StandaloneConnectionFactoryFacade.getMetaModelConnection(jarpaths);

            NgpmPackage pack = co.getPackage(NgpmPackage.PACKAGE_DESCRIPTOR);
            if (pack == null) {
                throw new IllegalStateException("Connection could not resolve NGPM root package, check paths : " + Arrays.toString(jarpaths));
            }
            connection = co;
        }
        return connection;
    }
    
    public static Moin getBuildMoin() {
        String[] jarpaths = MMJars;
        return StandaloneConnectionFactoryFacade.getMoin(jarpaths);
    }

    
    @BeforeClass
	public static void setModelFactory() {
		connection = getTestConnection(MMJars);
		modelFactory = new TestTextBlocksModelElementMoinFactory(connection);
	}
    
    public static TextBlock initialiseTextBlocksWithContentToken(AbstractToken contentToken) {
        TextBlock rootBlock;
        rootBlock = modelFactory.createTextBlock();
//                ((Partitionable) rootObject).get___Partition());
//        rootBlock.getCorrespondingModelElements().add((RefObject) rootObject);
        rootBlock.getTokens().add(modelFactory.createBostoken());
        AbstractToken eosToken =modelFactory.createEostoken();
        
        if (contentToken != null) {
            rootBlock.getTokens().add(contentToken);
            
            rootBlock.setLength(contentToken.getLength());
            rootBlock.setComplete(true);
            rootBlock.setEndColumn(contentToken.getLength());
            rootBlock.setCachedString(contentToken.getValue());
            eosToken.setOffset(contentToken.getLength());
        }
        
        
        rootBlock.getTokens().add(
                eosToken);
        rootBlock.setVersion(VersionEnum.REFERENCE);
        //TODO: make this paramterizable: either assign to same or separate partiotion
//        ((Partitionable)rootObject).get___Partition().assignElement(rootBlock);
        return rootBlock;
    }

}
