package ru.endroad.rosatom.view.order.adapter

import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_order_for_execution.view.*
import ru.endroad.component.common.inflate
import ru.endroad.rosatom.R
import ru.endroad.server.orders.entity.Order
import ru.endroad.server.orders.entity.Priority

class OrderViewHolder(parent: ViewGroup, private val onOrderClick: (Order) -> Unit) :
	RecyclerView.ViewHolder(parent.inflate(R.layout.item_order_for_execution)) {

	fun bind(item: Order) {
		itemView.setOnClickListener { onOrderClick(item) }
		itemView.bind(item)
	}

	private fun View.bind(order: Order) {
		order_title.text = order.titleText
		order_priority.imageTintList = context.getColorStateList(order.colorPriorityRes)
		order_priority.isVisible = order.priority != Priority.LOW
	}

	private val Order.colorPriorityRes: Int
		get() = when (priority) {
			Priority.CRITICAL -> R.color.orange_700
			Priority.HIGH     -> R.color.blue_500
			Priority.MEDIUM   -> R.color.gray_50
			Priority.LOW      -> R.color.gray_50
		}
}