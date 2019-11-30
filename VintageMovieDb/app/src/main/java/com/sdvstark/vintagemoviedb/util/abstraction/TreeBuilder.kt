package com.sdvstark.vintagemoviedb.util.abstraction

/**
 * This interface interacts with TreeModel model classes with help to build
 * tree hierarchy without using any additional fields only by marking models with
 * TreeModel interface.
 */

interface TreeBuilder<T : TreeModel> {
    fun getChildren(model: T): List<T>

    fun getParent(model: T): T?
}