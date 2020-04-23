OPENNLP_MODEL_FILE=en-token.bin
PROG=hello.luke.ai.nlp.java.App
CLASSPATH_ROOT=build/classes/java/main
CLASSPATH="build/classes/java/main:resources/main/*:build/lib/*"

clean:
	gradle clean

dependencies:
	gradle dependencies

build:
	gradle build

copy_files:
	gradle copyDeps
	cp ${OPENNLP_MODEL_FILE} ${CLASSPATH_ROOT}

# NAA.  Alternative to gradle run to debug dependencies.
# - https://stanfordnlp.github.io/CoreNLP/memory-time.html
#run: copy_files
run:
	gradle run

	#CMD="java -cp ${CLASSPATH} ${PROG}"
	#@echo ${CMD}
	#${CMD}
	#java -cp ${CLASSPATH} ${PROG}
