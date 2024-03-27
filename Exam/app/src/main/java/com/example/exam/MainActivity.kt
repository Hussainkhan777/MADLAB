package com.example.exam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.exam.ui.theme.ExamTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExamTheme {

                ActorsNavigation()

            }
        }
    }

}




@Composable
fun ActorsNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "actorslist") {
        composable("actorslist") {
            FriendsrFrontPage(navController)
        }
        composable(
            route = "actordetails/{actorId}",
            arguments = listOf(
                navArgument("actorId") {
                    type = androidx.navigation.NavType.IntType
                }
            )
        ) { backStackEntry ->
            val actorId = backStackEntry.arguments?.getInt("actorId")

            actorId?.let{
                FriendsSecondPage(navController, actorId)
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ExamTheme {

        ActorsNavigation()
    }
}