/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2009-10-06 16:02:30 +0200 (Di, 06 Okt 2009) $
 * @version $Revision: 8209 $
 * @author: $Author: d043530 $
 *******************************************************************************/
package com.sap.mi.textual.epi.filedefinition;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;

import tcs.ConcreteSyntax;

import com.sap.mi.fwk.ModelManager;
import com.sap.mi.textual.common.exceptions.ModelAdapterException;
import com.sap.mi.textual.common.exceptions.ParserInvokationException;
import com.sap.mi.textual.common.interfaces.IMetaModelLookup;
import com.sap.mi.textual.epi.Activator;
import com.sap.mi.textual.grammar.exceptions.InvalidParserImplementationException;
import com.sap.mi.textual.grammar.exceptions.SyntaxParsingException;
import com.sap.mi.textual.grammar.exceptions.UnknownProductionRuleException;
import com.sap.mi.textual.grammar.impl.ParsingError;
import com.sap.mi.textual.grammar.impl.tcs.t2m.AbstractTCSGrammarGenerator;
import com.sap.mi.textual.grammar.impl.tcs.t2m.TCSSyntaxContainerBean;
import com.sap.mi.textual.syntaxmodel.moinadapter.ModelInjectionResult;
import com.sap.mi.textual.syntaxmodel.moinadapter.TCS2MOINInjectorFacade;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.NullPartitionNotEmptyException;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.PartitionsNotSavedException;
import com.sap.tc.moin.repository.ReferencedTransientElementsException;


/**
 * The Class TCSInputStreamGrammarGenerator, generates a Grammar based on an InputStream
 * containing a TCS definition of a syntax.
 */
public class TCSInputStreamGrammarGenerator extends AbstractTCSGrammarGenerator {

	private static final String MAPPING_XMI_POSTFIX = "Mapping.xmi";
	/** The syntax definition stream. */
	private InputStream syntaxDefinitionStream;

	/**
	 * Instantiates a new TCS input stream grammar generator.
	 * 
	 * @param syntaxDefinitionStream the syntax definition stream
	 * @param out the out
	 * @param lookup the lookup
	 * @param qualifiedNamesSeparator 
	 * @param targetPackage 
	 */
	public TCSInputStreamGrammarGenerator(	InputStream syntaxDefinitionStream, OutputStream out, IMetaModelLookup<?> lookup, String targetPackage) {
		super(out, lookup, targetPackage);
		this.syntaxDefinitionStream = syntaxDefinitionStream;
	}


	private TCSSyntaxContainerBean initMembers(InputStream definitionInputStream, Connection connection, Set<PRI> metamodelPRIs) throws InvalidParserImplementationException, IOException, UnknownProductionRuleException, SyntaxParsingException, ModelAdapterException {

        // By choosing this injector, we establish the dependency to MOIN.
	    ModelInjectionResult result = TCS2MOINInjectorFacade.parseSyntaxDefinition(definitionInputStream, connection, metamodelPRIs, null);
		
		List<ParsingError> errors = result.getResult().getErrors();
		if (errors != null && errors.size() > 0) {
		    if (result.getSyntax() != null) {
			// also clean up unfinished syntax
			result.getSyntax().refDelete();
		    }
		    throw new SyntaxParsingException(errors);
		} 

		TCSSyntaxContainerBean returnBean = new TCSSyntaxContainerBean();

		
		
		ConcreteSyntax syntax = result.getSyntax();
	
        returnBean.setSyntax(syntax );
            
		returnBean.setKeywords(result.getKeywords());	

		returnBean.setElementToLocationMap(result.getResult().getLocationMap());
		
		return returnBean;
	}


	/* (non-Javadoc)
	 * @see com.sap.mi.textual.grammar.impl.tcs.t2m.AbstractTCSGrammarGenerator#doGetSyntaxDef()
	 */
	@Override
	protected TCSSyntaxContainerBean doGetSyntaxDef(Connection connection, Set<PRI> metamodelPRIs) throws IOException, SyntaxParsingException, ModelAdapterException, ParserInvokationException
	 {
		try {
            return initMembers(syntaxDefinitionStream, connection, metamodelPRIs);
        } catch (IllegalArgumentException e) {
            throw new ParserInvokationException(e);
        } catch (SecurityException e) {
            throw new ParserInvokationException(e);
        } catch (UnknownProductionRuleException e) {
            throw new ParserInvokationException(e);
        } catch(InvalidParserImplementationException e) {
            throw new ParserInvokationException(e);
        }
	}


	@Override
	protected TCSSyntaxContainerBean doGetSyntaxDef(Connection connection,
			Set<PRI> metamodelPRIs, String languageId)
			throws SyntaxParsingException, IOException, ModelAdapterException,
			ParserInvokationException {
		return doGetSyntaxDef(connection, metamodelPRIs);
	}


	/**
	 * Writes the given syntax to a default partition. The partition location is 
	 * constructed within the src folder of the given <tt>project</tt>
	 * with the name of the {@link ConcreteSyntax syntax} postfixed with "Mapping.xmi".
	 * If a the partition already exists it will be emptied.
	 * 
	 * @param project
	 * @param syntax
	 */
	public void writeMappingToFile(IProject project, ConcreteSyntax syntax) {
		Connection connection = ((Partitionable)syntax).get___Connection();
		ModelPartition partition = getOrCreateMappingPartition(project, syntax, connection);
		for (Partitionable element : connection.getNullPartition().getElements()) {
			partition.assignElementIncludingChildren(element);
		}
		try {
			connection.save();
		} catch (NullPartitionNotEmptyException e) {
			Activator.logError(e);
		} catch (ReferencedTransientElementsException e) {
			Activator.logError(e);
		} catch (PartitionsNotSavedException e) {
			Activator.logError(e);
		}
	}


	private ModelPartition getOrCreateMappingPartition(IProject project,
			ConcreteSyntax syntax, Connection connection) {
		IPath partitionRelativePath = project.getFile("mappings/"+syntax.getName() + MAPPING_XMI_POSTFIX).getProjectRelativePath();
		ModelPartition partition = ModelManager.getPartitionService().getPartition(connection, project, partitionRelativePath);
		if(partition != null) {
			partition.deleteElements();
		} else {
			partition = ModelManager.getPartitionService().createPartition(connection, project, 
					partitionRelativePath, syntax);
		}
		return partition;
	}
	
}
