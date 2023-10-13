package kg.damir.carollection.presentation

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kg.damir.carollection.R
import kg.damir.carollection.databinding.FragmentAddCarBinding
import kg.damir.carollection.presentation.factory.ViewModelFactory

/**
 * A simple [Fragment] subclass.
 * Use the [AddCarFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddCarFragment : Fragment() {

    private lateinit var viewModel: ViewModelAdd

    private var _binding: FragmentAddCarBinding? = null
    private val binding: FragmentAddCarBinding
        get() = _binding ?: throw RuntimeException("FragmentAddCarBinding == null")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddCarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModelFactory = ViewModelFactory(requireActivity().application)
        viewModel = ViewModelProvider(this, viewModelFactory)[ViewModelAdd::class.java]
        launchAddMode()
        observeViewModel()
    }

    private fun launchAddMode() {
        binding.buttonAddCar.setOnClickListener {
            viewModel.addCar(
                binding.etCarName.text.toString(),
                PHOTO_URI,
                binding.etYear.text.toString(),
                binding.etEngineCapacity.text.toString(),
            )
        }
        binding.choice.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, PICK_IMAGE_REQUEST_CODE)
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            // Получите выбранное изображение из данных Intent и выполните необходимые действия
            val selectedImageUri = data?.data
            if (selectedImageUri != null) {
                PHOTO_URI=selectedImageUri.toString()
                binding.setPhoto.setImageURI(selectedImageUri)
            }
        }
    }


    private fun observeViewModel() {
        viewModel.shouldCloseScreen.observe(viewLifecycleOwner) {
            findNavController().navigate(R.id.action_addCarFragment_to_carsListFragment)
        }
        viewModel.errorInputCarName.observe(viewLifecycleOwner) {
            val message = if (it) {
                getString(R.string.error_input_car_name)
            } else {
                null
            }
            binding.etCarName.error = message
        }
        viewModel.errorInputYearIssue.observe(viewLifecycleOwner) {
            val message = if (it) {
                getString(R.string.error_input_year_issue)
            } else {
                null
            }
            binding.etYear.error = message
        }

        viewModel.errorInputEngineCapacity.observe(viewLifecycleOwner) {
            val message = if (it) {
                getString(R.string.error_input_engine_capacity)
            } else {
                null
            }
            binding.etEngineCapacity.error = message
        }
        viewModel.errorInputPhoto.observe(viewLifecycleOwner) {
            val message = if (it) {
                getString(R.string.error_input_photo)
            } else {
                null
            }
            Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        }

    }

    companion object {
        const val PICK_IMAGE_REQUEST_CODE = 1
        var PHOTO_URI: String? = null
    }

}