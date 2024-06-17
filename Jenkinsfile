pipeline {
    agent any

    tools {
        maven 'Maven3.9.6' // Jenkins에서 설정한 Maven 이름을 사용합니다.
    }
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
                 sh '''
                                java -cp "classes:lib/junit-platform-console-standalone-1.7.1.jar" \
                                org.junit.platform.console.ConsoleLauncher --scan-classpath > test_results.txt
                                '''

            }
        }
    }

    post {
        // 빌드가 끝난 후 수행할 작업을 정의합니다.
        always {

            archiveArtifacts '**/target/surefire-reports/BookManagerTest.txt'
            archiveArtifacts '**/test_result.txt'
        }
        success {
            echo 'Build and tests succeeded!'
        }
        failure {
            echo 'Build or tests failed.'
        }
    }
}
