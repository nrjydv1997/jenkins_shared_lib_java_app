def call(String project, String imageTag, String hubUser){
  
  sh "docker rmi ${hubUSer}/${project}:${imageTag}"
  sh "docker rmi ${hubUSer}/${project}:latest"
}