package kg.damir.carollection.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kg.damir.carollection.R
import kg.damir.carollection.databinding.FragmentAddCarBinding
import kg.damir.carollection.databinding.FragmentCarInformationBinding


/**
 * A simple [Fragment] subclass.
 * Use the [CarInformationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CarInformationFragment : Fragment() {
    private var _binding: FragmentCarInformationBinding? = null
    private val binding: FragmentCarInformationBinding
        get() = _binding ?: throw  RuntimeException("FragmentCarInformationBinding")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCarInformationBinding.inflate(inflater, container, false)

        return binding.root
    }
}