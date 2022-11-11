package id.tisnahadiana.githubapi.api

import id.tisnahadiana.githubapi.data.model.DetailUserResponse
import id.tisnahadiana.githubapi.data.model.User
import id.tisnahadiana.githubapi.data.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("search/users")
    @Headers("Authorization: token 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")
    fun getSearchUsers(
        @Query("q") query: String
    ): Call<UserResponse>

    @GET("users/{username}")
    @Headers("Authorization: token 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")
    fun getUserDetail(
        @Path("username") username: String
        ): Call<DetailUserResponse>

    @GET("users/{username}/followers")
    @Headers("Authorization: token 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")
    fun getFollowers(
        @Path("username") username: String

    ): Call<ArrayList<User>>

    @GET("users/{username}/following")
    @Headers("Authorization: token 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")
    fun getFollowing(
        @Path("username") username: String

    ): Call<ArrayList<User>>

}