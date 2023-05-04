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

//         stage('Push image') {
//             steps {
//                 script {
//                     withCredentials( \
//                                  [string(credentialsId: 'dockerhub',\
//                                  variable: 'dockerhub')]) {
//                         sh "docker login -u duogglong -p ${dockerhub}"
//                     }
//                     app.push("${env.BUILD_ID}")
//                  }
//
//             }
//         }
//
//         stage('Deploy to K8s') {
//             steps{
//                 echo "Deployment started ..."
//                 sh 'ls -ltr'
//                 sh 'pwd'
//                 sh "sed -i 's/java-spring:latest/java-spring:${env.BUILD_ID}/g' deployment.yaml"
//                 step([$class: 'KubernetesEngineBuilder', \
//                   projectId: env.PROJECT_ID, \
//                   clusterName: env.CLUSTER_NAME, \
//                   location: env.LOCATION, \
//                   manifestPattern: 'deployment.yaml', \
//                   credentialsId: env.CREDENTIALS_ID, \
//                   verifyDeployments: true])
//                 }
//             }
//         }
}