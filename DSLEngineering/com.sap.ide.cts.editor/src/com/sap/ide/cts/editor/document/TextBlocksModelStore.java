/**
 * 
 */
package com.sap.ide.cts.editor.document;

import org.eclipse.jface.text.ITextStore;

import com.sap.furcas.metamodel.textblocks.AbstractToken;
import com.sap.furcas.metamodel.textblocks.TextBlock;
import com.sap.ide.cts.editor.CtsActivator;

/**
 * This is an implementation if {@link ITextStore} which serves as storage
 * mediator between {@link CtsDocument} and a Textblocks model comprised of a
 * tree of {@link TextBlock TextBlocks}.
 * 
 * @author C5106462
 * 
 */
public class TextBlocksModelStore implements ITextStore {

	private TextBlocksModel model;

	/**
	 * Constructs a store that is initialized with the given {@link TextBlock}.
	 * 
	 * @param rootBlock
	 * @param modelAdapter 
	 */
	public TextBlocksModelStore(TextBlock rootBlock, IModelElementInvestigator modelAdapter) {
		model = new TextBlocksModel(rootBlock, modelAdapter);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.text.ITextStore#get(int)
	 */
	@Override
	public synchronized char get(int offset) {
		try {
			return model.get(offset);
		} catch (Exception e) {
			CtsActivator.logError(e);
			return '#';
		}
	}

	/**
	 * iterates over the elements of the textblock tree to construct the string
	 * reaching from the given offset to the given offset + length position.
	 */
	@Override
	public synchronized String get(int offset, int length) {
		// TODO remove synchronization once we know it is not relevant
		try {
			return model.get(offset, length);
		} catch (Exception e) {
			// cannot throw anything, or eclipse Editor will never shut down
			CtsActivator.logError(e);
			String resultString = "";
			for (int i = 0; i < length; i++) {
				resultString += '#';
			}
			return resultString;
		}
	}

	/**
	 * Returns the token at the offset, or the last token before the offset.
	 * 
	 * @param offset
	 *            absolute offset in text
	 * @return token at the offset, last token before the offset, or null, if no
	 *         lexed tokens in textblocks model
	 */
	public synchronized AbstractToken getFloorToken(int offset) {
		try {
			return model.getFloorTokenInRoot(offset);
		} catch (Exception e) {
			CtsActivator.logError(e);
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.text.ITextStore#getLength()
	 */
	@Override
	public synchronized int getLength() {
	    try {
	        return model.getLength();
	    } catch (RuntimeException e) { // catches Exceptions caused by bugs, mainly if root block has been deleted
	        CtsActivator.logError(e);
	        return 0;
	    }
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.text.ITextStore#set(java.lang.String)
	 */
	@Override
	public synchronized void set(String text) {
	    try {
	        replace(0, model.getLength(), text);
	    } catch (Exception e) {
            CtsActivator.logError(e);
        }
	}

	/**
	 * Sets the root {@link TextBlock} to work on.
	 * 
	 * @param rootBlock
	 */
	public void setRootTextBlock(TextBlock rootBlock) {
		model.setRootTextBlock(rootBlock);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.text.ITextStore#replace(int, int,
	 *      java.lang.String)
	 */
	@Override
	public synchronized void replace(int replacedRegionOffset,
			int replacedRegionLength, String newText) {
		try {
			model.replace(replacedRegionOffset, replacedRegionLength, newText);
		} catch (Exception e) {
			CtsActivator.logError(e);
		}
	}

	/**
	 * Returns the current {@link TextBlocksModel}.
	 * @return
	 */
	public TextBlocksModel getModel() {
		return model;
	}

	public void reduceToMinimalState() {
	    //model.reduceToMinimalVersion();
	}

	public void expandToEditableVersion() {
	    model.doShortPrettyPrintToEditableVersion();
	}

}
