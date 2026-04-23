package id.ac.smpn8bks.ardiansyah.githubprofile.services

import id.ac.smpn8bks.ardiansyah.githubprofile.models.GithubUser
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface GithubUserService {

    @GET("users/{login}")
    fun getUser(
        @Header("Authorization") token: String,
        @Path("login") username: String
    ): Call<GithubUser>

}