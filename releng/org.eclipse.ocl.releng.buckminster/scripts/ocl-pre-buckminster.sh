#!/bin/bash

#wget http://download.eclipse.org/releases/helios/compositeContent.jar

rm -rf buildroot MDT-OCL.*
mkdir buildroot
:
COMPACT_BUILD_ID="${BUILD_ID//[-_]}"
COMPACT_BUILD_ID="${COMPACT_BUILD_ID:0:12}"
:
{
	cat "${WORKSPACE}/org.eclipse.mdt/org.eclipse.ocl/releng/org.eclipse.ocl.releng.buckminster/releng/ocl-build.properties"

	echo
	echo "# Define the Build Type (added by Hudson job definition)"
	echo "build.type=${BUILD_TYPE}"

	echo
	echo "# Define the Build ID (added by Hudson job definition)"
	echo "build.id=${BUILD_TYPE}${COMPACT_BUILD_ID}"

	echo
	echo "# Define the timestamp to use for changed components (added by Hudson job definition)"
	echo "buckminster.build.timestamp=${BUILD_ID}"

	echo
	echo "# Define the Build Alias (added by Hudson job definition)"
	echo "build.alias=${BUILD_ALIAS}"

	echo
	echo "# Define Hudson Build ID (added by Hudson job definition)"
	echo "hudson.build.id=${BUILD_ID}"

	echo
	echo "# Define if Huson Build should create javadoc (added by Hudson job definition)"
	echo "manage.javadoc=${MANAGE_JAVADOC}"

	echo
	echo "# Override default locations (added by Hudson job definition)"
	echo "buckminster.output.root=${WORKSPACE}/buildroot/buckminster.output"
	echo "buckminster.temp.root=${WORKSPACE}/buildroot/buckminster.temp"
	echo "eclipse.staging.area=/shared/download-staging.priv/modeling/mdt/ocl"

	echo
	echo "# Sign the jars (added by Hudson job definition)"
	echo "site.signing=${SITE_SIGNING}"

	echo
	echo "# Eclipse local download area (added by Hudson job definition"
        echo "eclipse.download=file:/home/data/httpd/download.eclipse.org"
	echo
	echo "# Required Properties for Publishing (added by Hudson job definition)"
	echo "packages.base=MDT-OCL.downloads"
        echo "tests.base=MDT-OCL.test.results"
        echo "javadoc.base=MDT-OCL.javadoc"
        echo "version=3.1.0"
	echo "downloads.area=/home/data/httpd/download.eclipse.org/modeling/mdt/ocl"


} > buildroot/build.properties
:
{
	echo "# Define the Build ID to use for tagging (added by Hudson job definition)"
	echo "build.id=${COMPACT_BUILD_ID}"

} > buildroot/tagging.properties
: