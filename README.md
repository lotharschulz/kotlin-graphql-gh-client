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
```

##### No graphql query provided, default [kgraph](https://github.com/lotharschulz/kotlin-graphql-gh-client/blob/master/src/main/kotlin/info/ls/graphql/Query.kt#L8-L22) applies
```
./gradlew run -Dexec.args="https://api.github.com/graphql $GHTOKEN"
```

##### With graphql query 
```
./gradlew run -Dexec.args="https://api.github.com/graphql $GHTOKEN {\"query\":\"query{viewer{login bio anyPinnableItems(type: GIST)}}\"}"

# with json file
GRAPHQL_QUERY=`cat query1.json`
echo $GRAPHQL_QUERY
./gradlew run -Dexec.args="https://api.github.com/graphql $GHTOKEN $GRAPHQL_QUERY"

# curl equivalent json query
curl -H "Authorization: bearer $GHTOKEN" -X POST -d "{ \"query\": \"query { viewer { login bio anyPinnableItems(type: GIST)}}\" }" https://api.github.com/graphql

# curl equivalent json file
curl -H "Authorization: bearer $GHTOKEN" -X POST -H "Content-Type: application/json" -d @query1.json https://api.github.com/graphql
```

##### With graphql query and variables
```
GRAPHQL_QUERY=`cat query2.json`
echo $GRAPHQL_QUERY
./gradlew run -Dexec.args="https://api.github.com/graphql $GHTOKEN $GRAPHQL_QUERY"

# curl equivalent json file
curl -H "Authorization: bearer $GHTOKEN" -X POST -H "Content-Type: application/json" -d @query2.json https://api.github.com/graphql
```


```
parameter explained:
println("1. GitHub (Enterprise) GraphQL API endpoint")
println("2. GitHub personal access token")
println("3. GitHub graphql json query or file")
```

### Used libraries

- [fuel](https://github.com/kittinunf/fuel)
- [kraph](https://github.com/VerachadW/kraph) 

