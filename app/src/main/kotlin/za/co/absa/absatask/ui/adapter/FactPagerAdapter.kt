package za.co.absa.absatask.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import za.co.absa.absatask.ui.date.DateFragment
import za.co.absa.absatask.ui.trivia.TriviaFragment

class FactPagerAdapter(
    fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return if (position == 0) TriviaFragment() else DateFragment()
    }
}