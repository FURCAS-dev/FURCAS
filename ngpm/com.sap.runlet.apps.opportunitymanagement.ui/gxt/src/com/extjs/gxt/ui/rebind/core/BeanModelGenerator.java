/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.rebind.core;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.data.BeanModel;
import com.extjs.gxt.ui.client.data.BeanModelFactory;
import com.extjs.gxt.ui.client.data.BeanModelLookup;
import com.extjs.gxt.ui.client.data.BeanModelMarker;
import com.extjs.gxt.ui.client.data.BeanModelTag;
import com.extjs.gxt.ui.client.data.NestedModelUtil;
import com.extjs.gxt.ui.client.data.BeanModelMarker.BEAN;
import com.google.gwt.core.ext.Generator;
import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.JMethod;
import com.google.gwt.core.ext.typeinfo.JParameterizedType;
import com.google.gwt.core.ext.typeinfo.NotFoundException;
import com.google.gwt.core.ext.typeinfo.TypeOracle;
import com.google.gwt.user.rebind.ClassSourceFileComposerFactory;
import com.google.gwt.user.rebind.SourceWriter;

public class BeanModelGenerator extends Generator {

  private TypeOracle oracle;
  private JClassType beanModelMarkerType;
  private JClassType beanModelTagType;
  private List<JClassType> beans;

  @Override
  public String generate(TreeLogger logger, GeneratorContext context, String typeName)
      throws UnableToCompleteException {
    oracle = context.getTypeOracle();
    beanModelMarkerType = oracle.findType(BeanModelMarker.class.getName());
    beanModelTagType = oracle.findType(BeanModelTag.class.getName());

    try {
      // final all beans and bean markers
      beans = new ArrayList<JClassType>();
      JClassType[] types = oracle.getTypes();
      for (JClassType type : types) {
        if (isBeanMarker(type)) {
          beans.add(getMarkerBean(type));
        } else if (isBean(type)) {
          beans.add(type);
        }
      }

      final String genPackageName = "com.extjs.gxt.ui.client.data";
      final String genClassName = "BeanModelLookupImpl";

      ClassSourceFileComposerFactory composer = new ClassSourceFileComposerFactory(genPackageName,
          genClassName);
      composer.setSuperclass(BeanModelLookup.class.getCanonicalName());
      composer.addImport("java.util.Map");
      composer.addImport("java.util.HashMap");
      composer.addImport(BeanModelFactory.class.getName());

      PrintWriter pw = context.tryCreate(logger, genPackageName, genClassName);

      if (pw != null) {
        SourceWriter sw = composer.createSourceWriter(context, pw);
        sw.println("private Map<Class, BeanModelFactory> map = new HashMap<Class, BeanModelFactory>();");

        sw.println("BeanModelLookupImpl() {");

        for (JClassType bean : beans) {
          String name = createBean(bean, logger, context);
          String factory = createFactory(bean, name, logger, context);

          sw.println("map.put(" + bean.getQualifiedSourceName() + ".class, new " + factory + "());");
        }

        sw.println("}");
        sw.println("public BeanModelFactory getFactory(Class beanClass) {");
        sw.println("return map.get(beanClass);");
        sw.println("}");
        sw.commit(logger);
      }

      return composer.getCreatedClassName();

    } catch (Exception e) {
      logger.log(TreeLogger.ERROR, "Class " + typeName + " not found.", e);
      throw new UnableToCompleteException();
    }

  }

  private String createFactory(JClassType bean, String beanModelName, TreeLogger logger,
      GeneratorContext context) throws Exception {
    final String genPackageName = "com.extjs.gxt.ui.client.data";
    final String genClassName = "BeanModel_" + bean.getQualifiedSourceName().replace(".", "_")
        + "_Factory";

    ClassSourceFileComposerFactory composer = new ClassSourceFileComposerFactory(genPackageName,
        genClassName);
    composer.setSuperclass(BeanModelFactory.class.getCanonicalName());
    PrintWriter pw = context.tryCreate(logger, genPackageName, genClassName);

    if (pw != null) {
      SourceWriter sw = composer.createSourceWriter(context, pw);
      sw.println("public BeanModel newInstance() {");
      sw.println("return new " + beanModelName + "();");
      sw.println("}");
      sw.commit(logger);
    }
    return composer.getCreatedClassName();
  }

  private String createBean(JClassType bean, TreeLogger logger, GeneratorContext context)
      throws Exception {
    final String genPackageName = bean.getPackage().getName();
    final String genClassName = "BeanModel_" + bean.getQualifiedSourceName().replace(".", "_");

    ClassSourceFileComposerFactory composer = new ClassSourceFileComposerFactory(genPackageName,
        genClassName);
    composer.setSuperclass(BeanModel.class.getCanonicalName());
    composer.addImport(BeanModel.class.getName());
    composer.addImport(NestedModelUtil.class.getName());
    PrintWriter pw = context.tryCreate(logger, genPackageName, genClassName);

    if (pw != null) {
      List<JMethod> getters = findGetters(bean);
      List<JMethod> setters = findSetters(bean);
      SourceWriter sw = composer.createSourceWriter(context, pw);

      sw.println("public " + genClassName + "(){");
      for (JMethod method : getters) {
        String s = method.getName();
        String p = lowerFirst(s.substring(s.startsWith("g") ? 3 : 2)); // get or
        // is
        sw.println("beanProperties.add(\"" + p + "\");");
      }
      sw.println("}");

      createGetMethods(getters, sw, bean.getQualifiedSourceName());
      createSetMethods(setters, sw, bean.getQualifiedSourceName());

      // delegate equals to bean
      sw.println("public boolean equals(Object obj) {");
      sw.println("  if (obj instanceof " + "BeanModel" + ") {");
      sw.println("    obj = ((BeanModel)obj).getBean();");
      sw.println("  }");
      sw.println("  return bean.equals(obj);");
      sw.println("}");

      // delegate hashCode to bean
      sw.println("public int hashCode(){");
      sw.println("  return bean.hashCode();");
      sw.println("}");

      sw.commit(logger);
    }
    return composer.getCreatedClassName();
  }

  private JClassType getMarkerBean(JClassType type) throws NotFoundException {
    BEAN pojo = type.getAnnotation(BEAN.class);
    return oracle.getType(pojo.value().getCanonicalName());
  }

  private boolean isBean(JClassType type) {
    return !type.equals(beanModelTagType) && type.isAssignableTo(beanModelTagType);
  }

  private boolean isBeanMarker(JClassType type) {
    return !type.equals(beanModelMarkerType) && type.isAssignableTo(beanModelMarkerType);
  }

  private void createGetMethods(List<JMethod> getters, SourceWriter sw, String typeName) {
    sw.println("public <X> X get(String s) {");

    sw.println("if (allowNestedValues && NestedModelUtil.isNestedProperty(s)) {");
    sw.println("    return (X)NestedModelUtil.getNestedValue(this, s);");
    sw.println("}");

    for (JMethod method : getters) {
      JClassType returnType = method.getReturnType().isClassOrInterface();
      String s = method.getName();
      String p = lowerFirst(s.substring(s.startsWith("g") ? 3 : 2)); // get or

      sw.println("if (s.equals(\"" + p + "\")) {");
      sw.println("Object value = ((" + typeName + ")bean)." + s + "();");

      try {
        if (returnType != null) {
          if (returnType.isAssignableTo(oracle.getType("java.util.List"))) {
            if (returnType.isParameterized() != null) {
              JParameterizedType type = returnType.isParameterized();
              JClassType[] params = type.getTypeArgs();
              if (params[0].isAssignableTo(beanModelTagType)) {
                sw.println("if (value != null) {");
                sw.println("   java.util.List list = (java.util.List)value;");
                sw.println("   java.util.List temp = new java.util.ArrayList();");
                sw.println("   for (Object obj : list) {");
                sw.println("     temp.add(");
                sw.println(BeanModelLookup.class.getCanonicalName() + ".get().getFactory("
                    + params[0].getQualifiedSourceName() + ".class).createModel(obj));");
                sw.println("   }");
                sw.println(" return (X)temp;");
                sw.println("}");
              }
            }
          }
        }
        // swap returnType as generic types were not matching
        // (beans.contains(returnType))
        if (returnType != null) {
          String t = returnType.getQualifiedSourceName();
          if (t.indexOf("extends") == -1) {
            returnType = oracle.getType(t);
          }
        }
        if (beans.contains(returnType)) {
          sw.println("if (value != null) {");
          sw.println("    BeanModel nestedModel = nestedModels.get(s);");
          sw.println("    if (nestedModel != null) {");
          sw.println("      Object bean = nestedModel.getBean();");
          sw.println("      if (!bean.equals(value)){");
          sw.println("        nestedModel = null;");
          sw.println("      }");
          sw.println("    }");
          sw.println("    if (nestedModel == null) {");
          sw.println("        nestedModel = " + BeanModelLookup.class.getCanonicalName()
              + ".get().getFactory(" + returnType.getQualifiedSourceName()
              + ".class).createModel(value);");
          sw.println("        nestedModels.put(s, nestedModel);");
          sw.println("    }");
          sw.println("    return (X)processValue(nestedModel);");
          sw.println("}");
        }
      } catch (Exception e) {
        e.printStackTrace();
      }

      sw.println("return (X)processValue(value);");
      sw.println("}");
    }
    sw.println("return super.get(s);");
    sw.println("}");
  }

  private String lowerFirst(String propName) {
    if (propName.length() == 0) {
      return propName;
    } else if (propName.length() == 1) {
      return propName.toLowerCase();
    } else {
      return propName.substring(0, 1).toLowerCase() + propName.substring(1);
    }
  }

  private void createSetMethods(List<JMethod> properties, SourceWriter sw, String typeName) {
    sw.println("public <X> X set(String s, X val) {");
    sw.indent();
    sw.println("Object obj = val;");
    sw.println("if (allowNestedValues && val instanceof BeanModel) {");
    sw.println("  obj = ((BeanModel)val).getBean();");
    sw.println("  if (nestedModels.containsKey(s)) {");
    sw.println("    nestedModels.put(s, (BeanModel)val);");
    sw.println("  }");
    sw.println("}");

    sw.println("if (allowNestedValues && NestedModelUtil.isNestedProperty(s)) {");
    sw.println("    return (X)NestedModelUtil.setNestedValue(this, s, val);");
    sw.println("}");

    for (JMethod method : properties) {
      String s = method.getName();
      String p = lowerFirst(s.substring(3));
      String type = method.getParameters()[0].getType().getQualifiedSourceName();

      if (type.indexOf("extends") != -1) {
        type = "java.lang.Object";
      }

      if (type.equals("byte")) {
        type = "Byte";
      } else if (type.equals("char")) {
        type = "Character";
      } else if (type.equals("short")) {
        type = "Short";
      } else if (type.equals("int")) {
        type = "Integer";
      } else if (type.equals("long")) {
        type = "Long";
      } else if (type.equals("float")) {
        type = "Float";
      } else if (type.equals("double")) {
        type = "Double";
      } else if (type.equals("boolean")) {
        type = "Boolean";
      }

      sw.println("if (s.equals(\"" + p + "\")) {");
      sw.println("Object old = get(s);");
      sw.println("((" + typeName + ")bean)." + s + "((" + type + ")obj);");
      sw.println("notifyPropertyChanged(s, val, old);");
      sw.println("return (X)old;");
      sw.println("}");
    }
    sw.println("return super.set(s, val);");
    sw.outdent();
    sw.println("}");
  }

  private List<JMethod> findGetters(JClassType cls) {
    List<JMethod> methods = new ArrayList<JMethod>();
    addGetters(cls, methods);
    return methods;
  }

  private void addGetters(JClassType cls, List<JMethod> methods) {

    // ignore methods of Object
    if (cls.getSuperclass() != null) {
      addGetters(cls.getSuperclass(), methods);
      for (JMethod m : cls.getMethods()) {
        if(m.isPublic() || m.isProtected()) {
          String name = m.getName();
          if ((name.matches("get.*") || name.matches("is.*")) && m.getParameters().length == 0) {
            methods.add(m);
          }
        }
      }
    }

  }

  private List<JMethod> findSetters(JClassType cls) {
    List<JMethod> methods = new ArrayList<JMethod>();
    addSetters(cls, methods);
    return methods;
  }

  private void addSetters(JClassType cls, List<JMethod> methods) {
    if (cls.getSuperclass() != null) {
      addSetters(cls.getSuperclass(), methods);
    }
    for (JMethod m : cls.getMethods()) {
      if(m.isPublic() || m.isProtected()) {
        String name = m.getName();
        if (name.matches("set.*") && m.getParameters().length == 1) {
          methods.add(m);
        }
      }
    }
  }

}
