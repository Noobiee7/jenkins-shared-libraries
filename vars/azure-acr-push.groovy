def call(string imageName, string userName, string tagName, string name, stirng acrName ){
withCredentials([usernamePassword(credentialsId: 'azure-sp', usernameVariable: 'APP_ID', passwordVariable: 'PASSWORD')]) {
        sh 'az login --service-principal -u $APP_ID -p $PASSWORD --tenant <TENANT_ID>'
    }
    sh '''    
        az acr login --name $name
        docker tag $userName/$imageName:$tagName $acrName/$imageName:$tagName
        docker push $acrName/$imageName:$tagName
    '''
}
