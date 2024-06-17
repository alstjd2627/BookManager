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
                       sh 'javac -encoding UTF-8 -d classes -cp lib/junit-jupiter-5.9.0.jar:lib/* src/*.java'
                   }
               }

               stage('Test') {
                   steps {
                       // 테스트 단계
                        sh 'java -cp classes:lib/junit-jupiter-5.9.0.jar:lib/junit-jupiter-engine-5.9.0.jar:lib/junit-platform-console-standalone-1.9.0.jar:lib/picocli-4.7.6.jar:lib/* org.junit.platform.console.ConsoleLauncher --classpath classes --select-class BookManagerTest > test_results1.txt'
                        sh 'java -cp classes:lib/junit-jupiter-5.9.0.jar:lib/junit-jupiter-engine-5.9.0.jar:lib/junit-platform-console-standalone-1.9.0.jar:lib/picocli-4.7.6.jar:lib/* org.junit.platform.console.ConsoleLauncher --classpath classes --select-class BookManagerTest2 > test_results2.txt'
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
