pipeline {
  agent any
  stages {
    stage('Release') {
      steps {
        bat 'run on release environment'
      }
    }

    stage('Prod') {
      steps {
        bat 'run on prod'
      }
    }

  }
}