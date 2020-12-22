# Deployment 01

## kubectl

```
kubectl create -f minispring-deployment.yaml,minispring-service.yaml

kubectl create -f  ./deploy/kubectl/minispring-deployment.yaml,./deploy/kubectl/minispring-service.yaml
```

## verify

get service info

```
> kubectl get services

NAME         TYPE        CLUSTER-IP      EXTERNAL-IP   PORT(S)          AGE
kubernetes   ClusterIP   10.96.0.1       <none>        443/TCP          85d
minispring   NodePort    10.97.247.180   <none>        8080:30484/TCP   2m7s

```

check response with api example

```
curl http://"$(minikube ip)":30484/api/example
```

## update image

### 1. set image

```
kubectl set image deployment minispring minispring=localhost:5000/minispring:latest --record
```

### 2. replace

```
kubectl replace -f minispring-deployment.yaml
```
