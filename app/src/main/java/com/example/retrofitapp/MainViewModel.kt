package com.example.retrofitapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitapp.model.Post
import com.example.retrofitapp.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository):ViewModel()
{
    val myResponse:MutableLiveData<Response<Post>> =MutableLiveData()
    val myResponse2:MutableLiveData<Response<Post>> =MutableLiveData()
    val myCustomPost:MutableLiveData<Response<List<Post>>> =MutableLiveData()
    val myCustomPost2:MutableLiveData<Response<List<Post>>> =MutableLiveData()

    fun pushPost(post: Post)
    {
        viewModelScope.launch {
            val response:Response<Post> =repository.pushPost(post)
            myResponse.value=response
        }
    }
    fun pushPost2(userId: Int, id:Int, title:String, body:String)
    {
        viewModelScope.launch{
            val response: Response<Post> = repository.pushPost2(userId, id, title, body)
            myResponse.value = response
        }
    }

    fun getPost()
    {
        viewModelScope.launch{
            val response: Response<Post> =repository.getPost()
            myResponse.value=response
        }
    }
    fun getPost2(number:Int)
    {
        viewModelScope.launch {
            val response:Response<Post> =repository.getPost2(number)
            myResponse2.value=response
        }
    }
    fun getCustomPost(userId:Int,sort:String,order:String)
    {
        viewModelScope.launch {
            val response:Response<List<Post>> =repository.getCustomPost(userId,sort,order)
            myCustomPost.value=response
        }
    }
    fun getCustomPost2(userId:Int,options:Map<String,String>)
    {
        viewModelScope.launch {
            val response:Response<List<Post>> =repository.getCustomPost2(userId,options)
            myCustomPost2.value=response
        }
    }
}