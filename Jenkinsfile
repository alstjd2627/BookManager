pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // 소스코드 체크아웃
                checkout scm
            }
        }

        stage('Build') {
            steps {
                // Java 파일들을 컴파일하여 생성된 클래스 파일을 classes 디렉토리에 저장
                // window 일 경우 bat
                sh 'javac -encoding UTF-8 -d classes BookManager/src/**/*.java'
            }
        }

        stage('Test') {
            steps {
                // 테스트 단계 (테스트 명령어 예시)
                // 예시: 테스트를 실행하고 결과를 test_results.txt에 저장
                sh 'java -cp classes org.junit.runner.JUnitCore BookManagerTests > test_results.txt'
            }
        }
    }

    post {
        always {
            // 테스트 결과 파일을 저장하기 위해 아카이브
            archiveArtifacts 'test_results.txt'
        }
        failure {
            echo 'Build or test failed'
        }
        success {
            echo 'Build and test succeeded'
        }
    }
}
