# maven-project-ci
An example for maven project for CI purpose 

Building without integration tests:
```
mvn clean package
```

Building with local integration tests:
```
mvn clean package -Plocal-integration-test
```

Building with remote integration tests:
```
mvn clean package -Premote-integration-test
```

Building from jenkins should call and provide a property:
```
mvn clean package -Drevision=$BUILD_NUMBER
```

Releasing:
```
mvn clean scm:tag -Drevision=$BUILD_NUMBER
```

