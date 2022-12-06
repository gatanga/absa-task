package za.co.absa.absatask.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.google.android.material.button.MaterialButton
import za.co.absa.absatask.ui.state.DataState

abstract class BaseFactFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(getLayoutId(), container, false)
    }

    protected abstract fun getLayoutId(): Int

    protected fun setUpListeners(button: MaterialButton, view: View) {
        button.setOnClickListener {
            onSearchClicked(view)
        }
    }

    protected fun setUpObservers(viewModel: BaseViewModel<*>) {
        val nameObserver = Observer<Any?> { result ->
            when (result) {
                is DataState.Loading -> {
                    showHideLoading()
                }
                is DataState.Success<*> -> {
                    displayFactText(result.value as String)
                }
            }
        }

        viewModel.liveData.observe(viewLifecycleOwner, nameObserver)
    }

    protected abstract fun displayFactText(fact: String)

    protected abstract fun showHideLoading()

    protected abstract fun onSearchClicked(view: View)
}