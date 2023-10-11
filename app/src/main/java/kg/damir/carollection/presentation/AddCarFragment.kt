package kg.damir.carollection.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kg.damir.carollection.R
import kg.damir.carollection.databinding.FragmentAddCarBinding

/**
 * A simple [Fragment] subclass.
 * Use the [AddCarFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddCarFragment : Fragment() {
    private var _binding: FragmentAddCarBinding? = null
    private val binding: FragmentAddCarBinding
        get() = _binding ?: throw  RuntimeException("FragmentAddCarBinding")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddCarBinding.inflate(inflater, container, false)

        return binding.root
    }

}