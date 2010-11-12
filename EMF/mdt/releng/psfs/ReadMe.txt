This folder contains PSF files that may assist MDT/OCL developers.

The main user-friendly PSF referenced from the MDT/OCL project page
(http://www.eclipse.org/projects/project_summary.php?projectid=modeling.mdt.ocl)
is http://eclipse.org/modeling/mdt/ocl/resources/ocl.psf which is maintained at
/cvsroot/org.eclipse www/modeling/mdt/ocl/resources/ocl.psf.

Here you will find

features.psf
------------

that loads features needed to develop/build/run parser features

parser-tools.psf
----------------

that loads plugins needed to develop/build/run parser features

- lpg.runtime.java
- lpg.generator
- lpg.generator.linux_x86
- lpg.generator.linux_x86_64
- lpg.generator.macosx_x86
- lpg.generator.macosx_x86_64
- lpg.generator.win32_x86

test-tools.psf
--------------

that loads plugins needed to develop/build/run test features
- org.eclipse.test
- org.eclipse.ant.optional.junit
- org.eclipse.uml2.uml.resources

tests.psf
------------

that loads test plugins needed to test developed plugins

www.psf
-------

that loads the doc and web support projects
- org.eclipse.ocl.doc
- org.eclipse.ocl.www
