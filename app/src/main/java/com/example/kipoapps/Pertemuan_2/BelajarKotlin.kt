package com.example.kipoapps.Pertemuan_2

fun main() {
    println("Hai rekan rekan...")
    println("Selamat datang di bahasa pemograman kotlin")

    println("=============")

    var angka = 15
    println("Hasil dari 15 + 10 = ${angka + 10}")

    val nilaiInt = 10000
    val nilaiDouble = 100.003
    val nilaiFloat = 1000.0f

    println("Nilai Integer = $nilaiInt")
    println("Hasil Double = $nilaiDouble")
    println("Hasil Float = $nilaiFloat")

    println("========String========")
    var huruf = 'A'
    println("Ini penggunaan karakter '$huruf'")

    val nilaiString = "Mawar"
    println("Halo $nilaiString!\nApa Kabar?")

    println("======= Kondisi=======")

    val nilai = 10
    if(nilai<0)
        println("Bilangan negatif")
    else {
        if (nilai%2 == 0)
            println("Bilangan Genap")
        else
            println("Bilangan Ganjil")

    }

    println("======Perulangan=======")
    val kampusku: Array<String> = arrayOf("kampus", "Politeknik", "Caltex", "Riau")
    for (kampus: String in kampusku) {
        println(kampus)
    }
}