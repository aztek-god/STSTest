package com.sdvstark.vintagemoviedb.util.abstraction

/**
 * Model which is part of tree hierarchy. It is used accordingly to TreeBuilder implementation.
 */

interface TreeModel {
    val parentTreeId: Int
    val treeId: Int
}
