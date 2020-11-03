pipeline{
agent any
stages
{
stage('Compile')
{
   steps{ 
      sh "mvn clean compile"
          }
}		
				
stage('Testing')
{
   steps{
     sh "mvn test"
        }
}
stage('packaging')
{
when{   
branch 'main'
}
   steps{
	sh "mvn package"                                                                  //sbt package vs sbt assembly
	}
}
stage('build image')
{
when{
branch 'main'
     }
    steps{ 
	 sh " docker build -t  himanshu1018/finalcapstone:$BUILD_NUMBER ."
          }
}
stage('push image')
{
when{
branch 'main'
     }
     steps{
     withCredentials([string(credentialsId: 'DOCKER_HUB_CREDENTIALS', variable: 'DOCKER_HUB_CREDENTIALS')]) {
          echo "pushing the image to the dockerhub registry"
	  sh "docker login -u himanshu1018 -p ${DOCKER_HUB_CREDENTIALS}"
          sh " docker push himanshu1018/finalcapstone:$BUILD_NUMBER"
			       }
	   }
}	
stage('Deploy to K8')
{
when{
branch 'master'
  }
			
        steps{
	//kubernetesDeploy(
	   // configs: 'deploy.yml',
            // kubeconfigId: 'KUBERNETES_CLUSTER_CONFIG',
	    // enableConfigSubstitution: true
		//	  )
		sh "pwd"
		//sh "kubectl delete -f deploy.yml"
        sh "kubectl create -f deploy.yaml"
		}
            post {
		    always{       mail to: "himanshu.upadhayay@knoldus.com",
                     subject: "Image build succesfully",
                     body: "Hello successfull completion f task, ${env.JOB_NAME} has been build successfully"
                  }
	    }
	    }
  }

		
	   
}
