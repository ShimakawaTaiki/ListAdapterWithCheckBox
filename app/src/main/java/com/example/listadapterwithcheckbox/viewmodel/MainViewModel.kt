package com.example.listadapterwithcheckbox.viewmodel

import android.widget.CheckBox
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.distinctUntilChanged
import com.example.listadapterwithcheckbox.model.data.Prefecture

class MainViewModel: ViewModel() {
    private val dataList =
        listOf(
            "北海道","青森県","岩手県","宮城県","秋田県","山形県","福島県",
            "茨城県","栃木県","群馬県","埼玉県","千葉県","東京都","神奈川県",
            "新潟県","富山県","石川県","福井県","山梨県","長野県","岐阜県",
            "静岡県","愛知県","三重県","滋賀県","京都府","大阪府","兵庫県",
            "奈良県","和歌山県","鳥取県","島根県","岡山県","広島県","山口県",
            "徳島県","香川県","愛媛県","高知県","福岡県","佐賀県","長崎県",
            "熊本県","大分県","宮崎県","鹿児島県","沖縄県"
        )

    private val list = dataList.map { Prefecture(it) }

    private val _prefectures = MutableLiveData(list)
    val prefectures = _prefectures.distinctUntilChanged()

    val selectItem = mutableListOf<String>()

    private val _click = MutableLiveData("Clicked!!")
    val click = _click as LiveData<String>

    fun onClickItem(prefecture: Prefecture) {
        prefecture.isChecked.value?.let {
            prefecture.isChecked.value = it
        }
    }

    fun onClickButton() {
        selectItem.clear()
        list.forEach {
            it.isChecked.value?.let { isChecked ->
                if (isChecked) {
                    selectItem.add(it.name)
                }
            }
        }
        _click.value = "Clicked!!"
    }
}