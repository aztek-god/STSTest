package com.sdvstark.vintagemoviedb

import com.sdvstark.vintagemoviedb.util.abstraction.tree.TreeModel
import com.sdvstark.vintagemoviedb.util.impl.MapTreeModelBuilder
import org.junit.Test

class TreeBuilderTest {

    @Test
    fun testTreeBuilder() {
        val builder = MapTreeModelBuilder(testData)

        val children: List<TestTreeModel> = builder.getChildren(testData[0])
        println(children)

        val parent: TestTreeModel? = builder.getParent(testData[1])
        println(parent)

        val parentNull: TestTreeModel? = builder.getParent(testData[0])
        println(parentNull)
    }

    data class TestTreeModel(
        val name: String,
        override val treeId: Int,
        override val parentTreeId: Int
        ): TreeModel

    private val testData = listOf(
        TestTreeModel("root", 1, -1),
        TestTreeModel("a", 2, 1),
        TestTreeModel("b", 3, 1),
        TestTreeModel("c", 4, 3),
        TestTreeModel("d", 5, 3)
    )
}