package ru.endroad.rosatom.view.order.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_order_for_execution.view.order_title
import kotlinx.android.synthetic.main.order_item_spectator.view.*
import ru.endroad.component.common.inflate
import ru.endroad.rosatom.R
import ru.endroad.server.orders.entity.Order
import ru.endroad.server.orders.entity.Performer
import ru.endroad.server.orders.entity.Priority

class SpectatorOrderViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.order_item_spectator)) {

	fun bind(item: Order) {
		itemView.bind(item)
	}

	private fun View.bind(order: Order) {
		order_title.text = order.titleText
		order_priority.text = order.priorityText
		order_performer.text = order.performerText
	}

	private val Order.priorityText: String
		get() = when (priority) {
			Priority.CRITICAL -> "Срочно"
			Priority.HIGH -> "Высокий"
			Priority.MEDIUM -> "Обычный"
			Priority.LOW -> "Низкий"
		}

	private val Order.performerText: String
		get() = when (performer) {
			Performer.All -> "Все"
			is Performer.Employer -> "Работник"
			is Performer.Group -> "Группа"
		}
}