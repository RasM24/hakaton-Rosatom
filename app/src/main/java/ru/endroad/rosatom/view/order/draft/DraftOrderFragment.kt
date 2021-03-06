package ru.endroad.rosatom.view.order.draft

import com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_SHORT
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.order_draft_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.endroad.component.common.MviFragment
import ru.endroad.rosatom.R

class DraftOrderFragment : MviFragment<DraftOrderScreenState, DraftOrderScreenEvent>() {

	override val viewModel by viewModel<DraftOrderViewModel>()
	override val layout = R.layout.order_draft_fragment

	override fun setupViewComponents() {
		setToolbarText(getString(R.string.tab_navigation_order_draft))

		order_draft_voice_input.setOnClickListener { viewModel.notice(DraftOrderScreenEvent.StartSpeak) }
		order_draft_create.setOnClickListener {
			Snackbar.make(fragment_root, "Заявка создана", LENGTH_SHORT).show()
			viewModel.notice(DraftOrderScreenEvent.Create)
		}
	}

	override fun render(state: DraftOrderScreenState) {
		when (state) {
			is DraftOrderScreenState.Initialized -> render(state)
			is DraftOrderScreenState.RecognitionData -> render(state)
			is DraftOrderScreenState.Recording -> render(state)
			DraftOrderScreenState.StopRecording -> stopRecordingRender()
		}
	}

	private fun render(state: DraftOrderScreenState.RecognitionData) {
		state.draftOrder.run {
			creator?.name?.let(order_draft_input_to::setText)
			executor?.name?.let(order_draft_input_from::setText)
			titleText?.let(order_draft_input_title::setText)
			bodyText?.let(order_draft_input_body::setText)
			deadline?.let(order_draft_input_date::setText)
		}
	}

	private fun render(state: DraftOrderScreenState.Initialized) {
		order_draft_voice_input.setImageResource(R.drawable.ic_microphone)
		order_draft_voice_input.setOnClickListener { viewModel.notice(DraftOrderScreenEvent.StartSpeak) }

		order_draft_input_to.text = null
		order_draft_input_from.text = null
		order_draft_input_title.text = null
		order_draft_input_body.text = null
		order_draft_input_date.text = null
	}

	private fun render(state: DraftOrderScreenState.Recording) {
		order_draft_voice_input.setImageResource(R.drawable.ic_senser_temperature)
		order_draft_voice_input.setOnClickListener { viewModel.notice(DraftOrderScreenEvent.StopSpeak) }
	}

	private fun stopRecordingRender(){
		order_draft_voice_input.setImageResource(R.drawable.ic_microphone)
		order_draft_voice_input.setOnClickListener { viewModel.notice(DraftOrderScreenEvent.StartSpeak) }
	}
}