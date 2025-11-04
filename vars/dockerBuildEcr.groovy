/*def call(String project, String imageTag, String hubUser){
    sh """
        docker image build -t ${hubUser}/${project} .
        docker image tag ${hubUser}/${project} ${hubUser}/${project}:${imageTag}
        docker image tag ${hubUser}/${project} ${hubUser}/${project}:latest
    """
}*/

def call(String aws_account_id, String region, String ecrRepoName){
    sh """
     docker build -t ${ecrRepoName} .
     docker tag ${ecrRepoName}:latest ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecrRepoName}:latest
    """
}