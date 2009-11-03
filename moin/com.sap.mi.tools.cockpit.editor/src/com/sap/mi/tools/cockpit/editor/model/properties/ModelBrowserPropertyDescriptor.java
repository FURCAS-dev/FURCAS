package com.sap.mi.tools.cockpit.editor.model.properties;

import org.eclipse.ui.views.properties.PropertyDescriptor;

/**
 * @author d003456
 *
 */
public class ModelBrowserPropertyDescriptor extends PropertyDescriptor {
    
	private boolean isAttribute;
    private String name;
    private String attributeKey;
    AttributeValueType type;
    private int index;
    private boolean isEditable;
    private boolean isMultiValued;
    
	/**
	 * Constructor
	 * @param id
	 * @param displayName
	 */
	public ModelBrowserPropertyDescriptor(Object id, String displayName) {
		super(id, displayName);
		this.isAttribute = false;
		this.attributeKey = null;
		this.isEditable = false;
		this.isMultiValued = false;
	}
	
	public boolean isAttribute()
    {
        return this.isAttribute;
    }

    public String getName()
    {
        return this.name;
    }

    public String getAttributeKey()
    {
        return this.attributeKey;
    }

    public AttributeValueType getType()
    {
        return this.type;
    }

    public int getIndex()
    {
        return this.index;
    }

    public boolean isEditable()
    {
        return this.isEditable;
    }

    public boolean isMultiValued()
    {
        return this.isMultiValued;
    }

    public void setIsAttribute(boolean isAttribute)
    {
        this.isAttribute = isAttribute;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setAttributeKey(String attributeKey)
    {
        this.attributeKey = attributeKey;
    }

    public void setType(AttributeValueType type)
    {
        this.type = type;
    }

    public void setIndex(int index)
    {
        this.index = index;
    }

    public void setIsEditable(boolean isEditable)
    {
        this.isEditable = isEditable;
    }

    public void setIsMultiValued(boolean isMultiValued)
    {
        this.isMultiValued = isMultiValued;
    }
}
