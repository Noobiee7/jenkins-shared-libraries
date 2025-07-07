def call(String ImageName String ImageTag String DockerHubUser){
  withCredentials([usernamePassword('credentialsId':"dockerHubCred", passwordVariable:"dockerHubPass", usernameVariable:"dockerHubUser")]){
    sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
  }
  docker push ${DockerHubUser}/${ImageName}:${ImageTag}
}
