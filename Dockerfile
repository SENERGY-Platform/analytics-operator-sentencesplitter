FROM maven:3.5-jdk-8-onbuild-alpine
CMD ["java","-jar","/usr/src/app/target/operator-sentencesplitter-jar-with-dependencies.jar"]
