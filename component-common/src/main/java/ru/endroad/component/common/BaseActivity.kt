package ru.endroad.component.common

import android.os.Bundle
import androidx.annotation.StyleRes
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

	abstract val layout: Int

	@StyleRes
	open val theme: Int? = null

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		theme?.let(::setTheme)
		setContentView(layout)

		savedInstanceState ?: onFirstCreate()
	}

	open fun onFirstCreate() = Unit
}