package com.appserba0797.app.ui.news

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import com.appserba0797.app.R
import com.appserba0797.app.databinding.FragmentNewsBinding
import com.appserba0797.app.ui.home.MainActivity

class NewsFragment : Fragment() {
    private val parent: MainActivity by lazy { activity as MainActivity }
    private lateinit var binding: FragmentNewsBinding
    private val viewModel: NewsViewModel by lazy {NewsViewModel()}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsBinding.inflate(inflater, container, false).apply {
            viewModel = this@NewsFragment.viewModel
            lifecycleOwner = this@NewsFragment
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
        obseve()
    }

    private fun init() {
        binding.recyclerView.adapter = NewsAdapter(parent)
        viewModel.listNews()
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.listNews()
        }
    }

    private fun obseve() {
        viewModel.loading.observe(viewLifecycleOwner){
         binding.swipeRefresh.isRefreshing = it
        }

        viewModel.actionState.observe(viewLifecycleOwner){
            if (it.isConsumed){
                Log.i("ActionState", "isConsumed")
            } else if (!it.isSuccess){
                Toast.makeText(parent, it.message, Toast.LENGTH_SHORT).show()
            }
        }
    }


}