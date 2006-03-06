#!/bin/sh
# The current direcotry
currentPath=`echo "$PWD/$0" | sed -e 's/\(.*\)\/.*/\1\//' | sed -e 's/^[^\/]*$//g'`

# The eclipse directory
eclipseDir=$1

# The destination directory
destDir=$currentPath/../references/javadoc

mkdir -p $destDir

# The plugin name
pluginName="org.eclipse.emf.ocl"

# Don't execute if the destination directory has files
#if [ -d "$destDir" ]; then
#	exit
#fi

function groupPackage
{
	plugin=$1
	hasToken=`grep "@plugin@" $currentPath/javadoc.xml.template`
	if [ "x$hasToken" != "x"  ]; then
		srcDir=$currentPath/../../$plugin/src
		if [ -d "$srcDir" ]; then
			packages=`find $srcDir -type f -name '*.java' -exec grep -e '^package .*;' {} \; | sed -e 's/^package *\(.*\);/\1/' | sed -e 's/[ ]*//g' | sort | uniq | xargs | sed -e 's/ /:/g'`
			packages=`echo $packages | sed -e 's/\//\\\\\\//g' | sed -e 's/\./\\\\\./g'`
	
			sed -e "s/\@plugin\@/${packages}/g" $currentPath/javadoc.xml.template > $currentPath/javadoc.xml.template.tmp
		fi
	fi
}

groupPackage $pluginName

# The directory of the emf.ocl plugins in the order they were built 
# Original: pluginDirs=`find $eclipseDir/plugins -name @dot -printf '%T@ %p\n' | sort -n | grep org.eclipse.emf.transaction | cut -f2 -d' ' | sed -e 's/\(\/.*\)\/.*/\1/'`
# New (eclipseDir): pluginDirs=`find $eclipseDir/plugins -name 'org.eclipse.emf.transaction*' -maxdepth 1 -type d -printf '%T@ %p\n' | sort -n | cut -f2 -d' '`
# Finds plugins in the Workspace:
pluginDirs=`find $currentPath/../.. -name "${pluginName}*" -maxdepth 1 -type d -printf '%T@ %p\n' | sort -n | cut -f2 -d' '`

### TODO: missing emf/sdo/xsd plugins (?) in $eclipseDir - need to copy them over or reference source (?)
### so that all classes/packages (and thus @links) can be resolved

# All the jars in the plugins directory
classpath=`find $eclipseDir/plugins -name "*.jar" -printf "%p:"`

# Calculates the packagesets and the calls to copyDocFiles
packagesets=""
copydocfiles=""
for pluginDir in $pluginDirs; do
	pluginDir=`echo $pluginDir | sed -e 's/\/runtime$//g'`
	srcDir=$pluginDir/src
	if [ -d "$srcDir" ]; then
		packagesets=$packagesets"<packageset dir=\"$srcDir\"><exclude name=\"$srcDir/**/doc-files/**\"/></packageset>"
		copydocfiles=$copydocfiles"<copyDocFiles pluginDir=\"$pluginDir\"/>"
	fi
done

# Finds the proper org.eclipse.platform.doc.isv jar
docjar=`find $eclipseDir/plugins/ -name "org.eclipse.platform.doc.isv*.jar" -printf "%f"`

if [ -f $currentPath/javadoc.xml.template ]; then
	true;
else
	cp $currentPath/javadoc.xml.template $currentPath/javadoc.xml.template.tmp;
fi

# Replaces the token @packagesets@ in the template by the actual value
packagesets=`echo $packagesets | sed -e 's/\//\\\\\\//g' | sed -e 's/\./\\\\\./g'`
sed -e "s/\@packagesets\@/${packagesets}/g" $currentPath/javadoc.xml.template.tmp > $currentPath/javadoc.xml.template.tmp2
# Replaces the token @copydocfiles@ in the template by the actual value
copydocfiles=`echo $copydocfiles | sed -e 's/\//\\\\\\//g' | sed -e 's/\./\\\\\./g'`
sed -e "s/\@copydocfiles\@/${copydocfiles}/g" $currentPath/javadoc.xml.template.tmp2 > $currentPath/javadoc.xml.template.tmp
# Replaces the token @docjar@ in the template by the actual value
sed -e "s/\@docjar\@/${docjar}/g" $currentPath/javadoc.xml.template.tmp > $currentPath/javadoc.xml.template.tmp2
# Replaces the token @eclipseDir@ in the template by the actual value
eclipseDirEsc=`echo $eclipseDir | sed -e 's/\//\\\\\//g' | sed -e 's/\./\\\\\./g'`
sed -e "s/\@eclipseDir\@/${eclipseDirEsc}/g" $currentPath/javadoc.xml.template.tmp2 > $currentPath/javadoc.xml

# Executes the ant script
ant -f $currentPath/javadoc.xml \
	-DdestDir="$destDir" \
	-Dclasspath="$classpath" \
	-DeclipseDir="$eclipseDir" \
	-Doverview="$currentPath/overview.html"

# Clean up templates
rm -f $currentPath/javadoc.xml.template.tmp $currentPath/javadoc.xml.template.tmp2 $currentPath/javadoc.xml
