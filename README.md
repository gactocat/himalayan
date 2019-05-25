# 🐥 himalayan

API server in Kotlin.
This repository is designed based on [The Twelve Factor App](https://12factor.net/) and The Clean Architecture.

## Run

Exec the following to run.

```shell
./gradlew run
```

So you can refer to the following.

http://localhost:8082/v1/movies/123

## Build

Exec the following to build.

```shell
./gradlew :infrastructure:distTar
```

This is a tar containing the executable file.

`./infrastructure/build/distributions/infrastructure.tar`

## Test

Exec the following to test.

```shell
./gradlew test
```

## Deploy

TBD
