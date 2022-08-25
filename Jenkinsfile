pipeline{
    agent any
    triggers{
		pollSCM('* * * * *')
    }
    stages{
        stage("Compile the source code")	{
            steps {
	 	bat "mvn compile"
            }
        } 
        stage("Test the source code")	{
            steps {
           	bat "mvn test"
            }
        }
         stage("Code coverage")	{
            steps {
	            bat "mvn jacoco:report"
	            publishHTML	(target:	[
					reportDir:	'target/site/jacoco',
					reportFiles:	'index.html',
					reportName:	"CodeCoverageReport"
				])
	            bat "mvn clean verify"
            }
        }
		stage("Package the application")	{
            steps	{
            	bat "mvn clean package -DskipTests"
            }
        }
	
		stage("Deploy to the staging")	{
		    steps	{
			    bat "mvn spring-boot:run"
			}
		}
		stage ('JMeter Performance') {
		    dir('C:/Users/castr/apache-jmeter-5.5\bin') {
			bat "jmeter -Jjmeter.save.saveservice.output_format=xml
			  -n -t src/main/resources/JMeter.jmx 
			    -l src/main/resources/JMeter.jtl"
			step([$class: 'ArtifactArchiver', artifacts: 'JMeter.jtl'])
			bat "pid=\$(lsof -i:8989 -t); kill -TERM \$pid || kill -KILL \$pid"
		    }
	    }
    }
}
