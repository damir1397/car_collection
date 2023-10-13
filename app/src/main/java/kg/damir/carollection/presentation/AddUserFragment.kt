package kg.damir.carollection.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kg.damir.carollection.R
import kg.damir.carollection.databinding.FragmentAddUserBinding
import kg.damir.carollection.databinding.FragmentSettingsBinding


class AddUserFragment : Fragment() {
    private var _binding: FragmentAddUserBinding? = null
    private val binding: FragmentAddUserBinding
        get() = _binding ?: throw  RuntimeException("FragmentAddUserBinding")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddUserBinding.inflate(inflater, container, false)

        return binding.root
    }
}