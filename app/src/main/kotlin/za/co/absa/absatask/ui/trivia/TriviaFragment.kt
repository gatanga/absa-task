package za.co.absa.absatask.ui.trivia

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_trivia.*
import kotlinx.android.synthetic.main.fragment_trivia.view.*
import za.co.absa.absatask.R
import za.co.absa.absatask.ui.base.BaseFactFragment

@AndroidEntryPoint
class TriviaFragment : BaseFactFragment() {

    private val viewModel: TriviaViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObservers(viewModel = viewModel)
        setUpListeners(button = btnSearch, view = view)
        etNumberInput.setText(generateRandomNumber())
        addRandomNumberGenerationListeners()
    }

    private fun addRandomNumberGenerationListeners() {
        btnGenerateNumber.setOnClickListener {
            etNumberInput.setText(generateRandomNumber())
        }
    }

    //FIXME -- Should create a usecase for this but I do not have time
    private fun generateRandomNumber() =
        (0..MAX_RANDOM_VALUE).random().toString()

    override fun getLayoutId() = R.layout.fragment_trivia

    override fun onSearchClicked(view: View) {
        viewModel.getTriviaFact(number = view.etNumberInput.text.toString())
    }

    override fun displayFactText(fact: String) {
        tvSearchResult.text = fact
    }

    override fun showHideLoading() {
        //TODO Add loading indicators
    }

    companion object {
        private const val MAX_RANDOM_VALUE = 100
    }
}