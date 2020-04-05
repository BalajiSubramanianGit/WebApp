
node {
    // Get Artifactory server instance, defined in the Artifactory Plugin administration page.
    def server = Artifactory.server "Artifactory"
    // Create an Artifactory Maven instance.
    def rtMaven = Artifactory.newMavenBuild()
    def buildInfo
    
 rtMaven.tool = "maven"

    stage('Clone sources') {
	    echo 'echo Clone sources...'
        git url: 'https://github.com/BalajiSubramanianGit/WebApp.git'
    }

    stage('Artifactory configuration') {
	     echo 'echo Artifactory configuration...'
        // Tool name from Jenkins configuration
        rtMaven.tool = "maven"
        // Set Artifactory repositories for dependencies resolution and artifacts deployment.
        rtMaven.deployer releaseRepo:'libs-release-local', snapshotRepo:'libs-snapshot-local', server: server
        rtMaven.resolver releaseRepo:'libs-release', snapshotRepo:'libs-snapshot', server: server
    }

    stage('Maven build') {
	    echo 'echo Maven build...'
        buildInfo = rtMaven.run pom: 'pom.xml', goals: 'clean install'
	    	       echo 'buildInfo rtMaven'
           jiraSendBuildInfo site: 'balajisubramanian.atlassian.net'
    }

    stage('Publish build info') {
	    echo 'echo Publish build info...'
        server.publishBuildInfo buildInfo
    }
	
	stage('Build') {
   steps {
       echo 'Building...'
   }
   post {
       always {
	       echo 'echo jiraSendBuildInfo site: balajisubramanian.atlassian.net'
           jiraSendBuildInfo site: 'balajisubramanian.atlassian.net'
       }
   }
}
	
	stage('Deploy - Production') {
   when {
       branch 'master'
   }
   steps {
       echo 'Deploying to Production from master...'
   }
   post {
       always {
	       echo 'echo jiraSendDeploymentInfo site: balajisubramanian.atlassian.net'
           jiraSendDeploymentInfo site: 'balajisubramanian.atlassian.net', environmentId: 'us-prod-1', environmentName: 'us-prod-1', environmentType: 'production'
       }
   }
}
	
    }
	 
