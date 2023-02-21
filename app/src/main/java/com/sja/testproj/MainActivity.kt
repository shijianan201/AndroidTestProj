package com.sja.testproj

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.sja.testproj.base.BaseRecyclerAdapter
import com.sja.testproj.base.BaseVBActivity
import com.sja.testproj.databinding.ActivityMainBinding
import com.sja.testproj.databinding.ItemMainFunctionBinding
import com.sja.testproj.viewmodel.SharedVMActivityOne

class MainActivity : BaseVBActivity<ActivityMainBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewBinding.rv.run {
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(DividerItemDecoration(this@MainActivity,DividerItemDecoration.VERTICAL))
            adapter = FunctionAdapter(
                arrayListOf(
                    Function("Activity共享ViewModel", SharedVMActivityOne::class.java)
                )
            )
        }
    }

    override fun createViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    inner class FunctionAdapter(dataList: List<Function>) :
        BaseRecyclerAdapter<Function, FunctionAdapter.FunctionViewHolder>(dataList) {

        inner class FunctionViewHolder(viewBinding: ItemMainFunctionBinding) :
            BaseViewBindingViewHolder<Function,ItemMainFunctionBinding>(
                viewBinding
            ) {
            override fun bindData(position: Int, data: Function) {
                viewBinding.tvName.run {
                    text = data.name
                }
                viewBinding.root.setOnClickListener {
                    startActivity(Intent(this@MainActivity,data.pageClass))
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FunctionViewHolder {
            return FunctionViewHolder(
                ItemMainFunctionBinding.bind(
                    ItemMainFunctionBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ).root
                )
            )
        }

    }
}

class Function(
    val name: String,
    val pageClass: Class<out Activity>? = null
)