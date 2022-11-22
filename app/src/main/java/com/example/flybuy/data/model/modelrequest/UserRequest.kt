package com.example.flybuy.data.model.modelrequest


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UserRequest(
    /**
    @SerializedName("address")
    val address: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("password")
    val password: String,
    */


    /**
    {
    "firstName": "Martin",
    "lastName": "W",
    "email": "martin@gmail.com",
    "phone": "0712345678",
    "password": "1234",
    "username": "ken"
    }
     */
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("username")
    val username: String,

) : Serializable