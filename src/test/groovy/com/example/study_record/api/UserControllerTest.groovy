package com.example.study_record.api

import com.example.study_record.FixtureUser
import groovyx.net.http.RESTClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Unroll

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import spock.lang.Specification

@Unroll
@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest extends Specification {

    @Autowired
    MockMvc mockMvc;

    def 'Post User'() {
        when:
        def results = mockMvc.perform(
                post("/user")
        )

        then:
        results.andExpect(status().isOk())
        results.andExpect(jsonPath('$.user.name').value('四郎'))
        results.andExpect(jsonPath('$.user.address').value('福岡'))
    }

    def 'Get Users'() {
        when:
        def results = mockMvc.perform(
                get("/users")
        )

        then:
        results.andExpect(status().isOk())
        FixtureUser.assertUserList(results)

//        results.andExpect(jsonPath('$.users[0].name').value('太郎'))
//        results.andExpect(jsonPath('$.users[0].address').value('東京'))
//        results.andExpect(jsonPath('$.users[1].name').value('二郎'))
//        results.andExpect(jsonPath('$.users[1].address').value('名古屋'))
//        results.andExpect(jsonPath('$.users[2].name').value('三郎'))
//        results.andExpect(jsonPath('$.users[2].address').value('大阪'))
    }

    def 'Get User'() {
        when:
        def results = mockMvc.perform(get("/user/" + userId))

        then:
        results.andExpect(status().isOk())
        results.andExpect(jsonPath('$.user.name').value( name ))
        results.andExpect(jsonPath('$.user.address').value( address ))

        where:
        userId | name   | address
        1      | "太郎"  | "東京"
    }


//    static String testURL = "http://localhost:8080"
//    RESTClient restClient = new RESTClient(testURL);

//    def 'Post User'(){
//        given:
//        def requestBody = [name:"四郎", adress:"東京"]
//
//        when:
//        def response = restClient.post(path:'/user', body: requestBody, requestContentType:'application/json')
//
//        then:
//        response.status == 200
//        response.responseData.user.name == "四郎"
//    }
}
