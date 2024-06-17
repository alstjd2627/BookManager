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
                script {
                    // Java 파일들을 컴파일하여 생성된 클래스 파일을 classes 디렉토리에 저장
                    def classpath = "lib/junit-jupiter-5.9.0.jar:lib/*"
                    sh "javac -encoding UTF-8 -d classes -cp ${classpath} src/*.java"
                }
            }
        }

        stage('Test') {
                    steps {
                        script {
                            // JUnit 5 테스트를 위한 클래스패스 설정
                            def classpath = "classes;lib/junit-jupiter-5.9.0.jar;lib/junit-jupiter-engine-5.9.0.jar;lib/junit-platform-console-standalone-1.7.1.jar;lib/picocli-4.7.6.jar;lib/*"
                            def junitConsoleJar = "lib/junit-platform-console-standalone-1.7.1.jar" // 정확한 경로 설정
                            // JUnit 테스트 실행
                            bat "java -cp ${classpath} org.junit.platform.console.ConsoleLauncher --scan-classpath > test_results.txt"
                        }
                    }
                }
    }

    post {
        always {
            // 테스트 결과 파일을 저장하기 위해 아카이브
            archiveArtifacts artifacts: 'test_results*.txt', allowEmptyArchive: true
        }
        failure {
            echo 'Build or test failed'
        }
        success {
            echo 'Build and test succeeded'
        }
    }
}
