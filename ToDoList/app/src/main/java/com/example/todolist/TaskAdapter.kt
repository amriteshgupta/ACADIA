import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import com.example.todolist.R
import com.example.todolist.TodoModel
import com.example.todolist.UpdateAndDelete

class TaskAdapter(context: Context, toDoList: MutableList<TodoModel>) : BaseAdapter() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var itemList = toDoList
    private var updateAndDelete: UpdateAndDelete = context as UpdateAndDelete

    override fun getCount(): Int {
        return itemList.size
    }

    override fun getItem(position: Int): Any {
        return itemList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val todoItem: TodoModel = itemList[position]
        val UID: String? = todoItem.UID
        val itemTextData: String = todoItem.itemDataText ?: ""
        val done: Boolean = todoItem.done ?: false

        val view: View
        val viewHolder: ListViewHolder

        if (convertView == null) {
            view = inflater.inflate(R.layout.item_task, null)
            viewHolder = ListViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ListViewHolder
        }
        viewHolder.textLabel.text = itemTextData
        viewHolder.isDone.isChecked = done

        viewHolder.isDone.setOnClickListener {
            UID?.let {
                updateAndDelete.modifyItem(it, !done)
            }
        }
        viewHolder.isDeleted.setOnClickListener {
            UID?.let {
                updateAndDelete.onItemDelete(it)
            }
        }

        return view
    }

    private class ListViewHolder(row: View?) {
        val textLabel: TextView = row!!.findViewById(R.id.textViewTitle) as TextView
        val isDone: CheckBox = row!!.findViewById(R.id.checkbox) as CheckBox
        val isDeleted: ImageButton = row!!.findViewById(R.id.close) as ImageButton
    }
}
