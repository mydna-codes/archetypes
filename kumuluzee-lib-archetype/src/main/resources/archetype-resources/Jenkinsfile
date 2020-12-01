pipeline {

    agent any

    environment {
        // Global variables
        NEXUS_CREDENTIALS      = "mydnacodes-nexus-user"
        // Local variables
        COMMIT_AUTHOR          = ""
        COMMIT_MESSAGE         = ""
    }

    tools {
        maven "mvn-3.6"
        jdk "jdk-11"
    }

    stages {
        stage("Set environment variables") {
            steps {
                script {
                    COMMIT_MESSAGE       = sh script: "git show -s --pretty='%s'", returnStdout: true
                    COMMIT_AUTHOR        = sh script: "git show -s --pretty='%cn <%ce>'", returnStdout: true
                    COMMIT_AUTHOR        = COMMIT_AUTHOR.trim()
                }
            }
        }
        stage("Deploy libraries") {
           steps {
               withCredentials([usernamePassword(credentialsId: NEXUS_CREDENTIALS, passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
                   sh "mvn clean deploy -DskipTests=true -Dnexus.username=$USERNAME -Dnexus.password=$PASSWORD --settings .ci/settings.xml"
               }
           }
        }
        stage("Clean maven packages") {
            steps {
                sh "mvn clean"
            }
        }
    }
    post {
        success {
            slackSend (color: '#57BA57',
                       message: """[<${env.BUILD_URL}|Build ${env.BUILD_NUMBER}>] *SUCCESSFUL*\n
                                  |Job: *${env.JOB_NAME}*\n
                                  |Branch: ${GIT_BRANCH}
                                  |Author: ${COMMIT_AUTHOR}
                                  |Message: ${COMMIT_MESSAGE}""".stripMargin()
            )
        }
        failure {
            slackSend (color: '#BD0808',
                       message: """[<${env.BUILD_URL}|Build ${env.BUILD_NUMBER}>] *FAILED*\n
                                  |Job: *${env.JOB_NAME}*\n
                                  |Branch: ${GIT_BRANCH}
                                  |Author: ${COMMIT_AUTHOR}
                                  |Message: ${COMMIT_MESSAGE}""".stripMargin()
            )
        }
    }
}