package br.edu.ifsp.scl.sc3045153.soccerscore.ui.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.edu.ifsp.scl.sc3045153.soccerscore.Screen
import br.edu.ifsp.scl.sc3045153.soccerscore.ui.theme.SoccerScoreTheme

@Composable
fun MainScreen(navHostController: NavHostController, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var teamA by rememberSaveable { mutableStateOf("") }
        var teamAError by rememberSaveable { mutableStateOf<String?>(null) }
        var teamB by rememberSaveable { mutableStateOf("") }
        var teamBError by rememberSaveable { mutableStateOf<String?>(null) }

        var golsA by rememberSaveable { mutableStateOf("") }
        var golsAError by rememberSaveable { mutableStateOf<String?>(null) }
        var golsB by rememberSaveable { mutableStateOf("") }
        var golsBError by rememberSaveable { mutableStateOf<String?>(null) }

        Text(
            text = "Soccer Score Board",
            modifier = Modifier
                .wrapContentSize()
                .padding(5.dp),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        OutlinedTextField(
            value = teamA,
            onValueChange = { teamA = it },
            label = { Text("Time A") },
            isError = teamAError != null,
            supportingText = { teamAError?.let { Text(it) } },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )

        OutlinedTextField(
            value = teamB,
            onValueChange = { teamB = it },
            label = { Text("Time B") },
            isError = teamBError != null,
            supportingText = { teamBError?.let { Text(it) } },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )

        OutlinedTextField(
            value = golsA,
            onValueChange = { golsA = it },
            label = { Text("Gols A") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            isError = golsAError != null,
            supportingText = { golsAError?.let { Text(it) } },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )

        OutlinedTextField(
            value = golsB,
            onValueChange = { golsB = it },
            label = { Text("Gols B") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            isError = golsBError != null,
            supportingText = { golsBError?.let { Text(it) } },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )

        Button(onClick = {
            //Valida valores
            teamAError = validateTeamNames(teamA)
            teamBError = validateTeamNames(teamB)
            golsAError = validateTeamGols(golsA)
            golsBError = validateTeamGols(golsB)

            if (teamAError == null && teamBError == null && golsAError == null && golsBError == null) {
                // Passa para a próxima navigation os valores
                navHostController.navigate(Screen.Match.route
                        + "?teamA=${teamA}"
                        + "&teamB=${teamB}"
                        + "&golsA=${golsA.toInt()}"
                        + "&golsB=${golsB.toInt()}")
            }
        }) {
            Text(text = "Ver Resultado")
        }

    }
}

private fun validateTeamNames(team: String): String? {
    if (team.isBlank()) {
        return "Nome do time não pode estar vazio"
    }

    return null
}

private fun validateTeamGols(gols: String): String? {
    if (gols.isBlank()) {
        return "Gols não podem estar vazios"
    }

    val golsNumber = gols.toIntOrNull() ?: return "Gols devem ser um número inteiro"

    if (golsNumber < 0) {
        return "Gols não podem ser menores que 0"
    }

    return null
}

@Preview(showBackground = true)
@Composable
private fun MainPrev() {
    SoccerScoreTheme {
        MainScreen(navHostController = rememberNavController())
    }
}