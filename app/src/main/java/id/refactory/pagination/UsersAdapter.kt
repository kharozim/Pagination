package id.refactory.pagination

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.refactory.pagination.databinding.ItemUsersBinding
import id.refactory.pagination.models.DataItem

class UsersAdapter(private val context: Context) :
    RecyclerView.Adapter<UsersAdapter.UsersViewHolder>() {

    private var users = listOf<DataItem>()
    fun setData(data: List<DataItem>) {
        users = data
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val viewHolder =
            UsersViewHolder(ItemUsersBinding.inflate(LayoutInflater.from(context), parent, false))
        return viewHolder
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {

        holder.bindData(users[position])

    }

    override fun getItemCount(): Int = users.size


    inner class UsersViewHolder(private val binding: ItemUsersBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(users: DataItem) {
            binding.Name.text = users.firstName + " " + users.lastName
            binding.tvEmail.text = users.email
            Glide.with(binding.root).load(users.avatar).circleCrop().into(binding.ivImage)
        }
    }

}