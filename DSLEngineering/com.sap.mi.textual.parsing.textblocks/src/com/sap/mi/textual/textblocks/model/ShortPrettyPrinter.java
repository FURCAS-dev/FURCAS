package com.sap.mi.textual.textblocks.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import com.sap.furcas.metamodel.TCS.AsPArg;
import com.sap.furcas.metamodel.TCS.FilterPArg;
import com.sap.furcas.metamodel.TCS.LiteralRef;
import com.sap.furcas.metamodel.TCS.Property;
import com.sap.furcas.metamodel.TCS.RefersToPArg;
import com.sap.furcas.metamodel.TCS.SequenceElement;
import com.sap.furcas.metamodel.TCS.Template;
import com.sap.furcas.metamodel.textblocks.AbstractToken;
import com.sap.furcas.metamodel.textblocks.LexedToken;
import com.sap.furcas.metamodel.textblocks.TextBlock;
import com.sap.mi.textual.common.exceptions.ModelAdapterException;
import com.sap.mi.textual.common.util.ContextAndForeachHelper;
import com.sap.mi.textual.grammar.IModelElementInvestigator;
import com.sap.mi.textual.parsing.textblocks.LocalContextBuilder;
import com.sap.mi.textual.parsing.textblocks.PrettyPrinterUtil;
import com.sap.mi.textual.parsing.textblocks.TbNavigationUtil;
import com.sap.mi.textual.parsing.textblocks.TbUtil;
import com.sap.mi.textual.tcs.util.TcsUtil;

public class ShortPrettyPrinter {

    private final static boolean doFlyWeight = true;
    private final IModelElementInvestigator investigator;

    public ShortPrettyPrinter(IModelElementInvestigator investigator) {
	this.investigator = investigator;
    }

    public void makeFlyweight(TextBlock rootBlock) {
	if (doFlyWeight) {
	    AbstractToken tok = TbNavigationUtil.firstToken(rootBlock);
	    while (tok != null) {
		if (tok instanceof LexedToken) {
		    if (((LexedToken) tok).getSequenceElement() instanceof Property
			    && TcsUtil
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
		    newValue = handlePropertyElement((Property) se,
			    (LexedToken) token);
		} else if (se instanceof LiteralRef) {
		    newValue = handleLiteralRef((LiteralRef) se);
		}
	    }
	    if (originalValue != null && newValue != null
		    && originalValue.length() != newValue.length()
		    && originalValue.replaceAll("\"", "").equals(newValue)) {
		// TODO handle this correctly using unescaping rules defined in
		// mapping!
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
	if (TcsUtil.containsRefersToArg(se) || TcsUtil.getFilterPArg(se) != null) {
	    // the new value comes from the value of the referenced element;
	    for (EObject referencedObject : token
		    .getReferencedElements()) {
	        if(referencedObject != null &&
	                referencedObject.refIsInstanceOf(se.getPropertyReference().getStrucfeature().getEType(), true)) {
        		RefersToPArg refersToArg = TcsUtil.getRefersToPArg(se);
        		try {
        		    if (TcsUtil.getFilterPArg(se) != null) {
        			// if the string given in the token is changed
        			// within the query to do the matching
        			// with the target element we need to invert this
        			// change to get the actual value
        		        AsPArg asParg = TcsUtil.getAsPArg(se);
        		        Template template = PrettyPrinterUtil.getAsTemplate(asParg);
        			return PrettyPrinterUtil.printUsingSerializer(invertOclQuery(referencedObject, token, se,
        				newvalue), template);
        		    }
        		    Object value = investigator.get(referencedObject,
        			    refersToArg.getPropertyName());
        		    if (value instanceof Collection<?> && ((Collection<?>)value).size() > 0) {
        			value = ((Collection<?>) value).iterator().next();
        		    }
        		    if (value != null && !(value instanceof EObject) && !(value instanceof Collection<?>)) {
        			newvalue = value.toString();
        		    }
        		    
        		    AsPArg asParg = TcsUtil.getAsPArg(se);
                            Template template = PrettyPrinterUtil.getAsTemplate(asParg);
                            return PrettyPrinterUtil.printUsingSerializer(newvalue, template);
        		} catch (ModelAdapterException e) {
        		    // element does not have this property
        		    System.out.println(e);
        		    continue;
        		} catch (OclManagerException e) {
        		    // element does not have this property
        		    System.out.println(e);
        		    continue;
        		}
	        }
	    }	    
	} else {
	    //it is always the first element as all others do not have a syntax contribution!
	    EObject referencedObject;
	    List<EObject> correspondingElements = token.getParent().getCorrespondingModelElements();
	    if (correspondingElements.isEmpty()) {
		referencedObject = token.getParent().getReferencedElements().iterator().next();
	    } else {
		referencedObject = correspondingElements.get(0);
	    }
            try {
                Object value = investigator.get(referencedObject, se
                        .getPropertyReference().getStrucfeature().getName());
                // TODO handle pretty printing and escaping according to
                // syntax
                if (value instanceof Collection<?>
                        && ((Collection<?>) value).size() > 0) {
                    value = ((Collection<?>) value).iterator().next();
                }
                if (value != null && !(value instanceof EObject)
                        && !(value instanceof Collection<?>)) {
                    newvalue = value.toString();
                }
                // break;
            } catch (ModelAdapterException e) {
                // element does not have such a property
                // continue;
            }
	}
	AsPArg asParg = TcsUtil.getAsPArg(se);
        Template template = PrettyPrinterUtil.getAsTemplate(asParg);
        return PrettyPrinterUtil.printUsingSerializer(newvalue, template);
    }

    private String invertOclQuery(EObject self, LexedToken token,
	    Property se, String newValue) throws OclManagerException,
	    ModelAdapterException {
	// TODO this should actually use the splitted version of query and
	// filter elements
	// to be able to invert the query.
	// this implementation just checks if there are any prefixes or
	// postfixes that can be removed.
	FilterPArg filterParg = TcsUtil.getFilterPArg(se);
	if (filterParg != null && filterParg.getInvert() != null) {
	    String query = filterParg.getInvert();

	    LocalContextBuilder lcb = new LocalContextBuilder();
	    TbUtil.constructContext(token, lcb);

	    if (!lcb.getContextStack().isEmpty()
		    && ContextAndForeachHelper.usesContext(query)) {
		self = (EObject) lcb.getContextStack().peek().getRealObject();
	    }
	    query = MoinHelper.prepareOclQuery(query, token.getValue());

	    if (self != null) {
		EPackage root = self.refOutermostPackage();
		Collection<EPackage> packagesForLookup = new ArrayList<EPackage>();
		packagesForLookup.addAll(MoinHelper.getImportedRefPackages(root));
		packagesForLookup.add(root);

		if (query != null) {
		    String name = "short-pretty-printer-temp-reg";
		    OclFreestyleRegistry freestyleRegistry = token.get___Connection().getOclRegistryService()
			    .getFreestyleRegistry();
		    OclExpressionRegistration registration = (OclExpressionRegistration) freestyleRegistry.getRegistration(name);
		    if (registration != null) {
			freestyleRegistry.deleteRegistration(name);
		    }
		    registration = freestyleRegistry.createExpressionRegistration(name, query, OclRegistrationSeverity.Info,
			    new String[] { name }, self.eClass(), packagesForLookup.toArray(new EPackage[] {}));
		    Object result = registration.evaluateExpression(self);
		    if (result == null) {
			// maybe create an error marker!
			return token.getValue();
		    } else if (result instanceof String) {
			return (String) result;
		    } else {
			throw new ModelAdapterException("Cannot invert OCL query: " + query + " on element " + self);
		    }
		}
	    }
	}
	
	return newValue;
    }

}
