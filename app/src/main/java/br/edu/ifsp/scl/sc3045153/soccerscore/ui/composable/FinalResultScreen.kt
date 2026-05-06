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
fun FinalResultScreen(
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

    val resultMessage = getResultMessage(
        teamA = savedTeamA,
        teamB = savedTeamB,
        golsA = savedGolsA,
        golsB = savedGolsB
    )

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Resultado Final",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "$savedTeamA $savedGolsA x $savedGolsB $savedTeamB",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = resultMessage,
            fontSize = 22.sp
        )

        Button(
            onClick = {
                // Volta para a Tela 1 e remove as telas anteriores da pilha.
                navHostController.navigate(Screen.Main.route) {
                    popUpTo(Screen.Main.route) {
                        inclusive = true
                    }
                }
            }
        ) {
            Text(text = "Novo Jogo")
        }
    }
}

private fun getResultMessage(
    teamA: String,
    teamB: String,
    golsA: Int,
    golsB: Int
): String {
    return when {
        golsA > golsB -> "$teamA venceu!"
        golsB > golsA -> "$teamB venceu!"
        else -> "Empate emocionante!"
    }
}

@Preview(showBackground = true)
@Composable
private fun FinalResultScreenPreview() {
    SoccerScoreTheme {
        FinalResultScreen(
            navHostController = rememberNavController(),
            teamA = "Flamengo",
            teamB = "Fluminense",
            golsA = 2,
            golsB = 1
        )
    }
}