package javax.jmi.model;

import javax.jmi.reflect.RefObject;

@SuppressWarnings( { "unchecked", "nls" } )
public interface ModelElement extends RefObject {

//    public String CONTAINERDEP = "container";
//    public String CONTENTSDEP = "contents";
//    public String SIGNATUREDEP = "signature";
//    public String CONSTRAINTDEP = "constraint";
//    public String CONSTRAINEDELEMENTSDEP = "constrained elements";
//    public String SPECIALIZATIONDEP = "specialization";
//    public String IMPORTDEP = "import";
//    public String TYPEDEFINITIONDEP = "type definition";
//    public String REFERENCEDENDSDEP = "referenced ends";
//    public String TAGGEDELEMENTSDEP = "tagged elements";
//    public String INDIRECTDEP = "indirect";
//    public String ALLDEP = "all";

    public String CONTAINER_DEP = "container";

    public String CONTENTS_DEP = "contents";

    public String SIGNATURE_DEP = "signature";

    public String CONSTRAINT_DEP = "constraint";

    public String CONSTRAINED_ELEMENTS_DEP = "constrained elements";

    public String SPECIALIZATION_DEP = "specialization";

    public String IMPORT_DEP = "import";

    public String TYPE_DEFINITION_DEP = "type definition";

    public String REFERENCED_ENDS_DEP = "referenced ends";

    public String TAGGED_ELEMENTS_DEP = "tagged elements";

    public String INDIRECT_DEP = "indirect";

    public String ALL_DEP = "all";

    public java.util.Collection findRequiredElements( java.util.Collection kinds, boolean recursive );

    public boolean isRequiredBecause( ModelElement otherElement, String reason[] );

    public boolean isFrozen( );

    public boolean isVisible( ModelElement otherElement );

    public String getName( );

    public void setName( String newValue );

    public java.util.List getQualifiedName( );

    public String getAnnotation( );

    public void setAnnotation( String newValue );

    public java.util.Collection getRequiredElements( );

    public Namespace getContainer( );

    public void setContainer( Namespace newValue );

    public java.util.Collection getConstraints( );
}
