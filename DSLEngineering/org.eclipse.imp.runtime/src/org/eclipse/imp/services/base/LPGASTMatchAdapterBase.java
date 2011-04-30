package org.eclipse.imp.services.base;

import lpg.runtime.IAst;
import lpg.runtime.IToken;

import org.eclipse.imp.services.IASTMatchAdapter;

public abstract class LPGASTMatchAdapterBase implements IASTMatchAdapter {
    private final Class<?> fNodeListBaseClass;

    public LPGASTMatchAdapterBase(Class<?> nodeListBaseClass) {
        fNodeListBaseClass= nodeListBaseClass;
    }

    public Object[] getChildren(Object astNode) {
        return ((IAst) astNode).getChildren().toArray();
    }

    public int getOffset(Object astNode) {
        return ((IAst) astNode).getLeftIToken().getStartOffset();
    }

    public int getLength(Object astNode) {
        IAst ast = (IAst) astNode;
        IToken left = ast.getLeftIToken();
        IToken right = ast.getRightIToken();

        // special case for epsilon trees
        if (left.getTokenIndex() > right.getTokenIndex()) {
            return 0;
        } else {
            int start = left.getStartOffset();
            int end = right.getEndOffset();
            return end - start + 1;
        }
    }

    public Object getChildAtPosition(int pos, Object astNode) {
        return ((IAst) astNode).getChildren().get(pos);
    }

    public boolean isList(Object astNode) {
        return fNodeListBaseClass.isInstance(astNode);
    }
}
