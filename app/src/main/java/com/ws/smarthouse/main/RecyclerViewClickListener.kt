package com.ws.smarthouse.main

import android.view.View

interface RecyclerViewClickListener {
    fun recyclerViewListClicked(v: View?, position: Int)
}