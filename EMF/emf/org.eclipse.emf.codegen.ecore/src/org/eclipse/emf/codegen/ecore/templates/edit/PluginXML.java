package org.eclipse.emf.codegen.ecore.templates.edit;

import java.util.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;

public class PluginXML
{
  protected static String nl;
  public static synchronized PluginXML create(String lineSeparator)
  {
    nl = lineSeparator;
    PluginXML result = new PluginXML();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + NL + "<?eclipse version=\"3.0\"?>" + NL;
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = "<!--";
  protected final String TEXT_4 = NL + " ";
  protected final String TEXT_5 = NL + " <copyright>" + NL + " </copyright>" + NL;
  protected final String TEXT_6 = NL + " ";
  protected final String TEXT_7 = "Id";
  protected final String TEXT_8 = NL + "-->" + NL;
  protected final String TEXT_9 = NL + "<plugin>";
  protected final String TEXT_10 = NL + "<plugin" + NL + "      name=\"%pluginName\"" + NL + "      id=\"";
  protected final String TEXT_11 = "\"" + NL + "      version=\"1.0.0\"" + NL + "      provider-name=\"%providerName\"" + NL + "      class=\"";
  protected final String TEXT_12 = "$Implementation\">" + NL + "" + NL + "   <requires>";
  protected final String TEXT_13 = NL + "      <import plugin=\"";
  protected final String TEXT_14 = "\"";
  protected final String TEXT_15 = " export=\"true\"";
  protected final String TEXT_16 = "/>";
  protected final String TEXT_17 = NL + "   </requires>" + NL + "" + NL + "   <runtime>";
  protected final String TEXT_18 = NL + "      <library name=\"";
  protected final String TEXT_19 = ".jar\">";
  protected final String TEXT_20 = NL + "      <library name=\".\">";
  protected final String TEXT_21 = NL + "         <export name=\"*\"/>" + NL + "      </library>" + NL + "   </runtime>";
  protected final String TEXT_22 = NL + NL + "   <extension point=\"org.eclipse.emf.edit.itemProviderAdapterFactories\">" + NL + "      <factory" + NL + "            uri=\"";
  protected final String TEXT_23 = "\"" + NL + "            class=\"";
  protected final String TEXT_24 = "\"" + NL + "            supportedTypes=";
  protected final String TEXT_25 = NL + "              ";
  protected final String TEXT_26 = "\"/>";
  protected final String TEXT_27 = NL + "   </extension>";
  protected final String TEXT_28 = NL + NL + "   <extension point=\"org.eclipse.emf.edit.childCreationExtenders\">";
  protected final String TEXT_29 = NL + "      <extender" + NL + "            uri=\"";
  protected final String TEXT_30 = "\"" + NL + "            class=\"";
  protected final String TEXT_31 = "$";
  protected final String TEXT_32 = "\"/>";
  protected final String TEXT_33 = NL + "   </extension>";
  protected final String TEXT_34 = NL + NL + "   <extension point=\"org.eclipse.emf.ecore.generated_package\">" + NL + "      <package" + NL + "            uri=\"";
  protected final String TEXT_35 = "\"";
  protected final String TEXT_36 = NL + "            class=\"";
  protected final String TEXT_37 = "\"" + NL + "            genModel=\"";
  protected final String TEXT_38 = "\"/>";
  protected final String TEXT_39 = NL + "            class=\"";
  protected final String TEXT_40 = "\"/>";
  protected final String TEXT_41 = NL + "   </extension>";
  protected final String TEXT_42 = NL + NL + "   <extension point=\"org.eclipse.emf.ecore.content_parser\">" + NL + "      <parser" + NL + "            contentTypeIdentifier=\"";
  protected final String TEXT_43 = "\"" + NL + "            class=\"";
  protected final String TEXT_44 = "\"/>" + NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.core.contenttype.contentTypes\">" + NL + "      <content-type" + NL + "            base-type=\"";
  protected final String TEXT_45 = "\"" + NL + "            file-extensions=\"";
  protected final String TEXT_46 = "\"" + NL + "            id=\"";
  protected final String TEXT_47 = "\"" + NL + "            name=\"%_UI_";
  protected final String TEXT_48 = "_content_type\"" + NL + "            priority=\"normal\">" + NL + "         <describer class=\"org.eclipse.emf.ecore.xmi.impl.RootXMLContentHandlerImpl$Describer\">";
  protected final String TEXT_49 = NL + "            <parameter name=\"namespace\" value=\"";
  protected final String TEXT_50 = "\"/>";
  protected final String TEXT_51 = NL + "            <parameter name=\"kind\" value=\"xmi\"/>";
  protected final String TEXT_52 = NL + "         </describer>" + NL + "      </content-type>" + NL + "   </extension>";
  protected final String TEXT_53 = NL + NL + "   <extension point=\"org.eclipse.emf.ecore.extension_parser\">" + NL + "      <parser" + NL + "            type=\"";
  protected final String TEXT_54 = "\"" + NL + "            class=\"";
  protected final String TEXT_55 = "\"/>" + NL + "   </extension>";
  protected final String TEXT_56 = NL + NL + "</plugin>";
  protected final String TEXT_57 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
/**
 * <copyright>
 *
 * Copyright (c) 2002-2005 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   IBM - Initial API and implementation
 *
 * </copyright>
 */

    GenModel genModel = (GenModel)argument;
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    {GenBase copyrightHolder = argument instanceof GenBase ? (GenBase)argument : argument instanceof Object[] && ((Object[])argument)[0] instanceof GenBase ? (GenBase)((Object[])argument)[0] : null;
    if (copyrightHolder != null && copyrightHolder.hasCopyright()) {
    stringBuffer.append(TEXT_4);
    stringBuffer.append(copyrightHolder.getCopyright(copyrightHolder.getGenModel().getIndentation(stringBuffer)));
    } else {
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    stringBuffer.append("$");
    stringBuffer.append(TEXT_7);
    stringBuffer.append("$");
    }}
    stringBuffer.append(TEXT_8);
    if (genModel.isBundleManifest()) {
    stringBuffer.append(TEXT_9);
    } else {
    stringBuffer.append(TEXT_10);
    stringBuffer.append(genModel.getEditPluginID());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(genModel.getQualifiedEditPluginClassName());
    stringBuffer.append(TEXT_12);
    for (String pluginID : genModel.getEditRequiredPlugins()) {
    stringBuffer.append(TEXT_13);
    stringBuffer.append(pluginID);
    stringBuffer.append(TEXT_14);
    if (!pluginID.startsWith("org.eclipse.core.runtime")) {
    stringBuffer.append(TEXT_15);
    }
    stringBuffer.append(TEXT_16);
    }
    stringBuffer.append(TEXT_17);
    if (genModel.isRuntimeJar()) {
    stringBuffer.append(TEXT_18);
    stringBuffer.append(genModel.getEditPluginID());
    stringBuffer.append(TEXT_19);
    } else {
    stringBuffer.append(TEXT_20);
    }
    stringBuffer.append(TEXT_21);
    }
    for (GenPackage genPackage : genModel.getAllGenPackagesWithClassifiers()) {
    if (!genPackage.getGenClasses().isEmpty()) {
    stringBuffer.append(TEXT_22);
    stringBuffer.append(genPackage.getNSURI());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(genPackage.getQualifiedItemProviderAdapterFactoryClassName());
    stringBuffer.append(TEXT_24);
    for (ListIterator<?> j = genPackage.getProviderSupportedTypes().listIterator(); j.hasNext(); ) {
    stringBuffer.append(TEXT_25);
    stringBuffer.append(j.hasPrevious() ? " " : "\"");
    stringBuffer.append(j.next());
    if (!j.hasNext()) {
    stringBuffer.append(TEXT_26);
    }
    }
    stringBuffer.append(TEXT_27);
    if (genPackage.isChildCreationExtenders()) { Map<GenPackage, Map<GenClass, List<GenClass.ChildCreationData>>> extendedChildCreationData = genPackage.getExtendedChildCreationData();
    if (!extendedChildCreationData.isEmpty()) {
    stringBuffer.append(TEXT_28);
    for (Map.Entry<GenPackage, Map<GenClass, List<GenClass.ChildCreationData>>> entry : extendedChildCreationData.entrySet()) {
    stringBuffer.append(TEXT_29);
    stringBuffer.append(entry.getKey().getNSURI());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(genPackage.getQualifiedItemProviderAdapterFactoryClassName());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(genPackage.getChildCreationExtenderName(entry.getKey()));
    stringBuffer.append(TEXT_32);
    }
    stringBuffer.append(TEXT_33);
    }
    }
    }
    }
    if (genModel.sameModelEditProject()) {
    for (GenPackage genPackage : genModel.getAllGenPackagesWithClassifiers()) {
    stringBuffer.append(TEXT_34);
    stringBuffer.append(genPackage.getNSURI());
    stringBuffer.append(TEXT_35);
    if (genModel.hasLocalGenModel()) {
    stringBuffer.append(TEXT_36);
    stringBuffer.append(genPackage.getQualifiedPackageInterfaceName());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(genModel.getRelativeGenModelLocation());
    stringBuffer.append(TEXT_38);
    } else {
    stringBuffer.append(TEXT_39);
    stringBuffer.append(genPackage.getQualifiedPackageInterfaceName());
    stringBuffer.append(TEXT_40);
    }
    stringBuffer.append(TEXT_41);
    if (genPackage.isContentType()) {
    stringBuffer.append(TEXT_42);
    stringBuffer.append(genPackage.getContentTypeIdentifier());
    stringBuffer.append(TEXT_43);
    stringBuffer.append(genPackage.getQualifiedEffectiveResourceFactoryClassName());
    stringBuffer.append(TEXT_44);
    stringBuffer.append(genPackage.isXMIResource() ? "org.eclipse.emf.ecore.xmi" : "org.eclipse.core.runtime.xml");
    stringBuffer.append(TEXT_45);
    stringBuffer.append(genPackage.getFileExtensions());
    stringBuffer.append(TEXT_46);
    stringBuffer.append(genPackage.getContentTypeIdentifier());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(genPackage.getPrefix());
    stringBuffer.append(TEXT_48);
    if (genPackage.hasTargetNamespace()) {
    stringBuffer.append(TEXT_49);
    stringBuffer.append(genPackage.getNSURI());
    stringBuffer.append(TEXT_50);
    }
    if (genPackage.isXMIResource()) {
    stringBuffer.append(TEXT_51);
    }
    stringBuffer.append(TEXT_52);
    } else if (genPackage.getResource() != GenResourceKind.NONE_LITERAL) {
    stringBuffer.append(TEXT_53);
    stringBuffer.append(genPackage.getFileExtension());
    stringBuffer.append(TEXT_54);
    stringBuffer.append(genPackage.getQualifiedResourceFactoryClassName());
    stringBuffer.append(TEXT_55);
    }
    }
    }
    stringBuffer.append(TEXT_56);
    stringBuffer.append(TEXT_57);
    return stringBuffer.toString();
  }
}
