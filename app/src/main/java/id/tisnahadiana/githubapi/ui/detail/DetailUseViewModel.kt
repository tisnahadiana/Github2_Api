package id.tisnahadiana.githubapi.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.tisnahadiana.githubapi.api.RetrofitClient
import id.tisnahadiana.githubapi.data.model.DetailUserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailUseViewModel: ViewModel() {
    val user = MutableLiveData<DetailUserResponse>()

    fun setUserDetail(username: String){
        RetrofitClient.apiInstance
            .getUserDetail(username)
            .enqueue(object : Callback<DetailUserResponse>{
                override fun onResponse(
                    call: Call<DetailUserResponse>,
                    response: Response<DetailUserResponse>
                ) {
                    if (response.isSuccessful){
                        user.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<DetailUserResponse>, t: Throwable) {
                    t.message?.let { Log.d("Failure", it) }
                }

            })
    }
    fun getUserDetail(): LiveData<DetailUserResponse>{
        return user
    }
}