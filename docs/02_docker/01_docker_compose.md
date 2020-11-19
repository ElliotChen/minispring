# docker-compose

## quick 

直接下`docker run`很快，但要敲的東西不少，個人還是建議使用`docker-compose`，
透過yaml 檔案保留記憶及修改的空間。

## demo

[docker-compose.yml](../../docker/docker-compose.yml) for minispring

```yaml
version: "3.7"

services:
  minispring:
    image: localhost:5000/minispring:latest
    ports:
      - 8080:8080
```

執行

```cmd
docker-compose up
```

即可