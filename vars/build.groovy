def call(String imageName, String tag, String acrName){
  sh "docker build -t $imageName:$tag .
      docker tag $imageName:$tag $acrName/$imageName:$tag
  "
}
