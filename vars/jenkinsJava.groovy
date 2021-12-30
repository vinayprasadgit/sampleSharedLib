def call(String repoUrl){
  pipeline {
    agent any
    tools{
       maven 'Maven3.8.3'
    }
    stages {
       stage("Tools initialization") {
               steps {
                   sh "mvn --version"
               }
           }
      stage("Checkout code"){
        steps{
          git branch: 'master',
            url: "${repoUrl}"
        }
      }
      stage("Clean workspace"){
        steps{
          sh "mvn clean package"
        }
      }
    }
  }
}
