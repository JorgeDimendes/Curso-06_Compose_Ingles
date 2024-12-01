package com.jordev.calculadoragorjeta

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jordev.calculadoragorjeta.components.CaixaPreco
import com.jordev.calculadoragorjeta.ui.theme.COLORTEXT
import com.jordev.calculadoragorjeta.ui.theme.CalculadoraDeGorjetaTheme
import com.jordev.calculadoragorjeta.ui.theme.EDITCOLORS
import com.jordev.calculadoragorjeta.ui.theme.TOPTEXTCOLOR

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            CalculadoraDeGorjetaTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ){
                    Column (
                        //modifier = Modifier.padding(16.dp),

                    ){
                        TopHeader()
                        MainContent()
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun TopHeader(totalPerPerson: Double = 137.53){

    Surface (
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(20.dp),
            //.clip(shape = RoundedCornerShape(12.dp))
        shape = RoundedCornerShape(12.dp),
        color = TOPTEXTCOLOR

    ){
        Column (
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ){

            //Colocando 2 casas decimais no valor
            val total = "%.2f".format(totalPerPerson)

            Text(
                modifier = Modifier.padding(bottom = 10.dp),
                text = "Total por pessoa",
                style = MaterialTheme.typography.headlineSmall,
                //fontSize = 15.sp,
                color = COLORTEXT

            )

            Text(
                text = "R$ $total",
                style = MaterialTheme.typography.headlineLarge,
                //fontSize = 35.sp,
                color = COLORTEXT,
                fontWeight = FontWeight.Bold

            )


        }
    }
}



@Preview
@Composable
fun MainContent(){
    var totalBillState by remember { mutableStateOf("") }
    val validState = remember(totalBillState) {
        totalBillState.trim().isNotEmpty()
    }
    val keyboardController = LocalSoftwareKeyboardController.current

    Surface (

        modifier = Modifier
            .padding(10.dp, 0.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
        border = BorderStroke(width = 2.dp, color = Color.LightGray),
        color = Color.White

    ){

        Column (
            modifier = Modifier.padding(7.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start

        ){

            CaixaPreco(
                valueState = totalBillState,
                labelId = "Valor da conta 1",
                enabled = true,
                isSingleLine = true,
                onAction = KeyboardActions {
                    if (!validState) return@KeyboardActions
                    //TODO - onValueChange
                    keyboardController?.hide()
                },

                onValueChange = {
                    totalBillState = it
                },
                modifier = Modifier,
                maxLines = 1
            )


            /*OutlinedTextField(
                value = text,
                onValueChange = {
                    text = it
                },
                label = { Text("Valor da conta") },
                maxLines = 1,
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(),
                //keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = EDITCOLORS,
                    unfocusedBorderColor = EDITCOLORS,
                    cursorColor = EDITCOLORS,
                    focusedLabelColor = EDITCOLORS,
                    focusedTextColor = Color.Black
                ),
                leadingIcon = { Text("R$") }

            )*/

        }
    }
}


/*
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalculadoraDeGorjetaTheme {

    }
}*/
