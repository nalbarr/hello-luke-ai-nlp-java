PROG=hello.luke.ai.nlp.java.App
CLASSPATH="build/classes/java/main:resources/main/*:build/lib/*"

build:
	gradle build
	gradle copyDeps

clean:
	gradle clean

# https://stanfordnlp.github.io/CoreNLP/memory-time.html
run:
	#CMD="java -cp ${CLASSPATH} ${PROG}"
	#@echo ${CMD}
	#${CMD}
	java -cp ${CLASSPATH} ${PROG}