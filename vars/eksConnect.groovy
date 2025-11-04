def call(String aws_account_id, String region, String ecrRepoName, String eks_cluster_name){
    withCredentials([aws(accessKeyVariable: 'AWS_ACCESS_KEY_ID', credentialsId: 'aws-cred', secretKeyVariable: 'AWS_SECRET_ACCESS_KEY')]) {
           sh"""
            aws configure set aws_access_key_id $AWS_ACCESS_KEY_ID
            aws configure set aws_secret_access_key $AWS_SECRET_ACCESS_KEY
            aws configure set default.region ${region}
            aws eks update-kubeconfig --region ${region} --name ${eks_cluster_name}

            echo "✅ Verifying EKS connection..."
            kubectl get nodes
           """
    }          
}