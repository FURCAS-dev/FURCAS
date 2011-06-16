package com.sap.furcas.runtime.textblocks.shortprettyprint;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.TCS.LiteralRef;
import com.sap.furcas.metamodel.FURCAS.TCS.PrimitiveTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.Property;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.LexedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.common.interfaces.IModelElementInvestigator;
import com.sap.furcas.runtime.common.util.TCSSpecificOCLEvaluator;
import com.sap.furcas.runtime.tcs.PropertyArgumentUtil;
import com.sap.furcas.runtime.textblocks.TbNavigationUtil;
import com.sap.furcas.utils.Activator;

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
        EObject contextObject = null;
        // it is always the first element as all others do not have a syntax contribution!
        List<EObject> correspondingElements = token.getParent().getCorrespondingModelElements();
        if (!correspondingElements.isEmpty()) {
            contextObject = correspondingElements.get(0);
        } else {
            return token.getValue();
        }

        Object propertyValue = null;
        try {
            propertyValue = investigator.get(contextObject, se.getPropertyReference().getStrucfeature().getName());
            if (propertyValue instanceof Collection<?> && ((Collection<?>) propertyValue).size() > 0) {
                propertyValue = ((Collection<?>) propertyValue).iterator().next();
            }
        } catch (ModelAdapterException e) {
            // element does not have such a property
        }

        String newValue = null;
        try {
            if (PropertyArgumentUtil.containsReferenceByPArg(se) && propertyValue instanceof EObject) {
                newValue = PrettyPrinterUtil.invertReferenceByQuery((EObject) propertyValue, se, oclEvaluator);
            } else {
                if (PropertyArgumentUtil.containsRefersToArg(se) && propertyValue instanceof EObject) {
                    propertyValue = investigator.get(contextObject, PropertyArgumentUtil.getRefersToPArg(se).getPropertyName());
                    
                    if (propertyValue instanceof Collection<?> && ((Collection<?>) propertyValue).size() > 0) {
                        propertyValue = ((Collection<?>) propertyValue).iterator().next();
                    }
                }
                if (propertyValue != null && !(propertyValue instanceof EObject) && !(propertyValue instanceof Collection<?>)) {
                    newValue = propertyValue.toString();
                }
            }
        } catch (ModelAdapterException e) {
            Activator.logger.logError("Failed to short prety print token value", e);
        }
        if (newValue == null) {
            // Failed to retrieve proeprty. Return the same value to keep the textual view intact,
            return token.getValue();
        } else {
            PrimitiveTemplate template = PropertyArgumentUtil.getAsTemplate(PropertyArgumentUtil.getAsPArg(se));
            return PrettyPrinterUtil.escapeUsingSerializer(newValue, template);
        }
    }

}
