package com.sap.river.interpreter.repository;

import com.sap.river.interpreter.objects.Link;

public abstract class LinkChange extends RepositoryChange {
    private Integer position;

    public LinkChange(Link link, Integer insertPosition) {
	super(link);
	this.position = insertPosition;
    }

    @Override
    public Link getObject() {
	return (Link) super.getObject();
    }

    @Override
    public boolean isEntityChange() {
	return false;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer newPosition) {
        this.position = newPosition;
    }
    
}
