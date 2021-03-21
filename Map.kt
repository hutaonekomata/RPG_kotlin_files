import java.util.*

val scanner = Scanner(System.`in`)

class Map(_number: Int) {
    private val number = _number //マップの番号（解放順）
    var steps = 0
    var openedNextMap = false
    var toOpenNextMap = false
    var choiceMax = 3   //次のマップへ行けるようになったら４にする

    //マップ開始時のメッセージ表示
    fun _mapStart() {
        fieldLog("~~~~ フィールド${this.number} ~~~~")
    }

    //フィールド内行動カウンタ（this.steps) をプラスする & コマンド操作を求める
    fun process() {
        this.steps ++
        this.printChoices()
        this.waitInput()
    }

    //マップ上での選択肢の入力を待つ
    private fun waitInput() {
        print("コマンド（数値）を入力して下さい : ")
        //複数の入力があった場合に、適切に対応する
        val input: Int = scanner.nextInt()

        //入力の失敗処理
        if (!checkInt(input)) {
            println("入力値に誤りがあるか、無効な入力です")
            this.waitInput()
        }

        //処理の選択
        when(input) {
            1 -> {
                //前へ進む処理
                eventGoForward((0..6).random())
            }

            2 -> {
                //アイテムを使う処理
            }

            3 -> {
                //踊る（ネタ）処理
            }

            4 -> {
                //次のマップへ移動する処理
            }
        }
    }

    private fun fieldLog(message: String) {
        println(message)
        Thread.sleep(2500)
    }

    //マップ上での選択肢を表示
    private fun printChoices() {
        println("1.前へ進む")
        println("2.アイテムを使う")
        println("3.踊る")
        if (this.openedNextMap) {
            this.fieldLog("4.次のマップへ移動する")
        }
    }

    //「前へ進む」により呼び出されるイベント
    private fun eventGoForward(number: Int) {
        when (number) {
            0 -> {
                //味方の回復
                fieldLog("行動パターン$number")
            }

            1 -> {
                //味方にダメージ
                fieldLog("行動パターン$number")
            }

            2 -> {
                //アイテム
                fieldLog("行動パターン$number")
            }

            3 -> {
                //敵と遭遇
                fieldLog("行動パターン$number")
            }

            4, 5, 6 -> {
                //特になにもない
                fieldLog("行動パターン$number")
            }
        }
    }

    private fun checkInt(x: Any): Boolean {
        return when (x) {
            is Int -> true
            else -> false
        }
    }
}

