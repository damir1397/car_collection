package kg.damir.carollection.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
        get() = _binding ?: throw RuntimeException("FragmentCarsListBinding")
    private lateinit var viewModel: ViewModelAdd
    private val carListAdapter = CarListAdapter(requireContext())
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCarsListBinding.inflate(inflater, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addCar.setOnClickListener {
            findNavController().navigate(R.id.action_carsListFragment_to_addCarFragment)
        }
        initCarAdapter()
        val viewModelFactory = ViewModelFactory(requireActivity().application)
        viewModel = ViewModelProvider(this, viewModelFactory)[ViewModelAdd::class.java]

        viewModel.getCarList.observe(viewLifecycleOwner) {
            carListAdapter.submitList(it)
        }
    }


    private fun initCarAdapter() {
        val recycleViewMenu = binding.carRecycleView
        recycleViewMenu.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        recycleViewMenu.adapter = carListAdapter
    }


}