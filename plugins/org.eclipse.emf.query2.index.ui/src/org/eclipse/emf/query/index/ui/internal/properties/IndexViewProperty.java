package org.eclipse.emf.query.index.ui.internal.properties;

public class IndexViewProperty {
	
	private String property;
	private String value;
	private Object parent;
	
	

	public IndexViewProperty(String property,String value){
		this.property = property;
		this.value = value;	
	}
	
	public String getProperty() {
		return property;
	}

	public String getValue() {
		return value;
	}
	
	public Object getParent() {
		return parent;
	}

	public void setParent(Object parent) {
		this.parent = parent;
	}

}
