/*
 * Ext GWT - Ext for GWT
 * Copyright(c) 2007-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.ui.rebind.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.core.Markup;
import com.extjs.gxt.ui.client.core.MarkupBase;
import com.extjs.gxt.ui.client.core.Template;
import com.extjs.gxt.ui.client.core.Templates;
import com.extjs.gxt.ui.client.core.TemplatesBase;
import com.extjs.gxt.ui.client.core.TemplatesCache;
import com.extjs.gxt.ui.client.core.Templates.Cache;
import com.extjs.gxt.ui.client.core.Templates.Compress;
import com.extjs.gxt.ui.client.core.Templates.Resource;
import com.extjs.gxt.ui.client.core.Templates.Selector;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.ext.Generator;
import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.JMethod;
import com.google.gwt.core.ext.typeinfo.JParameter;
import com.google.gwt.core.ext.typeinfo.JType;
import com.google.gwt.core.ext.typeinfo.NotFoundException;
import com.google.gwt.core.ext.typeinfo.TypeOracle;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.rebind.ClassSourceFileComposerFactory;
import com.google.gwt.user.rebind.SourceWriter;

/**
 * This is the thread-safe Generator for
 * {@link com.extjs.gxt.ui.client.core.Templates} subinterfaces.
 */
public class TemplatesGenerator extends Generator {

  @Override
  public String generate(TreeLogger logger, GeneratorContext context, String typeName)
      throws UnableToCompleteException {
    return new SourceGenerator(logger, context).generate(typeName);
  }

  /**
   * This class is responsible for creating the implementing class of a
   * {@link com.extjs.gxt.ui.client.core.Templates} subinterface.
   */
  public static class SourceGenerator {
    private TreeLogger logger;
    private GeneratorContext context;
    private JClassType type;
    private ClassSourceFileComposerFactory composer;
    private SourceWriter sw;
    private JType templateType;
    private JType stringType;
    private JClassType elementType;
    private JClassType templatesType;
    private JClassType markupType;
    private JClassType elType;

    public SourceGenerator(TreeLogger logger, GeneratorContext context) {
      this.logger = logger;
      this.context = context;
    }

    public String generate(String typeName) throws UnableToCompleteException {
      TypeOracle oracle = context.getTypeOracle();

      try {
        type = oracle.getType(typeName);
        elementType = oracle.getType(Element.class.getName());
        templatesType = oracle.getType(Templates.class.getName());
        templateType = oracle.getType(Template.class.getName());
        stringType = oracle.getType(String.class.getName());
        markupType = oracle.getType(Markup.class.getName());
        elType = oracle.getType(El.class.getName());
      } catch (NotFoundException e) {
        logger.log(TreeLogger.ERROR, "Class " + typeName + " not found.", e);
        throw new UnableToCompleteException();
      }

      validateType();

      final String genPackageName = type.getPackage().getName();
      final String genClassName = (type.getName().replace('.', '_')) + "Impl";

      composer = new ClassSourceFileComposerFactory(genPackageName, genClassName);
      if (type.isAssignableTo(markupType)) {
        composer.setSuperclass(MarkupBase.class.getName());
      } else {
        composer.setSuperclass(TemplatesBase.class.getName());
      }
      composer.addImplementedInterface(type.getQualifiedSourceName());
      composer.addImport(Template.class.getName());

      composer.addImport(GWT.class.getName());
      composer.addImport(MarkupBase.class.getName());
      composer.addImport(TemplatesBase.class.getName());
      composer.addImport(elementType.getQualifiedSourceName());
      composer.addImport(elType.getQualifiedSourceName());
      composer.addImport(templatesType.getQualifiedSourceName());
      composer.addImport(markupType.getQualifiedSourceName());
      composer.addImport(TemplatesCache.class.getName());

      PrintWriter pw = context.tryCreate(logger, genPackageName, genClassName);

      if (pw != null) {
        sw = composer.createSourceWriter(context, pw);

        for (JMethod method : type.getOverridableMethods()) {
          if (type.isAssignableTo(templatesType)) {
            createTemplatesMethod(method);
          } else if (type.isAssignableTo(markupType)) {
            createMarkupMethod(method);
          }

        }

        sw.commit(logger);
      }
      return composer.getCreatedClassName();
    }

    private void validateType() throws UnableToCompleteException {
      // check for duplicate method names
      Set<String> methodNames = new HashSet<String>();
      for (JMethod method : type.getOverridableMethods()) {
        if (methodNames.contains(method.getName())) {
          logger.log(TreeLogger.ERROR, "Class " + type
              + " must not contain multiple methods of the same name. [" + method.getName() + "]");
          throw new UnableToCompleteException();
        }
        methodNames.add(method.getName());
      }
    }

    private void createMarkupMethod(JMethod method) throws UnableToCompleteException {

      final boolean returnsEl = method.getReturnType() == elType;
      final boolean returnsElement = method.getReturnType() == elementType;

      if (!(returnsEl || returnsElement)) {
        return;
      }

      String selector;
      Selector selectorAnn = method.getAnnotation(Selector.class);
      if (selectorAnn == null || "".equals(selectorAnn.value())) {
        return;
      }
      selector = selectorAnn.value();

      sw.indent();
      sw.print(method.getReadableDeclaration(false, false, false, false, true));
      sw.println(" {");
      sw.indent();

      sw.println("Element element = select(\"" + escape(selector) + "\");");

      // TODO do all selectors have to return a node ? Should null checking be
      // done here, or in the caller ?
      // sw.println("assert element != null : \"" + method.getName() + " using
      // selector '" + escape(selector) + "' returned a null element\";");

      sw.println("return " + (returnsEl ? "new El(element);" : "element;"));
      sw.outdent();
      sw.println("}");
    }

    private void createTemplatesMethod(JMethod method) throws UnableToCompleteException {

      final boolean returnString = method.getReturnType() == stringType;
      final boolean returnsMarkup = method.getReturnType().isInterface() != null
          && method.getReturnType().isInterface().isAssignableTo(markupType);
      final boolean returnsTemplate = method.getReturnType() == templateType;

      if (!(returnsTemplate || returnString || returnsMarkup)) {
        logger.log(TreeLogger.ERROR, "Method " + method.getName() + " does not return "
            + templateType + " or " + stringType + " or " + markupType);
        throw new UnableToCompleteException();
      }

      // System.out.println(cacheKeyExpression);

      sw.indent();
      // System.out.println(method.getReadableDeclaration(false, false, false,
      // false, true));
      sw.print(method.getReadableDeclaration(false, false, false, false, true));
      sw.println(" {");
      sw.indent();

      // return String or subclass of Markup
      if (returnString) {

        boolean cache = isCache(method);
        String content = readResource(method);
        String cacheKeyExpression = createCacheKeyExpression(method);

        if (cache) {
          sw.print("String cached = (String)TemplatesCache.INSTANCE.get(" + cacheKeyExpression
              + ");");
          sw.println("if (cached != null) return cached;");
        }

        generateResultBody(content);

        if (cache) {
          sw.print("TemplatesCache.INSTANCE.put(result, " + cacheKeyExpression + ");");
        }

        sw.println("return result;");

      } else if (returnsMarkup) {

        boolean cache = isCache(method);
        String content = readResource(method);
        String cacheKeyExpression = createCacheKeyExpression(method);

        generateReturnsMarkupMethod(method, cache, content, cacheKeyExpression);

      } else if (returnsTemplate) {

        boolean cache = isCache(method);
        String content = readResource(method);
        String cacheKeyExpression = createCacheKeyExpression(method);

        // if Cache enabled, generate source to lookup the cached value
        if (cache) {
          sw.print("Template cached = (Template)TemplatesCache.INSTANCE.get(" + cacheKeyExpression
              + ");");
          sw.println("if (cached != null) return cached;");
        }

        generateResultBody(content);

        sw.println("Template template = new Template(result);");

        // if cache enabled, compile the template and store it in the cache
        if (cache) {
          sw.print("template.compile();");
          sw.print("TemplatesCache.INSTANCE.put(template, " + cacheKeyExpression + ");");
        }

        sw.println("return template;");

      }

      sw.outdent();
      sw.println("}");
      sw.outdent();

    }

    private boolean isCache(JMethod method) {
      boolean cache = false;
      Cache cacheAnn = method.getAnnotation(Cache.class);
      cache = (cacheAnn != null);
      return cache;
    }

    private void generateReturnsMarkupMethod(JMethod method, boolean cache, String content,
        String cacheKeyExpression) throws UnableToCompleteException {
      String returnTypeName = method.getReturnType().getParameterizedQualifiedSourceName();
      String newMarkupBaseSource = method.getReturnType() == markupType ? "new MarkupBase();"
          : "(MarkupBase)GWT.create(" + returnTypeName + ".class);";

      if (cache) {
        sw.print("MarkupBase cached = (MarkupBase)TemplatesCache.INSTANCE.get("
            + cacheKeyExpression + ");");
        sw.println("if (cached != null) {");
        sw.println("  MarkupBase clone = " + newMarkupBaseSource);
        sw.println("  clone.init(cached.getHtml(), (Element)cached.getRootElement().cloneNode(true));");
        sw.println("  return (" + returnTypeName + ") clone;");
        sw.println("}");
      }

      generateResultBody(content);

      sw.print("MarkupBase markup = " + newMarkupBaseSource);
      sw.print("markup.init(result, MarkupBase.createRootElement(result));");

      if (cache) {
        sw.print("TemplatesCache.INSTANCE.put(markup, " + cacheKeyExpression + ");");
      }

      sw.println("return (" + returnTypeName + ") markup;");
    }

    private void generateResultBody(String content) throws UnableToCompleteException {
      sw.println("StringBuilder sb = new StringBuilder();");
      // put the template code in a nested block to limit the scope of its
      // variables
      sw.println("{");
      sw.indent();
      new TemplateToJavaSourceConverter(logger, sw, content).convert();
      sw.outdent();
      sw.println("}");
      sw.println("String result = sb.toString();");
    }

    private String createCacheKeyExpression(JMethod method) {
      String cacheKeyExpression = "\"" + type.getParameterizedQualifiedSourceName() + "#"
          + method.getName() + "\"";
      for (JParameter parameter : method.getParameters()) {
        cacheKeyExpression += "," + parameter.getName();
      }
      return cacheKeyExpression;
    }

    private String readResource(JMethod method) throws UnableToCompleteException {

      String content = null;

      // try and read from a file
      String resource;
      Resource resourceAnn = method.getAnnotation(Resource.class);
      if (resourceAnn != null && !resourceAnn.value().equals("")) {
        resource = resourceAnn.value();
      } else {
        resource = type.getName() + "#" + method.getName() + ".html";
      }
      resource = type.getPackage().getName().replace(".", "/") + "/" + resource;
      InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(resource);
      if (is == null) {
        logger.log(TreeLogger.ERROR, "Unable to find source template file " + resource
            + " for method " + method.getName() + ".");
        throw new UnableToCompleteException();
      }
      StringBuilder sb = new StringBuilder();

      BufferedReader br = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));

      try {
        String buffer = br.readLine();
        while (buffer != null) {
          sb.append(buffer);
          buffer = br.readLine();
          if (buffer != null) {
            sb.append('\n');
          }
        }
      } catch (IOException e) {
        throw new UnableToCompleteException();
      }
      content = sb.toString();

      if (method.getAnnotation(Compress.class) != null) {
        content = compressHtml(content);
      }

      return content;

    }
  }

  /**
   * <p/>this class encapsulates all of the code to transform a single template
   * into java source
   * 
   * <p/>When the {@link TemplateToJavaSourceConverter#convert()} method is
   * called the generated source already contains a variable "StringBuilder sb"
   * initialized to a new instance
   * 
   * <p/>The {@link TemplateToJavaSourceConverter#convert()} method should
   * generate source of the form
   * 
   * <pre>
   *  sb.append("some text");
   *  if (true) {
   *    sb.append("some more text");
   *  }
   *  </pre>
   */
  public static class TemplateToJavaSourceConverter {

    private final TreeLogger logger;
    private final SourceWriter sw;
    private final String content;

    private static Pattern codeStartPattern = Pattern.compile("(.*?)((?:<%)|(?:<#)|(?:\\$\\{))",
        Pattern.DOTALL);
    private static Pattern fmListPattern = Pattern.compile("(.+?)\\s+as\\s+(?:(.+?):)?([^:]+)");
    private static Pattern iterableRangePattern = Pattern.compile("\\[?(.+)\\.\\.([^\\]]+)");
    private static Pattern iterableTablePattern = Pattern.compile("\\[([^(?:\\.\\.)]*)\\]",
        Pattern.DOTALL);

    private char codeType;
    private String codeEnd;
    private String iterableName;
    private String variableName;
    private String variableType;

    private TemplateToJavaSourceConverter(TreeLogger logger, SourceWriter sw, String content) {
      this.logger = logger;
      this.sw = sw;
      this.content = content;
    }

    private void convert() throws UnableToCompleteException {
      int currentPosition = 0;
      int contentLength = content.length();

      while (currentPosition < contentLength) {
        // Find next code start
        int nextCodeStartPosition = findNextCodeStart(content, currentPosition);

        // If there is text then add it
        if (nextCodeStartPosition > currentPosition || nextCodeStartPosition == -1) {
          sw.print("sb.append(\"");
          if (nextCodeStartPosition == -1) {
            sw.print(Generator.escape(content.substring(currentPosition)));
          } else {
            sw.print(Generator.escape(content.substring(currentPosition, nextCodeStartPosition)));
          }
          sw.println("\");");
        }

        if (nextCodeStartPosition == -1) {
          break;
        }

        currentPosition = nextCodeStartPosition;

        int codeEndPosition = findCodeEndPosition(content, currentPosition);
        if (codeEndPosition == -1) {
          logger.log(TreeLogger.ERROR, "Code end not found.");
          throw new UnableToCompleteException();
        }

        generateCode(content.substring(currentPosition + 2, codeEndPosition));

        currentPosition = codeEndPosition + codeEnd.length();
      }
    }

    private void generateCode(String code) throws UnableToCompleteException {
      switch (codeType) {
        case '%':
        case '{':
          generateJspCode(code);
          break;
        case '#':
          generateFMCode(code);
          break;
      }
    }

    private void generateFMCode(String code) throws UnableToCompleteException {
      int firstWordEnd = code.indexOf(' ');
      if (firstWordEnd == -1) {
        firstWordEnd = code.length();
      }

      String firstWord = code.substring(0, firstWordEnd);
      String parameters = code.substring(firstWordEnd).trim();

      if ("if".equals(firstWord)) {
        fmIf(parameters);
      } else if ("end".equals(firstWord)) {
        fmEnd(parameters);
      } else if ("else".equals(firstWord)) {
        fmElse(parameters);
      } else if ("elseif".equals(firstWord)) {
        fmElseif(parameters);
      } else if ("list".equals(firstWord)) {
        fmList(parameters);
      } else {
        logger.log(TreeLogger.ERROR, "Unknown FM code " + firstWord + ".");
      }
    }

    private void fmElseif(String parameters) {
      sw.outdent();
      sw.print("} else if (");
      sw.print(parameters);
      sw.println(") {");
      sw.indent();
    }

    private void fmElse(String parameters) {
      sw.println("} else {");
    }

    private void fmList(String parameters) throws UnableToCompleteException {
      Matcher matcher = fmListPattern.matcher(parameters);

      if (!matcher.matches()) {
        logger.log(TreeLogger.ERROR, "Incorrect parameters for list function.");
        throw new UnableToCompleteException();
      }

      iterableName = matcher.group(1);
      variableType = matcher.group(2);
      variableName = matcher.group(3);

      analyseIterable();

      sw.print("for(");
      sw.print(variableType == null ? "Object" : variableType);
      sw.print(" ");
      sw.print(variableName);
      sw.print(" : ");
      sw.print(iterableName);
      sw.println(") {");
      sw.indent();
    }

    private void analyseIterable() {
      // Is it a range?
      Matcher matcher = iterableRangePattern.matcher(iterableName);
      if (matcher.matches()) {
        iterableName = "(new IterableRange<Integer>(" + matcher.group(1) + "," + matcher.group(2)
            + "))";
        variableType = "int";
        return;
      }

      // Is it a table?
      matcher = iterableTablePattern.matcher(iterableName);
      if (matcher.matches()) {
        String type = variableType == null ? "Object" : variableType;
        iterableName = "new " + type + "[] {" + matcher.group(1) + "}";
        return;
      }
    }

    private void fmEnd(String parameters) {
      sw.println("}");
      sw.outdent();
    }

    private void fmIf(String parameters) {
      sw.print("if (");
      sw.print(parameters);
      sw.println(") {");
      sw.indent();
    }

    private void generateJspCode(String code) {
      if (codeType == '{' || code.charAt(0) == '=') {
        sw.print("sb.append(");
        if (codeType == '{') {
          sw.print(code);
        } else {
          sw.print(code.substring(1));
        }
        sw.println(");");
      } else {
        sw.println(code);
      }
    }

    private int findCodeEndPosition(String content, int currentPosition) {
      switch (codeType) {
        case '%':
          codeEnd = "%>";
          break;
        case '#':
          codeEnd = "#>";
          break;
        case '{':
          codeEnd = "}";
          break;
      }
      return content.indexOf(codeEnd, currentPosition);
    }

    private int findNextCodeStart(String content, int currentPosition) {
      Matcher matcher = codeStartPattern.matcher(content);
      if (!matcher.find(currentPosition)) {
        return -1;
      } else {
        codeType = matcher.group(2).charAt(1);
        return matcher.start(2);
      }
    }
  }

  public static String compressHtml(String html) {
    if (html == null) return null;
    html = html.replaceAll("(?s)<!--.*?-->", "");
    html = html.replaceAll("(?s)>[\\t\\n ]*<", "><");
    html = html.replaceAll("(?s)^[\\t\\n ]*<", "<");
    html = html.replaceAll("(?s)>[\\t\\n ]*$", ">");
    return html;
  }

}