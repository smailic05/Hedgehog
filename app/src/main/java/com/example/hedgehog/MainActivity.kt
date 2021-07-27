package com.example.hedgehog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.hedgehog.databinding.MainActivityBinding
import com.example.hedgehog.ui.main.MainViewModel
import com.example.hedgehog.ui.main.WebFragment

class MainActivity : AppCompatActivity() {
    val model: MainViewModel by viewModels()
    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setupNavigation()
        model.title.observe(this,{
            supportActionBar?.title=it
        })
    }

    private fun setupNavigation()
    {
        setSupportActionBar(binding.toolbar)
        val host: NavHostFragment = supportFragmentManager
            .findFragmentById(R.id.containerFragment) as NavHostFragment? ?: return
        val navController = host.navController
        binding.bottomNavigationView.setupWithNavController(navController)

    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            val current=supportFragmentManager.findFragmentById(R.id.containerFragment)?.
            childFragmentManager?.fragments?.get(0)
            if (current is WebFragment){
                return if (current.onKeyDown())
                    true
                else
                    super.onKeyDown(keyCode, event)
            }
        }
        return super.onKeyDown(keyCode, event)
    }
}