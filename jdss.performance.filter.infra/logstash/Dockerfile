## ==============================================
## BUILDER DOCKERFILE
## ==============================================

FROM docker.elastic.co/logstash/logstash:7.2.0

LABEL MAINTAINER= "Javier Santos (javier.david.santos@gmail.com)" \


#Add the configuration file
Add logstash.conf /usr/share/logstash/pipeline/

# Prepare dirs
RUN mkdir -p performance-logs


