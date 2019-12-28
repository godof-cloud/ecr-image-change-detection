'''
@autor godofcloud
'''

import boto3
import os

# Enter the region your instances are in. Include only the region without specifying Availability Zone; e.g., 'us-east-1'
region = os.environ['AWS_REGION']
ecsClusterName = os.environ['ECS_CLUSTER_NAME']

def lambda_handler(event, context):
    print 'EVENT: ' + str(event)
    
    if event['detail']['result'] == 'SUCCESS':
        repositoryName = event['detail']['repository-name']
        
        print 'CHANGE IMAGE SUCCESSFUL: ' + repositoryName
        
        ecs = boto3.client('ecs', region_name=region)
        response = ecs.list_services( cluster=ecsClusterName )
        
        print response
        
        for serviceArn in response['serviceArns']:
            serviceName = serviceArn.split('/')[1];
            print 'Service Name ' + serviceName
            if serviceName.startswith(repositoryName):
                print 'Updating Service ' + serviceName + ' in cluster ' + ecsClusterName
                ecs.update_service( cluster=ecsClusterName, service=serviceName, forceNewDeployment=True );