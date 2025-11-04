def call(String aws_account_id, String region, String ecrRepoName){
    sh """
    aws ecr get-login-password --region ${region} | docker login --username AWS --password-stdin ${aws_account_id}.dkr.ecr.${region}.amazonaws.com
    docker push ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecrRepoName}:latest
    """
}