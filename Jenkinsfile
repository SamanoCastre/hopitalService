pipeline{
    agent any
    triggers{
		pollSCM('* * * * *')
    }
    stages{
        
	    def autoCancelled = false

try {
  stage('checkout preconditions') {
    if (continueBuild == false) {
      autoCancelled = true
      return
    }
  }
  if (autoCancelled) {
    error('Aborting the build to prevent a loop.')
    //return would be also possible but you have to be sure to quit all stages and wrapper properly
    //return
  }
} catch (e) {
  if (autoCancelled) {
    currentBuild.result = 'ABORTED'
    echo('Skipping mail notification')
    //return here instead of throwing error to keep the build "green"
    return
  }
  //normal error handling
  throw e
}
    
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
    }
}
