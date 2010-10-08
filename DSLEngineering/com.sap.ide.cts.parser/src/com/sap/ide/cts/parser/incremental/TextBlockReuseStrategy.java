package com.sap.ide.cts.parser.incremental;

import java.util.Collection;

import com.sap.furcas.metamodel.textblocks.AbstractToken;
import com.sap.furcas.metamodel.textblocks.TextBlock;
import com.sap.furcas.parsing.textblocks.TextBlockFactory;
import com.sap.furcas.parsing.textblocks.observer.TextBlockProxy;

/**
 * This interface defines method that need to be implemented for an incremental
 * parsing strategy that defines if a textblock can be re-used and if certain
 * model elements can be re-used. The decision should be made by considering the
 * old versions of a textblock as well as the new ones.
 * 
 * @author C5106462
 * 
 */
public interface TextBlockReuseStrategy {

	public enum ReuseType {
		INSERT,DELETE,MERGE, COMPLETE;
	}

	public class TbBean {

		public final TextBlock textBlock;
		public final boolean isNew;
		public final ReuseType reuseType;
		public final boolean referenceOnly;

		public TbBean(TextBlock createNewTextBlock, boolean isNew, ReuseType reuseType) {
			this.textBlock = createNewTextBlock;
			this.isNew = isNew;
			this.reuseType = reuseType;
			this.referenceOnly = false;
		}

		public TbBean(TextBlock tb, boolean isNew, ReuseType reuseType,
			boolean referenceOnly) {
		    this.referenceOnly = referenceOnly;
		    this.textBlock = tb;
		    this.isNew = isNew;
		    this.reuseType = reuseType;
		}		
	}
	/**
	 * Returns the re-useable parts of a textblock subtree. For parts that cannot be
	 * reused a callback is made to the registered ITextBlockCreator instance.
	 * 
	 * @param oldVersion
	 * @param newVersion
	 * @return
	 */
	TbBean reuseTextBlock(TextBlock oldVersion, TextBlockProxy newVersion);

	void setTextBlockFactory(TextBlockFactory factory);
	
	void setReferenceHandler(ReferenceHandler handler);

	/**
	 * Decides whether a token candidate can be reused given a newly lexed
	 * newToken. This has to include a a decision that is able to decide if a
	 * token represents the same element from a model. As decisions on whether
	 * to create, reuse or delete the corresponding element are based on the
	 * identity of these tokens.
	 * 
	 * @param candidate
	 * @param newToken
	 * @return <code>true</code> If the candidate represents the newToken,
	 *         <code>false</code> if not.
	 */
	boolean canBeReUsed(AbstractToken candidate, Object newToken);

	/**
	 * If within {@link ITextBlockCreator#createNewTextBlock(TextBlockProxy)} any tokens were possibly reused
	 * this method has to be called to check if there are any actions necessary upon this.
	 * @param subNode
	 */
	void notifyTokenReuse(AbstractToken subNode);

	/**
	 * Clears the list of changed blocks that were collected since the last call of
	 * {@link #clearChangedBlocksList()}.
	 */
	void clearChangedBlocksList();
	
	/**
	 * Retuns the list of changed {@link TextBlock}s that were collected since the last call of 
	 * {@link #clearChangedBlocksList()}. It contains all blocks that were not reused but were newly
	 * created by the {@link TextBlockReuseStrategy}.
	 */
	Collection<TextBlock> getChangedBlocks();
}
