package info.ls.graphql

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.extensions.authentication
import com.github.kittinunf.fuel.core.extensions.jsonBody
import me.lazmaid.kraph.Kraph

// sample query: first 3 github org members with role
val kuery = Kraph {
    query {
        fieldObject("organization", args = mapOf("login" to "github")) {
            fieldObject("membersWithRole", args = mapOf("first" to 3)){
                fieldObject("edges"){
                    field("role")
                    fieldObject("node"){
                        field("name")
                    }
                }
            }
        }
    }
}

fun query(url: String, bearerToken: String, query: String = ""){

    val request:String = if (query.isNotEmpty()) query else kuery.toRequestString()
    
    val (_, _, result) = Fuel.post(url)
            .authentication().bearer(bearerToken)
            .jsonBody(request)
            .responseString()
    result.fold({ value -> println(value)  },
            { error -> println("Error: \n$error\n") })        
}

fun main(args: Array<String>) {
    if (args.size < 2) {
        println("Please provide at least 2 command line arguments:")
        println("1. Github (Enterprise) GraphQL API endpoint")         // args[0]
        println("2. Github personal access token")                     // args[1]
        println("3. optional graphql json query ")
        println("Usage: gradle run -Dexec.args=\"{graphql endpoint} {personal access token}\"")
        println("example:")
        println("$ export GHTOKEN=<your github personal access token>")
        println("$ gradle run -Dexec.args=\"https://api.github.com/graphql \$GHTOKEN\"")
        return
    }
    if (args.size == 3) query(args[0], args[1], args[2]) else query(args[0], args[1]) 
}