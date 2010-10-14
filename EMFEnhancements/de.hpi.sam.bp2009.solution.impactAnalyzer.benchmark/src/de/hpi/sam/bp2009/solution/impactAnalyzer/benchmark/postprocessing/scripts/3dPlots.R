library(rgl)
require(DAAG)

zlabEvalTime = "Evaluation time (total) in nanoseconds"

for(i in unique(result$optionId)){
        # select subsets for different ActivationOptions
        resultOptimizations = result[result$optionId == i, ]

        attach(resultOptimizations)
        # create graph / canvas
        plot3d(oclId, modelSize, iaEvalAndExecTime, col = "red", size=2, xlab = "Different OCL Expressions", ylab = "Number of Model Elements", zlab = zlabEvalTime)

        # add to existing graph
        points3d(oclId, modelSize, allInstancesEvalAndExecTime, col = "blue", size=2)
        pause()
        detach(resultOptimizations)
}

attach(resultOptimizations)
plot3d(oclId, modelSize, noContextObjects, col = "red", size=2, xlab = "Different OCL Expressions", ylab = "Number of Model Elements", zlab = "Number of Context Objects")
points3d(oclId, modelSize, noAllInstances, col = "blue", size=2)
pause()
detach(resultOptimizations)
