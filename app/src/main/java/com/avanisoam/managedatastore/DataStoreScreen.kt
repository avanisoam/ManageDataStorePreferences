package com.avanisoam.managedatastore

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Switch
import androidx.compose.material3.Button
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun DataStoreScreen(viewModel: DataStoreViewModel = viewModel()) {
    val booleanValue by viewModel.booleanValue.collectAsState()
    val intValue by viewModel.intValue.collectAsState()
    val longValue by viewModel.longValue.collectAsState()
    val floatValue by viewModel.floatValue.collectAsState()
    val stringValue by viewModel.stringValue.collectAsState()
    val doubleValue by viewModel.doubleValue.collectAsState()

    var booleanInput by remember { mutableStateOf(false) }
    var intInput by remember { mutableStateOf(0) }
    var longInput by remember { mutableStateOf(0L) }
    var floatInput by remember { mutableStateOf(0f) }
    var stringInput by remember { mutableStateOf("") }
    var doubleInput by remember { mutableStateOf(0.0) }


    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Stored Boolean Value: ${booleanValue ?: "No value"}")
        Spacer(modifier = Modifier.height(16.dp))

        Switch(
            checked = booleanInput,
            onCheckedChange = { booleanInput = it }
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { viewModel.saveBoolean(booleanInput) }) {
            Text("Save Boolean to DataStore")
        }

        Spacer(modifier = Modifier.height(16.dp))


        Text(text = "Stored String Value: ${stringValue ?: "No value"}")
        TextField(
            value = stringInput,
            onValueChange = { stringInput = it },
            label = { Text("Enter String") }
        )
        Button(onClick = { viewModel.saveString(stringInput) }) {
            Text("Save String to DataStore")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Stored Int Value: ${intValue ?: "No value"}")
        TextField(
            value = intInput.toString(),
            onValueChange = { intInput = it.toInt() },
            label = { Text("Enter Int") }
        )
        Button(onClick = { viewModel.saveInt(intInput) }) {
            Text("Save Int to DataStore")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Stored Long Value: ${longValue ?: "No value"}")
        TextField(
            value = longInput.toString(),
            onValueChange = { longInput = it.toLongOrNull() ?: 0L },
            label = { Text("Enter Long") }
        )
        Button(onClick = { viewModel.saveLong(longInput) }) {
            Text("Save Long to DataStore")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Stored Float Value: ${floatValue ?: "No value"}")
        Slider(
            value = floatInput,
            onValueChange = { floatInput = it },
            valueRange = 0f..100f
        )
        Button(onClick = { viewModel.saveFloat(floatInput) }) {
            Text("Save Float to DataStore")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Stored Double Value: ${doubleValue ?: "No value"}")
        TextField(
            value = doubleInput.toString(),
            onValueChange = { doubleInput = it.toDoubleOrNull() ?: 0.0 },
            label = { Text("Enter Double") }
        )
        Button(onClick = { viewModel.saveDouble(doubleInput) }) {
            Text("Save Double to DataStore")
        }
    }
}