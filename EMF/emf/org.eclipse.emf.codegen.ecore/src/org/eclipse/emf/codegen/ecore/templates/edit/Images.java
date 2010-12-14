package org.eclipse.emf.codegen.ecore.templates.edit;

import java.util.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;

public class Images
{
  protected static String nl;
  public static synchronized Images create(String lineSeparator)
  {
    nl = lineSeparator;
    Images result = new Images();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "/**";
  protected final String TEXT_3 = NL + " * ";
  protected final String TEXT_4 = NL + " * <copyright>" + NL + " * </copyright>" + NL + " *" + NL + " * ";
  protected final String TEXT_5 = "Id";
  protected final String TEXT_6 = NL + " */" + NL + "package ";
  protected final String TEXT_7 = ";" + NL;
  protected final String TEXT_8 = NL + NL + "/**" + NL + " * <!-- begin-user-doc -->" + NL + " * <!-- end-user-doc -->" + NL + " * @generated" + NL + " */" + NL + "public interface ";
  protected final String TEXT_9 = "Images extends ";
  protected final String TEXT_10 = NL + "{";
  protected final String TEXT_11 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\t@Source(\"";
  protected final String TEXT_12 = "\")" + NL + "\t";
  protected final String TEXT_13 = " ";
  protected final String TEXT_14 = "();" + NL;
  protected final String TEXT_15 = NL + "}";
  protected final String TEXT_16 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
/**
 * <copyright>
 *
 * Copyright (c) 2010 Ed Merks and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Ed Merks - Initial API and implementation
 *
 * </copyright>
 */

    GenModel genModel = (GenModel)argument; /* Trick to import java.util.* without warnings */Iterator.class.getName();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    {GenBase copyrightHolder = argument instanceof GenBase ? (GenBase)argument : argument instanceof Object[] && ((Object[])argument)[0] instanceof GenBase ? (GenBase)((Object[])argument)[0] : null;
    if (copyrightHolder != null && copyrightHolder.hasCopyright()) {
    stringBuffer.append(TEXT_3);
    stringBuffer.append(copyrightHolder.getCopyright(copyrightHolder.getGenModel().getIndentation(stringBuffer)));
    } else {
    stringBuffer.append(TEXT_4);
    stringBuffer.append("$");
    stringBuffer.append(TEXT_5);
    stringBuffer.append("$");
    }}
    stringBuffer.append(TEXT_6);
    stringBuffer.append(genModel.getEditPluginPackageName());
    stringBuffer.append(TEXT_7);
    genModel.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(genModel.getEditPluginClassName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(genModel.getImportedName("com.google.gwt.resources.client.ClientBundle"));
    stringBuffer.append(TEXT_10);
    for (GenPackage genPackage : genModel.getAllGenAndUsedGenPackagesWithClassifiers()) {
    for (GenClass genClass : genPackage.getGenClasses()) {
    if (genClass.isImage()) { String image = genClass.getItemIconFileName(); image = image.substring(image.lastIndexOf("/icons/") + 1); 
    stringBuffer.append(TEXT_11);
    stringBuffer.append(image);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(genModel.getImportedName("com.google.gwt.resources.client.ImageResource"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_14);
    }
    }
    }
    stringBuffer.append(TEXT_15);
    genModel.emitSortedImports();
    stringBuffer.append(TEXT_16);
    return stringBuffer.toString();
  }
}
