package id.ac.smpn8bks.ardiansyah.githubprofile.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.smpn8bks.ardiansyah.githubprofile.helpers.Config
import id.ac.smpn8bks.ardiansyah.githubprofile.models.GithubUser
import id.ac.smpn8bks.ardiansyah.githubprofile.services.GithubUserService
import id.ac.smpn8bks.ardiansyah.githubprofile.services.ServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    private val _githubUser = MutableLiveData<GithubUser>()
    val githubUser: LiveData<GithubUser> = _githubUser

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun searchUser(username: String) {

        _isLoading.value = true

        val service = ServiceBuilder.buildService(GithubUserService::class.java)

        // 🔥 pakai token
        val request = service.getUser(
            Config.TOKEN,
            username
        )

        request.enqueue(object : Callback<GithubUser> {

            override fun onResponse(
                call: Call<GithubUser>,
                response: Response<GithubUser>
            ) {
                _isLoading.value = false

                if (response.isSuccessful) {
                    _githubUser.value = response.body()
                }
            }

            override fun onFailure(call: Call<GithubUser>, t: Throwable) {
                _isLoading.value = false
            }
        })
    }
}