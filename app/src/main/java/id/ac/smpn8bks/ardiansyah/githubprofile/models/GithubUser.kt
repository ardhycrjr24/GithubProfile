package id.ac.smpn8bks.ardiansyah.githubprofile.models

import com.google.gson.annotations.SerializedName

data class GithubUser(

	@SerializedName("login")
	val login: String,

	@SerializedName("name")
	val name: String,

	@SerializedName("avatar_url")
	val avatarUrl: String,

	@SerializedName("bio")
	val bio: String?,

	@SerializedName("followers")
	val followers: Int,

	@SerializedName("following")
	val following: Int,

	@SerializedName("public_repos")
	val publicRepos: Int,

	@SerializedName("location")
	val location: String?,

	@SerializedName("company")
	val company: String?,

	@SerializedName("email")
	val email: String?
)