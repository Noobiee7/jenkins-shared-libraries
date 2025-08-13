def call(String imageName, String tag, String acrurl){
  sh """
      docker build -t ${imageName}:${tag} .
        
      docker tag ${imageName}:${tag} ${acrurl}/${imageName}:${tag}
  """
}
