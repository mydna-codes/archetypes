# Archetype for basic KumuluzEE microservice

## Deploy the archetype on nexus:
```bash
mvn clean deploy
```

## Generate project from the archetype:
```bash
mvn archetype:generate -P mydna "-DarchetypeGroupId=codes.mydna.archetype" "-DarchetypeArtifactId=rest-service" "-DarchetypeVersion=1.0.1" "-DgroupId=codes.mydna" "-DartifactId=new-service" "-Dversion=1.0.0-SNAPSHOT"
```