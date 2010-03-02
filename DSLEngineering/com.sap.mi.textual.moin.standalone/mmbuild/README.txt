This directory should contain a bunch of .zip files that contain metamodels.
The .zip files are automatically updated when standalone tests are executed.
However, a manual refresh is necessary after the first test execution after
a metamodel change so that the Eclipse workspace learns about the update.
This may mean that your standalone tests will fail upon the first execution
because the Eclipse refresh hasn't happened yet. 