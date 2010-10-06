result = read.table("result.data", header = TRUE)

result$iaEvalAndExecTime = result$executionTime + result$evaluationTimeAfter
result$allInstancesEvalAndExecTime = result$allInstanceEvalTime + result$allInstanceExecTime
result$sloppiness = result$noEqualResultsBeforeAndAfter / result$noContextObjects

attach(result)
# filter out those results where an expression's evaluation resulted in invalid for all instances of the context type
strippedResult = result[noAllInstances != allInstanceNoInvalidEvals, ]
detach(result)

