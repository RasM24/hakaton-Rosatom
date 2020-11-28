package ru.endroad.rosatom.view.order.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.endroad.server.orders.entity.Order

class SpectatorOrdersAdapter : RecyclerView.Adapter<SpectatorOrderViewHolder>() {

	private companion object {

		const val ORDER_VIEW_TYPE = 1
	}

	var items: List<Order> = listOf()
		set(value) {
			field = value
			notifyDataSetChanged()
		}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpectatorOrderViewHolder =
		SpectatorOrderViewHolder(parent)

	override fun onBindViewHolder(holder: SpectatorOrderViewHolder, position: Int) {
		holder.bind(items[position])
	}

	override fun getItemViewType(position: Int): Int = ORDER_VIEW_TYPE

	override fun getItemCount(): Int = items.size
}