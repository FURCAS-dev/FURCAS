package com.sap.furcas.runtime.parser.textblocks.observer;

import java.util.ArrayList;
import java.util.List;

import com.sap.furcas.metamodel.TCS.ClassTemplate;
import com.sap.furcas.metamodel.TCS.InjectorAction;
import com.sap.furcas.metamodel.TCS.SequenceElement;
import com.sap.furcas.metamodel.TCS.Template;
import com.sap.furcas.metamodel.textblocks.AbstractToken;
import com.sap.furcas.runtime.common.interfaces.IModelElementProxy;

public class TextBlockProxy {
	
	private TextBlockProxy parent;
	
	@Override
	public String toString() {
		StringBuffer temp = new StringBuffer();
		for (Object block : this.getSubNodes()) {
			if(block instanceof TextBlockProxy) {
				//temp.append("tb[").append(((TextBlockProxy) block).getSubNodes().size()).append(":").append(block.toString()).append("]");
				temp.append(block.toString());
			} else if(block instanceof AbstractToken){
				temp.append(((AbstractToken) block).getValue());
			}
		}
		return temp.toString();
	}

	private final List<Object> subNodes = new ArrayList<Object>();

	private boolean complete;

	private final List<IModelElementProxy> correspondingModelElements = new ArrayList<IModelElementProxy>(1);

	private Template template;
	
	private final List<Template> additionalTemplates = new ArrayList<Template>();

	private SequenceElement sequenceElement;
	
	private InjectorAction injectorAction;

	private final List<Object> contextElements = new ArrayList<Object>();

	private final List<IModelElementProxy> referencedElements = new ArrayList<IModelElementProxy>();

	private final List<Integer> alternativeChoices = new ArrayList<Integer>(1);
	
	public <T extends Object> void addSubNode(T newNode) {
		subNodes.add(newNode);
	}
	
	public <T extends Object> void addSubNodes(List<T> newNodes) {
		subNodes.addAll(newNodes);
	}
	
	public <T extends Object> void addSubNodeAt(T newNode, int position) {
		subNodes.add(position, newNode);
	}
	
	public <T extends Object> void addSubNodesAt(List<T> newNodes, int position) {
		subNodes.addAll(position, newNodes);
	}
	
	public List<Object> getSubNodes() {
		return subNodes;
	}

	public TextBlockProxy getParent() {
		return parent;
	}

	public void setParent(TextBlockProxy parent) {
		this.parent = parent;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;		
	}

	public boolean isComplete() {
		return complete;
	}

	public void addCorrespondingModelElementProxy(IModelElementProxy newModelElement) {
	    if(getTemplate() != null && getTemplate() instanceof ClassTemplate &&
		    ((ClassTemplate)getTemplate()).isIsReferenceOnly()) {
		addReferencedElementProxy(newModelElement);
	    } else {
		this.correspondingModelElements.add(newModelElement);
	    }
	}

	public List<IModelElementProxy> getCorrespondingModelElementProxies() {
		return correspondingModelElements;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

	public Template getTemplate() {
		return template;
	}
	
	public void addAdditionalTemplate(Template template) {
		this.additionalTemplates.add(template);
	}

	public List<Template> getAdditionalTemplates() {
		return additionalTemplates;
	}
	
	public void addAdditionalTemplates(List<Template> additionalTemplates) {
		this.additionalTemplates.addAll(additionalTemplates);
	}

	public void removeSubNode(TextBlockProxy textBlockProxy) {
		subNodes.remove(textBlockProxy);
	}

	public void addCorrespondingModelElementProxies(
			List<IModelElementProxy> correspondingModelElements) {
	    if(getTemplate() != null && getTemplate() instanceof ClassTemplate &&
		    ((ClassTemplate)getTemplate()).isIsReferenceOnly()) {
		addReferencedElementProxies(correspondingModelElements);
	    } else {
		this.correspondingModelElements.addAll(correspondingModelElements);
	    }
	}

	public void setSequenceElement(SequenceElement sequenceElement) {
	    this.sequenceElement = sequenceElement;	    
	}

	public SequenceElement getSequenceElement() {
	    return sequenceElement;
	}

	public void addToContext(Object element) {
	    contextElements .add(element);
	}

	public List<Object> getContextElements() {
	    return contextElements;
	}

	public List<IModelElementProxy> getReferencedElementProxies() {
	    return referencedElements;
	}
	
	public void addReferencedElementProxy(IModelElementProxy referencedElement) {
		this.referencedElements.add(referencedElement);
	}
	
	public void addReferencedElementProxies(
		List<IModelElementProxy> referencedElements) {
	    this.referencedElements.addAll(referencedElements);
	}

	public InjectorAction getInjectorAction() {
	    return injectorAction;
	}

	public void setInjectorAction(InjectorAction action) {
	    injectorAction = action;
	}

	public void addAlternativeChoice(int choice) {
		alternativeChoices.add(choice);
	}

	public List<Integer> getAlternativeChoices() {
		return alternativeChoices;
	}

}
