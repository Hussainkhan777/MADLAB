package com.example.exam

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FriendsrFrontPage(navController: NavController) {

    val title = stringResource(id = R.string.title)
    val cityName= remember {
        mutableStateOf("")
    }

    val intro = stringResource(id = R.string.intro)

    val actorsList = RetrieveActorsData()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Select City")
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.LightGray,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White,
                    actionIconContentColor = Color.White
                )
            )
        },
        bottomBar = {
            Icon(Icons.Filled.Favorite, contentDescription ="favourite" )
        }
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(painter = painterResource(id = R.drawable.logo), contentDescription = "")
            Spacer(modifier = Modifier.size(30.dp))
            Image(painter = painterResource(id = R.drawable.map), contentDescription = "")
            Spacer(modifier = Modifier.size(20.dp))
            TextField(value = cityName.value, onValueChange = {cityName.value=it})
            Spacer(modifier = Modifier.size(30.dp))
            Button( onClick = {
                navController.navigate("actordetails/${cityName.value}")
            } ) {

            }




            Text(
                text = title,
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .alpha(0.6f)
                    .padding(bottom = 10.dp),
            )

            Text(
                text = intro,
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier
                    .alpha(0.6f)
                    .padding(10.dp),
                textAlign = TextAlign.Center
            )

//            LazyVerticalGrid(
//                columns = GridCells.Adaptive(150.dp),
//                modifier = Modifier.padding(40.dp, 0.dp),
//                content = {
//                    items(
//                        count = actorsList.count(),
//                        itemContent = { index ->
//                            val actor = actorsList[index]
//
//                            Column(
//                                verticalArrangement = Arrangement.Center,
//                                horizontalAlignment = Alignment.CenterHorizontally
//                            ) {
//
//                                Card(
//                                    onClick = {
//                                        navController.navigate("actordetails/${index}")
//                                    },
//                                    modifier = Modifier.padding(10.dp),
//                                    shape = RoundedCornerShape(0)
//                                ) {
//                                    Image(
//                                        painter = painterResource(id = actor.image_Preview),
//                                        contentDescription = null,
//                                        modifier = Modifier
//                                            .padding(10.dp)
//                                            .fillMaxSize(),
//                                        contentScale = ContentScale.Crop
//                                    )
//
//                                }
//                                Text(
//                                    text = actor.name,
//                                    fontSize = 16.sp,
//                                    textAlign = TextAlign.Center,
//
//                                    )
//                            }
//                        }
//                    )
//                }
//            )
        }
    }
}