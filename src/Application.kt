package com.gmail.phinespec

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*


/**
 *  A Ktor Application is a program listening to one or more ports
 *   using a configured engine, which contains modules with installed features
 *
 *   This application is composed of different modules with different logic
 *   that will define what our REST endpoint and server-side code will do
 *
 *   We can then install features (Authentication, routes, security etc)
 *
 *   This is really the highlevel configuration and driving program driving our server code
 *
 *   The path (URI/URL) is the route (way) to a resource
 *   A resource is any kind of logical object in the business model
 *   HTTP is most often used as the transport protocol
 *   JSON is used as the preferred data format
 *  HTTPS ensures that communication is encrypted between the client and the server
 *  A REST API is often made secure with OAuth2 authentication
 *
 *
 *
 *
 *                          7 HTTP Methods
 *
 *           -  GET     - Retrieve data like a list or single object
 *           -  PUT     - Create or update an object
 *           -  POST    - Submit data or update an object
 *           -  DELETE  - Delete a resource
 *           -  HEAD    - Only retrieves the header (no body)
 *           -  OPTIONS - Query which methods are possible
 *           -  PATCH   - Updates a partial resource
 *
 *
 *                          REST Endpoint
 *
 *         https://mydomain.com/customer?orderby=name&startswith=K
 *
 *
 *         - First part is the protocol (https)
 *         - Second part is the domain (mydomain)
 *         - Third part is the resource
 *         - Fourth is a list of query / request parameters
 *
 *
 *                          Hypermedia
 *
 *         Tells the client how to continue or what to do with the current resource
 *
 *         Here we are querying "https://mydomain.com/user/12345"
 *
 *         The links are the other endpoints we can call in relation to this resource
 *
 *         {
 *              "userId": 12345,
 *              "name":  "George",
 *              "links": [
 *                  {
 *                  "href": "12345/kotlinprojects",  - Tells the client which endpoint to use to access the resource
 *                  "rel":  "kotlinprojects",        - Relation to the current resource
 *                  "type": "GET"                    - Which HTTP method to be used
 *                  }
 *              ]
 *          }
 */

// Routes are installed features to structure and simplify application request handling
// Lets us define GET and POST and define what the response will be

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

private val userData = "{\"users\": [\"Rafael\", \"Leonardo\", \"Donatello\", \"Michaelangelo\"]}"

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {

    routing {
        get("/")  {
            call.respondText("Hello Ktor", ContentType.Text.Plain)
        }

        get("/users") {
            call.respondText(userData)
        }

        post("/") {
            val post = call.receive<String>()

            call.respondText("Received $post from the post body", ContentType.Text.Plain)
        }
    }
}


/**
 *                          LIBRARY EXAMPLE
 *
 *
 */