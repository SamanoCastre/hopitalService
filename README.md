# Title of the project #
Hopital Service

# Description of the project
Hospital service is the microservice that manages the search for hospitals based on incident location and specialty.

Note 1 : the settings for this microservice are centralized in the configuration microservice. therefore, the config-service must be fully operational in order to serve configuration parameters to every microservice.

Note 2 : hopital-service needs to register with the eureka registration service (registre-service). Therefore, the registre-service must be fully operational in order for other microservices to be registred.

Note 3 : All access to hopital-service must be done via the API gateway (Gateway-service). Therefore, the gateway-service must be fully operational.

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
3. Mongodb 6.0.0

#External API used
GoogleMatrix API (provide a valid API KEY "see cloudConfig repo")  : to calculate the distance


#Data Storage
The data are stored in a mongodb database called "medhead_bdd" in 3 collections (Hopital, Specialite y disponibilite)

##Creating database
1. Download and install mongodb compas
2. create a new database with the name "medhead_bdd"
3. Import the CSV files located under the subfolder "resource/mongodb". there are all the collections of the database.

Collections name : 
a. Hopital
b. Specialite
c. Disponibilite

#Tests
1. Unit Tests
2. Integration Tests
4. Acceptance Tests
3. Command line : mvn test (see the project's jenkinsfile)

##CI-CD
1. See the project's configuration jenkinsfile

##Tests Report
1. Use Jacoco
2. Command line : mvn test jacoco:report (see project's jenkinsfile)

#Build
command line : mvn clean install (see jenkinsfile)

#Packaging the application
command line : mvn clean package -DskipTests (see the project's jenkins file)

#Deploy
command line : mvn spring-boot:run

