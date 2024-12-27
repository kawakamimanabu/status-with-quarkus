# status-with-quarkus

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Usage

This application returns http status code specified by path parameter.

For example, if you execute the following curl command, 404 is returned.

curl -v http://localhost:8080/status/404

Please refer the http status codes.

https://developer.mozilla.org/ja/docs/Web/HTTP/Status


## Deploying On OpenShift

You can deploy this on your OpenShift. After logging on your OpenShift environment by oc command, you can execute the following:
```shell script
./mvnw install -Dquarkus.kubernetes.deploy=true
```
Then, you can expose service and check working by curl command:
```shell script
oc expose service/status-with-quarkus

curl -v http://status-with-quarkus-mystatus.apps-crc.testing/status/404

* Host status-with-quarkus-mystatus.apps-crc.testing:80 was resolved.
* IPv6: (none)
* IPv4: 192.168.130.11
*   Trying 192.168.130.11:80...
* Connected to status-with-quarkus-mystatus.apps-crc.testing (192.168.130.11) port 80
> GET /status/404 HTTP/1.1
> Host: status-with-quarkus-mystatus.apps-crc.testing
> User-Agent: curl/8.9.1
> Accept: */*
> 
* Request completely sent off
< HTTP/1.1 404 Not Found
< content-length: 0
< set-cookie: bb962fcc4b7a348ec62d0c335cf6ba63=22e3473461dc8e106aa8e7e0e85800fe; path=/; HttpOnly
< 
* Connection #0 to host status-with-quarkus-mystatus.apps-crc.testing left intact
```


## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/status-with-quarkus-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides

- RESTEasy Classic ([guide](https://quarkus.io/guides/resteasy)): REST endpoint framework implementing Jakarta REST and more

## Provided Code

### RESTEasy JAX-RS

Easily start your RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)
