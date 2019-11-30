package com.sdvstark.vintagemoviedb.util.impl

import com.sdvstark.vintagemoviedb.util.abstraction.tree.TreeBuilder
import com.sdvstark.vintagemoviedb.util.abstraction.tree.TreeModel

class MapTreeModelBuilder<T : TreeModel>(private val mTreeModelList: List<T>) :
    TreeBuilder<T> {

    private val mTreeModelMap: Map<Int, List<T>> by lazy {
        mTreeModelList.groupBy {
            it.parentTreeId
        }
    }

    override fun getChildren(model: T): List<T> {
        return mTreeModelMap[model.treeId] ?: emptyList()
    }

    override fun getParent(model: T): T? {
        return mTreeModelList.find { it.treeId == model.parentTreeId }
    }
}