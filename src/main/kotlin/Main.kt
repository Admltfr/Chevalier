//const tidak dapat berada didalam method/fungsi hingga dideklarasikan diluarnya

const val pi = 3.14
enum class Direction {
    east,
    west,
    north,
    south
}
fun main() {
    //val name = "Kotlin"
    var name = "Kotlin"
    name = "Java"
    var i = 0
    //keyword val, nama variabel
    //tipe data val tidak bisa diassign ulang sedangkan var bisa
    //val termasuk tipe dinamis

    println(pi)
    println(name)

//    if (name == "Java") {
//        name = "Kotlin"
//    } else {
//        name = "Java Bukan Kotlin"
//    }
//    println(name)

    //versi lain dari if di kotlin adalah when

    when (name) {
        "Java" -> println("Kotlin Bukan Java")
        "Kotlin" -> println("Java Bukan Kotlin")
        else -> println("Salah")
    }
//when ibaratnya sebagai switch case di bahasa lain
    //jangan pakai when jika operatornya seperti > atai < karena pasti dia ditulis 1 1 angkanya
    //1 -> nama
    //2 -> nama
    //... -> nama
    //WHEN LEBIH CEPAT DARI IF
    //karena when sendiri dia langsung search nilainya
    //sedangkan if di tes 1 1
    for (i in 1..2){
        println("Kotlin")
    }
    //PELAJARI FOREACH
    //enum
    val direction_var = Direction.east
    //enum dideklarasikan diluar method
    //enum merupakan suatu set atribut yang tidak bisa diubah lagi
    when (direction_var) {
        Direction.east -> println("Timur")
        Direction.west -> println("Barat")
        Direction.north -> println("Utara")
        Direction.south -> println("Selatan")
        else -> println("Gak kemana mana")
    }

    //lambda function
    //atau anonymous function
    val x = 10
    val y = 10
    val hasil = process(x) {
        x -> {y*2}
    }
    println(hasil)


}

//fun process(a:Int, lambda: (a:Int) -> Int) : Int {
//    return a * lambda(a)
//}

//fun process(a:Int, kalidua2 : (a:Int) -> Int) : Int {
//    return a * kalidua2(a)
//}

fun process(a:Int, kalidua2 : (a:Int) -> (a:Int) -> Int) : Int {
    return a * kalidua2(a)(a)
}


//nama nim jurusan
//buat proyek misalnya kalkulator
//untuk ubah integer ke string tingal .tostring
//jika misal string ke integer .toint
//lambda bisa berbagai nama contohnya kalidua

//contoh lambda yaitu onclick
//fun main() {
//    button("text") {
//        tampilkatalog = true
//    }
//}