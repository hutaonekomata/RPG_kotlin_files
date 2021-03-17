class Player(_name: String): Character(_name) {
    override val name: String = _name
    var expNow: Int = 0
    var expToNxt: Int = 5

    fun getExp(exp: Int) {
        //所持している経験値をプラスする
        this.expNow += exp

        //次のレベルまでの経験値を減らす
        this.expToNxt -= exp

        //次のレベルまでの経験値よりも所持している経験値が多い間、レベルを上げ続ける
        if (expNow > expToNxt) {
            this.levelUp()
        }
    }

    private fun levelUp() {
        expNow -= expToNxt
        this.lvl ++
        expToNxt += expToNxt / 4
        if (expNow > expToNxt) {
            this.levelUp()
        }
    }
}
//this. => 自分自身を呼び出す。