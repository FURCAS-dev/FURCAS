<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  xmlns:ng="http://docbook.org/docbook-ng"
  xmlns:db="http://docbook.org/ns/docbook"
  xmlns:exsl="http://exslt.org/common"
  version="1.0"
  exclude-result-prefixes="exsl db ng">
  
<xsl:import href="chunk.xsl"/>

<!-- ********************************************************************
     $Id: eclipse.xsl,v 1.2 2011/05/29 16:38:06 ewillink Exp $
     ********************************************************************

     This file is part of the XSL DocBook Stylesheet distribution.
     See ../README or http://docbook.sf.net/release/xsl/current/ for
     copyright and other information.

     ******************************************************************** -->

<xsl:template match="/">
  <!-- * Get a title for current doc so that we let the user -->
  <!-- * know what document we are processing at this point. -->
  <xsl:variable name="doc.title">
    <xsl:call-template name="get.doc.title"/>
  </xsl:variable>
  <xsl:choose>
    <!-- Hack! If someone hands us a DocBook V5.x or DocBook NG document,
         toss the namespace and continue.  Use the docbook5 namespaced
         stylesheets for DocBook5 if you don't want to use this feature.-->
    <!-- include extra test for Xalan quirk -->
    <xsl:when test="$exsl.node.set.available != 0
                    and (*/self::ng:* or */self::db:*)">
      <xsl:call-template name="log.message">
        <xsl:with-param name="level">Note</xsl:with-param>
        <xsl:with-param name="source" select="$doc.title"/>
        <xsl:with-param name="context-desc">
          <xsl:text>namesp. cut</xsl:text>
        </xsl:with-param>
        <xsl:with-param name="message">
          <xsl:text>stripped namespace before processing</xsl:text>
        </xsl:with-param>
      </xsl:call-template>
      <xsl:variable name="nons">
        <xsl:apply-templates mode="stripNS"/>
      </xsl:variable>
      <xsl:call-template name="log.message">
        <xsl:with-param name="level">Note</xsl:with-param>
        <xsl:with-param name="source" select="$doc.title"/>
        <xsl:with-param name="context-desc">
          <xsl:text>namesp. cut</xsl:text>
        </xsl:with-param>
        <xsl:with-param name="message">
          <xsl:text>processing stripped document</xsl:text>
        </xsl:with-param>
      </xsl:call-template>
      <xsl:apply-templates select="exsl:node-set($nons)"/>
    </xsl:when>
    <xsl:otherwise>
  <xsl:choose>
    <xsl:when test="$rootid != ''">
      <xsl:choose>
        <xsl:when test="count(key('id',$rootid)) = 0">
          <xsl:message terminate="yes">
            <xsl:text>ID '</xsl:text>
            <xsl:value-of select="$rootid"/>
            <xsl:text>' not found in document.</xsl:text>
          </xsl:message>
        </xsl:when>
        <xsl:otherwise>
          <xsl:if test="$collect.xref.targets = 'yes' or
                        $collect.xref.targets = 'only'">
            <xsl:apply-templates select="key('id', $rootid)"
                        mode="collect.targets"/>
          </xsl:if>
          <xsl:if test="$collect.xref.targets != 'only'">
            <xsl:message>Formatting from <xsl:value-of 
	                          select="$rootid"/></xsl:message>
            <xsl:apply-templates select="key('id',$rootid)"
                        mode="process.root"/>
            <xsl:call-template name="etoc"/>
            <!-- <xsl:call-template name="plugin.xml"/> -->
			<xsl:call-template name="helpidx"/>
          </xsl:if>
        </xsl:otherwise>
      </xsl:choose>
    </xsl:when>
    <xsl:otherwise>
      <xsl:if test="$collect.xref.targets = 'yes' or
                    $collect.xref.targets = 'only'">
        <xsl:apply-templates select="/" mode="collect.targets"/>
      </xsl:if>
      <xsl:if test="$collect.xref.targets != 'only'">
        <xsl:apply-templates select="/" mode="process.root"/>
        <xsl:call-template name="etoc"/>
        <!-- <xsl:call-template name="plugin.xml"/> -->
		<xsl:call-template name="helpidx"/>
      </xsl:if>
    </xsl:otherwise>
  </xsl:choose>
</xsl:otherwise>
</xsl:choose>
</xsl:template>

<xsl:template name="etoc">
  <xsl:call-template name="write.chunk">
    <xsl:with-param name="filename">
      <xsl:if test="$manifest.in.base.dir != 0">
        <xsl:value-of select="$base.dir"/>
      </xsl:if>
      <xsl:value-of select="'toc.xml'"/>
    </xsl:with-param>
    <xsl:with-param name="method" select="'xml'"/>
    <xsl:with-param name="encoding" select="'utf-8'"/>
    <xsl:with-param name="indent" select="'yes'"/>
    <xsl:with-param name="quiet" select="$chunk.quietly"/>
    <xsl:with-param name="content">
      <xsl:choose>

        <xsl:when test="$rootid != ''">
          <xsl:variable name="title">
            <xsl:if test="$eclipse.autolabel=1">
              <xsl:variable name="label.markup">
                <xsl:apply-templates select="key('id',$rootid)" mode="label.markup"/>
              </xsl:variable>
              <xsl:if test="normalize-space($label.markup)">
                <xsl:value-of select="concat($label.markup,$autotoc.label.separator)"/>
              </xsl:if>
            </xsl:if>
            <xsl:apply-templates select="key('id',$rootid)" mode="title.markup"/>
          </xsl:variable>
          <xsl:variable name="href">
            <xsl:call-template name="href.target.with.base.dir">
              <xsl:with-param name="object" select="key('id',$rootid)"/>
            </xsl:call-template>
          </xsl:variable>
          
          <toc label="{normalize-space($title)}" topic="{$href}">
            <xsl:apply-templates select="key('id',$rootid)/*" mode="etoc"/>
          </toc>
        </xsl:when>

        <xsl:otherwise>
          <xsl:variable name="title">
            <xsl:if test="$eclipse.autolabel=1">
              <xsl:variable name="label.markup">
                <xsl:apply-templates select="/*" mode="label.markup"/>
              </xsl:variable>
              <xsl:if test="normalize-space($label.markup)">
                <xsl:value-of select="concat($label.markup,$autotoc.label.separator)"/>
              </xsl:if>
            </xsl:if>
            <xsl:apply-templates select="/*" mode="title.markup"/>
          </xsl:variable>
          <xsl:variable name="href">
            <xsl:call-template name="href.target.with.base.dir">
              <xsl:with-param name="object" select="/"/>
            </xsl:call-template>
          </xsl:variable>
          
          <toc label="{normalize-space($title)}" topic="{$href}">
            <xsl:apply-templates select="/*/*" mode="etoc"/>
          </toc>
        </xsl:otherwise>

      </xsl:choose>
    </xsl:with-param>
  </xsl:call-template>
</xsl:template>

<xsl:template match="book|part|reference|preface|chapter|bibliography|appendix|article|glossary|section|sect1|sect2|sect3|sect4|sect5|refentry|colophon|bibliodiv|index" mode="etoc">
  <xsl:variable name="title">
    <xsl:if test="$eclipse.autolabel=1">
      <xsl:variable name="label.markup">
        <xsl:apply-templates select="." mode="label.markup"/>
      </xsl:variable>
      <xsl:if test="normalize-space($label.markup)">
        <xsl:value-of select="concat($label.markup,$autotoc.label.separator)"/>
      </xsl:if>
    </xsl:if>
    <xsl:apply-templates select="." mode="title.markup"/>
  </xsl:variable>

  <xsl:variable name="href">
    <xsl:call-template name="href.target.with.base.dir">
      <xsl:with-param name="context" select="/"/>        <!-- Generate links relative to the location of root file/toc.xml file -->
    </xsl:call-template>
  </xsl:variable>
  <xsl:variable name="label">
    <xsl:call-template name="normalize-xml">
        <xsl:with-param name="original" select="$title"/>
    </xsl:call-template>
  </xsl:variable>

  <topic label="{normalize-space($label)}" href="{$href}">
    <xsl:apply-templates select="part|reference|preface|chapter|bibliography|appendix|article|glossary|section|sect1|sect2|sect3|sect4|sect5|refentry|colophon|bibliodiv|index" mode="etoc"/>
  </topic>

</xsl:template>

<xsl:template match="text()" mode="etoc"/>

<!--
<xsl:template name="plugin.xml">
  <xsl:call-template name="write.chunk">
    <xsl:with-param name="filename">
      <xsl:if test="$manifest.in.base.dir != 0">
        <xsl:value-of select="$base.dir"/>
      </xsl:if>
      <xsl:value-of select="'plugin.xml'"/>
    </xsl:with-param>
    <xsl:with-param name="method" select="'xml'"/>
    <xsl:with-param name="encoding" select="'utf-8'"/>
    <xsl:with-param name="indent" select="'yes'"/>
    <xsl:with-param name="quiet" select="$chunk.quietly"/>
    <xsl:with-param name="content">
      <plugin name="{$eclipse.plugin.name}"
        id="{$eclipse.plugin.id}"
        version="1.0"
        provider-name="{$eclipse.plugin.provider}">

		  <extension point="org.eclipse.help.toc">
			<toc file="toc.xml" primary="true"/>
		  </extension>
		  <extension point="org.eclipse.help.index">
			<index file="index.xml"/>
		  </extension>
      </plugin>
    </xsl:with-param>
  </xsl:call-template>
</xsl:template>
-->

<!-- ==================================================================== -->
<!-- The following templates come from the javahelp xsls with modifications needed to make them generate and ecilpse index.xml file -->

<xsl:template name="helpidx">
  <xsl:call-template name="write.chunk.with.doctype">
    <xsl:with-param name="filename" select="concat($base.dir, 'index.xml')"/>
    <xsl:with-param name="method" select="'xml'"/>
    <xsl:with-param name="indent" select="'yes'"/>
    <xsl:with-param name="doctype-public" select="''"/>
    <xsl:with-param name="doctype-system" select="''"/>
    <xsl:with-param name="encoding" select="'utf-8'"/>
    <xsl:with-param name="quiet" select="$chunk.quietly"/>
    <xsl:with-param name="content">
      <xsl:call-template name="helpidx.content"/>
    </xsl:with-param>
  </xsl:call-template>
</xsl:template>

  <xsl:template name="helpidx.content">
	<index>
	  <xsl:choose>
		<xsl:when test="$rootid != ''">
		  <xsl:apply-templates select="key('id',$rootid)//indexterm" mode="idx">
			<xsl:sort select="normalize-space(concat(primary/@sortas, primary[not(@sortas) or @sortas = '']))"/>
			<xsl:sort select="normalize-space(concat(secondary/@sortas, secondary[not(@sortas) or @sortas = '']))"/>
			<xsl:sort select="normalize-space(concat(tertiary/@sortas, tertiary[not(@sortas) or @sortas = '']))"/>
		  </xsl:apply-templates>
		</xsl:when>
		<xsl:otherwise>
		  <xsl:apply-templates select="//indexterm" mode="idx">
			<xsl:sort select="normalize-space(concat(primary/@sortas, primary[not(@sortas) or @sortas = '']))"/>
			<xsl:sort select="normalize-space(concat(secondary/@sortas, secondary[not(@sortas) or @sortas = '']))"/>
			<xsl:sort select="normalize-space(concat(tertiary/@sortas, tertiary[not(@sortas) or @sortas = '']))"/>
		  </xsl:apply-templates>
		</xsl:otherwise>
	  </xsl:choose>
	</index>
  </xsl:template>
  
  <xsl:template match="indexterm[@class='endofrange']" mode="idx"/>
  
  <xsl:template match="indexterm|primary|secondary|tertiary" mode="idx">

	<xsl:variable name="href">
	  <xsl:call-template name="href.target.with.base.dir">
		<xsl:with-param name="context" select="/"/>        <!-- Generate links relative to the location of root file/toc.xml file -->
	  </xsl:call-template>
	</xsl:variable>

	<xsl:variable name="text">
	  <xsl:value-of select="normalize-space(.)"/>
	  <xsl:if test="following-sibling::*[1][self::see]">
		<xsl:text> (</xsl:text><xsl:call-template name="gentext">
		  <xsl:with-param name="key" select="'see'"/>
		</xsl:call-template><xsl:text> </xsl:text>
		<xsl:value-of select="following-sibling::*[1][self::see]"/>)</xsl:if>
	</xsl:variable>
	
	<xsl:choose>
	  <xsl:when test="self::indexterm">
		<xsl:apply-templates select="primary" mode="idx"/>
	  </xsl:when>
	  <xsl:when test="self::primary">
		<entry keyword="{$text}">
		  <topic href="{$href}"/>
		  <xsl:apply-templates select="following-sibling::secondary"  mode="idx"/>
		</entry>
	  </xsl:when>
	  <xsl:otherwise>
		<entry keyword="{$text}">
		  <topic href="{$href}"/>
		  <xsl:apply-templates select="following-sibling::tertiary"  mode="idx"/>
		</entry>
	  </xsl:otherwise>
	</xsl:choose>
  </xsl:template>

<xsl:template name="normalize-xml">
<xsl:param name="original"/>
<xsl:choose>
    <xsl:when test="contains($original, '&lt;')">
        <xsl:value-of select="substring-before($original, '&lt;')"/>
        <xsl:copy-of select="'_lt_'"/>
        <xsl:call-template name="normalize-xml">
            <xsl:with-param name="original" select="substring-after($original, '&lt;')"/>
        </xsl:call-template>
    </xsl:when>
    <xsl:otherwise>
		<xsl:choose>
		    <xsl:when test="contains($original, '&gt;')">
		        <xsl:value-of select="substring-before($original, '&gt;')"/>
		        <xsl:copy-of select="'_gt_'"/>
		        <xsl:call-template name="normalize-xml">
		            <xsl:with-param name="original" select="substring-after($original, '&gt;')"/>
		        </xsl:call-template>
		    </xsl:when>
		    <xsl:otherwise>
				<xsl:choose>
				    <xsl:when test='contains($original, "&apos;")'>
				        <xsl:value-of select='substring-before($original, "&apos;")'/>
				        <xsl:copy-of select="'_apos_'"/>
				        <xsl:call-template name="normalize-xml">
				            <xsl:with-param name="original" select='substring-after($original, "&apos;")'/>
				        </xsl:call-template>
				    </xsl:when>
				    <xsl:otherwise>
						<xsl:choose>
						    <xsl:when test="contains($original, '&quot;')">
						        <xsl:value-of select="substring-before($original, '&quot;')"/>
						        <xsl:copy-of select="'_quot_'"/>
						        <xsl:call-template name="normalize-xml">
						            <xsl:with-param name="original" select="substring-after($original, '&quot;')"/>
						        </xsl:call-template>
						    </xsl:when>
						    <xsl:otherwise>
						        <xsl:value-of select="$original"/>
						    </xsl:otherwise>
						</xsl:choose>
				    </xsl:otherwise>
				</xsl:choose>
		    </xsl:otherwise>
		</xsl:choose>
    </xsl:otherwise>
</xsl:choose>
</xsl:template>

  <!-- ==================================================================== -->

</xsl:stylesheet>
