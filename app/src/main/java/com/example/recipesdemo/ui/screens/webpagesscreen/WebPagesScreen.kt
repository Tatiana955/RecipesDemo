package com.example.recipesdemo.ui.screens.webpagesscreen

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun WebPagesScreen(
    id: String?,
    viewModel: WebPagesViewModel = hiltViewModel()
) {
    viewModel.dataPrKey.value = id!!
    viewModel.getSourceUrl()
    val url by remember { viewModel.dataUrl }
    OpenWeb(url)
}

@Composable
private fun OpenWeb(
    url: String
) {
    AndroidView(factory = {
        WebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            webViewClient = WebViewClient()
            loadUrl(url)
        }
    })
}