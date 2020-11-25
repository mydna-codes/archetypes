# Archetype for KumuluzEE library

## Deploy the archetype on nexus:
```bash
mvn clean deploy
```

## Generate project from the archetype:
```bash
mvn archetype:generate -P mydna "-DarchetypeGroupId=codes.mydna.archetype" "-DarchetypeArtifactId=lib" "-DarchetypeVersion=1.0.2" "-DgroupId=codes.mydna" "-DartifactId=new-lib" "-Dversion=1.0.0-SNAPSHOT"
```