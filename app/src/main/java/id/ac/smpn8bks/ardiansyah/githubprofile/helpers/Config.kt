package id.ac.smpn8bks.ardiansyah.githubprofile.helpers

import id.ac.smpn8bks.ardiansyah.githubprofile.BuildConfig

class Config {
    companion object {
        const val SPLASH_SCREEN_DELAY: Long = 3000

        const val BASE_URL = "https://api.github.com/"

        const val DEFAULT_USER_LOGIN = "ardhycrjr24"

        // 🔐 AMBIL DARI BuildConfig (bukan hardcode)
        val TOKEN = "Bearer ${BuildConfig.GITHUB_TOKEN}"
    }
}