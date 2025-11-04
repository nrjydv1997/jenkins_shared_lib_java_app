def call(String aws_account_id, String region, String ecrRepoName){
    sh """
    docker rmi ${ecrRepoName}:latest
    docker rmi ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecrRepoName}:latest
    """
}