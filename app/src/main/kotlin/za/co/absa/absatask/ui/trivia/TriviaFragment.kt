package za.co.absa.absatask.ui.trivia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import za.co.absa.absatask.databinding.FragmentTriviaBinding
import za.co.absa.absatask.ui.base.BaseFactFragment

@AndroidEntryPoint
class TriviaFragment : BaseFactFragment() {

    private val viewModel: TriviaViewModel by viewModels()
    private lateinit var binding: FragmentTriviaBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObservers(viewModel = viewModel)
        setUpListeners(button = binding.btnSearch)
        binding.etNumberInput.setText(generateRandomNumber())
        addRandomNumberGenerationListeners()
    }

    private fun addRandomNumberGenerationListeners() {
        binding.btnGenerateNumber.setOnClickListener {
            binding.etNumberInput.setText(generateRandomNumber())
        }
    }

    //FIXME -- Should create a usecase for this but I do not have time
    private fun generateRandomNumber() =
        (0..MAX_RANDOM_VALUE).random().toString()

    override fun createBinding(inflater: LayoutInflater, container: ViewGroup?): View {
        binding = FragmentTriviaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onSearchClicked() {
        viewModel.getTriviaFact(number = binding.etNumberInput.text.toString())
    }

    override fun displayFactText(fact: String) {
        binding.tvSearchResult.text = fact
    }

    override fun showHideLoading() {
        //TODO Add loading indicators
    }

    companion object {
        private const val MAX_RANDOM_VALUE = 100
    }
}