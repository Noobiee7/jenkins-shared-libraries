def call(String appName, String rgName, String acrurl, String imageName, String tag){
  withCredentials([usernamePassword(credentialsId: "acrCred", usernameVariable: "AZURE_CLIENT_ID", passwordVariable: "AZURE_CLIENT_SECRET" )]){
    sh """
    set +x
    az login --service-principal --username $AZURE_CLIENT_ID --password $AZURE_CLIENT_SECRET --tenant 11c0a18b-b9dd-43aa-b740-c285e47c2d2b
    """
  //configure Web app
  sh """
  az webapp config container set --name $appName --resource-group $rgName --docker-custom-image-name $acrurl/$imageName:$tag --docker-registry-server-url https://$acrName

  az webapp restart --name $appName --resource-group $rgName
  
  """
  }
}
