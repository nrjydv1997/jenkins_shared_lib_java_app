def call(String project, String imageTag, String hubUser){
   
   withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
    sh "docker login -u '$USER' -p '$PASS'"
  }

  sh "docker image push ${hubUSer}/${project}:${imageTag}"
  sh "docker image push ${hubUSer}/${project}:latest"
}