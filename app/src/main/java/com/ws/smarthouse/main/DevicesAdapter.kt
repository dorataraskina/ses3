package com.ws.smarthouse

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ws.smarthouse.main.RecyclerViewClickListener


class DevicesAdapter(
    private val devices: Array<String>,
    private val onClickListener: RecyclerViewClickListener
) : RecyclerView.Adapter<DevicesAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById<View>(R.id.textView2) as TextView
        val imageView: ImageView = view.findViewById<View>(R.id.imageView2) as ImageView

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_device, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.textView.text = devices.get(position)
        val resources = viewHolder.itemView.context.resources
        val resourceId = resources.getIdentifier(
            "device$position", "drawable",
            viewHolder.itemView.context.packageName
        )
        viewHolder.imageView.setImageResource(resourceId)
        viewHolder.itemView.setOnClickListener(View.OnClickListener { view ->
            onClickListener.recyclerViewListClicked(
                view,
                viewHolder.layoutPosition
            )
        })
    }

    override fun getItemCount(): Int = devices.size
}