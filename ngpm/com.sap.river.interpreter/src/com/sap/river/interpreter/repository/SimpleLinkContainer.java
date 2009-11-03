package com.sap.river.interpreter.repository;

import com.sap.river.interpreter.objects.Link;

public interface SimpleLinkContainer {

    public void addLink(Link link, Integer at);

    public void removeLink(Link link, Integer at);

}
