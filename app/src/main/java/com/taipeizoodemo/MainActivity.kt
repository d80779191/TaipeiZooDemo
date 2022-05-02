package com.taipeizoodemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.lxj.xpopup.XPopup

const val AREA_DATA_TO_DETAIL = "AREA_DATA_TO_DETAIL"
const val AREA_DATA_TO_VEGETATION = "AREA_DATA_TO_VEGETATION"
const val MAIN_FRAGMENT_TAG = "fragment_main"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onBackPressed() {
        if (Navigation.findNavController(findViewById(R.id.nav_host_fragment)).currentDestination?.label == MAIN_FRAGMENT_TAG) {
            XPopup.Builder(this)
                .asConfirm(getString(R.string.dialog_confirm_title)
                    , getString(R.string.dialog_confirm_left)
                    , getString(R.string.dialog_cancel)
                    , getString(R.string.dialog_confirm)
                    , {
                        super.onBackPressed()
                    }, {}, false).show()
        } else {
            Navigation.findNavController(findViewById(R.id.nav_host_fragment)).popBackStack()
        }
    }
}