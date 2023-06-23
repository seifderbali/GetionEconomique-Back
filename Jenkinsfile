	pipeline {
	    environment {

            registry = "seifderbali/devopsrepository"

            registryCredential = 'dockerhub-id'

            dockerImage = ''

    }
	        agent any

     stages {
        stage('GIT') {

         steps {
                echo 'cloning project from GIT'
                git branch : "master" ,
		credentialsId: 'seifpfe' ,
                url :'https://github.com/seifderbali/GetionEconomique-Back.git'
            }
        }
        stage('MVN CLEAN') {
            steps {
               sh 'mvn clean'
            }
        }
        stage('MVN COMPILE') {
            steps {
               sh 'mvn compile'

           }
        }

         stage('Scan') {
               steps {
                 sh "mvn sonar:sonar \
                    -Dsonar.projectKey=PFE \
                    -Dsonar.host.url=http://192.168.0.4:9000 \
                    -Dsonar.login=a375046e95a39542a3a8c40f98ad94c13da19e7a"
                    echo "sonar succefully"

                      }
                        }

            stage('Nexus Deploy') {
                 steps {
                     sh 'mvn deploy -e'
            }


        }

              stage('Building our image') {

            steps {

                script {

                    dockerImage = docker.build registry + ":latest"

                }

            }

        }

        stage('Deploy our image') {

            steps {

                script {

                    docker.withRegistry( '', registryCredential ) {

                        dockerImage.push()

                    }
                }

            }

        }

        stage('Cleaning up') {

            steps {

                sh "docker rmi $registry:latest"

            }

        }

	    stage(' Docker Compose') {

            steps {
                sh "docker-compose up -d"

            }

        }
}
}
