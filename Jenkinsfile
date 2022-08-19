pipeline{
    agent any
    triggers{
		pollSCM('* * * * *')
	}
    stages{
        stage("Compile the source code")	{
            steps	{
            	bat "mvn compile"
            }
        }
        stage("Test the source code")	{
            steps	{
           		bat "mvn test"
            }
        }
         stage("Code coverage. Limiting the minimum score for lines coverage to 75%")	{
            steps	{
	            bat "mvn jacoco:report"
	            publishHTML	(target:	[
			    		 allowMissing: false,
      alwaysLinkToLastBuild: false,
      keepAll: true,
					reportDir:	'target/site/jacoco',
					reportFiles:	'index.html',
					reportName:	"CodeCoverageReport"
				])
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
    }
}
