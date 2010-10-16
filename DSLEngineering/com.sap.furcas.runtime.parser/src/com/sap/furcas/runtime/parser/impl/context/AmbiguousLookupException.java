/**
 * 
 */
package com.sap.furcas.runtime.parser.impl.context;

/**
 *
 */
public class AmbiguousLookupException extends Exception {
    private Context context;
    private Object original;
    private Object duplicate;

    /**
     * @param context
     * @param candidate
     * @param loopCandidate
     */
    public AmbiguousLookupException(Context context, Object candidate,
            Object loopCandidate) {
        this.context = context;
        this.original = candidate;
        this.duplicate = loopCandidate;
    }

    
    
    private static final long serialVersionUID = 7033724149239527032L;

    public Context getContext() {
        return context;
    }
    public Object getOriginal() {
        return original;
    }
    public Object getDuplicate() {
        return duplicate;
    }
}
