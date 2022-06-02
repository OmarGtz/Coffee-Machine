class Block(val color: String) {

    object BlockProperties {
        var length: Int = 4
        var width: Int = 6

        fun blocksInBox(length: Int, width: Int): Int {
            return (length / this.length) * (width/this.width)
        }
    }

}
