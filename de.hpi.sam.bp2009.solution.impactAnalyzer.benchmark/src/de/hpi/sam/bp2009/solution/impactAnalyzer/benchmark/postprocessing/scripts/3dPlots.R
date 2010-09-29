library(rgl)
require(DAAG)

# select subsets for different ActivationOptions
resultAllOptimizations = result[result$optionId == 0, ]
resultWoDeltaProp = result[result$optionId == 1, ]

attach(resultAllOptimizations)
# create graph / canvas
plot3d(oclId, modelSize, iaEvalAndExecTime, col = "red", size=2)
# add to existing graph
points3d(oclId, modelSize, allInstancesEvalAndExecTime, col = "blue", size=2)
pause()
detach(resultAllOptimizations)

attach(resultWoDeltaProp)
plot3d(oclId, modelSize, iaEvalAndExecTime, col = "red", size=2)
points3d(oclId, modelSize, allInstancesEvalAndExecTime, col = "blue", size=2)
pause()
detach(resultWoDeltaProp)

attach(resultAllOptimizations)
plot3d(oclId, modelSize, noContextObjects, col = "red", size=2)
points3d(oclId, modelSize, noAllInstances, col = "blue", size=2)
pause()
detach(resultAllOptimizations)
