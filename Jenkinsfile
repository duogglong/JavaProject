pipeline {
    agent any

    environment {
        DOCKERHUB_CREDENTIALS = credentials('dockerhub')
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build Image') {
          steps {
            sh 'docker build -t duogglong/java-spring .'
          }
        }

        stage('Login Docker') {
          steps {
            sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
          }
        }

        stage('Push Image') {
          steps {
            sh 'docker push duogglong/java-spring'
          }
        }
    }
    post {
        always {
          sh 'docker logout'
        }
    }
}