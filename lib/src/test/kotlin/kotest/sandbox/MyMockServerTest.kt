package kotest.sandbox

import io.kotest.assertions.ktor.client.shouldHaveHeader
import io.kotest.assertions.ktor.client.shouldHaveStatus
import io.kotest.core.spec.style.FunSpec
import io.kotest.extensions.mockserver.MockServerListener
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.utils.EmptyContent.contentType
import io.ktor.http.*
import org.mockserver.client.MockServerClient
import org.mockserver.model.HttpRequest
import org.mockserver.model.HttpResponse

class MyMockServerTest : FunSpec() {
    init {

        // this attaches the server to the lifeycle of the spec
        listener(MockServerListener(1080))

        // we can use the client to create routes. Here we are setting them up
        // before each test by using the beforeTest callback.
        beforeTest {
            MockServerClient("localhost", 1080).`when`(
                HttpRequest.request()
                    .withMethod("POST")
                    .withPath("/login")
                    .withHeader("Content-Type", "application/json")
                    .withBody("""{"username": "foo", "password": "bar"}""")
            ).respond(
                HttpResponse.response()
                    .withStatusCode(202)
                    .withHeader("X-Test", "foo")
            )
        }

        // this test will confirm the endpoint works
        test("login endpoint should accept username and password json") {

            // using the ktor client to send requests
            val client = HttpClient(CIO)
            val resp = client.post("http://localhost:1080/login") {
                contentType(ContentType.Application.Json)
                setBody("""{"username": "foo", "password": "bar"}""")
            }

            // these handy matchers come from the kotest-assertions-ktor module
            resp.shouldHaveStatus(HttpStatusCode.Accepted)
            resp.shouldHaveHeader("X-Test", "foo")
        }
    }
}