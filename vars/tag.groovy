def call(String imageName, String acrurl, String tag){
  sh 'docker tag $imageName $acrurl/$imageName:$tag'
}
