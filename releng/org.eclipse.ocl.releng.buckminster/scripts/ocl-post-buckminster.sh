mv buildroot/buckminster.output/org.eclipse.ocl.build_*-eclipse.feature/site.p2 MDT-OCL.p2.repository
mv buildroot/buckminster.output/org.eclipse.ocl.build_*-eclipse.feature/zips MDT-OCL.downloads

if [ ${MANAGE_JAVADOC} = "true" ]
then
  mkdir MDT-OCL.javadoc
  mv buildroot/buckminster.output/org.eclipse.ocl.releng.buckminster_*-buckminster/javadoc/MDT-OCL-javadoc.zip MDT-OCL.javadoc/MDT-OCL-javadoc.zip
  rm -rf buildroot/buckminster.output/org.eclipse.ocl.releng.buckminster_*-buckminster/javadoc
fi