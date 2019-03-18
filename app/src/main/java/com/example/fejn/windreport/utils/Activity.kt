package com.example.fejn.windreport.utils

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.example.fejn.windreport.R

fun Activity.inflateView(@LayoutRes resource: Int, viewGroup: View, attachToRoot : Boolean = false): View =
    layoutInflater.inflate(resource, viewGroup.parent as ViewGroup, attachToRoot)

fun Activity.blackLoading(): View {
    val view  = this.inflateView(R.layout.loading,this.findViewById<ViewGroup>(android.R.id.content))
    return view
}