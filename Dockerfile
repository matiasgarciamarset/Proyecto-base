FROM maven

MAINTAINER Matias Garcia Marset

RUN mkdir /project \
	&&  cd /project \
	&&  git clone https://github.com/matiasgarciamarset/Proyecto-base.git \
	&& cd Test

WORKDIR /project/Test

EXPOSE 8080
CMD ["mvn", "tomcat7:run"]
