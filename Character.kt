open class Character(_name: String) {
    open val name = _name
    var lvl = 1
    var atk = 5
    var def = 5
    var hp = 10
    var life = true

    fun test() {
        println("ようこそ ${this.name} さん")
    }

    fun talk(message: String) {
        println("${this.name} 「${message}」")
        Thread.sleep(2500)
    }

    open fun isAtk(acAtk: Int) {
        this.hp -= (acAtk - acAtk / this.def)
        if (this.hp <= 0) {
            this.life = false
        }
    }
}