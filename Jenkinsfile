pipeline {
  agent any
  stages {
    stage('Release') {
      steps {
        sh 'echo "run on release environment"'
      }
    }

    stage('Prod') {
      steps {
        sh 'echo "run on prod"'
      }
    }

  }
}