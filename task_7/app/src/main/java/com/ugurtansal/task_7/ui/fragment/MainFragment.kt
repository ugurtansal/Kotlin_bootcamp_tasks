import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.R
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ugurtansal.task_7.data.entity.ToDo
import com.ugurtansal.task_7.databinding.FragmentMainBinding
import com.ugurtansal.task_7.ui.adapter.ToDoAdapter
import com.ugurtansal.task_7.ui.viewModel.MainViewModel
import com.ugurtansal.task_7.utils.pass
import dagger.hilt.android.AndroidEntryPoint
import kotlin.getValue

@AndroidEntryPoint
class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentMainBinding.inflate(inflater, container, false)

        binding.toDoRv.layoutManager= StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)

        binding.cvAdd.setOnClickListener {
            Navigation.pass(it, com.ugurtansal.task_7.R.id.main_to_create)
        }

        viewModel.toDoList.observe(viewLifecycleOwner){
            val toDoAdapter = ToDoAdapter(requireContext(), it, viewModel);
            binding.toDoRv.adapter= toDoAdapter
        }

        binding.searchView.setOnQueryTextListener (object: android.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String): Boolean {

                viewModel.search(query)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {

                viewModel.search(newText)
                return false
            }

        })

        return binding.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: MainViewModel by viewModels()
        viewModel= tempViewModel
    }




    override fun onResume() {
        super.onResume();
        viewModel.loadTasks();
    }
}
