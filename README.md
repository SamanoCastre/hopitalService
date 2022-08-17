# Title of the project #
Hopital Service

# Description of the project
Hospital service is the microservice that manages the search for hospitals based on incident location and specialty.

Note 1 : the settings for this microservice are centralized in the configuration microservice. therefore, the latter must be fully operational in order to serve it its configuration parameters.

Note 2 : This microservice needs to register with the eureka registration service (registry-service). Therefore, the latter must be fully operational in order for it to register with it.

Note 3 : All access to this microservice must be done via the API gateway (Gateway-service). Therefore, the latter must be fully operational.

#Fonctionalities
1. Rechercher d'hopital à proximité

#Endpoints
1. GET:/hopital: allows you to search for the hospital
2. GET:/specialites: retrieves the list of known specialties
3. GET:/disponibilite: retrieves availability (beds) for a hospital/speciality couple
4. PUT:/disponibilite/decrementer: increases the number of beds for the hospital/specialty couple when a reservation has been made
5. PUT:/disponibilite/incrementer: used to decrease the number of beds in a hospital/specialty pair when a bed is freed up

#Requirements
1. Java 17
2. Maven 3.8.6

#External API used
GoogleMatrix API (provid a valid API KEY "see cloudConfig repo")  : to calculate the distance

#Dependencies
1. spring-boot-starter-data-mongodb
2. spring-boot-starter-log4j2
3. spring-cloud-starter-netflix-eureka-client
4. google-maps-services
5. spring-boot-starter-test
6. spring-cloud-starter-openfeign

#Data Storage
1. hospital, specialty and availability data are stored in a mongodb database (3 collections). See subfolder: resources/mongodb
2. Note : To update database configuration, got to the repo cloudConfig (https://github.com/SamanoCastre/cloudConfig)

#Tests
1. Unit Tests
2. Integration Tests
4. Acceptance Tests
3. Command line : mvn test (see the project's jenkinsfile)

##Automated tests 
1. using the jenkins tool (see the project's jenkinsfile)

##Tests Report
1. Use Jacoco
2. Command line : mvn jacoco:report (see project's jenkinsfile)

#Build
command line : mvn clean install (see jenkinsfile)

#Packaging the application
command line : mvn clean package -DskipTests (see the project's jenkins file)

#Deploy
command line : mvn spring-boot:run



