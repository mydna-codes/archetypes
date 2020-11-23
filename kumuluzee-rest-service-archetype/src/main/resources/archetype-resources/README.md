#set($hash = '#')
${hash} ${artifactId}

${hash}${hash}${hash} Library
```xml
<dependency>
    <groupId>${groupId}</groupId>
    <artifactId>${artifactId}-lib</artifactId>
    <version>${${artifactId}.version}</version>
</dependency>
```

${hash}${hash}${hash} Docker

*Note: This service requires DB.*

Pull docker image:
```bash
docker pull mydnacodes/${artifactId}
```

Run docker image:
```bash
docker run -d -p <PORT>:8080 
    -e KUMULUZEE_DATASOURCES0_CONNECTIONURL=jdbc:postgresql://<DB_HOST>:<DB_PORT>/${artifactId}
    -e KUMULUZEE_DATASOURCES0_USERNAME=<DB_USERNAME> 
    -e KUMULUZEE_DATASOURCES0_PASSWORD=<DB_PASSWORD> 
    --name ${artifactId}-service
    mydnacodes/${artifactId}
```