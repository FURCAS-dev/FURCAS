package com.sap.ide.cts.parser.incremental;

import java.util.ArrayList;
import java.util.List;

import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;

public class LookAheadSet {

	private final List<Entry> list = new ArrayList<Entry>();
	
//	private Entry currentEntry;

	public void advance(int offset) {
		// replace <tok,cla,cnt> in list with <tok,cla - offset,cnt + 1>
		for (Entry currentEntry : list) {
			currentEntry.characterLookahead = currentEntry.characterLookahead-offset;
			currentEntry.tokenLookback++;
		}
	}

	public void addItem(AbstractToken tok) {
		list.add(new Entry(tok, tok.getLookahead(),0));
	}

	public int computeLookback() {
		/*
		 * remove <tok,cla,cnt> s.t. cla <= 0 from list if (list == empty)
		 * return 0; else return max cnt j <tok,cla,cnt> in list
		 */
		List<Entry> removeObjects = new ArrayList<Entry>(); 
		for (Entry entry : list) {
			if(entry.characterLookahead<=0){
				removeObjects.add(entry);
			}
		}
		list.removeAll(removeObjects);
		if(list.isEmpty())
			return 0;
		
		//TODO this is a hack re-check algorithm then change to maxLookback =0;
		int maxLookback = 1;
		for (Entry entry2 : list) {
			if(entry2.tokenLookback> maxLookback)
				maxLookback = entry2.tokenLookback;
		}
		return maxLookback;
	}

	public boolean allItemsDiscardable() {
		/*
		 * forall <tok,cla,cnt> in list, !was_re_lexed(tok)
		 */
		boolean result = true;
		for (Entry entry : list) {
			result = wasReLexed(entry.token) && result;
		}
		return result;
	}

	private boolean wasReLexed(AbstractToken token) {
		return token.isRelexingNeeded();
	}

	private class Entry {
		private final AbstractToken token;
		private int characterLookahead;
		private int tokenLookback;

		public Entry(AbstractToken token, int characterLookahead,
				int tokenLookback) {
			super();
			this.token = token;
			this.characterLookahead = characterLookahead;
			this.tokenLookback = tokenLookback;
		}

		@Override
		public boolean equals(Object other) {
			if (other instanceof Entry) {
				Entry otherEntry = (Entry) other;
				return token.equals(otherEntry.token)
						&& characterLookahead == otherEntry.characterLookahead
						&& tokenLookback == otherEntry.tokenLookback;
			} else {
				return false;
			}
		}
	}
}
