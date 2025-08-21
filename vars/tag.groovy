def call(String imageName, String acrurl){
  sh 'docker tag $imageName $acrurl/$imageName:latest'
}
