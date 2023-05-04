pipeline {
    agent any
    environment {
        PROJECT_ID = 'striped-bastion-329118'
                CLUSTER_NAME = 'jenkins'
                LOCATION = 'asia-southeast1-a'
                CREDENTIALS_ID = 'kubernetes'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('') {
                    steps {
                        echo pwd
                    }
                }
//         stage('Build image') {
//             steps {
//                 script {
//                     app = docker.build("arshad1914/pipeline:${env.BUILD_ID}")
//                     }
//             }
//         }
//
//         stage('Push image') {
//             steps {
//                 script {
//                     withCredentials( \
//                                  [string(credentialsId: 'dockerhub',\
//                                  variable: 'dockerhub')]) {
//                         sh "docker login -u arshad1914 -p ${dockerhub}"
//                     }
//                     app.push("${env.BUILD_ID}")
//                  }
//
//             }
//         }
}