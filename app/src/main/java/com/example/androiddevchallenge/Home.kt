package com.example.androiddevchallenge

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.data.Puppy
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch

@Composable
fun Home() {
    val snackBarHostState = SnackbarHostState()
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Puppy Finder") }
            )
        },
        snackbarHost = { SnackbarHost(snackBarHostState) }
    ) {
        val viewModel: MainViewModel = viewModel()
        val currentPuppy: Puppy? by viewModel.currentPuppy.observeAsState(null)
        if (currentPuppy == null) {
            PuppyList(puppyList = viewModel.getPuppyList(), onItemClick = {
                if (currentPuppy == null) {
                    viewModel.showPuppy(it)
                }
            })
        } else {
            currentPuppy?.let {
                PuppyDetail(puppy = it) {
                    coroutineScope.launch {
                        snackBarHostState.showSnackbar("You have adopted ${it.name}")
                    }
                }
            }
        }

    }
}