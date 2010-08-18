package com.sap.mi.tcs.parser;

import generated.TCSLexer;
import generated.TCSParser;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xml.type.internal.DataValue.URI;




public class TcsParserFactory extends AbstractParserFactory<TCSParser, TCSLexer> {

    private static final String TCS_LANGUAGE_ID = "TCS";

    @Override
	public String[] getHiddenChannelTokenNames() {
	return new String[] { "WS", "NL", "COMMENT" };
    }

  

    @Override
    public Class<TCSLexer> getLexerClass() {
	return TCSLexer.class;
    }

    @Override
    public Class<TCSParser> getParserClass() {
	return TCSParser.class;
    }

    @Override
    public EPackage getMetamodelPackage(ResourceSet connection) {
	return connection.getPackage(TcsPackage.PACKAGE_DESCRIPTOR);
    }

    @Override
    public String getLanguageId() {
	return TCS_LANGUAGE_ID;
    }
    
    /**
     * Adds the MOF metamodel partitions for PrimitiveTypes and the core MOF
     * meta-metamodel to the scope
     */
    @Override
    public Collection<URI> getParserLookupScope(ResourceSet connection) {
	Moin moin = connection.getSession().getMoin();
	Set<URI> referencePRIs = new HashSet<URI>();
	referencePRIs.add(moin
		.createPri("PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/PrimitiveTypes.moinmm"));
	referencePRIs.add(moin.createPri("PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/Model.moinmm"));
	return referencePRIs;
    }



	@Override
	public Integer[] getOmittedTokensForFormatting() {
		// TODO Auto-generated method stub
		return null;
	}

}
