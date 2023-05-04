pipeline {
    agent any

    environment {
        DOCKERHUB_CREDENTIALS = credentials('dockerhub')
        PROJECT_ID = 'ci-cd-gcp-k8s-imey'
        CLUSTER_NAME = 'cluster-1'
        LOCATION = 'asia-east1-a'
        CREDENTIALS_ID = 'GCP-cer'
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

        stage('Update Deployment Image ') {
          steps {
            withCredentials([kubeconfigFile(credentialsId: 'GCP-cer', variable: 'KUBECONFIG')]) {
//               sh 'kubectl config use-context <context-name>'
              sh 'kubectl set image deployment/my-app-java-dev my-app-java-dev=duogglong/java-spring:latest --kubeconfig $KUBECONFIG'
            }
          }
        }
    }
    post {
        always {
          sh 'docker logout'
        }
    }
}