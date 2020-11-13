#set($hash = '#')
${hash} ${artifactId}

${hash}${hash}${hash} Development

```bash
mvn clean package
```

Build docker image:
```bash
docker build -t ${artifactId} .
```

Create docker network:
```bash
docker network create ${artifactId}-network
```

Run database in docker:
```bash
docker run -d -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=${artifactId} --network ${artifactId}-network --name ${artifactId}-db postgres:12
```

Run docker image (change `<PORT>`):
```bash
docker run -d -p <PORT>:8080 -e KUMULUZEE_DATASOURCES0_CONNECTIONURL=jdbc:postgresql://${artifactId}-db:5432/${artifactId} -e KUMULUZEE_DATASOURCES0_USERNAME=postgres -e KUMULUZEE_DATASOURCES0_PASSWORD=postgres --network ${artifactId}-network --name ${artifactId}-service ${artifactId}
```