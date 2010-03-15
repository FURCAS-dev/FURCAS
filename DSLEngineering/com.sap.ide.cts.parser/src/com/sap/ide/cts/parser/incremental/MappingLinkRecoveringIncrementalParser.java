package com.sap.ide.cts.parser.incremental;

import java.util.Collection;
import java.util.Collections;

import tcs.ClassTemplate;
import tcs.Template;
import textblockdefinition.TextBlockDefinition;
import textblocks.Bostoken;
import textblocks.DocumentNode;
import textblocks.LexedToken;
import textblocks.TextBlock;
import textblocks.TextblocksPackage;

import com.sap.ide.cts.parser.incremental.antlr.ANTLRIncrementalLexerAdapter;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import com.sap.mi.textual.parsing.textblocks.TbNavigationUtil;
import com.sap.mi.textual.parsing.textblocks.observer.ParserTextBlocksHandler;
import com.sap.mi.textual.parsing.textblocks.observer.TextBlockProxy;
import com.sap.mi.textual.tcs.util.TcsUtil;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;

public class MappingLinkRecoveringIncrementalParser extends IncrementalParser {

	public MappingLinkRecoveringIncrementalParser(Connection connection,
		ParserFactory<?, ?> parserFactory, IncrementalLexer incrementalLexer,
		ObservableInjectingParser batchParser, TextBlockReuseStrategy reuseStrategy,
		Collection<CRI> additionalCRIScope) {
		super(connection, parserFactory, incrementalLexer, batchParser, reuseStrategy, additionalCRIScope);
	}

	public void recoverMappingLink(TextBlock existingRoot, ClassTemplate rootTemplate)
		throws TextBlockMappingRecoveringFailedException {
		ParserTextBlocksHandler parserTextBlocksHandler = new ParserTextBlocksHandler(
			tbtokenStream, connection, parserFactory.getMetamodelCri(connection),
			TcsUtil.getSyntaxePartitions(connection, parserFactory.getLanguageId()),
			parserFactory.getParserLookupScope(connection), additionalCRIScope);
		// IParsingObserver originalObserver = batchParser.getObserver();
		batchParser.setObserver(parserTextBlocksHandler);
		((ANTLRIncrementalLexerAdapter) batchParser.input.getTokenSource())
			.setCurrentTokenForParser(existingRoot.getTokens().get(0));
		// Ensure no model elements get created
		// only proxies should be created
		boolean originalResolveProxiesValue = batchParser.isResolveProxies();
		prepareForParsing(existingRoot, parserTextBlocksHandler);
		batchParser.setResolveProxies(false);
		try {
			existingRoot.setType(tbFactory.getTbDef(rootTemplate));
			RecoverMappingLinkComand rmlc = new RecoverMappingLinkComand(connection,
				existingRoot, parserTextBlocksHandler);
			connection.getCommandStack().execute(rmlc);
			if (rmlc.hasFailed()) {
				// connection.getCommandStack().undo();
				throw new TextBlockMappingRecoveringFailedException(
					"Cannot recover textblock to mapping link due to the following errors:"
						+ rmlc.getException());
			}
			if (batchParser.getInjector().getErrorList().size() > 1) {
				throw new TextBlockMappingRecoveringFailedException(
					"Cannot recover textblock to mapping link due to the following parse errors:"
						+ batchParser.getInjector().getErrorList());
			}
		} catch (Exception e) {
			throw new TextBlockMappingRecoveringFailedException(e);
		} finally {
			batchParser.setResolveProxies(originalResolveProxiesValue);
		}
	}

	public class RecoverMappingLinkComand extends Command {

		private final TextBlock existingRoot;
		private boolean failed = false;
		private Exception exception;
		private final ParserTextBlocksHandler parserTextBlocksHandler;

		public RecoverMappingLinkComand(Connection con, TextBlock existingRoot,
			ParserTextBlocksHandler parserTextBlocksHandler) {
			super(con);
			this.existingRoot = existingRoot;
			this.parserTextBlocksHandler = parserTextBlocksHandler;

		}

		@Override
		public boolean canExecute() {
			return true;
		}

		@Override
		public void doExecute() {
			try {
				callBatchParser(existingRoot);
				//FIXME: evaluate foreach references to reestablish links where templates used in foreachs
				//are referenced as additionalTemplates
				TextBlockProxy proxy = parserTextBlocksHandler.getCurrentTbProxy();
				recoverMappingLink(existingRoot, proxy);
			} catch (Exception ex) {
				exception = ex;
				failed = true;
			}
		}

		private void recoverMappingLink(TextBlock textBlock, TextBlockProxy proxy) {
			if (proxy.getSubNodes().size() != TbNavigationUtil
				.getSubNodesSize(textBlock)) {
				if (TbNavigationUtil.getSubNodeAt(textBlock, 0) instanceof Bostoken) {
					if (proxy.getSubNodes().size() + 2 != TbNavigationUtil
						.getSubNodesSize(textBlock)) {
						failed = true;
						return;
					}
				} else {
					failed = true;
					return;
				}
			}
			textBlock.setSequenceElement(proxy.getSequenceElement());
			TextBlockDefinition tbDef = getTbDef(proxy.getTemplate());
			if (tbDef == null) {
				failed = true;
				return;
			}
			textBlock.setType(tbDef);
			int i = 0;
			for (DocumentNode n : TbNavigationUtil.getSubNodes(textBlock)) {
				if (n instanceof TextBlock) {
					TextBlockProxy subNodeProxy = (TextBlockProxy) proxy
						.getSubNodes().get(i);
					recoverMappingLink((TextBlock) n, subNodeProxy);
				}
				if (n instanceof LexedToken
					&& ((LexedToken) n).getSequenceElement() == null) {
					((LexedToken) n).setSequenceElement(proxy
						.getSequenceElement());
				}
				if (!(n instanceof Bostoken)) {
					i++;
				}
			}
		}

		private TextBlockDefinition getTbDef(Template t) {
			Collection<TextBlockDefinition> tbDefs = getConnection().getPackage(
				TextblocksPackage.PACKAGE_DESCRIPTOR).getTextblockdefinition()
				.getTextblockDefinitionReferencesProduction()
				.getTextBlockDefinition(t);
			if (!tbDefs.isEmpty()) {
				if (tbDefs.size() == 1) {
					return tbDefs.iterator().next();
				} else {
					// TODO What to do if there is more than one?
					// for now this case seems strange, so throw an exception

				}
			}
			return null;
		}

		@Override
		public Collection<PartitionOperation> getAffectedPartitions() {
			Partitionable partitionable = existingRoot;
			PRI pri = partitionable.get___Partition().getPri();
			PartitionOperation editOperation = new PartitionOperation(
				PartitionOperation.Operation.EDIT, pri);
			return Collections.singleton(editOperation);
		}

		public boolean hasFailed() {
			return failed;
		}

		public void setException(Exception exception) {
			this.exception = exception;
		}

		public Exception getException() {
			return exception;
		}

	}

}
