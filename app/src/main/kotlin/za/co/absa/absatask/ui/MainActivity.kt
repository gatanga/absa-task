package za.co.absa.absatask.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import za.co.absa.absatask.R
import za.co.absa.absatask.databinding.ActivityMainBinding
import za.co.absa.absatask.ui.adapter.FactPagerAdapter

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        createViewPagerWithTabs()
    }

    private fun createViewPagerWithTabs() {
        val pagerAdapter = FactPagerAdapter(this)
        binding.viewPager.adapter = pagerAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            val tabNames = listOf(getString(R.string.trivia_fact), getString(R.string.date_fact))
            tab.text = tabNames[position]
        }.attach()
    }
}