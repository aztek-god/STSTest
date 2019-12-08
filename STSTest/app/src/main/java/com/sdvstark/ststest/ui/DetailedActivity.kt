package com.sdvstark.ststest.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sdvstark.ststest.R
import com.sdvstark.ststest.abstraction.EntityInfoModel
import kotlinx.android.synthetic.main.activity_detailed.*
import java.io.Serializable

class DetailedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)

        (intent.getSerializableExtra(ARGUMENT_NAME) as? EntityInfoModel)?.let {
            detailedInfoTv.text = it.detailedDescription
        }
    }


    companion object {
        fun startActivity(context: Context, model: Serializable) {
            context.startActivity(
                Intent(
                    context,
                    DetailedActivity::class.java
                ).apply {
                    putExtra(ARGUMENT_NAME, model)
                }
            )
        }

        private const val ARGUMENT_NAME = "argument"
    }
}
