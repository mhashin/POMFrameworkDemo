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

        stage('') {
          steps {
            echo 'run on release'
          }
        }

      }
    }

  }
}