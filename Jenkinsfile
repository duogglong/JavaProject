pipeline {
    agent any
    environment {
        DOCKERHUB_CREDENTIALS = credentials('dockerhub')
        PROJECT_ID = 'ci-cd-gcp-k8s-imey'
        CLUSTER_NAME = 'cluster-1'
        LOCATION = 'asia-east1-a'
        CREDENTIALS_ID = 'gke'
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
        stage('Push image') {
            steps {
                script {
                    sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
                    app.push("${env.BUILD_ID}")
                 }

            }
        }
        stage('Deploy to K8s') {
            steps{
                echo "Deployment started ..."
                sh 'ls -ltr'
                sh 'pwd'
                sh "sed -i 's/java-spring:latest/java-spring:${env.BUILD_ID}/g' deployment.yaml"
                step([$class: 'KubernetesEngineBuilder', \
                  projectId: env.PROJECT_ID, \
                  clusterName: env.CLUSTER_NAME, \
                  location: env.LOCATION, \
                  manifestPattern: 'deployment.yaml', \
                  credentialsId: env.CREDENTIALS_ID, \
                  verifyDeployments: true])
            }
        }
    }
    post {
        always {
          sh 'docker logout'
        }
    }
}