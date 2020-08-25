pipeline {
  agent any
  stages {
    stage('Release') {
      parallel {
        stage('Build') {
          steps {
            echo 'Build is Started'
            bat 'mvn clean install -DskipTests=true'
            echo 'Build is Successful'
          }
        }

        stage('run on release') {
          steps {
            bat 'mvn test -Denv=release'
          }
        }

      }
    }

  }
}
