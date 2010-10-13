/**
 * 
 */
package com.sap.furcas.runtime.parser.impl.context;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.common.interfaces.IModelElementInvestigator;
import com.sap.furcas.runtime.common.interfaces.IModelElementProxy;

/**
 * keeps track of modelElements being contexts for each other in a text file with regards to a context path.
 * manages the context as a set of trees (set of roots with childs) and is aware of context elements being 
 * proxies at first, and later modelElements.
 * The interface allows passing anything of Type Object, but the objects passed should really only be Objects
 * which a ModelAdapter can deal with when passed in findCandidatesInContext(). 
 * Allows searching for elements in context, and caches queries to that method call.
 */
public class ContextManager {

    /** static maintenance of element sematic context mapping. */
    private Map<Object, Context> contextByElement;

    private ContextLookUpCache lookupCache;
    
    private Set<Context> rootContexts;

    public ContextManager() {
        resetContextManager();
    }

    /**
     * 
     */
    private void resetContextManager() {
        // maybe make public later
        contextByElement = new HashMap<Object, Context>();
        rootContexts = new HashSet<Context>();
        lookupCache = new ContextLookUpCache();
    }


    /**
     * notifies the manager that a proxy has been resolved with another object, 
     * so the manager should from now on treat the new object like the proxy before.
     * The manager relies on client code to pass a creation context if any.
     * @param proxy
     * @param realElement
     * @param creationContextElement the context in which the proxy had been created, if any (may be null) 
     */
    public void notifyProxyResolvedWith(IModelElementProxy proxy, Object realElement, IModelElementProxy creationContextElement) {
        // proxy element is either a context element itself, or contained in some creationContext
        Context elementContext = contextByElement.get(proxy);
        if (elementContext != null) {
            // change in context
            contextByElement.remove(proxy); // TODO remove the proxy from context map
            contextByElement.put(realElement, elementContext);
            if (elementContext.getElement() == proxy) {
                elementContext.setElement(realElement);
                Context parent = elementContext.getParent();
                if (parent != null) {
                    parent.replaceElement(proxy, realElement);
                }
            } else {
                elementContext.replaceElement(proxy, realElement);
            }
        } 
        if (creationContextElement != null) {
            Context creationContext = contextByElement.get(creationContextElement);
            if (creationContext == null && creationContextElement.getRealObject() != null) {
        	creationContext = contextByElement.get(creationContextElement.getRealObject());
            }
            if (creationContext != null) {
                creationContext.replaceElement(proxy, realElement);
            }
        }
    }


    /**
     * @param proxy
     * @param modelElementProxy 
     */
    public void discardProxy(Object proxy, IModelElementProxy creationContextElement) {
        if (proxy != null) {
            Context elementContext = contextByElement.get(proxy);
            if (elementContext != null) {
                Context parent = elementContext.getParent();
                if (parent == null) { // root context is invalid
                    rootContexts.remove(elementContext);
                } 
                Set<Object> deleted = Context.removeWithChildren(elementContext);
                // remove all elements without context from map.
                for (Iterator<Object> iterator = deleted.iterator(); iterator.hasNext();) {
                    Object toDelete = iterator.next();
                    contextByElement.remove(toDelete);    
                }                
            }
            Context creationContext = contextByElement.get(creationContextElement);
            if (creationContext != null) {
                creationContext.remove(proxy);
            }
        }
    }
    


    /**
     * @param object
     * @return
     */
    public Object getContextForElement(Object object) {
        Context objectContext = contextByElement.get(object);
        if(objectContext == null && object instanceof IModelElementProxy) {
            objectContext = contextByElement.get(((IModelElementProxy)object).getRealObject());
        }
        if (objectContext != null) {
            return objectContext.getElement();
        }
        return null;
    }
    
    /**
     * @param object
     * @return
     */
    public List<Object> getElementsInContext(Object contextElement) {
        Context objectContext = contextByElement.get(contextElement);
        if (objectContext != null) {
            return objectContext.getElements();
        }
        return null;
    }

    /**
     * Extends the importing context by the elements of the imported context.
     * @param modelElement
     * @param realValue
     */
    public void setContextImport(Object importingContextElement, Object importedContextElement) {
        Context importedContext = contextByElement.get(importedContextElement);
        Context importingContext = contextByElement.get(importingContextElement);
        if (importingContext != null && importedContext != null) {
            importingContext.importContext(importedContext);
        }
    }
    

    


    /**
     * @param modelAdapter
     * @param context
     * @param valueTypeName
     * @param keyValue
     * @param keyName
     * @return
     * @throws AmbiguousLookupException 
     * @throws ModelAdapterException 
     */
    public Object findCandidatesInContext(IModelElementInvestigator modelAdapter,
            Object contextElement, List<String> valueTypeName, String keyName, Object keyValue)
            throws ModelAdapterException, AmbiguousLookupException {

        Context context = this.contextByElement.get(contextElement);
        if (context != null) {
            // use cache as operations involving modelAdapter may take long.
            return lookupCache.findCandidatesInContext(modelAdapter, context, valueTypeName, keyValue, keyName);
        } else {
            return null;
        }
        
    }



    /**
     * @param contextElement
     * @param ro
     */
    public void addToContext(Object contextElement, Object newElement) {
	// TODO problem: if contextElement is a proxy but a substitution has already happened in the contextManager, the element won't be found
        Context context = this.contextByElement.get(contextElement);
        if (context == null && contextElement instanceof IModelElementProxy &&
        	((IModelElementProxy) contextElement).getRealObject() != null) {
            // The proxy representing the context element may already have been substituted in
            // the contextByElement ksy side but still remained as a proxy in the currentContextStack.
            // If the contextElement passed is a resolved proxy, try to use the real object instead:
            context = this.contextByElement.get(((IModelElementProxy) contextElement).getRealObject());
        }
        if (context != null) {
            context.add(newElement);
        }
    }

    /**
     * returns this context or the first ancestor context (bottom up) having the tag, or null if none.
     * @param contextElement an element that is a context element (else null is returned)
     * @param optionalTag null, or a tag that a context need to have.
     * @return
     */
    public Object getTaggedContext(Object contextElement, String optionalTag) {
        Object modelElement = null;
        
        Context referenceContext = this.contextByElement.get(contextElement);
        if (referenceContext != null) {
            if (optionalTag != null) {
                // search upwards in hierarchy for first context having tag in tags
                boolean tagFound = false;
                while (!tagFound && referenceContext != null) {
                    String[] contextTags = referenceContext.getTags();
                    if (contextTags != null) {
                        for (int i = 0; i < contextTags.length; i++) {
                            String contextTag = contextTags[i];
                            if (contextTag.equals(optionalTag)) {
                                tagFound = true;
                                break;
                            }
                        }
                    }
                    if (!tagFound) {
                        referenceContext = referenceContext.getParent();
                    }
                }
            }
            // referenceContext canbecome null by using tags, if none with tag exists
            if (referenceContext != null) {
                modelElement = referenceContext.getElement();
            }
        }
        
        return modelElement;
    }

    /**
     * @param contextElement 
     * @return
     */
    public Object getContextParent(Object contextElement) {
        Context referenceContext = this.contextByElement.get(contextElement);
        if (referenceContext != null) {
            Context parent = referenceContext.getParent();
            if (parent != null) {
                return parent.getElement();
            }
        }
        return null;
    }

    /**
     * checks modelElement was part of the document, navigation along 
     * modelElements can lead outside the modelElements represented in the text.
     * @param navigatedContext
     * @return true if the element has been parsed from the document, and therefore has a context.
     */
    public boolean hasInTextContext(Object navigatedContext) {
        return this.contextByElement.get(navigatedContext) != null;
    }

    /**
     * adds a context for the given element within a parent context, creates a content hierarchy.
     * @param tags 
     * @param currentContextElement
     * @param element
     */
    public void addContextChildFor(IModelElementProxy parentContextElement, IModelElementProxy newChildElement, String[] tags) {
        Context context = contextByElement.get(parentContextElement);
        if (context == null && parentContextElement.getRealObject() != null) {
            context = contextByElement.get(parentContextElement.getRealObject());
        }
        if (context != null) {
            Context newContext = context.createContext(newChildElement);
            newContext.setTags(tags);
            contextByElement.put(newChildElement, newContext);
        } else {
            // should never happen
            throw new RuntimeException("BUG: addContext called where parent Object has no known context.");
        }
    }
    
    /**
     * adds this element as new root context, meaning it is not contained in any other context.
     * @param newChildElement
     * @param tags 
     */
    public void addRootContext(IModelElementProxy newChildElement, String[] tags) {
        Context newRootContext = new Context();
        newRootContext.setTags(tags);
        rootContexts.add(newRootContext);
        
        newRootContext.setElement(newChildElement);
        contextByElement.put(newChildElement, newRootContext);
    }


// probably obsolete methods
//    /**
//     * 
//     */
//    public void resolveAllProxies() {
//        for (Iterator<Context> iterator = rootContexts.iterator(); iterator.hasNext();) {
//            Context rootContext = (Context) iterator.next();
//            // recursively go through all context nodes
//            resolveOrRemoveProxies(rootContext);
//        }
//       
//    }
//    /**
//     * resolves or removes in the given subtree recursively
//     * @param rootContext
//     */
//    private void resolveOrRemoveProxies(Context rootContext) {
//        if (rootContext.getElement() instanceof IModelElementProxy) {
//            IModelElementProxy proxy = (IModelElementProxy) rootContext.getElement();
//            Object realObject = proxy.getRealObject();
//            if (realObject == null) {
//                // could not create or resolve this modelElement from proxy, context is invalid
//                throw new RuntimeException("Context content Element had not be resolved");
//            }
//            rootContext.setElement(realObject);
//        }
//        ContextIterator iterator = rootContext.iterator();
//        List<IModelElementProxy> toBeReplaced = new ArrayList<IModelElementProxy>();
//        while (iterator.hasNext()) {
//            Object object = (Object) iterator.next();
//            if (object instanceof IModelElementProxy) {
//                IModelElementProxy proxy = (IModelElementProxy) object;
//                Object realObject = proxy.getRealObject();
//                if (realObject == null) {
//                    // could not create this modelElement from proxy, context is invalid
//                    throw new RuntimeException("Context content Element could not be resolved");
//                }
//                toBeReplaced.add(proxy);
//                
//            }
//        }
//        for (Iterator<IModelElementProxy> iterator2 = toBeReplaced.iterator(); iterator2.hasNext();) {
//            IModelElementProxy proxy = (IModelElementProxy) iterator2.next();
//            rootContext.replaceElement(proxy, proxy.getRealObject());
//            
//        }
//        
//        Collection<Context> children = rootContext.getChildContexts();
//        if (children != null) {
//            for (Iterator<Context> iterator2 = children.iterator(); iterator2.hasNext();) {
//                Context childcontext = (Context) iterator2.next();
//                resolveOrRemoveProxies(childcontext);
//            }
//        }
//    }

}
