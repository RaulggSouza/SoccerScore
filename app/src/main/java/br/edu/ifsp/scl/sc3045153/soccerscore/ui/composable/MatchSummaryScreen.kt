package br.edu.ifsp.scl.sc3045153.soccerscore.ui.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.edu.ifsp.scl.sc3045153.soccerscore.Screen
import br.edu.ifsp.scl.sc3045153.soccerscore.ui.theme.SoccerScoreTheme

@Composable
fun MatchSummaryScreen(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
    teamA: String,
    teamB: String,
    golsA: Int,
    golsB: Int
) {
    // Mantém os dados preservados em caso de rotação de tela.
    val savedTeamA = rememberSaveable { teamA }
    val savedTeamB = rememberSaveable { teamB }
    val savedGolsA = rememberSaveable { golsA }
    val savedGolsB = rememberSaveable { golsB }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Resumo da Partida",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Time A: $savedTeamA",
            fontSize = 20.sp
        )

        Text(
            text = "Time B: $savedTeamB",
            fontSize = 20.sp
        )

        Text(
            text = "Placar: $savedGolsA x $savedGolsB",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Button(
            onClick = {
                navHostController.navigate(
                    Screen.Result.route
                            + "?teamA=${teamA}"
                            + "&teamB=${teamB}"
                            + "&golsA=${golsA}"
                            + "&golsB=${golsB}"
                )
            }
        ) {
            Text(text = "Confirmar Resultado")
        }

        Button(
            onClick = {
                // Retorna para a Tela 1.
                navHostController.popBackStack()
            }
        ) {
            Text(text = "Editar")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MatchSummaryScreenPreview() {
    SoccerScoreTheme {
        MatchSummaryScreen(
            navHostController = rememberNavController(),
            teamA = "Flamengo",
            teamB = "Fluminense",
            golsA = 2,
            golsB = 1
        )
    }
}