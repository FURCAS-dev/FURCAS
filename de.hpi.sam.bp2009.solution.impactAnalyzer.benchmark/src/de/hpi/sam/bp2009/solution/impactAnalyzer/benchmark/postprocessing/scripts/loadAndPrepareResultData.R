result = read.table("result.data", header = TRUE)

result$iaEvalAndExecTime = result$executionTime + result$evaluationTimeAfter
result$allInstancesEvalAndExecTime = result$allInstanceEvalTime + result$allInstanceExecTime

attach(result)
strippedResult = result[noAllInstances != allInstanceNoInvalidEvals, ]
detach(result)

