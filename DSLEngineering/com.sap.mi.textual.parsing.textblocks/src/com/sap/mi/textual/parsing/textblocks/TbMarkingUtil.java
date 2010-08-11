/**
 * 
 */
package com.sap.mi.textual.parsing.textblocks;

import static com.sap.mi.textual.parsing.textblocks.TbNavigationUtil.nextToken;

import com.sap.furcas.metamodel.textblocks.AbstractToken;
import com.sap.furcas.metamodel.textblocks.Bostoken;
import com.sap.furcas.metamodel.textblocks.DocumentNode;
import com.sap.furcas.metamodel.textblocks.Eostoken;

/**
 *
 */
public class TbMarkingUtil {


    
    public static boolean isEOS(DocumentNode tok) {
        return tok instanceof Eostoken;
    }

    public static boolean isBOS(DocumentNode tok) {
        return tok instanceof Bostoken;
    }

    /**
     * Marks token (sets relexing needed to true), if token is not bos or eos
     * @param tok token to mark
     */
    public static void mark(AbstractToken tok) {
        if (!isEOS(tok) && !isBOS(tok)) {
            tok.setRelexingNeeded(true);
            TbChangeUtil.markAscending(tok.getParent());
        }
    }

	public static boolean marked(AbstractToken tok) {
        return tok.isRelexingNeeded();
    }
    
    /**
     * Computes the difference in number of chars between the currently read
     * location and the location where the original token was constructed.
     * 
     * TODO: why use offset and not absolute offset?
     * 
     * @param readLoc2
     * @param constructionLoc2
     * @return
     */
    public static int deltaInChars(TokenLocation readLoc2, TokenLocation constructionLoc2) {
        int delta = 0;
        if (readLoc2.getTok().equals(constructionLoc2.getTok())) {
            // Still the same token so just return difference bewtween offsets
            delta = readLoc2.getOffset() - constructionLoc2.getOffset();
        } else {
            AbstractToken currentToken = constructionLoc2.getTok();
            delta = currentToken.getLength() - constructionLoc2.getOffset();
            if (!isEOS(constructionLoc2.getTok())) {
                currentToken = nextToken(currentToken);
                while (!currentToken.equals(readLoc2.getTok()) && !isEOS(currentToken)) {
                    delta += currentToken.getLength();
                    currentToken = nextToken(currentToken);
                }
                delta += readLoc2.getOffset();
            }

        }
        if (delta <= 0) {
            // TODO it seems that antlr does prediction only as far as necessary
            // if the token type is clear no special lookahead is done
            // only LA(1) is used, therefore return 1 as it is the minimal
            // lookahead used
            return 1;
        } else {
            return delta;
        }
    }

	public static void markTokenRelexed(AbstractToken t) {
		//currently mark and markTokenRelexed is the same
		//the only difference is that mark for relexing is done on
		//the previous version and markTokenRelexed is done on the current version
		//indicating that a token was newly created or changed and the parser
		//needs to re-evaluate
		mark(t);
	}
    

    
}
