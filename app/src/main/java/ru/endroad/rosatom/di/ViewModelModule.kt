package ru.endroad.rosatom.di

import org.koin.androidx.viewmodel.dsl.setIsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.definition.BeanDefinition
import org.koin.core.module.Module
import org.koin.dsl.module
import org.koin.experimental.builder.create
import ru.endroad.rosatom.view.detail.DetailOrderViewModel
import ru.endroad.rosatom.view.monitoring.MonitoringViewModel
import ru.endroad.rosatom.view.order.DraftOrderViewModel
import ru.endroad.rosatom.view.order.ListOrderViewModel
import ru.endroad.rosatom.view.order.SpectatorOrderViewModel
import ru.endroad.rosatom.view.profile.ProfileViewModel

val viewModelModule = module {
	viewModel<ProfileViewModel>()
	viewModel<MonitoringViewModel>()
	viewModel<DraftOrderViewModel>()
	viewModel<ListOrderViewModel>()
	viewModel<SpectatorOrderViewModel>()
	viewModel { (id: Long) -> DetailOrderViewModel(id, get()) }
}

private inline fun <reified T : Any> Module.viewModel(): BeanDefinition<T> {
	return factory(null, false) { create<T>() }.apply { setIsViewModel() }
}