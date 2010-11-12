#!/bin/bash

# This script runs as https://build.eclipse.org/hudson/job/cbi-*/configure
# and is archived (for example) in http://dev.eclipse.org/viewcvs/index.cgi/org.eclipse.dash/athena/org.eclipse.dash.commonbuilder/org.eclipse.dash.common.releng/hudson/run.sh?root=Technology_Project
# Build runs under ${WORKSPACE} == /opt/users/hudsonbuild/.hudson/jobs/cbi-*/workspace

echo "[`date +%Y/%m/%d\ %H:%M`] Hudson job ${JOBNAME} build #${BUILD_NUMBER} (${BUILD_ID}) started." 

##############################################################################################

# BEGIN CONFIGURATION

buildTimestamp="`date +%Y%m%d%H%M`"

# where should we look for pre-checked out project sources for org.eclipse.dash.common.releng and org.eclipse.releng.basebuilder ?
cvsProjectBaseDir=/opt/public/cbi/build # build.eclipse.org
if [[ ! -d $cvsProjectBaseDir ]]; then cvsProjectBaseDir=/home/builduser/workspace; fi # local build? 
if [[ ! -d $cvsProjectBaseDir ]]; then 
	echo "ERROR: cannot find where org.eclipse.dash.common.releng and org.eclipse.releng.basebuilder are on disk. Must exit!"
	exit 1;
fi 

# need a place to store existing 3rd party jars, eg., ant-contrib.jar (if not in /usr/share/java/)
thirdPartyJarsDir=/opt/public/cbi/build/3rdPartyJars # build.eclipse.org
if [[ ! -d $thirdPartyJarsDir ]]; then thirdPartyJarsDir=/tmp/build/3rdPartyJars; fi # local build 
if [[ ! -d $thirdPartyJarsDir ]]; then mkdir $thirdPartyJarsDir; fi 

# DONE CONFIGURATION

##############################################################################################

# exposed as a Hudson build parameter for convenience
if [[ $BUILDTYPE ]]; then
	buildType="$BUILDTYPE"
else
	buildType="N"
fi

##############################################################################################

# collect required variables 
# could also set them here as variable="some value" static variables, or use 
# export VARIABLE="some value" in Hudson script for convenience when copying/editing jobs

# if NOT hardcoded here, then this script is COMPLETELY boilerplate and need not be copied into the build's .releng folder.

haderror=0
if [[ $PROJECTID ]]; then 
	projectid="$PROJECTID" 
else
	echo "Error: Must set projectid in run.sh or PROJECTID in Hudson config." 
	haderror=1
fi

if [[ $VERSION ]]; then 
	version="$VERSION"
else
	echo "Error: Must set version in run.sh or VERSION in Hudson config." 
	haderror=1
fi

if [[ $PROJRELENGROOT ]]; then
	projRelengRoot="$PROJRELENGROOT"
else
	echo "Error: Must set projRelengRoot in run.sh or PROJRELENGROOT in Hudson config." 
	haderror=1
fi

if [[ $PROJRELENGPATH ]]; then
	projRelengPath="$PROJRELENGPATH"
else
	echo "Error: Must set projRelengPath in run.sh or PROJRELENGPATH in Hudson config." 
	haderror=1
fi

# optional override; assume HEAD or trunk if not specified
if [[ $PROJRELENGBRANCH ]]; then
	projRelengBranch="$PROJRELENGBRANCH"
else
	projRelengBranch="";
fi

if [[ $haderror -gt 0 ]]; then
	exit 1;
fi

# pass in additional flags like -buildAlias=1.0.0RC2 using the $EXTRAFLAGS Hudson parameter
# buildAlias will rename zips from foo-SDK-N200901011234.zip to foo-SDK-1.0.0RC2.zip

##############################################################################################

# define where to do all the work; start with a fresh folder each time
writableBuildRoot="/home/data/httpd/download-staging.priv/modeling/mdt/ocl"
if [[ -d ${writableBuildRoot} ]]; then rm -fr ${writableBuildRoot}; fi

# define required folders
downloadsDir="${writableBuildRoot}/downloads"
signingDir="${writableBuildRoot}/signing"
#signingDir=/home/data/httpd/download-staging.priv/modeling/mdt/ocl

# long form (default if omitted)
#   buildDir="${writableBuildRoot}/${projectid//.//}/downloads/drops/${version}/${buildType}${buildTimestamp}"
# short form (non-default)
if [[ $SNAPSHOT ]]; then # build in a path that will always be the same (so downstream projects can depend on Update zip)
  buildDir="${writableBuildRoot}/${buildType}-SNAPSHOT"
  EXTRAFLAGS="-buildAlias ${buildType}-SNAPSHOT ${EXTRAFLAGS}"
else
  buildDir="${writableBuildRoot}/${buildType}${buildTimestamp}"
fi

# create required folders & files (as symlinks is possible)
mkdir -p ${downloadsDir} ${signingDir} ${buildDir}

# create .cvspass file to shut up unnecessary warnings
touch ${writableBuildRoot}/.cvspass

#define symlinked required folders
relengBaseBuilderDir="${writableBuildRoot}/org.eclipse.releng.basebuilder"
relengCommonBuilderDir="${writableBuildRoot}/org.eclipse.dash.common.releng"
# symlink basebuilder and common.releng; alternatively, if you omit this, they'll be checked out in start.sh
ln -s ${cvsProjectBaseDir}/org.eclipse.releng.basebuilder ${writableBuildRoot}/
ln -s ${cvsProjectBaseDir}/org.eclipse.dash.common.releng ${writableBuildRoot}/

# symlink 3rdPartyJars (reuse existing content on build.eclipse.org for ant-contrib.jar, etc.)
ln -s ${thirdPartyJarsDir} ${writableBuildRoot}/
thirdPartyJarsDir="${writableBuildRoot}/3rdPartyJars"

# clean up any *-SNAPSHOT.zip files in ${downloadsDir}
find ${downloadsDir} -maxdepth 1 -type f -name "*-SNAPSHOT.zip" -exec rm -f {} \;

# run a build - may have to pass in "-javaHome /usr/lib/jvm/java" or similar here if default JVM not found
cd ${writableBuildRoot}/org.eclipse.dash.common.releng/tools/scripts
./start.sh -projectid ${projectid} -version ${version} -buildType ${buildType} -buildTimestamp ${buildTimestamp} \
  -writableBuildRoot ${writableBuildRoot} -thirdPartyJarsDir ${thirdPartyJarsDir} -downloadsDir ${downloadsDir} -buildDir ${buildDir} \
  ${projRelengRoot} ${projRelengPath} ${projRelengBranch} ${EXTRAFLAGS} 2>&1

# remove file so workspace navigation is one click simpler
rm -f ${writableBuildRoot}/.cvspass

echo "[`date +%Y/%m/%d\ %H:%M`] Hudson job ${JOBNAME} build #${BUILD_NUMBER} (${BUILD_ID}) done." 
