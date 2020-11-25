package ru.endroad.rosatom.view.monitoring.widget

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class WidgetAdapter : RecyclerView.Adapter<WidgetViewHolder>() {

	companion object {

		const val WIDGET_ITEM = 1
	}

	var items: List<WidgetItem> = listOf()
		set(value) {
			field = value
			notifyDataSetChanged()
		}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WidgetViewHolder =
		WidgetViewHolder(parent)

	override fun onBindViewHolder(holder: WidgetViewHolder, position: Int) {
		holder.bind(items[position])
	}

	override fun getItemViewType(position: Int): Int =
		WIDGET_ITEM

	override fun getItemCount(): Int =
		items.size
}