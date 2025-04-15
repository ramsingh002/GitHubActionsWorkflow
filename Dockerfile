FROM eclipse-temurin:21-jdk-alpine

LABEL mentainer="rsalliswell@gmail.com"

WORKDIR /app

COPY target/GitHubActionsWorkflow.jar /app/java-spring-github-actions-workflow.jar

ENTRYPOINT ["java", "-jar", "java-spring-github-actions-workflow.jar"]