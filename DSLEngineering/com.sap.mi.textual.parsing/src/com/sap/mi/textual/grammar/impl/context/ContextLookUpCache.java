/**
 * 
 */
package com.sap.mi.textual.grammar.impl.context;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sap.furcas.textual.common.exceptions.ModelAdapterException;
import com.sap.furcas.textual.common.interfaces.IModelElementInvestigator;
import com.sap.furcas.textual.common.interfaces.IModelElementProxy;

/**
 * During an injection, caches lookups within contexts
 */
class ContextLookUpCache {

    Map<Context, Map<KeySignature, Object>> cache = new HashMap<Context, Map<KeySignature,Object>>();
    
    // placeholder in cache to indicate context does not contain object
//    private final static Object NOT_FOUND_OBJECT = new Object();
    
    /**
     * looks through all elements in the given context and checks using the modelAdapter
     * whether they are of the given type and have the correct key value if they are.
     * @param modelAdapter
     * @param context
     * @param valueTypeName
     * @param keyValue
     * @param keyName
     * @return
     * @throws ModelAdapterException
     * @throws AmbiguousLookupException
     */
    Object findCandidatesInContext(IModelElementInvestigator modelAdapter,
            Context context, List<String> valueTypeName, Object keyValue,
            String keyName) throws ModelAdapterException, AmbiguousLookupException {
        
        // caching disabled because it may be buggy for creation of Objects during resolving of references 
        
//        KeySignature keySignature = new KeySignature(valueTypeName, keyValue, keyName);
//        // caching because ModelManager Operations can take long
//        Object candidate = lookUpInCache(context, keySignature);
//        
//        // candidate may be null, that means we never looked for it, or it may be the NOT_FOUND_OBJECT
//        if (candidate == NOT_FOUND_OBJECT) {
//            return null;
//        }
//        
////        if not found in cache
//        if (candidate == null) {
        Object  candidate = lookUpInContext(modelAdapter, context,
                    valueTypeName, keyValue, keyName);
            
//            // store for next cache lookup
//            if (candidate == null) {
//                cache.get(context).put(keySignature, NOT_FOUND_OBJECT);
//            } else {
//                cache.get(context).put(keySignature, candidate);
//            }
////        }
        
        return candidate;
    }

    /**
     * 
     */
    public void clear() {
        cache.clear();
    }


//    private Object lookUpInCache(Context context, KeySignature keySignature) {
//        
//        Map<KeySignature, Object> cachedContextSignatures = cache.get(context);
//        
//        if (cachedContextSignatures == null) {
//            cachedContextSignatures = new HashMap<KeySignature, Object>();
//            cache.put(context, cachedContextSignatures);
//            return null;
//        }
//        
//        // cache for context existed
//        return cachedContextSignatures.get(keySignature);    
//        
//    }

    /** loops through elemens in context and first checks type than value
    **/
    private Object lookUpInContext(IModelElementInvestigator modelAdapter, Context context,
            List<String> valueTypeName, Object keyValue, String keyName)
            throws ModelAdapterException, AmbiguousLookupException {
        Object candidate = null;
        Object loopCandidate;
        Object metatype = modelAdapter.getMetaType(valueTypeName);
        for(ContextIterator i = context.iterator() ; i.hasNext() ; ) {
            loopCandidate = i.next();
            if (loopCandidate instanceof IModelElementProxy) {
        	loopCandidate = ((IModelElementProxy) loopCandidate).getRealObject();
            }
            
            // check type of context object is of valueTypeName
            if (modelAdapter.instanceOf(loopCandidate, metatype)) {
                
                // check key value (identity) of loop candidate
                if (keyValue != null && keyValue.equals(modelAdapter.get(loopCandidate, keyName))) {
                    if (candidate == null ) {
                        candidate = loopCandidate; 
                    } else {
                        if (candidate != loopCandidate ) {
                            throw new AmbiguousLookupException(context, candidate, loopCandidate);
                        } else { // element is duplicate in iterator, this is a bug, but not a harmful one
                            continue; 
                        }
                    }
                }
            }
        } // end for context
        return candidate;
    }
    

    
    private class KeySignature {

        private List<String> valueTypeName;
        private Object keyValue;
        private String keyName;

        /* (non-Javadoc)
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString() {
            return valueTypeName.toString() +'.'+keyName + '=' + keyValue;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result
                    + ((keyName == null) ? 0 : keyName.hashCode());
            result = prime * result
                    + ((keyValue == null) ? 0 : keyValue.hashCode());
            result = prime * result
                    + ((valueTypeName == null) ? 0 : valueTypeName.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            final KeySignature other = (KeySignature) obj;
            if (keyName == null) {
                if (other.keyName != null)
                    return false;
            } else if (!keyName.equals(other.keyName))
                return false;
            if (keyValue == null) {
                if (other.keyValue != null)
                    return false;
            } else if (!keyValue.equals(other.keyValue))
                return false;
            if (valueTypeName == null) {
                if (other.valueTypeName != null)
                    return false;
            } else if (!valueTypeName.equals(other.valueTypeName))
                return false;
            return true;
        }
        
        
        
    }


}
