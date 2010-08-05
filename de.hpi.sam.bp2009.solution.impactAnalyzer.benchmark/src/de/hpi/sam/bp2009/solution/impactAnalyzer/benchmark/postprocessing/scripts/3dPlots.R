library(rgl)
require(DAAG)

result = read.table("~/Dropbox/fullResult8.data", header = TRUE)

result$iaEvalAndExecTime = result$executionTime + result$evaluationTimeAfter
result$allInstancesEvalAndExecTime = result$allInstanceEvalTime + result$allInstanceExecTime

result = result[result$noAllInstances != result$allInstanceNoInvalidEvals, ]

resultAllOptimizations = result[result$optionId == 0, ]
resultWoDeltaProp = result[result$optionId == 1, ]

attach(resultAllOptimizations)
plot3d(oclId, modelSize, iaEvalAndExecTime, col = "red", size=2)
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
