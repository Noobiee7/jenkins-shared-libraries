def call(string imageName, string userName, string tagName, string name, stirng acrname, string servicePrinciple,  )
withCredentials([usernamePassword(credentialsId: 'azure-sp', usernameVariable: 'APP_ID', passwordVariable: 'PASSWORD')]) {
    sh '''
        az login --service-principal -u $APP_ID -p $PASSWORD --tenant <TENANT_ID>
        az acr login --name myregistry
        docker tag shelby777/tetris:latest myregistry.azurecr.io/tetris:latest
        docker push myregistry.azurecr.io/tetris:latest
    '''
}
