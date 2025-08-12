def call(String imageName, String dockerHubUser, String tagName, String acrName, String acrurl){
withCredentials([usernamePassword(credentialsId: "acrCred", usernameVariable: "AZURE_CLIENT_ID", passwordVariable: "AZURE_CLIENT_SECRET")]) {
        sh """
        set +x
        az login --service-principal --username $AZURE_CLIENT_ID --password $AZURE_CLIENT_SECRET --tenant 11c0a18b-b9dd-43aa-b740-c285e47c2d2b 
        set -x
        """
    }
    sh """    
        az acr login --name $carName
        docker tag $dockerHubUser/$imageName:$tagName $acrName/$imageName:$tagName
        docker push $acrurl/$imageName:$tagName
    """
}
