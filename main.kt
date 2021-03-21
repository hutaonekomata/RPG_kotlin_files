//登場キャラクターを予めキャラクタクラスのインスタンスとして宣言しておく
val king = Character("王様的な人")
val first = Map(1)

fun main() {
    startingGame()
    first._mapStart()
    for (i in 1..5) {
        first.process()
    }
}

fun startingGame() {
    king.talk("よくぞ来てくれた、勇者、、、")
    king.talk("ええと、名前を何と言ったか、、")
    king.talk("済まないが今一度名前を名乗ってはもらえないか")

    //名前を入力させる
    print("プレイヤーの名前を入力してください : ")
    val player = readLine()?.let { Player(it) }

    king.talk("おお！、そうであったそうであった、いや覚えておったよ？ただちょっと今あのその...")
    if (player != null) {
        king.talk("ゴッホン...では改めて、勇者${player.name}よ、")
    }
    king.talk("悪しき魔王を討ち、国に平和をもたらすのだ!!!")
}