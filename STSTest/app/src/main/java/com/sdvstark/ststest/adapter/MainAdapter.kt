package com.sdvstark.ststest.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sdvstark.ststest.R
import com.sdvstark.ststest.abstraction.EntityInfoModel
import com.sdvstark.ststest.util.inflate
import kotlinx.android.synthetic.main.view_holder_info_model.view.*

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private var mDataHolder: List<EntityInfoModel> = emptyList()

    lateinit var onItemClickListener: (EntityInfoModel) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.view_holder_info_model)).apply {
            itemView.setOnClickListener {
                onItemClickListener(mDataHolder[adapterPosition])
            }
        }
    }

    override fun getItemCount(): Int {
        return mDataHolder.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mDataHolder[position])
    }

    fun update(list: List<EntityInfoModel>) {
        mDataHolder = list
        notifyDataSetChanged()
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val modelDescTv: TextView = view.modelDescTv

        fun bind(model: EntityInfoModel) {
            modelDescTv.text = model.shortDescription
        }
    }
}