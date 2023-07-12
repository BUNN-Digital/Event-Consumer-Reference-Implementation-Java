FROM bunndigital/bunn-openjdk:11-temurin-v1.0.1

LABEL author="BUNN"

EXPOSE 8080
EXPOSE 7980

CMD ["-jar", "/opt/report-management/report-api.jar"]

COPY report-api-web/target/report-api-web.jar /opt/report-management/report-api.jar
