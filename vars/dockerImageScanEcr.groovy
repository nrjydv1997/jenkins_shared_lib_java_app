def call(String aws_account_id, String region, String ecrRepoName){
    sh """
    trivy image ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecrRepoName}:latest > scan.txt
    cat scan.txt
    """
}