FROM tomcat
LABEL maintainer="Sakshat"

COPY webapp/target/swe645-spr20-hw3.war /usr/local/tomcat/webapps/

EXPOSE 8080
CMD ["catalina.sh", "run"]