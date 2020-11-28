package ru.endroad.rosatom.view.order.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_order_for_execution.view.*
import ru.endroad.component.common.inflate
import ru.endroad.rosatom.R
import ru.endroad.server.orders.entity.Order

class OrderViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.item_order_for_execution)) {

	fun bind(item: Order) {
		itemView.bind(item)
	}

	private fun View.bind(order: Order) {
		order_title.text = order.titleText
	}
}