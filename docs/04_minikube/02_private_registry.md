# Private Registry

## Reference

Reference [docker on macOS](https://minikube.sigs.k8s.io/docs/handbook/registry/#docker-on-macos)

## enable 

```
minikube addons enable registry
```

## network configuration

```
docker run --rm -it --network=host alpine ash -c "apk add socat && socat TCP-LISTEN:5000,reuseaddr,fork TCP:$(minikube ip):5000"
```

將minikube docker registry 與 local 端綁定，才不會每次都要知道minikube ip

## tag and push image

```
docker tag my/image localhost:5000/myimage
docker push localhost:5000/myimage
```

## verify 

```
curl http://"$(minikube ip)":5000/v2/_catalog
```