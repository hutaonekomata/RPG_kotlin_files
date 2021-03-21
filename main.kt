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
    king.talk("よくぞ来てくれた、デビルマン吉澤")
    king.talk("え？、違う？、いやいや嘘を言っても無駄じゃよ、ブルガリアン坂本")
    king.talk("ほぇ？、これも違う？、")
    king.talk("済まないが今一度名前を名乗ってはもらえないか")

    //名前を入力させる
    print("プレイヤーの名前を入力してください : ")
    val player = readLine()?.let { Player(it) }

    king.talk("ああ！、そうそう、そうだそうだ、あーいやね、覚えてたよ？覚えてたんだけどいやそのｱﾉｴｯﾄ...")
    if (player != null) {
        king.talk("ゴッホン...では改めて、勇者${player.name}よ、")
    }
    king.talk("悪しき魔王を討ち、国に平和をもたらすのだ!!!")
}