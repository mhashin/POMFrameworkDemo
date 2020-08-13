pipeline {
  agent any
  stages {
    stage('Release') {
      steps {
        bat 'run on release environment'
        bat 'run on QA'
      }
    }

    stage('Prod') {
      steps {
        bat 'run on prod'
      }
    }

  }
}