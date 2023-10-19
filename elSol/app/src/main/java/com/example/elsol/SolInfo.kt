package com.example.elsol

data class SolInfo(val imageId: Int, val name: String) {
}

fun getSol() : MutableList<SolInfo> {
    return mutableListOf(
        SolInfo(R.drawable.corona_solar, "Corona solar"),
        SolInfo(R.drawable.erupcionsolar, "Erupción solar"),
        SolInfo(R.drawable.espiculas, "Espiculas"),
        SolInfo(R.drawable.filamentos, "Filamentos"),
        SolInfo(R.drawable.magnetosfera, "Magnetosfera"),
        SolInfo(R.drawable.manchasolar, "Mancha solar"),
    )
}
