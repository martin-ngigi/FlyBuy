package com.example.flybuy.data.model.modelresponse

import com.example.flybuy.data.model.modelrequest.Name
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UserResponse(
	/**
	@SerializedName("address")
	val address: String,
	@SerializedName("email")
	val email: String,
	@SerializedName("_id")
	val id: String,
	@SerializedName("name")
	val name: String,
	@SerializedName("password")
	val password: String,
	@SerializedName("type")
	val type: String,
	@SerializedName("__v")
	val v: Int
	*/


	/**
	 * {
	"id": 1,
	"firstName": "Martin",
	"lastName": "W",
	"email": "martin@gmail.com",
	"phone": "0712345678",
	"password": "1234",
	"username": "ken"
	}
	 */
	@SerializedName("id")
	val id: Int,
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