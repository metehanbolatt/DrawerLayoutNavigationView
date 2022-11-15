package com.metehanbolat.drawerlayoutnav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import com.metehanbolat.drawerlayoutnav.databinding.ActivityMainBinding
import com.metehanbolat.drawerlayoutnav.databinding.NavHeaderBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navHeaderBinding: NavHeaderBinding

    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        navHeaderBinding = NavHeaderBinding.inflate(LayoutInflater.from(binding.navigationView.context))

        toggle = ActionBarDrawerToggle(this, binding.homeDrawerLayout, R.string.open, R.string.close)
        binding.homeDrawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.navigationView.addHeaderView(navHeaderBinding.root)

        navHeaderBinding.profileCard.setOnClickListener {
            println("Profile Card Clicked")
        }

        navHeaderBinding.nameText.setOnClickListener {
            println("Name Text Clicked")
        }

        binding.navigationView.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.item1 -> { println("Item 1 Clicked") }
                R.id.item2 -> { println("Item 2 Clicked") }
                R.id.settings -> { println("Settings Clicked") }
                R.id.signOut -> { println("Sign Out Clicked")}
            }
            true
        }

        binding.button.setOnClickListener {
            binding.homeDrawerLayout.open()
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}