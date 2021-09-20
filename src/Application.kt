package com.gmail.phinespec

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*


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
 */

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
}