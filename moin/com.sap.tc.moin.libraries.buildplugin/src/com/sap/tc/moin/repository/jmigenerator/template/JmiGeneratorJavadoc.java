package com.sap.tc.moin.repository.jmigenerator.template;

import java.util.List;

/**
 * JMI Generator Java Doc consists of a description part and a tag part. Each
 * tag has a name and can have several values, e.g. the tag
 * <code>@exception</code> can have 2 values, <code>class-name</code> and
 * <code>description</code>
 */
public interface JmiGeneratorJavadoc {

    public List<JmiGeneratorJavadocLine> getDescription( );
}
