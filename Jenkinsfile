pipeline {
    agent any
    environment {
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
        stage('Build image') {
            steps {
                script {
                    app = docker.build("duogglong/java-spring:${env.BUILD_ID}")
                    }
            }
        }
    }
}