package id.ac.smpn8bks.ardiansyah.githubprofile.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import id.ac.smpn8bks.ardiansyah.githubprofile.databinding.ActivityMainBinding
import id.ac.smpn8bks.ardiansyah.githubprofile.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ambil ViewModel
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        // observe data dari ViewModel
        viewModel.githubUser.observe(this) { user ->
            user?.let {
                binding.tvName.text = it.name ?: "-"
                binding.tvBio.text = it.bio ?: "-"
                binding.tvFollowers.text = "Followers: ${it.followers}"
                binding.tvFollowing.text = "Following: ${it.following}"

                Glide.with(this)
                    .load(it.avatarUrl)
                    .into(binding.ivAvatar)
            }
        }

        // tombol search oke
        binding.btnSearch.setOnClickListener {

            val username = binding.etUsername.text.toString()

            if (username.isEmpty()) {
                Toast.makeText(this, "Masukkan username", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.searchUser(username)
            }
        }
    }
}