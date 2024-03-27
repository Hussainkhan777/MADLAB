package com.example.exam

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.res.stringArrayResource
import com.example.lab_03.ActorDataClass

@Composable
fun RetrieveActorsData(): SnapshotStateList<ActorDataClass> {

    val actors = stringArrayResource(id = R.array.city_names)
    val actors_details = stringArrayResource(id = R.array.Temprature)
    val Humidity = stringArrayResource(id = R.array.Humidity)
    val Condition = stringArrayResource(id = R.array.Condition)


    val actorsModalList = remember {

        mutableStateListOf<ActorDataClass>(
            ActorDataClass(
                1,
                actors[0],
                0,
                actors_details[0],
            ),
            ActorDataClass(
                2,
                actors[1],
                0,
                actors_details[1],
            ),
            ActorDataClass(
                3,
                actors[2],
                0,
                actors_details[2],
            ),
            ActorDataClass(
                4,
                actors[3],
                0,
                actors_details[3],
            ),
            ActorDataClass(
                5,
                actors[4],
                0,
                actors_details[4],
            ),
            ActorDataClass(
                6,
                actors[5],
                0,
                actors_details[5],
            )

        )
    }

    return actorsModalList
}