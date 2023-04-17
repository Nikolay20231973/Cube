package com.example.dicenikolay1973

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dicenikolay1973.ui.theme.DiceNikolay1973Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceNikolay1973Theme {
                FunctionTwo()
            }
        }
    }
}

@Preview
@Composable
fun FunctionTwo() {
    FunctionOne(modifier = Modifier
        .fillMaxSize()
       )
}


@Composable
fun FunctionOne(modifier: Modifier = Modifier){
    Image(
        painter = painterResource(id = R.drawable.img_20220909_194655),
        modifier = Modifier.alpha(0.9f).padding(5.dp)
        , contentDescription = "kart5", contentScale = ContentScale.Crop)
    var sport1  by remember {
        mutableStateOf(1)
    }
    val sport2 = when(sport1) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(sport2),
            contentDescription = sport1.toString(),
            modifier = Modifier.padding(bottom = 56.dp, top = 200.dp) )
        Spacer(modifier = Modifier.height(6.dp))                         // отступ между кубиком и кнопкой
        Button(onClick = { sport1 =(1..6).random() }) {
            Text(text = "ЖМИ НАТАЛИ", fontSize = 23.sp)           // ТЕКСТ НА КНОПКЕ ЖМИ ( В ПАПКЕ VALUES -> STRIGS)


        }


    }

}

