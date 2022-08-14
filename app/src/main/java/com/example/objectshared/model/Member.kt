package com.example.objectshared.model

import java.io.Serializable

class Member(var name:String,var age:String):Serializable {

    override open fun toString(): String {
        return "Member{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}'
    }
}