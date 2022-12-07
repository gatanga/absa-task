package za.co.absa.absatask.ui.date

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.google.android.material.datepicker.MaterialDatePicker
import dagger.hilt.android.AndroidEntryPoint
import za.co.absa.absatask.R
import za.co.absa.absatask.databinding.FragmentDateBinding
import za.co.absa.absatask.ui.base.BaseFactFragment
import java.util.*

@AndroidEntryPoint
class DateFragment : BaseFactFragment() {

    private val viewModel: DateViewModel by viewModels()
    private lateinit var binding: FragmentDateBinding
    private var day = 1
    private var month = 1
    private val datePicker by lazy {
        MaterialDatePicker
            .Builder
            .datePicker()
            .setTitleText(getString(R.string.choose_day_month_prompt_text))
            .build()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObservers(viewModel = viewModel)
        setUpListeners(button = binding.btnSearch)
        addDateListeners()
    }

    private fun addDateListeners() {
        binding.btnChooseDateMonth.setOnClickListener {
            showDayMonthChooser()
        }
        datePicker.addOnPositiveButtonClickListener {
            (Calendar.getInstance(TimeZone.getTimeZone("UTC"))).also { calendar ->
                calendar.time = Date(it)
                month = calendar.get(Calendar.MONTH) + 1
                day = calendar.get(Calendar.DAY_OF_MONTH)
                binding.tvDate.text =
                    getString(
                        R.string.month_day_values,
                        month.properDateDisplay(),
                        day.properDateDisplay()
                    )
            }
        }
    }

    private fun showDayMonthChooser() {
        datePicker.show(
            requireActivity().supportFragmentManager,
            getString(R.string.choose_day_month_prompt_text)
        )
    }

    override fun createBinding(inflater: LayoutInflater, container: ViewGroup?): View {
        binding = FragmentDateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onSearchClicked() {
        viewModel.getDateFact(month = month.toString(), day = day.toString())
    }

    override fun displayFactText(fact: String) {
        binding.tvSearchResult.text = fact
    }

    override fun showHideLoading() {
        //TODO Add loading indicators
    }

    private fun Int.properDateDisplay() =
        if (this < 10) "0$this" else "$this"
}