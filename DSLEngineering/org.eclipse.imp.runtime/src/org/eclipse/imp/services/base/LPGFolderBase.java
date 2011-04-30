package org.eclipse.imp.services.base;

import java.util.List;

import lpg.runtime.Adjunct;
import lpg.runtime.IAst;
import lpg.runtime.ILexStream;
import lpg.runtime.IPrsStream;
import lpg.runtime.IToken;

public abstract class LPGFolderBase extends FolderBase {
    protected IPrsStream prsStream;

    protected void makeFoldableByOffsets(int first_offset, int last_offset) {
        super.makeAnnotation(first_offset, last_offset - first_offset + 1);
    }
    
    //
    // Use this version of makeAnnotation when you have a range of 
    // tokens to fold.
    //
    protected void makeFoldable(IToken first_token, IToken last_token) {
        if (last_token.getEndLine() > first_token.getLine()) {
            ILexStream lexStream = prsStream.getILexStream();
            int start = first_token.getStartOffset();
            int end = last_token.getEndOffset();

            // Following may be necessary if one edits an empty source file; there
            // may be an AST with an empty textual extent, which causes Position()
            // a heartache.
            if (end <= start) {
                return;
            }

            while (end < lexStream.getStreamLength() && (lexStream.getCharValue(end) == ' ' || lexStream.getCharValue(end) == '\t')) {
                end++;
            }
            // For some reason, simply testing against Character.LINE_SEPARATOR here doesn't work.
            if (end < lexStream.getStreamLength()-1 && (lexStream.getCharValue(end+1) == '\n' || lexStream.getCharValue(end+1) == '\r')) {
                end++;
            }

            makeFoldableByOffsets(start, end);
        }
    }

    protected void makeFoldable(IAst n) {
        makeFoldable(n.getLeftIToken(), n.getRightIToken());
    }

    protected void makeAdjunctsFoldable() {
        ILexStream lexStream = prsStream.getILexStream();
        if (lexStream == null)
            return;
        List<IToken> adjuncts = prsStream.getAdjuncts();
        for (int i = 0; i < adjuncts.size(); ) {
            Adjunct adjunct = (Adjunct) adjuncts.get(i);

            IToken previous_token = prsStream.getIToken(adjunct.getTokenIndex()),
                   next_token = prsStream.getIToken(prsStream.getNext(previous_token.getTokenIndex())),
                   comments[] = previous_token.getFollowingAdjuncts();

            for (int k = 0; k < comments.length; k++)
            {
                Adjunct comment = (Adjunct) comments[k];
                if (comment.getEndLine() > comment.getLine())
                {
                    IToken gate_token = k + 1 < comments.length ? comments[k + 1] : next_token;
                    makeFoldableByOffsets(comment.getStartOffset(),
                                              gate_token.getLine() > comment.getEndLine()
                                                  ? lexStream.getLineOffset(gate_token.getLine() - 1)
                                                  : comment.getEndOffset());
                }
            }

            i += comments.length;
        }    
    }
}
