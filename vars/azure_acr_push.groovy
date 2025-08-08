def call(string imageName, string dockerHubUser, string tagName, string name, stirng acrName){
withCredentials([usernamePassword(credentialsId: 'azure-sp', usernameVariable: 'ddac2575-c1ef-4003-8782-f382f95ffec1', passwordVariable: 'ibZ8Q~IJ-F-aseWV-wswcdyv6jtMxdtxdqnoIbEQ')]) {
        sh 'az login --service-principal -u $APP_ID -p $PASSWORD --tenant 11c0a18b-b9dd-43aa-b740-c285e47c2d2b'
    }
    sh '''    
        az acr login --name $name
        docker tag $dockerHubUser/$imageName:$tagName $acrName/$imageName:$tagName
        docker push $acrName/$imageName:$tagName
    '''
}
