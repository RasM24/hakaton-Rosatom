package ru.endroad.rosatom.view.monitoring.widget

import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.widget_item.view.*
import ru.endroad.component.common.inflate
import ru.endroad.rosatom.R
import ru.endroad.rosatom.entity.SensorData

class WidgetViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.widget_item)) {

	fun bind(item: WidgetItem) {
		itemView.widget_icon.setImageResource(item.sensorData.type.iconRes)
		itemView.widget_name.setText(item.sensorData.type.sensorName)
		itemView.widget_value.setSensorValue(item.sensorData)
		itemView.widget_threshold.text = item.sensorData.thresholdText
	}

	private fun TextView.setSensorValue(sensorData: SensorData) {
		val value = sensorData.value
		val measure = resources.getString(sensorData.type.measureRes)
		text = "$value $measure"
	}

	private val SensorData.thresholdText: String?
		get() = when {
			thresholdMax != null && thresholdMin != null -> "$thresholdMin | $thresholdMax"
			thresholdMax != null && thresholdMin == null -> "критическое значение: $thresholdMax"
			thresholdMax == null && thresholdMin != null -> "критическое значение: $thresholdMin"
			else                                         -> null
		}

}

