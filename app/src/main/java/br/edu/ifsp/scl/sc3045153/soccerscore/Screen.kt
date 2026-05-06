package br.edu.ifsp.scl.sc3045153.soccerscore

sealed class Screen(val route: String) {
    object Main: Screen("main_screen")
    object Match: Screen("match_screen")
    object Result: Screen("result_screen")
}