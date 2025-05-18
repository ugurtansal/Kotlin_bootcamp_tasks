import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.R
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ugurtansal.task_7.data.entity.ToDo
import com.ugurtansal.task_7.databinding.FragmentMainBinding
import com.ugurtansal.task_7.ui.adapter.ToDoAdapter
import com.ugurtansal.task_7.utils.pass

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentMainBinding.inflate(inflater, container, false)
        val toDoList = listOf(
            ToDo(1, "Task 1"),
            ToDo(2, "Task 2"),
            ToDo(3, "Task 3")
        )

        val toDoAdapter = ToDoAdapter(requireContext(), toDoList);
        binding.toDoRv.adapter= toDoAdapter

        binding.toDoRv.layoutManager= StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)

        binding.cvAdd.setOnClickListener {
            Navigation.pass(it, com.ugurtansal.task_7.R.id.main_to_create)
        }

        return binding.root
    }
}
