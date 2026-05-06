package br.edu.ifsp.scl.sc3045153.soccerscore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import br.edu.ifsp.scl.sc3045153.soccerscore.ui.composable.MainNavigator
import br.edu.ifsp.scl.sc3045153.soccerscore.ui.theme.SoccerScoreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SoccerScoreTheme {
                val mainNavHostController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainNavigator(
                        navHostController = mainNavHostController,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}