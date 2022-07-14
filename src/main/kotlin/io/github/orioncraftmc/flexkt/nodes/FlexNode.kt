package io.github.orioncraftmc.flexkt.nodes

data class FlexNode(
    val style: FlexStyle,
) {
    private val childrenNodes: MutableList<FlexNode> = mutableListOf()

    val children: List<FlexNode>
        get() = childrenNodes

    var parent: FlexNode? = null
        set(newParent) {
            // Remove from old parent
            field?.childrenNodes?.remove(this)
            // Add to new parent
            newParent?.childrenNodes?.add(this)
            // Set new parent
            field = newParent
        }

    fun addChild(child: FlexNode) {
        child.parent = this
    }
}
