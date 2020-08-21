# Gradle

## buildImage

雖說正式的方式，還是應該透過`Dockerfile`來產生docker image，但Spring Boot提供了另一個選擇

透過Gradle 的Task `bootBuildImage`，即可產生專為SpringBoot Application需求而生的image.

![Gradle](https://blog.elliot.tw/wp-content/uploads/2020/08/minispring_01_gradle.png)

簡單指令

```cmd
gradle bootBuildImage
```

可以看到

```cmd

> Task :bootBuildImage
Building image 'docker.io/library/minispring:0.0.1-SNAPSHOT'

 > Pulling builder image 'gcr.io/paketo-buildpacks/builder:base-platform-api-0.3' ..................................................
 > Pulled builder image 'gcr.io/paketo-buildpacks/builder@sha256:793b289414f3ea66540750edf618756916b6102a6a94389822526cd99d033b36'
....
    [creator]     ===> EXPORTING
    [creator]     Reusing layer 'paketo-buildpacks/bellsoft-liberica:class-counter'
    [creator]     Reusing layer 'paketo-buildpacks/bellsoft-liberica:java-security-properties'
    [creator]     Reusing layer 'paketo-buildpacks/bellsoft-liberica:jre'
    [creator]     Reusing layer 'paketo-buildpacks/bellsoft-liberica:jvmkill'
    [creator]     Reusing layer 'paketo-buildpacks/bellsoft-liberica:link-local-dns'
    [creator]     Reusing layer 'paketo-buildpacks/bellsoft-liberica:memory-calculator'
    [creator]     Reusing layer 'paketo-buildpacks/bellsoft-liberica:openssl-certificate-loader'
    [creator]     Reusing layer 'paketo-buildpacks/bellsoft-liberica:security-providers-configurer'
    [creator]     Reusing layer 'paketo-buildpacks/executable-jar:class-path'
    [creator]     Reusing layer 'paketo-buildpacks/spring-boot:spring-cloud-bindings'
    [creator]     Reusing layer 'paketo-buildpacks/spring-boot:web-application-type'
....
    [creator]     *** Images (1ce932692b6f):
    [creator]           docker.io/library/minispring:0.0.1-SNAPSHOT

Successfully built image 'docker.io/library/minispring:0.0.1-SNAPSHOT'

```

是一個有分層架構的docker image，實測上，也比自行使用Dockerfile建構產生的image，具有一些建構及載入上時間的優勢。
