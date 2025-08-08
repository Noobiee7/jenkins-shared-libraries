def call(String imageName, String dockerHubUser, String tagName, String name, String acrName){
withCredentials([usernamePassword(credentialsId: 'acrCred', usernameVariable: 'dockerHubUser', passwordVariable: 'dockerHubPass')]) {
        sh 'az login --service-principal --username $APP_ID --password $PASSWORD --tenant 11c0a18b-b9dd-43aa-b740-c285e47c2d2b'
    }
    sh '''    
        az acr login --name $name
        docker tag $dockerHubUser/$imageName:$tagName $acrName/$imageName:$tagName
        docker push $acrName/$imageName:$tagName
    '''
}
