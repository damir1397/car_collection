package kg.damir.carollection.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kg.damir.carollection.R
import kg.damir.carollection.databinding.FragmentCarsListBinding
import kg.damir.carollection.presentation.adapter.CarListAdapter
import kg.damir.carollection.presentation.factory.ViewModelFactory

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

    private val carListAdapter = CarListAdapter()
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
        val usersByLogin = viewModel.getUsersByLogin("UserCar")
        if ((usersByLogin?.id ?: 0) <= 0){
            viewModel.addDefaultUser()
        }
        viewModel.getCarList.observe(viewLifecycleOwner) { searchResults ->
            carListAdapter.submitList(searchResults)
        }
        binding.searchView.isIconified = false
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                searchDatabase(newText.orEmpty())
                return true
            }
        })
    }

    private fun searchDatabase(query: String) {
        val searchQuery = "%$query%"
        viewModel.searchDatabase(searchQuery)

        viewModel.searchDatabase(searchQuery).observe(this) {
            carListAdapter.submitList(it)
        }
    }
    private fun initCarAdapter() {
        val recycleViewMenu = binding.carRecycleView
        recycleViewMenu.adapter = carListAdapter
    }
}