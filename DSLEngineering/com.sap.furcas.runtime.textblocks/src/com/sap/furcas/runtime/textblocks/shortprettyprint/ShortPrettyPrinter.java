package com.sap.furcas.runtime.textblocks.shortprettyprint;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.TCS.AsPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.LiteralRef;
import com.sap.furcas.metamodel.FURCAS.TCS.PrimitiveTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.Property;
import com.sap.furcas.metamodel.FURCAS.TCS.ReferenceByPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.RefersToPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.LexedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.common.interfaces.IModelElementInvestigator;
import com.sap.furcas.runtime.common.util.TCSSpecificOCLEvaluator;
import com.sap.furcas.runtime.tcs.PropertyArgumentUtil;
import com.sap.furcas.runtime.textblocks.TbNavigationUtil;

public class ShortPrettyPrinter {

    private final static boolean doFlyWeight = true;
    private final IModelElementInvestigator investigator;
    private final TCSSpecificOCLEvaluator oclEvaluator;

    public ShortPrettyPrinter(IModelElementInvestigator investigator) {
	this.investigator = investigator;
	this.oclEvaluator = new TCSSpecificOCLEvaluator(); // TODO need a consistent OppositeEndFinder
    }

    public void makeFlyweight(TextBlock rootBlock) {
	if (doFlyWeight) {
	    AbstractToken tok = TbNavigationUtil.firstToken(rootBlock);
	    while (tok != null) {
		if (tok instanceof LexedToken) {
		    if (((LexedToken) tok).getSequenceElement() instanceof Property
			    && PropertyArgumentUtil
				    .containsRefersToArg((Property) ((LexedToken) tok)
					    .getSequenceElement())) {
			// remember value as secondary id for resolving
		    } else {
			tok.setValue(null);
		    }
		}
		tok = TbNavigationUtil.nextToken(tok);
	    }
	}
    }

    public String resynchronizeToEditableState(AbstractToken token) {
	String originalValue = token.getValue();
	String newValue = token.getValue();
	if (doFlyWeight) {
	    if (token instanceof LexedToken) {
		SequenceElement se = ((LexedToken) token).getSequenceElement();
		if (se instanceof Property) {
		    newValue = handlePropertyElement((Property) se, (LexedToken) token);
		} else if (se instanceof LiteralRef) {
		    newValue = handleLiteralRef((LiteralRef) se);
		}
	    }
	    if (originalValue != null && newValue != null
		    && originalValue.length() != newValue.length()
		    && originalValue.replaceAll("\"", "").equals(newValue)) {
		newValue = originalValue;
	    }
	}
	return newValue;
    }

    private String handleLiteralRef(LiteralRef se) {
	return se.getReferredLiteral().getValue();
    }

    private String handlePropertyElement(Property se, LexedToken token) {
	String newvalue = token.getValue();
	if (PropertyArgumentUtil.containsRefersToArg(se) || PropertyArgumentUtil.containsReferenceByPArg(se)) {
	    // the new value comes from the value of the referenced element;
	    for (EObject referencedObject : token.getReferencedElements()) {
	        if(referencedObject != null &&
	                referencedObject.eClass().equals(se.getPropertyReference().getStrucfeature().getEType())
	        		|| referencedObject.eClass().getEAllSuperTypes().contains(se.getPropertyReference().getStrucfeature().getEType())) {
        		try {
        		    if (PropertyArgumentUtil.containsReferenceByPArg(se)) {
        			// if the string given in the token is changed
        			// within the query to do the matching
        			// with the target element we need to invert this
        			// change to get the actual value
        		        AsPArg asParg = PropertyArgumentUtil.getAsPArg(se);
        		        PrimitiveTemplate template = PrettyPrinterUtil.getAsTemplate(asParg);
        			return PrettyPrinterUtil.printUsingSerializer(invertOclQuery(referencedObject, se, newvalue), template);
        		    } else {
        		        // refersTo case
        		        RefersToPArg refersToArg = PropertyArgumentUtil.getRefersToPArg(se);
        		        Object value = investigator.get(referencedObject, refersToArg.getPropertyName());
        		        if (value instanceof Collection<?> && ((Collection<?>)value).size() > 0) {
        		            value = ((Collection<?>) value).iterator().next();
        		        }
        		        if (value != null && !(value instanceof EObject) && !(value instanceof Collection<?>)) {
        		            newvalue = value.toString();
        		        }
        		        
        		        AsPArg asParg = PropertyArgumentUtil.getAsPArg(se);
        		        PrimitiveTemplate template = PrettyPrinterUtil.getAsTemplate(asParg);
        		        return PrettyPrinterUtil.printUsingSerializer(newvalue, template);
        		    }
        		} catch (ModelAdapterException e) {
        		    // element does not have this property
        		    e.printStackTrace();
        		    continue;
        		}
	        }
	    }	    
	} else {
	    //it is always the first element as all others do not have a syntax contribution!
	    EObject referencedObject = null;
	    List<EObject> correspondingElements = token.getParent().getCorrespondingModelElements();
	    if (correspondingElements.isEmpty()) {
	    	if( token.getParent().getReferencedElements().size() > 0) {
	            referencedObject = token.getParent().getReferencedElements().iterator().next();
	        }
	    } else {
	    	referencedObject = correspondingElements.get(0);
	    }
            try {
            	if(referencedObject != null) {
	                Object value = investigator.get(referencedObject, se.getPropertyReference().getStrucfeature().getName());
	                // TODO handle pretty printing and escaping according to
	                // syntax
	                if (value instanceof Collection<?> && ((Collection<?>) value).size() > 0) {
	                    value = ((Collection<?>) value).iterator().next();
	                }
	                if (value != null && !(value instanceof EObject) && !(value instanceof Collection<?>)) {
	                    newvalue = value.toString();
	                }
	                // break;
            	}
            } catch (ModelAdapterException e) {
                // element does not have such a property
                // continue;
            }
	}
	AsPArg asParg = PropertyArgumentUtil.getAsPArg(se);
        PrimitiveTemplate template = PrettyPrinterUtil.getAsTemplate(asParg);
        if(newvalue.equals(token.getValue())) {
            return newvalue;
        } else {
            return PrettyPrinterUtil.printUsingSerializer(newvalue, template);
        }
    }

	private String invertOclQuery(EObject self, Property se, String newValue) throws ModelAdapterException {
		ReferenceByPArg referenceByPArg = PropertyArgumentUtil.getReferenceByPArg(se);
		if (referenceByPArg != null) {
	                ReferenceByPArg referenceBy = PropertyArgumentUtil.getReferenceByPArg(se);
	                String invertQuery = PropertyArgumentUtil.getReferenceByAsOCL(referenceBy);
	                try {
	                    String value = (String) oclEvaluator.findElementsWithOCLQuery(self, /*keyValue*/ null, invertQuery).iterator().next();
	                    value = PropertyArgumentUtil.stripPrefixPostfix(value, PropertyArgumentUtil.getPrefixPArg(se), PropertyArgumentUtil.getPostfixPArg(se));
	                } catch (ModelAdapterException e) {
	                    throw new ModelAdapterException("Unable to serialize referenced model element: " + e.getMessage(), e);
	                }
		}
		return newValue;
	}

}
