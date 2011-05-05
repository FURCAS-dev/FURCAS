package com.sap.furcas.runtime.parser.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EObject;

import antlr.Token;

import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.common.implementation.ResolvedModelElementProxy;
import com.sap.furcas.runtime.common.interfaces.IModelElementProxy;
import com.sap.furcas.runtime.parser.ANTLR3LocationToken;
import com.sap.furcas.runtime.parser.IModelAdapter;
import com.sap.furcas.runtime.parser.ModelElementCreationException;
import com.sap.furcas.runtime.parser.ParsingError;
import com.sap.furcas.runtime.parser.exceptions.UnknownProductionRuleException;
import com.sap.furcas.runtime.parser.impl.context.ContextManager;

public class SemanticDisambiguateDelayedReference extends DelayedReference {
    public SemanticDisambiguateDelayedReference(IModelElementProxy currentContextElement, Object proxy, Object element,
            Object opTemplateLefthand, String opName, List<SemanticDisambRuleData> preds,
            ANTLR3LocationToken lastToken, ANTLR3LocationToken firstToken, boolean hasContext, boolean b) {
        super(currentContextElement, DelayedReference.ReferenceType.SEMANTIC_DISAMBIGUATE, proxy, element,
                opTemplateLefthand, opName, preds, lastToken, firstToken, hasContext, b);
    }

    public boolean isSemanticDisambiguatedOperatorRule() {
        return opTemplateLefthand != null;
    }

    public boolean setDelayedReference(DelayedReference reference, IModelAdapter modelAdapter,
            ContextManager contextManager, ObservableInjectingParser parser) {
        Object contextElement = reference.getContextElement();
        if (contextElement instanceof IModelElementProxy) {
            IModelElementProxy proxyContext = (IModelElementProxy) contextElement;
            contextElement = proxyContext.getRealObject();
        }
        try {
            Iterator<SemanticDisambRuleData> dataIt = reference.getSemRulData().iterator();
            boolean resultFound = false;
            while (dataIt.hasNext()) {
                SemanticDisambRuleData nextRuleData = dataIt.next();
                int beginRef = nextRuleData.getOcl().indexOf("${");
                String flattenOCL = DelayedReferencesHelper.appendFlattenToOclQuery(nextRuleData.getOcl());
                if (beginRef >= 0) {
                    String semReference = nextRuleData.getOcl().substring(beginRef,
                            nextRuleData.getOcl().indexOf('}', beginRef + 1) + 1);
                    String replacedBy;
                    // TODO support other types than string
                    if (isBasicType(reference.getSemanticObject())) {
                        replacedBy = "'" + reference.getSemanticObject().toString() + "'";
                    } else {
                        replacedBy = "?";
                    }
                    String replacedOCL = nextRuleData.getOcl().replaceAll(Pattern.quote(semReference), replacedBy);
                    if (replacedOCL.contains("#source")) {
                        replacedOCL = replacedOCL.replace("#source", "self");
                    }
                    flattenOCL = DelayedReferencesHelper.appendFlattenToOclQuery(replacedOCL);
                }

                // evaluate the predicate by OCL, return value is a list of
                // objects
                Object currentContextElement;
                if (nextRuleData.getOcl().contains("#source") && reference.isSemanticDisambiguatedOperatorRule()) {
                    if (reference.getOpTemplateLefthand() instanceof ModelElementProxy) {
                        currentContextElement = ((ModelElementProxy) reference.getOpTemplateLefthand()).getRealObject();
                    } else {
                        currentContextElement = reference.getOpTemplateLefthand();
                    }
                } else {
                    currentContextElement = contextElement;
                }
                Collection<?> result = modelAdapter.evaluateOCLQuery(currentContextElement, null, flattenOCL,
                        currentContextElement);
                // if there is no result it will be null
                if (result.isEmpty()) {
                    resultFound = false;
                } else {
                    Iterator<?> resultIt = result.iterator();
                    // loop over the results to handle them one by one
                    boolean ruleFound = false;
                    while (resultIt.hasNext()) {
                        Object nextResult = resultIt.next();
                        if (nextResult instanceof Boolean) {
                            if (((Boolean) nextResult).booleanValue()) {
                                if (ruleFound) {
                                    parser.getInjector().addError(new ParsingError("The semantic disambiguate matches more than one rule",
                                            reference.getToken()));
                                    return false;
                                }
                                ruleFound = true;
                                resultFound = true;
                                setReferenceForSemanticDisambiguatedRule(parser, reference, nextRuleData.getRule(),
                                        modelAdapter);
                            }
                        } else {
                            parser.getInjector().addError(new ParsingError("The rule " + nextRuleData.getRule()
                                    + " has a semantic disambiguate which does not evaluate to a bool value",
                                    reference.getToken()));
                            return false;
                        }
                    }
                }
            }
            if (!resultFound) {
                parser.getInjector().addError(new ParsingError("The semantic disambiguate did not match any rule", reference.getToken()));
                return false;
            }
        } catch (IllegalAccessException e) {
            parser.getInjector().addError(new ParsingError(e.getMessage(), reference.getToken()));
            return false;
        } catch (SecurityException e) {
            parser.getInjector().addError(new ParsingError(e.getMessage(), reference.getToken()));
            return false;
        } catch (IllegalArgumentException e) {
            parser.getInjector().addError(new ParsingError(e.getMessage(), reference.getToken()));
            return false;
        } catch (UnknownProductionRuleException e) {
            parser.getInjector().addError(new ParsingError(e.getMessage(), reference.getToken()));
            return false;
        } catch (NoSuchMethodException e) {
            parser.getInjector().addError(new ParsingError(e.getMessage(), reference.getToken()));
            return false;
        } catch (InvocationTargetException e) {
            parser.getInjector().addError(new ParsingError(e.getMessage(), reference.getToken()));
            return false;
        } catch (ModelElementCreationException e) {
            parser.getInjector().addError(new ParsingError(e.getMessage(), reference.getToken()));
            return false;
        } catch (ModelAdapterException e) {
            parser.getInjector().addError(new ParsingError(e.getMessage(), reference.getToken()));
            return false;
        }
        return true;
    }

    private void setReferenceForSemanticDisambiguatedRule(ObservableInjectingParser parser, DelayedReference reference,
            String ruleName, IModelAdapter modelAdapter) throws SecurityException, UnknownProductionRuleException,
            NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException,
            ModelElementCreationException, ModelAdapterException {
        // invoke the parser to execute the template
        Method methodToCall = parser.getClass().getMethod(ruleName, String.class, Object.class, Token.class);
        if (!Modifier.isFinal(methodToCall.getModifiers())) {
            throw new UnknownProductionRuleException(ruleName + " is not a production rule in generated Parser.");
        }
        boolean originalResolveProxiesValue = parser.isResolveProxies();
        parser.setResolveProxies(false);
        parser.reset();

        IModelElementProxy proxyForContextElement = null;
        if (reference.getContextElement() instanceof IModelElementProxy) {
            proxyForContextElement = (IModelElementProxy) reference.getContextElement();
        } else {
            proxyForContextElement = new ResolvedModelElementProxy(reference.getContextElement());
        }

        if (parser.getContextManager().getContextForElement(reference.getContextElement()) == null) {
            parser.addContext(proxyForContextElement);
            if (proxyForContextElement.getRealObject() != null && reference.getContextElement() instanceof EObject) {
                parser.getContextManager().notifyProxyResolvedWith(proxyForContextElement,
                        reference.getContextElement(), /*
                                                        * no creation context element needs to be provided here because
                                                        * the proxy has just been created and has not been added to any
                                                        * other context
                                                        */null);
            }
        } else {
            parser.getCurrentContextStack().push(proxyForContextElement); // the Context object was already created
                                                                          // elsewhere
        }
        try {
            parser.getTokenStream().seek(reference.getFirstToken().getTokenIndex());
            Object parseReturn;
            if (reference.isSemanticDisambiguatedOperatorRule()) {
                parseReturn = methodToCall.invoke(parser, reference.getPropertyName(),
                        reference.getOpTemplateLefthand(), reference.getFirstToken());
            } else {
                parseReturn = methodToCall.invoke(parser);
            }
            // add the parsed part to the object
            parser.setResolveProxies(originalResolveProxiesValue);
            reference.setRealValue(parser.getInjector().createOrResolve((ModelElementProxy) parseReturn, null, null));
            // by default use partition of reference.getModelElement
            if (reference.getModelElement() instanceof EObject && reference.getRealValue() instanceof EObject) {
                ((EObject) reference.getContextElement()).eResource().getContents()
                        .add((EObject) reference.getRealValue());
            }

            ModelElementProxy oldModelElement = ((ModelElementProxy) reference.getModelElement());
            oldModelElement.setRealObject(reference.getRealValue());
            Object parentProxy = oldModelElement.getParent();
            Object parentElement = ((ModelElementProxy) parentProxy).getRealObject();
            String parentPropertyName = oldModelElement.getParentPropertyName();
            modelAdapter.set(parentElement, parentPropertyName, reference.getRealValue());
        } finally {
            if (reference.hasContext()) {
                parser.leaveContext();
            }
            parser.getCurrentContextStack().pop();
        }
    }

    // TODO support the other basic types as well
    private boolean isBasicType(Object ref) {
        if (ref instanceof String) {
            return true;
        }
        return false;
    }

}
