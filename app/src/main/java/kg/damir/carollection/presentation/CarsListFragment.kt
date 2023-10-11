package kg.damir.carollection.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kg.damir.carollection.R
import kg.damir.carollection.databinding.FragmentCarInformationBinding
import kg.damir.carollection.databinding.FragmentCarsListBinding

/**
 * A simple [Fragment] subclass.
 * Use the [CarsListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CarsListFragment : Fragment() {
    private var _binding: FragmentCarsListBinding? = null
    private val binding: FragmentCarsListBinding
        get() = _binding ?: throw  RuntimeException("FragmentCarsListBinding")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCarsListBinding.inflate(inflater, container, false)

        return binding.root
    }
}