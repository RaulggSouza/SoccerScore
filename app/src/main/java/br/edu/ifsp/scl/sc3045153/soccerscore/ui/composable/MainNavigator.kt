package br.edu.ifsp.scl.sc3045153.soccerscore.ui.composable

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.edu.ifsp.scl.sc3045153.soccerscore.Screen
import br.edu.ifsp.scl.sc3045153.soccerscore.ui.theme.SoccerScoreTheme

@Composable
fun MainNavigator(navHostController: NavHostController, modifier: Modifier) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Main.route
    ) {
        composable(route = Screen.Main.route) {
            MainScreen(navHostController, modifier)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainNavigationPreview() {
    SoccerScoreTheme {
        MainNavigator(
            navHostController = rememberNavController(),
            modifier = Modifier
        )
    }
}