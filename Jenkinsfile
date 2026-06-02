pipeline {

    agent any

    stages {

        stage('Checkout') {

            steps {

                git 'YOUR_GITHUB_URL'
            }
        }

        stage('Build') {

            steps {

                bat 'mvn clean test'
            }
        }
    }

    post {

        always {

            archiveArtifacts
            artifacts: 'screenshots/*.png'

            junit '**/testng-results.xml'
        }
    }
}