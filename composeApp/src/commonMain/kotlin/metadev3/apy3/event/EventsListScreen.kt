package metadev3.apy3.event

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

data class NFTEvent(val id: String, val name: String, val date: String)

@Composable
fun EventsListScreen(navController: NavController) {
    val events = remember {
        listOf(
            NFTEvent("1", "Crypto Conference 2024", "2024-03-15"),
            NFTEvent("2", "Blockchain Summit", "2024-04-22"),
            NFTEvent("3", "NFT Art Exhibition", "2024-05-10")
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("My NFT Events") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("qr-scanner") },
                shape = CircleShape,
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(
                    imageVector = Icons.Filled.AddCircle,
                    contentDescription = "Scan QR Code"
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(events) { event ->
                EventItem(event) {
                    navController.navigate("metadata/${event.id}")
                }
            }
        }
    }
}

@Composable
fun EventItem(event: NFTEvent, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick),
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = event.name, style = MaterialTheme.typography.h6)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Date: ${event.date}", style = MaterialTheme.typography.body2)
        }
    }
}