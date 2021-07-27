package com.example.hedgehog.ui.main

import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.activityViewModels
import com.example.hedgehog.databinding.FragmentWebBinding
import com.example.hedgehog.databinding.MainFragmentBinding


class WebFragment : Fragment() {

    private var _binding: FragmentWebBinding? = null
    private val binding get() = _binding!!
    private val model: MainViewModel by activityViewModels()
    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

    override fun onPause() {
        super.onPause()
        binding.webView.saveState(model.webState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWebBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model.updateActionBar("Api info")
        binding.webView.webViewClient=SimpleWebClient()
        if (model.webState.isEmpty){
            binding.webView.loadUrl("https://www.icndb.com/api/")
        }
        else
            binding.webView.restoreState(model.webState)
    }

    fun onKeyDown():Boolean{
        return if ( binding.webView.canGoBack()){
            binding.webView.goBack()
            true
        } else
            false
    }

}
private class SimpleWebClient: WebViewClient() {
    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        return false
    }
}