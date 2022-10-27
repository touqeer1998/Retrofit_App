package com.example.retrofitapp.api

import android.graphics.BitmapFactory.Options
import com.example.retrofitapp.model.Post
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface SimpleApi
{
    @GET(value="posts/1")
    suspend fun getPost():Response<Post>
    @GET(value = "posts/{postNumber}")
    suspend fun getPost2(
        @Path(value = "postNumber")number:Int
    ):Response<Post>
    @GET(value ="posts")
    suspend fun getCustomPost(
        @Query(value = "userId")userId:Int,
        @Query(value="_sort")sort:String,
        @Query(value = "_order")order:String
    ):Response<List<Post>>
    @GET(value="posts")
    suspend fun getCustomPost2(
        @Query(value="userId")userId: Int,
        @QueryMap options:Map<String,String>
    ):Response<List<Post>>
    @POST(value ="posts")
    suspend fun pushPost(
        @Body post:Post
    ):Response<Post>
    @FormUrlEncoded
    @POST("posts")
    suspend fun pushPost2(
        @Field("userId") userId:Int,
        @Field(value="id") id:Int,
        @Field("title") title:String,
        @Field("body") body:String,
    ):Response<Post>
}