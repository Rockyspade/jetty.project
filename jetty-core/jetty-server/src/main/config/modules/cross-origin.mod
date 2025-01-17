# DO NOT EDIT THIS FILE - See: https://eclipse.dev/jetty/documentation/

[description]
Enables CrossOriginHandler to support the CORS protocol and protect from cross-site request forgery (CSRF) attacks.

[tags]
server
handler
csrf

[depend]
server

[xml]
etc/jetty-cross-origin.xml

[ini-template]
#tag::documentation[]
## Whether cross-origin requests can include credentials such as cookies or authentication headers.
# jetty.crossorigin.allowCredentials=true

## A comma-separated list of headers allowed in cross-origin requests.
# jetty.crossorigin.allowedHeaders=Content-Type

## A comma-separated list of HTTP methods allowed in cross-origin requests.
# jetty.crossorigin.allowedMethods=GET,POST,HEAD

## A comma-separated list of origins regex patterns allowed in cross-origin requests.
# jetty.crossorigin.allowedOriginPatterns=*

## A comma-separated list of timing origins regex patterns allowed in cross-origin requests.
# jetty.crossorigin.allowedTimingOriginPatterns=

## Whether preflight requests are delivered to the child Handler of CrossOriginHandler.
# jetty.crossorigin.deliverPreflightRequests=false

## Whether requests whose origin is not allowed are delivered to the child Handler of CrossOriginHandler.
# jetty.crossorigin.deliverNonAllowedOriginRequests=true

## Whether WebSocket upgrade requests whose origin is not allowed are delivered to the child Handler of CrossOriginHandler.
# jetty.crossorigin.deliverNonAllowedOriginWebSocketUpgradeRequests=false

## A comma-separated list of headers allowed in cross-origin responses.
# jetty.crossorigin.exposedHeaders=

## How long the preflight results can be cached by browsers, in seconds.
# jetty.crossorigin.preflightMaxAge=60
#end::documentation[]
