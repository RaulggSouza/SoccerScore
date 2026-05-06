package br.edu.ifsp.scl.sc3045153.soccerscore.ui.composable

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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

        composable(
            route = Screen.Match.route + "?teamA={teamA}&teamB={teamB}&golsA={golsA}&golsB={golsB}",
            arguments = listOf(
                navArgument(name = "teamA") {
                    type = NavType.StringType
                    nullable = false
                },

                navArgument(name = "teamB") {
                    type = NavType.StringType
                    nullable = false
                },

                navArgument(name = "golsA") {
                    type = NavType.IntType
                    nullable = false
                },

                navArgument(name = "golsB") {
                    type = NavType.IntType
                    nullable = false
                }
            )
        ) {
            MatchSummaryScreen(
                navHostController,
                modifier,
                teamA = it.arguments?.getString("teamA")?:"",
                teamB = it.arguments?.getString("teamB")?:"",
                golsA = it.arguments?.getInt("golsA")?:0,
                golsB = it.arguments?.getInt("golsB")?:0
            )
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