package com.jordev.calculadoragorjeta.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//@Preview(showBackground = true)
@Composable
fun CaixaPreco(
    modifier: Modifier = Modifier,
    valueState: String,
    onValueChange: (String) -> Unit,
    labelId: String,
    enabled: Boolean,
    isSingleLine: Boolean,
    keyboardType: KeyboardType = KeyboardType.Number,
    imeAction: ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default,
    maxLines: Int
){
    //var textId by remember{mutableStateOf("")}

    OutlinedTextField(
        value = valueState,
        //onValueChange = onValueChange,
        onValueChange = onValueChange,
        label = {Text(text = labelId)},
        leadingIcon = { Text("R$") },
        singleLine = isSingleLine,
        textStyle = LocalTextStyle.current.copy(fontSize = 18.sp, color = Color.Blue),
        modifier = modifier
            .padding(10.dp, 0.dp, 10.dp, 10.dp),
        enabled = enabled,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction),
        keyboardActions = onAction,
        maxLines = 1


    )

}

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

/*
fun CaixaTexto(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions
){

    OutlinedTextField(
        value,
        onValueChange,
        label = {
            Text(text = label)
        },
        colors = TextFieldDefaults.colors(
            focusedLabelColor = Teal700,
            cursorColor = Teal700,
            focusedIndicatorColor = Teal700,
            focusedContainerColor = WHITE,
            unfocusedContainerColor = WHITE

        ),
        modifier = modifier,
        keyboardOptions = keyboardOptions,
        maxLines = 1,


        )

}*/
