package id.ac.smpn8bks.ardiansyah.githubprofile.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import id.ac.smpn8bks.ardiansyah.githubprofile.databinding.ActivitySplashScreenBinding
import id.ac.smpn8bks.ardiansyah.githubprofile.helpers.Config

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // aktifkan viewBinding
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // delay lalu pindah ke MainActivity
        Handler(Looper.getMainLooper()).postDelayed({

            startActivity(Intent(this, MainActivity::class.java))
            finish()

        }, Config.SPLASH_SCREEN_DELAY)
    }
}