package za.co.absa.absatask.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import za.co.absa.absatask.R
import za.co.absa.absatask.ui.adapter.FactPagerAdapter

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createViewPagerWithTabs()
    }

    private fun createViewPagerWithTabs() {
        val pagerAdapter = FactPagerAdapter(this)
        viewPager.adapter = pagerAdapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            val tabNames = listOf(getString(R.string.trivia_fact), getString(R.string.date_fact))
            tab.text = tabNames[position]
        }.attach()
    }
}