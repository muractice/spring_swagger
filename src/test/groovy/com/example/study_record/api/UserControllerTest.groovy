package com.example.study_record.api

import groovyx.net.http.RESTClient
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

//@Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.7.1' )
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest extends Specification {
    static String testURL = "http://localhost:8080"

    RESTClient restClient = new RESTClient(testURL);

    def 'Post User'(){
        given:
//        def requestBody = [name:"四郎", adress:"東京"]
        def requestBody = []

        when:
        def response = restClient.post(path:'/user', body: requestBody, requestContentType:'application/json')

        then:
        response.status == 200
        response.responseData.user.name == "四郎"
    }
}
