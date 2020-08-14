pipeline {
  agent any
  stages {
    stage('Release') {
      parallel {
        stage('Release') {
          steps {
            echo 'run on Release'
          }
        }

        stage('run on release') {
          steps {
            sh 'echo "run on release"'
          }
        }

      }
    }

  }
}