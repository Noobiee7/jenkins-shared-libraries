def call(String appName, String rgName, String acrName, String imageName, String tagName){
  withCredentials([usernamePassword(credentialsId: "acrCred", usernameVariable: "AZURE_CLIENT_ID", passwordVariable: "AZURE_CLIENT_SECRET" )]){
    sh """
    set +x
    az login --service-principal --username $AZURE_CLIENT_ID --password $AZURE_CLIENT_SECRET --tenant 11c0a18b-b9dd-43aa-b740-c285e47c2d2b
    """
  #configure Web app
  sh """
  az webapp config container set --name $appName --resource-group $rgName --docker-custom-image-name $acrName/$imageName:$tagName --docker-registry-server-url https://$acrName

  #Restart web app
  az webapp restart --name $appName --resource-group $rgName
  
  """
  }
}
