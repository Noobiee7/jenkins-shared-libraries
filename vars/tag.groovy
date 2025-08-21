def call(String imageName, String acrurl, String tag){
  sh "docker tag $imageName:$tag $acrurl/$imageName:$tag"
}
