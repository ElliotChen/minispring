# Pipeline

## 前言

這部份要分為幾個部份來討論

1. Checkout 及 Build image
2. Deploy 到 Minikube


## Pipeline

```
pipeline {
    agent any
    
    tools {
        jdk "jdk14"
        gradle "gradle"
    }
    
    stages {
        stage('SCM') {
            steps {
                echo 'Checkout From Git'
                git 'https://github.com/ElliotChen/minispring'
            }
        }
        
        stage('Build') {
            steps {
                echo 'Build docker Image'
                sh "gradle bootBuildImage"
            }
        }
    }
}

```