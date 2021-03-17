class Map(_number: Int) {
    private val number = _number //マップの番号（解放順）
    var steps = 0
    var openedNextMap = false
    var toOpenNextMap = false
    var choiceMax = 3

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
        val input = readLine()!!.split(" ").map(String::toInt)
        //.split
        // => 入力された文字列を””で囲んだ文字に応じて分割する関数
        //.map
        // => 配列処理。各要素一つずつに対して「コールバック関数」を実行し、その結果を新しい配列として返すことができるようになっている。
        // => => 「コールバック関数」＝　

        //入力の失敗処理
        if (input[0] > this.choiceMax) {
            println("入力値に誤りがあるか、無効な入力です")
            this.waitInput()
        }

        //処理の選択
        when(input[0]) {
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
                println("")
            }

            3 -> {
                //敵と遭遇
                fieldLog("行動パターン$number")
                println("Encount Battle!!")
            }

            4, 5, 6 -> {
                //特になにもない
                fieldLog("行動パターン$number")
                println("特に何も起こらなかった。")
            }
        }
    }
}