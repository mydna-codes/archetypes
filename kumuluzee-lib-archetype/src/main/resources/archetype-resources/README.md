#set($hash = '#')
${hash} ${artifactId}

## Deployment
```bash
mvn clean deploy
```

## Usage
```xml
<dependencies>
    <dependency>
        <groupId>${groupId}</groupId>
        <artifactId>${artifactId}</artifactId>
        <version>${version}</version>
    </dependency>
</dependencies>
```