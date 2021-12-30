def call(String repoUrl){
  pipeline {
    agent any
    tools{
       maven 'Maven3.8.3'
       jdk 'jdk8'
    }
    stages {
       stage("Tools initialization") {
               steps {
                   sh "mvn --version"
                   sh "java -version"
               }
           }
      stage("Checkout code"){
        steps{
          git branch: 'master',
              url: "${repoUrl)"
        }
      }
      stage("Clean workspace"){
        steps{
          sh "mvn clean package"
        }
      }
    }
  }
    
