pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // SCM(소스 코드 관리) 시스템에서 소스 코드를 가져옵니다.
                checkout scm
            }
        }
        stage('Build') {
            steps {
                // Maven 빌드를 수행합니다.
                sh 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                // Maven 테스트를 수행합니다.
                sh 'mvn test'
            }
        }
    }

    post {
        // 빌드가 끝난 후 수행할 작업을 정의합니다.
        always {
            // JUnit 테스트 결과를 보고합니다.
            junit '**/target/surefire-reports/*.xml'

            // 빌드 아티팩트를 보관합니다.
            archiveArtifacts artifacts: '**/target/*.jar', allowEmptyArchive: true
        }
        success {
            echo 'Build and tests succeeded!'
        }
        failure {
            echo 'Build or tests failed.'
        }
    }
}
