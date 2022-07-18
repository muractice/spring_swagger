package com.example.study_record

import org.springframework.test.web.servlet.ResultActions

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath

class FixtureUser {
    def static assertUserList(ResultActions results){
        results.andExpect(jsonPath('$.users[0].name').value('太郎'))
        results.andExpect(jsonPath('$.users[0].address').value('東京'))
        results.andExpect(jsonPath('$.users[1].name').value('二郎'))
        results.andExpect(jsonPath('$.users[1].address').value('名古屋'))
        results.andExpect(jsonPath('$.users[2].name').value('三郎'))
        results.andExpect(jsonPath('$.users[2].address').value('大阪'))
    }
}
