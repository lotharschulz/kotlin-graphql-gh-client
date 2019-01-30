# Github GraphQL query script

Simple queries Github.com or Github Enterprise [GraphQL API](https://developer.github.com/v4/).

## Why
You may use this code as inspiration for ([Github's](https://developer.github.com/v4/)) [Graphql](https://graphql.org/) API requests with Kotlin code.

### Preconditions
- [*nix](https://en.wikipedia.org/wiki/Unix-like) terminal
- [Gradle](https://docs.gradle.org/)  

### Usage
```
$ export GHTOKEN=<your github personal access token>
$ ./gradlew run -Dexec.args="https://api.github.com/graphql $GHTOKEN"
$ ./gradlew run -Dexec.args="https://api.github.com/graphql $GHTOKEN {\"query\":\"query{viewer{login}}\"}"

parameter explained:
println("1. Github (Enterprise) GraphQL API endpoint")
println("2. Github personal access token")
println("3. optional graphql json query ")
```

### Used libraries

- [fuel](https://github.com/kittinunf/fuel)
- [kraph](https://github.com/VerachadW/kraph) 

